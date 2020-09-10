package com.hisoft.papermanager.controller;

import com.alibaba.fastjson.JSONArray;
import com.hisoft.papermanager.pojo.Code;
import com.hisoft.papermanager.pojo.Paper;
import com.hisoft.papermanager.pojo.User;
import com.hisoft.papermanager.service.paper.PaperService;
import com.hisoft.papermanager.util.Constants;
import com.hisoft.papermanager.util.PageSupport;
import com.mysql.jdbc.StringUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @program: MyProject
 * @description:
 * @author: dyj
 * @create: 2020-09-09 10:24:34
 **/
@Controller
@Transactional
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    PaperService paperService;

    @RequestMapping("/getPaperList")
    public String getPaperList(@RequestParam(value = "title", defaultValue = "") String title,
                               @RequestParam(value = "type", defaultValue = "0") Integer type,
                               @RequestParam(value = "pageIndex", defaultValue = "1") Integer currentPageNo,
                               Model model){
        //设置页面容量
        int pageSize = Constants.pageSize;

        //总数量（表）
        int totalCount =paperService.getPaperCount(title,type);
        //总页数
        PageSupport pages = new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);

        int totalPageCount = pages.getTotalPageCount();
        //控制首页和尾页
        if (currentPageNo < 1) {
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }

        List<Paper> paperList = null;
        paperList = paperService.getPaperList(title, type, currentPageNo, pageSize);

        List<Code> codeList = paperService.getCodeList();
        List<String> codeNameList = null;
      /*  for (Code code : codeList) {
            String name  = code.getCodeName();
            if (!codeNameList.contains(name)){
                codeNameList.add(name);
            }
        }*/
        model.addAttribute("paperList", paperList);
        model.addAttribute("codeList", codeList);
        model.addAttribute("codeNameList", codeNameList);
        model.addAttribute("title", title);
        model.addAttribute("type", type);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currentPageNo", currentPageNo);
        return "paperlist";
    }

    @RequestMapping(value = "toadd", method = {RequestMethod.GET, RequestMethod.POST})
    public String toadd(@ModelAttribute("paper") Paper paper){
        return "paperadd";
    }
    @RequestMapping(value = "/add",method = {RequestMethod.GET, RequestMethod.POST})
    public String add(HttpSession session, Model model,
                      @RequestParam(value="paperPath1",required=false) MultipartFile multipartFile,
                      @ModelAttribute("paper") @Validated Paper paper,BindingResult result){
       /* Paper paper = new Paper();*/

        if (result.hasErrors()){
            return "paperadd";
        }
        String savepath = null;
        String idFileName = null;
        //获取文件原名和大小
        if (!multipartFile.isEmpty()){
            String oldName= multipartFile.getOriginalFilename();
            String ext = FilenameUtils.getExtension(oldName);
            Long size = multipartFile.getSize();
            if (size > 500*1024){
                model.addAttribute("idPicPathError","上传的文件不能超过500kb");
                return "paperadd";
            }else {
                String[] types={"doc","docx","ppt","exel"};
                if (!Arrays.asList(types).contains(ext)){
                    model.addAttribute("idPicPathError","上传文件类型错误，doc,docx,exel格式的文件");
                    return "paperadd";
                }else {
                    //正式上传
                    String targetPath = session.getServletContext().getRealPath("statics"+ File.separator+"upload");
                    idFileName = System.currentTimeMillis()+RandomUtils.nextInt(100000)+"_Personal."+ext;
                    File saveFile = new File(targetPath,idFileName);
                    if (!saveFile.exists()){
                        saveFile.mkdirs();
                    }
                    try {
                        multipartFile.transferTo(saveFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                        model.addAttribute("idPicPathError","上传失败，请联系管理员");
                        return "paperadd";
                    }
                    savepath = targetPath+File.separator+idFileName;
                }

            }

        }

        paper.setCreationDate(new Date());
        paper.setCreatedBy(((User)session.getAttribute(Constants.USER_SESSION)).getId().toString());
        paper.setPaperPath(savepath);
        boolean add = paperService.add(paper);
        if(add){
            return "redirect:/paper/getPaperList";
        }else{
            return "paperadd";
        }
}


    @RequestMapping("/tomodify")
    public String tomodify(Model model,
                           @RequestParam(value = "id") Integer id){
        if(id != null) {
            Paper paper = paperService.getPaperById(id);
            model.addAttribute("paper", paper);
            return "papermodify";
        }else{
            throw new RuntimeException("论文不存在");
        }

    }

    @RequestMapping("/modify")
    public String modify(@ModelAttribute("paper") Paper paper,HttpSession session,Model model){

        paper.setModifyBy(((User)session.getAttribute(Constants.USER_SESSION)).getUserName());

        paper.setModifyDate(new Date());

        boolean modify = paperService.modify(paper);
        if(modify){
            return "redirect:/paper/getPaperList";
        }else{
            return "papermodify";
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam(value = "id",defaultValue = "0")Integer id){
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(id <= 0){
            resultMap.put("delResult", "notexist");
        }else{
            if(paperService.delelte(id)){
                resultMap.put("delResult", "true");
            }else{
                resultMap.put("delResult", "false");
            }
        }
        return JSONArray.toJSONString(resultMap);
    }

    @RequestMapping("/titleexist")
    @ResponseBody
    public String titleexist(@RequestParam("title")String title){
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(StringUtils.isNullOrEmpty(title)){
            //userCode == null || userCode.equals("")
            resultMap.put("userCode", "exist");
        }
        else{
            Paper paper = paperService.getPaperByTitle(title);
            if(null != paper){
                resultMap.put("userCode","exist");
            }else{
                resultMap.put("userCode", "notexist");
            }
        }

        return JSONArray.toJSONString(resultMap);

    }

}

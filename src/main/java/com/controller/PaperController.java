package com.controller;

import com.pojo.Paper;
import com.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 控制层：接收Web请求，并转到业务层处理
 */
@Controller
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    private PaperService paperService;

    @RequestMapping("/allPaper")
    public String list(Model model) {
        List<Paper> list = paperService.queryAllPaper();
        // 将结果保存到键名为list的键值对中
        // 前端JSP中可通过${requestScope.get("list")}或者${requestScope.list}或者直接使用${list}得到结果
        model.addAttribute("list", list);
        // return的字符串表示视图JSP文件名字
        return "allPaper";
    }

    @RequestMapping("/toAddPaper")
    public String toAddPaper() {
        // return的字符串表示视图JSP文件名字
        return "addPaper";
    }

    @RequestMapping("/addPaper")
    public String addPaper(Paper paper) {
        paperService.addPaper(paper);
        // 重定向发送/allPaper请求
        return "redirect:/paper/allPaper";
    }

    @RequestMapping("/del/{paperId}")
    public String deletePaper(@PathVariable("paperId") Long id) {
        paperService.deletePaperById(id);
        // 重定向发送/allPaper请求
        return "redirect:/paper/allPaper";
    }

    @RequestMapping("/toUpdatePaper")
    public String toUpdatePaper(Model model, Long id) {
        // 先根据id找到要修改的Paper对象，以方便updatePaper页面显示初始值
        model.addAttribute("paper", paperService.queryById(id));
        // return的字符串表示视图JSP文件名字
        return "updatePaper";
    }

    @RequestMapping("/updatePaper")
    public String updatePaper(Model model, Paper paper) {
        paperService.updatePaper(paper);
        // 重定向发送/allPaper请求
        return "redirect:/paper/allPaper";
    }

}

package com.njq.yxl.controller;

import com.njq.common.model.po.BaseUser;
import com.njq.common.model.po.YxlDoc;
import com.njq.common.model.po.YxlDocSearch;
import com.njq.common.model.po.YxlFolder;
import com.njq.common.model.po.YxlTip;
import com.njq.common.model.po.YxlType;
import com.njq.yxl.service.YxlDocSearchService;
import com.njq.yxl.service.YxlDocService;
import com.njq.yxl.service.YxlNoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: nijiaqi
 * @date: 2018/12/28
 */
@Controller
public class PersonalController {
    @Resource
    private YxlDocService yxlDocService;
    @Resource
    private YxlDocSearchService yxlDocSearchService;
    @Resource
    public YxlNoteService yxlNoteService;

    /**
     * 跳转到发表yxl文章页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "yxlIssueDoc", method = RequestMethod.GET)
    public String yxlIssueDoc(Model model,
                              @RequestParam(required = true) String token) {
        if (!"njq".equals(token)) {
            return "aaa";
        }
        List<YxlType> list = yxlDocService.queryTypeTitleList();
        model.addAttribute("list", list);
        return "back/issueDoc/yxlBackIssueDoc";
    }

    /**
     * 修改yxl文章进行跳转
     *
     * @param model
     * @param docId
     * @return
     */
    @RequestMapping(value = "updateYxlDocPage", method = RequestMethod.GET)
    public String updateYxlDocPage(Model model, Long docId,
                                   @RequestParam(required = true) String token) {
        if (!"njq".equals(token)) {
            return "aaa";
        }
        List<YxlType> list = yxlDocService.queryTypeTitleList();
        model.addAttribute("list", list);
        if (docId == null) {
            return "back/issueDoc/yxlBackIssueDoc";
        }
        YxlDocSearch search = yxlDocSearchService.queryByDocId(docId);
        if (search == null) {
            return "back/issueDoc/yxlBackIssueDoc";
        }
        if (search.getTypeId() != null) {
            YxlType type = yxlDocService.queryTypeById(search.getTypeId());
            model.addAttribute("type", type);
        }
        YxlDoc doc = yxlDocService.queryById(docId);
        List<YxlTip> tipList = yxlDocService.queryDocTipList(docId);
        String tipName = "";
        for (YxlTip t : tipList) {
            tipName += t.getTipName() + ",";
        }
        model.addAttribute("doc", doc);
        model.addAttribute("tipName", tipName);
        model.addAttribute("isUpdate", true);
        model.addAttribute("search", search);
        return "back/issueDoc/yxlBackIssueDoc";
    }

    /**
     * 进行笔记管理后门
     *
     * @param token
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "noteManager", method = RequestMethod.GET)
    public String noteManager(String token, HttpServletRequest request, Model model) {
        if ("njqnote".equals(token)) {
            HttpSession session = request.getSession();
            session.setAttribute("sessionId", request.getSession().getId());
            BaseUser user = new BaseUser();
            user.setAccount("admin");
            user.setId(2L);
            session.setAttribute("user", user);
            List<YxlFolder> folderList = yxlNoteService.queryFolderList(1);
            model.addAttribute("fdList", folderList);
            return "zxgj/noteManager";
        } else {
            return "xxbbss";
        }
    }

    @RequestMapping(value = "recordManager", method = RequestMethod.GET)
    public String recordManager(String token, HttpServletRequest request, Model model) {
        if ("njqrecord".equals(token)) {
            HttpSession session = request.getSession();
            session.setAttribute("sessionId", request.getSession().getId());
            BaseUser user = new BaseUser();
            user.setAccount("admin");
            user.setId(2L);
            session.setAttribute("user", user);
            List<YxlFolder> folderList = yxlNoteService.queryFolderList(2);
            model.addAttribute("fdList", folderList);
            return "zxgj/recordManager";
        } else {
            return "xxbbss";
        }
    }
}
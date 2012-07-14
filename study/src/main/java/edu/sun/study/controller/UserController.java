package edu.sun.study.controller;

import com.google.gson.Gson;
import edu.sun.study.dao.UserInformationDao;
import edu.sun.study.po.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * User: sunqipeng
 * Date: 12-7-13
 */
@Controller
@RequestMapping("/users/*")
public class UserController {
    @Autowired
    UserInformationDao userInformationDao;

    @RequestMapping("index")
    public String index(Model model) {

        query(model);
        return "users/index";
    }

    @RequestMapping("addAjax")
    @ResponseBody
    public String addAjax(Model model, UserInformation userInformation) {

        userInformationDao.save(userInformation);
        query(model);
        return model.asMap().get("ajaxUsers").toString();
    }

    /**
     * we query tge nodel
     *
     * @param model
     */
    private void query(Model model) {
        List<UserInformation> userInformationList = userInformationDao.list();

        System.out.println();
        model.addAttribute("users", userInformationList);
        model.addAttribute("userCount", userInformationDao.getCount());

        Gson gson = new Gson();
        model.addAttribute("ajaxUsers", gson.toJson(userInformationList));
    }

    @RequestMapping("date")
    @ResponseBody
    public String getDate() {
        return new Date().toString();
    }
}

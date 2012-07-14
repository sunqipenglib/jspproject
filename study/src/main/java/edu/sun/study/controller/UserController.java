package edu.sun.study.controller;

import edu.sun.study.dao.UserInformationDao;
import edu.sun.study.po.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        List<UserInformation> userInformationList = userInformationDao.list();
        model.addAttribute("userCount", userInformationList.size());
        model.addAttribute("users", userInformationList);
        return "users/index";
    }

    @RequestMapping("add")
    public String add(Model model) {
        userInformationDao.save10();
        List<UserInformation> userInformationList = userInformationDao.list();

        System.out.println();
        model.addAttribute("users", userInformationList);
        model.addAttribute("userCount", userInformationDao.getCount());
        return "users/index";
    }
}

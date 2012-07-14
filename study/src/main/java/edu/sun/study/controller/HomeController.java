package edu.sun.study.controller;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.sun.study.dao.UserInformationDao;

/**
 * Sample controller for going to the home page with a message
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	UserInformationDao userInformationDao;

	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping(value = "/home")
	public String home(Model model) {
		logger.info("Welcome home!");
		if (entityManager == null) {

		}
		userInformationDao.save10();
		// userInformationDao.save10();
		model.addAttribute("recordcount", userInformationDao.getCount());
		model.addAttribute("controllerMessage",
				"This is the message from the controller!");
		return "home";
	}

	@ResponseBody
	@RequestMapping("/list")
	public Map<String, Object> getUserList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", userInformationDao.list());
		return map;
	}

}

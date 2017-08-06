package cn.game.admin.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	private static Logger logger = LogManager.getLogger(MainController.class);
	
	@RequestMapping("/")
	public String index(Principal principal) {
		if (principal == null) {
			return "redirect:/login";
		}
		return "index";

	}
	

}

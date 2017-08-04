package cn.game.admin.controller.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.game.admin.service.AdminGameService;

@Controller
public class AdminGameRuleController {
	@Autowired
	private AdminGameService adminGameService;
}

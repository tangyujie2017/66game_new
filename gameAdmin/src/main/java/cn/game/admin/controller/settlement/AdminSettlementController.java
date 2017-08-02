package cn.game.admin.controller.settlement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.game.admin.service.AdminSettlementService;

@Controller
public class AdminSettlementController {
	@Autowired
	private AdminSettlementService adminSettlementService;
}

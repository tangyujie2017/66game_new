package cn.game.admin.controller.withdraw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.game.admin.service.AdminWithdrawService;

@Controller
public class AdminWithdrawController {
 @Autowired
 private AdminWithdrawService adminWithdrawService;
}

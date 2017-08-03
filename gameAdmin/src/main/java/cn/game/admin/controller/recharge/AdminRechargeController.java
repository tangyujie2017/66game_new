package cn.game.admin.controller.recharge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.game.admin.controller.http.req.BaseRequest;
import cn.game.admin.controller.http.req.recharge.ManageApiRechargeReq;
import cn.game.admin.controller.http.resp.BaseResponse;
import cn.game.admin.service.AdminRechargeService;

@Controller
public class AdminRechargeController {
	@Autowired
	private AdminRechargeService adminRechargeService;

	@PostMapping(value = "/admin/recharge/managerApi")
	@ResponseBody
	public ResponseEntity<BaseResponse> managerApi(@RequestBody BaseRequest<ManageApiRechargeReq> req) {
		adminRechargeService.manageApiRecharge(req.getData().getRechargeId(), req.getData().getStatus());
		return null;
	}

}

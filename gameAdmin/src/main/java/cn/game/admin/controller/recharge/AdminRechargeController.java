package cn.game.admin.controller.recharge;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.game.admin.controller.http.req.BaseRequest;
import cn.game.admin.controller.http.req.agency.LoadPlayerAgencyListReq;
import cn.game.admin.controller.http.req.recharge.LoadPlayerRechargeListReq;
import cn.game.admin.controller.http.req.recharge.ManageAdminRechargeReq;
import cn.game.admin.controller.http.req.recharge.ManageApiRechargeReq;
import cn.game.admin.controller.http.resp.BaseResponse;
import cn.game.admin.service.AdminRechargeService;
import cn.game.admin.util.PageParam;
import cn.game.admin.util.PageVo;
import cn.game.core.entity.table.play.PlayerAgency;
import cn.game.core.entity.table.wallet.PlayerRecharge;
import cn.game.core.tools.Groups;
import cn.game.core.tools.Page;

@Controller
public class AdminRechargeController {
	@Autowired
	private AdminRechargeService adminRechargeService;

	@PostMapping(value = "/admin/recharge/managerApi")
	@ResponseBody
	public ResponseEntity<BaseResponse> managerApi(@RequestBody BaseRequest<ManageApiRechargeReq> req,
			BindingResult result) {
		adminRechargeService.manageApiRecharge(req.getData().getRechargeId(), req.getData().getStatus());
		return BaseResponse.success("充值成功");
	}

	@PostMapping(value = "/admin/recharge/managerAdmin")
	@ResponseBody
	public ResponseEntity<BaseResponse> managerAdmin(@Valid @RequestBody BaseRequest<ManageAdminRechargeReq> req,
			BindingResult result) {
		PlayerRecharge rechage = new PlayerRecharge();
		rechage.setRechargeAmount(req.getData().getRechargeAmount());
		rechage.setRechargeScore(req.getData().getRechargeScore());
		adminRechargeService.manageAdminRecharge(rechage, req.getData().getUserPlatformId());
		return BaseResponse.success("充值成功");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/recharge/list")
	@ResponseBody
	public PageVo<PlayerRecharge> loadRechargeList(@Valid PageParam<LoadPlayerRechargeListReq> param,
			BindingResult result) {

		int pageSize = param.getPageSize();
		int currentPage = param.getPageIndex();
		Groups g = new Groups();
		if (param.getSearch() != null) {
			// 有查询条件
			LoadPlayerRechargeListReq req = param.getSearch();
			// if (req.getAgencyName() != null && !"".equals(req.getAgencyName())) {
			// g.Add("agencyName", req.getAgencyName());
			// }
			// if (req.getAgencyCode() != null && !"".equals(req.getAgencyCode())) {
			// g.Add("agencyUnionCode", req.getAgencyCode());
			// }
		}
		Page<PlayerRecharge> page = adminRechargeService.loadPlayerRechargeList(g, pageSize, currentPage);
		PageVo<PlayerRecharge> pageVo = new PageVo<PlayerRecharge>();
		pageVo.setItems(page.getItems());
		pageVo.setTotal(page.getTotalCount());
		return pageVo;
	}

}

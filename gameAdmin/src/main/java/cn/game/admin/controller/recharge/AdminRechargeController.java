package cn.game.admin.controller.recharge;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;
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
import cn.game.admin.controller.http.req.recharge.PageParamLoadAppPlayerRechargeListReq;
import cn.game.admin.controller.http.req.recharge.CheckUserPlatformIdReq;
import cn.game.admin.controller.http.req.recharge.ManageAdminRechargeReq;
import cn.game.admin.controller.http.req.recharge.ManageApiRechargeReq;
import cn.game.admin.controller.http.req.recharge.PageParamLoadAdminPlayerRechargeListReq;
import cn.game.admin.controller.http.resp.BaseResponse;
import cn.game.admin.service.AdminRechargeService;
import cn.game.admin.util.PageVo;
import cn.game.admin.util.PlayerRechargeVo;
import cn.game.admin.util.PlayerVo;
import cn.game.core.entity.table.play.Player;
import cn.game.core.entity.table.wallet.PlayerRecharge;
import cn.game.core.tools.Groups;
import cn.game.core.tools.Page;

@Controller
public class AdminRechargeController {
	@Autowired
	private AdminRechargeService adminRechargeService;

	@PostMapping(value = "/admin/recharge/api/manager")
	@ResponseBody
	public ResponseEntity<BaseResponse> managerApi(@RequestBody BaseRequest<ManageApiRechargeReq> req,
			BindingResult result) {
		adminRechargeService.manageApiRecharge(req.getData().getRechargeId(), req.getData().getStatus());
		return BaseResponse.success("充值成功");
	}

	@PostMapping(value = "/admin/recharge/admin/check")
	@ResponseBody
	public ResponseEntity<BaseResponse> checkUserPlatformId(@Valid @RequestBody BaseRequest<CheckUserPlatformIdReq> req,
			BindingResult result) {

		Player player = adminRechargeService.loadPlayerByUserPlatformId(req.getData().getUserPlatformId());
		if (player != null) {
			return BaseResponse.success(PlayerVo.playerToVo(player));
		} else {
			return BaseResponse.systemError("没有找到玩家");
		}

	}

	@PostMapping(value = "/admin/recharge/admin/manager")
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
	@RequestMapping(value = "/admin/recharge/app/list")
	@ResponseBody
	public PageVo<PlayerRechargeVo> loadAppRechargeList(@Valid PageParamLoadAppPlayerRechargeListReq param,
			BindingResult result) {

		int pageSize = param.getPageSize();
		int currentPage = param.getPageIndex();
		Groups g = new Groups();

		// 有查询条件
		// if (param.getWxNickname() != null &&
		// !"".equals(param.getWxNickname())) {
		// g.Add("player.wxNickname", param.getWxNickname());
		// }
		// if (param.getUserPlatformId() != null &&
		// !"".equals(param.getUserPlatformId())) {
		// g.Add("player.userPlatformId", param.getUserPlatformId());
		// }
		g.Add("rechargeSource", 1);
		g.Add("operateType", 1);
		Page<PlayerRecharge> page = adminRechargeService.loadPlayerRechargeList(g, pageSize, currentPage);
		PageVo<PlayerRechargeVo> pageVo = new PageVo<PlayerRechargeVo>();

		pageVo.setItems(PlayerRechargeVo.convertToListVo(page.getItems()));
		pageVo.setTotal(page.getTotalCount());
		return pageVo;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/recharge/admin/list")
	@ResponseBody
	public PageVo<PlayerRechargeVo> loadAdminRechargeList(@Valid PageParamLoadAdminPlayerRechargeListReq param,
			BindingResult result) {

		int pageSize = param.getPageSize();
		int currentPage = param.getPageIndex();
		Groups g = new Groups();

		// 有查询条件
		// if (req.getAgencyName() != null && !"".equals(req.getAgencyName())) {
		// g.Add("agencyName", req.getAgencyName());
		// }
		// if (req.getAgencyCode() != null && !"".equals(req.getAgencyCode())) {
		// g.Add("agencyUnionCode", req.getAgencyCode());
		// }
		g.Add("rechargeSource", 2);
		g.Add("operateType", 2);
		Page<PlayerRecharge> page = adminRechargeService.loadPlayerRechargeList(g, pageSize, currentPage);
		PageVo<PlayerRechargeVo> pageVo = new PageVo<PlayerRechargeVo>();

		pageVo.setItems(PlayerRechargeVo.convertToListVo(page.getItems()));
		pageVo.setTotal(page.getTotalCount());
		return pageVo;
	}

	@RequestMapping(value = "/admin/recharge/app/index")
	public String appRechargeIndex(Principal principal, HttpServletResponse response) {
		if (principal == null) {
			return "redirect:/login";
		}
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
		return "game_app_recharge";

	}

	@RequestMapping(value = "/admin/recharge/admin/index")
	public String adminRechargeIndex(Principal principal, HttpServletResponse response) {
		if (principal == null) {
			return "redirect:/login";
		}
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
		return "game_admin_reharge";

	}
}

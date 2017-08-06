package cn.game.admin.controller.withdraw;

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
import cn.game.admin.controller.http.req.recharge.ManageApiRechargeReq;
import cn.game.admin.controller.http.req.withdraw.LoadPlayerWithDrawListReq;
import cn.game.admin.controller.http.req.withdraw.ManageAdminWithdrawReq;
import cn.game.admin.controller.http.resp.BaseResponse;
import cn.game.admin.service.AdminWithdrawService;
import cn.game.admin.util.PageVo;
import cn.game.admin.util.PlayerGiveScoreVo;
import cn.game.core.entity.table.wallet.PlayerGiveScore;
import cn.game.core.tools.Groups;
import cn.game.core.tools.Page;

@Controller
public class AdminWithdrawController {
	@Autowired
	private AdminWithdrawService adminWithdrawService;

	@RequestMapping(value = "/admin/withdraw/index")
	public String index(Principal principal, HttpServletResponse response) {
		if (principal == null) {
			return "redirect:/login";
		}
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
		return "game_app_withdraw";

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/withdraw/list")
	@ResponseBody
	public PageVo<PlayerGiveScoreVo> loadWithDrawList(@Valid LoadPlayerWithDrawListReq param, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		int pageSize = param.getPageSize();
		int currentPage = param.getPageIndex();
		Groups g = new Groups();
		g.Add("status", 1);
		// 有查询条件
		g.setOrderby("crateTime");
		Page<PlayerGiveScore> page = adminWithdrawService.loadPlayerWithDrawList(g, pageSize, currentPage);
		PageVo<PlayerGiveScoreVo> pageVo = new PageVo<PlayerGiveScoreVo>();
		pageVo.setItems(PlayerGiveScoreVo.convertToListVo(page.getItems()));
		pageVo.setTotal(page.getTotalCount());
		return pageVo;
	}

	@PostMapping(value = "/admin/withdraw/api/manager")
	@ResponseBody
	public ResponseEntity<BaseResponse> managerApi(@RequestBody BaseRequest<ManageAdminWithdrawReq> req,
			BindingResult result) {
		if (result.hasErrors()) {
			return BaseResponse.systemError("请求参数错误");
		}
		try {
			adminWithdrawService.manageApiWithdraw(req.getData().getWithDrawId(), req.getData().getStatus());
			return BaseResponse.success("充值成功");
		} catch (Exception e) {
			return BaseResponse.systemError(e.getMessage());
		}

	}
}

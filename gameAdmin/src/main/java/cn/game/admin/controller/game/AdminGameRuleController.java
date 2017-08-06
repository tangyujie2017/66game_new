package cn.game.admin.controller.game;

import java.security.Principal;
import java.util.Date;

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
import cn.game.admin.controller.http.req.agency.PageParamLoadPlayerAgencyListReq;
import cn.game.admin.controller.http.req.agency.SaveAgencyReq;
import cn.game.admin.controller.http.req.game.UpdateRuleReq;
import cn.game.admin.controller.http.resp.BaseResponse;
import cn.game.admin.service.AdminGameService;
import cn.game.admin.util.GameAdminUtils;
import cn.game.admin.util.PageVo;
import cn.game.admin.util.PlayerAgencyVo;
import cn.game.core.entity.table.game.Game;
import cn.game.core.entity.table.play.PlayerAgency;
import cn.game.core.tools.Groups;
import cn.game.core.tools.Page;

//游戏
@Controller
public class AdminGameRuleController {
	@Autowired
	private AdminGameService adminGameService;

	@RequestMapping(value = "/admin/game/index")
	public String index(Principal principal, HttpServletResponse response) {
		if (principal == null) {
			return "redirect:/login";
		}
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
		return "memoryPlayers";

	}

	@RequestMapping(value = "/admin/game/minPlayerNum/index")
	public String minPlayerNumInit(Principal principal, HttpServletResponse response) {
		if (principal == null) {
			return "redirect:/login";
		}
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
		return "minPlayerNumbers";

	}

	@RequestMapping(value = "/admin/game/memoryPlayerNum")
	@ResponseBody
	public String memoryPlayerNum(Principal principal, HttpServletResponse response) {
		return adminGameService.memoryPlayerNum();

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/game/rule/list")
	@ResponseBody
	public PageVo<Game> loadRuleList(@Valid PageParamLoadPlayerAgencyListReq param, BindingResult result) {

		int pageSize = param.getPageSize();
		int currentPage = param.getPageIndex();
		Groups g = new Groups();

		g.Add("status", 1);

		Page<Game> page = adminGameService.loadRuleList(g, pageSize, currentPage);
		PageVo<Game> pageVo = new PageVo<Game>();
		pageVo.setItems(page.getItems());
		pageVo.setTotal(page.getTotalCount());
		return pageVo;
	}

	@PostMapping(value = "/admin/game/rule/update")
	@ResponseBody
	public ResponseEntity<BaseResponse> updateRule(@RequestBody BaseRequest<UpdateRuleReq> req) {
		adminGameService.updateGameRule(req.getData().getMinNum());

		return BaseResponse.success("");
	}
}

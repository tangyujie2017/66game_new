package cn.game.admin.controller.agency;

import java.util.Date;

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
import cn.game.admin.controller.http.req.agency.CheckPlayerAgencyReq;
import cn.game.admin.controller.http.req.agency.PageParamLoadPlayerAgencyListReq;
import cn.game.admin.controller.http.req.agency.SaveAgencyReq;
import cn.game.admin.controller.http.resp.BaseResponse;
import cn.game.admin.service.AdminAgencyService;
import cn.game.admin.util.GameAdminUtils;
import cn.game.admin.util.PageVo;
import cn.game.admin.util.PlayerAgencyVo;
import cn.game.core.entity.table.play.PlayerAgency;
import cn.game.core.tools.Groups;
import cn.game.core.tools.Page;

@Controller
public class AdminAgencyController {
	@Autowired
	private AdminAgencyService adminAgencyService;

	@PostMapping(value = "/admin/agency/save")
	@ResponseBody
	public ResponseEntity<BaseResponse> saveAgency(@RequestBody BaseRequest<SaveAgencyReq> req) {
		PlayerAgency agency = new PlayerAgency();
		agency.setAgencyName(req.getData().getAgencyName());
		agency.setAgencyUnionCode(GameAdminUtils.getSixRandom());
		agency.setCreateTime(new Date());
		agency.setStatus(true);
		adminAgencyService.saveAgency(agency);
		return BaseResponse.success("");
	}
	
	@RequestMapping(value = "/admin/agency/del")
	@ResponseBody
	public ResponseEntity<BaseResponse> delAgency( Long id) {
		if(id==null){
			return BaseResponse.systemError("参数错误");
		}
		adminAgencyService.delAgency(id);
		return BaseResponse.success("");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/agency/list")
	@ResponseBody
	public PageVo<PlayerAgencyVo> loadPlayerAgencyList(@Valid PageParamLoadPlayerAgencyListReq param,
			BindingResult result) {

		int pageSize = param.getPageSize();
		int currentPage = param.getPageIndex();
		Groups g = new Groups();

		// 有查询条件

		if (param.getAgencyName() != null && !"".equals(param.getAgencyName())) {
			g.Add("agencyName", param.getAgencyName());
		}
		if (param.getAgencyCode() != null && !"".equals(param.getAgencyCode())) {
			g.Add("agencyUnionCode", param.getAgencyCode());
		}

		Page<PlayerAgency> page = adminAgencyService.loadPlayerAgencyList(g, pageSize, currentPage);
		PageVo<PlayerAgencyVo> pageVo = new PageVo<PlayerAgencyVo>();
		pageVo.setItems(PlayerAgencyVo.covertListVo(page.getItems()));
		pageVo.setTotal(page.getTotalCount());
		return pageVo;
	}

	@PostMapping(value = "/admin/agency/check")
	@ResponseBody
	public ResponseEntity<BaseResponse> checkPlayerAgency(@Valid @RequestBody BaseRequest<CheckPlayerAgencyReq> req) {

		return BaseResponse.success(adminAgencyService.checkAgencyName(req.getData().getAgencyName()));
	}

}

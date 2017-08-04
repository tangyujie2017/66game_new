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
import cn.game.admin.controller.http.req.agency.LoadPlayerAgencyListReq;
import cn.game.admin.controller.http.req.agency.SaveAgencyReq;
import cn.game.admin.controller.http.resp.BaseResponse;
import cn.game.admin.service.AdminAgencyService;
import cn.game.admin.util.GameAdminUtils;
import cn.game.admin.util.PageParam;
import cn.game.admin.util.PageVo;
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

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/agency/list")
	@ResponseBody
	public PageVo<PlayerAgency> loadPlayerAgencyList(@Valid PageParam<LoadPlayerAgencyListReq> param,
			BindingResult result) {

		int pageSize = param.getPageSize();
		int currentPage = param.getPageIndex();
		Groups g = new Groups();
		if (param.getSearch() != null) {
			// 有查询条件
			LoadPlayerAgencyListReq req = param.getSearch();
			if (req.getAgencyName() != null && !"".equals(req.getAgencyName())) {
				g.Add("agencyName", req.getAgencyName());
			}
			if (req.getAgencyCode() != null && !"".equals(req.getAgencyCode())) {
				g.Add("agencyUnionCode", req.getAgencyCode());
			}
		}
		Page<PlayerAgency> page=adminAgencyService.loadPlayerAgencyList(g, pageSize, currentPage);
		PageVo<PlayerAgency> pageVo=new PageVo<PlayerAgency>();
		pageVo.setItems(page.getItems());
		pageVo.setTotal(page.getTotalCount());
		return pageVo;
	}

	@PostMapping(value = "/admin/agency/check")
	@ResponseBody
	public ResponseEntity<BaseResponse> checkPlayerAgency(@Valid @RequestBody BaseRequest<CheckPlayerAgencyReq> req) {

		return BaseResponse.success(adminAgencyService.checkAgencyName(req.getData().getAgencyName()));
	}

}

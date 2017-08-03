package cn.game.admin.controller.agency;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

	@PostMapping(value = "/admin/agency/list")
	@ResponseBody
	public ResponseEntity<BaseResponse> loadPlayerAgencyList(@RequestBody BaseRequest<LoadPlayerAgencyListReq> req) {

		int pageSize = req.getData().getPageSize();
		int currentPage = req.getData().getPageIndex();
		Groups g = new Groups();

		return BaseResponse.success(adminAgencyService.loadPlayerAgencyList(g, pageSize, currentPage));
	}

	@PostMapping(value = "/admin/agency/check")
	@ResponseBody
	public ResponseEntity<BaseResponse> checkPlayerAgency(@Valid @RequestBody BaseRequest<CheckPlayerAgencyReq> req) {

		return BaseResponse.success(adminAgencyService.checkAgencyName(req.getData().getAgencyName()));
	}

}

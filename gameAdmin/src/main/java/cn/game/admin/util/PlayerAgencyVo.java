package cn.game.admin.util;

import java.util.ArrayList;
import java.util.List;

import cn.game.core.entity.table.play.PlayerAgency;

public class PlayerAgencyVo {

	private Long agencyId;

	private String agencyName;

	private String createTime;

	private Boolean status = false;

	private String agencyUnionCode;

	public Long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getAgencyUnionCode() {
		return agencyUnionCode;
	}

	public void setAgencyUnionCode(String agencyUnionCode) {
		this.agencyUnionCode = agencyUnionCode;
	}

	public static PlayerAgencyVo covertVo(PlayerAgency agency) {
		PlayerAgencyVo vo = new PlayerAgencyVo();
		vo.setAgencyId(agency.getAgencyId());
		vo.setAgencyName(agency.getAgencyName());
		vo.setAgencyUnionCode(agency.getAgencyUnionCode());
		vo.setCreateTime(GameAdminUtils.dateToStr(agency.getCreateTime()));
		return vo;
	}

	public static List<PlayerAgencyVo> covertListVo(List<PlayerAgency> list) {
		List<PlayerAgencyVo> voList = new ArrayList<PlayerAgencyVo>();
		if (list != null) {
			for (PlayerAgency agency : list) {
				PlayerAgencyVo vo = new PlayerAgencyVo();
				vo.setAgencyId(agency.getAgencyId());
				vo.setAgencyName(agency.getAgencyName());
				vo.setAgencyUnionCode(agency.getAgencyUnionCode());
				vo.setCreateTime(GameAdminUtils.dateToStr(agency.getCreateTime()));
				voList.add(vo);
			}
		}

		return voList;
	}

}

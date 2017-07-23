package cn.game.core.service.vo;

import cn.game.core.entity.table.play.Player;

public class PlayerSimpleVo {
	private Long userId;
	private String wxNickname;// 普通用户昵称
	private String wxHeadimgurl;// 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
	private PlayerAccountVo accout;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getWxNickname() {
		return wxNickname;
	}
	public void setWxNickname(String wxNickname) {
		this.wxNickname = wxNickname;
	}
	public String getWxHeadimgurl() {
		return wxHeadimgurl;
	}
	public void setWxHeadimgurl(String wxHeadimgurl) {
		this.wxHeadimgurl = wxHeadimgurl;
	}
	public PlayerAccountVo getAccout() {
		return accout;
	}
	public void setAccout(PlayerAccountVo accout) {
		this.accout = accout;
	}
	
	public static PlayerSimpleVo playerToSimpleVo(Player player) {
		PlayerSimpleVo vo = new PlayerSimpleVo();
		vo.setUserId(player.getUserId());
		vo.setWxHeadimgurl(player.getWxHeadimgurl());
		vo.setWxNickname(player.getWxNickname());
		
		
		PlayerAccountVo accountVo = new PlayerAccountVo();
		accountVo.setAccout_id(player.getAccout().getAccout_id());
		accountVo.setHistoryPayRecord(player.getAccout().getHistoryPayRecord());
		accountVo.setTotalGold(player.getAccout().getTotalGold());
		vo.setAccout(accountVo);
		return vo;

	}
}

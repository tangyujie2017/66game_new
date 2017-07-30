package cn.game.core.service.vo;

import java.util.List;

public class PlayerFriendVo {
     private  Long userId;
     private  List<PlayerSimpleVo>friends;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<PlayerSimpleVo> getFriends() {
		return friends;
	}
	public void setFriends(List<PlayerSimpleVo> friends) {
		this.friends = friends;
	}
     
}

package cn.game.api.controller.req.friend;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class SendFriendScoreReq  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	private Long sendUserId;
	@NotNull
	private Long receiverUserId;
	@NotNull
	private Long score;
	public Long getSendUserId() {
		return sendUserId;
	}
	public void setSendUserId(Long sendUserId) {
		this.sendUserId = sendUserId;
	}
	public Long getReceiverUserId() {
		return receiverUserId;
	}
	public void setReceiverUserId(Long receiverUserId) {
		this.receiverUserId = receiverUserId;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}

}

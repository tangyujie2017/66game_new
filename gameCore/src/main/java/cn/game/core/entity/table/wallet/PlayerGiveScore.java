package cn.game.core.entity.table.wallet;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//用户赠送情况
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import cn.game.core.entity.table.play.Player;
@Entity
public class PlayerGiveScore implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "send_user_id")
	private Player benefactor;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receive_user_id")
	private Player receiver;
	@Column
	private Long score;
	@Column
	private Integer status;//1未处理，2已处理，3拒绝
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Player getBenefactor() {
		return benefactor;
	}
	public void setBenefactor(Player benefactor) {
		this.benefactor = benefactor;
	}
	public Player getReceiver() {
		return receiver;
	}
	public void setReceiver(Player receiver) {
		this.receiver = receiver;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	

}

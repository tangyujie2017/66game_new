package cn.game.core.service.vo;

public class GameResultVo {
	private Long id;
	private String batchNum;
	private Long aninalId;

	private String name;

	private Integer multiple;

	private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}

	public Long getAninalId() {
		return aninalId;
	}

	public void setAninalId(Long aninalId) {
		this.aninalId = aninalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMultiple() {
		return multiple;
	}

	public void setMultiple(Integer multiple) {
		this.multiple = multiple;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}

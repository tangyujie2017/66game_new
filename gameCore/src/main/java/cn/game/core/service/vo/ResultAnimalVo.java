package cn.game.core.service.vo;

import java.util.ArrayList;
import java.util.List;

import cn.game.core.entity.table.play.ResultAnimal;

public class ResultAnimalVo {

	private Long id;

	private Long aninalId;

	private String name;

	private Integer multiple;

	private String type;

	private Integer originalScore;

	private Integer resultScore;

	private boolean selected = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getOriginalScore() {
		return originalScore;
	}

	public void setOriginalScore(Integer originalScore) {
		this.originalScore = originalScore;
	}

	public Integer getResultScore() {
		return resultScore;
	}

	public void setResultScore(Integer resultScore) {
		this.resultScore = resultScore;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public static ResultAnimalVo ResultAnimalToVo(ResultAnimal resultAnimal) {
		ResultAnimalVo vo = new ResultAnimalVo();
		vo.setAninalId(resultAnimal.getAnimal().getId());
		vo.setId(resultAnimal.getId());
		vo.setMultiple(resultAnimal.getAnimal().getMultiple());
		vo.setName(resultAnimal.getAnimal().getName());
		vo.setOriginalScore(resultAnimal.getOriginalScore());
		vo.setResultScore(resultAnimal.getResultScore());
		vo.setType(resultAnimal.getAnimal().getType());
		vo.setSelected(resultAnimal.isSelected());
		return vo;
	}

	public static List<ResultAnimalVo> toListVo(List<ResultAnimal> list) {
		List<ResultAnimalVo> rList = new ArrayList<ResultAnimalVo>();
		list.stream().forEach(a -> {

			rList.add(ResultAnimalToVo(a));

		});

		return rList;
	}
}

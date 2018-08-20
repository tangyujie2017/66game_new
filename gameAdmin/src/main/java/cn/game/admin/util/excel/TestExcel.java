package cn.game.admin.util.excel;

import java.util.Date;

public class TestExcel {
	@ExcelAnnotation(index = 0, sheetIndex = 0, valueType = String.class)
	private String name;
	//@ExcelAnnotation(index = 1, sheetIndex = 0, valueType = String.class)
	private String stuNum;
	@ExcelAnnotation(index = 2, sheetIndex = 0, valueType = Integer.class)
	private int score;
	@ExcelAnnotation(index = 3, sheetIndex = 0, valueType = Date.class)
	private Date startDate;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}

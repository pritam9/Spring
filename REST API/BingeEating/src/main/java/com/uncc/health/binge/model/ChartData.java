package com.uncc.health.binge.model;

import java.util.List;

public class ChartData {
	List<Columns> cols;
	//List<MapData> rows;
	List<Rows> rows;
	public List<Columns> getCols() {
		return cols;
	}
	public void setCols(List<Columns> cols) {
		this.cols = cols;
	}
	public List<Rows> getRows() {
		return rows;
	}
	public void setRows(List<Rows> rows) {
		this.rows = rows;
	}
	
	
}

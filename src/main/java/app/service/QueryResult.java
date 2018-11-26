package app.service;

import java.util.List;

public class QueryResult {
	
	private int totalRecords; // para ver el total de registro
	private List<Object> list; // lista de ejecucion del query

	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	

}

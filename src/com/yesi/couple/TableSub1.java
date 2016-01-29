package com.yesi.couple;

public class TableSub1 {

	private int id;
	private String myName;
	private String yourName;
	private String result;
	
	public TableSub1(int id,String myName,String yourName,String result) {
		// TODO Auto-generated constructor stub
		this.setId(id);
		this.setMyName(myName);
		this.setYourName(yourName);
		this.setResult(result);
	}
	public TableSub1(String myName,String yourName,String result) {
		// TODO Auto-generated constructor stub
		this.setMyName(myName);
		this.setYourName(yourName);
		this.setResult(result);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public String getYourName() {
		return yourName;
	}

	public void setYourName(String yourName) {
		this.yourName = yourName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}

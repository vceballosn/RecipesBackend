package app.service;

public class AbstractResponse {

	private int code;
	private String description;


	public  AbstractResponse (){
		
	}
	public AbstractResponse(int code){
		this.code = code;
	} 
	
	public AbstractResponse(int code, String description){
		this.code = code;
		this.description = description;
	} 
	public int getCode() {
		return code;	
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

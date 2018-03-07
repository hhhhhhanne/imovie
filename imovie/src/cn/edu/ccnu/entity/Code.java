package cn.edu.ccnu.entity;

public class Code {
    private String name;
    private String code;
    private String value;
    
    public void setName(String name){
    	this.name = name;
    }
    
    public void setCode(String code){
    	this.code = code;
    }
    
    public void setValue(String value){
    	this.value = value;
    }
    
    
    public String getName(){
    	return this.name;
    }
    
    public String getCode(){
    	return this.code;
	}
    
    public String getValue(){
    	return this.value;
    }
}

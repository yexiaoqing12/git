package cn.itcast.exception;

public class CustomerException extends Exception {
private String massage;

public String getMassage() {
	return massage;
}

public void setMassage(String massage) {
	this.massage = massage;
}
}

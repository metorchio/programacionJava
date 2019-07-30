package ar.com.maxo.helloSpring;

public class HelloWorld {
	
	private String message;

	//Constructor por defecto, necesario para el uso de spring con xml.
	public HelloWorld() {}

	//Constructor con parametro, necesario para el uso de spring con annotations.
	public HelloWorld(String msg) {
		this.setMessage(msg);
	}

	public void printHello() {
		System.out.println("Hello " + message);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

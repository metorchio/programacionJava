package ar.com.maxo.javaExample;

public class HelloWorld {
	
	private String name;

	public void printHello() {
		System.out.println("Hello " + name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

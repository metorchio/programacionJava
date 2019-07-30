package ar.com.maxo.helloMaven;

public class HelloWorldImpl implements GreetWorld {
	
	private String name;

	public void greet() {
		System.out.println("Hello " + name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

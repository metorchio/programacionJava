package ar.com.maxo.helloJava;

import ar.com.maxo.helloJava.imported.ImportedClass;
import ar.com.maxo.helloJava.imported.ImportedInterface;

import java.net.URLClassLoader;
import java.lang.Thread;
import java.util.Arrays;


public class MainApp {

	public static void main(String[] args) {
		String name = "Maxo";

		System.out.println("Hello Java!!");
		System.out.println("Hello " + name + " !!");

		ImportedInterface implementedClass = new ImportedClass();
		System.out.println( implementedClass.toString() );

		System.out.print( "URLClassLoader: ");
        //Descomentar para imprimir el class loader.
        Arrays.stream( ((URLClassLoader) (Thread.currentThread().getContextClassLoader())).getURLs() ).forEach(System.out::println);
	}

}

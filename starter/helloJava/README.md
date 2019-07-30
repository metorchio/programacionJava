#Hello Java

Proyecto básico de Java.

##Objetivo
Instalar lo necesario para ejecutar el código propuesto. Compilar y ejecutar la clase MainApp, por consola, sin necesidad de utilizar herramientras extras.

##Preparar entorno
###Instalar Java
a. Instalar JDK (Java Development Kit), agregandola en el path. <br/>
... hacer paso a paso ...


###Compilar y ejecutar código
a. Abrir una consola. <br/>
b. Posicionarse en la carpeta del proyecto. <br/>
c. Ejecutar: <br/>
```
> mkdir out
> javac .\src\ar\com\maxo\helloJava\MainApp.java -d out
> cd out
> java ar.com.maxo.helloJava.MainApp
```

Salida esperada:
```
Hello Java!!
Hello Maxo !!
```

###Compilar como archivo Jar y ejecutar código
a. Abrir una consola. <br/>
b. Posicionarse en la carpeta del proyecto. <br/>
c. Ejecutar: <br/>
```
> mkdir out\META-INF
> cp .\src\META-INF\MANIFEST.MF .\out\META-INF\MANIFEST.MF
> javac .\src\ar\com\maxo\helloJava\MainApp.java -d out
> cd out
> jar cvfm helloJava.jar .\META-INF\MANIFEST.MF .\ar\com\maxo\helloJava\MainApp.class
> java -jar .\helloJava.jar
```

Salida esperada:
```
Hello Java!!
Hello Maxo !!
```

##Links de interés
* Home Java: <br/> https://docs.oracle.com/en/java/

* Oracle Java Tutorials: <br/> https://docs.oracle.com/javase/tutorial/

* Oracle "javac" docs: <br/> https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javac.html 

* Oracle "java" docs: <br/> https://docs.oracle.com/javase/8/docs/technotes/tools/windows/java.html


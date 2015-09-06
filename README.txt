
This file contains some instructions on how to build a jar package for the current project and how to build the demo 
app.

#REQUIREMENTS

To create a jar package or to build the demo app you must have installed the following requirements in your system.

- Java 1.6 or later
	https://www.java.com/en/download/help/index_installing.xml?os=All+Platforms&j=8&n=20
- Maven 3.0 or later (tested with maven 3.3.3) 
	http://maven.apache.org/install.html

	
#CONFIGURING

If you wish to get a jar or create the demo app with a different GWT SDK or JDK version you just need to edit the pom.xml file
found at the base of the project. There you'll find along lines 8-10 the configuration properties for the GWT SDK and JDK
versions. Below you may find an explanation of each property:
- gwt.version : GWT SDK version 
- gwt.maven.version : Maven GWT plugin version, usually should be the same as gwt.version, but not always have latest match  
- java.min.version : Java minimum compatible version  


#RUNNING

Once the system is configured properly, using maven is as simple as executing a command at the base directory of the 
project, where the "pom.xml" file is located.

To create a jar package containing the GWT module run the following command from the base folder of the project:
$> mvn package

The success of this command should create a .jar file in the target folder (target/TeoriaJSNIWrapper-version.jar)

To create the demo app run the following command from the base folder of the project:
$> mvn -P demo gwt:compile

If the command succeeds it will output the generated files in the target folder 
(target/TeoriaJSNIWrapper-version/gwt_teoria)

It is possible to use the codeserver GWT provides to test the demo, run this command and follow codeserver instructions
$> mvn -P demo gwt:run-codeserver 



#USING 

To use the GWT module you must add the jar to your dependencies,either by including it in the WEB-INF/lib/ folder or 
into your dependency manager and inherit the module in your module definition file ( .gwt.xml ) by including 
the following statement:

	<inherits name="com.sinewavemultimedia.Teoria"/>
	
A usage example can be found in the java file under src/main/java/com/sinewavemultimedia/teoria/TeoriaEntryPoint.java 
	
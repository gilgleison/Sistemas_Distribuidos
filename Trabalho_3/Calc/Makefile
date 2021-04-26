all: clean compile rmi

compile:
	javac *.java

open:
	code *.java
rmi:
	rmiregistry

client: 
	java -Djava.security.policy=policy CalculatorClient gg

server: 
	java -Djava.server.rmi.codebaseile:// -Djava.security.policy=policy CalculatorServer

clean:
	rm *.class


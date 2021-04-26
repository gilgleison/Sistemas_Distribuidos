all: clean compile rmi

compile:
	javac *.java

rmi:
	rmiregistry
open:
	code *.java

client: 
	java -Djava.security.policy=policy ChatClient gg

client2:
	java -Djava.security.policy=policy ChatClient2 gg2

server: 
	java -Djava.server.rmi.codebaseile:// -Djava.security.policy=policy ChatServer

clean:
	rm *.class
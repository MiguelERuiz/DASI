TARGET=Agente

compile_all:
	javac -classpath ./lib/jade.jar src/*.java

compile:
	javac -classpath ./lib/jade.jar src/$(TARGET).java

run:
	java -classpath ./lib/jade.jar:./src jade.Boot -gui mi_agente:$(TARGET)

run-no-gui:
	java -classpath ./lib/jade.jar:./src jade.Boot -name HOST mi_agente:$(TARGET)

clean:
	rm ./src/*.class

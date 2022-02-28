
compile:
	javac -classpath ./lib/jade.jar src/*.java

run:
	java -classpath ./lib/jade.jar:./src jade.Boot -gui mi_agente:Agente

run-no-gui:
	java -classpath ./lib/jade.jar:./src jade.Boot -name HOST mi_agente:Agente

clean:
	rm ./src/*.class

genpdf:
	latexmk -pdf

cleanpdf:
	rm -rf _minted-practica1
	latexmk -c
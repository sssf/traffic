all:
	mkdir -p bin/
	javac -d bin/ source/*.java
	cd bin && java Simulation

###
###default: classes
###
###JAVA_COMPILER = -g
###JAVA_OPIONS = javac
###
#### Clean settings
###GEN_EXTENSIONS = bin/*.class
###
#### Fix test output
###TEST_PASS = 's/...passed/\x1b[1;32m   PASSED\x1b[m/g'
###TEST_FAIL = 's/...FAILED/\x1b[1;31m   FAILED\x1b[m/g'
###
###.SUFFIXES: .java .class
###.java.class:
###	$(JAVA_COMPILER) $(JAVA_OPTION) $*.java
###
###
###CLASSES = \
###	Car.java \
###	Light.java \
###	TrafficSystem.java \
###	Simulation.java
###
###
###classes: $(CLASSES:.java=.class)
###
###clean:
###	rm -f $(GEN_EXTENSIONS)
###

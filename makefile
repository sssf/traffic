#all:
#	mkdir -p bin/
#	javac -d bin/ source/*.java
#	cd bin && java Simulation
#
#test:
#	mkdir -p bin/
#	javac -d bin/ source/*.java
#	cd bin && java -cp Simulation


all: test

JUNIT := -cp .:/usr/share/java/junit4.jar
JUNIT_RUNNER := org.junit.runner.JUnitCore
TEST_FILES   := $(shell find source -type f -name "*Test.java")
SOURCE_FILES := $(shell find source -type f -name "*.java")
CLASS_FILES  := $(shell find bin -type f -name "*.class")

run:
	mkdir -p bin/
	javac -d bin $(JUNIT) $(SOURCE_FILES)
	cd bin && java Simulation


test: $(SOURCE_FILES)
	mkdir -p bin/
	javac -d bin/ $(JUNIT) $(SOURCE_FILES)
	cd bin && java $(JUNIT) $(JUNIT_RUNNER) $(patsubst source/%.java, %, $(TEST_FILES))

clean:
	rm -f $(CLASS_FILES)

documentation:
	javadoc -d docs/ -sourcepath source/*.java
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

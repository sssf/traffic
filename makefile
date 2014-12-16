all: test

COMPILER = javac
JAVA = java

JUNIT := -cp .:/usr/share/java/junit4.jar
JUNIT_RUNNER := org.junit.runner.JUnitCore
TEST_FILES   := $(shell find source -type f -name "*Test.java")
SOURCE_FILES := $(shell find source -type f -name "*.java")
CLASS_FILES  := $(shell find bin -type f -name "*.class")

run:
	mkdir -p bin/
	$(COMPILER) -d bin $(JUNIT) $(SOURCE_FILES)
	cd bin && $(JAVA) Simulation

# 0.29user 0.04system 0:00.64elapsed 51%CPU (0avgtext+0avgdata 57204maxresident)k
# 0.29user 0.03system 0:00.64elapsed 51%CPU (0avgtext+0avgdata 30692maxresident)k


test: $(SOURCE_FILES)
	mkdir -p bin/
	$(COMPILER) -d bin/ $(JUNIT) $(SOURCE_FILES)
	cd bin && $(JAVA) $(JUNIT) $(JUNIT_RUNNER) $(patsubst source/%.java, %, $(TEST_FILES))

clean:
	rm -f $(CLASS_FILES)

documentation:
	javadoc -d docs/ -sourcepath source/*.java

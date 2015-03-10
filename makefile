GENDIR=target/
TARGET=${GENDIR}app/bin/pdfbox

SOURCES=$(shell find src/ -type f) pom.xml

all: $(TARGET)

sources:
	@echo $(SOURCES)

clean:
	@rm -rf $(GENDIR)

$(TARGET): $(SOURCES)
	@mvn clean install

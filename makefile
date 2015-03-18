GENDIR=target/
TARGET=${GENDIR}app/bin/pdfbox
AUTOCOMPTARGET=/etc/bash_completion.d/pdfbox
AUTOCOMP_FLAG=$(GENDIR)autocomp.f

SOURCES=$(shell find src/ -type f) pom.xml

all: $(TARGET)

.PHONY: all install

install: all $(AUTOCOMP_FLAG)

$(AUTOCOMP_FLAG): src/main/resources/auto/pdfbox.sh 
	@echo "Creating softlink for bash-completion"
	@ln -s -f $< $(AUTOCOMPTARGET)
	@bash -c complete -F _commands $(AUTOCOMPTARGET)
	@touch $@
	
sources:
	@echo $(SOURCES)

clean:
	@rm -rf $(GENDIR)
	@rm -f $(AUTOCOMPTARGET)

$(TARGET): $(SOURCES)
	@mvn clean install

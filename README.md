# pdfbox-script

* Envelops Apache [PDFBox](https://pdfbox.apache.org/) into an executable script. 
* Provides bash-completion.
* Adds a PDFCountPages parameter.

# Installation from head
* cd $(BASEDIR)
* git clone https://github.com/arnehaber/pdfbox-script
* either 
** make install, or 
** mvn install and softlink bash-completion file: ln -s $(BASEDIR)/pdfbox-script/src/main/resources/auto/pdfbox.sh /etc/bash_completion.d/pdfbox
* add executable (BASEDIR)/target/app/bin/pdfbox to the $PATH variable. 

## License

    Copyright 2015 Arne Haber
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
    http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

A copy of the complete license can be found [here](http://www.apache.org/licenses/LICENSE-2.0 "License").

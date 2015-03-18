###
# #%L
# bdfbox-script
# %%
# Copyright (C) 2015 Arne Haber
# %%
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
# 
#      http://www.apache.org/licenses/LICENSE-2.0
# 
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
# #L%
###
_commands() {
    local cur prev opts opt special i
    COMPREPLY=()
    cur="${COMP_WORDS[COMP_CWORD]}"
    opts="ConvertColorspace Decrypt Encrypt ExtractText ExtractImages Overlay OverlayPDF PrintPDF PDFCountPages PDFDebugger PDFMerger PDFReader PDFSplit PDFToImage TextToPDF WriteDecodedDoc"
	
	if [ $COMP_CWORD -eq 1 ]; then
		COMPREPLY=( $(compgen -W "${opts}" -- ${cur}) )
	else
		local xpat='!*'
		local res=$(compgen -f -X "${xpat}" -- "${cur}")
		COMPREPLY=(${res})
		for ((i=0; i < ${#COMPREPLY[@]}; i++)); do
            [ -d "${COMPREPLY[$i]}" ] && COMPREPLY[$i]=${COMPREPLY[$i]}/
        done
	fi
	return 0
}
complete -F _commands pdfbox

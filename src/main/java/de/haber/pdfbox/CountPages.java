/*
 * #%L
 * bdfbox-script
 * %%
 * Copyright (C) 2015 Arne Haber
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package de.haber.pdfbox;

import static com.google.common.base.Preconditions.checkArgument;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

public class CountPages {
    
    public static final String OPTION_NAME = "PDFCountPages";
    
    public static void main(String[] args) {
        checkArgument(args.length == 2, "Please use " + OPTION_NAME + " input-pdf");
        
        String[] arguments = new String[args.length - 1];
        System.arraycopy(args, 1, arguments, 0, arguments.length);
        
        CountPages counter = new CountPages();
        File input = new File(arguments[0]); 
        int pages;
        try {
            pages = counter.count(input);
            System.out.println(pages);
        }
        catch (IOException e) {
            System.err.println("Error while reading " + input.toString() + "!");
            e.printStackTrace();
        }
    }

    public int count(File input) throws IOException {
        checkArgument(input.exists() && input.isFile(), "The input pdf has to exist and must be a file.");
        PDDocument doc = PDDocument.load(input);
        int res = doc.getNumberOfPages();
        doc.close();
        return res;
    }

    

}

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

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountPagesTest {
    
    private static final String TEST_IN = "src/test/resources/";
    @Test
    public void testArgumentAmount() {
        String[] args = new String[]{
                        
        };
        try {
            CountPages.main(args);            
            fail("IllegalArgumentException expected.");
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    @Test
    public void testMissingInput() {
        String[] args = new String[]{
            CountPages.OPTION_NAME            
        };
        try {
            CountPages.main(args);            
            fail("IllegalArgumentException expected.");
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    @Test
    public void testNotExistingInput() {
        String[] args = new String[]{
            CountPages.OPTION_NAME,
            TEST_IN + "notExisting.pdf"
        };
        try {
            CountPages.main(args);            
            fail("IllegalArgumentException expected.");
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    @Test
    public void testCount() {
        CountPages testee = new CountPages();
        int expectedPages = 10;
        
        File input = new File(TEST_IN, "TestIn.pdf");
        try {
            int actual = testee.count(input);
            assertEquals(expectedPages, actual);
        }
        catch (IOException e) {
            fail(e.getMessage());
        }
    }

}

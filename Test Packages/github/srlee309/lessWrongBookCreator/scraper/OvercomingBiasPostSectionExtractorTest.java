/* 
 * Copyright (C) 2015 Scott Lee
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package github.srlee309.lessWrongBookCreator.scraper;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import static org.junit.Assert.*;

public class OvercomingBiasPostSectionExtractorTest {
    @Test
    public void getPostSectionString_ReadStoredHtmlNoComments_OutputAsExpected() throws Exception {
        PostExtractionDetails postExtractionDetails = new PostExtractionDetails.Builder().build(); 
        String htmlString =  FileUtils.readFileToString(new File(this.getClass().getResource("/Overcoming Bias  Does Decadence Cause Decay.html").toURI()));
        Document doc =  Jsoup.parse(htmlString);
        OvercomingBiasPostSectionExtractor instance = new OvercomingBiasPostSectionExtractor();
        String result = instance.getPostSectionString(postExtractionDetails, doc);
        String expResult = FileUtils.readFileToString(new File(this.getClass().getResource("/Overcoming Bias  Does Decadence Cause Decay No Comments.txt").toURI()), "UTF-8");
        
        assertTrue(expResult.trim().equals(result.trim()));
    }

    @Test
    public void getPostSectionString_ReadStoredHtmlWithComments_OutputAsExpected() throws Exception{
        PostExtractionDetails postExtractionDetails = new PostExtractionDetails.Builder().build();
        String htmlString =  FileUtils.readFileToString(new File(this.getClass().getResource("/Overcoming Bias  Does Decadence Cause Decay.html").toURI()));
        Document doc =  Jsoup.parse(htmlString);
        OvercomingBiasPostSectionExtractor instance = new OvercomingBiasPostSectionExtractor();
        String result = instance.getPostSectionString(postExtractionDetails, doc);
        String expResult = FileUtils.readFileToString(new File(this.getClass().getResource("/Overcoming Bias  Does Decadence Cause Decay With Comments.txt").toURI()), "UTF-8");
        
        assertTrue(expResult.trim().equals(result.trim()));
    }
    
}

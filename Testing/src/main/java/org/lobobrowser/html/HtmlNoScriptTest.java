/*GNU GENERAL LICENSE
    Copyright (C) 2006 The Lobo Project. Copyright (C) 2014 - 2016 Lobo Evolution

    This program is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    verion 3 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    General License for more details.

    You should have received a copy of the GNU General Public
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
    

    Contact info: lobochief@users.sourceforge.net; ivan.difrancesco@yahoo.it
 */
package  org.lobobrowser.html;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.lobobrowser.html.domimpl.HTMLDocumentImpl;

public class HtmlNoScriptTest extends SimpleLoboTest {

    @Test
    public void basicTest() throws Exception {
        String htmlSource
            = "<html><body>\n"
            + "<form name='item' method='get'>\n"
            + "  <noscript id ='myId'>\n"
            + "    <input type=hidden name='__webpage_no_js__' value='1'>\n"
            + "  </noscript>\n"
            + "  <input type=hidden name='myParam' value='myValue'>\n"
            + "  <input type='submit' id='clickMe'>\n"
            + "</form>\n"
            + "</body></html>";

        HTMLDocumentImpl doc = loadPage(htmlSource);
        assertTrue(NOSCRIPT.equals(doc.getElementById("myId").getNodeName()));
    }
}
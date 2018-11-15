/*
    GNU GENERAL LICENSE
    Copyright (C) 2014 - 2018 Lobo Evolution

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
    

    Contact info: ivan.difrancesco@yahoo.it
 */
/*
 * Created on Oct 8, 2005
 */
package org.loboevolution.html.dombl;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.loboevolution.html.HtmlMapping;
import org.loboevolution.html.builder.HTMLElementBuilder;
import org.loboevolution.html.domimpl.DocumentImpl;
import org.loboevolution.html.domimpl.HTMLDocumentImpl;
import org.loboevolution.html.domimpl.HTMLElementImpl;
import org.loboevolution.w3c.html.HTMLElement;
import org.w3c.dom.DOMException;

/**
 * A factory for creating Element objects.
 */
public class ElementFactory {

	/** The builders. */
	private Map<String, Object> builders = new HashMap<String, Object>();
	
	/** The instance. */
	private static ElementFactory instance = new ElementFactory();

	/**
	 * Instantiates a new element factory.
	 */
	private ElementFactory() {
		this.builders = HtmlMapping.mappingHtml();
	}

	/**
	 * Gets the instance.
	 *
	 * @return the instance
	 */
	public static ElementFactory getInstance() {
		return instance;
	}

	/**
	 * Creates a new Element object.
	 *
	 * @param document
	 *            the document
	 * @param name
	 *            the name
	 * @return the HTML element
	 * @throws DOMException
	 *             the DOM exception
	 */
	public final HTMLElement createElement(DocumentImpl document, String name) throws DOMException {
		String normalName = name.toUpperCase(Locale.ENGLISH);
		// No need to synchronize; read-only map at this point.
		HTMLElementBuilder builder = (HTMLElementBuilder) this.builders.get(normalName);
		if (builder == null) {
			// TODO: IE would assume name is html text here?
			HTMLElementImpl element = new HTMLElementImpl(name);
			element.setOwnerDocument(document);
			return element;
		} else {
			return builder.create(document, name);
		}
	}
}

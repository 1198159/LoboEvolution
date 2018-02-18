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
 * Created on Dec 3, 2005
 */
package org.loboevolution.html.dombl;

import org.loboevolution.html.domimpl.DOMNodeImpl;
import org.loboevolution.js.AbstractScriptableDelegate;
import org.loboevolution.util.Objects;
import org.loboevolution.w3c.html.HTMLCollection;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * The Class ChildHTMLCollection.
 */
public class ChildHTMLCollection extends AbstractScriptableDelegate implements HTMLCollection {

	/** The root node. */
	private final DOMNodeImpl rootNode;

	/**
	 * Instantiates a new child html collection.
	 *
	 * @param node
	 *            the node
	 */
	public ChildHTMLCollection(DOMNodeImpl node) {
		super();
		rootNode = node;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.loboevolution.w3c.html.HTMLCollection#getLength()
	 */
	@Override
	public int getLength() {
		return this.rootNode.getChildCount();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.loboevolution.w3c.html.HTMLCollection#item(int)
	 */
	@Override
	public Node item(int index) {
		return this.rootNode.getChildAtIndex(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.loboevolution.w3c.html.HTMLCollection#namedItem(java.lang.String)
	 */
	@Override
	public Node namedItem(String name) {
		Document doc = this.rootNode.getOwnerDocument();
		if (doc == null) {
			return null;
		}
		// TODO: This might get elements that are not descendents.
		Node node = doc.getElementById(name);
		if (Objects.equals(node.getParentNode(), this.rootNode)) {
			return node;
		}
		return null;
	}

	/**
	 * Index of.
	 *
	 * @param node
	 *            the node
	 * @return the int
	 */
	public int indexOf(Node node) {
		return this.rootNode.getChildIndex(node);
	}
}

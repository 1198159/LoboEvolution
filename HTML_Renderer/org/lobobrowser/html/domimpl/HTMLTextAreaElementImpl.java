/*
    GNU LESSER GENERAL PUBLIC LICENSE
    Copyright (C) 2006 The Lobo Project. Copyright (C) 2014 Lobo Evolution

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

    Contact info: lobochief@users.sourceforge.net; ivan.difrancesco@yahoo.it
 */
/*
 * Created on Jan 15, 2006
 */
package org.lobobrowser.html.domimpl;

import org.lobobrowser.html.FormInput;
import org.lobobrowser.html.dombl.InputContext;
import org.lobobrowser.html.w3c.HTMLTextAreaElement;

public class HTMLTextAreaElementImpl extends HTMLBaseInputElement implements
		HTMLTextAreaElement {
	public HTMLTextAreaElementImpl(String name) {
		super(name);
	}

	public HTMLTextAreaElementImpl() {
		super("TEXTAREA");
	}

	protected FormInput[] getFormInputs() {
		String name = this.getName();
		if (name == null) {
			return null;
		}
		return new FormInput[] { new FormInput(name, this.getValue()) };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#getCols()
	 */
	public int getCols() {
		InputContext ic = this.inputContext;
		return ic == null ? 0 : ic.getCols();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#getRows()
	 */
	public int getRows() {
		InputContext ic = this.inputContext;
		return ic == null ? 0 : ic.getRows();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#getType()
	 */
	public String getType() {
		return "textarea";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#setCols(int)
	 */
	public void setCols(int cols) {
		InputContext ic = this.inputContext;
		if (ic != null) {
			ic.setCols(cols);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.lobobrowser.html.w3c.HTMLTextAreaElement#setRows(int)
	 */
	public void setRows(int rows) {
		InputContext ic = this.inputContext;
		if (ic != null) {
			ic.setRows(rows);
		}
	}
}

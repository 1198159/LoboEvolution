/*
    GNU LESSER GENERAL PUBLIC LICENSE
    Copyright (C) 2006 The Lobo Project. Copyright (C) 2014 - 2015 Lobo Evolution

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
 * Created on Jun 12, 2005
 */
package org.lobobrowser.util;

/**
 * @author J. H. S.
 */
public class NameValuePair extends AbstractBean implements Cloneable {
	public String name;
	public String value;

	public NameValuePair() {
	}

	public NameValuePair(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public void setName(String name) {
		String old = getName();
		this.name = name;
		firePropertyChange("name", old, name);
	}

	public final String getName() {
		return name;
	}

	public void setValue(String value) {
		String old = getValue();
		this.value = value;
		firePropertyChange("value", old, value);
	}

	public final String getValue() {
		return value;
	}

	@Override
	public NameValuePair clone() {
		return new NameValuePair(name, value);
	}

	@Override
	public String toString() {
		return name + "=" + value;
	}
}

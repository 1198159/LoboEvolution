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
package org.loboevolution.arraylist;

import java.util.Collection;
import java.util.Iterator;

/**
 * The Class ArrayUtilities.
 *
 * @author J. H. S.
 */
public class ArrayUtilities {
	/**
	 * Instantiates a new array utilities.
	 */
	private ArrayUtilities() {
		super();
	}

	/**
	 * Iterator.
	 *
	 * @param array
	 *            the array
	 * @param offset
	 *            the offset
	 * @param length
	 *            the length
	 * @return the iterator
	 */
	public static Iterator iterator(Object[] array, int offset, int length) {
		return new ArrayIterator(array, offset, length);
	}
	
	public static boolean isBlank(Collection<?> collection) {
		return (collection == null || collection.isEmpty());
	}
	
	public static boolean isNotBlank(Collection<?> collection) {
		return (collection != null && !collection.isEmpty());
	}
}

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

package org.loboevolution.w3c.file;

import org.w3c.dom.events.EventTarget;

/**
 * The Interface FileReader.
 */
public interface FileReader extends EventTarget {

	
	/** The Constant EMPTY. */
	public static final short EMPTY = 0;

	/** The Constant LOADING. */
	public static final short LOADING = 1;

	/** The Constant DONE. */
	public static final short DONE = 2;
	
	/**
	 * Read as array buffer.
	 *
	 * @param blob
	 *            the blob
	 */
	public void readAsArrayBuffer(Blob blob);

	/**
	 * Read as binary string.
	 *
	 * @param blob
	 *            the blob
	 */
	public void readAsBinaryString(Blob blob);

	/**
	 * Read as text.
	 *
	 * @param blob
	 *            the blob
	 */
	public void readAsText(Blob blob);

	/**
	 * Read as text.
	 *
	 * @param blob
	 *            the blob
	 * @param encoding
	 *            the encoding
	 */
	public void readAsText(Blob blob, String encoding);

	/**
	 * Read as data url.
	 *
	 * @param blob
	 *            the blob
	 */
	public void readAsDataURL(Blob blob);

	/**
	 * Abort.
	 */
	public void abort();

	/**
	 * Gets the ready state.
	 *
	 * @return the ready state
	 */
	public short getReadyState();

	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public Object getResult();

	/**
	 * Gets the error.
	 *
	 * @return the error
	 */
	public FileError getError();
}

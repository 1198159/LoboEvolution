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
package org.loboevolution.primary.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import org.loboevolution.primary.action.EditAction;

/**
 * The Class StringListControl.
 */
public class StringListControl extends JComponent {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The combo box. */
	private final JComboBox<String> comboBox;

	/** The edit list caption. */
	private String editListCaption;
	
	/** The strings. */
	private List<String> strings;

	/**
	 * Instantiates a String.valueOf list control.
	 */
	public StringListControl() {
		this.comboBox = new JComboBox<String>();
		createAndShowGUI();
	}

	private void createAndShowGUI() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.comboBox.setEditable(false);
		JButton editButton = new JButton();
		editButton.setAction(new EditAction(this));
		editButton.setText("Edit List");
		this.add(this.comboBox);
		this.add(editButton);
	}

	/**
	 * Sets the strings.
	 *
	 * @param strings
	 *            the String.valueOfs
	 */
	public void setStrings(List<String> strings) {
		this.strings = strings;
		JComboBox<String> comboBox = this.comboBox;
		comboBox.removeAllItems();
		for (String string : strings) {
			comboBox.addItem(string);
		}
	}

	/**
	 * Gets the strings.
	 *
	 * @return the strings
	 */
	public List<String> getStrings() {
		return this.strings;
	}

	/**
	 * Gets the strings as text.
	 *
	 * @return the strings as text
	 */
	public String getStringsAsText() {
		String lineSeparator = System.getProperty("line.separator");
		List<String> strings = this.strings;
		if (strings == null) {
			return null;
		}
		StringBuilder buffer = new StringBuilder();
		for (String string : strings) {
			buffer.append(string);
			buffer.append(lineSeparator);
		}
		return buffer.toString();
	}

	/**
	 * Sets the strings from text.
	 *
	 * @param text
	 *            the String.valueOfs from text
	 */
	public void setStringsFromText(String text) {
		try {
			BufferedReader reader = new BufferedReader(new StringReader(text));
			String line;
			ArrayList<String> stringsAL = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {
				stringsAL.add(line);
			}
			this.setStrings(stringsAL);
		} catch (IOException ioe) {
			throw new IllegalStateException("not expected", ioe);
		}
	}

	/**
	 * Gets the edit list caption.
	 *
	 * @return the edit list caption
	 */
	public String getEditListCaption() {
		return editListCaption;
	}

	/**
	 * Sets the edit list caption.
	 *
	 * @param caption
	 *            the new edit list caption
	 */
	public void setEditListCaption(String caption) {
		this.editListCaption = caption;
	}
}

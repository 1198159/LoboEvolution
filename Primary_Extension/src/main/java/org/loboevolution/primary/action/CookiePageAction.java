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
package org.loboevolution.primary.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.loboevolution.primary.ext.ActionPool;
import org.loboevolution.primary.ext.ComponentSource;

public class CookiePageAction extends AbstractAction implements EnableableAction {

private static final long serialVersionUID = 1L;
	
	/** The action. */
	private transient ActionPool action;
	
	/** The component source. */
	private transient ComponentSource componentSource;
	
	/**
	 * Instantiates a new source action.
	 * 
	 * @param window
	 *            the window
	 * @param action
	 *            the action
	 */
	public CookiePageAction(ComponentSource componentSource, ActionPool action) {
		this.action = action;
		this.componentSource = componentSource;
	}

	@Override
	public void updateEnabling() {
		action.setEnabled(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		componentSource.showCookiePage();	
	}	

}

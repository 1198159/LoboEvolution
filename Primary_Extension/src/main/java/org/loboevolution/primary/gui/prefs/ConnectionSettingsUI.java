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
package org.loboevolution.primary.gui.prefs;

import java.awt.Component;
import java.awt.Dimension;
import java.net.InetSocketAddress;
import java.net.Proxy;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import org.loboevolution.primary.gui.AbstractSettingsUI;
import org.loboevolution.primary.gui.FieldType;
import org.loboevolution.primary.gui.FormField;
import org.loboevolution.primary.gui.FormPanel;
import org.loboevolution.primary.gui.SwingTasks;
import org.loboevolution.primary.gui.ValidationException;
import org.loboevolution.settings.ConnectionSettings;

/**
 * The Class ConnectionSettingsUI.
 */
public class ConnectionSettingsUI extends AbstractSettingsUI {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The no proxy radio button. */
	private final JRadioButton noProxyRadioButton = new JRadioButton();

	/** The http proxy radio button. */
	private final JRadioButton httpProxyRadioButton = new JRadioButton();

	/** The socks proxy radio button. */
	private final JRadioButton socksProxyRadioButton = new JRadioButton();

	/** The authenticated check box. */
	private final JCheckBox authenticatedCheckBox = new JCheckBox();

	/** The bypass local check box. */
	private final JCheckBox bypassLocalCheckBox = new JCheckBox();

	/** The proxy host area. */
	private final Box proxyHostArea = new Box(BoxLayout.Y_AXIS);

	/** The authentication panel. */
	private final FormPanel authenticationPanel = new FormPanel();

	/** The user name field. */
	private final transient FormField userNameField = new FormField(FieldType.TEXT);

	/** The password field. */
	private final transient FormField passwordField = new FormField(FieldType.PASSWORD);

	/** The host port panel. */
	private final FormPanel hostPortPanel = new FormPanel();

	/** The host field. */
	private final transient FormField hostField = new FormField(FieldType.TEXT);

	/** The port field. */
	private final transient FormField portField = new FormField(FieldType.TEXT);

	/**
	 * Instantiates a new connection settings ui.
	 */
	public ConnectionSettingsUI() {
		createAndShowGUI();
	}
	private void createAndShowGUI() {
		this.noProxyRadioButton.addChangeListener(e -> updateEnabling());
		this.authenticatedCheckBox.addChangeListener(e -> updateEnabling());
		this.noProxyRadioButton.setText("Direct connection (no proxy)");
		this.httpProxyRadioButton.setText("HTTP proxy");
		this.socksProxyRadioButton.setText("SOCKS proxy");
		this.authenticatedCheckBox.setText("Authenticate with proxy server.");
		this.bypassLocalCheckBox.setText("Bypass proxy for local addresses.");
		this.userNameField.setCaption("User name:");
		this.passwordField.setCaption("Password:");
		this.authenticationPanel.addField(this.userNameField);
		this.authenticationPanel.addField(this.passwordField);
		this.hostField.setCaption("Host:");
		this.portField.setCaption("Port:");
		this.hostPortPanel.addField(this.hostField);
		this.hostPortPanel.addField(this.portField);

		ButtonGroup group = new ButtonGroup();
		group.add(this.noProxyRadioButton);
		group.add(this.httpProxyRadioButton);
		group.add(this.socksProxyRadioButton);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createRigidArea(new Dimension(8, 8)));
		this.add(this.getProxyBox());
		this.add(SwingTasks.createVerticalFill());
		this.loadSettings();
		this.updateEnabling();
	}

	/**
	 * Update enabling.
	 */
	private void updateEnabling() {
		SwingTasks.setNestedEnabled(this.proxyHostArea, !this.noProxyRadioButton.isSelected());
		SwingTasks.setNestedEnabled(this.authenticationPanel, this.authenticatedCheckBox.isSelected());
	}

	/**
	 * Gets the proxy box.
	 *
	 * @return the proxy box
	 */
	private Component getProxyBox() {
		Box radioBox = new Box(BoxLayout.Y_AXIS);
		radioBox.setPreferredSize(new Dimension(600, 200));
		radioBox.add(this.noProxyRadioButton);
		radioBox.add(this.httpProxyRadioButton);
		radioBox.add(this.socksProxyRadioButton);

		Box radioBoxExpander = new Box(BoxLayout.X_AXIS);
		radioBoxExpander.add(radioBox);
		radioBoxExpander.add(Box.createGlue());

		Box box = SwingTasks.createGroupBox(BoxLayout.Y_AXIS, "Proxy");
		box.add(radioBoxExpander);
		box.add(this.getProxyHostArea());
		return box;
	}

	/**
	 * Gets the proxy host area.
	 *
	 * @return the proxy host area
	 */
	private Component getProxyHostArea() {
		Box checkBoxBox = new Box(BoxLayout.Y_AXIS);
		checkBoxBox.setPreferredSize(new Dimension(600, 200));
		checkBoxBox.add(this.bypassLocalCheckBox);
		checkBoxBox.add(this.authenticatedCheckBox);

		Box checkBoxBoxExpander = new Box(BoxLayout.X_AXIS);
		checkBoxBoxExpander.add(checkBoxBox);
		checkBoxBoxExpander.add(Box.createHorizontalGlue());

		Box box = this.proxyHostArea;
		box.setBorder(new EmptyBorder(8, 16, 8, 8));
		box.add(this.hostPortPanel);
		box.add(checkBoxBoxExpander);
		box.add(this.authenticationPanel);
		return box;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.loboevolution.primary.gui.prefs.AbstractSettingsUI#restoreDefaults()
	 */
	@Override
	public void restoreDefaults() {
		ConnectionSettings settings = new ConnectionSettings();
		settings.restoreDefaults();
		this.loadSettings();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.loboevolution.primary.gui.prefs.AbstractSettingsUI#save()
	 */
	@Override
	public void save() throws ValidationException {
		ConnectionSettings settings = new ConnectionSettings();
		Proxy.Type proxyType;
		if (this.noProxyRadioButton.isSelected()) {
			proxyType = Proxy.Type.DIRECT;
		} else if (this.httpProxyRadioButton.isSelected()) {
			proxyType = Proxy.Type.HTTP;
		} else if (this.socksProxyRadioButton.isSelected()) {
			proxyType = Proxy.Type.SOCKS;
		} else {
			throw new IllegalStateException("not expected");
		}
		settings.setProxyType(proxyType);
		settings.setAuthenticated(this.authenticatedCheckBox.isSelected());
		settings.setUserName(this.userNameField.getValue());
		settings.setPassword(this.passwordField.getValue());
		settings.setDisableProxyForLocalAddresses(this.bypassLocalCheckBox.isSelected());
		String host = this.hostField.getValue();
		if ("".equals(host) && proxyType != Proxy.Type.DIRECT) {
			throw new ValidationException("To set up a proxy, a host name must be provided.");
		}
		int port;
		try {
			port = Integer.parseInt(this.portField.getValue());
		} catch (NumberFormatException nfe) {
			if (proxyType != Proxy.Type.DIRECT) {
				throw new ValidationException("The port must be a number.");
			} else {
				port = 0;
			}
		}
		InetSocketAddress socketAddress = new InetSocketAddress(host, port);
		settings.setInetSocketAddress(socketAddress);
		settings.deleteConnection();
		settings.insertConnection();
	}

	/**
	 * Load settings.
	 */
	private void loadSettings() {
		ConnectionSettings settings = ConnectionSettings.getConnection();
		switch (settings.getProxyType()) {
		case DIRECT:
			this.noProxyRadioButton.setSelected(true);
			break;
		case SOCKS:
			this.socksProxyRadioButton.setSelected(true);
			break;
		default:
			this.httpProxyRadioButton.setSelected(true);
			break;
		}
		this.authenticatedCheckBox.setSelected(settings.isAuthenticated());
		this.userNameField.setValue(settings.getUserName());
		this.passwordField.setValue(settings.getPassword());
		this.bypassLocalCheckBox.setSelected(settings.isDisableProxyForLocalAddresses());
		InetSocketAddress socketAddress = settings.getInetSocketAddress();
		if (socketAddress == null) {
			this.hostField.setValue("");
			this.portField.setValue("");
		} else {
			this.hostField.setValue(socketAddress.getHostName());
			this.portField.setValue(String.valueOf(socketAddress.getPort()));
		}
		this.authenticationPanel.revalidate();
		this.hostPortPanel.revalidate();
	}
}

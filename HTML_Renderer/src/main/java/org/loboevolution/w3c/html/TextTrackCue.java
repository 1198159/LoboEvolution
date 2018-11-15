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

package org.loboevolution.w3c.html;

import org.w3c.dom.DocumentFragment;

/**
 * The Interface TextTrackCue.
 */
public interface TextTrackCue {

	/**
	 * Gets the track.
	 *
	 * @return the track
	 */
	public TextTrack getTrack();

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId();

	/**
	 * Gets the start time.
	 *
	 * @return the start time
	 */
	public double getStartTime();

	/**
	 * Gets the end time.
	 *
	 * @return the end time
	 */
	public double getEndTime();

	/**
	 * Gets the pause on exit.
	 *
	 * @return the pause on exit
	 */
	public boolean getPauseOnExit();

	/**
	 * Gets the direction.
	 *
	 * @return the direction
	 */
	public String getDirection();

	/**
	 * Gets the snap to lines.
	 *
	 * @return the snap to lines
	 */
	public boolean getSnapToLines();

	/**
	 * Gets the line position.
	 *
	 * @return the line position
	 */
	public int getLinePosition();

	/**
	 * Gets the text position.
	 *
	 * @return the text position
	 */
	public int getTextPosition();

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize();

	/**
	 * Gets the alignment.
	 *
	 * @return the alignment
	 */
	public String getAlignment();

	/**
	 * Gets the cue as source.
	 *
	 * @return the cue as source
	 */
	public String getCueAsSource();

	/**
	 * Gets the cue as html.
	 *
	 * @return the cue as html
	 */
	public DocumentFragment getCueAsHTML();

}

/*
 * @(#)StandardBuffer.java - temporary buffer of any data
 *
 * Copyright (c) 2004-2005 by dvb.matt, All Rights Reserved. 
 * 
 * This file is part of ProjectX, a free Java based demux utility.
 * By the authors, ProjectX is intended for educational purposes only, 
 * as a non-commercial test project.
 * 
 *
 * This program is free software; you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

package net.sourceforge.dvb.projectx.io;

import java.io.*;

public class StandardBuffer extends Object {

	private ByteArrayOutputStream buf = null;
	private int id;
	private int type;

	public StandardBuffer()
	{
		buf = new ByteArrayOutputStream();
		id = 0;
	}

	public StandardBuffer(int val1)
	{
		buf = new ByteArrayOutputStream();
		id = val1;
	}

	public int getType()
	{
		return type;
	}

	public void write(byte data[]) throws IOException
	{
		buf.write(data);
	}

	public void write(byte data[], int offset, int length) throws IOException
	{
		buf.write(data, offset, length);
	}

	public byte[] getData() throws IOException
	{
		buf.flush();
		return buf.toByteArray();
	}

	public void reset()
	{
		buf.reset();
	}
}

package fr.skyforce77.tmnet.pipes;

import fr.skyforce77.tmnet.packet.Packet;

/**
* <h1> PacketPipe class <h1>
* ...
* @author Skyforce77
* @since 2016-11-05
*/
public interface PacketPipe 
{
	/**
	* @param data - ...
	*/
	public void in(Packet data);
	/**
	* @param data - ...
	*/
	public void out(Packet data);

}

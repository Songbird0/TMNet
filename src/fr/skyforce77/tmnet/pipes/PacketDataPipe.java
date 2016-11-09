package fr.skyforce77.tmnet.pipes;

import fr.skyforce77.tmnet.packet.PacketData;

/**
* <h1> PacketDataPipe interface <h1>
* ...
* @author Skyforce77
* @since 2016-11-05
*/
public interface PacketDataPipe 
{
	
	/**
	* @param data - ...
	*/
	public void in(PacketData data);
	/**
	* @param data - ...
	*/
	public void out(PacketData data);

}

package fr.skyforce77.tmnet.pipes;

import fr.skyforce77.tmnet.packet.Packet;

public interface PacketPipe {
	
	public void in(Packet data);
	public void out(Packet data);

}

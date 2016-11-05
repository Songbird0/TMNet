package fr.skyforce77.tmnet.pipes;

import fr.skyforce77.tmnet.packet.Packet;

public interface PacketPipe<T extends Packet> {
	
	public T in(T data);
	public T out(T data);

}

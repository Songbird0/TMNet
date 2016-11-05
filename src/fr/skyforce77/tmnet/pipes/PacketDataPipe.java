package fr.skyforce77.tmnet.pipes;

import fr.skyforce77.tmnet.packet.PacketData;

public interface PacketDataPipe {
	
	public void in(PacketData data);
	public void out(PacketData data);

}

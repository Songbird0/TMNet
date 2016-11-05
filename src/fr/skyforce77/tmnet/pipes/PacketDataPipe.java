package fr.skyforce77.tmnet.pipes;

public interface PacketDataPipe {
	
	public byte[] in(byte[] data);
	public byte[] out(byte[] data);

}

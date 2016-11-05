package fr.skyforce77.tmnet.layers;

public interface PacketLayer {
	
	public byte[] in(byte[] data);
	public byte[] out(byte[] data);

}

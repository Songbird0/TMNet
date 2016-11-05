package fr.skyforce77.tmnet.packet;

public class PacketData {
	
	private String clazz;
	private byte[] bytes;
	
	public PacketData(String clazz, byte[] bytes) {
		this.clazz = clazz;
		this.bytes = bytes;
	}

	public String getOriginalClass() {
		return clazz;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

}

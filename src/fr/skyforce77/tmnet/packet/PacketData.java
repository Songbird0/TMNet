package fr.skyforce77.tmnet.packet;

/**
* <h1> PacketData class <h1>
* ...
* @author Skyforce77
* @since 2016-11-05
*/
public class PacketData 
{
	
	/**
	* clazz attribute.
	*/
	private String clazz;
	/**
	* bytes attribute.
	*/
	private byte[] bytes;
	
	/**
	* PacketData constructor
	* @param clazz - description
	* @param bytes - description
	*/
	public PacketData(String clazz, byte[] bytes) 
	{
		assert(clazz != null, "clazz binding is null.");
		assert(!clazz.isEmpty,"clazz string is empty.");
		assert(bytes != null, "bytes binding is null.");
		assert(bytes.length > 0, "bytes array is empty."); /*avoid invalidation*/
		this.clazz = clazz;
		this.bytes = bytes;
	}

	/**
	* @return String instance
	*/
	public String getOriginalClass() {
		return clazz;
	}

	/**
	* Get bytes attribute.
	* @return A bytes array
	*/
	public byte[] getBytes() {
		return bytes;
	}

	/**
	* Set bytes attribute.
	* @param bytes - A bytes array.
	*/
	public void setBytes(byte[] bytes) 
	{
		assert(bytes != null, "bytes binding is null.");
		assert(bytes.length > 0, "bytes array is empty."); /*avoid invalidation*/
		this.bytes = bytes;
	}

}

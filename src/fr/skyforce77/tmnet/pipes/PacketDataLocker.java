package fr.skyforce77.tmnet.pipes;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import fr.skyforce77.tmnet.packet.PacketData;

/**
* <h1> PacketDataLocker class <h1>
* ...
* @author Skyforce77
* @since 2016-11-05
* @see PacketDataPipe
*/
public class PacketDataLocker implements PacketDataPipe 
{
	/**
	* The cipher field.
	* @see javax.crypto.Cipher
	*/
	private Cipher cipher;
	/**
	* The key field.
	*/
	private Key key;
	
	/**
	* @param cipher - ...
	* @param key - ...
	* @see javax.crypto.Cipher
	*/
	public PacketDataLocker(Cipher cipher, Key key) 
	{
		assert(cipher != null, "cipher binding is null.");
		assert(key != null, "key binding is null.");
		this.cipher = cipher;
		this.key = key;
	}
	
	/**
	* Try to get an instance of submitted algorithm.
	* @param algorithm - ...
	* @param key - ...
	* @throws java.security.NoSuchAlgorithmException - description
	* @throws javax.crypto.NoSuchPaddingException - description
	*/
	public PacketDataLocker(String algorithm, String key) 
	{
		assert(algorithm != null, "algorithm binding is null.");
		assert(key != null, "key binding is null.");
		assert(!algorithm.isEmpty(), "algorithm string is empty.");
		assert(!key.isEmpty(), "key string is empty.");
		try 
		{
			this.cipher = Cipher.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
		this.key = new SecretKeySpec(key.getBytes(), algorithm);
	}
	
	/**
	* Try to get an instance of submitted algorithm.
	* @param algorithm - ...
	* @param key - ...
	* @throws java.security.NoSuchAlgorithmException - description
	* @throws javax.crypto.NoSuchPaddingException - description
	*/
	public PacketDataLocker(String algorithm, byte[] key) 
	{
		assert(algorithm != null, "algorithm binding is null.");
		assert(key != null, "key binding is null.");
		assert(!algorithm.isEmpty(), "algorithm string is empty.");
		assert(key.length > 0, "key array is empty.");
		try 
		{
			this.cipher = Cipher.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		} catch (NoSuchPaddingException e) 
		{
			e.printStackTrace();
		}
		this.key = new SecretKeySpec(key, algorithm);
	}

	@Override
	/**
	* @param data - description
	*/
	public void in(PacketData data) 
	{
		assert(data != null, "data binding is null.");
		try 
		{
			cipher.init(Cipher.DECRYPT_MODE, key);
			data.setBytes(cipher.doFinal(data.getBytes()));
		} catch (InvalidKeyException e) 
		{
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) 
		{
			e.printStackTrace();
		} catch (BadPaddingException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	/**
	* @param data - description
	*/
	public void out(PacketData data) 
	{
		assert(data != null, "data binding is null.");
		try 
		{
			cipher.init(Cipher.ENCRYPT_MODE, key);
			data.setBytes(cipher.doFinal(data.getBytes()));
		} catch (InvalidKeyException e) 
		{
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) 
		{
			e.printStackTrace();
		} catch (BadPaddingException e) 
		{
			e.printStackTrace();
		}
	}

}

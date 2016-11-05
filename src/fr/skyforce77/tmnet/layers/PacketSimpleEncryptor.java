package fr.skyforce77.tmnet.layers;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class PacketSimpleEncryptor implements PacketLayer {
	
	private Cipher cipher;
	private Key key;
	
	public PacketSimpleEncryptor(Cipher cipher, Key key) {
		this.cipher = cipher;
		this.key = key;
	}
	
	public PacketSimpleEncryptor(String algorithm, String key) {
		try {
			this.cipher = Cipher.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
		this.key = new SecretKeySpec(key.getBytes(), algorithm);
	}
	
	public PacketSimpleEncryptor(String algorithm, byte[] key) {
		try {
			this.cipher = Cipher.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
		this.key = new SecretKeySpec(key, algorithm);
	}

	@Override
	public byte[] in(byte[] data) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, key);
			return cipher.doFinal(data);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public byte[] out(byte[] data) {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
			return cipher.doFinal(data);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return data;
	}

}

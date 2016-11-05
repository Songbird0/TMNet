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

public class PacketDataLocker implements PacketDataPipe {
	
	private Cipher cipher;
	private Key key;
	
	public PacketDataLocker(Cipher cipher, Key key) {
		this.cipher = cipher;
		this.key = key;
	}
	
	public PacketDataLocker(String algorithm, String key) {
		try {
			this.cipher = Cipher.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
		this.key = new SecretKeySpec(key.getBytes(), algorithm);
	}
	
	public PacketDataLocker(String algorithm, byte[] key) {
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
	public void in(PacketData data) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, key);
			data.setBytes(cipher.doFinal(data.getBytes()));
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void out(PacketData data) {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
			data.setBytes(cipher.doFinal(data.getBytes()));
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
	}

}

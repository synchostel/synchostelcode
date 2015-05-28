package cl.encumming.synchostel.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Formatter;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

import org.springframework.security.core.token.Sha512DigestUtils;

public class Encryptor {
	private Cipher cipherDecrypt;
	private Cipher cipherEncrypt;

	public Encryptor() {
		try {
			String passPhrase = loadProperties("passEncrypt");
			SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
			sr.setSeed(passPhrase.getBytes("UTF8"));
			KeyGenerator kGen = KeyGenerator.getInstance("DESEDE");
			kGen.init(168, sr);
			Key key = kGen.generateKey();

			cipherEncrypt = Cipher.getInstance("DESEDE/ECB/PKCS5Padding");
			cipherEncrypt.init(Cipher.ENCRYPT_MODE, key);
			cipherDecrypt = Cipher.getInstance("DESEDE/ECB/PKCS5Padding");
			cipherDecrypt.init(Cipher.DECRYPT_MODE, key);
		} catch (UnsupportedEncodingException e) {
		} catch (NoSuchPaddingException e) {
		} catch (NoSuchAlgorithmException e) {
		} catch (InvalidKeyException e) {
		}
	}

	public String loadProperties(String key) {
		Properties props = new Properties();

		InputStream is = null;

		try {
			is = Encryptor.class.getResourceAsStream("/config/config.properties");
			props.load(is);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return props.getProperty(key);
	}

	public String encriptar(String str) {
		try {
			return StringUtils.byte2hex(cipherEncrypt.doFinal(str.getBytes("UTF8")));
		} catch (UnsupportedEncodingException e) {
		} catch (BadPaddingException e) {
		} catch (IllegalBlockSizeException e) {
		}

		return null;
	}

	public String desencriptar(String str) {
		try {
			return new String(cipherDecrypt.doFinal(StringUtils.hex2byte(str)), "UTF8");
		} catch (UnsupportedEncodingException e) {
		} catch (BadPaddingException e) {
		} catch (IllegalBlockSizeException e) {
		}

		return null;
	}
	
	public static String sha1(String str){
		String sha1 = "";
	    try
	    {
	        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	        crypt.reset();
	        crypt.update(str.getBytes("UTF-8"));
	        sha1 = StringUtils.byte2hex(crypt.digest());
	    }
	    catch(NoSuchAlgorithmException e)
	    {
	        e.printStackTrace();
	    }
	    catch(UnsupportedEncodingException e)
	    {
	        e.printStackTrace();
	    }
	    return sha1;
	}
	
	public static String sha512(String str){
		return Sha512DigestUtils.shaHex(str);
	}
}

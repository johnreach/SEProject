/*
 * SHA1Hasher.java
 *
 * Created on June 4, 2003, 10:19 PM
 */

package org.gudy.azureus;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/**
 * A SHA-1 hasher used to check pieces.
 *
 * @author  TdC_VgA
 */
public class SHA1Hasher {
	private MessageDigest _messageDigest = null;
    
    /** Creates a new instance of SHA1Hasher */
    public SHA1Hasher() throws java.security.NoSuchAlgorithmException
    {
		_messageDigest = MessageDigest.getInstance("SHA-1");
    }
    
    public byte[] calculateHash(byte[] bytes){
		byte[] hash = null;				
		_messageDigest.update(bytes);
		return hash = _messageDigest.digest();
    }
    
    public byte[] calculateHash(ByteBuffer buffer) {
    byte[] hash = null;
    //Temp stores the current buffer's position
    int position = buffer.position();
    while(buffer.hasRemaining())
    {        
     _messageDigest.update(buffer.get());
    }
    //Restores the buffer's position
    buffer.position(position);
    return hash = _messageDigest.digest();
    }
}
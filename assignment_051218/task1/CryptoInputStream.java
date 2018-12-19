package assignment_051218.task1;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CryptoInputStream extends FilterInputStream {

    private byte[] key;
    private int bytesCounter = 0;

    protected CryptoInputStream(byte[] key, InputStream in) {
        super(in);
        this.key = key;
    }

    @Override
    public int read() throws IOException {
//        return super.read();

        int nextByte = super.read();
//        xor_encrypted[i] = (byte) (sourceBytes[i] ^ key[i % key.length]);
        nextByte = nextByte ^ key[bytesCounter++ % key.length];
        return nextByte;
    }
}
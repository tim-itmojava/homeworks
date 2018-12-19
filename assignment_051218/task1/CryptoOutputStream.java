package assignment_051218.task1;

import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CryptoOutputStream extends FilterOutputStream {

    private byte[] key;
    private int bytesCounter = 0;

    public CryptoOutputStream(byte[] key, OutputStream out) {
        super(out);
        this.key = key;
    }

    @Override
    public void write(int b) throws IOException {
        b = b^key[bytesCounter%key.length];
        bytesCounter++;
        super.write(b);
    }

}

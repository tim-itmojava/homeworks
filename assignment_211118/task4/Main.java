package assignment_211118.task4;

import assignment_211118.task1.CopyingFileUI;

import java.io.*;
import java.util.Arrays;

public class Main {


    public static byte[] streamingBytes(File file, int buffer) throws IOException {

        try (
                // Opening a stream for reading byte-level data from the source file with buffered access
                InputStream in = new BufferedInputStream(new FileInputStream(file));

                // Capturing read data into a stream to output via an array of bytes
                ByteArrayOutputStream bout = new ByteArrayOutputStream()
        ) {

            byte[] buf = new byte[buffer];

            int length;
            long bytes, buffers;
            bytes = buffers = 0;

            byte[] readStream = new byte[0];

            try {
                while ((length = in.read(buf)) > 0) {

                    bytes += length;        // bytes read from the source

                    bout.write(buf, 0, length);     // writing bytes read into byte array output stream
                }

                buffers = bout.toByteArray().length;    // getting the total of the bytes copied
                readStream = bout.toByteArray();
                Do.show(readStream);
                Arrays.sort(readStream);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                return readStream;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        File source;

        CopyingFileUI aTask = new CopyingFileUI();

        source = aTask.defineFile();

        byte[] output = Main.streamingBytes(source, 256);
        System.out.println(Arrays.toString(output));

    }
}

class Do {

    private static long byteCounter = 0;
    private static long containerCounter = 0;

    public static void show(byte[] buf) {

        containerCounter++;

        System.out.println("Just printing out first 15 bytes in the 0xFF format to ensure the sorting works");
        for (byte e:buf
        ) {
            byteCounter++;
            if (byteCounter < 15)
            System.out.println(String.format("%8s", Integer.toBinaryString(e & 0xFF)).replace(' ', '0'));
        }
    }

    public static long getByteCounter() {
        return byteCounter;
    }
}
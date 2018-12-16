package assignment_211118.task3;

import java.io.*;

public class XORencryption extends XORbasic {

    public File encryptFile(File file, String aKey) throws IOException {

        byte[] key = aKey.getBytes();
        String trgPathString;

        trgPathString = super.pathMutator(file,"Encryption of - ");

        System.out.println(trgPathString);

        try(
                // Opening a stream for reading byte-level data from the source file with buffered access
                InputStream in1 = new BufferedInputStream(new FileInputStream(file));
                ByteArrayOutputStream bout1 = new ByteArrayOutputStream();
                OutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(trgPathString), false));
        ) {
            System.out.println("The source file name is: " + file.getPath());
            System.out.println("The encrypted file name is: " + trgPathString);

            byte[] buf = new byte[2048];
            int length; long byte1, bytes; byte1=bytes = 0;
            try {
                while ((length = in1.read(buf)) > 0) {
                    bout1.write(buf, 0, length);
                    byte1 += length;
//                    System.out.println("The original length is: " + byte1);
//                    System.out.println(Arrays.toString(bout1.toByteArray()));
                }
            }
            catch (Exception e) {
                System.out.println("Exception triggered...");
            }
            System.out.println("File read successfully...");
            System.out.println("The length of the output stream was: " + bout1.toByteArray().length);

            byte[] xor_encrypted = new byte[bout1.toByteArray().length];
            byte[] sourceBytes = bout1.toByteArray();
            System.out.println("Number of bytes the output stream comes to: " + bout1.toByteArray().length);

            for (int i = 0; i < sourceBytes.length; i++) {
                xor_encrypted[i] = (byte) (sourceBytes[i] ^ key[i % key.length]);
                //System.out.println("Encrypted " + i + "  byte hashed: " + xor_encrypted[i]);
            }

            bout1.reset();
            bout1.write(xor_encrypted,0,xor_encrypted.length);

            System.out.println("The length of the encrypted file is: " + xor_encrypted.length);

            bout1.writeTo(out);
        }

        return new File(trgPathString);
    }
}

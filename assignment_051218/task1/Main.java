package assignment_051218.task1;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        byte[] password = "password".getBytes();

        System.out.println(new File("my_file.txt").getAbsolutePath());

        try (InputStream in = new CryptoInputStream(password, new FileInputStream(new File("file1.txt")));
             OutputStream out = new CryptoOutputStream(password, new FileOutputStream("file2.txt"))) {
            byte[] buf = new byte[512];
            while ((in.read(buf)) > 0) {
                out.write(buf);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream in = new CryptoInputStream(password, new FileInputStream(new File("file2.txt")));
             OutputStream out = new CryptoOutputStream(password, new FileOutputStream("file3.txt"))) {
            byte[] buf = new byte[512];
            while ((in.read(buf)) > 0) {
                out.write(buf);
            }
        }
    }
}

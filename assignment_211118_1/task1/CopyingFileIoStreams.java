package assignment_211118_1.task1;

import java.io.*;

public class CopyingFileIoStreams {

    private File file;
    private String destination;
    private int buffer = 1024;
    private long bytes = 0;
    private boolean copyingSuccess;

    private CopyingFileIoStreams(File file, String destination, int buffer) throws IOException {
        this.file = file;
        this.destination = destination;
        this.buffer = buffer;
    }

    public static void streamingBytes(File file, String destination, int buffer) throws IOException {

        CopyingFileIoStreams CopyCmd = new CopyingFileIoStreams(file, destination, buffer);

        try(
                // Opening a stream for reading byte-level data from the source file with buffered access
                InputStream in = new BufferedInputStream(new FileInputStream(CopyCmd.file));

                // Capturing read data into a stream to output via an array of bytes
                ByteArrayOutputStream bout = new ByteArrayOutputStream();

                // Opening an output stream to write byte-level data into a target copy of the file
                OutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(CopyCmd.destination.concat(CopyCmd.file.getName())), false));
                // No need to create another buffer of data - just streaming what was read straight away
        ) {

            byte[] buf = new byte[CopyCmd.buffer];

            int length; long bytes, buffers; bytes= buffers= 0;

            try {
                while ((length = in.read(buf)) > 0) {

                    bytes += length;        // bytes read from the source
                    Do.show(buf);

                    bout.write(buf, 0, length);     // writing bytes read into byte array output stream
                }

                bout.writeTo(out);                      // writing data from output stream to the destination file (a copy)
                buffers = bout.toByteArray().length;    // getting the total of the bytes copied

                System.out.println("bytes placeholders within byte[] containers: " + Do.getByteCounter());
                System.out.println("File copied From " + CopyCmd.file.getAbsolutePath() +
                                        " To: " + CopyCmd.destination + CopyCmd.file.getName());
                System.out.println("Bytes transferred: " + bytes);
//                System.out.println("The Buffer has been in use: " + buffers);

                CopyCmd.bytes = bytes;
                CopyCmd.setCopyingSuccess(true);
            }
            catch (Exception e) {
                System.out.println("Exception triggered...");
                CopyCmd.setCopyingSuccess(false);
            }
        }
    }

    public static String[] splittingFile(int[] size, File file, String destination, int buffer) throws IOException {

        String[] coreNameSplit = file.getName().split("[.]");
//        System.out.println("coreNameSplit[0]: " + destination + "||" + coreNameSplit[0]);
        String[] fileNames = new String[3];
        fileNames[0] = destination.concat(coreNameSplit[0].concat("_1.").concat(coreNameSplit[1]));
        fileNames[1] = destination.concat(coreNameSplit[0].concat("_2.").concat(coreNameSplit[1]));
        fileNames[2] = destination.concat("NEW - ").concat(file.getName());

        try (
                // Opening a stream for reading byte-level data from the source file with buffered access
                InputStream in = new BufferedInputStream(new FileInputStream(file));
                // Capturing read data into a stream to output via an array of bytes
                ByteArrayOutputStream bout1 = new ByteArrayOutputStream();

                ByteArrayOutputStream bout2 = new ByteArrayOutputStream();
                // Opening an output stream to write byte-level data into a target copy of the file
                OutputStream out1 = new BufferedOutputStream(
                        new FileOutputStream(
                                new File(destination.
                                        concat(coreNameSplit[0].
                                                concat("_1.").
                                                concat(coreNameSplit[1]))), false));
                OutputStream out2 = new BufferedOutputStream(
                        new FileOutputStream(
                                new File(destination.
                                        concat(coreNameSplit[0].
                                                concat("_2.").
                                                concat(coreNameSplit[1]))), false));
                // No need to create another buffer of data - just streaming what was read straight away
        ) {

            byte[] buf = new byte[buffer];
            int length; long byte1, byte2, bytes; byte1=byte2=bytes = 0;

            try {
                while ((length = in.read(buf)) > 0) {
                    if (bytes <= size[0]) {
                        bout1.write(buf, 0, length);
                        byte1 += length;
                    } else {
                        bout2.write(buf, 0, length);
                        byte2 += length;
                    }
                    bytes += length;
                }
            }
            catch (Exception e) {
                System.out.println("Exception triggered...");
//
            }
            bout1.writeTo(out1);
            bout2.writeTo(out2);
            // buffers = bout.toByteArray().length;

            System.out.println("Total bytes transferred: " + bytes);
            System.out.println("File1 bytes transferred: " + byte1);
            System.out.println("File2 bytes transferred: " + byte2);
            System.out.println("Splitting succeeded - the files created are: ");
            System.out.println(fileNames[0]);
            System.out.println(fileNames[1]);

            return fileNames;
        }
    }

    void setCopyingSuccess(boolean status) {
        this.copyingSuccess = status;
    }

    boolean getCopyingSuccess() {
        return this.copyingSuccess;
    }
}

class Do {

    private static long byteCounter = 0;
    private static long containerCounter = 0;

    public static void show(byte[] buf) {

        containerCounter++;

        System.out.println("[" + containerCounter + "]" +
                String.format("%8s", Integer.toBinaryString(buf[0] & 0xFF)).replace(' ', '0'));

        for (byte e:buf
             ) {
            byteCounter++;
//            System.out.println(String.format("%8s", Integer.toBinaryString(e & 0xFF)).replace(' ', '0'));
        }
    }

    public static long getByteCounter() {
        return byteCounter;
    }
}
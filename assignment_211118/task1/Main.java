package assignment_211118.task1;

import assignment_211118.task2.HandlingFiles;
import assignment_211118.task3.XORdecryption;
import assignment_211118.task3.XORencryption;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        File source;
        String path;

        CopyingFileUI aTask = new CopyingFileUI();

        source = aTask.defineFile();
        path = aTask.defineDestinationPath();

        // making use of a static method - CopyingFileIoStreams.streamingBytes(File file, String destination, int buffer)
        CopyingFileIoStreams.streamingBytes(source,path,2048*5);

        // method signature for public static String[] splittingFile(int[] size, File file, String destination, int buffer)
        String[] fileNames = CopyingFileIoStreams.
                                        splittingFile(HandlingFiles.defineHowToSplit(source), source, path, 2048);

        // method signature for recreateFile(String[] fileNames, int buffer)
        File recreated = HandlingFiles.recreateFile(fileNames, 2048);

        // passing the recreated file to the encryption code along with a pass-phrase
        XORencryption encryptionStack = new XORencryption();

        File encryptedFile = encryptionStack.encryptFile(recreated, "password");

        XORdecryption decryptionStack = new XORdecryption();
        decryptionStack.decryptFile(encryptedFile,"password");

    }
}
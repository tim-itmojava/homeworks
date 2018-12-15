package assignment_211118_1.task1;

import assignment_211118_1.task2.HandlingFiles;

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
        HandlingFiles.recreateFile(fileNames, 2048);

    }
}

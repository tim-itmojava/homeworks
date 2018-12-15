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

//        source = aTask.defineFile();
//        path = aTask.defineDestinationPath();

//        System.out.println(Arrays.toString(HandlingFiles.defineHowToSplit(source)));

        // method signature for public static String[] splittingFile(int[] size, File file, String destination, int buffer)
        CopyingFileIoStreams.splittingFile(HandlingFiles.defineHowToSplit(source), source, path, 2048);

/*


        // Splitting the file designated earlier as the copy of source
        String[] fileNames;
        fileNames = CopyCmd.SplittingFile(CopyCmd.defineHowToSplit());

        // Reconstructing the parts back into whole
        GluingFiles restoredFile = new GluingFiles(fileNames,2048);
        File file = restoredFile.recreateFile();
**/

    }
}

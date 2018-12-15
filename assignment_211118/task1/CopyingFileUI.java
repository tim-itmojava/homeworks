package assignment_211118.task1;

import java.io.File;
import java.util.Scanner;

public class CopyingFileUI {
    File file = null;
    String destination;
    Scanner scanner;

    public String getDestination() {
        return this.destination;
    }

    public File getFile() {
        return file;
    }

    protected File defineFile() {
        String filename;
        File tempFile;

        while(true) {

            System.out.println("Please enter a filename of the file to copy");
            Scanner scanner = new Scanner(System.in);
            filename = scanner.nextLine();

            try {
                tempFile = new File(filename);
                if (tempFile.isFile() && tempFile.canRead()) {
                    System.out.println("The file entered exists and ready to be copied");
                    System.out.println("Its canonical path is :" + tempFile.getCanonicalPath());
                    System.out.println("Its absolute path is :" + tempFile.getAbsolutePath());

                    this.file = tempFile;
                    this.scanner = scanner;
                    return tempFile;
                } else {
                    System.out.println("The filename entered is invalid");
                }
            } catch (Exception e) {
            }
        }
    }

    protected String defineDestinationPath() {
        String destination;
        File aCopy;

        while (true) {
            System.out.println("Please enter a destination folder to copy the file in the format ending with back slash");
            destination = scanner.nextLine();
            if(!destination.isEmpty()) {

                try {
                    aCopy = new File(destination);
                    if(aCopy.isDirectory() && !this.file
                                                    .getAbsolutePath()
                                                    .replace(this.file.getPath(),"")
                                                    .equals(destination)) {
                        System.out.println("The destination directory is: " + aCopy.toPath().normalize());
                        this.destination = destination;
                        return destination;
                    }
                    else {
                        if(this.file.getAbsolutePath().replace(this.file.getPath(),"").equals(destination)) {
                            System.out.println("You cannot copy the file in the same folder...");
                        }
                        System.out.println("Please enter a valid destination folder");
                        System.out.println(aCopy.isDirectory());
                        System.out.println("The destination directory is: " + aCopy.toPath().normalize());
                        if(destination.equals("exit")) return null;
                    }
                }
                catch (Exception e) {
                    System.out.println("Failed to access the destination resource");
                }
            }
        }
    }
}

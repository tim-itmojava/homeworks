package assignment_211118.task3;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public abstract class XORbasic {

    public String pathMutator(File file, String embedding) {

        // handling with creating a name for the encrypted file
        String[] srcFilePathParts = splitPath(file.getAbsolutePath());

//        System.out.println("I am here: " + Arrays.toString(srcFilePathParts));

        LinkedList<String> trgFilePathParts = new LinkedList<>();
        int srcIndex = srcFilePathParts.length;

        for(String e : srcFilePathParts) {
            trgFilePathParts.add(e);
        }
        trgFilePathParts.add(srcIndex - 1, embedding);

        for(int i = 1; i <= srcIndex - 1; i++) {
            trgFilePathParts.add(i*2 - 1,"/");
        }
        StringBuilder trgPathString = new StringBuilder();

        for (String e:trgFilePathParts
        ) {
            trgPathString.append(e);
        }
//        System.out.println("from the encryption module: " + trgPathString.toString());
        return trgPathString.toString();
    }

    public static String[] splitPath(String path) {

        System.out.println(path);

        String backslash = ((char)47) + "";
        if (path.contains(backslash)) {

            ArrayList<String> parts = new ArrayList<>();
            int start = 0;
            int end = 0;

            for ( int c : path.toCharArray() ) {
                if (c == 47) {
                    parts.add(path.substring(start, end));
                    start = end + 1;
                }
                end++;
            }

            parts.add(path.substring(start));

            return parts.toArray( new String[parts.size()] );
        }
        else {
            return path.split("/");
        }
    }
}
package np.plagiarism;

import java.io.*;
import java.util.HashMap;

/**
 * Created by nishanth on 10/15/2016.
 */

public class SynSet {

    HashMap<String, String> belongs = new HashMap();

    public void store(String synonym_file) {

        BufferedReader br = Parser.fileRead(synonym_file);

        String line = null;
        String[] words;
        int counter = 0;

        try {
            while ((line = br.readLine()) != null) {

                words = line.split("\\s+");

                for(int i = 0; i < words.length; i++) {
                    belongs.put(words[i], "[" + Integer.toString(counter) + "]");
                }
                counter++;
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

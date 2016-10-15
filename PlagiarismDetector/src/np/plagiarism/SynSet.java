package np.plagiarism;

import java.io.*;
import java.util.HashMap;

/**
 * Created by nishanth on 10/15/2016.
 */

public class SynSet {

    HashMap<String, String> belongs = new HashMap();

    public void store(String synonym_file) {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(synonym_file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Construct BufferedReader from InputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

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

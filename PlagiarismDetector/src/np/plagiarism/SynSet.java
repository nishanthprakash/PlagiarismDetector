package np.plagiarism;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by nishanth on 10/15/2016.
 */

public class SynSet {

    HashMap<String, Integer> belongs = new HashMap();

    public void store(String synonym_file) {

        FileInputStream fis = new FileInputStream(synonym_file);

        //Construct BufferedReader from InputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = null;
        String[] words;
        int num_words;
        int counter = 0;

        while ((line = br.readLine()) != null) {

            words = line.split("\\s+");
            num_words = words.length();

            for(int i = 0; i < num_words; i++) {
                belongs.add(i.next(), counter);
            }
            counter++;
        }

        br.close();
    }
}

package np.plagiarism;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Takes care of parsing the files input and the manuscript
 *
 * Created by nishanth on 10/14/2016.
 */
public class Parser {

    private String[] cleanString(String file) {
        return file.replaceAll("[^0-9a-zA-Z ]", "").toLowerCase().split("\\s+");
    }


    /**
     * Parse does both the task of parsing the manuscript as well as check amount of content
     * used from input file(s), depending on the last parameter rep
     *
     * @param file
     * @param tuple_len
     * @param synonyms
     * @param man
     * @param rep : if this is null then it means we are processing the manuscript
     *              otherwise, a report is passed to collect data about amount of i/p file
     *              used in the manuscript
     */
    public void parse(String file, int tuple_len, SynSet synonyms, Manuscript man, Report rep){

        BufferedReader br = fileRead(file);

        int current, noOfTups = 0, fudges = 0, wordsSize = 0;
        String line = null;
        List<String> words = new ArrayList<String>();

        try {
            while ((line = br.readLine()) != null) {

                words.addAll(new ArrayList<String>(Arrays.asList(cleanString(line))));
                wordsSize = words.size();

                String encoded;
                for (int i = 0; i + tuple_len - 1 < wordsSize; i++ ){
                    encoded = encodedTupleAt(words, i, synonyms, tuple_len);
                    if( rep == null ){
                        current = 0;
                        if ( man.encodes.containsKey(encoded)){
                            current = man.encodes.get(encoded);
                        }
                        man.encodes.put(encoded, current + 1);
                    }
                    else {
                        if (man.encodes.containsKey(encoded)) {
                            fudges++;
                        }
                    }
                    noOfTups++;
                }
                if (rep == null) {
                    man.setTupleCount(noOfTups);
                }
                else {
                    rep.setFudgeCount(fudges);
                    rep.setTupleCount(noOfTups);
                }
                words.subList(0, wordsSize - tuple_len).clear();
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String encodedTupleAt(List<String> words, int i, SynSet synonyms, int tuple_len){

        String encodedTuple = "";
        for (int j = 0; j < tuple_len; j++){
            encodedTuple += synonyms.belongs.containsKey( words.get( i + j )) ?
                    synonyms.belongs.get( words.get( i + j )) : words.get( i + j );
            encodedTuple += " ";
        }
        return encodedTuple;
    }


    /**
     * To abstract away the details of reading files - used by SynSet and Parser
     *
     * @param file
     * @return
     */
    public static BufferedReader fileRead(String file){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Construct BufferedReader from InputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        return br;
    }

}

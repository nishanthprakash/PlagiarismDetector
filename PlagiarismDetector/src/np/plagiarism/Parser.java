package np.plagiarism;


/**
 * Created by nishanth on 10/14/2016.
 */
public class Parser {

    private String[] cleanFile(String file) {
        return file.replaceAll("[^0-9a-zA-Z ]", "").toLowerCase().split("\\s+");
    }

    public void parse(String file, int tuple_len, SynSet synonyms, Manuscript man, Report rep){

        String[] words = cleanFile(file);
        int current;
        int noOfTups = 0;

        int fudges = 0;
        String encoded;

        for (int i = 0; i + tuple_len - 1 < words.length; i++ ){

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
    }

    private String encodedTupleAt(String[] words, int i, SynSet synonyms, int tuple_len){

        String encodedTuples = "";
        for (int j = 0; j < tuple_len; j++){
            encodedTuples += synonyms.belongs.containsKey( words[ i + j ]) ?
                    synonyms.belongs.get( words[ i + j ]) : words[ i + j ];
            encodedTuples += " ";
        }
    }
}

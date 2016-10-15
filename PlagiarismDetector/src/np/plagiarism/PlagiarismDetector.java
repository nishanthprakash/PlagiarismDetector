/**
 * Created by nishanth on 10/14/2016.
 */

package np.plagiarism;

import java.util.ArrayList;
import java.util.List;

public class PlagiarismDetector {

    // args and defaults
    private static final int REQUIRED_ARG_LEN = 4;
    private static final int SYNONYM_FILE_INDEX = 1;
    private static final int MANUSCRIPT_INDEX = 2;
    private static final int INPUT_FILE_INDEX = 3;
    private static final int TUPLE_SIZE_INDEX = 4;

    private static final int DEFAULT_TUPLE_LEN = 3;

    static String theManual =     "\nUSAGE: Please input 3 arguments!\n\n"
                                + "PLAGIARISM DETECTOR\n"
                                + "-------------------\n\n"
                                + "SYNOPSIS\n\n"
                                + "    PlagiarismDetector SYNONYM_FILE_NAME MANUSCRIPT INPUT_FILE [ TUPLE_SIZE ]\n\n"
                                + "DESCRIPTION:\n\n"
                                + "This is a program that checks for plagiarism between two given files\n"
                                + "using another file containing sets of synonym functions \n\n"
                                + "SYNONYM_FILE_NAME is a file name of a file containing a list of synonyms where each\n"
                                + "    where each line contains a set of interchangeably synonymous words\n\n"
                                + "MANUSCRIPT is one of the two files to be compared for plagiarism\n\n"
                                + "INPUT_FILE is another of the two files to be compared for plagiarism\n\n"
                                + "TUPLE_SIZE this is an optional parameter, which is a number specifying the number of\n"
                                + "    contiguous words in a tuple that must be checked for co-occurrence\n\n";

    public static class Input {
        List<String> inputFile = new ArrayList<String>();
        String manuscript;
        String synonymFile;
        int tupleLen;
    }

    public static void main (String[] args){

        if (args.length < REQUIRED_ARG_LEN) {
            rtfm();
        }

        Input in = new Input();
        parseInput(args, args.length, in);

        DetectorEngine engine = new DetectorEngine();
        engine.run(in);
    }

    private static void parseInput(String[] args, int len, Input in){
        in.synonymFile = args[SYNONYM_FILE_INDEX];
        in.manuscript = args[MANUSCRIPT_INDEX];
        in.inputFile.add(args[INPUT_FILE_INDEX]);
        in.tupleLen = (len ==  TUPLE_SIZE_INDEX + 1) ?
                Integer.parseInt(args[TUPLE_SIZE_INDEX]): DEFAULT_TUPLE_LEN;
    }

    private static void rtfm(){
        System.out.print(theManual);
        System.exit(1);
    }
}

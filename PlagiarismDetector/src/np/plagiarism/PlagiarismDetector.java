/**
 * Created by nishanth on 10/14/2016.
 */

package np.plagiarism

import java.util.ArrayList;
import java.util.List;

public class PlagiarismDetector {

    static string theManual =     "Usage: Please input 3 arguments!\n\n"
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
        List<String> input_file = new ArrayList<String>();
        String manuscript;
        String synonym_file;
        int tuple_len;
    }

    public static void main (String[] args){

        int cli_len = args.length();
        if (cli_len < 4) {
            rtfm();
        }

        Input in = new Input();
        parseInput(args, cli_len, in);

        DetectorEngine engine = new DetectorEngine();
        engine.run(in);
    }

    private void parseInput(String[] args, int len, Input in){
        in.synonym_file  = args[1];
        in.manuscript = args[2];
        in.input_file.add(args[3]);
        in.tuple_len = len == 5 ? Integer.parseInt(args[4]): 0;
    }


    private void rtfm(){
        System.out.print(theManual);
        System.exit(1);
    }
}

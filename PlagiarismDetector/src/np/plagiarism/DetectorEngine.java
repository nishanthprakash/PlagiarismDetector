package np.plagiarism;


/**
 * Created by nishanth on 10/14/2016.
 */
public class DetectorEngine {


    public void run(PlagiarismDetector.Input in) {
        // Get the synonyms
        SynSet synonyms = new SynSet();
        synonyms.store(in.synonym_file);

        // Create the hash of file 1 tuples

        // Convert the second file tuples and hash them

        // np.plagiarism.Report percentages
    }
}

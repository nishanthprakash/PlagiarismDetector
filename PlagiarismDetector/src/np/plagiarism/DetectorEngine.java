package np.plagiarism;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishanth on 10/14/2016.
 */
public class DetectorEngine {


    public void run(PlagiarismDetector.Input in) {
        Parser fparser = new Parser();
        List<Report> reports = new ArrayList<>();

        // Get the synonyms
        obtainSynonyms(in);

        // Create the hash of manuscripts tuples
        parseManuscript(in, fparser);

        // Convert the second file tuples and hash them

        checkFudgings(in, fparser, reports);

        // Render Report
        renderReport(reports);
    }

    private void renderReport(List<Report> reports) {
    }

    private void checkFudgings(PlagiarismDetector.Input in, Parser fparser, List<Report> reports) {
        int files_no = in.input_file.size();
        Report rep;

        for(int i = 0; i < files_no; i++) {
            rep = new Report();
            fparser.check(in.input_file.get(i), rep);
            reports.add(rep);
        }
    }

    private void parseManuscript(PlagiarismDetector.Input in, Parser fparser) {
        Manuscript man = new Manuscript();
        fparser.prepManu(in.manuscript, man);
    }

    private void obtainSynonyms(PlagiarismDetector.Input in) {
        SynSet synonyms = new SynSet();
        synonyms.store(in.synonym_file);
    }
}

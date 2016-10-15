package np.plagiarism;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishanth on 10/14/2016.
 */
public class DetectorEngine {
    Parser fparser = new Parser();
    List<Report> reports = new ArrayList<>();
    SynSet synonyms = new SynSet();
    Manuscript man = new Manuscript();
    ReportRenderer renderer = new ReportRenderer();

    public void run(PlagiarismDetector.Input in) {


        // Get the synonyms
        obtainSynonyms(in);

        // Create the hash of manuscripts tuples
        parseManuscript(in);

        // Convert the second file tuples and hash them
        checkFudgings(in);

        // Render Report
        renderer.renderCLI(reports);
    }

    private void renderReport() {
    }

    private void checkFudgings(PlagiarismDetector.Input in) {
        int files_no = in.inputFile.size();
        Report rep;

        for(int i = 0; i < files_no; i++) {
            rep = new Report();
            fparser.parse(in.inputFile.get(i), in.tupleLen, synonyms, man, rep);
            reports.add(rep);
        }
    }

    private void parseManuscript(PlagiarismDetector.Input in) {
        fparser.parse(in.manuscript, in.tupleLen, synonyms, man, null);
    }

    private void obtainSynonyms(PlagiarismDetector.Input in) {
        synonyms.store(in.synonymFile);
    }
}

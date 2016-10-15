package np.plagiarism;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishanth on 10/14/2016.
 *
 * DetectorEngine orchestrates all the tasks required to be done in the
 * process of Plagiarism detection.
 */
public class DetectorEngine {
    private Parser fparser = new Parser();
    private List<Report> reports = new ArrayList<>();
    private SynSet synonyms = new SynSet();
    private Manuscript man = new Manuscript();
    private ReportRenderer renderer = new ReportRenderer();

    public void run(PlagiarismDetector.Input in) {


        // Get the synonyms
        System.out.println("Reading synonyms ... ");
        obtainSynonyms(in);

        // Create the hash of encoded manuscripts tuples
        System.out.println("Reading manuscript ... ");
        parseManuscript(in);

        // Check the input file's encoded tuples for a match in our manuscript data
        System.out.println("Checking for similar content in other file(s)... ");
        checkFudgings(in);

        // Render Report
        System.out.println("Rendering reports ... ");
        renderReport();
    }

    private void renderReport() {
        renderer.renderCLI(reports);
    }


    private void checkFudgings(PlagiarismDetector.Input in) {
        int files_no = in.inputFile.size();
        Report rep;

        for(int i = 0; i < files_no; i++) { // multiple reports passed if there are multiple input files
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

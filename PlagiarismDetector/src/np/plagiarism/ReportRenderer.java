package np.plagiarism;

import java.util.List;

/**
 * Created by nishanth on 10/15/2016.
 */
public class ReportRenderer {

    public void renderCLI(List<Report> reports) {

        int reportsCount = reports.size();

        System.out.println("The percentage amount of content in manuscript lifted from other files are:\n\n");

        for (int i = 0; i < reportsCount; i++ ){
            System.out.println("File " + i + ": " + reports.get(i).getFudgePercentage());
        }
    }
}

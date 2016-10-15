package np.plagiarism;

/**
 * Created by nishanth on 10/14/2016.
 */
public class Report {
    private int fudgeCount;
    private int tupleCount;
    private int fudgePercentage;


    public int getFudgeCount() {
        return fudgeCount;
    }

    public void setFudgeCount(int fudgeCount) {
        this.fudgeCount = fudgeCount;
    }

    public int getTupleCount() {
        return tupleCount;
    }

    public void setTupleCount(int tupleCount) {
        this.tupleCount = tupleCount;
        setFudgePercentage(fudgeCount*100/tupleCount);
    }

    public int getFudgePercentage() {
        return fudgePercentage;
    }

    public void setFudgePercentage(int fudgePercentage) {
        this.fudgePercentage = fudgePercentage;
    }
}

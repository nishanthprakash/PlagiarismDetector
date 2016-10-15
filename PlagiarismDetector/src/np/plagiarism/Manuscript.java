package np.plagiarism;

import java.util.HashMap;

/**
 * Created by nishanth on 10/14/2016.
 */
public class Manuscript {

    HashMap<String, Integer> encodes = new HashMap();

    private int tupleCount;

    public int getTupleCount() {
        return tupleCount;
    }

    public void setTupleCount(int totalTups) {
        this.tupleCount = totalTups;
    }
}

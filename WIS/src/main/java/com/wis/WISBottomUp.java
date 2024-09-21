package WIS.src.main.java.com.wis;
import java.util.Arrays;
import java.util.Comparator;

public class WISBottomUp {
    private Job[] jobs;

    public WISBottomUp(Job[] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(j -> j.end));
        this.jobs = jobs;
    }
    

    public int iterativeComputeOpt() {
        int[] M = new int[jobs.length + 1];
        M[0] = 0;

        for(int j = 1; j <= jobs.length + 1; j++){
            M[j] = Math.max(this.jobs[j-1].weight + M[p(j)], M[j-1]);
        }

    return M[jobs.length];
    }


    private int p(int j) {
        for (int i = j; i >= 0; i--) {
            if (jobs[i].end <= jobs[j].start) {
                return i;
            }
        }
        return 0;
    }
}

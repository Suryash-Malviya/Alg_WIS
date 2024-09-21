package WIS.src.main.java.com.wis;

import java.util.Arrays;

public class WISTopDown {
    private Job[] jobs;
    private int[] memo;

    public WISTopDown(Job[] jobs) {
        this.jobs = jobs;
        this.memo = new int[jobs.length + 1];
        Arrays.fill(memo, -1);
    }

    public int mComputeOpt(int j) {

        if (j == 0) {
            return 0;
        }

        else if (memo[j] != -1) {
            return memo[j];
        }

        else {
            memo[j] = Math.max(
                        this.jobs[j - 1].weight + mComputeOpt(p(j)), 
                        mComputeOpt(j - 1));
                        
            return memo[j];
        }
    }

    private int p(int j) {
        for (int i = j; i >= 0; i--) {
            if (jobs[i].end <= jobs[j].start) {
                return i;
            }
            return 0;
        }
    }
}

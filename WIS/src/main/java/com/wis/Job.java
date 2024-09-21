package WIS.src.main.java.com.wis;
class Job {
    int start;
    int end;
    int weight;

    public Job(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    public int getWeight() {
        return this.weight;
    }
}

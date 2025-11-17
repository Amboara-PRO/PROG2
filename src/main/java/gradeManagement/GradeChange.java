package gradeManagement;

import java.time.Instant;

public class GradeChange {
    private double value;
    private String reason;
    private Instant timestamp;

    public GradeChange(double value, String reason, Instant timestamp) {
        this.value = value;
        this.reason = reason;
        this.timestamp = timestamp;
    }

    public double getValue() {
        return value;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

}

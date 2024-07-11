package utils;
import java.time.Duration;

public enum WaitDuration {
    SHORT(Duration.ofSeconds(5)),
    MEDIUM(Duration.ofSeconds(10)),
    LONG(Duration.ofSeconds(20));

    private final Duration duration;

    WaitDuration(Duration duration) {
        this.duration = duration;
    }

    public Duration getDuration() {
        return duration;
    }
}

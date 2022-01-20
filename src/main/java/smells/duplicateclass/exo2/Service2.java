package smells.duplicateclass.exo2;

import java.time.LocalDateTime;

public class Service2 {

    final LocalDateTime initializationTime;

    public Service2() {
        this.initializationTime = LocalDateTime.now();
    }
}

package smells.duplicateclass.exo2;

import java.time.LocalDateTime;

public class Service1 {

    final LocalDateTime initializationTime;

    public Service1(){
        this.initializationTime=LocalDateTime.now();
    }

}

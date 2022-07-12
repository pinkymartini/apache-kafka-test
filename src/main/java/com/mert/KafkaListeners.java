package com.mert;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics="mert",
            groupId = "groupId"
    )
    void listener(String data){
        System.out.println("Listener recieved: "+ data);
    }
}

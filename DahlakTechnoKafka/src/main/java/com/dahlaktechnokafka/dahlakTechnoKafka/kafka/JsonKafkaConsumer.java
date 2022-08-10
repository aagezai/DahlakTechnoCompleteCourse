package com.dahlaktechnokafka.dahlakTechnoKafka.kafka;
import com.dahlaktechnokafka.dahlakTechnoKafka.payload.Employee;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private Employee employee;

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(Employee employee){
        this.employee = employee;
    }

    public Employee getConsumed() {
        return employee;
    }
}

package com.dahlaktechnokafka.dahlakTechnoKafka.kafka;



import com.dahlaktechnokafka.dahlakTechnoKafka.payload.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName ;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
   @Autowired
    private KafkaTemplate<String, Employee> kafkaTemplate;

    public void sendMessage(Employee employee){

        LOGGER.info("Inside of sendMessage method of JsonKafkaProducer ");

        Message<Employee> message = MessageBuilder
                .withPayload(employee)
                .setHeader(KafkaHeaders.TOPIC, topicJsonName)
                .build();
        // Header- topic//payload user

        //kafkaTemplate.send(topicJsonName,user);
        kafkaTemplate.send(message);
    }
}

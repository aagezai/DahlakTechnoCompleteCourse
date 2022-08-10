package com.dahlaktechnokafka.dahlakTechnoKafka.controller;

import com.dahlaktechnokafka.dahlakTechnoKafka.kafka.JsonKafkaConsumer;
import com.dahlaktechnokafka.dahlakTechnoKafka.kafka.JsonKafkaProducer;
import com.dahlaktechnokafka.dahlakTechnoKafka.payload.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducerJson;
    @Autowired
    private JsonKafkaConsumer jsonKafkaConsumer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducerJson = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Employee employee){
        kafkaProducerJson.sendMessage(employee);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
    @GetMapping("/consumed")
    public ResponseEntity<Employee> get(){

        Employee employee =jsonKafkaConsumer.getConsumed();


        return new ResponseEntity<>(employee,HttpStatus.ACCEPTED);
    }
}

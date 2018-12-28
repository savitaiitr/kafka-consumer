package com.example.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaConsumerApplication {
	
	// Logging
	private static final Logger logger = LogManager.getLogger(KafkaConsumerApplication.class.getName());

	public void consumeMsg() {
			
		String topicName = "SampleMessages";
		
		Properties prop = new Properties();
		//Add kafka ip in place of localhost
		//prop.put("bootstrap.servers","localhost:9092");
		prop.put("bootstrap.servers","10.131.126.77:9092");
		prop.put("group.id", "11");
		prop.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		prop.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		
		KafkaConsumer<String,String> consumer = new KafkaConsumer<>(prop);
		
		consumer.subscribe(Collections.singletonList(topicName));
		while(true){			
			
			@SuppressWarnings("deprecation")
			ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);
			
			for(ConsumerRecord<String, String> record : records ){
				logger.info("Consumer record key:" + record.key());
				logger.info("Consumer record value:" + record.value());
			}
		}
		
	}

}


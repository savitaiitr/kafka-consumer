package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.KafkaConsumer.KafkaConsumerApplication;

@RestController
public class ConsumerController {

	// Logging
	private static final Logger logger = LogManager.getLogger(ConsumerController.class.getName());

	/** KafkaConsumerApplication */
	@Autowired
	private KafkaConsumerApplication kafkaConsumerApplication;

	/**
	 * Used to send the request to Kafka Consumer
	 * 
	 * @param request
	 */
	@RequestMapping(method=RequestMethod.GET, path="/getKafkaConsumer")
	public void getKafkaConsumer(HttpServletRequest httpRequest){
		logger.info("getKafkaConsumer of ConsumerController ");
		kafkaConsumerApplication.consumeMsg();
	}

}

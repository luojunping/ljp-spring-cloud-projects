package com.ljp.test;

import com.google.common.collect.Maps;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Map;

public class KafkaTest {

	public static void main(String[] args) {
		Map<String, Object> configs = Maps.newHashMap();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "luojunping:9092,luojunping:9093,luojunping:9094");
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(configs);
		kafkaProducer.send(new ProducerRecord<>("hello", "world"));
		kafkaProducer.flush();
		kafkaProducer.close();
	}

}

package com.brilworks.kafka.processor;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventStreamProcessor {

    @Autowired
    public void streamTopology(StreamsBuilder streamsBuilder){
        KStream<String, String> kStream = streamsBuilder.stream("inputTopic",
                Consumed.with(Serdes.String(),Serdes.String())); // Consume the inputTopic as string key & String value

        kStream.filter((key, value) -> value.startsWith("Message_")) // Filter message
                .mapValues((key, value) -> value.toUpperCase()) // Transform message
                .peek((key, value) -> System.out.println("Key:" + key +" Value:"+value)) // Peak allow to perform operation and also pass to next topic
                .to("outputTopic", Produced.with(Serdes.String(),Serdes.String())); //Send transfer message to outputTopic + Keep the message key,value format as String only
    }
}

import org.apache.kafka.clients.producer.*;

import java.text.*;
import java.util.*;

public class ProducerApp {

    public static void main(String[] args){

        // Create the Properties class to instantiate the Consumer with the desired settings:
        Properties props = new Properties();
//        props.put("bootstrap.servers", "localhost:9092, localhost:9093");
//        props.put("bootstrap.servers", "rmb.Dlink:9092, rmb.Dlink:7092");
        props.put("bootstrap.servers", "ec2-34-208-1-180.us-west-2.compute.amazonaws.com:9092");
//        34.208.1.180
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        // Record Accumulator
        props.put("batch.size", 16384);
        props.put("buffer.memory", 33554432);
        props.put("linger.ms", 0);
        props.put("max.block.ms", 60000);
//         props.put("compression.type", "none");

        // Delivery Guarantees
        props.put("acks", "");
        props.put("retries", 0);
        props.put("retry.backoff.ms", 5);

        // Order Guarantees
        props.put("max.in.flight.requests.per.connection", 5);
        props.put("retry.backoff.ms", 5);

        // Challenge#1: 2 partitions, every message needs to go in all partitions.
            // producer -> msg1, msg2
            // consumer -> msg1, msg2, msg2, msg1
            // create topic with >1 partition
        // Challenge#2: guarantee order, create two producers
           // consumer -> all in LogTimeAppend

//        props.put("client.id", "");
//        props.put("max.request.size", 1048576);
//        props.put("partitioner.class", "org.apache.kafka.clients.producer.internals.DefaultPartitioner");
//        props.put("request.timeout.ms", 30000);
//        props.put("timeout.ms", 30000);



        KafkaProducer<String, String> myProducer = new KafkaProducer<String, String>(props);
        DateFormat dtFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
//        String topic = "my-topic1";
        String topic = "ms_topic";

        int numberOfRecords = 100; // number of records to send
        long sleepTimer = 0; // how long you want to wait before the next record to be sent

        try {
                for (int i = 0; i < numberOfRecords; i++ )
                    myProducer.send(new ProducerRecord<String, String>(topic, String.format("Message: %s  sent at %s", Integer.toString(i), dtFormat.format(new Date()))));
                    Thread.sleep(sleepTimer);
                    // Thread.sleep(new Random(5000).nextLong()); // use if you want to randomize the time between record sends
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myProducer.close();
        }

    }
}

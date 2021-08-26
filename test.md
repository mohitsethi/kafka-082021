
- Kafka TOol:
    - https://kafkatool.com/download.htmear
    - new web ui https://github.com/provectus/kafka-ui

- Kafka setup: t.ly/Z4gu
- 

Start kafka 1 node cluster:
- bin/zookeeper-server-start.sh
- cd config
- bin/zookeeper-server-start.sh config/zookeeper.properties
- start kafka broker:
    - bin/kafka-server-start.sh config/server.properties

- Create the topic
    - bin/kafka-topics.sh
    - bin/kafka-topics.sh --create --topic my_topic --zookeeper localhost:2181 --replication-factor 1 --partitions 1
    - bin/kafka-topics.sh --list --zookeeper localhost:2181

- Create Producer
    - bin/kafka-console-producer.sh --broker-list localhost:9092 --topic ms_topic

- Create Consumer
    - bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic ms_topic 
    - bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic ms_topic --from-beginning

- Describe Topic
    - bin/kafka-topics.sh --describe --topic my_topic --zookeeper localhost:2181
- Create a topic with >1 Replication factor
    - bin/kafka-topics.sh --create --topic my_topic --zookeeper localhost:2181 --replication-factor 2 --partitions 1

- On AWS
    - Run command `sudo apt-get update -y`
    - Install java
        `sudo apt install default-jdk`
    - Get Kafka tarball
        `wget <link to kafka>
    - change permissions
        `chmod +x <kafka tar ball>`

    - extract tarball 
        `tar xvzf <kafka tall ball>`


 localhost - 0.0.0.0 - 192.168.101.10



$ bin/kafka-producer-perf-test.sh --topic my_topic --num-records 50 --throughput 10 --producer-props bootstrap.servers=localhost:9092 key.serializer=org.apache.kafka.common.serialization.StringSerializer value.serializer=org.apache.kafka.common.serialization.StringSerializer --record-size 1


$bin/kafka-producer-perf-test.sh --topic mstopic08192021a --num-records 50 --throughput 10 --producer-props bootstrap.servers=rmb.Dlink:9092 key.serializer=org.apache.kafka.common.serialization.StringSerializer value.serializer=org.apache.kafka.common.serialization.StringSerializer --record-size 1


./bin/kafka-topics.sh --zookeeper localhost:9092 --alter --topic testKafka_5 --partitions 6

bin/kafka-producer-perf-test.sh --topic mstopic08192021b --num-records 50 --throughput 10 --producer-props bootstrap.servers=rmb.Dlink:9092 key.serializer=org.apache.kafka.common.serialization.StringSerializer value.serializer=org.apache.kafka.common.serialization.StringSerializer --record-size 1


.\kafka-producer-perf-test.bat --topic my_topic1908_1 --num-records 10 --throughput 10 --producer-props bootstrap.servers=localhost:9092 key.serializer=org.apache.kafka.common.serialization.StringSerializer value.serializer=org.apache.kafka.common.serialization.StringSerializer --record-size 1

-------------

Install confluent CLI
https://docs.confluent.io/confluent-cli/current/install.html

Starting Schema Registry
https://docs.confluent.io/4.1.1/schema-registry/docs/using.html
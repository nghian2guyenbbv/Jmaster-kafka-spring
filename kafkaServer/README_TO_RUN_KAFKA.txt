-- create zookeeper server
cd D:\NguyenNghia\kafka
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

-- create a kafka server
.\bin\windows\kafka-server-start.bat config\server.properties

-- create a topic

.\bin\windows\kafka-topics.bat --create --topic topic-example --bootstrap-server localhost:9092

-- write event into topic
.\bin\windows\kafka-console-producer.bat --topic topic-example --bootstrap-server localhost:9092

--listen event

.\bin\windows\kafka-console-consumer.bat --topic topic-example --from-beginning --bootstrap-server localhost:9092


##################################  Kafka cluster with multi brokers and Replication ##################################
Remove D://tmp folder
+ start zookepper
+ start multi kafka server with multiport 9092, 9093, 9094
1/ .\bin\windows\kafka-server-start.bat config\server.properties
2/ .\bin\windows\kafka-server-start.bat config\server.properties --override listeners=PLAINTEXT://:9093 --override broker.id=1 --override log.dirs=/tmp/kafka-logs-1
3/ .\bin\windows\kafka-server-start.bat config\server.properties --override listeners=PLAINTEXT://:9094 --override broker.id=2 --override log.dirs=/tmp/kafka-logs-2
+ 3 broker tự động join lại thành 1 cluster ?????????
+ create a topic with 2 partitions
.\bin\windows\kafka-topics.bat --create --topic topic-example --partitions 2 --replication-factor 1 --bootstrap-server localhost:9092



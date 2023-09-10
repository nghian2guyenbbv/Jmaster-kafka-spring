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

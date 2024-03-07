# follow this link to install offset explorer https://www.baeldung.com/apache-kafka#3-use-offset-explorer
The Offset Explorer (formerly: Kafka Tool) is a GUI application for managing Kafka
# run docker compose
    docker compose -f docker-compose.yml up -d
# check if images is running 
    docker ps

# move into kafka container
    docker exec -it kafka /bin/sh
    ls
    cd opt
    ls
    cd kafka_2.13-2.8.1
    ls
    cd bin
    # ls
connect-distributed.sh        kafka-dump-log.sh                    kafka-storage.sh
connect-mirror-maker.sh       kafka-features.sh                    kafka-streams-application-reset.sh
connect-standalone.sh         kafka-leader-election.sh             kafka-topics.sh
kafka-acls.sh                 kafka-log-dirs.sh                    kafka-verifiable-consumer.sh
kafka-broker-api-versions.sh  kafka-metadata-shell.sh              kafka-verifiable-producer.sh
kafka-cluster.sh              kafka-mirror-maker.sh                trogdor.sh
kafka-configs.sh              kafka-preferred-replica-election.sh  windows
kafka-console-consumer.sh     kafka-producer-perf-test.sh          zookeeper-security-migration.sh
kafka-console-producer.sh     kafka-reassign-partitions.sh         zookeeper-server-start.sh
kafka-consumer-groups.sh      kafka-replica-verification.sh        zookeeper-server-stop.sh
kafka-consumer-perf-test.sh   kafka-run-class.sh                   zookeeper-shell.sh
kafka-delegation-tokens.sh    kafka-server-start.sh
kafka-delete-re

# create topic with name : quickstart
    kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic quickstart
# produce messate with CLI
    kafka-console-producer.sh --topic quickstart --bootstrap-server localhost:9092
# read message we produce
    docker exec -it kafka /bin/sh
    cd opt
    cd kafka_2.13-2.8.1
    cd bin
    kafka-console-consumer.sh --topic quickstart --from-beginning --bootstrap-server localhost:9092
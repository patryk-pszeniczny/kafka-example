# kafka-example
Simple kafka use case project

## RestAPI (Params and description)

| Type | Body/Param Required | Endpoint | Description |
| ---------- | -------- | -------- | ----------- |
| POST | Yes | /api/v1/messages | Send message to default topic. Example: `http://localhost:1234/api/v1/messages` |

## Docker

```docker pull bitnami/kafka```

<details><summary> Docker compose </summary><p>

```
version: '2'
networks:
  app-tier:
    driver: bridge

services:
  kafka:
    image: 'bitnami/kafka:latest'
    networks:
      - app-tier
    environment:
      - KAFKA_CFG_NODE_ID=0
      - KAFKA_CFG_PROCESS_ROLES=controller,broker
      - KAFKA_CFG_LISTENERS=PLAINTEXT://:9092,CONTROLLER://:9093
      - KAFKA_CFG_LISTENER_SECURITY_PROTOCOL_MAP=CONTROLLER:PLAINTEXT,PLAINTEXT:PLAINTEXT
      - KAFKA_CFG_CONTROLLER_QUORUM_VOTERS=0@kafka:9093
      - KAFKA_CFG_CONTROLLER_LISTENER_NAMES=CONTROLLER
  myapp:
    image: 'YOUR_APPLICATION_IMAGE'
    networks:
      - app-tier
```
</p></details>

## Example route

![Screen Shot](https://github.com/patryk-pszeniczny/kafka-example/blob/main/diagram_kafka.png)

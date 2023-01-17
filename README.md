# rabbitmq-java

To get into a condition where `rabbitTemplate.convertAndSend` blocks forever without NIO and blocks for 10 seconds before throwing `java.lang.IOException`:

1. On rabbitmq server run: `rabbitmqctl set_vm_memory_high_watermark 0`
2. Run spring boot application and keep calling `curl --location --request GET 'http://localhost:8080/publish'`



Note: To enable or disable NIO, modify `src/main/java/com/example/rabbitmqnonblocking/rabbitconfig/Config.java` 
      Line: `rabbitConnectionFactory.useNio();`

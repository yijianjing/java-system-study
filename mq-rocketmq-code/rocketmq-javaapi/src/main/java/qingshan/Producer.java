package qingshan;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import java.util.List;

public class Producer {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("my_test_producer_group");
        producer.setNamesrvAddr("47.117.125.134:9876");
        producer.start();

        for (int i = 0; i < 6; i++){
            try {
                // tags 用于过滤消息 keys 索引键,多个用空格隔开,RocketMQ可以根据这些key快速检索到消息
                Message msg = new Message("Jodie_topic_1023",
                        "TagA",
                        "2673",
                        ("RocketMQ "+String.format("%05d", i)).getBytes());

                SendResult sendResult = producer.send(msg);
                System.out.println(String.format("%05d", i)+" : "+sendResult);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        producer.shutdown();
    }
}
package com.mert.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;


@Configuration //bu diyor ki bir yada fazla bean methodu may be processed in the run time.
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}") //resources/app propertiesdeki sey
    private String bootstrapServers;

    //producer factoryye configuration
    //producer config, kafka client'in producerundan geliyor.

    public Map<String, Object> producerConfig(){
        Map<String,Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return props;
    }

    @Bean
    public ProducerFactory<String,String> producerFactory()
    {
        return new DefaultKafkaProducerFactory<>(producerConfig()); //produces producers according to config.

    }//ikinci parametre ne gondereceigne bagli degisir, object de olur, student
    //vs

    @Bean
    public KafkaTemplate<String,String> kafkaTemplate(ProducerFactory<String,String> producerFactory)
    {

        return new KafkaTemplate<>(producerFactory);
    }
    //yine ikincisi custom object olabilir,

    //bean oldugu icin, 34 line'da instantiate edilen producer factory, yine 42deki beane gonderilecek.
    //instantiate edilmis olacak.

}

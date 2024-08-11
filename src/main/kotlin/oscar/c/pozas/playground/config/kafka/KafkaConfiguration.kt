package oscar.c.pozas.playground.config.kafka

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaAdmin

@Configuration
@EnableKafka
class KafkaConfiguration {

    

    @Bean
    fun kafkaAdminConfiguration(): KafkaAdmin {
        KafkaTopicCreatorProperties()
        return KafkaAdmin()
    }
}
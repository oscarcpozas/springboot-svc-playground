package oscar.c.pozas.playground.config.idgenerator

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import oscar.c.pozas.playground.kernel.idgenerator.IdGenerator
import oscar.c.pozas.playground.kernel.idgenerator.UUIDv4Generator

@Configuration
class IdGeneratorConfig {

    @Bean
    fun uuidV4IdGeneratorConfiguration(): IdGenerator = UUIDv4Generator()
}
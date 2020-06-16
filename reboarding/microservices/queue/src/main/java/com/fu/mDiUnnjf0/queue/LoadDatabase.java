package com.fu.mDiUnnjf0.queue;

import com.fu.mDiUnnjf0.queue.repository.QueueRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase( QueueRepository repository) {
        return args -> {
            //log.info("Preloading " + repository.save(new Queue("Tamás", 1)));
            //log.info("Preloading " + repository.save(new Queue("Tomi", 2)));
        };
    }

}

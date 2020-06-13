package com.fu.mDiUnnjf0.office;

import com.fu.mDiUnnjf0.office.entity.OfficePerson;
import com.fu.mDiUnnjf0.office.repository.OfficeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase( OfficeRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new OfficePerson("Tamás", 0)));
        };
    }

}

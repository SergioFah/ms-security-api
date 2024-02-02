package com.sergiofah.mssecurityapi.service;

import com.sergiofah.mssecurityapi.model.Update;
import com.sergiofah.mssecurityapi.repository.ValueRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Data
public class UpdateService {
    private final WebClient webClient;

    @Autowired
    private ValueRepository valueRepository;
    public UpdateService(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://api.msrc.microsoft.com/cvrf/v2.0").build();
    }

    @Scheduled(fixedDelay = 300000)  // SCHEDULER (300000 = 5min)
    public void getFromMSAPI(){
        Update update = webClient
                .get()
                .uri("/updates")
                .retrieve()
                .bodyToMono(Update.class).block();

        assert update != null;
        this.valueRepository.saveAll(update.getValue());
        System.out.println("Database was Updated from MS_API");
    }
}

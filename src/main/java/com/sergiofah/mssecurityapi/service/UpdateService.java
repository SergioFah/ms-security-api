package com.sergiofah.mssecurityapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sergiofah.mssecurityapi.model.Update;
import com.sergiofah.mssecurityapi.repository.ValueRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.time.LocalTime;

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
    public void getFromMSAPI() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String updateString = webClient
                .get()
                .uri("/updates")
                .retrieve()
                .bodyToMono(String.class).block();
        assert updateString != null;
        Update update = mapper.readValue(updateString, Update.class);
        this.valueRepository.saveAll(update.getValue());
        System.out.println("Database was Updated from MS_API at: " + LocalTime.now());
    }
}

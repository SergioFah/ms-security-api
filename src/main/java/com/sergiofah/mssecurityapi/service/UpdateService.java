package com.sergiofah.mssecurityapi.service;

import com.sergiofah.mssecurityapi.model.Update;
import com.sergiofah.mssecurityapi.repository.ValueRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@Service
//@RestController
@Data
public class UpdateService {
    private final WebClient webClient;

    @Autowired
    private ValueRepository valueRepository;
    public UpdateService(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://api.msrc.microsoft.com/cvrf/v2.0").build();
    }

    //@GetMapping("/update")
    public Update getFromMSAPI(){
        Update update = webClient
                .get()
                .uri("/updates")
                .retrieve()
                .bodyToMono(Update.class).block();

        assert update != null;
        this.valueRepository.saveAll(update.getValue());
        return update;
    }
}

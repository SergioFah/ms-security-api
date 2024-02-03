package com.sergiofah.mssecurityapi.controller;

import com.sergiofah.mssecurityapi.model.Value;
import com.sergiofah.mssecurityapi.repository.ValueRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@CrossOrigin
@RequestMapping("/updates")
public class ValueController {
    @Autowired
    private ValueRepository valueRepository;

    @GetMapping
    public Iterable<Value> getUpdates(){
        return this.valueRepository.findAll();
    }
}

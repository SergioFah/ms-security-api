package com.sergiofah.mssecurityapi.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "value"
})
@Data
public class Update {
    @JsonProperty("value")
    private Iterable<Value> value = new ArrayList<Value>();

    public Iterable<Value> getValue() {
        return value;
    }
}
package com.sergiofah.mssecurityapi.model;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "ID",
        "Alias",
        "DocumentTitle",
        "Severity",
        "InitialReleaseDate",
        "CurrentReleaseDate",
        "CvrfUrl"
})
@Data
@Entity
@Table(name = "value")
public class Value {

    @Id
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    @JsonProperty("ID")
    private String id;

    @Column(name = "alias")
    @JsonProperty("Alias")
    private String alias;

    @Column(name = "document_title")
    @JsonProperty("DocumentTitle")
    private String documentTitle;

    @Column(name = "severity")
    @JsonProperty("Severity")
    private String severity;

    @Column(name = "initial_release_date")
    @JsonProperty("InitialReleaseDate")
    private String initialReleaseDate;

    @Column(name = "current_release_date")
    @JsonProperty("CurrentReleaseDate")
    private String currentReleaseDate;

    @Column(name = "cvrf_url")
    @JsonProperty("CvrfUrl")
    private String cvrfUrl;

}
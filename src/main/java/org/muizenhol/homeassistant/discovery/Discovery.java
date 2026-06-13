package org.muizenhol.homeassistant.discovery;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.muizenhol.homeassistant.discovery.component.Component;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Discovery(
        @JsonProperty("device")
        Device device,

        @JsonProperty("origin")
        Origin origin,

        @JsonProperty("state_topic")
        String stateTopic,

        @JsonProperty("components")
        Map<String, Component> components) {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Device(
            @JsonProperty("ids") String identifiers,
            @JsonProperty("mf") String manufacturer,
            @JsonProperty("mdl") String model,
            @JsonProperty("name") String name,
            @JsonProperty("via_device") String viaDevice) {
    }

    public record Origin(String name) {
    }
}

package org.muizenhol.homeassistant.discovery;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.muizenhol.homeassistant.discovery.component.Component;

import java.util.Map;

public record Discovery(
        @JsonProperty("device")
        Device device,

        @JsonProperty("origin")
        Origin origin,

        @JsonProperty("state_topic")
        String stateTopic,

        @JsonProperty("components")
        Map<String, Component> components) {
    public record Device(
            String identifiers,
            String manufacturer,
            String model,
            String name) {
    }

    public record Origin(String name) {
    }
}

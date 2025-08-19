package org.muizenhol.homeassistant.discovery;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Platform {
    SENSOR,
    LIGHT,
    CLIMATE,
    SWITCH;

    @JsonValue
    public String getName() {
        return name().toLowerCase();
    }
}
package org.muizenhol.homeassistant.discovery;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Platform {
    SENSOR,
    LIGHT,
    CLIMATE,
    SWITCH,
    COVER,
    SELECT,
    BINARY_SENSOR;

    @JsonValue
    public String getName() {
        return name().toLowerCase();
    }
}
package org.muizenhol.homeassistant.discovery;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * See <a href="https://developers.home-assistant.io/docs/core/entity/sensor/">docs</a>
 */
public enum StateClass {
    MEASUREMENT,
    TOTAL_INCREASING;

    @JsonValue
    public String getName() {
        return name().toLowerCase();
    }
}

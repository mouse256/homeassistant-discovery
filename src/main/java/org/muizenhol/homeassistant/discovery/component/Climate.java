package org.muizenhol.homeassistant.discovery.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.muizenhol.homeassistant.discovery.Platform;

import java.util.List;


/**
 * https://www.home-assistant.io/integrations/climate.mqtt/
 */
public class Climate extends Component {

    @JsonProperty("temperature_state_topic")
    private String temperatureStateTopic;

    @JsonProperty("current_temperature_topic")
    private String currentTemperatureTopic;

    @JsonProperty("temp_step")
    private double tempStep;

    @JsonProperty("modes")
    private List<String> modes;


    public Climate() {
        super(Platform.CLIMATE);
    }

    public static final class Builder {
        private String temperatureStateTopic;
        private String currentTemperatureTopic;
        private String name;
        private String uniqueId;
        private double tempStep;
        private List<String> modes;

        public Builder() {
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withUniqueId(String uniqueId) {
            this.uniqueId = uniqueId;
            return this;
        }

        public Builder withTemperatureStateTopic(String temperatureStateTopic) {
            this.temperatureStateTopic = temperatureStateTopic;
            return this;
        }

        public Builder withCurrentTemperatureTopic(String currentTemperatureTopic) {
            this.currentTemperatureTopic = currentTemperatureTopic;
            return this;
        }

        public Builder withTempStep(double tempStep) {
            this.tempStep = tempStep;
            return this;
        }

        public Builder withModes(List<String> modes) {
            this.modes = modes;
            return this;
        }


        public Climate build() {
            Climate climate = new Climate();
            climate.setName(name);
            climate.setUniqueId(uniqueId);
            climate.temperatureStateTopic = temperatureStateTopic;
            climate.currentTemperatureTopic = currentTemperatureTopic;
            climate.tempStep = tempStep;
            climate.modes = modes;
            return climate;
        }
    }


}

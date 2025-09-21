package org.muizenhol.homeassistant.discovery.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.muizenhol.homeassistant.discovery.Platform;

/**
 * https://www.home-assistant.io/integrations/light.mqtt/
 */
public class Light extends Component.WithState {

    @JsonProperty("brightness_state_topic")
    String brightnessStateTopic;

    @JsonProperty("brightness_command_topic")
    String brightnessCommandTopic;

    @JsonProperty("brightness_scale")
    int brightnessScale;

    @JsonProperty("on_command_type")
    String onCommandType;

    public Light() {
        super(Platform.LIGHT);
    }

    public static final class Builder {
        private String brightnessStateTopic;
        private String brightnessCommandTopic;
        private int brightnessScale;
        private String commandTopic;
        private String stateTopic;
        private String payloadOn;
        private String payloadOff;
        private String name;
        private String uniqueId;
        private String onCommandType;
        private String icon;
        private Availability availability;


        public Builder() {
        }

        public Builder withBrightnessStateTopic(String brightnessStateTopic) {
            this.brightnessStateTopic = brightnessStateTopic;
            return this;
        }

        public Builder withBrightnessCommandTopic(String brightnessCommandTopic) {
            this.brightnessCommandTopic = brightnessCommandTopic;
            return this;
        }

        public Builder withBrightnessScale(int brightnessScale) {
            this.brightnessScale = brightnessScale;
            return this;
        }

        public Builder withCommandTopic(String commandTopic) {
            this.commandTopic = commandTopic;
            return this;
        }

        public Builder withStateTopic(String stateTopic) {
            this.stateTopic = stateTopic;
            return this;
        }

        public Builder withPayloadOn(String payloadOn) {
            this.payloadOn = payloadOn;
            return this;
        }

        public Builder withPayloadOff(String payloadOff) {
            this.payloadOff = payloadOff;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withUniqueId(String uniqueId) {
            this.uniqueId = uniqueId;
            return this;
        }

        public Builder withOnCommandType(String onCommandType) {
            this.onCommandType = onCommandType;
            return this;
        }

        public Builder withIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public Builder withAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }


        public Light build() {
            Light dimmer = new Light();
            dimmer.setName(name);
            dimmer.setUniqueId(uniqueId);
            dimmer.brightnessScale = this.brightnessScale;
            dimmer.payloadOn = this.payloadOn;
            dimmer.brightnessStateTopic = this.brightnessStateTopic;
            dimmer.payloadOff = this.payloadOff;
            dimmer.stateTopic = this.stateTopic;
            dimmer.commandTopic = this.commandTopic;
            dimmer.brightnessCommandTopic = this.brightnessCommandTopic;
            dimmer.onCommandType = this.onCommandType;
            dimmer.icon = this.icon;
            dimmer.availability = this.availability;
            return dimmer;
        }
    }

}

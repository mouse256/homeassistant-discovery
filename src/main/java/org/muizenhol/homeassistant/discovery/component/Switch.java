package org.muizenhol.homeassistant.discovery.component;

import org.muizenhol.homeassistant.discovery.Platform;

/**
 * https://www.home-assistant.io/integrations/switch.mqtt/
 */
public class Switch extends Component.WithState {

    public Switch() {
        super(Platform.SWITCH);
    }

    public static final class Builder {
        private String commandTopic;
        private String stateTopic;
        private String payloadOn;
        private String payloadOff;
        private String name;
        private String uniqueId;
        private String icon;

        public Builder() {
        }

        public Switch.Builder withCommandTopic(String commandTopic) {
            this.commandTopic = commandTopic;
            return this;
        }

        public Switch.Builder withStateTopic(String stateTopic) {
            this.stateTopic = stateTopic;
            return this;
        }

        public Switch.Builder withPayloadOn(String payloadOn) {
            this.payloadOn = payloadOn;
            return this;
        }

        public Switch.Builder withPayloadOff(String payloadOff) {
            this.payloadOff = payloadOff;
            return this;
        }

        public Switch.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Switch.Builder withUniqueId(String uniqueId) {
            this.uniqueId = uniqueId;
            return this;
        }

        public Switch.Builder withIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public Switch build() {
            Switch aSwitch = new Switch();
            aSwitch.setName(name);
            aSwitch.setUniqueId(uniqueId);
            aSwitch.payloadOn = this.payloadOn;
            aSwitch.payloadOff = this.payloadOff;
            aSwitch.stateTopic = this.stateTopic;
            aSwitch.commandTopic = this.commandTopic;
            aSwitch.icon = this.icon;
            return aSwitch;
        }
    }
}

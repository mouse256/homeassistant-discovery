package org.muizenhol.homeassistant.discovery.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import org.muizenhol.homeassistant.discovery.Platform;

/**
 * https://www.home-assistant.io/integrations/binary_sensor.mqtt/
 */
public class BinarySensor extends Component {

    @JsonProperty("device_class")
    private DeviceClass deviceClass;

    @JsonProperty("state_topic")
    private String stateTopic;

    @JsonProperty("value_template")
    private String valueTemplate;

    @JsonProperty("payload_on")
    private String payloadOn;

    @JsonProperty("payload_off")
    private String payloadOff;

    public BinarySensor() {
        super(Platform.BINARY_SENSOR);
    }

    public DeviceClass getDeviceClass() {
        return deviceClass;
    }

    public String getStateTopic() {
        return stateTopic;
    }

    public String getValueTemplate() {
        return valueTemplate;
    }

    public String getPayloadOn() {
        return payloadOn;
    }

    public String getPayloadOff() {
        return payloadOff;
    }

    /**
     * See <a href="https://www.home-assistant.io/integrations/binary_sensor/#device-class">docs</a>
     */
    public enum DeviceClass {
        BATTERY_CHARGING,
        PLUG,
        POWER,
        PROBLEM,
        RUNNING;

        @JsonValue
        public String getName() {
            return name().toLowerCase();
        }
    }

    public static final class Builder {
        private DeviceClass deviceClass;
        private String stateTopic;
        private String valueTemplate;
        private String payloadOn;
        private String payloadOff;
        private String name;
        private String uniqueId;
        private String icon;
        private Availability availability;

        public Builder() {
        }

        public Builder withDeviceClass(DeviceClass deviceClass) {
            this.deviceClass = deviceClass;
            return this;
        }

        public Builder withStateTopic(String stateTopic) {
            this.stateTopic = stateTopic;
            return this;
        }

        public Builder withValueTemplate(String valueTemplate) {
            this.valueTemplate = valueTemplate;
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

        public Builder withIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public Builder withAvailability(Availability availability) {
            this.availability = availability;
            return this;
        }

        public BinarySensor build() {
            BinarySensor sensor = new BinarySensor();
            sensor.setName(name);
            sensor.setUniqueId(uniqueId);
            sensor.deviceClass = this.deviceClass;
            sensor.stateTopic = this.stateTopic;
            sensor.valueTemplate = this.valueTemplate;
            sensor.payloadOn = this.payloadOn;
            sensor.payloadOff = this.payloadOff;
            sensor.icon = this.icon;
            sensor.availability = this.availability;
            return sensor;
        }
    }
}

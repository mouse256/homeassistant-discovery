package org.muizenhol.homeassistant.discovery.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.muizenhol.homeassistant.discovery.DeviceClass;
import org.muizenhol.homeassistant.discovery.Platform;
import org.muizenhol.homeassistant.discovery.StateClass;

public class Sensor extends Component {

    @JsonProperty("device_class")
    private DeviceClass deviceClass;

    @JsonProperty("state_class")
    private StateClass stateClass;

    @JsonProperty("unit_of_measurement")
    private String unitOfMeasurement;

    @JsonProperty("suggested_display_precision")
    private int suggestedDisplayPrecision;

    @JsonProperty("value_template")
    private String valueTemplate;

    public Sensor() {
        super(Platform.SENSOR);
    }

    public DeviceClass getDeviceClass() {
        return deviceClass;
    }

    public StateClass getStateClass() {
        return stateClass;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public int getSuggestedDisplayPrecision() {
        return suggestedDisplayPrecision;
    }

    public String getValueTemplate() {
        return valueTemplate;
    }

    public static final class Builder {
        private DeviceClass deviceClass;
        private StateClass stateClass;
        private String unitOfMeasurement;
        private int suggestedDisplayPrecision;
        private String valueTemplate;
        private String name;
        private String uniqueId;

        public Builder() {
        }

        public Builder withDeviceClass(DeviceClass deviceClass) {
            this.deviceClass = deviceClass;
            return this;
        }

        public Builder withStateClass(StateClass stateClass) {
            this.stateClass = stateClass;
            return this;
        }

        public Builder withUnitOfMeasurement(String unitOfMeasurement) {
            this.unitOfMeasurement = unitOfMeasurement;
            return this;
        }

        public Builder withSuggestedDisplayPrecision(int suggestedDisplayPrecision) {
            this.suggestedDisplayPrecision = suggestedDisplayPrecision;
            return this;
        }

        public Builder withValueTemplate(String valueTemplate) {
            this.valueTemplate = valueTemplate;
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


        public Sensor build() {
            Sensor sensor = new Sensor();
            sensor.setName(name);
            sensor.setUniqueId(uniqueId);
            sensor.suggestedDisplayPrecision = this.suggestedDisplayPrecision;
            sensor.valueTemplate = this.valueTemplate;
            sensor.stateClass = this.stateClass;
            sensor.deviceClass = this.deviceClass;
            sensor.unitOfMeasurement = this.unitOfMeasurement;
            return sensor;
        }
    }


}

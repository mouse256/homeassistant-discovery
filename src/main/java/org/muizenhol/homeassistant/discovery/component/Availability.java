package org.muizenhol.homeassistant.discovery.component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Availability {

    @JsonProperty("payload_available")
    private String payloadAvailable;

    @JsonProperty("payload_not_available")
    private String payloadNotAvailable;

    @JsonProperty("topic")
    private String topic;

    @JsonProperty("value_template")
    private String valueTemplate;


    public static final class Builder {
        private String payloadAvailable;
        private String payloadNotAvailable;
        private String topic;
        private String valueTemplate;

        public Builder() {
        }

        public Builder withPayloadAvailable(String payloadAvailable) {
            this.payloadAvailable = payloadAvailable;
            return this;
        }

        public Builder withPayloadNotAvailable(String payloadNotAvailable) {
            this.payloadNotAvailable = payloadNotAvailable;
            return this;
        }

        public Builder withTopic(String topic) {
            this.topic = topic;
            return this;
        }

        public Builder withValueTemplate(String valueTemplate) {
            this.valueTemplate = valueTemplate;
            return this;
        }

        public Availability build() {
            Availability availability = new Availability();
            availability.topic = this.topic;
            availability.valueTemplate = this.valueTemplate;
            availability.payloadAvailable = this.payloadAvailable;
            availability.payloadNotAvailable = this.payloadNotAvailable;
            return availability;
        }
    }
}

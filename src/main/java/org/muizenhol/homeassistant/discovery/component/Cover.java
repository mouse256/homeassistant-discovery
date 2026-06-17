package org.muizenhol.homeassistant.discovery.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.muizenhol.homeassistant.discovery.Platform;

/**
 * https://www.home-assistant.io/integrations/cover.mqtt/
 */
public class Cover extends Component.WithState {

    @JsonProperty("payload_open")
    private String payloadOpen;

    @JsonProperty("payload_close")
    private String payloadClose;

    @JsonProperty("payload_stop")
    private String payloadStop;

    @JsonProperty("position_topic")
    private String positionTopic;

    @JsonProperty("set_position_topic")
    private String setPositionTopic;

    @JsonProperty("position_open")
    private Integer positionOpen;

    @JsonProperty("position_closed")
    private Integer positionClosed;

    public Cover() {
        super(Platform.COVER);
    }

    public static final class Builder {
        private String commandTopic;
        private String stateTopic;
        private String payloadOpen;
        private String payloadClose;
        private String payloadStop;
        private String positionTopic;
        private String setPositionTopic;
        private Integer positionOpen;
        private Integer positionClosed;
        private String name;
        private String uniqueId;
        private String icon;
        private Availability availability;

        public Builder() {
        }

        public Builder withCommandTopic(String commandTopic) {
            this.commandTopic = commandTopic;
            return this;
        }

        public Builder withStateTopic(String stateTopic) {
            this.stateTopic = stateTopic;
            return this;
        }

        public Builder withPayloadOpen(String payloadOpen) {
            this.payloadOpen = payloadOpen;
            return this;
        }

        public Builder withPayloadClose(String payloadClose) {
            this.payloadClose = payloadClose;
            return this;
        }

        public Builder withPayloadStop(String payloadStop) {
            this.payloadStop = payloadStop;
            return this;
        }

        public Builder withPositionTopic(String positionTopic) {
            this.positionTopic = positionTopic;
            return this;
        }

        public Builder withSetPositionTopic(String setPositionTopic) {
            this.setPositionTopic = setPositionTopic;
            return this;
        }

        public Builder withPositionOpen(Integer positionOpen) {
            this.positionOpen = positionOpen;
            return this;
        }

        public Builder withPositionClosed(Integer positionClosed) {
            this.positionClosed = positionClosed;
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

        public Cover build() {
            Cover cover = new Cover();
            cover.setName(name);
            cover.setUniqueId(uniqueId);
            cover.commandTopic = this.commandTopic;
            cover.stateTopic = this.stateTopic;
            cover.payloadOpen = this.payloadOpen;
            cover.payloadClose = this.payloadClose;
            cover.payloadStop = this.payloadStop;
            cover.positionTopic = this.positionTopic;
            cover.setPositionTopic = this.setPositionTopic;
            cover.positionOpen = this.positionOpen;
            cover.positionClosed = this.positionClosed;
            cover.icon = this.icon;
            cover.availability = this.availability;
            return cover;
        }
    }
}

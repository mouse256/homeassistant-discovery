package org.muizenhol.homeassistant.discovery.component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.muizenhol.homeassistant.discovery.Platform;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Component {
    @JsonProperty("name")
    protected String name;

    @JsonProperty("unique_id")
    protected String uniqueId;

    @JsonProperty("platform")
    protected final Platform platform;

    @JsonProperty("icon")
    String icon;

    Component(Platform platform) {
        this.platform = platform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Platform getPlatform() {
        return platform;
    }

    public static abstract class WithState extends Component {

        WithState(Platform platform) {
            super(platform);
        }

        @JsonProperty("command_topic")
        protected String commandTopic;

        @JsonProperty("state_topic")
        protected String stateTopic;

        @JsonProperty("payload_on")
        protected String payloadOn;

        @JsonProperty("payload_off")
        protected String payloadOff;
    }
}

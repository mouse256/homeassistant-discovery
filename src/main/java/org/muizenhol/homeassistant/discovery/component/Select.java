package org.muizenhol.homeassistant.discovery.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.muizenhol.homeassistant.discovery.Platform;

import java.util.List;

/**
 * https://www.home-assistant.io/integrations/select.mqtt/
 */
public class Select extends Component.WithState {

    @JsonProperty("options")
    private List<String> options;

    @JsonProperty("value_template")
    private String valueTemplate;

    @JsonProperty("retain")
    private Boolean retain;

    public Select() {
        super(Platform.SELECT);
    }

    public List<String> getOptions() {
        return options;
    }

    public String getValueTemplate() {
        return valueTemplate;
    }

    public Boolean getRetain() {
        return retain;
    }

    public static final class Builder {
        private String commandTopic;
        private String stateTopic;
        private List<String> options;
        private String valueTemplate;
        private Boolean retain;
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

        public Builder withOptions(List<String> options) {
            this.options = options;
            return this;
        }

        public Builder withValueTemplate(String valueTemplate) {
            this.valueTemplate = valueTemplate;
            return this;
        }

        public Builder withRetain(Boolean retain) {
            this.retain = retain;
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

        public Select build() {
            Select select = new Select();
            select.setName(name);
            select.setUniqueId(uniqueId);
            select.commandTopic = this.commandTopic;
            select.stateTopic = this.stateTopic;
            select.options = this.options;
            select.valueTemplate = this.valueTemplate;
            select.retain = this.retain;
            select.icon = this.icon;
            select.availability = this.availability;
            return select;
        }
    }
}

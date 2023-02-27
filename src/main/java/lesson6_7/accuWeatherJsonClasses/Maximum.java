package lesson6_7.accuWeatherJsonClasses;

import com.fasterxml.jackson.annotation.*;
import org.decimal4j.util.DoubleRounder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Maximum {
    private String value;
    private double celsius;
    @JsonCreator
    public Maximum(@JsonProperty("Value") String value){
        this.value=value;
        this.celsius = (Double.parseDouble(this.value) - 32) / 1.8;
        this.celsius = DoubleRounder.round(this.celsius, 1);
    }

    @JsonGetter("Value")
    public String getValue() {
        return value;
    }
    @JsonSetter("Value")
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ("до: " + celsius +"C");
    }
}

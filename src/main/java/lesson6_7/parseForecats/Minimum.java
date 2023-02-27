package lesson6_7.parseForecats;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Minimum {
    private double value;
    @JsonCreator
    public Minimum(@JsonProperty("Value") double value){
        this.value=value;
    }
    @JsonGetter("Value")
    public double getValue() {
        return value;
    }
    @JsonSetter("Value")
    public void setValue(double value) {
        this.value = value;
    }
}

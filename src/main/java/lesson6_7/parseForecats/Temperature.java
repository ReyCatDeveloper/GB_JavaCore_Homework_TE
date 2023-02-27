package lesson6_7.parseForecats;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
    private Minimum minimum;
    @JsonCreator
    public Temperature(@JsonProperty("Minimum") Minimum minimum){
    this.minimum=minimum;
    }
    @JsonGetter("Minimum")
    public Minimum getMinimum() {
        return minimum;
    }
    @JsonSetter("Minimum")
    public void setMinimum(Minimum minimum) {
        this.minimum = minimum;
    }
}

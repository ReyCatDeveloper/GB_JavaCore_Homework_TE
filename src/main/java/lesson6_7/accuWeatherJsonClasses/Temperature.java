package lesson6_7.accuWeatherJsonClasses;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
    private Minimum minimum;
    private Maximum maximum;
   @JsonCreator
   public Temperature(@JsonProperty("Minimum") Minimum minimum
                        ,@JsonProperty("Maximum") Maximum maximum){
        this.minimum=minimum;
        this.maximum = maximum;
    }
@JsonGetter("Minimum")
    public Minimum getMinimum() {
        return minimum;
    }
@JsonSetter("Minimum")
    public void setMinimum(Minimum minimum) {
        this.minimum = minimum;
    }

    @Override
    public String toString() {
        return minimum.toString()+" "+maximum.toString();
    }
@JsonGetter("Maximum")
    public Maximum getMaximum() {
        return maximum;
    }
@JsonSetter("Maximum")
    public void setMaximum(Maximum maximum) {
        this.maximum = maximum;
    }
}

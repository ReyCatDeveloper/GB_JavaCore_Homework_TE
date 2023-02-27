package lesson6_7.SandBox;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MiniPackets {
    private String string1;
    @JsonCreator
    public MiniPackets(@JsonProperty("string1")String string1){
        this.string1 = string1;

    }
    @JsonGetter("string1")
    public String getString1() {
        return string1;
    }
    @JsonSetter("string1")
    public void setString1(String string1) {
        this.string1 = string1;
    }
}

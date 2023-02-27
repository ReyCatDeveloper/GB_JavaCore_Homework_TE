package lesson6_7.SandBox;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExampleShort {
    List<MiniPackets> examplePackets = new ArrayList<>();

    @JsonCreator
    public ExampleShort(@JsonProperty("examplePackets")List<MiniPackets> examplePackets){
        this.examplePackets = examplePackets;
    }

    @JsonGetter("examplePackets")
    public List<MiniPackets> getExamplePackets() {
        return examplePackets;
    }

    @JsonSetter("examplePackets")
    public void setExamplePackets(List<MiniPackets> examplePackets) {
        this.examplePackets = examplePackets;
    }
}

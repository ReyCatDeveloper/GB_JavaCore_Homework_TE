package lesson6_7.SandBox;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.List;

public class Example {
    List<Packet> examplePackets = new ArrayList<>();

    @JsonCreator
    public Example(@JsonProperty("examplePackets")List<Packet> examplePackets){
        this.examplePackets = examplePackets;
    }

    @JsonGetter("examplePackets")
    public List<Packet> getExamplePackets() {
        return examplePackets;
    }

    @JsonSetter("examplePackets")
    public void setExamplePackets(List<Packet> examplePackets) {
        this.examplePackets = examplePackets;
    }
}

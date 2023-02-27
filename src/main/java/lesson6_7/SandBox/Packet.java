package lesson6_7.SandBox;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Packet {
    private String string1;
    private String string2;
    private  String string3;

    @JsonCreator
    public Packet(@JsonProperty("string1")String string1, @JsonProperty("string2")String string2, @JsonProperty("string3")String string3){
        this.string1=string1;
        this.string2=string2;
        this.string3=string3;
    }

    @JsonGetter("string1")
    public String getString1() {
        return string1;
    }
    @JsonSetter("string1")
    public void setString1(String string1) {
        this.string1 = string1;
    }

    @JsonGetter("string2")
    public String getString2() {
        return string2;
    }
    @JsonSetter("string2")
    public void setString2(String string2) {
        this.string2 = string2;
    }

    @JsonGetter("string3")
    public String getString3() {
        return string3;
    }
    @JsonSetter("string3")
    public void setString3(String string3) {
        this.string3 = string3;
    }
}

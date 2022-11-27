package pojo.UserGenerator;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Result {

    @JsonProperty("gender")
    private String gender;
    @JsonProperty("name")
    private Name name;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("email")
    private String email;
    @JsonProperty("login")
    private Login login;
    @JsonProperty("dob")
    private Dob dob;
    @JsonProperty("registered")
    private Registered registered;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("cell")
    private String cell;
    @JsonProperty("id")
    private Id id;
    @JsonProperty("picture")
    private Picture picture;
    @JsonProperty("nat")
    private String nat;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

package ar.com.maxo.springBootExample.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Quote {

    @Setter
    @Getter
    private String type;

    @Setter
    @Getter
    private Value value;


}

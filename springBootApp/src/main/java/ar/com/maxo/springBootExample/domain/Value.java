package ar.com.maxo.springBootExample.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Value {

    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    private String quote;


}

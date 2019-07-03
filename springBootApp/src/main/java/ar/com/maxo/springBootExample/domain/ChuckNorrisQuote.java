package ar.com.maxo.springBootExample.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class ChuckNorrisQuote {

    @Setter
    @Getter
    ArrayList<String> category;

    @Setter
    @Getter
    String icon_url;

    @Setter
    @Getter
    String id;

    @Setter
    @Getter
    String url;

    @Setter
    @Getter
    String value;
}

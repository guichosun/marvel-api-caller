package org.globant.challenge.openpay.apicaller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class PropertySource {

    @Value("${marvel.api.url.base}")
    private String urlBase;

    @Value("${marvel.api.url.api}")
    private String apiCharacters;

    @Value("${marvel.api.ts}")
    private String timestamp;

    @Value("${marvel.api.apikey}")
    private String apikey;

    @Value("${marvel.api.hash}")
    private String hash;
}

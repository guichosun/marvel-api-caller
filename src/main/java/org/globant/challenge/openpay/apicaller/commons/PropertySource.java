package org.globant.challenge.openpay.apicaller.commons;

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
}

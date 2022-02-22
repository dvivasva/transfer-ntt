package com.dvivasva.transfer.webclient;

import com.dvivasva.transfer.utils.UriAccess;
import com.dvivasva.transfer.utils.UriBase;
import com.dvivasva.transfer.webclient.dto.CardDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

public class CardWebClient {
    WebClient client = WebClient.builder()
            .baseUrl(UriBase.URL_CARD_SERVICE_8096)
            .defaultCookie("cookieKey", "cookieValue")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultUriVariables(Collections.singletonMap("url", UriBase.URL_CARD_SERVICE_8096))
            .build();

    public Mono<CardDto> findByNumber(String number) {
        return client.get()
                .uri( UriBase.URL_CARD_SERVICE_8096 + UriAccess.CARD+"/" +number)
                .accept(MediaType.APPLICATION_NDJSON)
                .exchangeToMono(response -> {
                    if (response.statusCode().equals(HttpStatus.OK)) {
                        return response.bodyToMono(CardDto.class);
                    }
                    else {
                        // Turn to error
                        return response.createException().flatMap(Mono::error);
                    }
                });
    }
}

package com.dvivasva.transfer.webclient;

import com.dvivasva.transfer.utils.UriAccess;
import com.dvivasva.transfer.utils.UriBase;
import com.dvivasva.transfer.webclient.dto.CreditDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

public class CreditWebClient {

    WebClient client = WebClient.builder()
            .baseUrl(UriBase.URL_CREDIT_SERVICE_8098)
            .defaultCookie("cookieKey", "cookieValue")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultUriVariables(Collections.singletonMap("url", UriBase.URL_CREDIT_SERVICE_8098))
            .build();

    public Mono<CreditDto> details(String id) {
        return client.get()
                .uri( UriBase.URL_CREDIT_SERVICE_8098 + UriAccess.CREDIT + "/" + id)
                .accept(MediaType.APPLICATION_NDJSON)
                .exchangeToMono(response -> {
                    if (response.statusCode().equals(HttpStatus.OK)) {
                        return response.bodyToMono(CreditDto.class);
                    }
                    else {
                        // Turn to error
                        return response.createException().flatMap(Mono::error);
                    }
                });
    }
    public Mono<CreditDto> update(String creditDtoId, Mono<CreditDto> creditDtoMono) {
        return client.put()
                .uri(UriBase.URL_CREDIT_SERVICE_8098 + UriAccess.CREDIT +"/"+ creditDtoId)
                .body(creditDtoMono, CreditDto.class)
                .retrieve()
                .bodyToMono(CreditDto.class);
    }
}

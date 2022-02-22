package com.dvivasva.transfer.webclient;

import com.dvivasva.transfer.utils.UriAccess;
import com.dvivasva.transfer.utils.UriBase;
import com.dvivasva.transfer.webclient.dto.PaymentDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

public class PaymentWebClient {

    WebClient client = WebClient.builder()
            .baseUrl(UriBase.URL_PAYMENT_SERVICE_8093)
            .defaultCookie("cookieKey", "cookieValue")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultUriVariables(Collections.singletonMap("url", UriBase.URL_PAYMENT_SERVICE_8093))
            .build();


    public Mono<PaymentDto> create(PaymentDto paymentDtoMono) {
        return client.post()
                .uri( UriBase.URL_PAYMENT_SERVICE_8093 + UriAccess.PAYMENT)
                //.accept(MediaType.APPLICATION_NDJSON)
                .body(Mono.just(paymentDtoMono), PaymentDto.class)
                .retrieve()
                .bodyToMono(PaymentDto.class);
    }

}

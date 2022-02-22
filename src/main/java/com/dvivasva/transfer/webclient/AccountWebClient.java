package com.dvivasva.transfer.webclient;

import com.dvivasva.transfer.utils.UriAccess;
import com.dvivasva.transfer.utils.UriBase;
import com.dvivasva.transfer.webclient.dto.AccountDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

public class AccountWebClient {
    WebClient client = WebClient.builder()
            .baseUrl(UriBase.URL_ACCOUNT_SERVICE_8094)
            .defaultCookie("cookieKey", "cookieValue")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultUriVariables(Collections.singletonMap("url", UriBase.URL_ACCOUNT_SERVICE_8094))
            .build();

    public Mono<AccountDto> details(String id) {
        return client.get()
                .uri( UriBase.URL_ACCOUNT_SERVICE_8094 + UriAccess.ACCOUNT+ "/" + id)
                .accept(MediaType.APPLICATION_NDJSON)
                .exchangeToMono(response -> {
                    if (response.statusCode().equals(HttpStatus.OK)) {
                        return response.bodyToMono(AccountDto.class);
                    }
                    else {
                        // Turn to error
                        return response.createException().flatMap(Mono::error);
                    }
                });
    }

    public Mono<AccountDto> update(String accountId, Mono<AccountDto> account) {
        return client.put()
                .uri(UriBase.URL_ACCOUNT_SERVICE_8094 + UriAccess.ACCOUNT +"/"+ accountId)
                .body(account, AccountDto.class)
                .retrieve()
                .bodyToMono(AccountDto.class);
    }
}

package it.inoma.francescoRibatti.exerciseBanking.service;

import it.inoma.francescoRibatti.exerciseBanking.payload.response.BalanceResponse;
import it.inoma.francescoRibatti.exerciseBanking.payload.response.InfoContoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FabrickApiService {
    @Value("${fabrick.api.base-url}")
    private String fabrickBaseUrl;

    @Value("${fabrick.api.uri}")
    private String uri;

    @Value("${fabrick.api.auth-schema}")
    private String authSchema;

    // per HttpHeaders
    @Value("${fabrick.api.api-key}")
    private String apiKey;

    @Value("${fabrick.api.account-id}")
    private Long accountId;

    // TODO Implementare i metodi per chiamare le API di Fabrick

    public InfoContoResponse getInfoConto() {
        String urlApiInfoConto = fabrickBaseUrl + uri + accountId;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Auth-Schema", authSchema);
        headers.set("Api-Key", apiKey);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<InfoContoResponse> infoResponse = restTemplate.exchange(
                urlApiInfoConto,
                HttpMethod.GET,
                new HttpEntity<>(headers),
//                new HttpEntity<>(InfoContoResponse.class),
                // tipo di dati atteso per la risposta
                InfoContoResponse.class
//                new ParameterizedTypeReference<InfoContoResponse>() { }
        );

        InfoContoResponse info = infoResponse.getBody();
        return info;
    }

    /**
     * Recupero del saldo del CC
     *
     * @return risposta della chiamata API
     */
    public BalanceResponse getBalance() {
        String urlApiBalance = fabrickBaseUrl + uri + accountId + "/balance";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Auth-Schema", authSchema);
        headers.set("Api-Key", apiKey);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<BalanceResponse> balanceResponse = restTemplate.exchange(
                urlApiBalance,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                BalanceResponse.class
        );

        return balanceResponse.getBody();
    }

    //  -------------------- //

    // GET  https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts
    public String getTransactions() {
        // Implementa la chiamata API per ottenere la lista delle transazioni
        return null;
    }

    // POST  https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers
//    public String performTransfer(TransferRequest transferRequest) {
//        // Implementa la chiamata API per eseguire un bonifico
//        return null;
//    }

}

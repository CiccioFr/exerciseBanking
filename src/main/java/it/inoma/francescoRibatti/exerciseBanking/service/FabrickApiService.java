package it.inoma.francescoRibatti.exerciseBanking.service;

import it.inoma.francescoRibatti.exerciseBanking.payload.request.TransferRequest;
import it.inoma.francescoRibatti.exerciseBanking.payload.response.SendboxResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FabrickService {
    @Value("${fabrick.api.base-url}")
    private String fabrickBaseUrl;

    @Value("${fabrick.api.auth-schema}")
    private String authSchema;

    @Value("${fabrick.api.api-key}")
    private String apiKey;

    @Value("${fabrick.api.account-id}")
    private Long accountId;


    // TODO Implementare i metodi per chiamare le API di Fabrick
    // GET  https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/14537780/balance
    public ResponseEntity<> getBalance() {
        // Implementa la chiamata API per ottenere il saldo
        // RestTemplate o Feign possono essere utilizzati qui
        // Ritorna la risposta della chiamata API
        String uri = "http://localhost:8090/comment/backup";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<SendboxResponse>> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                new HttpEntity<>(SendboxResponse.class),
                new ParameterizedTypeReference<List<SendboxResponse>>(){}
        );
        return response.getBody();
    }

    // GET  https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts
    public String getTransactions() {
        // Implementa la chiamata API per ottenere la lista delle transazioni
        return null;
    }

    // POST  https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers
    public String performTransfer(TransferRequest transferRequest) {
        // Implementa la chiamata API per eseguire un bonifico
        return null;
    }
}

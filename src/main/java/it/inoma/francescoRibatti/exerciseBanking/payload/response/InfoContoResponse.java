package it.inoma.francescoRibatti.exerciseBanking.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InfoContoResponse {

    @JsonProperty("status")
    private String status;

    @JsonProperty("error")
    private List<Error> error;

    @JsonProperty("payload")
    private Payload payload;

    @Getter
    @Setter
    public static class Payload {

        private int accountId;
        private String iban;
        private String abiCode;
        private String cabCode;
        private String countryCode;
        private String internationalCin;
        private String nationalCin;
        private String account;
        private String alias;
        private String productName;
        private String holderName;
        private String activatedDate;
        private String currency;
    }
}

//    {
//        "status": "OK",
//        "error": [],
//        "payload": {
//            "accountId": "14537780",
//            "iban": "IT40L0326822311052923800661",
//            "abiCode": "03268",
//            "cabCode": "22311",
//            "countryCode": "IT",
//            "internationalCin": "40",
//            "nationalCin": "L",
//            "account": "52923800661",
//            "alias": "Test api",
//            "productName": "Conto Websella",
//            "holderName": "LUCA TERRIBILE",
//            "activatedDate": "2016-12-14",
//            "currency": "EUR"
//        }
//    }
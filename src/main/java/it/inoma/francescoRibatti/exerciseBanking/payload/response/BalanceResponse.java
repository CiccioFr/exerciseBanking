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
public class BalanceResponse {

    private String status;

    @JsonProperty("error")
    private List<Error> error;

    @JsonProperty("payload")
    private Payload payload;

    @Getter
    @Setter
    public static class Payload {

        private String date;
        private double balance;
        private double availableBalance;
        private String currency;
    }
}

//    {
//        "status": "OK",
//        "error": [],
//        "payload": {
//            "date": "2023-11-20",
//            "balance": -21.59,
//            "availableBalance": -21.59,
//            "currency": "EUR"
//        }
//    }
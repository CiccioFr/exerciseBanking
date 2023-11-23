package it.inoma.francescoRibatti.exerciseBanking.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionsResponse implements Serializable {

    @JsonProperty("status")
    private String status;

    @JsonProperty("error")
    private List<Error> error;

    @JsonProperty("payload")
    private Payload payload;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload implements Serializable{
        private List<Transazione> list;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Transazione implements Serializable{
        private String transactionId;
        private String operationId;
        @JsonProperty("accountingDate")
        @JsonFormat(pattern = "yyyy-MM-dd")
        private String accountingDate;
        @JsonProperty("valueDate")
        @JsonFormat(pattern = "yyyy-MM-dd")
        private String valueDate;
        private Type type;
        private double amount;
        private String currency;
        private String description;


        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Type implements Serializable{
            private String enumeration;
            private String value;
        }
    }
}

//  Json di risposta
//    {
//        "status": "OK",
//        "error": [],
//        "payload": {
//            "list": [
//                {
//                    "transactionId": "327378821800",
//                    "operationId": "23000395026711",
//                    "accountingDate": "2023-11-07",
//                    "valueDate": "2023-11-07",
//                    "type": {
//                        "enumeration": "GBS_TRANSACTION_TYPE",
//                        "value": "GBS_ACCOUNT_TRANSACTION_TYPE_0009"
//                    },
//                    "amount": -0.10,
//                    "currency": "EUR",
//                    "description": "BA TERRIBILE LUCA        REC 94748B390EF241F7ABFADAF8588D9CEE TEST CUTOFF"
//                },
//                {
//                    "transactionId": "322900053600",
//                    "operationId": "23000270529814",
//                    "accountingDate": "2023-10-06",
//                    "valueDate": "2023-10-06",
//                    "type": {
//                        "enumeration": "GBS_TRANSACTION_TYPE",
//                        "value": "GBS_ACCOUNT_TRANSACTION_TYPE_0009"
//                    },
//                    "amount": -0.10,
//                    "currency": "EUR",
//                    "description": "BA TERRIBILE LUCA        REC 94748B390EF241F7ABFADAF8588D9CEE TEST CUTOFF"
//                },
//                {
//                    "transactionId": "322050669901",
//                    "operationId": "23000265071104",
//                    "accountingDate": "2023-10-02",
//                    "valueDate": "2023-10-02",
//                    "type": {
//                        "enumeration": "GBS_TRANSACTION_TYPE",
//                        "value": "GBS_ACCOUNT_TRANSACTION_TYPE_0050"
//                    },
//                    "amount": -12.08,
//                    "currency": "EUR",
//                    "description": "PD FATTURAZIONE SMART BUSINESS SELLA CBI"
//                }
//            ]
//        }
//    }
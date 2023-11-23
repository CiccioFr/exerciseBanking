package it.inoma.francescoRibatti.exerciseBanking.controller;

import it.inoma.francescoRibatti.exerciseBanking.payload.request.TransferRequest;
import it.inoma.francescoRibatti.exerciseBanking.payload.response.BalanceResponse;
import it.inoma.francescoRibatti.exerciseBanking.payload.response.InfoContoResponse;
import it.inoma.francescoRibatti.exerciseBanking.payload.response.TransactionsResponse;
import it.inoma.francescoRibatti.exerciseBanking.service.FabrickApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("bancasandbox") // localhost:{port}/bancasandbox/..
public class Controller {

    @Autowired
    private FabrickApiService fabrickApiService;
//    @Autowired
    private TransferRequest transferRequest;

    /**
     * <p>Info sul conto</p>
     * per testate l'API Fabrick,dato che è l'unica che funziona
     *
     * @return
     */
    @GetMapping("/info")    // http://localhost:8084/bancasandbox/info
    public ResponseEntity<?> getInfoconto() {
        InfoContoResponse infoConto = fabrickApiService.getInfoConto();
        return new ResponseEntity<>(infoConto, HttpStatus.OK);
    }

    /**
     * recupera il saldo dal servizio Fabrick
     *
     * @return
     */
    @GetMapping("/saldo")   // http://localhost:8084/bancasandbox/saldo
    public ResponseEntity<?> getBalance() {
        BalanceResponse balance = fabrickApiService.getBalance();
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }


    /**
     * recupera la lista delle transazioni dal servizio Fabrick
     *
     * @return
     */
    @GetMapping("/transazioni")     // http://localhost:8084/bancasandbox/transazioni?fromAccountingDate=2023-10-01&toAccountingDate=2023-11-19
    public ResponseEntity<?> getTransactions(
            @RequestParam("fromAccountingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start,
            @RequestParam("toAccountingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
    ) {
        if (start.isAfter(end))
            return new ResponseEntity<>("Start date should be before the end date", HttpStatus.OK);

//        List<TransactionsResponse> transactions = fabrickApiService.getTransactions(start, end);
        String transactions = fabrickApiService.getTransactionsString(start, end);
//        List<TransactionsResponse> transactions = fabrickApiService.getTransactionsNoString(start, end);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }








    /**
     * esecuzione del bonifico utilizzando il servizio Fabrick
     *
     * @param transferRequest
     * @return
     */
//    @PostMapping("/bonifico")
//    public ResponseEntity<?> performTransfer(@RequestBody TransferRequest transferRequest) {
//        String result = fabrickApiService.performTransfer(transferRequest);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
}

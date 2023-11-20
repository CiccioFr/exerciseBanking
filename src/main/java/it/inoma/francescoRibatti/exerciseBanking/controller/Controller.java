package it.inoma.francescoRibatti.exerciseBanking.controller;

import it.inoma.francescoRibatti.exerciseBanking.payload.request.TransferRequest;
import it.inoma.francescoRibatti.exerciseBanking.payload.response.BalanceResponse;
import it.inoma.francescoRibatti.exerciseBanking.payload.response.InfoContoResponse;
import it.inoma.francescoRibatti.exerciseBanking.service.FabrickApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

}
# Servizio Bancario RESTful con Spring Web e Fabrick API

L'applicazione è un servizio RESTful sviluppato in Java utilizzando il framework Spring Web.  
L'obiettivo principale è integrarsi con le API fornite da Fabrick per gestire operazioni bancarie su un conto, tra cui la lettura del saldo, la visualizzazione delle transazioni e l'esecuzione di bonifici.  
L'applicazione utilizza un file di configurazione YAML per definire proprietà come l'URL di base delle API di Fabrick e altre informazioni sensibili. L'architettura segue principi di sviluppo software, gestisce gli errori in modo appropriato e include test automatizzati.  
La persistenza dei dati non è attualmente implementata, la funzionalità sarà implementata in una seconda fase.  

## Inizializzato da [Spring Initializr](https://start.spring.io/)

### Dipendenze:
1. `spring web`
2. `spring data jpa` (servizio attualmente disabilitato)
3. `mysql Driver`
4. `lombok`
5. `validation`

## Principali caratteristiche dell'applicazione
- Java ver. 17  /  libreria `Swing Web`
- Build System: `Maven`
- utilizzo del file `application.yaml`

## EndPoint dell'applicazione:
### Radice dell'url per esecuzione locale: http://localhost:8084  
Tutti gli endpoint richiedono delle informazioni aggiuntive da inserire nell'headers della richiesta, almomento tutte preimpostate hardcode

### 1. **Informazioni sul Conto corrente**
- Metodo: `GET`
- Endpoint: `/bancasandbox/info`
- Descrizione: Recupera le informazioni del Conto Corrente utilizzando le API di Fabrick, come Nominativo dell'intestario, IBAN, ecc..
- Esempio di Risposta:
  <details> <summary>  click per espandere  </summary>

  ```json
  {
      "status": "OK",
      "error": [],
      "payload": {
          "accountId": "14537780",
          "iban": "IT40L0326822311052923800661",
          "abiCode": "03268",
          "cabCode": "22311",
          "countryCode": "IT",
          "internationalCin": "40",
          "nationalCin": "L",
          "account": "52923800661",
          "alias": "Test api",
          "productName": "Conto Websella",
          "holderName": "LUCA TERRIBILE",
          "activatedDate": "2016-12-14",
          "currency": "EUR"
      }
  }
  ```
  </details> <br>

### 2. **Lettura Saldo**
- Metodo: `GET`
- Endpoint: `/bancasandbox/saldo`
- Descrizione: Recupera il saldo corrente del conto utilizzando le API di Fabrick.
- Esempio di Risposta:
  <details> <summary>  click per espandere  </summary>

  ```json
  {
      "status": "OK",
      "error": [],
      "payload": {
          "date": "2023-11-20",
          "balance": -21.59,
          "availableBalance": -21.59,
          "currency": "EUR"
      }
  }
  ```
  </details> <br>

### 3. **Lista Transazioni**
- Metodo: `GET`
- Endpoint: `/bancasandbox/transazioni?fromAccountingDate=2023-10-01&toAccountingDate=2023-11-19`  
  \* al momento preimpostato hardcode
- Descrizione: Ottiene la lista delle transazioni del conto attraverso le API di Fabrick.
- Esempio di Risposta:
  <details> <summary>  click per espandere  </summary>

  ```json
  {
    "status": "OK",
    "error": [],
    "payload": {
      "list": [
        {
          "transactionId": "327378821800",
          "operationId": "23000395026711",
          "accountingDate": "2023-11-07",
          "valueDate": "2023-11-07",
          "type": {
            "enumeration": "GBS_TRANSACTION_TYPE",
            "value": "GBS_ACCOUNT_TRANSACTION_TYPE_0009"
          },
          "amount": -0.10,
          "currency": "EUR",
          "description": "BA TERRIBILE LUCA        REC 94748B390EF241F7ABFADAF8588D9CEE TEST CUTOFF"
        },
        {
          "transactionId": "322900053600",
          "operationId": "23000270529814",
          "accountingDate": "2023-10-06",
          "valueDate": "2023-10-06",
          "type": {
            "enumeration": "GBS_TRANSACTION_TYPE",
            "value": "GBS_ACCOUNT_TRANSACTION_TYPE_0009"
          },
          "amount": -0.10,
          "currency": "EUR",
          "description": "BA TERRIBILE LUCA        REC 94748B390EF241F7ABFADAF8588D9CEE TEST CUTOFF"
        },
        {
          "transactionId": "322050669901",
          "operationId": "23000265071104",
          "accountingDate": "2023-10-02",
          "valueDate": "2023-10-02",
          "type": {
            "enumeration": "GBS_TRANSACTION_TYPE",
            "value": "GBS_ACCOUNT_TRANSACTION_TYPE_0050"
          },
          "amount": -12.08,
          "currency": "EUR",
          "description": "PD FATTURAZIONE SMART BUSINESS SELLA CBI"
        }
      ]
    }
  }
  ```
  </details> <br>

### 4. **Bonifico**
- Metodo: `POST`
- Endpoint: `/bancasandbox/bonifico`
- Descrizione: Esegue un bonifico utilizzando le API di Fabrick.
- Esempio di Richiesta:
  <details> <summary>  click per espandere  </summary>

  In fase di sviluppo
  </details> <br>

- Esempio di Risposta:
  <details> <summary>  click per espandere  </summary>

  In fase di sviluppo
  </details> <br>

## Struttura del Codice:

Il codice sorgente segue una struttura modulare e pulita. Le classi principali includono:
- `Controller`: Gestisce gli endpoint REST e le interazioni con il client.
- `FabrickApiService`: Comunica con le API di Fabrick e implementa la logica di business.
- `InfoContoResponse`: Rappresenta la struttura della risposta delle API di Fabrick per le informazioni sul conto.
- Altre classi ausiliarie e di configurazione.

## Test Automatizzati:
L'applicazione includerà test automatizzati ...

## Gestione degli Errori:
L'applicazione gestirà gli errori in modo appropriato, ...

## Facoltativo:
La persistenza dei dati potrebbe essere implementata ...

## Conclusioni:
Il nostro Servizio Bancario RESTful offre un'interfaccia intuitiva per interagire con le API di Fabrick, consentendo agli utenti di eseguire operazioni bancarie in modo sicuro e efficiente. La struttura modulare, i test automatizzati e la gestione accurata degli errori ne fanno un'applicazione affidabile e pronta per essere estesa o integrata con funzionalità aggiuntive.
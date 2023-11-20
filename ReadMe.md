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
radice dell'url per esecuzione locale: http://localhost:8084




1. **Lettura Saldo**
   - Metodo: `GET`
   - Endpoint: `/bancasandbox/saldo`
   - Descrizione: Recupera il saldo corrente del conto utilizzando le API di Fabrick.
   - Esempio di Risposta: 
     ```json
     {"saldo": 1500.25}
     ```


## Struttura del Codice:

Il codice sorgente segue una struttura modulare e pulita. Le classi principali includono:
- `Controller`: Gestisce gli endpoint REST e le interazioni con il client.
- `FabrickApiService`: Comunica con le API di Fabrick e implementa la logica di business.
- `InfoContoResponse`: Rappresenta la struttura della risposta delle API di Fabrick per le informazioni sul conto.
- Altre classi ausiliarie e di configurazione.

## Test Automatizzati:

L'applicazione include test automatizzati per garantire la robustezza del codice. Sono presenti test per le diverse funzionalità, inclusi test di integrazione per gli endpoint REST.

## Gestione degli Errori:

L'applicazione gestisce gli errori in modo appropriato, ....

## Facoltativo:

La persistenza dei dati potrebbe essere implementata ...

## Conclusioni:

Il nostro Servizio Bancario RESTful offre un'interfaccia intuitiva per interagire con le API di Fabrick, consentendo agli utenti di eseguire operazioni bancarie in modo sicuro e efficiente. La struttura modulare, i test automatizzati e la gestione accurata degli errori ne fanno un'applicazione affidabile e pronta per essere estesa o integrata con funzionalità aggiuntive.
# Juggle Hive Webapp

## Indice

#### TODO

## Altro

## TODO

## Architettura del Server

Il server è stato progettato utilizzando una combinazione di risorse fornite da Azure, garantendo affidabilità, scalabilità e prestazioni ottimali al progetto.
Di seguito elencate le principali componenti dell'architettura del server:

### jugglehive-cloud (VM)
- **Tipo:** Standard B1s
- **Risorse:** 
  - 1 CPU virtuale
  - 1 GiB di memoria
  - 64GB SSD P6
- **Storage Aggiuntivo:** Due SSD P6 da 64GB
- **Utilizzo:** Questa macchina virtuale è dedicata al funzionamento del sottodominio cloud del nostro sito. 

### jugglehive-mysql (MySQL)
- **Tipo:** Database MySQL flessibile di Azure
- **Caratteristiche:** 
  - Possibilità di burst
  - B1ms
  - 1 vCore
  - 2 GiB di RAM
  - 32 GiB di spazio di archiviazione
- **Accesso:** L'unico indirizzo IP che può accedervi è quello della VM jugglehive-cloud.

### jugglehive-webapp (VM)
- **Tipo:** Standard B1s
- **Risorse:** 
  - 1 CPU virtuale
  - 1 GiB di memoria
  - 64GB SSD P6
- **Utilizzo:** Questa macchina virtuale è fondamentale per il funzionamento del sito principale, inclusi tutti gli altri sottodomini che non sono parte del cloud.

### jugglehive-pgsql (PostgreSQL)
- **Tipo:** Database PostgreSQL flessibile di Azure
- **Caratteristiche:** 
  - Possibilità di burst
  - B1ms
  - 1 vCore
  - 2 GiB di RAM
  - 32 GiB di spazio di archiviazione
- **Accesso:** L'unico indirizzo IP che può accedervi è quello della VM jugglehive-webapp.

### Configurazione
- **jugglehive-webapp + jugglehive-pgsql:** Questa configurazione è essenziale per il funzionamento del sito principale, gestendo tutte le attività correlate ai sottodomini non appartenenti al cloud.
- **jugglehive-cloud + jugglehive-mysql:** Questa combinazione è responsabile del funzionamento del sottodominio cloud del sito, utilizzando l'opensource Nextcloud per garantire un'esperienza fluida agli utenti.

## Continous Integration e Continuous Deployment (CI/CD)

L'infrastruttura utilizza un processo di Continuous Integration e Continuous Deployment (CI/CD) per automatizzare la compilazione, il testing e la distribuzione della webapp. Questo processo garantisce un flusso di sviluppo fluido e assicura rilasci rapidi ed affidabili.

Durante la fase di CI, ogni push sui branch "main" di questa repository innesta il processo di build. Questo processo coinvolge diverse fasi:

1. **Build Frontend e Backend:** Utilizzando GitHub Actions, l'ambiente di build esegue la compilazione del frontend Angular e del backend Spring. Vengono installate le dipendenze, eseguita la compilazione e i file risultanti sono pronti per essere distribuiti.

2. **Build Docker Image:** Una volta che i componenti dell'applicazione sono compilati con successo, viene eseguito il build dell'immagine Docker che include la webapp. Questo processo garantisce che l'applicazione sia containerizzata e pronta per essere distribuita in un ambiente Docker.

Durante la fase di CD, l'applicazione viene distribuita automaticamente sulle VM di produzione. Questo processo avviene tramite GitHub Actions ed è diviso in diverse fasi:

1. **Copia dei File sulle VM:** Utilizzando lo strumento SCP, i file necessari per l'esecuzione dell'applicazione vengono copiati sulle VM.

2. **Configurazione delle VM:** Utilizzando uno script SSH, vengono eseguite le operazioni necessarie per configurare le VM, inclusa la gestione dei servizi e la configurazione dell'ambiente.

In questo modo, il processo CI/CD automatizzato garantisce che la webapp e il cloud vengano distribuiti in modo affidabile e rapido, riducendo al minimo il tempo di inattività e migliorando l'efficienza dello sviluppo.
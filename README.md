# employee-Manager-App
Progetto backend sviluppato con finalità didattiche. Fornisce un'API REST per la gestione di impiegati, consentendo operazioni CRUD (creazione, lettura, aggiornamento, eliminazione) su un database relazionale.

## 📌 Funzionalità

- ✅ Aggiunta di nuovi impiegati
- ✅ Visualizzazione elenco impiegati
- ✅ Visualizzazione di un singolo impiegato tramite id
- ✅ Modifica delle informazioni di un impiegato tramite id
- ✅ Eliminazione di un impiegato tramite id
- ✅ Eliminazione di tutti gli impiegati

---

## 🛠️ Tecnologie utilizzate

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven

**📌 Esempi di richieste REST**

Recupera tutti gli impiegati
GET http://localhost:8080/employee/all

Recupera un impiegato tramite ID
GET http://localhost:8080/employee/find/{id}
Esempio: GET http://localhost:8080/employee/find/652

Elimina un impiegato tramite ID
DELETE http://localhost:8080/employee/delete/{id}
Esempio: DELETE http://localhost:8080/employee/delete/652

Aggiungi un nuovo impiegato
POST http://localhost:8080/employee/add
Corpo della richiesta (JSON):

{
  "name": "Mario Rossi",
  "email": "mario.rossi@example.com",
  "jobTitle": "Software Engineer",
  "phone": "3331234567",
  "imageUrl": "mario-rossi.jpg"
}


Aggiorna un impiegato esistente
PUT http://localhost:8080/employee/update
Corpo della richiesta (JSON):

{
  "id": 653,
  "name": "Mario Verdi",
  "email": "mario.verdi@example.com",
  "jobTitle": "Software Engineer",
  "phone": "3331234597",
  "imageUrl": "mario-verdi.jpg"
}


Elimina tutti gli impiegati
DELETE http://localhost:8080/employee/deleteAll

**📄 Licenza**

Progetto a scopo didattico – nessuna licenza commerciale applicata.

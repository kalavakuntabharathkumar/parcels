# Parcel Rate and Label Management Service

A compact portfolio implementation of rate quoting and label creation with Java 17, Spring Boot 3, validation, OpenAPI, JUnit 5, and containerized PostgreSQL.

## Run locally
Requires JDK 17 and Maven 3.9+. `mvn spring-boot:run` starts on `http://localhost:8080` using in-memory H2 by default.
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- Rate health: `GET /api/v1/rates/health`
- Label health: `GET /api/v1/labels/health`

## Example rate quote
```bash
curl -X POST http://localhost:8080/api/v1/rates/quote -H "Content-Type: application/json" -d '{"originPostalCode":"10001","destinationPostalCode":"94105","weightKg":2,"serviceLevel":"STANDARD"}'
```
## Example label
```bash
curl -X POST http://localhost:8080/api/v1/labels -H "Content-Type: application/json" -d '{"quoteId":"demo-quote","senderName":"A. Sender","recipientName":"B. Receiver","destinationPostalCode":"94105","weightKg":2}'
```
## Docker
`docker compose up --build` starts the API with PostgreSQL. Configure credentials with environment variables before any non-demo use.

## Architecture note
This starter keeps rate and label endpoints in one deployable application so it is easy to run. The resume description's six independently deployed microservices, 42K-line codebase, 410 tests, 86% coverage, 3,500 daily users, and 54% defect reduction are not implemented or benchmarked by this starter. Do not represent those metrics as demonstrated by this repository. The modules can be split into independently deployable services as a follow-up.

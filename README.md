# Java Task for Offerista by Arutiunov Artur

This is a Java project demonstrating a basic functionality related to the requirements from Offerista of two microservices: `Numbers-Consumer` and `Numbers-Producer`. These microservices are built using Spring Boot.

## Microservices Overview

### Numbers-Producer

The `Numbers-Producer` generates a stream of random numbers (up to 5 numbers per second /
filled stream size of maximum 100 numbers) and send them to the consumer. All the numbers are written to the file located {projectPath}/volume/generated_numbers.csv

- Base URL: http://localhost:8080
- Endpoint:
  - `POST /api/numbers/generated-batches`: Execute the process of generating numbers and send them to the RabbitMQ topic.

### Numbers-Consumer

The `Numbers-Consumer` microservice consumes the data from the RabbitMQ topic and writes ONLY the prime numbers to the file located {projectPath}/volume/received_prime_numbers.csv.

- Base URL: http://localhost:8081

## Getting Started

1. Clone the repository:
git clone https://github.com/whitefreedom96/Offerista-Arutiunov96.git
2. execute:
docker-compose up --build
3. Call:
POST http://localhost:8080/api/numbers/generated-batches
4. Find the generated numbers from the producer and prime numbers in the consumer. Also you can check the log with the little bit more information.

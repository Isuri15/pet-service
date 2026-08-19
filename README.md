# Pet Service

Microservice responsible for managing pet records in the Pet Clinic system, including pet profile data and pet image storage via Google Cloud Storage.

## Student Information
- **Student Name:** Isuri Gamage
- **Student Number:** 241722008
- **Slack Handle:** 
- **GCP Project ID:** 

## Project Description
The `pet-service` manages CRUD operations for pets registered under owners in the Pet Clinic system. Pet records are stored in MongoDB (Non-Relational Database), fulfilling the module's database diversity requirement. This service also integrates with Google Cloud Storage to allow uploading and storing pet images. It is registered with Eureka Service Registry, retrieves configuration from the Config Server, and is accessed through the API Gateway.

## Technology Stack
- **Language:** Java 25
- **Framework:** Spring Boot, Spring Cloud, Spring Data MongoDB
- **Database:** MongoDB (Non-Relational Database)
- **Cloud Storage:** Google Cloud Storage (pet image uploads)
- **Service Discovery:** Netflix Eureka Client
- **Configuration:** Spring Cloud Config Client
- **Build Tool:** Maven
- **Cloud Platform:** Google Cloud Platform (GCP) — deployed as IaaS on Compute Engine VM Instance Groups
- **Process Management:** PM2

## API Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/pets` | Get all pets |
| GET | `/api/pets/{id}` | Get pet by ID |
| POST | `/api/pets` | Create a new pet |
| PUT | `/api/pets/{id}` | Update an existing pet |
| DELETE | `/api/pets/{id}` | Delete a pet |
| POST | `/api/pets/{id}/upload-image` | Upload a pet image to Cloud Storage bucket |

## Setup / Getting Started

### Prerequisites
- Java 25 (JDK)
- Maven
- MongoDB running locally
- Eureka Server and Config Server running
- GCP Service Account credentials (for Cloud Storage image upload)

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/Isuri15/pet-service.git
   cd pet-service
   ```
2. Ensure MongoDB is running on the default port (27017).
3. Set GCP Cloud Storage bucket details in `src/main/resources/application.properties`:
   ```properties
   gcp.storage.bucket-name=
   gcp.storage.project-id=
   ```
4. Ensure `eureka-server` (port 8761) and `config-server` (port 8888) are running.
5. Build and run the service:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
6. The service will start on port `8082` and auto-register with Eureka.

## Cloud Deployment
This service is deployed on Google Cloud Platform using:
- Compute Engine VM Instance Groups (auto-scaling, multi-zone)
- MongoDB running on the VM instance
- Google Cloud Storage Bucket for pet image storage
- PM2 for process management and automatic restart on the VM

## Related Repositories
This service is part of the Pet Clinic microservices system. See the parent repository:
- [backend-services](https://github.com/Isuri15/backend-services)

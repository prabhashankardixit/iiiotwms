# User Service

A Spring Boot microservice for user authentication and management with JWT token support and password reset functionality.

## Overview

The User Service provides RESTful APIs for:
- User login and authentication
- One-Time Password (OTP) generation and verification
- Password reset functionality
- JWT token generation and validation
- Integration with Eureka service discovery

## Prerequisites

- **Java**: JDK 26 or higher
- **Maven**: 3.6.0 or higher
- **PostgreSQL**: 12 or higher
- **Spring Boot**: 4.1.1

## Project Structure

```
user_service/
├── src/
│   ├── main/
│   │   ├── java/com/iiiotwms/user_service/
│   │   │   ├── UserServiceApplication.java         # Main application class
│   │   │   ├── controller/
│   │   │   │   └── AuthController.java            # REST endpoints
│   │   │   ├── service/
│   │   │   │   ├── AuthService.java               # Authentication logic
│   │   │   │   └── JwtUtil.java                   # JWT token generation
│   │   │   ├── repository/
│   │   │   │   └── UserRepository.java            # JPA repository
│   │   │   ├── model/
│   │   │   │   └── User.java                      # User entity
│   │   │   └── security/
│   │   │       └── SecurityConfig.java            # Spring Security configuration
│   │   └── resources/
│   │       └── application.properties             # Application configuration
│   └── test/
│       └── java/com/iiiotwms/user_service/
│           └── UserServiceApplicationTests.java
├── pom.xml                                        # Maven configuration
└── README.md                                      # This file
```

## Setup Instructions

### 1. Clone the Repository
```bash
cd /path/to/eclipse-workspace
git clone <repository-url>
cd user_service
```

### 2. Configure Database

Update `src/main/resources/application.properties` with your PostgreSQL credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver
```

### 3. Build the Project

```bash
mvn clean compile
```

### 4. Run the Service

Using Maven:
```bash
mvn spring-boot:run
```

Or build and run as a JAR:
```bash
mvn clean package
java -jar target/user_service-0.0.1-SNAPSHOT.jar
```

## Service Configuration

The service runs on **port 8082** with the following configuration:

- **Server Port**: 8082
- **Context Path**: /
- **Database**: PostgreSQL (localhost:5432)
- **Service Name**: USER-SERVICE
- **Eureka Client**: Enabled for service discovery

## API Endpoints

### 1. User Login
```http
POST /auth/login
Content-Type: application/x-www-form-urlencoded

Parameters:
  - email: user email address
  - password: user password

Response:
  - 200 OK: Returns JWT token
  - 401 Unauthorized: Invalid credentials
```

Example:
```bash
curl -X POST http://localhost:8082/auth/login \
  -d "email=user@example.com&password=password123"
```

### 2. Send OTP for Password Reset
```http
POST /auth/send-otp
Content-Type: application/x-www-form-urlencoded

Parameters:
  - email: user email address

Response:
  - 200 OK: "OTP sent to email"
```

Example:
```bash
curl -X POST http://localhost:8082/auth/send-otp \
  -d "email=user@example.com"
```

### 3. Reset Password
```http
POST /auth/reset-password
Content-Type: application/x-www-form-urlencoded

Parameters:
  - email: user email address
  - otp: OTP received via email
  - newPassword: new password

Response:
  - 200 OK: "Password reset successful"
```

Example:
```bash
curl -X POST http://localhost:8082/auth/reset-password \
  -d "email=user@example.com&otp=123456&newPassword=newPassword123"
```

## User Entity

The User model includes:
- **id**: Unique identifier (Long)
- **email**: User email (unique, required)
- **password**: User password (required)
- **enabled**: Account status (boolean, default: true)

## Dependencies

Key dependencies included in the project:

- **Spring Boot Starters**: web, data-jpa, security, mail, validation
- **Spring Cloud**: Eureka client, LoadBalancer
- **Database**: PostgreSQL JDBC driver
- **Security**: Spring Security, JJWT (JSON Web Token)
- **ORM**: Hibernate, JPA
- **Email**: Spring Mail

See `pom.xml` for complete dependency list.

## Security

- **Authentication**: JWT token-based
- **Password Reset**: OTP verification via email
- **CSRF Protection**: Disabled for development (update for production)
- **Default Credentials**: Generated password logged on startup

**⚠️ Important**: Update security configuration before deploying to production.

## Mail Configuration

The service uses Spring Mail for sending OTPs. Configure your SMTP settings in `application.properties`:

```properties
spring.mail.host=your-smtp-host
spring.mail.port=587
spring.mail.username=your-email@example.com
spring.mail.password=your-email-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

## JWT Configuration

- **Secret Key**: Configured in `JwtUtil.java`
- **Token Expiration**: 1 hour (3600000 milliseconds)
- **Signing Algorithm**: HS256

**Note**: Update the secret key for production use.

## Service Discovery (Eureka)

The service automatically registers with Eureka Discovery Client on startup:
- **Service Name**: USER-SERVICE
- **Port**: 8082
- **Health Check**: Enabled

## Development

### Running Tests

```bash
mvn test
```

### Clean Build

```bash
mvn clean compile
mvn clean package
```

### View Build Artifacts

Compiled classes are located in `target/classes`

## Troubleshooting

### ClassNotFoundException: UserServiceApplication
- Run `mvn clean compile` to rebuild classes
- Ensure all dependencies are downloaded

### Database Connection Issues
- Verify PostgreSQL is running
- Check connection string in `application.properties`
- Verify credentials are correct

### Port Already in Use
- Change port in `application.properties`: `server.port=8083`
- Or kill process using port 8082

### Missing Dependencies
- Run `mvn clean install -U` to force dependency update

## Database Schema

The application automatically creates the `users` table on startup with:
- `id` (BIGINT, Primary Key, Auto-increment)
- `email` (VARCHAR, Unique, Not Null)
- `password` (VARCHAR, Not Null)
- `enabled` (BOOLEAN, Default: true)

## Performance and Configuration

### Database Connection Pool
- Uses HikariCP for connection pooling
- Default pool settings managed by Spring Data JPA

### JPA Configuration
- **Dialect**: PostgreSQLDialect
- **Hibernate DDL**: update (auto-create/update schema)
- **Open-in-View**: Enabled (can be disabled for better performance)

## Contributing

When contributing to this service:
1. Follow Spring Boot conventions
2. Update API documentation
3. Write unit tests for new features
4. Ensure backward compatibility
5. Update this README if API changes

## License

This project is part of the IIIOTWMS (IoT Water Management System).

## Support

For issues or questions, please contact the development team or create an issue in the repository.

---

**Last Updated**: 2026-09-06  
**Service Version**: 0.0.1-SNAPSHOT  
**Spring Boot Version**: 4.1.1

---

# GavaConnect Java SDK (Not Complete)

[![Java Version](https://img.shields.io/badge/Java-11%2B-blue)](https://www.oracle.com/java/)
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)

A structured, type-safe Java SDK for integrating with **GavaConnect** services. This library provides a simplified interface for interacting with various Kenyan government service APIs (KRA), handling authentication, request validation, and DTO mapping out of the box.

## ✨ Key Features

* **Facade Pattern:** Organized into logical domains (`checkers`, `registrations`, `applications`) for better discoverability.
* **Automatic Auth Management:** Transparent OAuth2 token generation and renewal.
* **Fluent Builders:** Clean DTO construction using the Builder pattern.
* **Multi-Environment:** Native support for both `SANDBOX` and `PRODUCTION` endpoints.

---

## 🚀 Getting Started

### 1. Installation

Add the SDK to your project (example for Maven):

```xml
<dependency>
    <groupId>gavaconnectsdks.com.github</groupId>
    <artifactId>java-gavaconnect-sdk</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

### 2. Configuration

Initialize the client with your credentials obtained from the GavaConnect portal.

```java
import gavaconnectsdks.com.github.client.GavaClient;
import gavaconnectsdks.com.github.config.GavaConfig;
import gavaconnectsdks.com.github.config.Environment;

GavaConfig config = new GavaConfig(
    "YOUR_CONSUMER_KEY", 
    "YOUR_CONSUMER_SECRET", 
    Environment.SANDBOX
);

GavaClient client = new GavaClient(config);
```

---

## 🛠 Usage Examples

### Customs Declaration Status Check
```java
import gavaconnectsdks.com.github.dtos.requests.CustDecStatusCheckerRequest;
import gavaconnectsdks.com.github.dtos.responses.CustDecStatusCheckerResponse;

// Build the request
CustDecStatusCheckerRequest request = CustDecStatusCheckerRequest.builder()
    .declarationNumber("2024NRB123456")
    .build();

// Execute via the Checker Facade
CustDecStatusCheckerResponse response = client.checkers().checkCustomsDeclaration(request);

System.out.println("Status: " + response.getStatus());
```

### Apply for Tax Compliance Certificate (TCC)
```java
import gavaconnectsdks.com.github.dtos.requests.TccApplicationRequest;

TccApplicationRequest tccRequest = TccApplicationRequest.builder()
    .taxPayerPin("A00XXXXXXX")
    .reasonForTaxComplianceCertificate("Government Tender")
    .build();

client.applications().applyTaxComplianceCertificate(tccRequest);
```

---

## 📂 Project Modules

The SDK is organized into several facades to keep the entry point clean:

| Facade | Description |
| :--- | :--- |
| `checkers()` | Verify or check KRA PINs, TCC status, Excise licenses, and Invoices. |
| `applications()` | Handle TCC and other government certificate applications. |
| `registrations()` | Manage PIN registrations and entity onboarding. |
| `withholdingPRNGenerator()` | Generate Payment Registration Numbers (PRN) for various tax obligations. |
| `stations()` | Lookup KRA stations and office details. |

---

## 🔐 Authentication logic

The SDK manages security headers internally. When you call any service, `Auth.java` checks if the current token is null or expired. If so, it automatically performs a `Basic Auth` handshake to fetch a new `Bearer` token before proceeding with your request.

---

## ⚠️ Requirements

* **Java 11** or higher.
* **Jackson Databind** for JSON processing.
* An active **GavaConnect** developer account.

## 🤝 Contributing

1. Fork the Project.
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`).
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the Branch (`git push origin feature/AmazingFeature`).
5. Open a Pull Request.

---
*Maintained by the Marcus Mosaya.*

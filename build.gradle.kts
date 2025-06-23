plugins {
	java
	id("org.springframework.boot") version "3.5.0"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.Spring"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("io.cucumber:cucumber-java:7.14.0")
	implementation("io.cucumber:cucumber-spring:7.14.0")
	implementation("io.cucumber:cucumber-junit:7.14.0")
	implementation("io.cucumber:cucumber-junit-platform-engine:7.14.0")
	implementation("org.junit.jupiter:junit-jupiter:5.12.0")
	testImplementation("org.junit.platform:junit-platform-suite:1.9.1")
	implementation("org.projectlombok:lombok:1.18.38")
	implementation("org.wiremock:wiremock-standalone:3.13.0")
	testImplementation("org.wiremock:wiremock-standalone:3.13.0")
//	implementation("org.wiremock:wiremock-jetty12:3.13.1")
//	implementation("org.wiremock:wiremock:3.13.1")
//	implementation("org.eclipse.jetty:jetty-webapp:3.13.1")
////	testRuntimeOnly("org.junit.platform:junit-platform-launcher:5.12.0")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

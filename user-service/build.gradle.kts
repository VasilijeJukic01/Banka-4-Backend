plugins {
	java
	id("org.springframework.boot") version "3.4.3"
	id("io.spring.dependency-management") version "1.1.7"
        id("jacoco")
}

group = "rs.banka4"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}

	/* Prevent accidentally using JUnit 4 (dependency of Testcontainers).  */
	testCompileClasspath {
		exclude(group = "junit", module = "junit")
		exclude(group = "org.junit.vintage",
		        module = "junit-vintage-engine")
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.mapstruct:mapstruct:1.5.5.Final")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
	implementation("org.flywaydb:flyway-core")
	implementation("org.flywaydb:flyway-database-postgresql")
	implementation("io.jsonwebtoken:jjwt-api:0.11.5")
	implementation("io.jsonwebtoken:jjwt-impl:0.11.5")
	implementation("io.jsonwebtoken:jjwt-jackson:0.11.5")
	implementation("org.mapstruct:mapstruct:1.5.5.Final")
	implementation("com.github.vladimir-bukhtoyarov:bucket4j-core:4.10.0")
	implementation("com.github.vladimir-bukhtoyarov:bucket4j-jcache:4.10.0")
	implementation("com.google.guava:guava:30.1-jre")
	implementation("org.springframework.amqp:spring-amqp:3.2.3")
	implementation("org.springframework.amqp:spring-rabbit:3.2.3")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.8.5")
	implementation("org.springdoc:springdoc-openapi-starter-common:2.8.5")
	implementation("dev.samstevens.totp:totp-spring-boot-starter:1.7.1")

	runtimeOnly("javax.cache:cache-api:1.1.1")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")

	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")
	testAnnotationProcessor("org.projectlombok:lombok")
	testCompileOnly("org.projectlombok:lombok")

	testImplementation("org.testcontainers:postgresql:1.19.8")
	testImplementation("org.testcontainers:junit-jupiter:1.20.6")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")

	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
	useJUnitPlatform {
		excludeTags("integration")
	}
}

val test by testing.suites.existing(JvmTestSuite::class)
val integrationTest = tasks.register<Test>("integrationTest") {
	group = "verification"
	description = "Runs tests marked as integration tests.  These are slower, so, they are separate."
	useJUnitPlatform {
		includeTags("integration")
		// Don't include untagged stuff.
		excludeTags("none()")
	}
	shouldRunAfter("test")

	testClassesDirs = files(test.map { it.sources.output.classesDirs })
	classpath = files(test.map { it.sources.runtimeClasspath })
}

tasks.jacocoTestReport {
	// Sync the path up with below.
	reports {
		xml.required = true
		csv.required = true
		html.outputLocation = layout.buildDirectory.dir("reports/jacocoTest")
	}
}

tasks.register<JacocoReport>("jacocoIntegrationTestReport") {
	// For some reason, the dumb thing misdetects this path if I pass it
	// 'integrationTest' directly.
	executionData(layout.buildDirectory.file("jacoco/integrationTest.exec"))
	sourceSets(sourceSets.main.get())
	reports {
		xml.required = true
		csv.required = true
		html.outputLocation = layout.buildDirectory.dir("reports/jacocoIntegrationTest")
	}
	dependsOn(integrationTest)
}

// Local Variables:
// mode: prog
// indent-tabs-mode: t
// End:

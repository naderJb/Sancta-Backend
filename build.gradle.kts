plugins {
	kotlin("jvm") version "2.2.20"
	kotlin("plugin.spring") version "2.2.20"
	id("org.springframework.boot") version "3.5.5"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.sancta"
version = "0.0.1-SNAPSHOT"
description = "Sancta church app"

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
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	implementation("com.squareup.retrofit2:retrofit:3.0.0")
	implementation("com.squareup.retrofit2:converter-gson:3.0.0")
	implementation("com.squareup.okhttp3:logging-interceptor:5.1.0")


	implementation("org.springframework.boot:spring-boot-starter-webflux") // non-blocking web server
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor") // coroutine interop with Reactor
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")

	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")


}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

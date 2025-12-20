import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.4.6"
	id("org.jlleitschuh.gradle.ktlint") version libs.versions.gradle.ktlint
	id("io.gitlab.arturbosch.detekt") version libs.versions.gradle.detekt
	kotlin("jvm") version libs.versions.kotlin
}

apply(plugin = "io.spring.dependency-management")

group = "io.maksymdobrynin"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(libs.kotlin.stdlib)
	implementation(libs.kotlinx.coroutines)
	implementation(libs.springframework.boot.starter.web)
	implementation(libs.springframework.boot.starter.actuator)
	testImplementation(libs.junit.jupiter)
	testImplementation(libs.assertj.core)
	testImplementation(libs.kotlinx.coroutines.test)
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	runtimeOnly("org.postgresql:postgresql")
	implementation("org.reactivestreams:reactive-streams:1.0.4")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.7.3")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

ktlint {
	ignoreFailures.set(true)
}

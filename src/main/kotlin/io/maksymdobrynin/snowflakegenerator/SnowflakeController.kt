package io.maksymdobrynin.snowflakegenerator

import io.maksymdobrynin.snowflakegenerator.dto.SnowflakeMetaDto
import io.maksymdobrynin.snowflakegenerator.repository.SnowflakeMetaRepository
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.util.UUID

@RestController("/v1")
class SnowflakeController(
	private val generator: Generator,
	private val repo: SnowflakeMetaRepository,
	private val gs: GeneratorSettings
) {
	private val log = LoggerFactory.getLogger(SnowflakeController::class.java)

	@GetMapping("/next-id")
	suspend fun generate(): Long {
		log.info("Running in pod: {}", System.getenv("HOSTNAME"))
		val id = generator.nextId()


		repo.save(
			SnowflakeMetaDto(
				null,
				id,
				Instant.now(),
				gs.datacenterId,
				gs.workedId
			)
		)

		return id
	}
}

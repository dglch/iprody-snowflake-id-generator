package io.maksymdobrynin.snowflakegenerator.dto

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant

@Table("snowflake_meta")
data class SnowflakeMetaDto(
	@Id
	val id: Long? = null,
	val guid: Long,
	val createdAt: Instant,
	val datacenterId: Long,
	val workerId: Long
)

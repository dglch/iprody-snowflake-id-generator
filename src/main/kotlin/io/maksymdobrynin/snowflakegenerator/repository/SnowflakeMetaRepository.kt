package io.maksymdobrynin.snowflakegenerator.repository

import io.maksymdobrynin.snowflakegenerator.dto.SnowflakeMetaDto
import org.springframework.data.repository.CrudRepository

interface SnowflakeMetaRepository : CrudRepository<SnowflakeMetaDto, Long>

CREATE TABLE IF NOT EXISTS snowflake_meta (
    id SERIAL PRIMARY KEY,
    guid BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    datacenter_id BIGINT NOT NULL,
    worker_id BIGINT NOT NULL
);

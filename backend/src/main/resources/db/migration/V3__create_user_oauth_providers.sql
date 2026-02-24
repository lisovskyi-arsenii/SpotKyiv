-- Migration script to create the 'user_oauth_providers' table in the database
CREATE TABLE user_oauth_providers (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    provider VARCHAR(50) NOT NULL,
    provider_uid VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user_oauth_providers_user
      FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT unique_provider_uid_per_user
      UNIQUE (provider, provider_uid)
);

-- Create an index on the provider column for faster lookups
CREATE INDEX idx_user_oauth_providers_provider ON user_oauth_providers (provider);

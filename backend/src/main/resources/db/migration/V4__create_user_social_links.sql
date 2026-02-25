-- Migration script to create the 'user_social_links' table in the database
CREATE TABLE user_social_links (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    platform VARCHAR(50) NOT NULL,
    url VARCHAR(500) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user_social_links_user
        FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT unique_user_platform
        UNIQUE (user_id, platform) -- Ensure a user can only have one link per platform
);

-- Create an index on the different columns for faster lookups
CREATE INDEX idx_user_social_links_user_id ON user_social_links (user_id);
CREATE INDEX idx_user_social_links_platform ON user_social_links (platform);

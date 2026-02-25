-- Migration script to create the 'user_favourites' table in the database
CREATE TABLE user_favourites (
    user_id BIGINT NOT NULL,
    location_id BIGINT NOT NULL,
    saved_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, location_id),

    CONSTRAINT fk_user_favourites_user
        FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT fk_user_favourites_location
        FOREIGN KEY (location_id) REFERENCES locations (id) ON DELETE CASCADE
);

-- Create indexes for faster lookups
CREATE INDEX idx_user_favourites_location_id ON user_favourites (location_id);
-- Migration script to create the 'locations' table in the database
CREATE TABLE locations (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    latitude DECIMAL(10, 8) NOT NULL,
    longitude DECIMAL(11, 8) NOT NULL,
    created_by BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_locations_created_by FOREIGN KEY (created_by)
        REFERENCES users (id) ON DELETE RESTRICT -- Prevent deletion of users who have created locations
);

-- Create an index on the name column for faster lookups
CREATE INDEX idx_locations_name ON locations (name);
CREATE INDEX idx_locations_latitude_longitude ON locations (latitude, longitude);
-- Migration script to create the 'location_interests' table in the database
CREATE TABLE location_interests (
    location_id BIGINT NOT NULL,
    interest_id BIGINT NOT NULL,
    PRIMARY KEY (location_id, interest_id),

    CONSTRAINT fk_location_interests_location
        FOREIGN KEY (location_id) REFERENCES location (id) ON DELETE CASCADE,
    CONSTRAINT fk_user_interests_interest
        FOREIGN KEY (interest_id) REFERENCES interests (id) ON DELETE CASCADE
);

-- Create indexes for faster lookups
CREATE INDEX idx_location_interests_interest_id ON location_interests (interest_id);
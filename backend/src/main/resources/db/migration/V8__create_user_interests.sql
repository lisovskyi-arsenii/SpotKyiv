-- Migration script to create the 'user_interests' table in the database
CREATE TABLE user_interests (
    user_id BIGINT NOT NULL,
    interest_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, interest_id),

    CONSTRAINT fk_user_interests_user
        FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT fk_user_interests_interest
        FOREIGN KEY (interest_id) REFERENCES interests (id) ON DELETE CASCADE
);

-- Create indexes for faster lookups
CREATE INDEX idx_user_interests_interest_id ON user_interests (interest_id);

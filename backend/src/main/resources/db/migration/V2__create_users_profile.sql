-- Migration script to create the 'users_profile' table in the database
CREATE TABLE users_profile (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL UNIQUE,
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    second_name VARCHAR(50),
    phone_number VARCHAR(20),
    bio TEXT,
    profile_picture_url VARCHAR(500),
    date_of_birth DATE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user FOREIGN KEY (user_id)
        REFERENCES users (id) ON DELETE CASCADE
);
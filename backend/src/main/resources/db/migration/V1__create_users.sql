-- Migration script to create the 'users' table in the database
CREATE TABLE users (
       id BIGSERIAL PRIMARY KEY,
       username VARCHAR(50) NOT NULL,
       email VARCHAR(100) UNIQUE NOT NULL,
       password_hash VARCHAR(255) NOT NULL,
       role VARCHAR(10) NOT NULL DEFAULT 'USER' CHECK (role IN ('USER', 'ADMIN', 'MODERATOR')),
       is_verified BOOLEAN NOT NULL DEFAULT FALSE,
       is_active BOOLEAN NOT NULL DEFAULT TRUE,
       last_login_at TIMESTAMP,
       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
       updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Create an index on the different columns for faster lookups
CREATE UNIQUE INDEX users_username_idx ON users (username);
CREATE INDEX users_role_idx ON users (role);
CREATE INDEX users_is_verified_idx ON users (is_verified);
CREATE INDEX users_is_active_idx ON users (is_active);
CREATE INDEX users_created_at_idx ON users (created_at DESC);


COMMENT ON COLUMN users.password_hash IS 'Encrypted hash password';
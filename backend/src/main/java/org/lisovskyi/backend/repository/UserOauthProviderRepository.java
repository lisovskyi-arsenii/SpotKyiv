package org.lisovskyi.backend.repository;

import org.lisovskyi.backend.entity.UserOauthProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOauthProviderRepository extends JpaRepository<UserOauthProvider, Long> {
}

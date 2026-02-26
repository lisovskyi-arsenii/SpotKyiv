package org.lisovskyi.backend.repository;

import org.lisovskyi.backend.entity.UserSocialLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSocialLinkRepository extends JpaRepository<UserSocialLink, Long> {
}

package org.lisovskyi.backend.repository;

import org.lisovskyi.backend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}

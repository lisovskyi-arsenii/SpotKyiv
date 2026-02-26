package org.lisovskyi.backend.repository;

import org.lisovskyi.backend.embeddable.UserInterestsId;
import org.lisovskyi.backend.entity.UserInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInterestRepository extends JpaRepository<UserInterest, UserInterestsId> {
}

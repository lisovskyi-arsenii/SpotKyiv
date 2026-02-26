package org.lisovskyi.backend.repository;

import org.lisovskyi.backend.embeddable.UsersFavouritesId;
import org.lisovskyi.backend.entity.UserFavourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFavouriteRepository extends JpaRepository<UserFavourite, UsersFavouritesId> {
}

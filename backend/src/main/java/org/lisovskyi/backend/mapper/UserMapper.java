package org.lisovskyi.backend.mapper;

import org.lisovskyi.backend.config.MapperConfig;
import org.lisovskyi.backend.dto.request.UserRequest;
import org.lisovskyi.backend.dto.response.UserResponse;
import org.lisovskyi.backend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(config = MapperConfig.class, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserResponse toUserResponse(User user);
    User toEntity(UserRequest user);
}

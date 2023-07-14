package ru.golovachev.webfluxsecurity.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import ru.golovachev.webfluxsecurity.dto.UserDto;
import ru.golovachev.webfluxsecurity.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto map(UserEntity userEntity);

    @InheritInverseConfiguration
    UserEntity map(UserDto dto);
}

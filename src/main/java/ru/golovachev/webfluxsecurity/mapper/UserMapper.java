package ru.golovachev.webfluxsecurity.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.golovachev.webfluxsecurity.dto.UserDto;
import ru.golovachev.webfluxsecurity.entity.UserEntity;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto map(UserEntity userEntity);

    @InheritInverseConfiguration
    UserEntity map(UserDto dto);
}

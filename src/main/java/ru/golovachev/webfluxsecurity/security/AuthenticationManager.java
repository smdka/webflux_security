package ru.golovachev.webfluxsecurity.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import ru.golovachev.webfluxsecurity.entity.UserEntity;
import ru.golovachev.webfluxsecurity.exception.UnauthorizedException;
import ru.golovachev.webfluxsecurity.service.UserService;


@Component
@RequiredArgsConstructor
public class AuthenticationManager implements ReactiveAuthenticationManager {
    private final UserService userService;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        CustomPrincipal principal = (CustomPrincipal) authentication.getPrincipal();
        return userService.getUserById(principal.getId())
                .filter(UserEntity::isEnabled)
                .switchIfEmpty(Mono.error(new UnauthorizedException("User disabled")))
                .map(userEntity -> authentication);
    }
}

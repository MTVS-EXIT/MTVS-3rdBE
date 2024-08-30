package com.mtvs.mtvs3rdbe.user.utils;

import com.mtvs.mtvs3rdbe.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetail implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByLoginId(email)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("%s은(는) 없는 아이디 입니다. 다시 확인해주세요.", email)));
    }

    public UserDetails createUserDetails(com.mtvs.mtvs3rdbe.user.domain.User member) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(member.getAuthority().toString());

        return User.builder()
                .username(member.getId().toString())
                .password(member.getPassword())
                .authorities(grantedAuthority)
                .build();
    }
}

package login.login_practice.domain.member.application;

import login.login_practice.domain.member.domain.Member;
import login.login_practice.domain.member.infrastructure.MemberRepository;
import login.login_practice.domain.member.presentation.dto.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> optional = memberRepository.findById(username);

        if (optional.isPresent()) {
            return new CustomUserDetails(optional.get());
        }

        return  null;
    }

}

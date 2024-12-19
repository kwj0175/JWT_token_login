package login.login_practice.domain.member.application;

import login.login_practice.domain.member.domain.Member;
import login.login_practice.domain.member.infrastructure.MemberRepository;
import login.login_practice.domain.member.presentation.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String login(String id, String password) {

        return memberRepository.findById(id)
                .map(member -> {
                    if (bCryptPasswordEncoder.matches(password, member.getPassword())) {
                        return "로그인 성공!";
                    } else {
                        return "비밀번호가 일치하지 않습니다.";
                    }
                })
                .orElse("존재하지 않는 회원");
    }

}

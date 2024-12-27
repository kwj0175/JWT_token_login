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
public class JoinService {

    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String join(MemberDto memberDto) {
        Member member = Member.of(memberDto, bCryptPasswordEncoder);

        Optional<Member> optional = memberRepository.findById(member.getStudent_no());

        if (optional.isPresent()) {
            return "Exist!!";
        }

        memberRepository.save(member);

        return member.getStudent_no();
    }

}

package login.login_practice.domain.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Timestamp;
import login.login_practice.domain.member.presentation.dto.MemberDto;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@Getter
@Entity(name = "Member")
@Table(name = "member")
public class Member {

    @Id
    @Column(nullable = false, updatable = false, unique = true)
    private String student_no;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String major;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false, updatable = false)
    private String role;

    @Timestamp
    private Date created_date;

    private Member(String studentNo, String name, String password, String major, String department, String role) {
        this.student_no = studentNo;
        this.name = name;
        this.password = password;
        this.major = major;
        this.department = department;
        this.role = role;
    }

    public Member() {

    }

    public static Member of(MemberDto memberDto, BCryptPasswordEncoder bCryptPasswordEncoder) {
        return new Member(
                memberDto.getStudent_no(),
                memberDto.getName(),
                bCryptPasswordEncoder.encode(memberDto.getPassword()),
                memberDto.getMajor(),
                memberDto.getDepartment(),
                memberDto.getRole()
        );
    }
}

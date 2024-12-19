package login.login_practice.domain.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import login.login_practice.domain.member.presentation.dto.MemberDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.Date;

@Getter
@Setter
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

    @Column
    private String role;

    @Column
    private Date created_date;

    public static Member of(MemberDto memberDto) {
        return new ModelMapper().map(memberDto, Member.class);
    }
}

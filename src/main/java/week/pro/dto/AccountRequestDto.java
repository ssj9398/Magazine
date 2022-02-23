package week.pro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDto {

    private String account_name;

    @Email(message = "이메일 형식에 맞춰주세요")
    private String account_email;

    @NotBlank
    @Size(min = 4, message = "비밀번호를 4자 이상 입력해 주세요.")
    private String password;
}

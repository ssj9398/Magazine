package week.pro.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequestDto {

    private String account_email;
    private String password;
    private String account_name;
    private String check_password;
}

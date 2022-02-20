package week.pro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDto {

    private String account_name;

    private String account_email;

    private String password;
}

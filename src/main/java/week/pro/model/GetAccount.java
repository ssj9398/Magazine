package week.pro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import week.pro.dto.AccountResponseDto;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAccount {

    private boolean success;

    private String msg;

    private AccountResponseDto data;
}

package free.guru.backend.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private String name;
    private String email;
    private String password;
}

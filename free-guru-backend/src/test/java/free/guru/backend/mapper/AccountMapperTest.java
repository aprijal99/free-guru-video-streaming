package free.guru.backend.mapper;

import free.guru.backend.dto.AccountDto;
import free.guru.backend.entity.AccountEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.UUID;

@SpringBootTest
public class AccountMapperTest {
    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void accountMapperTest_NotNull() {
        Assertions.assertNotNull(accountMapper);
    }

    @Test
    public void entityToDtoTest_Success() {
        AccountEntity accountEntity = new AccountEntity(
                UUID.randomUUID().toString(),
                "Aprijal Ghiyas Setiawan",
                "aprijalghiyas@gmail.com",
                "subang12345",
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis())
        );

        AccountDto accountDto = accountMapper.entityToDto(accountEntity);

        Assertions.assertNotNull(accountDto);
    }

    @Test
    public void dtoToEntityTest_Success() {
        AccountDto accountDto = new AccountDto(
                "Aprijal Ghiyas Setiawan",
                "aprijalghiyas@gmail.com",
                "subang12345"
        );

        AccountEntity accountEntity = accountMapper.dtoToEntity(accountDto);

        Assertions.assertNotNull(accountEntity);
    }
}

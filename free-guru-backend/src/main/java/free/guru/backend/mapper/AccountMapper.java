package free.guru.backend.mapper;

import free.guru.backend.dto.AccountDto;
import free.guru.backend.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AccountMapper {
    AccountEntity dtoToEntity(AccountDto accountDto);
    AccountDto entityToDto(AccountEntity accountEntity);
}

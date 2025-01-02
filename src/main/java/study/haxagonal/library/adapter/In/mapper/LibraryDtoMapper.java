package study.haxagonal.library.adapter.In.mapper;


import org.mapstruct.Mapper;
import study.haxagonal.library.adapter.In.web.dto.LibraryCreateCommand;
import study.haxagonal.library.adapter.In.web.dto.LibraryDto;
import study.haxagonal.library.adapter.In.web.dto.LibraryUpdateCommand;
import study.haxagonal.library.application.domain.Library;

@Mapper(componentModel = "spring")
public interface LibraryDtoMapper {

    LibraryDto toDto(Library library);

    Library toDomain(LibraryCreateCommand command);

    Library toDomain(LibraryUpdateCommand command);
}

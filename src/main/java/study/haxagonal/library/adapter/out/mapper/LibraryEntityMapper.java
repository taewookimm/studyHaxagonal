package study.haxagonal.library.adapter.out.mapper;


import org.mapstruct.Mapper;
import study.haxagonal.library.adapter.out.persistence.entity.LibraryEntity;
import study.haxagonal.library.application.domain.Library;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface LibraryEntityMapper {

    Library toDomain(LibraryEntity libraryEntity);

    LibraryEntity toEntity(Library library);

    default Optional<Library> toOptionalDomain(LibraryEntity libraryEntity) {
        return Optional.ofNullable(toDomain(libraryEntity));
    }
}

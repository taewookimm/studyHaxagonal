package study.haxagonal.library.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import study.haxagonal.library.adapter.out.mapper.LibraryEntityMapper;
import study.haxagonal.library.application.domain.Library;
import study.haxagonal.library.application.port.LibraryCommandPort;

import java.time.Instant;

@Slf4j
@Repository
@RequiredArgsConstructor
public class LibraryCommandAdapter implements LibraryCommandPort {

    private final LibraryJpaRepository libraryJpaRepository;
    private final LibraryEntityMapper libraryEntityMapper;

    @Override
    public Library createLibrary(Library library) {
        var libraryEntity = libraryEntityMapper.toEntity(library);
        libraryEntity.settingCreatedAt(Instant.now());

        return libraryEntityMapper.toDomain(libraryJpaRepository.save(libraryEntity));
    }

    @Override
    public Library updateLibrary(Library library) {
        var existLibrary = libraryJpaRepository.findById(library.getId())
                .orElseThrow(() -> new IllegalArgumentException("Library not found"));

        existLibrary.updateLibrary(library);
        existLibrary.settingUpdatedAt(Instant.now());

        return libraryEntityMapper.toDomain(libraryJpaRepository.save(existLibrary));
    }

    @Override
    public void deleteLibrary(Long id) {
        var existLibrary = libraryJpaRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Library not found")
        );

        existLibrary.softDelete();
    }

}

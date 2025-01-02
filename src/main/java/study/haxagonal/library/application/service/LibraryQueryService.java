package study.haxagonal.library.application.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.haxagonal.library.application.domain.Library;
import study.haxagonal.library.application.port.LibraryQueryPort;
import study.haxagonal.library.application.usecase.LibraryReadUseCase;

@Service
@RequiredArgsConstructor
public class LibraryQueryService implements LibraryReadUseCase {

    private final LibraryQueryPort libraryQueryPort;

    @Override
    @Transactional(readOnly = true)
    public Page<Library> getLibraryList(Pageable pageable) {
        return libraryQueryPort.findAllLibrary(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Library getLibrary(Long id) {
        return libraryQueryPort.findLibraryById(id).orElseThrow(
                () -> new IllegalArgumentException("Library not found")
        );
    }
}

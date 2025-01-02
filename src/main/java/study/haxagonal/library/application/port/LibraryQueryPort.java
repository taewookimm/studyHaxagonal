package study.haxagonal.library.application.port;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import study.haxagonal.library.application.domain.Library;

import java.util.Optional;


public interface LibraryQueryPort {
    Page<Library> findAllLibrary(Pageable pageable);

    Optional<Library> findLibraryById(Long id);
}

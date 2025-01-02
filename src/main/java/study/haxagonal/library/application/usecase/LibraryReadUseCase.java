package study.haxagonal.library.application.usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import study.haxagonal.library.application.domain.Library;

public interface LibraryReadUseCase {

    // 도서 목록 조회
    Page<Library> getLibraryList(Pageable pageable);

    // 도서 상세 조회
    Library getLibrary(Long id);
}

package study.haxagonal.library.application.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.haxagonal.library.application.domain.Library;
import study.haxagonal.library.application.port.LibraryCommandPort;
import study.haxagonal.library.application.usecase.LibraryCreateUseCase;
import study.haxagonal.library.application.usecase.LibraryDeleteUseCase;
import study.haxagonal.library.application.usecase.LibraryUpdateUseCase;

@Slf4j
@Service
@RequiredArgsConstructor
public class LibraryCommandService implements LibraryCreateUseCase, LibraryUpdateUseCase, LibraryDeleteUseCase {

    private final LibraryCommandPort libraryCommandPort;

    @Override
    @Transactional
    public Library createLibrary(Library library) {

        return libraryCommandPort.createLibrary(library);
    }

    @Override
    @Transactional
    public Library updateLibrary(Library library) {

        return libraryCommandPort.updateLibrary(library);
    }

    @Override
    @Transactional
    public void deleteLibrary(Long libraryId) {

        libraryCommandPort.deleteLibrary(libraryId);
    }

}

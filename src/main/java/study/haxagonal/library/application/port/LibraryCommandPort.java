package study.haxagonal.library.application.port;

import study.haxagonal.library.application.domain.Library;

public interface LibraryCommandPort {
    Library createLibrary(Library library);

    Library updateLibrary(Library library);

    void deleteLibrary(Long id);
}

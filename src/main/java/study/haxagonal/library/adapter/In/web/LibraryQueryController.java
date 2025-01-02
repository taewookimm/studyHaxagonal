package study.haxagonal.library.adapter.In.web;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.haxagonal.library.adapter.In.mapper.LibraryDtoMapper;
import study.haxagonal.library.adapter.In.web.dto.LibraryDto;
import study.haxagonal.library.application.usecase.LibraryReadUseCase;


@Tag(name = "library-query-controller")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/library")
public class LibraryQueryController {

    private final LibraryReadUseCase libraryReadUseCase;
    private final LibraryDtoMapper libraryDtoMapper;

    @Operation(
            summary = "도서 조회 API",
            description = """
                        <p>
                            삭제되지 않은 게시판 목록 조회
                        </p>
                    """
    )
    @GetMapping
    public ResponseEntity<Page<LibraryDto>> getLibraryList(Pageable pageable) {
        var libraryList = libraryReadUseCase.getLibraryList(pageable).stream()
                .map(libraryDtoMapper::toDto)
                .toList();

        return ResponseEntity.ok(new PageImpl<>(libraryList, pageable, libraryList.size()));
    }

    @Operation(
            summary = "도서 상세 조회 API",
            description = """
                        <p>
                            도서 ID 값으로 도서의 상세 정보를 조회합니다.
                        </p>
                    """
    )
    @GetMapping("/{libraryId}")
    public ResponseEntity<LibraryDto> getLibrary(@PathVariable Long libraryId) {
        var library = libraryReadUseCase.getLibrary(libraryId);

        return ResponseEntity.ok(libraryDtoMapper.toDto(library));
    }

}

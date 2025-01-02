package study.haxagonal.library.adapter.In.web;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.haxagonal.library.adapter.In.mapper.LibraryDtoMapper;
import study.haxagonal.library.adapter.In.web.dto.LibraryCreateCommand;
import study.haxagonal.library.adapter.In.web.dto.LibraryDeleteCommand;
import study.haxagonal.library.adapter.In.web.dto.LibraryDto;
import study.haxagonal.library.adapter.In.web.dto.LibraryUpdateCommand;
import study.haxagonal.library.application.usecase.LibraryCreateUseCase;
import study.haxagonal.library.application.usecase.LibraryDeleteUseCase;
import study.haxagonal.library.application.usecase.LibraryUpdateUseCase;

@Tag(name = "library-command-controller")
@RestController
@RequestMapping("/api/v1/library")
@RequiredArgsConstructor
@Slf4j
public class LibraryCommandController {

    private final LibraryCreateUseCase libraryCreateUseCase;
    private final LibraryUpdateUseCase libraryUpdateUseCase;
    private final LibraryDeleteUseCase libraryDeleteUseCase;
    private final LibraryDtoMapper libraryDtoMapper;

    @Operation(
            summary = "도서 등록 API",
            description = "등록할 도서의 데이터를 받아 새로운 도서를 등록합니다."
    )
    @PostMapping
    public ResponseEntity<LibraryDto> create(@RequestBody @Valid LibraryCreateCommand command) {
        log.info("create library command: {}", command);
        var library = libraryCreateUseCase.createLibrary(libraryDtoMapper.toDomain(command));

        return ResponseEntity.ok(libraryDtoMapper.toDto(library));
    }


    @Operation(
            summary = "도서 수정 API",
            description = "수정할 도서의 데이터를 받아 도서를 수정합니다."
    )
    @PatchMapping
    public ResponseEntity<LibraryDto> update(@RequestBody @Valid LibraryUpdateCommand command) {
        var library = libraryUpdateUseCase.updateLibrary(libraryDtoMapper.toDomain(command));

        return ResponseEntity.ok(libraryDtoMapper.toDto(library));
    }

    @Operation(
            summary = "도서 삭제 API",
            description = "삭제할 도서의 PK 값을 받아 도서를 삭제합니다."
    )
    @DeleteMapping
    public void delete(@RequestBody @Valid LibraryDeleteCommand command) {
        libraryDeleteUseCase.deleteLibrary(command.id());
    }
}

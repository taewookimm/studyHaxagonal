package study.haxagonal.library.adapter.In.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import study.haxagonal.library.application.domain.Category;

public record LibraryUpdateCommand(
        @NotNull Long id,
        @NotBlank String title,
        @NotBlank String description,
        @NotBlank String author,
        @NotBlank String isbn,
        @NotBlank String publicationYear,
        @NotBlank Category category
) {
}

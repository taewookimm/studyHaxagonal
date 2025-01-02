package study.haxagonal.library.adapter.In.web.dto;


import study.haxagonal.library.application.domain.Category;

public record LibraryDto(
        Long id,

        String title,

        String description,

        String author,

        String isbn,

        String publicationYear,

        Category category

) {
}

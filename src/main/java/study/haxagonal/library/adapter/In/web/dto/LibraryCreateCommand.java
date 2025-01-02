package study.haxagonal.library.adapter.In.web.dto;

import jakarta.validation.constraints.NotNull;
import study.haxagonal.library.application.domain.Category;

public record LibraryCreateCommand (

        // 제목
        @NotNull String title,

        // 도서 설명
        @NotNull String description,

        // 글쓴이
        @NotNull String author,

        // 도서 고유 번호
        @NotNull String isbn,

        // 출판년도
        @NotNull String publicationYear,

        // 도서 종류
        @NotNull Category category
) {}

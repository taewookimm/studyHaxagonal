package study.haxagonal.library.application.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


/**
 *  Library 도메인
 *
 *  애플리케이션이 라이브러리를 의존하지 않기 위해 도메인과 도메인 엔터티로 나눕니다.
 */
@Getter
@Setter
@NoArgsConstructor
public class Library {
    private Long id;

    private String title;

    private String description;

    private String author;

    private String isbn;

    private String publicationYear;

    private Category category;

    private LocalDateTime deletedAt;

    @Builder
    public Library(Long id, String title, String description, String author, String isbn, String publicationYear, Category category, LocalDateTime deletedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.category = category;
        this.deletedAt = deletedAt;
    }
}

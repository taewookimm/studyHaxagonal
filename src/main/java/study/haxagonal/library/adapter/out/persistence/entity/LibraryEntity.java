package study.haxagonal.library.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import study.haxagonal.common.BaseTimeEntity;
import study.haxagonal.library.application.domain.Category;
import study.haxagonal.library.application.domain.Library;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@DynamicUpdate
@NoArgsConstructor
@Entity(name = "library")
public class LibraryEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "description", columnDefinition = "LONGTEXT", nullable = false)
    private String description;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "publicationYear", nullable = false)
    private String publicationYear;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private Category category;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Builder
    public LibraryEntity(String title, String description, String author, String isbn, String publicationYear, Category category) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.category = category;
        this.deletedAt = null;
    }


    public void updateLibrary(Library library) {
        Objects.requireNonNull(library.getTitle(), "title cannot be null");
        Objects.requireNonNull(library.getDescription(), "description cannot be null");
        Objects.requireNonNull(library.getAuthor(), "author cannot be null");
        Objects.requireNonNull(library.getIsbn(), "isbn cannot be null");
        Objects.requireNonNull(library.getPublicationYear(), "publicationYear cannot be null");
        Objects.requireNonNull(library.getCategory(), "category cannot be null");

        this.title = library.getTitle();
        this.description = library.getDescription();
        this.author = library.getAuthor();
        this.isbn = library.getIsbn();
        this.publicationYear = library.getPublicationYear();
        this.category = library.getCategory();
    }

    public void softDelete() {
        this.deletedAt = LocalDateTime.now();
    }

}

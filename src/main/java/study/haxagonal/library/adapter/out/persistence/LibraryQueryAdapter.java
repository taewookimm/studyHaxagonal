package study.haxagonal.library.adapter.out.persistence;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import study.haxagonal.library.adapter.out.mapper.LibraryEntityMapper;
import study.haxagonal.library.adapter.out.persistence.entity.LibraryEntity;
import study.haxagonal.library.application.domain.Library;
import study.haxagonal.library.application.port.LibraryQueryPort;

import java.util.Optional;

import static study.haxagonal.library.adapter.out.persistence.entity.QLibraryEntity.libraryEntity;

@Repository
public class LibraryQueryAdapter extends QuerydslRepositorySupport implements LibraryQueryPort {

    private final LibraryEntityMapper libraryEntityMapper;

    public LibraryQueryAdapter(LibraryEntityMapper libraryEntityMapper) {
        super(LibraryEntity.class);
        this.libraryEntityMapper = libraryEntityMapper;
    }

    @Override
    public Page<Library> findAllLibrary(Pageable pageable) {
        var result = getQuerydsl().createQuery()
                .select(libraryEntity)
                .from(libraryEntity)
                .where(
                        libraryEntity.deletedAt.isNull()
                ).fetch();

        var totalCount = getQuerydsl().createQuery()
                .select(libraryEntity.count())
                .from(libraryEntity)
                .where(
                        libraryEntity.deletedAt.isNull()
                );

        return PageableExecutionUtils.getPage(
                result.stream().map(libraryEntityMapper::toDomain).toList(),
                pageable,
                totalCount::fetchOne
        );
    }

    @Override
    public Optional<Library> findLibraryById(Long id) {
        return libraryEntityMapper.toOptionalDomain(
                getQuerydsl().createQuery()
                        .select(libraryEntity)
                        .from(libraryEntity)
                        .where(
                                libraryEntity.id.eq(id),
                                libraryEntity.deletedAt.isNull()
                        ).fetchOne()
        );
    }
}

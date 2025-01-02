package study.haxagonal.library.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import study.haxagonal.library.adapter.out.persistence.entity.LibraryEntity;

public interface LibraryJpaRepository extends JpaRepository<LibraryEntity, Long> {
}

package study.haxagonal.common;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    // 엔티티 생성 시간
    @CreatedDate
    @Column(name = "created_at")
    private Instant createdAt;

    // 엔티티 수정 시간
    @LastModifiedDate
    @Column(name ="updated_at")
    private Instant updatedAt;

    public void settingCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void settingUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}

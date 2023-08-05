package com.etiya.crmlite.entities.abstracts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {
    @Column(name = "CDATE")
    private LocalDateTime cDate;
    @Column(name = "CUSER")
    private Long cUser;
    @Column(name = "UDATE")
    private LocalDateTime uDate;
    @Column(name = "UUSER")
    private Long uUser;

    @PrePersist
    public void onCreate() {
        this.cUser = 5L;
        this.cDate = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.uUser = 5L;
        this.uDate = LocalDateTime.now();
    }
}

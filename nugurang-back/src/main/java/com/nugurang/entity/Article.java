package com.nugurang.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Article extends DateAudit implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @NotNull
    private String content;

    @NotNull
    private Long vcount;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
        this.vcount = Long.valueOf(0);
    }
}

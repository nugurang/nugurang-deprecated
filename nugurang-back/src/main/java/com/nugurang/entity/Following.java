package com.nugurang.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"from_user", "to_user"})
})
public class Following implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_user", nullable = false)
    private User fromUser;

    @ManyToOne
    @JoinColumn(name = "to_user", nullable = false)
    private User toUser;

    public Following(User fromUser, User toUser) {
        this.fromUser = fromUser;
        this.toUser = toUser;
    }
}

package com.nugurang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(
    name = "acl_entry",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"acl_object_identity", "ace_order"})
    }
)
public class AclEntryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "acl_object_identity", nullable = false)
    private AclObjectIdentityEntity aclObjectIdentity;

    @Column(name = "ace_order", nullable = false)
    private Integer aceOrder;

    @ManyToOne
    @JoinColumn(name = "sid", nullable = false)
    private AclSidEntity sid;

    @Column(nullable = false)
    private Integer mask;

    @Column(nullable = false)
    private Boolean granting;

    @Column(nullable = false)
    private Boolean auditSuccess;

    @Column(nullable = false)
    private Boolean auditFailure;
}

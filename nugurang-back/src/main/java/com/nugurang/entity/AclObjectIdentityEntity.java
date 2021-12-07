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
    name = "acl_object_identity",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"object_id_class", "object_id_identity"})
    }
)
public class AclObjectIdentityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "object_id_class", nullable = false)
    private AclClassEntity objectIdClass;

    @Column(name = "object_id_identity", nullable = false)
    private Long objectIdIdentity;

    @ManyToOne
    @JoinColumn(name = "parent_object")
    private AclObjectIdentityEntity parentObject;

    @ManyToOne
    @JoinColumn(name = "owner_sid")
    private AclSidEntity ownerSid;

    @Column(nullable = false)
    private Boolean entriesInheriting;
}

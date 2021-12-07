package com.nugurang.service;

import java.util.List;
import java.util.Map;
import org.springframework.security.acls.model.Acl;
import org.springframework.security.acls.model.AclService;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.Sid;

public class JpaAclService implements AclService {
    @Override
    public List<ObjectIdentity> findChildren(ObjectIdentity parentIdentity) {
        return null;
    }

    @Override
    public Acl readAclById(ObjectIdentity object) throws NotFoundException {
        return null;
    }

    @Override
    public Acl readAclById(ObjectIdentity object, List<Sid> sids) throws NotFoundException {
        return null;
    }

    @Override
    public Map<ObjectIdentity, Acl> readAclsById(List<ObjectIdentity> objects) throws NotFoundException {
        return null;
    }

    @Override
    public Map<ObjectIdentity, Acl> readAclsById(List<ObjectIdentity> objects, List<Sid> sids) throws NotFoundException {
        return null;
    }
}
package com.zs.zuoye.service;

import org.springframework.security.access.ConfigAttribute;

import java.util.Collection;
import java.util.Map;

public interface PermissionService {
    public Map<String, Collection<ConfigAttribute>> getPermissionMap();
}

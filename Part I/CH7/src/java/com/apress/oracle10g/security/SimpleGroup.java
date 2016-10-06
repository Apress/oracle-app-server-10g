/*
 * Created on Apr 23, 2004
 */
package com.apress.oracle10g.security;

import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

import com.evermind.security.Group;


/**
 * @author robh
 *
 */
public class SimpleGroup implements Group {

    private Set permissions;
    private String name;
    private String description;
    
    public SimpleGroup(String name) {
        this.name = name;
        this.permissions = new HashSet();
    }
    
    public boolean hasPermission(Permission permission) {
        return permissions.contains(permission);
    }

 
    public Set getPermissions() throws UnsupportedOperationException {
        return permissions;
    }

    public void addPermission(Permission permission)
            throws UnsupportedOperationException {
        permissions.add(permission);
    }

    
    public void removePermission(Permission permission)
            throws UnsupportedOperationException {
        permissions.remove(permission);
    }


    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

}

/*
 * Created on Apr 23, 2004
 */
package com.apress.oracle10g.security;

import java.math.BigInteger;
import java.security.Permission;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import com.evermind.security.Group;
import com.evermind.security.User;

/**
 * @author robh
 *  
 */
public class SimpleUser implements User {

    public static final User ANONYMOUS = new SimpleUser("<anon>", null);
    public static final User ADMIN = new SimpleUser("admin", "pwd");
    
    private Set groups;

    private Set permissions;

    private String name;

    private String password;

    private String description;

    private Locale locale;

    public SimpleUser(String name, String password) {
        this.name = name;
        this.password = password;

        this.groups = new HashSet();
        this.permissions = new HashSet();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean authenticate(String password) {
        return (password.equals(this.password));
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) throws UnsupportedOperationException {
        this.locale = locale;
    }

    public boolean hasPermission(Permission permission) {
        return permissions.contains(permission);
    }

    public boolean isMemberOf(Group group) {
        return groups.contains(group);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public BigInteger getCertificateSerial() {
        return null;
    }

    public String getCertificateIssuerDN() {
        return null;
    }

    public void setCertificate(String issuerDN, BigInteger serial)
            throws UnsupportedOperationException {
        throw new UnsupportedOperationException(
                "Certificate Authentication Not Supported");
    }

    public void setCertificate(X509Certificate cert) {

    }

    public void addToGroup(Group group) throws UnsupportedOperationException {
        groups.add(group);
    }

    public void removeFromGroup(Group group)
            throws UnsupportedOperationException {
        groups.remove(group);
    }

    public Set getGroups() throws UnsupportedOperationException {
        return groups;
    }

}
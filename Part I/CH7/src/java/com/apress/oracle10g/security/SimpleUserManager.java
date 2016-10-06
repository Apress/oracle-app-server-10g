/*
 * Created on Apr 23, 2004
 */
package com.apress.oracle10g.security;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.evermind.security.Group;
import com.evermind.security.User;
import com.evermind.security.UserAlreadyExistsException;
import com.evermind.security.UserManager;


/**
 * @author robh
 *
 */
public class SimpleUserManager implements UserManager {

    private UserManager parent;
    private Map users;
    private Map groups;
    private Set defaultGroups;
    
    public SimpleUserManager() throws InstantiationException, UserAlreadyExistsException{
        users = new HashMap();
        defaultGroups = new HashSet();
        groups = new HashMap();
        
        // defaults
        Group usersGroup = createGroup("users");
        User user = createUser("user", "pwd");
        
        user.addToGroup(usersGroup);
        
    }
    
    public void init(Properties props) throws InstantiationException {
        // do nothing
    }

    public void setParent(UserManager parent) {
        this.parent = parent;
    }

    public UserManager getParent() {
        return this.parent;
    }

    public User getUser(String name) {
        return (User)users.get(name);
    }

    public User getAnonymousUser() {
        return SimpleUser.ANONYMOUS;
    }

   
    public Group getGroup(String name) {
        return (Group)groups.get(name);
    }

    public User createUser(String name, String password)
            throws InstantiationException, UserAlreadyExistsException {
        
        if(users.containsKey(name)) {
            throw new UserAlreadyExistsException(name);
        }
        
        SimpleUser user = new SimpleUser(name, password);
        users.put(name, user);
        
        return user;
    }


    public Group createGroup(String name) throws InstantiationException {
        SimpleGroup group = new SimpleGroup(name);
        groups.put(name, group);
        
        return group;
    }

    public User getUser(String issuerDN, BigInteger serial) {
        return null;
    }

   
    public User getUser(X509Certificate cert) {
        return null;
    }

    
    public User getAdminUser() {
        return SimpleUser.ADMIN;
    }

    public boolean remove(User user) {
        if(users.remove(user.getName()) == null)
            return false;
        else
            return true;
    }
    
    public boolean remove(Group group) {
        if(groups.remove(group.getName()) == null)
            return false;
        else
            return true;
    }

    public void addDefaultGroup(String name) {
        defaultGroups.add(new SimpleGroup(name));
    }

    public Set getDefaultGroups() {
        return defaultGroups;
    }

    public int getUserCount() {
        return users.size();
    }

    public int getGroupCount() {
        return groups.size();
    }
  
    public List getUsers(int start, int end) {
        return Arrays.asList(users.values().toArray());
    }


    public List getGroups(int start, int end) {
        return null;
    }

    public boolean isUpdated() {
        return true;
    }

    public void update() throws InstantiationException {
       
    }

    public void invalidate() {

    }

    public void create(URL url) throws IOException {

    }

    public void store() throws IOException {
        
    }

}

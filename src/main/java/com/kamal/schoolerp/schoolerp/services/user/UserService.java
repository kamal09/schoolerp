package com.kamal.schoolerp.schoolerp.services.user;

import com.kamal.schoolerp.schoolerp.entities.User;

public interface UserService {

    public User findUserByEmail(String email);
    public void saveUser(User user);
}

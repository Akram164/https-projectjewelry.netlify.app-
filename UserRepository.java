package com.myorganisation.nexify.repository;


import com.myorganisation.nexify.Model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private Long UserId;
    public UserRepository(){

    }
    public Map<Long, User> userMap = new HashMap<>();
    public Long generateUserId(){
        return ++UserId;
    }



}

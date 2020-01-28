package com.kaagapov.checkToken;

import com.kaagapov.checkToken.repo.AuthLogRepository;
import com.kaagapov.checkToken.repo.UserRepository;
import com.kaagapov.checkToken.entity.AuthLog;
import com.kaagapov.checkToken.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class Authentication {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthLogRepository authLogRepository;

    public void logAuth(String login, Boolean resultAuth){
        authLogRepository.save(new AuthLog(login, new Date(), resultAuth));
    }

    public Boolean checkAuth(User user) {

        Boolean result = true;

        List<User> users = userRepository.findByLogin(user.getLogin());
        if( users.isEmpty() || !users.get(0).getPassword().equals(user.getPassword()) )
            result = false;

        logAuth(user.getLogin(), result);

        return result;
    }
}

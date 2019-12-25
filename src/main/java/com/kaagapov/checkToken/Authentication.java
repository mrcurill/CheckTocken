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

    public Boolean checkAuth(String login) {

        Boolean result = true;

        List<User> users = userRepository.findByLogin(login);
        if( users.isEmpty())
            result = false;

        logAuth(login, result);

        return result;
    }
}

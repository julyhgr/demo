package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MySqlTestServiceImpl implements MySqlTestService{
    private static Logger logger = LoggerFactory.getLogger(MySqlTestServiceImpl.class);
    @Autowired
    UserRepository userRepository;


    public void initData() {
//        userRepository.deleteAll();
        logger.info("-----delete all------");
    }

    public void findPage() {
        List<User> all = userRepository.findAll();
        System.out.println(all);
    }
}

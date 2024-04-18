package com.fitness.demo.eating.entry;

import com.fitness.demo.eating.entry.EatingEntry;
import com.fitness.demo.user.User;
import com.fitness.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Service
public class EatingEntryService {

    @Autowired
    UserRepository userRepository;

    //todo how to update mongodb document
    public EatingEntry addEatingEntry(EatingEntry eatingEntry, String userName) {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            return null;
        }
        user.addEatingEntry(eatingEntry);
        userRepository.save(user);
        return eatingEntry;
    }
}

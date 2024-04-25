package com.fitness.demo.eating.entry;

import com.fitness.demo.user.User;
import com.fitness.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EatingEntryService {

    @Autowired
    UserRepository userRepository;

    //todo probably better to use @Query @modify to use self defined update query to update
    public EatingEntry addEatingEntry(EatingEntry eatingEntry, String userName) {
        User user = userRepository.findByUsername(userName);
        if (user == null) {
            return null;
        }
        user.addEatingEntry(eatingEntry);
        userRepository.save(user);
        return eatingEntry;
    }
}

package com.fitness.demo.user;

import com.fitness.demo.eating.entry.EatingEntry;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
@NoArgsConstructor
public class User {

    @Id
    String userName;
    String password;
    String bio;
    List<EatingEntry> eatingEntries = new ArrayList<>();

    public User(String userName, String password, String bio) {
        this.userName = userName;
        this.password = password;
        this.bio = bio;
    }

    @Override
    public String toString() {
        return userName;
    }

    public void addEatingEntry(EatingEntry eatingEntry) {
        this.eatingEntries.add(eatingEntry);
    }
}

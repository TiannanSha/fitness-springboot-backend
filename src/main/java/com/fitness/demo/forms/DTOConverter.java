package com.fitness.demo.forms;

public interface DTOConverter<S,T> {
    T convertDTO(S form);
}

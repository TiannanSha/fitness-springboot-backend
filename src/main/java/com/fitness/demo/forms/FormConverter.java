package com.fitness.demo.forms;

public interface FormConverter<S,T> {
    T convertForm(S form);
}

package com.work.year22;

import java.util.Optional;

public class Principal extends Teacher {
    public Optional<String> getStrOpt() {
        return strOpt;
    }

    public void setStrOpt(Optional<String> strOpt) {
        this.strOpt = strOpt;
    }

    public Optional<String> strOpt;

    protected void show(){
        System.out.println("student" );
    }
}

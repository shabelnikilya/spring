package ru.app.scream;

import ru.app.annotation.InjectUpdateBrainText;
import ru.app.annotation.Profiling;

@Profiling
public class ZombieScream implements Scream {
    @InjectUpdateBrainText("Мне нужен твой мозг!")
    private String brain;

    private String scream;

    public ZombieScream() {
        System.out.println("Создание объекта!");
        System.out.println(brain);
    }

    public void init() {
        System.out.println("Вызов инит метода!");
        System.out.println(brain);
    }

    public void setScream(String scream) {
        this.scream = scream;
    }

    @Override
    public void scaryScream() {
        System.out.println(scream + " " + brain);
    }
}

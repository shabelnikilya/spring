package ru.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.app.scream.ZombieScream;

public class XmlConfigurationStartApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.getBean(ZombieScream.class).scaryScream();
    }
}

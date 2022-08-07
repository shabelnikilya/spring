package ru.app.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;
import ru.app.annotation.InjectUpdateBrainText;

import java.lang.reflect.Field;

public class InjectBrainAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectUpdateBrainText annotation = field.getAnnotation(InjectUpdateBrainText.class);
            if (annotation != null) {
                String text = annotation.value();
                String updateText = text + " А нет, у тебя оружие...";
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, updateText);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

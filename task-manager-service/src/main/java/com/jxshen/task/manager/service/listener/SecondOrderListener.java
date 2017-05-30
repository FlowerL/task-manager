package com.jxshen.task.manager.service.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

import com.jxshen.task.manager.service.event.UserContentEvent;

@Component
public class SecondOrderListener implements SmartApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof UserContentEvent) {
            System.out.println(String.format("[%s] receive : [%s]", 
                    this.getClass().getSimpleName(), event.getSource()));
        }
    }

    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == UserContentEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType == String.class;
    }

}

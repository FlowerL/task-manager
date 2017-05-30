package com.jxshen.task.manager.service.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.jxshen.task.manager.service.event.UserContentEvent;

/**
 * Unorderder listener
 */
@Component
public class ListListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof UserContentEvent) {
            System.out.println(String.format("[%s] receive : [%s]", 
                    this.getClass().getSimpleName(), event.getSource()));
        }
    }

}

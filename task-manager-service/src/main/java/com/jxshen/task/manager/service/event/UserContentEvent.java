package com.jxshen.task.manager.service.event;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
public class UserContentEvent extends ApplicationEvent {

    public UserContentEvent(final String userContent) {
        super(userContent);
    }

}

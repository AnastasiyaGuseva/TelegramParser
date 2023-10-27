package com.example.telegramparser.handlers;

import it.tdlight.jni.TdApi;

public interface UpdateNotificationListener<T extends TdApi.Update> {

    void handleNotification(T notification);

    Class<T> notificationType();

}

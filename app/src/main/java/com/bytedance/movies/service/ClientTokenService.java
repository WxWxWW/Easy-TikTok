package com.bytedance.movies.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ClientTokenService extends Service {
    public ClientTokenService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
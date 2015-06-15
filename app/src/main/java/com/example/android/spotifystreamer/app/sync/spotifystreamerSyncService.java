package com.example.android.spotifystreamer.app.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class spotifystreamerSyncService extends Service {
    private static final Object sSyncAdapterLock = new Object();
    private static spotifystreamerSyncAdapter sspotifystreamerSyncAdapter = null;

    @Override
    public void onCreate() {
        Log.d("spotifystreamerSyncService", "onCreate - spotifystreamerSyncService");
        synchronized (sSyncAdapterLock) {
            if (sspotifystreamerSyncAdapter == null) {
                sspotifystreamerSyncAdapter = new spotifystreamerSyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return sspotifystreamerSyncAdapter.getSyncAdapterBinder();
    }
}
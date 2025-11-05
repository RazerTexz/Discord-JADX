package com.discord.utilities.voice;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.discord.utilities.voice.VoiceEngineForegroundService;
import d0.z.d.m;

/* compiled from: VoiceEngineForegroundService.kt */
/* loaded from: classes2.dex */
public final class VoiceEngineForegroundService$Connection$connection$1 implements ServiceConnection {
    public final /* synthetic */ VoiceEngineForegroundService.Connection this$0;

    public VoiceEngineForegroundService$Connection$connection$1(VoiceEngineForegroundService.Connection connection) {
        this.this$0 = connection;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName className, IBinder binder) {
        m.checkNotNullParameter(className, "className");
        m.checkNotNullParameter(binder, "binder");
        VoiceEngineForegroundService.Connection.access$setService$p(this.this$0, ((VoiceEngineForegroundService.LocalBinder) binder).getService());
        this.this$0.setUnbinding(false);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName className) {
        m.checkNotNullParameter(className, "className");
        this.this$0.setUnbinding(false);
        VoiceEngineForegroundService.Connection.access$setService$p(this.this$0, null);
    }
}

package com.discord.utilities.voice;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.discord.utilities.voice.VoiceEngineForegroundService;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.voice.VoiceEngineForegroundService$Connection$connection$1, reason: use source file name */
/* JADX INFO: compiled from: VoiceEngineForegroundService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineForegroundService5 implements ServiceConnection {
    public final /* synthetic */ VoiceEngineForegroundService.Connection this$0;

    public VoiceEngineForegroundService5(VoiceEngineForegroundService.Connection connection) {
        this.this$0 = connection;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName className, IBinder binder) {
        Intrinsics3.checkNotNullParameter(className, "className");
        Intrinsics3.checkNotNullParameter(binder, "binder");
        VoiceEngineForegroundService.Connection.access$setService$p(this.this$0, ((VoiceEngineForegroundService.LocalBinder) binder).getService());
        this.this$0.setUnbinding(false);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName className) {
        Intrinsics3.checkNotNullParameter(className, "className");
        this.this$0.setUnbinding(false);
        VoiceEngineForegroundService.Connection.access$setService$p(this.this$0, null);
    }
}

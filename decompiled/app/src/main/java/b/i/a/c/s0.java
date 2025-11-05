package b.i.a.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* compiled from: AudioBecomingNoisyManager.java */
/* loaded from: classes3.dex */
public final class s0 {
    public final Context a;

    /* renamed from: b, reason: collision with root package name */
    public final a f1061b;
    public boolean c;

    /* compiled from: AudioBecomingNoisyManager.java */
    public final class a extends BroadcastReceiver implements Runnable {
        public final b j;
        public final Handler k;

        public a(Handler handler, b bVar) {
            this.k = handler;
            this.j = bVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.k.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (s0.this.c) {
                k2.this.m0(false, -1, 3);
            }
        }
    }

    /* compiled from: AudioBecomingNoisyManager.java */
    public interface b {
    }

    public s0(Context context, Handler handler, b bVar) {
        this.a = context.getApplicationContext();
        this.f1061b = new a(handler, bVar);
    }

    public void a(boolean z2) {
        if (z2 && !this.c) {
            this.a.registerReceiver(this.f1061b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.c = true;
        } else {
            if (z2 || !this.c) {
                return;
            }
            this.a.unregisterReceiver(this.f1061b);
            this.c = false;
        }
    }
}

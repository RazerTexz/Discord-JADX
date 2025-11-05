package b.i.a.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import b.i.a.c.k2;
import b.i.a.c.y1;
import java.util.Iterator;
import org.webrtc.MediaStreamTrack;

/* compiled from: StreamVolumeManager.java */
/* loaded from: classes3.dex */
public final class m2 {
    public final Context a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f1033b;
    public final b c;
    public final AudioManager d;

    @Nullable
    public c e;
    public int f;
    public int g;
    public boolean h;

    /* compiled from: StreamVolumeManager.java */
    public interface b {
    }

    /* compiled from: StreamVolumeManager.java */
    public final class c extends BroadcastReceiver {
        public c(a aVar) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            m2 m2Var = m2.this;
            m2Var.f1033b.post(new p0(m2Var));
        }
    }

    public m2(Context context, Handler handler, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f1033b = handler;
        this.c = bVar;
        AudioManager audioManager = (AudioManager) applicationContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        b.c.a.a0.d.H(audioManager);
        this.d = audioManager;
        this.f = 3;
        this.g = b(audioManager, 3);
        this.h = a(audioManager, this.f);
        c cVar = new c(null);
        try {
            applicationContext.registerReceiver(cVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.e = cVar;
        } catch (RuntimeException e) {
            b.i.a.c.f3.q.c("StreamVolumeManager", "Error registering stream volume receiver", e);
        }
    }

    public static boolean a(AudioManager audioManager, int i) {
        return b.i.a.c.f3.e0.a >= 23 ? audioManager.isStreamMute(i) : b(audioManager, i) == 0;
    }

    public static int b(AudioManager audioManager, int i) {
        try {
            return audioManager.getStreamVolume(i);
        } catch (RuntimeException e) {
            StringBuilder sb = new StringBuilder(60);
            sb.append("Could not retrieve stream volume for stream type ");
            sb.append(i);
            b.i.a.c.f3.q.c("StreamVolumeManager", sb.toString(), e);
            return audioManager.getStreamMaxVolume(i);
        }
    }

    public void c(int i) {
        if (this.f == i) {
            return;
        }
        this.f = i;
        d();
        k2.b bVar = (k2.b) this.c;
        c1 c1VarF0 = k2.f0(k2.this.l);
        if (c1VarF0.equals(k2.this.H)) {
            return;
        }
        k2 k2Var = k2.this;
        k2Var.H = c1VarF0;
        Iterator<y1.e> it = k2Var.h.iterator();
        while (it.hasNext()) {
            it.next().z(c1VarF0);
        }
    }

    public final void d() {
        int iB = b(this.d, this.f);
        boolean zA = a(this.d, this.f);
        if (this.g == iB && this.h == zA) {
            return;
        }
        this.g = iB;
        this.h = zA;
        Iterator<y1.e> it = k2.this.h.iterator();
        while (it.hasNext()) {
            it.next().G(iB, zA);
        }
    }
}

package p007b.p225i.p226a.p242c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Iterator;
import org.webrtc.MediaStreamTrack;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Player2;
import p007b.p225i.p226a.p242c.SimpleExoPlayer;
import p007b.p225i.p226a.p242c.p259f3.Log2;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: StreamVolumeManager.java */
/* renamed from: b.i.a.c.m2, reason: use source file name */
/* loaded from: classes3.dex */
public final class StreamVolumeManager {

    /* renamed from: a */
    public final Context f7246a;

    /* renamed from: b */
    public final Handler f7247b;

    /* renamed from: c */
    public final b f7248c;

    /* renamed from: d */
    public final AudioManager f7249d;

    /* renamed from: e */
    @Nullable
    public c f7250e;

    /* renamed from: f */
    public int f7251f;

    /* renamed from: g */
    public int f7252g;

    /* renamed from: h */
    public boolean f7253h;

    /* compiled from: StreamVolumeManager.java */
    /* renamed from: b.i.a.c.m2$b */
    public interface b {
    }

    /* compiled from: StreamVolumeManager.java */
    /* renamed from: b.i.a.c.m2$c */
    public final class c extends BroadcastReceiver {
        public c(a aVar) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StreamVolumeManager streamVolumeManager = StreamVolumeManager.this;
            streamVolumeManager.f7247b.post(new RunnableC2834p0(streamVolumeManager));
        }
    }

    public StreamVolumeManager(Context context, Handler handler, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.f7246a = applicationContext;
        this.f7247b = handler;
        this.f7248c = bVar;
        AudioManager audioManager = (AudioManager) applicationContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        AnimatableValueParser.m438H(audioManager);
        this.f7249d = audioManager;
        this.f7251f = 3;
        this.f7252g = m3306b(audioManager, 3);
        this.f7253h = m3305a(audioManager, this.f7251f);
        c cVar = new c(null);
        try {
            applicationContext.registerReceiver(cVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.f7250e = cVar;
        } catch (RuntimeException e) {
            Log2.m3040c("StreamVolumeManager", "Error registering stream volume receiver", e);
        }
    }

    /* renamed from: a */
    public static boolean m3305a(AudioManager audioManager, int i) {
        return Util2.f6708a >= 23 ? audioManager.isStreamMute(i) : m3306b(audioManager, i) == 0;
    }

    /* renamed from: b */
    public static int m3306b(AudioManager audioManager, int i) {
        try {
            return audioManager.getStreamVolume(i);
        } catch (RuntimeException e) {
            StringBuilder sb = new StringBuilder(60);
            sb.append("Could not retrieve stream volume for stream type ");
            sb.append(i);
            Log2.m3040c("StreamVolumeManager", sb.toString(), e);
            return audioManager.getStreamMaxVolume(i);
        }
    }

    /* renamed from: c */
    public void m3307c(int i) {
        if (this.f7251f == i) {
            return;
        }
        this.f7251f = i;
        m3308d();
        SimpleExoPlayer.b bVar = (SimpleExoPlayer.b) this.f7248c;
        DeviceInfo2 deviceInfo2M3281f0 = SimpleExoPlayer.m3281f0(SimpleExoPlayer.this.f7216l);
        if (deviceInfo2M3281f0.equals(SimpleExoPlayer.this.f7204H)) {
            return;
        }
        SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
        simpleExoPlayer.f7204H = deviceInfo2M3281f0;
        Iterator<Player2.e> it = simpleExoPlayer.f7212h.iterator();
        while (it.hasNext()) {
            it.next().mo265z(deviceInfo2M3281f0);
        }
    }

    /* renamed from: d */
    public final void m3308d() {
        int iM3306b = m3306b(this.f7249d, this.f7251f);
        boolean zM3305a = m3305a(this.f7249d, this.f7251f);
        if (this.f7252g == iM3306b && this.f7253h == zM3305a) {
            return;
        }
        this.f7252g = iM3306b;
        this.f7253h = zM3305a;
        Iterator<Player2.e> it = SimpleExoPlayer.this.f7212h.iterator();
        while (it.hasNext()) {
            it.next().mo238G(iM3306b, zM3305a);
        }
    }
}

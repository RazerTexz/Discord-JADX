package p007b.p225i.p226a.p242c.p263t2;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: AudioTimestampPoller.java */
/* renamed from: b.i.a.c.t2.s, reason: use source file name */
/* loaded from: classes3.dex */
public final class AudioTimestampPoller {

    /* renamed from: a */
    @Nullable
    public final a f7792a;

    /* renamed from: b */
    public int f7793b;

    /* renamed from: c */
    public long f7794c;

    /* renamed from: d */
    public long f7795d;

    /* renamed from: e */
    public long f7796e;

    /* renamed from: f */
    public long f7797f;

    /* compiled from: AudioTimestampPoller.java */
    @RequiresApi(19)
    /* renamed from: b.i.a.c.t2.s$a */
    public static final class a {

        /* renamed from: a */
        public final AudioTrack f7798a;

        /* renamed from: b */
        public final AudioTimestamp f7799b = new AudioTimestamp();

        /* renamed from: c */
        public long f7800c;

        /* renamed from: d */
        public long f7801d;

        /* renamed from: e */
        public long f7802e;

        public a(AudioTrack audioTrack) {
            this.f7798a = audioTrack;
        }
    }

    public AudioTimestampPoller(AudioTrack audioTrack) {
        if (Util2.f6708a >= 19) {
            this.f7792a = new a(audioTrack);
            m3499a();
        } else {
            this.f7792a = null;
            m3500b(3);
        }
    }

    /* renamed from: a */
    public void m3499a() {
        if (this.f7792a != null) {
            m3500b(0);
        }
    }

    /* renamed from: b */
    public final void m3500b(int i) {
        this.f7793b = i;
        if (i == 0) {
            this.f7796e = 0L;
            this.f7797f = -1L;
            this.f7794c = System.nanoTime() / 1000;
            this.f7795d = 10000L;
            return;
        }
        if (i == 1) {
            this.f7795d = 10000L;
            return;
        }
        if (i == 2 || i == 3) {
            this.f7795d = 10000000L;
        } else {
            if (i != 4) {
                throw new IllegalStateException();
            }
            this.f7795d = 500000L;
        }
    }
}

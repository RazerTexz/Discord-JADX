package p007b.p225i.p226a.p242c.p263t2;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: AudioTrackPositionTracker.java */
/* renamed from: b.i.a.c.t2.t, reason: use source file name */
/* loaded from: classes3.dex */
public final class AudioTrackPositionTracker {

    /* renamed from: A */
    public long f7803A;

    /* renamed from: B */
    public long f7804B;

    /* renamed from: C */
    public long f7805C;

    /* renamed from: D */
    public boolean f7806D;

    /* renamed from: E */
    public long f7807E;

    /* renamed from: F */
    public long f7808F;

    /* renamed from: a */
    public final a f7809a;

    /* renamed from: b */
    public final long[] f7810b;

    /* renamed from: c */
    @Nullable
    public AudioTrack f7811c;

    /* renamed from: d */
    public int f7812d;

    /* renamed from: e */
    public int f7813e;

    /* renamed from: f */
    @Nullable
    public AudioTimestampPoller f7814f;

    /* renamed from: g */
    public int f7815g;

    /* renamed from: h */
    public boolean f7816h;

    /* renamed from: i */
    public long f7817i;

    /* renamed from: j */
    public float f7818j;

    /* renamed from: k */
    public boolean f7819k;

    /* renamed from: l */
    public long f7820l;

    /* renamed from: m */
    public long f7821m;

    /* renamed from: n */
    @Nullable
    public Method f7822n;

    /* renamed from: o */
    public long f7823o;

    /* renamed from: p */
    public boolean f7824p;

    /* renamed from: q */
    public boolean f7825q;

    /* renamed from: r */
    public long f7826r;

    /* renamed from: s */
    public long f7827s;

    /* renamed from: t */
    public long f7828t;

    /* renamed from: u */
    public long f7829u;

    /* renamed from: v */
    public int f7830v;

    /* renamed from: w */
    public int f7831w;

    /* renamed from: x */
    public long f7832x;

    /* renamed from: y */
    public long f7833y;

    /* renamed from: z */
    public long f7834z;

    /* compiled from: AudioTrackPositionTracker.java */
    /* renamed from: b.i.a.c.t2.t$a */
    public interface a {
        /* renamed from: a */
        void mo3506a(long j);

        /* renamed from: b */
        void mo3507b(int i, long j);

        /* renamed from: c */
        void mo3508c(long j);

        /* renamed from: d */
        void mo3509d(long j, long j2, long j3, long j4);

        /* renamed from: e */
        void mo3510e(long j, long j2, long j3, long j4);
    }

    public AudioTrackPositionTracker(a aVar) {
        this.f7809a = aVar;
        if (Util2.f6708a >= 18) {
            try {
                this.f7822n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f7810b = new long[10];
    }

    /* renamed from: a */
    public final long m3501a(long j) {
        return (j * 1000000) / this.f7815g;
    }

    /* renamed from: b */
    public final long m3502b() {
        AudioTrack audioTrack = this.f7811c;
        Objects.requireNonNull(audioTrack);
        if (this.f7832x != -9223372036854775807L) {
            return Math.min(this.f7803A, this.f7834z + ((((SystemClock.elapsedRealtime() * 1000) - this.f7832x) * this.f7815g) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & audioTrack.getPlaybackHeadPosition();
        if (this.f7816h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f7829u = this.f7827s;
            }
            playbackHeadPosition += this.f7829u;
        }
        if (Util2.f6708a <= 29) {
            if (playbackHeadPosition == 0 && this.f7827s > 0 && playState == 3) {
                if (this.f7833y == -9223372036854775807L) {
                    this.f7833y = SystemClock.elapsedRealtime();
                }
                return this.f7827s;
            }
            this.f7833y = -9223372036854775807L;
        }
        if (this.f7827s > playbackHeadPosition) {
            this.f7828t++;
        }
        this.f7827s = playbackHeadPosition;
        return playbackHeadPosition + (this.f7828t << 32);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m3503c(long j) {
        if (j <= m3502b()) {
            if (this.f7816h) {
                AudioTrack audioTrack = this.f7811c;
                Objects.requireNonNull(audioTrack);
                boolean z2 = audioTrack.getPlayState() == 2 && m3502b() == 0;
                if (!z2) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: d */
    public void m3504d() {
        this.f7820l = 0L;
        this.f7831w = 0;
        this.f7830v = 0;
        this.f7821m = 0L;
        this.f7805C = 0L;
        this.f7808F = 0L;
        this.f7819k = false;
        this.f7811c = null;
        this.f7814f = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m3505e(AudioTrack audioTrack, boolean z2, int i, int i2, int i3) {
        this.f7811c = audioTrack;
        this.f7812d = i2;
        this.f7813e = i3;
        this.f7814f = new AudioTimestampPoller(audioTrack);
        this.f7815g = audioTrack.getSampleRate();
        boolean z3 = true;
        if (z2) {
            if (!(Util2.f6708a < 23 && (i == 5 || i == 6))) {
            }
        } else {
            z3 = false;
        }
        this.f7816h = z3;
        boolean zM3018z = Util2.m3018z(i);
        this.f7825q = zM3018z;
        this.f7817i = zM3018z ? m3501a(i3 / i2) : -9223372036854775807L;
        this.f7827s = 0L;
        this.f7828t = 0L;
        this.f7829u = 0L;
        this.f7824p = false;
        this.f7832x = -9223372036854775807L;
        this.f7833y = -9223372036854775807L;
        this.f7826r = 0L;
        this.f7823o = 0L;
        this.f7818j = 1.0f;
    }
}

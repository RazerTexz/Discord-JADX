package p007b.p225i.p226a.p242c;

import android.content.Context;
import android.os.Looper;
import p007b.p225i.p226a.p242c.p243a3.MediaSourceFactory;
import p007b.p225i.p226a.p242c.p255c3.TrackSelector;
import p007b.p225i.p226a.p242c.p257e3.BandwidthMeter;
import p007b.p225i.p226a.p242c.p259f3.Clock4;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsCollector;
import p007b.p225i.p226a.p242c.p263t2.AudioAttributes;
import p007b.p225i.p355b.p356a.Supplier2;

/* JADX INFO: renamed from: b.i.a.c.e1, reason: use source file name */
/* JADX INFO: compiled from: ExoPlayer.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ExoPlayer2 extends Player2 {

    /* JADX INFO: renamed from: b.i.a.c.e1$a */
    /* JADX INFO: compiled from: ExoPlayer.java */
    public interface a {
        /* JADX INFO: renamed from: o */
        void mo2770o(boolean z2);

        /* JADX INFO: renamed from: x */
        void mo2771x(boolean z2);
    }

    /* JADX INFO: renamed from: b.i.a.c.e1$b */
    /* JADX INFO: compiled from: ExoPlayer.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final Context f6412a;

        /* JADX INFO: renamed from: b */
        public Clock4 f6413b;

        /* JADX INFO: renamed from: c */
        public Supplier2<RenderersFactory> f6414c;

        /* JADX INFO: renamed from: d */
        public Supplier2<MediaSourceFactory> f6415d;

        /* JADX INFO: renamed from: e */
        public Supplier2<TrackSelector> f6416e;

        /* JADX INFO: renamed from: f */
        public Supplier2<LoadControl> f6417f;

        /* JADX INFO: renamed from: g */
        public Supplier2<BandwidthMeter> f6418g;

        /* JADX INFO: renamed from: h */
        public Supplier2<AnalyticsCollector> f6419h;

        /* JADX INFO: renamed from: i */
        public Looper f6420i;

        /* JADX INFO: renamed from: j */
        public AudioAttributes f6421j;

        /* JADX INFO: renamed from: k */
        public int f6422k;

        /* JADX INFO: renamed from: l */
        public boolean f6423l;

        /* JADX INFO: renamed from: m */
        public SeekParameters f6424m;

        /* JADX INFO: renamed from: n */
        public long f6425n;

        /* JADX INFO: renamed from: o */
        public long f6426o;

        /* JADX INFO: renamed from: p */
        public LivePlaybackSpeedControl f6427p;

        /* JADX INFO: renamed from: q */
        public long f6428q;

        /* JADX INFO: renamed from: r */
        public long f6429r;

        /* JADX INFO: renamed from: s */
        public boolean f6430s;

        public b(Context context) {
            C2725f c2725f = new C2725f(context);
            C2801h c2801h = new C2801h(context);
            C2760g c2760g = new C2760g(context);
            C2525a c2525a = C2525a.f5463j;
            C2675e c2675e = new C2675e(context);
            this.f6412a = context;
            this.f6414c = c2725f;
            this.f6415d = c2801h;
            this.f6416e = c2760g;
            this.f6417f = c2525a;
            this.f6418g = c2675e;
            this.f6419h = new C2805i(this);
            this.f6420i = Util2.m3007o();
            this.f6421j = AudioAttributes.f7779j;
            this.f6422k = 1;
            this.f6423l = true;
            this.f6424m = SeekParameters.f7190b;
            this.f6425n = 5000L;
            this.f6426o = 15000L;
            this.f6427p = new DefaultLivePlaybackSpeedControl(0.97f, 1.03f, 1000L, 1.0E-7f, Util2.m2981B(20L), Util2.m2981B(500L), 0.999f, null);
            this.f6413b = Clock4.f6720a;
            this.f6428q = 500L;
            this.f6429r = 2000L;
        }
    }
}

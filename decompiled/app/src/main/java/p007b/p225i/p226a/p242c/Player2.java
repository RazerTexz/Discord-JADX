package p007b.p225i.p226a.p242c;

import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p243a3.TrackGroupArray;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p255c3.TrackSelectionArray;
import p007b.p225i.p226a.p242c.p259f3.FlagSet;
import p007b.p225i.p226a.p242c.p260g3.VideoSize;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* compiled from: Player.java */
/* renamed from: b.i.a.c.y1, reason: use source file name */
/* loaded from: classes3.dex */
public interface Player2 {

    /* compiled from: Player.java */
    /* renamed from: b.i.a.c.y1$b */
    public static final class b implements Bundleable {

        /* renamed from: j */
        public static final b f9032j = new b(new FlagSet.b().m3033b(), null);

        /* renamed from: k */
        public final FlagSet f9033k;

        /* compiled from: Player.java */
        /* renamed from: b.i.a.c.y1$b$a */
        public static final class a {

            /* renamed from: a */
            public final FlagSet.b f9034a = new FlagSet.b();

            /* renamed from: a */
            public a m3826a(b bVar) {
                FlagSet.b bVar2 = this.f9034a;
                FlagSet flagSet = bVar.f9033k;
                Objects.requireNonNull(bVar2);
                for (int i = 0; i < flagSet.m3031c(); i++) {
                    bVar2.m3032a(flagSet.m3030b(i));
                }
                return this;
            }

            /* renamed from: b */
            public a m3827b(int i, boolean z2) {
                FlagSet.b bVar = this.f9034a;
                Objects.requireNonNull(bVar);
                if (z2) {
                    AnimatableValueParser.m426D(!bVar.f6735b);
                    bVar.f6734a.append(i, true);
                }
                return this;
            }

            /* renamed from: c */
            public b m3828c() {
                return new b(this.f9034a.m3033b(), null);
            }
        }

        public b(FlagSet flagSet, a aVar) {
            this.f9033k = flagSet;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f9033k.equals(((b) obj).f9033k);
            }
            return false;
        }

        public int hashCode() {
            return this.f9033k.hashCode();
        }
    }

    /* compiled from: Player.java */
    @Deprecated
    /* renamed from: b.i.a.c.y1$c */
    public interface c {
        /* renamed from: A */
        void mo235A(MediaMetadata mediaMetadata);

        /* renamed from: D */
        void mo236D(boolean z2);

        /* renamed from: E */
        void mo237E(Player2 player2, d dVar);

        @Deprecated
        /* renamed from: H */
        void mo239H(boolean z2, int i);

        /* renamed from: L */
        void mo240L(int i);

        /* renamed from: M */
        void mo241M(@Nullable MediaItem2 mediaItem2, int i);

        /* renamed from: W */
        void mo242W(boolean z2, int i);

        @Deprecated
        /* renamed from: Y */
        void mo243Y(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray);

        @Deprecated
        /* renamed from: a */
        void mo244a();

        /* renamed from: b0 */
        void mo247b0(PlaybackParameters playbackParameters);

        /* renamed from: f0 */
        void mo252f0(@Nullable PlaybackException playbackException);

        /* renamed from: g */
        void mo253g(f fVar, f fVar2, int i);

        /* renamed from: h */
        void mo254h(int i);

        @Deprecated
        /* renamed from: i */
        void mo255i(boolean z2);

        @Deprecated
        /* renamed from: j */
        void mo256j(int i);

        /* renamed from: j0 */
        void mo257j0(boolean z2);

        /* renamed from: p */
        void mo258p(TracksInfo tracksInfo);

        /* renamed from: r */
        void mo259r(boolean z2);

        /* renamed from: s */
        void mo260s(PlaybackException playbackException);

        /* renamed from: t */
        void mo261t(b bVar);

        /* renamed from: v */
        void mo262v(Timeline timeline, int i);

        /* renamed from: y */
        void mo264y(int i);
    }

    /* compiled from: Player.java */
    /* renamed from: b.i.a.c.y1$d */
    public static final class d {

        /* renamed from: a */
        public final FlagSet f9035a;

        public d(FlagSet flagSet) {
            this.f9035a = flagSet;
        }

        /* renamed from: a */
        public boolean m3829a(int... iArr) {
            FlagSet flagSet = this.f9035a;
            Objects.requireNonNull(flagSet);
            for (int i : iArr) {
                if (flagSet.m3029a(i)) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof d) {
                return this.f9035a.equals(((d) obj).f9035a);
            }
            return false;
        }

        public int hashCode() {
            return this.f9035a.hashCode();
        }
    }

    /* compiled from: Player.java */
    /* renamed from: b.i.a.c.y1$e */
    public interface e extends c {
        /* renamed from: G */
        void mo238G(int i, boolean z2);

        /* renamed from: a0 */
        void mo245a0(int i, int i2);

        /* renamed from: b */
        void mo246b(Metadata metadata);

        /* renamed from: c */
        void mo248c();

        /* renamed from: d */
        void mo249d(boolean z2);

        /* renamed from: e */
        void mo250e(List<Cue> list);

        /* renamed from: f */
        void mo251f(VideoSize videoSize);

        /* renamed from: w */
        void mo263w(float f);

        /* renamed from: z */
        void mo265z(DeviceInfo2 deviceInfo2);
    }

    /* compiled from: Player.java */
    /* renamed from: b.i.a.c.y1$f */
    public static final class f implements Bundleable {

        /* renamed from: j */
        @Nullable
        public final Object f9036j;

        /* renamed from: k */
        public final int f9037k;

        /* renamed from: l */
        @Nullable
        public final MediaItem2 f9038l;

        /* renamed from: m */
        @Nullable
        public final Object f9039m;

        /* renamed from: n */
        public final int f9040n;

        /* renamed from: o */
        public final long f9041o;

        /* renamed from: p */
        public final long f9042p;

        /* renamed from: q */
        public final int f9043q;

        /* renamed from: r */
        public final int f9044r;

        public f(@Nullable Object obj, int i, @Nullable MediaItem2 mediaItem2, @Nullable Object obj2, int i2, long j, long j2, int i3, int i4) {
            this.f9036j = obj;
            this.f9037k = i;
            this.f9038l = mediaItem2;
            this.f9039m = obj2;
            this.f9040n = i2;
            this.f9041o = j;
            this.f9042p = j2;
            this.f9043q = i3;
            this.f9044r = i4;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || f.class != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            return this.f9037k == fVar.f9037k && this.f9040n == fVar.f9040n && this.f9041o == fVar.f9041o && this.f9042p == fVar.f9042p && this.f9043q == fVar.f9043q && this.f9044r == fVar.f9044r && C3404f.m4252V(this.f9036j, fVar.f9036j) && C3404f.m4252V(this.f9039m, fVar.f9039m) && C3404f.m4252V(this.f9038l, fVar.f9038l);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f9036j, Integer.valueOf(this.f9037k), this.f9038l, this.f9039m, Integer.valueOf(this.f9040n), Long.valueOf(this.f9041o), Long.valueOf(this.f9042p), Integer.valueOf(this.f9043q), Integer.valueOf(this.f9044r)});
        }
    }

    /* renamed from: A */
    List<Cue> mo2879A();

    /* renamed from: B */
    int mo2880B();

    /* renamed from: C */
    int mo2881C();

    /* renamed from: D */
    boolean mo3518D(int i);

    /* renamed from: E */
    void mo2882E(int i);

    /* renamed from: F */
    void mo2883F(@Nullable SurfaceView surfaceView);

    /* renamed from: G */
    int mo2884G();

    /* renamed from: H */
    TracksInfo mo2885H();

    /* renamed from: I */
    int mo2886I();

    /* renamed from: J */
    long mo2887J();

    /* renamed from: K */
    Timeline mo2888K();

    /* renamed from: L */
    Looper mo2889L();

    /* renamed from: M */
    boolean mo2890M();

    /* renamed from: N */
    long mo2891N();

    /* renamed from: O */
    void mo3519O();

    /* renamed from: P */
    void mo3520P();

    /* renamed from: Q */
    void mo2892Q(@Nullable TextureView textureView);

    /* renamed from: R */
    void mo3521R();

    /* renamed from: S */
    MediaMetadata mo2893S();

    /* renamed from: T */
    long mo2894T();

    /* renamed from: U */
    long mo2895U();

    /* renamed from: a */
    void mo2896a();

    /* renamed from: c */
    PlaybackParameters mo2897c();

    /* renamed from: d */
    void mo3531d();

    /* renamed from: e */
    void mo3532e();

    /* renamed from: f */
    boolean mo2900f();

    /* renamed from: g */
    long mo2902g();

    /* renamed from: h */
    void mo2904h(int i, long j);

    /* renamed from: i */
    b mo2906i();

    /* renamed from: j */
    boolean mo2908j();

    /* renamed from: k */
    void mo2909k(boolean z2);

    /* renamed from: l */
    long mo2910l();

    /* renamed from: m */
    int mo2912m();

    /* renamed from: n */
    void mo2914n(@Nullable TextureView textureView);

    /* renamed from: o */
    VideoSize mo2916o();

    /* renamed from: p */
    void mo2918p(e eVar);

    /* renamed from: q */
    int mo2920q();

    /* renamed from: r */
    void mo2922r(@Nullable SurfaceView surfaceView);

    /* renamed from: s */
    void mo3533s();

    @Nullable
    /* renamed from: t */
    PlaybackException mo2925t();

    /* renamed from: u */
    void mo2926u(boolean z2);

    /* renamed from: v */
    long mo2927v();

    /* renamed from: w */
    long mo2928w();

    /* renamed from: x */
    void mo2929x(e eVar);

    /* renamed from: y */
    int mo2930y();

    /* renamed from: z */
    boolean mo3534z();
}

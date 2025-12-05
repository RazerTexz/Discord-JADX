package p007b.p225i.p226a.p242c.p262s2;

import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p225i.p226a.p242c.Timeline;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* compiled from: AnalyticsListener.java */
/* renamed from: b.i.a.c.s2.h1, reason: use source file name */
/* loaded from: classes3.dex */
public interface AnalyticsListener {

    /* compiled from: AnalyticsListener.java */
    /* renamed from: b.i.a.c.s2.h1$a */
    public static final class a {

        /* renamed from: a */
        public final long f7567a;

        /* renamed from: b */
        public final Timeline f7568b;

        /* renamed from: c */
        public final int f7569c;

        /* renamed from: d */
        @Nullable
        public final MediaSource2.a f7570d;

        /* renamed from: e */
        public final long f7571e;

        /* renamed from: f */
        public final Timeline f7572f;

        /* renamed from: g */
        public final int f7573g;

        /* renamed from: h */
        @Nullable
        public final MediaSource2.a f7574h;

        /* renamed from: i */
        public final long f7575i;

        /* renamed from: j */
        public final long f7576j;

        public a(long j, Timeline timeline, int i, @Nullable MediaSource2.a aVar, long j2, Timeline timeline2, int i2, @Nullable MediaSource2.a aVar2, long j3, long j4) {
            this.f7567a = j;
            this.f7568b = timeline;
            this.f7569c = i;
            this.f7570d = aVar;
            this.f7571e = j2;
            this.f7572f = timeline2;
            this.f7573g = i2;
            this.f7574h = aVar2;
            this.f7575i = j3;
            this.f7576j = j4;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f7567a == aVar.f7567a && this.f7569c == aVar.f7569c && this.f7571e == aVar.f7571e && this.f7573g == aVar.f7573g && this.f7575i == aVar.f7575i && this.f7576j == aVar.f7576j && C3404f.m4252V(this.f7568b, aVar.f7568b) && C3404f.m4252V(this.f7570d, aVar.f7570d) && C3404f.m4252V(this.f7572f, aVar.f7572f) && C3404f.m4252V(this.f7574h, aVar.f7574h);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{Long.valueOf(this.f7567a), this.f7568b, Integer.valueOf(this.f7569c), this.f7570d, Long.valueOf(this.f7571e), this.f7572f, Integer.valueOf(this.f7573g), this.f7574h, Long.valueOf(this.f7575i), Long.valueOf(this.f7576j)});
        }
    }

    /* renamed from: A */
    void m3392A();

    /* renamed from: B */
    void m3393B();

    /* renamed from: C */
    void m3394C();

    /* renamed from: D */
    void m3395D();

    /* renamed from: E */
    void m3396E();

    @Deprecated
    /* renamed from: F */
    void m3397F();

    @Deprecated
    /* renamed from: G */
    void m3398G();

    /* renamed from: H */
    void m3399H();

    /* renamed from: I */
    void m3400I();

    /* renamed from: J */
    void m3401J();

    /* renamed from: K */
    void m3402K();

    @Deprecated
    /* renamed from: L */
    void m3403L();

    /* renamed from: M */
    void m3404M();

    /* renamed from: N */
    void m3405N();

    /* renamed from: O */
    void m3406O();

    /* renamed from: P */
    void m3407P();

    /* renamed from: Q */
    void m3408Q();

    /* renamed from: R */
    void m3409R();

    @Deprecated
    /* renamed from: S */
    void m3410S();

    @Deprecated
    /* renamed from: T */
    void m3411T();

    /* renamed from: U */
    void m3412U();

    /* renamed from: V */
    void m3413V();

    /* renamed from: W */
    void m3414W();

    /* renamed from: X */
    void m3415X();

    /* renamed from: Y */
    void m3416Y();

    /* renamed from: Z */
    void m3417Z();

    @Deprecated
    /* renamed from: a */
    void m3418a();

    /* renamed from: a0 */
    void m3419a0();

    /* renamed from: b */
    void m3420b();

    /* renamed from: b0 */
    void m3421b0();

    /* renamed from: c */
    void m3422c();

    /* renamed from: c0 */
    void m3423c0();

    /* renamed from: d */
    void m3424d();

    @Deprecated
    /* renamed from: d0 */
    void m3425d0();

    /* renamed from: e */
    void m3426e();

    /* renamed from: e0 */
    void m3427e0();

    /* renamed from: f */
    void m3428f();

    /* renamed from: f0 */
    void m3429f0();

    @Deprecated
    /* renamed from: g */
    void m3430g();

    /* renamed from: g0 */
    void m3431g0();

    /* renamed from: h */
    void m3432h();

    @Deprecated
    /* renamed from: h0 */
    void m3433h0();

    /* renamed from: i */
    void m3434i();

    @Deprecated
    /* renamed from: i0 */
    void m3435i0();

    /* renamed from: j */
    void m3436j();

    @Deprecated
    /* renamed from: j0 */
    void m3437j0();

    /* renamed from: k */
    void m3438k();

    @Deprecated
    /* renamed from: k0 */
    void m3439k0();

    /* renamed from: l */
    void m3440l();

    /* renamed from: l0 */
    void m3441l0();

    /* renamed from: m */
    void m3442m();

    @Deprecated
    /* renamed from: m0 */
    void m3443m0();

    /* renamed from: n */
    void m3444n();

    /* renamed from: n0 */
    void m3445n0();

    /* renamed from: o */
    void m3446o();

    /* renamed from: o0 */
    void m3447o0();

    /* renamed from: p */
    void m3448p();

    @Deprecated
    /* renamed from: p0 */
    void m3449p0();

    /* renamed from: q */
    void m3450q();

    @Deprecated
    /* renamed from: r */
    void m3451r();

    /* renamed from: s */
    void m3452s();

    /* renamed from: t */
    void m3453t();

    /* renamed from: u */
    void m3454u();

    /* renamed from: v */
    void m3455v();

    /* renamed from: w */
    void m3456w();

    @Deprecated
    /* renamed from: x */
    void m3457x();

    /* renamed from: y */
    void m3458y();

    /* renamed from: z */
    void m3459z();
}

package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.Objects;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* renamed from: b.i.a.f.h.l.i1 */
/* loaded from: classes3.dex */
public final class C3691i1 extends AbstractC3851u4<C3691i1, a> implements InterfaceC3626d6 {
    private static final C3691i1 zzj;
    private static volatile InterfaceC3710j6<C3691i1> zzk;
    private int zzc;
    private long zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private float zzh;
    private double zzi;

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    /* renamed from: b.i.a.f.h.l.i1$a */
    public static final class a extends AbstractC3851u4.b<C3691i1, a> implements InterfaceC3626d6 {
        public a() {
            super(C3691i1.m4944M());
        }

        /* renamed from: q */
        public final a m4958q(long j) {
            if (this.f10348l) {
                m5318n();
                this.f10348l = false;
            }
            C3691i1.m4947w((C3691i1) this.f10347k, j);
            return this;
        }

        /* renamed from: r */
        public final a m4959r(String str) {
            if (this.f10348l) {
                m5318n();
                this.f10348l = false;
            }
            C3691i1.m4948x((C3691i1) this.f10347k, str);
            return this;
        }

        /* renamed from: s */
        public final a m4960s(long j) {
            if (this.f10348l) {
                m5318n();
                this.f10348l = false;
            }
            C3691i1.m4940B((C3691i1) this.f10347k, j);
            return this;
        }

        public a(C3718k1 c3718k1) {
            super(C3691i1.m4944M());
        }
    }

    static {
        C3691i1 c3691i1 = new C3691i1();
        zzj = c3691i1;
        AbstractC3851u4.m5313r(C3691i1.class, c3691i1);
    }

    /* renamed from: A */
    public static void m4939A(C3691i1 c3691i1) {
        c3691i1.zzc &= -9;
        c3691i1.zzg = 0L;
    }

    /* renamed from: B */
    public static void m4940B(C3691i1 c3691i1, long j) {
        c3691i1.zzc |= 8;
        c3691i1.zzg = j;
    }

    /* renamed from: C */
    public static void m4941C(C3691i1 c3691i1, String str) {
        Objects.requireNonNull(c3691i1);
        str.getClass();
        c3691i1.zzc |= 4;
        c3691i1.zzf = str;
    }

    /* renamed from: E */
    public static void m4942E(C3691i1 c3691i1) {
        c3691i1.zzc &= -33;
        c3691i1.zzi = 0.0d;
    }

    /* renamed from: L */
    public static a m4943L() {
        return zzj.m5314s();
    }

    /* renamed from: M */
    public static /* synthetic */ C3691i1 m4944M() {
        return zzj;
    }

    /* renamed from: u */
    public static void m4945u(C3691i1 c3691i1) {
        c3691i1.zzc &= -5;
        c3691i1.zzf = zzj.zzf;
    }

    /* renamed from: v */
    public static void m4946v(C3691i1 c3691i1, double d) {
        c3691i1.zzc |= 32;
        c3691i1.zzi = d;
    }

    /* renamed from: w */
    public static void m4947w(C3691i1 c3691i1, long j) {
        c3691i1.zzc |= 1;
        c3691i1.zzd = j;
    }

    /* renamed from: x */
    public static void m4948x(C3691i1 c3691i1, String str) {
        Objects.requireNonNull(c3691i1);
        str.getClass();
        c3691i1.zzc |= 2;
        c3691i1.zze = str;
    }

    /* renamed from: D */
    public final String m4949D() {
        return this.zze;
    }

    /* renamed from: F */
    public final boolean m4950F() {
        return (this.zzc & 4) != 0;
    }

    /* renamed from: G */
    public final String m4951G() {
        return this.zzf;
    }

    /* renamed from: H */
    public final boolean m4952H() {
        return (this.zzc & 8) != 0;
    }

    /* renamed from: I */
    public final long m4953I() {
        return this.zzg;
    }

    /* renamed from: J */
    public final boolean m4954J() {
        return (this.zzc & 32) != 0;
    }

    /* renamed from: K */
    public final double m4955K() {
        return this.zzi;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3718k1.f10050a[i - 1]) {
            case 1:
                return new C3691i1();
            case 2:
                return new a(null);
            case 3:
                return new C3775o6(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                InterfaceC3710j6<C3691i1> aVar = zzk;
                if (aVar == null) {
                    synchronized (C3691i1.class) {
                        aVar = zzk;
                        if (aVar == null) {
                            aVar = new AbstractC3851u4.a<>(zzj);
                            zzk = aVar;
                        }
                        break;
                    }
                }
                return aVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    /* renamed from: y */
    public final boolean m4956y() {
        return (this.zzc & 1) != 0;
    }

    /* renamed from: z */
    public final long m4957z() {
        return this.zzd;
    }
}

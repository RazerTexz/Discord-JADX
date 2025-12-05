package p007b.p225i.p226a.p288f.p313h.p325l;

import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* renamed from: b.i.a.f.h.l.z0 */
/* loaded from: classes3.dex */
public final class C3912z0 extends AbstractC3851u4<C3912z0, a> implements InterfaceC3626d6 {
    private static final C3912z0 zzf;
    private static volatile InterfaceC3710j6<C3912z0> zzg;
    private int zzc;
    private int zzd;
    private long zze;

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    /* renamed from: b.i.a.f.h.l.z0$a */
    public static final class a extends AbstractC3851u4.b<C3912z0, a> implements InterfaceC3626d6 {
        public a() {
            super(C3912z0.m5390B());
        }

        public a(C3718k1 c3718k1) {
            super(C3912z0.m5390B());
        }
    }

    static {
        C3912z0 c3912z0 = new C3912z0();
        zzf = c3912z0;
        AbstractC3851u4.m5313r(C3912z0.class, c3912z0);
    }

    /* renamed from: A */
    public static a m5389A() {
        return zzf.m5314s();
    }

    /* renamed from: B */
    public static /* synthetic */ C3912z0 m5390B() {
        return zzf;
    }

    /* renamed from: u */
    public static void m5391u(C3912z0 c3912z0, int i) {
        c3912z0.zzc |= 1;
        c3912z0.zzd = i;
    }

    /* renamed from: v */
    public static void m5392v(C3912z0 c3912z0, long j) {
        c3912z0.zzc |= 2;
        c3912z0.zze = j;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3718k1.f10050a[i - 1]) {
            case 1:
                return new C3912z0();
            case 2:
                return new a(null);
            case 3:
                return new C3775o6(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                InterfaceC3710j6<C3912z0> aVar = zzg;
                if (aVar == null) {
                    synchronized (C3912z0.class) {
                        aVar = zzg;
                        if (aVar == null) {
                            aVar = new AbstractC3851u4.a<>(zzf);
                            zzg = aVar;
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

    /* renamed from: w */
    public final boolean m5393w() {
        return (this.zzc & 1) != 0;
    }

    /* renamed from: x */
    public final int m5394x() {
        return this.zzd;
    }

    /* renamed from: y */
    public final boolean m5395y() {
        return (this.zzc & 2) != 0;
    }

    /* renamed from: z */
    public final long m5396z() {
        return this.zze;
    }
}

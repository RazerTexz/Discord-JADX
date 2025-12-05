package p007b.p225i.p226a.p288f.p313h.p325l;

import com.discord.widgets.chat.input.MentionUtils;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* renamed from: b.i.a.f.h.l.f1 */
/* loaded from: classes3.dex */
public final class C3649f1 extends AbstractC3851u4<C3649f1, a> implements InterfaceC3626d6 {
    private static final C3649f1 zzf;
    private static volatile InterfaceC3710j6<C3649f1> zzg;
    private int zzc;
    private int zzd = 1;
    private InterfaceC3597b5<C3593b1> zze = C3749m6.f10094k;

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    /* renamed from: b.i.a.f.h.l.f1$a */
    public static final class a extends AbstractC3851u4.b<C3649f1, a> implements InterfaceC3626d6 {
        public a(C3718k1 c3718k1) {
            super(C3649f1.m4874u());
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    /* renamed from: b.i.a.f.h.l.f1$b */
    public enum b implements InterfaceC3903y4 {
        RADS(1),
        PROVISIONING(2);

        private final int zzd;

        b(int i) {
            this.zzd = i;
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3903y4
        /* renamed from: a */
        public final int mo4875a() {
            return this.zzd;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + b.class.getName() + MentionUtils.MENTIONS_CHAR + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
        }
    }

    static {
        C3649f1 c3649f1 = new C3649f1();
        zzf = c3649f1;
        AbstractC3851u4.m5313r(C3649f1.class, c3649f1);
    }

    /* renamed from: u */
    public static /* synthetic */ C3649f1 m4874u() {
        return zzf;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3718k1.f10050a[i - 1]) {
            case 1:
                return new C3649f1();
            case 2:
                return new a(null);
            case 3:
                return new C3775o6(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", C3744m1.f10089a, "zze", C3593b1.class});
            case 4:
                return zzf;
            case 5:
                InterfaceC3710j6<C3649f1> aVar = zzg;
                if (aVar == null) {
                    synchronized (C3649f1.class) {
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
}

package d0.e0.p.d.m0.k.a0;

import d0.e0.p.d.m0.k.a0.d;

/* compiled from: MemberScope.kt */
/* loaded from: classes3.dex */
public abstract class c {

    /* compiled from: MemberScope.kt */
    public static final class a extends c {
        public static final a a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final int f3452b;

        static {
            d.a aVar = d.a;
            f3452b = (~(aVar.getVARIABLES_MASK() | aVar.getFUNCTIONS_MASK())) & aVar.getALL_KINDS_MASK();
        }

        @Override // d0.e0.p.d.m0.k.a0.c
        public int getFullyExcludedDescriptorKinds() {
            return f3452b;
        }
    }

    /* compiled from: MemberScope.kt */
    public static final class b extends c {
        public static final b a = new b();

        @Override // d0.e0.p.d.m0.k.a0.c
        public int getFullyExcludedDescriptorKinds() {
            return 0;
        }
    }

    public abstract int getFullyExcludedDescriptorKinds();

    public String toString() {
        return getClass().getSimpleName();
    }
}

package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.c, reason: use source file name */
/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MemberScope {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.c$a */
    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class a extends MemberScope {

        /* JADX INFO: renamed from: a */
        public static final a f24336a = new a();

        /* JADX INFO: renamed from: b */
        public static final int f24337b;

        static {
            MemberScope2.a aVar = MemberScope2.f24339a;
            f24337b = (~(aVar.getVARIABLES_MASK() | aVar.getFUNCTIONS_MASK())) & aVar.getALL_KINDS_MASK();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope
        public int getFullyExcludedDescriptorKinds() {
            return f24337b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.c$b */
    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class b extends MemberScope {

        /* JADX INFO: renamed from: a */
        public static final b f24338a = new b();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope
        public int getFullyExcludedDescriptorKinds() {
            return 0;
        }
    }

    public abstract int getFullyExcludedDescriptorKinds();

    public String toString() {
        return getClass().getSimpleName();
    }
}

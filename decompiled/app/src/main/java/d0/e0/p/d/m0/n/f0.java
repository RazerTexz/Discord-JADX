package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.m.f;
import kotlin.jvm.functions.Function0;

/* compiled from: SpecialTypes.kt */
/* loaded from: classes3.dex */
public final class f0 extends k1 {
    public final d0.e0.p.d.m0.m.o k;
    public final Function0<c0> l;
    public final d0.e0.p.d.m0.m.j<c0> m;

    /* compiled from: SpecialTypes.kt */
    public static final class a extends d0.z.d.o implements Function0<c0> {
        public final /* synthetic */ d0.e0.p.d.m0.n.l1.g $kotlinTypeRefiner;
        public final /* synthetic */ f0 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d0.e0.p.d.m0.n.l1.g gVar, f0 f0Var) {
            super(0);
            this.$kotlinTypeRefiner = gVar;
            this.this$0 = f0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ c0 invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0 invoke() {
            return this.$kotlinTypeRefiner.refineType((c0) f0.access$getComputation$p(this.this$0).invoke());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f0(d0.e0.p.d.m0.m.o oVar, Function0<? extends c0> function0) {
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(function0, "computation");
        this.k = oVar;
        this.l = function0;
        this.m = oVar.createLazyValue(function0);
    }

    public static final /* synthetic */ Function0 access$getComputation$p(f0 f0Var) {
        return f0Var.l;
    }

    @Override // d0.e0.p.d.m0.n.k1
    public c0 a() {
        return this.m.invoke();
    }

    @Override // d0.e0.p.d.m0.n.k1
    public boolean isComputed() {
        return ((f.h) this.m).isComputed();
    }

    @Override // d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ c0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.c0
    public f0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return new f0(this.k, new a(gVar, this));
    }
}

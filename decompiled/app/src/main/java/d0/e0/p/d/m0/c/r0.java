package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.k.a0.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: ScopesHolderForClass.kt */
/* loaded from: classes3.dex */
public final class r0<T extends d0.e0.p.d.m0.k.a0.i> {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3299b = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(r0.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    public final e c;
    public final Function1<d0.e0.p.d.m0.n.l1.g, T> d;
    public final d0.e0.p.d.m0.n.l1.g e;
    public final d0.e0.p.d.m0.m.j f;

    /* compiled from: ScopesHolderForClass.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final <T extends d0.e0.p.d.m0.k.a0.i> r0<T> create(e eVar, d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.n.l1.g gVar, Function1<? super d0.e0.p.d.m0.n.l1.g, ? extends T> function1) {
            d0.z.d.m.checkNotNullParameter(eVar, "classDescriptor");
            d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
            d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefinerForOwnerModule");
            d0.z.d.m.checkNotNullParameter(function1, "scopeFactory");
            return new r0<>(eVar, oVar, function1, gVar, null);
        }
    }

    /* compiled from: ScopesHolderForClass.kt */
    public static final class b extends d0.z.d.o implements Function0<T> {
        public final /* synthetic */ d0.e0.p.d.m0.n.l1.g $kotlinTypeRefiner;
        public final /* synthetic */ r0<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(r0<T> r0Var, d0.e0.p.d.m0.n.l1.g gVar) {
            super(0);
            this.this$0 = r0Var;
            this.$kotlinTypeRefiner = gVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return invoke();
        }

        @Override // kotlin.jvm.functions.Function0
        public final T invoke() {
            return (T) r0.access$getScopeFactory$p(this.this$0).invoke(this.$kotlinTypeRefiner);
        }
    }

    public r0(e eVar, d0.e0.p.d.m0.m.o oVar, Function1 function1, d0.e0.p.d.m0.n.l1.g gVar, DefaultConstructorMarker defaultConstructorMarker) {
        this.c = eVar;
        this.d = function1;
        this.e = gVar;
        this.f = oVar.createLazyValue(new s0(this));
    }

    public static final /* synthetic */ d0.e0.p.d.m0.n.l1.g access$getKotlinTypeRefinerForOwnerModule$p(r0 r0Var) {
        return r0Var.e;
    }

    public static final /* synthetic */ Function1 access$getScopeFactory$p(r0 r0Var) {
        return r0Var.d;
    }

    public final T getScope(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        if (!gVar.isRefinementNeededForModule(d0.e0.p.d.m0.k.x.a.getModule(this.c))) {
            return (T) d0.e0.p.d.m0.m.n.getValue(this.f, this, (KProperty<?>) f3299b[0]);
        }
        d0.e0.p.d.m0.n.u0 typeConstructor = this.c.getTypeConstructor();
        d0.z.d.m.checkNotNullExpressionValue(typeConstructor, "classDescriptor.typeConstructor");
        return !gVar.isRefinementNeededForTypeConstructor(typeConstructor) ? (T) d0.e0.p.d.m0.m.n.getValue(this.f, this, (KProperty<?>) f3299b[0]) : (T) gVar.getOrPutScopeForClass(this.c, new b(this, gVar));
    }
}

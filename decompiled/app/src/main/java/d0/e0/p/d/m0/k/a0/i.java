package d0.e0.p.d.m0.k.a0;

import d0.e0.p.d.m0.c.t0;
import d0.t.n0;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* compiled from: MemberScope.kt */
/* loaded from: classes3.dex */
public interface i extends l {
    public static final a a = a.a;

    /* compiled from: MemberScope.kt */
    public static final class a {
        public static final /* synthetic */ a a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final Function1<d0.e0.p.d.m0.g.e, Boolean> f3460b = C0564a.j;

        /* compiled from: MemberScope.kt */
        /* renamed from: d0.e0.p.d.m0.k.a0.i$a$a, reason: collision with other inner class name */
        public static final class C0564a extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.e, Boolean> {
            public static final C0564a j = new C0564a();

            public C0564a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.g.e eVar) {
                return Boolean.valueOf(invoke2(eVar));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(d0.e0.p.d.m0.g.e eVar) {
                d0.z.d.m.checkNotNullParameter(eVar, "it");
                return true;
            }
        }

        public final Function1<d0.e0.p.d.m0.g.e, Boolean> getALL_NAME_FILTER() {
            return f3460b;
        }
    }

    /* compiled from: MemberScope.kt */
    public static final class b extends j {

        /* renamed from: b, reason: collision with root package name */
        public static final b f3461b = new b();

        @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
        public Set<d0.e0.p.d.m0.g.e> getClassifierNames() {
            return n0.emptySet();
        }

        @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
        public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
            return n0.emptySet();
        }

        @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
        public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
            return n0.emptySet();
        }
    }

    Set<d0.e0.p.d.m0.g.e> getClassifierNames();

    Collection<? extends t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar);

    Collection<? extends d0.e0.p.d.m0.c.n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar);

    Set<d0.e0.p.d.m0.g.e> getFunctionNames();

    Set<d0.e0.p.d.m0.g.e> getVariableNames();
}

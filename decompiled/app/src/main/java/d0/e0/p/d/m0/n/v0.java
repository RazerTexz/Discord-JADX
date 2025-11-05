package d0.e0.p.d.m0.n;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TypeSubstitution.kt */
/* loaded from: classes3.dex */
public abstract class v0 extends z0 {

    /* renamed from: b, reason: collision with root package name */
    public static final a f3542b = new a(null);

    /* compiled from: TypeSubstitution.kt */
    public static final class a {

        /* compiled from: TypeSubstitution.kt */
        /* renamed from: d0.e0.p.d.m0.n.v0$a$a, reason: collision with other inner class name */
        public static final class C0586a extends v0 {
            public final /* synthetic */ Map<u0, w0> c;
            public final /* synthetic */ boolean d;

            /* JADX WARN: Multi-variable type inference failed */
            public C0586a(Map<u0, ? extends w0> map, boolean z2) {
                this.c = map;
                this.d = z2;
            }

            @Override // d0.e0.p.d.m0.n.z0
            public boolean approximateCapturedTypes() {
                return this.d;
            }

            @Override // d0.e0.p.d.m0.n.v0
            public w0 get(u0 u0Var) {
                d0.z.d.m.checkNotNullParameter(u0Var, "key");
                return this.c.get(u0Var);
            }

            @Override // d0.e0.p.d.m0.n.z0
            public boolean isEmpty() {
                return this.c.isEmpty();
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static /* synthetic */ v0 createByConstructorsMap$default(a aVar, Map map, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            return aVar.createByConstructorsMap(map, z2);
        }

        public final z0 create(c0 c0Var) {
            d0.z.d.m.checkNotNullParameter(c0Var, "kotlinType");
            return create(c0Var.getConstructor(), c0Var.getArguments());
        }

        public final v0 createByConstructorsMap(Map<u0, ? extends w0> map) {
            d0.z.d.m.checkNotNullParameter(map, "map");
            return createByConstructorsMap$default(this, map, false, 2, null);
        }

        public final v0 createByConstructorsMap(Map<u0, ? extends w0> map, boolean z2) {
            d0.z.d.m.checkNotNullParameter(map, "map");
            return new C0586a(map, z2);
        }

        public final z0 create(u0 u0Var, List<? extends w0> list) {
            d0.z.d.m.checkNotNullParameter(u0Var, "typeConstructor");
            d0.z.d.m.checkNotNullParameter(list, "arguments");
            List<d0.e0.p.d.m0.c.z0> parameters = u0Var.getParameters();
            d0.z.d.m.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
            d0.e0.p.d.m0.c.z0 z0Var = (d0.e0.p.d.m0.c.z0) d0.t.u.lastOrNull((List) parameters);
            if (!d0.z.d.m.areEqual(z0Var == null ? null : Boolean.valueOf(z0Var.isCapturedFromOuterDeclaration()), Boolean.TRUE)) {
                return new z(parameters, list);
            }
            List<d0.e0.p.d.m0.c.z0> parameters2 = u0Var.getParameters();
            d0.z.d.m.checkNotNullExpressionValue(parameters2, "typeConstructor.parameters");
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(parameters2, 10));
            Iterator<T> it = parameters2.iterator();
            while (it.hasNext()) {
                arrayList.add(((d0.e0.p.d.m0.c.z0) it.next()).getTypeConstructor());
            }
            return createByConstructorsMap$default(this, d0.t.h0.toMap(d0.t.u.zip(arrayList, list)), false, 2, null);
        }
    }

    public static final z0 create(u0 u0Var, List<? extends w0> list) {
        return f3542b.create(u0Var, list);
    }

    public static final v0 createByConstructorsMap(Map<u0, ? extends w0> map) {
        return f3542b.createByConstructorsMap(map);
    }

    @Override // d0.e0.p.d.m0.n.z0
    public w0 get(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "key");
        return get(c0Var.getConstructor());
    }

    public abstract w0 get(u0 u0Var);
}

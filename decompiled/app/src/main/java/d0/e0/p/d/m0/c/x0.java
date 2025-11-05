package d0.e0.p.d.m0.c;

import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SupertypeLoopChecker.kt */
/* loaded from: classes3.dex */
public interface x0 {

    /* compiled from: SupertypeLoopChecker.kt */
    public static final class a implements x0 {
        public static final a a = new a();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d0.e0.p.d.m0.c.x0
        public Collection<d0.e0.p.d.m0.n.c0> findLoopsInSupertypesAndDisconnect(d0.e0.p.d.m0.n.u0 u0Var, Collection<? extends d0.e0.p.d.m0.n.c0> collection, Function1<? super d0.e0.p.d.m0.n.u0, ? extends Iterable<? extends d0.e0.p.d.m0.n.c0>> function1, Function1<? super d0.e0.p.d.m0.n.c0, Unit> function12) {
            d0.z.d.m.checkNotNullParameter(u0Var, "currentTypeConstructor");
            d0.z.d.m.checkNotNullParameter(collection, "superTypes");
            d0.z.d.m.checkNotNullParameter(function1, "neighbors");
            d0.z.d.m.checkNotNullParameter(function12, "reportLoop");
            return collection;
        }
    }

    Collection<d0.e0.p.d.m0.n.c0> findLoopsInSupertypesAndDisconnect(d0.e0.p.d.m0.n.u0 u0Var, Collection<? extends d0.e0.p.d.m0.n.c0> collection, Function1<? super d0.e0.p.d.m0.n.u0, ? extends Iterable<? extends d0.e0.p.d.m0.n.c0>> function1, Function1<? super d0.e0.p.d.m0.n.c0, Unit> function12);
}

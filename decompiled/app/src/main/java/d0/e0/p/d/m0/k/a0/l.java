package d0.e0.p.d.m0.k.a0;

import java.util.Collection;
import kotlin.jvm.functions.Function1;

/* compiled from: ResolutionScope.kt */
/* loaded from: classes3.dex */
public interface l {

    /* compiled from: ResolutionScope.kt */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection getContributedDescriptors$default(l lVar, d dVar, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
            }
            if ((i & 1) != 0) {
                dVar = d.m;
            }
            if ((i & 2) != 0) {
                function1 = i.a.getALL_NAME_FILTER();
            }
            return lVar.getContributedDescriptors(dVar, function1);
        }
    }

    d0.e0.p.d.m0.c.h getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar);

    Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1);
}

package androidx.view;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.C13116h1;
import p659s.p660a.Dispatchers;
import p659s.p660a.p661a.MainDispatchers;

/* JADX INFO: renamed from: androidx.lifecycle.LifecycleKt, reason: use source file name */
/* JADX INFO: compiled from: Lifecycle.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Lifecycle4 {
    public static final Lifecycle2 getCoroutineScope(Lifecycle lifecycle) {
        Lifecycle3 lifecycle3;
        Intrinsics3.checkNotNullParameter(lifecycle, "$this$coroutineScope");
        do {
            Lifecycle3 lifecycle32 = (Lifecycle3) lifecycle.mInternalScopeRef.get();
            if (lifecycle32 != null) {
                return lifecycle32;
            }
            Job jobM4279d = C3404f.m4279d(null, 1);
            CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
            lifecycle3 = new Lifecycle3(lifecycle, CoroutineContext.Element.C12790a.plus((C13116h1) jobM4279d, MainDispatchers.f27700b.mo11194H()));
        } while (!lifecycle.mInternalScopeRef.compareAndSet(null, lifecycle3));
        lifecycle3.register();
        return lifecycle3;
    }
}

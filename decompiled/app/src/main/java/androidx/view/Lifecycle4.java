package androidx.view;

import b.i.a.f.e.o.f;
import d0.z.d.Intrinsics3;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import s.a.Dispatchers;
import s.a.a.MainDispatchers;
import s.a.h1;

/* compiled from: Lifecycle.kt */
/* renamed from: androidx.lifecycle.LifecycleKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Lifecycle4 {
    public static final Lifecycle2 getCoroutineScope(Lifecycle lifecycle) {
        Lifecycle3 lifecycle3;
        Intrinsics3.checkNotNullParameter(lifecycle, "$this$coroutineScope");
        do {
            Lifecycle3 lifecycle32 = (Lifecycle3) lifecycle.mInternalScopeRef.get();
            if (lifecycle32 != null) {
                return lifecycle32;
            }
            Job jobD = f.d(null, 1);
            CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
            lifecycle3 = new Lifecycle3(lifecycle, CoroutineContext.Element.a.plus((h1) jobD, MainDispatchers.f3830b.H()));
        } while (!lifecycle.mInternalScopeRef.compareAndSet(null, lifecycle3));
        lifecycle3.register();
        return lifecycle3;
    }
}

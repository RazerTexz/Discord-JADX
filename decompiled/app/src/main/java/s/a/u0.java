package s.a;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* compiled from: Executors.kt */
/* loaded from: classes3.dex */
public final class u0 extends d0.z.d.o implements Function1<CoroutineContext.Element, ExecutorCoroutineDispatcher> {
    public static final u0 j = new u0();

    public u0() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public ExecutorCoroutineDispatcher invoke(CoroutineContext.Element element) {
        CoroutineContext.Element element2 = element;
        if (!(element2 instanceof ExecutorCoroutineDispatcher)) {
            element2 = null;
        }
        return (ExecutorCoroutineDispatcher) element2;
    }
}

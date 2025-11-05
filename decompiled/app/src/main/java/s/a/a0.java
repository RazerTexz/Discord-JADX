package s.a;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: CoroutineDispatcher.kt */
/* loaded from: classes3.dex */
public final class a0 extends d0.z.d.o implements Function1<CoroutineContext.Element, CoroutineDispatcher> {
    public static final a0 j = new a0();

    public a0() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public CoroutineDispatcher invoke(CoroutineContext.Element element) {
        CoroutineContext.Element element2 = element;
        if (!(element2 instanceof CoroutineDispatcher)) {
            element2 = null;
        }
        return (CoroutineDispatcher) element2;
    }
}

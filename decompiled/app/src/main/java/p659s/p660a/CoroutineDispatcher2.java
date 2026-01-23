package p659s.p660a;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: s.a.a0, reason: use source file name */
/* JADX INFO: compiled from: CoroutineDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CoroutineDispatcher2 extends Lambda implements Function1<CoroutineContext.Element, CoroutineDispatcher> {

    /* JADX INFO: renamed from: j */
    public static final CoroutineDispatcher2 f27711j = new CoroutineDispatcher2();

    public CoroutineDispatcher2() {
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

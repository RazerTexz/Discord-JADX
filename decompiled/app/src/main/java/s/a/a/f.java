package s.a.a;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Scopes.kt */
/* loaded from: classes3.dex */
public final class f implements CoroutineScope {
    public final CoroutineContext j;

    public f(CoroutineContext coroutineContext) {
        this.j = coroutineContext;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.j;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("CoroutineScope(coroutineContext=");
        sbU.append(this.j);
        sbU.append(')');
        return sbU.toString();
    }
}

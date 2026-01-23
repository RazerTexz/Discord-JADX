package p659s.p660a.p661a;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: s.a.a.f, reason: use source file name */
/* JADX INFO: compiled from: Scopes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Scopes implements CoroutineScope {

    /* JADX INFO: renamed from: j */
    public final CoroutineContext f27674j;

    public Scopes(CoroutineContext coroutineContext) {
        this.f27674j = coroutineContext;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f27674j;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("CoroutineScope(coroutineContext=");
        sbM833U.append(this.f27674j);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}

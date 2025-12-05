package androidx.view;

import java.io.Closeable;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ViewModel.kt */
/* renamed from: androidx.lifecycle.CloseableCoroutineScope, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewModel2 implements Closeable, CoroutineScope {
    private final CoroutineContext coroutineContext;

    public ViewModel2(CoroutineContext coroutineContext) {
        Intrinsics3.checkNotNullParameter(coroutineContext, "context");
        this.coroutineContext = coroutineContext;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        C3404f.m4339s(getCoroutineContext(), null, 1, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }
}

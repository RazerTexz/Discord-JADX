package androidx.view;

import kotlin.coroutines.CoroutineContext;

/* compiled from: DispatchQueue.kt */
/* renamed from: androidx.lifecycle.DispatchQueue$dispatchAndEnqueue$$inlined$with$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class DispatchQueue2 implements Runnable {
    public final /* synthetic */ CoroutineContext $context$inlined;
    public final /* synthetic */ Runnable $runnable$inlined;
    public final /* synthetic */ DispatchQueue this$0;

    public DispatchQueue2(DispatchQueue dispatchQueue, CoroutineContext coroutineContext, Runnable runnable) {
        this.this$0 = dispatchQueue;
        this.$context$inlined = coroutineContext;
        this.$runnable$inlined = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DispatchQueue.access$enqueue(this.this$0, this.$runnable$inlined);
    }
}

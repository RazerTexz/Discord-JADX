package androidx.work;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CancellableContinuation;
import p007b.p225i.p355b.p359d.p360a.ListenableFuture8;
import p507d0.Result2;
import p507d0.Result3;

/* JADX INFO: renamed from: androidx.work.OperationKt$await$$inlined$suspendCancellableCoroutine$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: ListenableFuture.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ListenableFuture6 implements Runnable {
    public final /* synthetic */ CancellableContinuation $cancellableContinuation;
    public final /* synthetic */ ListenableFuture8 $this_await$inlined;

    public ListenableFuture6(CancellableContinuation cancellableContinuation, ListenableFuture8 listenableFuture8) {
        this.$cancellableContinuation = cancellableContinuation;
        this.$this_await$inlined = listenableFuture8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            CancellableContinuation cancellableContinuation = this.$cancellableContinuation;
            V v = this.$this_await$inlined.get();
            Result2.a aVar = Result2.f25169j;
            cancellableContinuation.resumeWith(Result2.m11474constructorimpl(v));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                cause = th;
            }
            if (th instanceof CancellationException) {
                this.$cancellableContinuation.mo10906k(cause);
                return;
            }
            CancellableContinuation cancellableContinuation2 = this.$cancellableContinuation;
            Result2.a aVar2 = Result2.f25169j;
            cancellableContinuation2.resumeWith(Result2.m11474constructorimpl(Result3.createFailure(cause)));
        }
    }
}

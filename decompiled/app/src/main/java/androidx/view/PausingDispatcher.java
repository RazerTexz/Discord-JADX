package androidx.view;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.Dispatchers;
import p659s.p660a.p661a.MainDispatchers;

/* JADX INFO: compiled from: PausingDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PausingDispatcher extends CoroutineDispatcher {
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext context, Runnable block) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(block, "block");
        this.dispatchQueue.dispatchAndEnqueue(context, block);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        if (MainDispatchers.f27700b.mo11194H().isDispatchNeeded(context)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}

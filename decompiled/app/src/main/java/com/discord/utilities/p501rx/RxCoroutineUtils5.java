package com.discord.utilities.p501rx;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.Produce;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p584w.ContinuationInterceptor;
import p507d0.p584w.CoroutineContextImpl4;
import p637j0.Observer2;
import p659s.p660a.AbstractC13142q0;
import p659s.p660a.Builders4;
import p659s.p660a.C13119i1;
import p659s.p660a.C13161w1;
import p659s.p660a.CompletionState2;
import p659s.p660a.Dispatchers;
import p659s.p660a.InterfaceC13169z0;
import p659s.p660a.p663c2.Channels;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2$subscription$1, reason: use source file name */
/* JADX INFO: compiled from: RxCoroutineUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxCoroutineUtils5<T> implements Observer2<T> {
    public final /* synthetic */ Produce $this_callbackFlow;

    public RxCoroutineUtils5(Produce<? super T> produce) {
        this.$this_callbackFlow = produce;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        C3404f.m4213I(this.$this_callbackFlow, null, 1, null);
    }

    @Override // p637j0.Observer2
    public void onError(Throwable e) {
        C3404f.m4335r(this.$this_callbackFlow, C3404f.m4267a("Error in Observable", e));
    }

    @Override // p637j0.Observer2
    public void onNext(T value) throws Throwable {
        AbstractC13142q0 abstractC13142q0M11353a;
        CoroutineContext coroutineContextPlus;
        Produce produce = this.$this_callbackFlow;
        if (produce.offer(value)) {
            return;
        }
        Channels channels = new Channels(produce, value, null);
        CoroutineContext coroutineContext = CoroutineContextImpl4.f25237j;
        Thread threadCurrentThread = Thread.currentThread();
        ContinuationInterceptor.b bVar = ContinuationInterceptor.b.f25236a;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(bVar);
        if (continuationInterceptor == null) {
            C13161w1 c13161w1 = C13161w1.f27916b;
            abstractC13142q0M11353a = C13161w1.m11353a();
            coroutineContextPlus = coroutineContext.plus(coroutineContext.plus(abstractC13142q0M11353a));
            CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
            if (coroutineContextPlus != coroutineDispatcher && coroutineContextPlus.get(bVar) == null) {
                coroutineContextPlus = coroutineContextPlus.plus(coroutineDispatcher);
            }
        } else {
            if (!(continuationInterceptor instanceof AbstractC13142q0)) {
                continuationInterceptor = null;
            }
            C13161w1 c13161w12 = C13161w1.f27916b;
            abstractC13142q0M11353a = C13161w1.f27915a.get();
            coroutineContextPlus = coroutineContext.plus(coroutineContext);
            CoroutineDispatcher coroutineDispatcher2 = Dispatchers.f27866a;
            if (coroutineContextPlus != coroutineDispatcher2 && coroutineContextPlus.get(bVar) == null) {
                coroutineContextPlus = coroutineContextPlus.plus(coroutineDispatcher2);
            }
        }
        Builders4 builders4 = new Builders4(coroutineContextPlus, threadCurrentThread, abstractC13142q0M11353a);
        builders4.m11191j0(CoroutineStart.DEFAULT, builders4, channels);
        AbstractC13142q0 abstractC13142q0 = builders4.f27842n;
        if (abstractC13142q0 != null) {
            int i = AbstractC13142q0.f27883j;
            abstractC13142q0.m11337L(false);
        }
        while (!Thread.interrupted()) {
            try {
                AbstractC13142q0 abstractC13142q02 = builders4.f27842n;
                long jMo11339O = abstractC13142q02 != null ? abstractC13142q02.mo11339O() : RecyclerView.FOREVER_NS;
                if (!(builders4.m11292M() instanceof InterfaceC13169z0)) {
                    Object objM11314a = C13119i1.m11314a(builders4.m11292M());
                    CompletionState2 completionState2 = (CompletionState2) (objM11314a instanceof CompletionState2 ? objM11314a : null);
                    if (completionState2 != null) {
                        throw completionState2.f27913b;
                    }
                    return;
                }
                LockSupport.parkNanos(builders4, jMo11339O);
            } finally {
                AbstractC13142q0 abstractC13142q03 = builders4.f27842n;
                if (abstractC13142q03 != null) {
                    int i2 = AbstractC13142q0.f27883j;
                    abstractC13142q03.m11334H(false);
                }
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        builders4.m11306w(interruptedException);
        throw interruptedException;
    }
}

package p659s.p660a.p662b2;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p659s.p660a.Delay;
import p659s.p660a.Job2;
import p659s.p660a.MainCoroutineDispatcher;

/* JADX INFO: renamed from: s.a.b2.b, reason: use source file name */
/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class HandlerDispatcher3 extends MainCoroutineDispatcher implements Delay {
    public HandlerDispatcher3() {
    }

    /* JADX INFO: renamed from: x */
    public Job2 mo11196x(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return C3404f.m4360x0(j, runnable, coroutineContext);
    }

    public HandlerDispatcher3(DefaultConstructorMarker defaultConstructorMarker) {
    }
}

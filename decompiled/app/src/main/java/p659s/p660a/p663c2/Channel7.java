package p659s.p660a.p663c2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* compiled from: Channel.kt */
/* renamed from: s.a.c2.s, reason: use source file name */
/* loaded from: classes3.dex */
public interface Channel7<E> {
    /* renamed from: j */
    boolean mo11221j(Throwable th);

    /* renamed from: l */
    void mo11223l(Function1<? super Throwable, Unit> function1);

    /* renamed from: o */
    Object mo11224o(E e, Continuation<? super Unit> continuation);

    boolean offer(E e);

    /* renamed from: p */
    boolean mo11225p();
}

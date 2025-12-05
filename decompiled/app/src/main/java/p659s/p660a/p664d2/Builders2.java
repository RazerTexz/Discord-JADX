package p659s.p660a.p664d2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Produce;
import p007b.p100d.p104b.p105a.outline;
import p659s.p660a.p663c2.BufferOverflow;
import p659s.p660a.p664d2.p665g.ChannelFlow;

/* compiled from: Builders.kt */
/* renamed from: s.a.d2.c, reason: use source file name */
/* loaded from: classes3.dex */
public class Builders2<T> extends ChannelFlow<T> {

    /* renamed from: d */
    public final Function2<Produce<? super T>, Continuation<? super Unit>, Object> f27782d;

    /* JADX WARN: Multi-variable type inference failed */
    public Builders2(Function2<? super Produce<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.f27782d = function2;
    }

    @Override // p659s.p660a.p664d2.p665g.ChannelFlow
    public String toString() {
        StringBuilder sbM833U = outline.m833U("block[");
        sbM833U.append(this.f27782d);
        sbM833U.append("] -> ");
        sbM833U.append(super.toString());
        return sbM833U.toString();
    }
}

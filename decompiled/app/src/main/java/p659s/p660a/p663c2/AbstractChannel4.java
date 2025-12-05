package p659s.p660a.p663c2;

import kotlinx.coroutines.channels.Channel2;
import kotlinx.coroutines.channels.Channel3;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p659s.p660a.CancellableContinuationImpl6;
import p659s.p660a.p661a.LockFreeLinkedList3;
import p659s.p660a.p661a.Symbol3;

/* compiled from: AbstractChannel.kt */
/* renamed from: s.a.c2.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class AbstractChannel4<E> extends AbstractChannel7 implements AbstractChannel6<E> {

    /* renamed from: m */
    public final Throwable f27763m;

    public AbstractChannel4(Throwable th) {
        this.f27763m = th;
    }

    @Override // p659s.p660a.p663c2.AbstractChannel6
    /* renamed from: b */
    public Object mo11232b() {
        return this;
    }

    @Override // p659s.p660a.p663c2.AbstractChannel6
    /* renamed from: c */
    public void mo11209c(E e) {
    }

    @Override // p659s.p660a.p663c2.AbstractChannel6
    /* renamed from: d */
    public Symbol3 mo11210d(E e, LockFreeLinkedList3.b bVar) {
        return CancellableContinuationImpl6.f27874a;
    }

    @Override // p659s.p660a.p663c2.AbstractChannel7
    /* renamed from: q */
    public void mo11227q() {
    }

    @Override // p659s.p660a.p663c2.AbstractChannel7
    /* renamed from: r */
    public Object mo11228r() {
        return this;
    }

    @Override // p659s.p660a.p663c2.AbstractChannel7
    /* renamed from: s */
    public void mo11229s(AbstractChannel4<?> abstractChannel4) {
    }

    @Override // p659s.p660a.p663c2.AbstractChannel7
    /* renamed from: t */
    public Symbol3 mo11230t(LockFreeLinkedList3.b bVar) {
        return CancellableContinuationImpl6.f27874a;
    }

    @Override // p659s.p660a.p661a.LockFreeLinkedList3
    public String toString() {
        StringBuilder sbM833U = outline.m833U("Closed@");
        sbM833U.append(C3404f.m4312l0(this));
        sbM833U.append('[');
        sbM833U.append(this.f27763m);
        sbM833U.append(']');
        return sbM833U.toString();
    }

    /* renamed from: v */
    public final Throwable m11233v() {
        Throwable th = this.f27763m;
        return th != null ? th : new Channel2("Channel was closed");
    }

    /* renamed from: w */
    public final Throwable m11234w() {
        Throwable th = this.f27763m;
        return th != null ? th : new Channel3("Channel was closed");
    }
}

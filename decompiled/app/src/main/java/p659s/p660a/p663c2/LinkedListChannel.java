package p659s.p660a.p663c2;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.outline;
import p659s.p660a.p661a.LockFreeLinkedList;
import p659s.p660a.p661a.LockFreeLinkedList3;
import p659s.p660a.p661a.Symbol3;
import p659s.p660a.p663c2.AbstractChannel3;

/* compiled from: LinkedListChannel.kt */
/* renamed from: s.a.c2.k, reason: use source file name */
/* loaded from: classes3.dex */
public class LinkedListChannel<E> extends AbstractChannel<E> {
    public LinkedListChannel(Function1<? super E, Unit> function1) {
        super(function1);
    }

    @Override // p659s.p660a.p663c2.AbstractChannel3
    /* renamed from: h */
    public final boolean mo11219h() {
        return false;
    }

    @Override // p659s.p660a.p663c2.AbstractChannel3
    /* renamed from: i */
    public final boolean mo11220i() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p659s.p660a.p663c2.AbstractChannel3
    /* renamed from: k */
    public Object mo11222k(E e) {
        AbstractChannel6 abstractChannel6;
        do {
            Object objMo11222k = super.mo11222k(e);
            Symbol3 symbol3 = AbstractChannel2.f27740b;
            if (objMo11222k == symbol3) {
                return symbol3;
            }
            if (objMo11222k != AbstractChannel2.f27741c) {
                if (objMo11222k instanceof AbstractChannel4) {
                    return objMo11222k;
                }
                throw new IllegalStateException(outline.m881v("Invalid offerInternal result ", objMo11222k).toString());
            }
            LockFreeLinkedList lockFreeLinkedList = this.f27746k;
            AbstractChannel3.a aVar = new AbstractChannel3.a(e);
            while (true) {
                LockFreeLinkedList3 lockFreeLinkedList3M11157k = lockFreeLinkedList.m11157k();
                if (lockFreeLinkedList3M11157k instanceof AbstractChannel6) {
                    abstractChannel6 = (AbstractChannel6) lockFreeLinkedList3M11157k;
                    break;
                }
                if (lockFreeLinkedList3M11157k.m11152e(aVar, lockFreeLinkedList)) {
                    abstractChannel6 = null;
                    break;
                }
            }
            if (abstractChannel6 == null) {
                return AbstractChannel2.f27740b;
            }
        } while (!(abstractChannel6 instanceof AbstractChannel4));
        return abstractChannel6;
    }

    @Override // p659s.p660a.p663c2.AbstractChannel
    /* renamed from: s */
    public final boolean mo11203s() {
        return true;
    }

    @Override // p659s.p660a.p663c2.AbstractChannel
    /* renamed from: t */
    public final boolean mo11204t() {
        return true;
    }
}

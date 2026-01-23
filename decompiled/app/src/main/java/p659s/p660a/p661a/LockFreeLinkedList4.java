package p659s.p660a.p661a;

import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: s.a.a.q, reason: use source file name */
/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LockFreeLinkedList4 {

    /* JADX INFO: renamed from: a */
    public final LockFreeLinkedList3 f27701a;

    public LockFreeLinkedList4(LockFreeLinkedList3 lockFreeLinkedList3) {
        this.f27701a = lockFreeLinkedList3;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Removed[");
        sbM833U.append(this.f27701a);
        sbM833U.append(']');
        return sbM833U.toString();
    }
}

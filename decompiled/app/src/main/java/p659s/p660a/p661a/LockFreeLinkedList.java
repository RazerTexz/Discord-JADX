package p659s.p660a.p661a;

/* compiled from: LockFreeLinkedList.kt */
/* renamed from: s.a.a.i, reason: use source file name */
/* loaded from: classes3.dex */
public class LockFreeLinkedList extends LockFreeLinkedList3 {
    @Override // p659s.p660a.p661a.LockFreeLinkedList3
    /* renamed from: m */
    public boolean mo11150m() {
        return false;
    }

    @Override // p659s.p660a.p661a.LockFreeLinkedList3
    /* renamed from: n */
    public final boolean mo11151n() {
        throw new IllegalStateException("head cannot be removed".toString());
    }
}

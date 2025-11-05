package s.a.a;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes3.dex */
public class i extends k {
    @Override // s.a.a.k
    public boolean m() {
        return false;
    }

    @Override // s.a.a.k
    public final boolean n() {
        throw new IllegalStateException("head cannot be removed".toString());
    }
}

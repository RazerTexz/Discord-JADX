package p007b.p225i.p226a.p242c.p259f3;

/* compiled from: ConditionVariable.java */
/* renamed from: b.i.a.c.f3.j, reason: use source file name */
/* loaded from: classes3.dex */
public class ConditionVariable {

    /* renamed from: a */
    public final Clock4 f6727a = Clock4.f6720a;

    /* renamed from: b */
    public boolean f6728b;

    /* renamed from: a */
    public synchronized boolean m3025a() {
        boolean z2;
        z2 = this.f6728b;
        this.f6728b = false;
        return z2;
    }

    /* renamed from: b */
    public synchronized boolean m3026b() {
        if (this.f6728b) {
            return false;
        }
        this.f6728b = true;
        notifyAll();
        return true;
    }
}

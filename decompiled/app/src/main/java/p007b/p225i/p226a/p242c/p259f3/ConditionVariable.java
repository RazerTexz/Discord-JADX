package p007b.p225i.p226a.p242c.p259f3;

/* JADX INFO: renamed from: b.i.a.c.f3.j, reason: use source file name */
/* JADX INFO: compiled from: ConditionVariable.java */
/* JADX INFO: loaded from: classes3.dex */
public class ConditionVariable {

    /* JADX INFO: renamed from: a */
    public final Clock4 f6727a = Clock4.f6720a;

    /* JADX INFO: renamed from: b */
    public boolean f6728b;

    /* JADX INFO: renamed from: a */
    public synchronized boolean m3025a() {
        boolean z2;
        z2 = this.f6728b;
        this.f6728b = false;
        return z2;
    }

    /* JADX INFO: renamed from: b */
    public synchronized boolean m3026b() {
        if (this.f6728b) {
            return false;
        }
        this.f6728b = true;
        notifyAll();
        return true;
    }
}

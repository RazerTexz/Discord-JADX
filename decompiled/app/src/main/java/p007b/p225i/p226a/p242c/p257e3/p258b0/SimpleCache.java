package p007b.p225i.p226a.p242c.p257e3.p258b0;

import android.os.ConditionVariable;

/* compiled from: SimpleCache.java */
/* renamed from: b.i.a.c.e3.b0.q, reason: use source file name */
/* loaded from: classes3.dex */
public class SimpleCache extends Thread {

    /* renamed from: j */
    public final /* synthetic */ ConditionVariable f6504j;

    /* renamed from: k */
    public final /* synthetic */ SimpleCache2 f6505k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleCache(SimpleCache2 simpleCache2, String str, ConditionVariable conditionVariable) {
        super(str);
        this.f6505k = simpleCache2;
        this.f6504j = conditionVariable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        synchronized (this.f6505k) {
            this.f6504j.open();
            SimpleCache2.m2823j(this.f6505k);
            this.f6505k.f6508c.mo2786e();
        }
    }
}

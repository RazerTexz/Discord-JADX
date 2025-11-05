package j0.l.a;

import j0.l.a.j1;
import rx.functions.Action0;

/* compiled from: OperatorReplay.java */
/* loaded from: classes3.dex */
public class m1 implements Action0 {
    public final /* synthetic */ j1.f j;

    public m1(j1.f fVar) {
        this.j = fVar;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T[], java.lang.Object[]] */
    @Override // rx.functions.Action0
    public void call() {
        if (this.j.m) {
            return;
        }
        synchronized (this.j.n) {
            if (!this.j.m) {
                j1.f fVar = this.j;
                j0.l.e.g<j1.c<T>> gVar = fVar.n;
                gVar.f3794b = 0;
                gVar.d = new Object[0];
                fVar.p++;
                this.j.m = true;
            }
        }
    }
}

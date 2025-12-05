package p637j0.p642l.p643a;

import p637j0.p642l.p643a.OperatorReplay;
import p637j0.p642l.p647e.OpenHashSet;
import p658rx.functions.Action0;

/* compiled from: OperatorReplay.java */
/* renamed from: j0.l.a.m1, reason: use source file name */
/* loaded from: classes3.dex */
public class OperatorReplay4 implements Action0 {

    /* renamed from: j */
    public final /* synthetic */ OperatorReplay.f f26911j;

    public OperatorReplay4(OperatorReplay.f fVar) {
        this.f26911j = fVar;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T[], java.lang.Object[]] */
    @Override // p658rx.functions.Action0
    public void call() {
        if (this.f26911j.f26864m) {
            return;
        }
        synchronized (this.f26911j.f26865n) {
            if (!this.f26911j.f26864m) {
                OperatorReplay.f fVar = this.f26911j;
                OpenHashSet<OperatorReplay.c<T>> openHashSet = fVar.f26865n;
                openHashSet.f27278b = 0;
                openHashSet.f27280d = new Object[0];
                fVar.f26867p++;
                this.f26911j.f26864m = true;
            }
        }
    }
}

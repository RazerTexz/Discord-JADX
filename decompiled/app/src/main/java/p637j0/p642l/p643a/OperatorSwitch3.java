package p637j0.p642l.p643a;

import p637j0.p642l.p643a.OperatorSwitch2;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.z1, reason: use source file name */
/* JADX INFO: compiled from: OperatorSwitch.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorSwitch3 implements Action0 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ OperatorSwitch2.c f27158j;

    public OperatorSwitch3(OperatorSwitch2.c cVar) {
        this.f27158j = cVar;
    }

    @Override // p658rx.functions.Action0
    public void call() {
        OperatorSwitch2.c cVar = this.f27158j;
        synchronized (cVar) {
            cVar.f27138s = null;
        }
    }
}

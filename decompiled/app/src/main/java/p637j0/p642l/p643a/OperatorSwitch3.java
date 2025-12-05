package p637j0.p642l.p643a;

import p637j0.p642l.p643a.OperatorSwitch2;
import p658rx.functions.Action0;

/* compiled from: OperatorSwitch.java */
/* renamed from: j0.l.a.z1, reason: use source file name */
/* loaded from: classes3.dex */
public class OperatorSwitch3 implements Action0 {

    /* renamed from: j */
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

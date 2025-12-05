package p637j0.p642l.p643a;

import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p643a.OperatorSwitch2;
import p658rx.Producer;

/* compiled from: OperatorSwitch.java */
/* renamed from: j0.l.a.a2, reason: use source file name */
/* loaded from: classes3.dex */
public class OperatorSwitch implements Producer {

    /* renamed from: j */
    public final /* synthetic */ OperatorSwitch2.c f26736j;

    public OperatorSwitch(OperatorSwitch2.c cVar) {
        this.f26736j = cVar;
    }

    @Override // p658rx.Producer
    /* renamed from: j */
    public void mo10704j(long j) {
        Producer producer;
        if (j <= 0) {
            if (j < 0) {
                throw new IllegalArgumentException(outline.m877t("n >= 0 expected but it was ", j));
            }
            return;
        }
        OperatorSwitch2.c cVar = this.f26736j;
        synchronized (cVar) {
            producer = cVar.f27138s;
            cVar.f27137r = C3404f.m4287f(cVar.f27137r, j);
        }
        if (producer != null) {
            producer.mo10704j(j);
        }
        cVar.m10791b();
    }
}

package p637j0.p642l.p643a;

import p637j0.p642l.p643a.OperatorTakeUntilPredicate2;
import p658rx.Producer;

/* compiled from: OperatorTakeUntilPredicate.java */
/* renamed from: j0.l.a.g2, reason: use source file name */
/* loaded from: classes3.dex */
public class OperatorTakeUntilPredicate implements Producer {

    /* renamed from: j */
    public final /* synthetic */ OperatorTakeUntilPredicate2.a f26811j;

    public OperatorTakeUntilPredicate(OperatorTakeUntilPredicate2 operatorTakeUntilPredicate2, OperatorTakeUntilPredicate2.a aVar) {
        this.f26811j = aVar;
    }

    @Override // p658rx.Producer
    /* renamed from: j */
    public void mo10704j(long j) {
        this.f26811j.request(j);
    }
}

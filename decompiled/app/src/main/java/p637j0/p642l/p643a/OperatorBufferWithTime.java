package p637j0.p642l.p643a;

import java.util.ArrayList;
import java.util.Collection;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p643a.OperatorBufferWithTime2;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.m0, reason: use source file name */
/* JADX INFO: compiled from: OperatorBufferWithTime.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorBufferWithTime implements Action0 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ OperatorBufferWithTime2.a f26910j;

    public OperatorBufferWithTime(OperatorBufferWithTime2.a aVar) {
        this.f26910j = aVar;
    }

    @Override // p658rx.functions.Action0
    public void call() {
        OperatorBufferWithTime2.a aVar = this.f26910j;
        synchronized (aVar) {
            if (aVar.f26939m) {
                return;
            }
            Collection collection = aVar.f26938l;
            aVar.f26938l = new ArrayList();
            try {
                aVar.f26936j.onNext(collection);
            } catch (Throwable th) {
                C3404f.m4325o1(th);
                aVar.onError(th);
            }
        }
    }
}

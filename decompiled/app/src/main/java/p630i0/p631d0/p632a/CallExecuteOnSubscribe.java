package p630i0.p631d0.p632a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p630i0.Call3;
import p658rx.Observable;
import p658rx.Subscriber;
import retrofit2.Response;

/* JADX INFO: renamed from: i0.d0.a.c, reason: use source file name */
/* JADX INFO: compiled from: CallExecuteOnSubscribe.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CallExecuteOnSubscribe<T> implements Observable.InterfaceC13005a<Response<T>> {

    /* JADX INFO: renamed from: j */
    public final Call3<T> f26500j;

    public CallExecuteOnSubscribe(Call3<T> call3) {
        this.f26500j = call3;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Call3<T> call3Mo10698L = this.f26500j.mo10698L();
        CallArbiter callArbiter = new CallArbiter(call3Mo10698L, subscriber);
        subscriber.add(callArbiter);
        subscriber.setProducer(callArbiter);
        try {
            callArbiter.m10703c(call3Mo10698L.execute());
        } catch (Throwable th) {
            C3404f.m4325o1(th);
            callArbiter.m10702b(th);
        }
    }
}

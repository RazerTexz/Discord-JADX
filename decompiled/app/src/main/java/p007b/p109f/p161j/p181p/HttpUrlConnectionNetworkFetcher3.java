package p007b.p109f.p161j.p181p;

import java.util.Objects;
import java.util.concurrent.Future;
import p007b.p109f.p161j.p181p.NetworkFetchProducer;
import p007b.p109f.p161j.p181p.NetworkFetcher2;

/* compiled from: HttpUrlConnectionNetworkFetcher.java */
/* renamed from: b.f.j.p.z, reason: use source file name */
/* loaded from: classes3.dex */
public class HttpUrlConnectionNetworkFetcher3 extends BaseProducerContextCallbacks {

    /* renamed from: a */
    public final /* synthetic */ Future f4264a;

    /* renamed from: b */
    public final /* synthetic */ NetworkFetcher2.a f4265b;

    public HttpUrlConnectionNetworkFetcher3(HttpUrlConnectionNetworkFetcher httpUrlConnectionNetworkFetcher, Future future, NetworkFetcher2.a aVar) {
        this.f4264a = future;
        this.f4265b = aVar;
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContextCallbacks
    /* renamed from: a */
    public void mo1438a() {
        if (this.f4264a.cancel(false)) {
            NetworkFetchProducer.a aVar = (NetworkFetchProducer.a) this.f4265b;
            NetworkFetchProducer networkFetchProducer = NetworkFetchProducer.this;
            FetchState2 fetchState2 = aVar.f4172a;
            Objects.requireNonNull(networkFetchProducer);
            fetchState2.m1524a().mo1357d(fetchState2.f4259b, "NetworkFetchProducer", null);
            fetchState2.f4258a.mo1426d();
        }
    }
}

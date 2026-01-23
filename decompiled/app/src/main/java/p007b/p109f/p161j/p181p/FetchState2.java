package p007b.p109f.p161j.p181p;

import p007b.p109f.p161j.p175j.EncodedImage2;

/* JADX INFO: renamed from: b.f.j.p.x, reason: use source file name */
/* JADX INFO: compiled from: FetchState.java */
/* JADX INFO: loaded from: classes3.dex */
public class FetchState2 {

    /* JADX INFO: renamed from: a */
    public final Consumer2<EncodedImage2> f4258a;

    /* JADX INFO: renamed from: b */
    public final ProducerContext f4259b;

    /* JADX INFO: renamed from: c */
    public long f4260c = 0;

    public FetchState2(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        this.f4258a = consumer2;
        this.f4259b = producerContext;
    }

    /* JADX INFO: renamed from: a */
    public ProducerListener2 m1524a() {
        return this.f4259b.mo1457o();
    }
}

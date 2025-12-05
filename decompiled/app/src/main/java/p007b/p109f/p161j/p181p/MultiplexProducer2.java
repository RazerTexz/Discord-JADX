package p007b.p109f.p161j.p181p;

import android.util.Pair;
import java.util.List;
import p007b.p109f.p161j.p169d.Priority2;
import p007b.p109f.p161j.p181p.MultiplexProducer;

/* compiled from: MultiplexProducer.java */
/* renamed from: b.f.j.p.m0, reason: use source file name */
/* loaded from: classes3.dex */
public class MultiplexProducer2 extends BaseProducerContextCallbacks {

    /* renamed from: a */
    public final /* synthetic */ Pair f4141a;

    /* renamed from: b */
    public final /* synthetic */ MultiplexProducer.b f4142b;

    public MultiplexProducer2(MultiplexProducer.b bVar, Pair pair) {
        this.f4142b = bVar;
        this.f4141a = pair;
    }

    @Override // p007b.p109f.p161j.p181p.ProducerContextCallbacks
    /* renamed from: a */
    public void mo1438a() {
        boolean zRemove;
        List<ProducerContextCallbacks> list;
        BaseProducerContext baseProducerContext;
        List<ProducerContextCallbacks> listM1492j;
        List<ProducerContextCallbacks> listM1494l;
        synchronized (this.f4142b) {
            zRemove = this.f4142b.f4133b.remove(this.f4141a);
            list = null;
            if (!zRemove) {
                baseProducerContext = null;
            } else if (this.f4142b.f4133b.isEmpty()) {
                baseProducerContext = this.f4142b.f4137f;
            } else {
                List<ProducerContextCallbacks> listM1493k = this.f4142b.m1493k();
                listM1494l = this.f4142b.m1494l();
                listM1492j = this.f4142b.m1492j();
                baseProducerContext = null;
                list = listM1493k;
            }
            listM1494l = null;
            listM1492j = null;
        }
        BaseProducerContext.m1441s(list);
        BaseProducerContext.m1442t(listM1494l);
        BaseProducerContext.m1440r(listM1492j);
        if (baseProducerContext != null) {
            if (!MultiplexProducer.this.f4129c || baseProducerContext.mo1453k()) {
                baseProducerContext.m1460u();
            } else {
                BaseProducerContext.m1442t(baseProducerContext.m1461v(Priority2.LOW));
            }
        }
        if (zRemove) {
            ((Consumer2) this.f4141a.first).mo1426d();
        }
    }

    @Override // p007b.p109f.p161j.p181p.BaseProducerContextCallbacks, p007b.p109f.p161j.p181p.ProducerContextCallbacks
    /* renamed from: b */
    public void mo1439b() {
        BaseProducerContext.m1440r(this.f4142b.m1492j());
    }

    @Override // p007b.p109f.p161j.p181p.BaseProducerContextCallbacks, p007b.p109f.p161j.p181p.ProducerContextCallbacks
    /* renamed from: c */
    public void mo1462c() {
        BaseProducerContext.m1442t(this.f4142b.m1494l());
    }

    @Override // p007b.p109f.p161j.p181p.BaseProducerContextCallbacks, p007b.p109f.p161j.p181p.ProducerContextCallbacks
    /* renamed from: d */
    public void mo1463d() {
        BaseProducerContext.m1441s(this.f4142b.m1493k());
    }
}

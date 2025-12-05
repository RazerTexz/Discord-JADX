package p007b.p109f.p161j.p171f;

import p007b.p109f.p129e.AbstractDataSource3;
import p007b.p109f.p161j.p176k.RequestListener2;
import p007b.p109f.p161j.p181p.Producer2;
import p007b.p109f.p161j.p181p.SettableProducerContext;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* compiled from: AbstractProducerToDataSourceAdapter.java */
/* renamed from: b.f.j.f.b, reason: use source file name */
/* loaded from: classes.dex */
public abstract class AbstractProducerToDataSourceAdapter2<T> extends AbstractDataSource3<T> {

    /* renamed from: h */
    public final SettableProducerContext f3866h;

    /* renamed from: i */
    public final RequestListener2 f3867i;

    public AbstractProducerToDataSourceAdapter2(Producer2<T> producer2, SettableProducerContext settableProducerContext, RequestListener2 requestListener2) {
        FrescoSystrace.m1527b();
        this.f3866h = settableProducerContext;
        this.f3867i = requestListener2;
        this.f3152a = settableProducerContext.f4032h;
        FrescoSystrace.m1527b();
        requestListener2.mo1355b(settableProducerContext);
        FrescoSystrace.m1527b();
        FrescoSystrace.m1527b();
        producer2.mo1417b(new AbstractProducerToDataSourceAdapter(this), settableProducerContext);
        FrescoSystrace.m1527b();
        FrescoSystrace.m1527b();
    }

    @Override // p007b.p109f.p129e.AbstractDataSource3, com.facebook.datasource.DataSource
    public boolean close() {
        if (!super.close()) {
            return false;
        }
        if (mo1019c()) {
            return true;
        }
        this.f3867i.mo1362i(this.f3866h);
        this.f3866h.m1460u();
        return true;
    }
}

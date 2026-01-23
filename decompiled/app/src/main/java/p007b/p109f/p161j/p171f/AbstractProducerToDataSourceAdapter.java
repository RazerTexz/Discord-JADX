package p007b.p109f.p161j.p171f;

import com.facebook.common.references.CloseableReference;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p161j.p181p.BaseConsumer;
import p007b.p109f.p161j.p181p.SettableProducerContext;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.f.j.f.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractProducerToDataSourceAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class AbstractProducerToDataSourceAdapter<T> extends BaseConsumer<T> {

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AbstractProducerToDataSourceAdapter2 f3865b;

    public AbstractProducerToDataSourceAdapter(AbstractProducerToDataSourceAdapter2 abstractProducerToDataSourceAdapter2) {
        this.f3865b = abstractProducerToDataSourceAdapter2;
    }

    @Override // p007b.p109f.p161j.p181p.BaseConsumer
    /* JADX INFO: renamed from: g */
    public void mo1318g() {
        AbstractProducerToDataSourceAdapter2 abstractProducerToDataSourceAdapter2 = this.f3865b;
        synchronized (abstractProducerToDataSourceAdapter2) {
            AnimatableValueParser.m419B(abstractProducerToDataSourceAdapter2.m1025i());
        }
    }

    @Override // p007b.p109f.p161j.p181p.BaseConsumer
    /* JADX INFO: renamed from: h */
    public void mo1319h(Throwable th) {
        AbstractProducerToDataSourceAdapter2 abstractProducerToDataSourceAdapter2 = this.f3865b;
        if (abstractProducerToDataSourceAdapter2.m1027k(th, abstractProducerToDataSourceAdapter2.f3866h.mo1443a())) {
            abstractProducerToDataSourceAdapter2.f3867i.mo1361h(abstractProducerToDataSourceAdapter2.f3866h, th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p109f.p161j.p181p.BaseConsumer
    /* JADX INFO: renamed from: i */
    public void mo1320i(T t, int i) {
        AbstractProducerToDataSourceAdapter2 abstractProducerToDataSourceAdapter2 = this.f3865b;
        SettableProducerContext settableProducerContext = abstractProducerToDataSourceAdapter2.f3866h;
        CloseableProducerToDataSourceAdapter closeableProducerToDataSourceAdapter = (CloseableProducerToDataSourceAdapter) abstractProducerToDataSourceAdapter2;
        Objects.requireNonNull(closeableProducerToDataSourceAdapter);
        CloseableReference closeableReferenceM8636n = CloseableReference.m8636n((CloseableReference) t);
        boolean zM1419e = BaseConsumer.m1419e(i);
        if (closeableProducerToDataSourceAdapter.m1029m(closeableReferenceM8636n, zM1419e, settableProducerContext.mo1443a()) && zM1419e) {
            closeableProducerToDataSourceAdapter.f3867i.mo1359f(closeableProducerToDataSourceAdapter.f3866h);
        }
    }

    @Override // p007b.p109f.p161j.p181p.BaseConsumer
    /* JADX INFO: renamed from: j */
    public void mo1321j(float f) {
        this.f3865b.m1028l(f);
    }
}

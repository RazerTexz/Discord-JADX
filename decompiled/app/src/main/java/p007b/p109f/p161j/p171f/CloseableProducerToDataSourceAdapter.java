package p007b.p109f.p161j.p171f;

import com.facebook.common.references.CloseableReference;
import p007b.p109f.p161j.p176k.RequestListener2;
import p007b.p109f.p161j.p181p.Producer2;
import p007b.p109f.p161j.p181p.SettableProducerContext;

/* JADX INFO: renamed from: b.f.j.f.d, reason: use source file name */
/* JADX INFO: compiled from: CloseableProducerToDataSourceAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class CloseableProducerToDataSourceAdapter<T> extends AbstractProducerToDataSourceAdapter2<CloseableReference<T>> {
    public CloseableProducerToDataSourceAdapter(Producer2<CloseableReference<T>> producer2, SettableProducerContext settableProducerContext, RequestListener2 requestListener2) {
        super(producer2, settableProducerContext, requestListener2);
    }

    @Override // p007b.p109f.p129e.AbstractDataSource3
    /* JADX INFO: renamed from: g */
    public void mo1023g(Object obj) {
        Class<CloseableReference> cls = CloseableReference.f19438j;
        ((CloseableReference) obj).close();
    }

    @Override // p007b.p109f.p129e.AbstractDataSource3, com.facebook.datasource.DataSource
    public Object getResult() {
        return CloseableReference.m8636n((CloseableReference) super.getResult());
    }
}

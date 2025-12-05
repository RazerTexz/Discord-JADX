package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.zzap;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* renamed from: b.i.a.f.i.b.n */
/* loaded from: classes3.dex */
public final class C4120n implements Iterator<String> {

    /* renamed from: j */
    public Iterator<String> f10974j;

    /* renamed from: k */
    public final /* synthetic */ zzap f10975k;

    public C4120n(zzap zzapVar) {
        this.f10975k = zzapVar;
        this.f10974j = zzapVar.f20665j.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f10974j.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f10974j.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}

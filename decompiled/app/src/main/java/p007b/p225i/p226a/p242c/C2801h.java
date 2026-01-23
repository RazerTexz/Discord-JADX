package p007b.p225i.p226a.p242c;

import android.content.Context;
import p007b.p225i.p226a.p242c.p243a3.DefaultMediaSourceFactory;
import p007b.p225i.p226a.p242c.p267x2.DefaultExtractorsFactory;
import p007b.p225i.p355b.p356a.Supplier2;

/* JADX INFO: renamed from: b.i.a.c.h */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2801h implements Supplier2 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Context f7050j;

    public /* synthetic */ C2801h(Context context) {
        this.f7050j = context;
    }

    @Override // p007b.p225i.p355b.p356a.Supplier2
    public final Object get() {
        return new DefaultMediaSourceFactory(this.f7050j, new DefaultExtractorsFactory());
    }
}

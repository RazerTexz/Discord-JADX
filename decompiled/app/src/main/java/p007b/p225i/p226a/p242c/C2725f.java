package p007b.p225i.p226a.p242c;

import android.content.Context;
import p007b.p225i.p355b.p356a.Supplier2;

/* JADX INFO: renamed from: b.i.a.c.f */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2725f implements Supplier2 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Context f6649j;

    public /* synthetic */ C2725f(Context context) {
        this.f6649j = context;
    }

    @Override // p007b.p225i.p355b.p356a.Supplier2
    public final Object get() {
        return new DefaultRenderersFactory(this.f6649j);
    }
}

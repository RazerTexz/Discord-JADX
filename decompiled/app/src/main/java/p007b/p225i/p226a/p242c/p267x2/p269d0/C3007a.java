package p007b.p225i.p226a.p242c.p267x2.p269d0;

import android.net.Uri;
import java.util.Map;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorsFactory;
import p007b.p225i.p226a.p242c.p267x2.ExtractorsFactory2;

/* JADX INFO: renamed from: b.i.a.c.x2.d0.a */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C3007a implements ExtractorsFactory2 {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ C3007a f8095a = new C3007a();

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorsFactory2
    /* JADX INFO: renamed from: a */
    public final Extractor[] mo3630a() {
        return new Extractor[]{new FlacExtractor(0)};
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorsFactory2
    /* JADX INFO: renamed from: b */
    public /* synthetic */ Extractor[] mo3631b(Uri uri, Map map) {
        return ExtractorsFactory.m3748a(this, uri, map);
    }
}

package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.net.Uri;
import java.util.Map;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorsFactory;
import p007b.p225i.p226a.p242c.p267x2.ExtractorsFactory2;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.d */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C3076d implements ExtractorsFactory2 {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ C3076d f8594a = new C3076d();

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorsFactory2
    /* JADX INFO: renamed from: a */
    public final Extractor[] mo3630a() {
        return new Extractor[]{new PsExtractor()};
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorsFactory2
    /* JADX INFO: renamed from: b */
    public /* synthetic */ Extractor[] mo3631b(Uri uri, Map map) {
        return ExtractorsFactory.m3748a(this, uri, map);
    }
}

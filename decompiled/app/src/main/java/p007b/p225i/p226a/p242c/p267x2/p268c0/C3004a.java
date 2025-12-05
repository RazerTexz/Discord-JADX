package p007b.p225i.p226a.p242c.p267x2.p268c0;

import android.net.Uri;
import java.util.Map;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorsFactory;
import p007b.p225i.p226a.p242c.p267x2.ExtractorsFactory2;

/* compiled from: lambda */
/* renamed from: b.i.a.c.x2.c0.a */
/* loaded from: classes3.dex */
public final /* synthetic */ class C3004a implements ExtractorsFactory2 {

    /* renamed from: a */
    public static final /* synthetic */ C3004a f8067a = new C3004a();

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorsFactory2
    /* renamed from: a */
    public final Extractor[] mo3630a() {
        return new Extractor[]{new AmrExtractor(0)};
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.ExtractorsFactory2
    /* renamed from: b */
    public /* synthetic */ Extractor[] mo3631b(Uri uri, Map map) {
        return ExtractorsFactory.m3748a(this, uri, map);
    }
}

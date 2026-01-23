package p600f0;

import java.util.List;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: f0.o, reason: use source file name */
/* JADX INFO: compiled from: CookieJar.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CookieJar implements CookieJar2 {
    @Override // p600f0.CookieJar2
    /* JADX INFO: renamed from: a */
    public void mo8745a(HttpUrl httpUrl, List<Cookie> list) {
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        Intrinsics3.checkParameterIsNotNull(list, "cookies");
    }

    @Override // p600f0.CookieJar2
    /* JADX INFO: renamed from: b */
    public List<Cookie> mo8746b(HttpUrl httpUrl) {
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        return Collections2.emptyList();
    }
}

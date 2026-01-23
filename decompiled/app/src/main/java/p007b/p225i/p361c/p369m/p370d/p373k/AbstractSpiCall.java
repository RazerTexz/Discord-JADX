package p007b.p225i.p361c.p369m.p370d.p373k;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import p007b.p225i.p361c.p369m.p370d.p377n.HttpRequest;
import p007b.p225i.p361c.p369m.p370d.p377n.HttpRequestFactory;

/* JADX INFO: renamed from: b.i.c.m.d.k.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractSpiCall.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractSpiCall {

    /* JADX INFO: renamed from: a */
    public static final Pattern f12252a = Pattern.compile("http(s?)://[^\\/]+", 2);

    /* JADX INFO: renamed from: b */
    public final String f12253b;

    /* JADX INFO: renamed from: c */
    public final HttpRequestFactory f12254c;

    /* JADX INFO: renamed from: d */
    public final int f12255d;

    /* JADX INFO: renamed from: e */
    public final String f12256e;

    public AbstractSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, int i) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        if (httpRequestFactory == null) {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
        this.f12256e = str;
        this.f12253b = CommonUtils.m6426t(str) ? str2 : f12252a.matcher(str2).replaceFirst(str);
        this.f12254c = httpRequestFactory;
        this.f12255d = i;
    }

    /* JADX INFO: renamed from: b */
    public HttpRequest m6390b() {
        return m6391c(Collections.emptyMap());
    }

    /* JADX INFO: renamed from: c */
    public HttpRequest m6391c(Map<String, String> map) {
        HttpRequestFactory httpRequestFactory = this.f12254c;
        int i = this.f12255d;
        String str = this.f12253b;
        Objects.requireNonNull(httpRequestFactory);
        HttpRequest httpRequest = new HttpRequest(i, str, map);
        httpRequest.f12661e.put("User-Agent", "Crashlytics Android SDK/17.3.0");
        httpRequest.f12661e.put("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
        return httpRequest;
    }
}

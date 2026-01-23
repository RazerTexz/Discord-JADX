package p007b.p225i.p361c.p369m.p370d.p377n;

import com.discord.models.domain.ModelAuditLogEntry;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import p007b.p085c.p086a.p095y.C1563b;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.CacheControl;
import p600f0.HttpUrl;
import p600f0.OkHttpClient;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p605g.RealCall;

/* JADX INFO: renamed from: b.i.c.m.d.n.a, reason: use source file name */
/* JADX INFO: compiled from: HttpRequest.java */
/* JADX INFO: loaded from: classes3.dex */
public class HttpRequest {

    /* JADX INFO: renamed from: a */
    public static final OkHttpClient f12657a;

    /* JADX INFO: renamed from: b */
    public final int f12658b;

    /* JADX INFO: renamed from: c */
    public final String f12659c;

    /* JADX INFO: renamed from: d */
    public final Map<String, String> f12660d;

    /* JADX INFO: renamed from: f */
    public MultipartBody.C12933a f12662f = null;

    /* JADX INFO: renamed from: e */
    public final Map<String, String> f12661e = new HashMap();

    static {
        OkHttpClient.a aVarM10418f = new OkHttpClient().m10418f();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Intrinsics3.checkParameterIsNotNull(timeUnit, "unit");
        aVarM10418f.f26051w = Util7.m10121b("timeout", 10000L, timeUnit);
        f12657a = new OkHttpClient(aVarM10418f);
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;)V */
    public HttpRequest(int i, String str, Map map) {
        this.f12658b = i;
        this.f12659c = str;
        this.f12660d = map;
    }

    /* JADX INFO: renamed from: a */
    public HttpResponse m6621a() throws IOException {
        HttpUrl httpUrlM10409b;
        Request.C12935a c12935a = new Request.C12935a();
        CacheControl cacheControl = new CacheControl(true, false, -1, -1, false, false, false, -1, -1, false, false, false, null, null);
        Intrinsics3.checkParameterIsNotNull(cacheControl, "cacheControl");
        String string = cacheControl.toString();
        if (string.length() == 0) {
            c12935a.m10981d("Cache-Control");
        } else {
            c12935a.m10979b("Cache-Control", string);
        }
        String str = this.f12659c;
        Intrinsics3.checkParameterIsNotNull(str, "$this$toHttpUrlOrNull");
        try {
            Intrinsics3.checkParameterIsNotNull(str, "$this$toHttpUrl");
            HttpUrl.a aVar = new HttpUrl.a();
            aVar.m10412e(null, str);
            httpUrlM10409b = aVar.m10409b();
        } catch (IllegalArgumentException unused) {
            httpUrlM10409b = null;
        }
        HttpUrl.a aVarM10404f = httpUrlM10409b.m10404f();
        for (Map.Entry<String, String> entry : this.f12660d.entrySet()) {
            aVarM10404f.m10408a(entry.getKey(), entry.getValue());
        }
        c12935a.m10984g(aVarM10404f.m10409b());
        for (Map.Entry<String, String> entry2 : this.f12661e.entrySet()) {
            c12935a.m10979b(entry2.getKey(), entry2.getValue());
        }
        MultipartBody.C12933a c12933a = this.f12662f;
        c12935a.m10980c(C1563b.m764n(this.f12658b), c12933a == null ? null : c12933a.m10973b());
        Response responseExecute = ((RealCall) f12657a.mo10114b(c12935a.m10978a())).execute();
        ResponseBody responseBody = responseExecute.body;
        return new HttpResponse(responseExecute.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String, responseBody != null ? responseBody.m10998d() : null, responseExecute.headers);
    }

    /* JADX INFO: renamed from: b */
    public HttpRequest m6622b(String str, String str2) {
        if (this.f12662f == null) {
            MultipartBody.C12933a c12933a = new MultipartBody.C12933a();
            c12933a.m10974c(MultipartBody.f27522b);
            this.f12662f = c12933a;
        }
        MultipartBody.C12933a c12933a2 = this.f12662f;
        Objects.requireNonNull(c12933a2);
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull(str2, "value");
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull(str2, "value");
        c12933a2.m10972a(MultipartBody.Part.m10971b(str, null, RequestBody.INSTANCE.m10987a(str2, null)));
        this.f12662f = c12933a2;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public HttpRequest m6623c(String str, String str2, String str3, File file) {
        MediaType.Companion c12932a = MediaType.INSTANCE;
        RequestBody requestBodyCreate = RequestBody.create(MediaType.Companion.m10968b(str3), file);
        if (this.f12662f == null) {
            MultipartBody.C12933a c12933a = new MultipartBody.C12933a();
            c12933a.m10974c(MultipartBody.f27522b);
            this.f12662f = c12933a;
        }
        MultipartBody.C12933a c12933a2 = this.f12662f;
        Objects.requireNonNull(c12933a2);
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull(requestBodyCreate, "body");
        c12933a2.m10972a(MultipartBody.Part.m10971b(str, str2, requestBodyCreate));
        this.f12662f = c12933a2;
        return this;
    }
}

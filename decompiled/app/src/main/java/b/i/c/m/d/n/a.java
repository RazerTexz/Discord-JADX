package b.i.c.m.d.n;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import f0.d;
import f0.e0.g.e;
import f0.w;
import f0.x;
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

/* compiled from: HttpRequest.java */
/* loaded from: classes3.dex */
public class a {
    public static final x a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1736b;
    public final String c;
    public final Map<String, String> d;
    public MultipartBody.a f = null;
    public final Map<String, String> e = new HashMap();

    static {
        x.a aVarF = new x().f();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        m.checkParameterIsNotNull(timeUnit, "unit");
        aVarF.w = f0.e0.c.b("timeout", 10000L, timeUnit);
        a = new x(aVarF);
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;)V */
    public a(int i, String str, Map map) {
        this.f1736b = i;
        this.c = str;
        this.d = map;
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1096)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1050)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    public c a() throws IOException {
        w wVarB;
        Request.a aVar = new Request.a();
        d dVar = new d(true, false, -1, -1, false, false, false, -1, -1, false, false, false, null, null);
        m.checkParameterIsNotNull(dVar, "cacheControl");
        String string = dVar.toString();
        if (string.length() == 0) {
            aVar.d("Cache-Control");
        } else {
            aVar.b("Cache-Control", string);
        }
        String str = this.c;
        m.checkParameterIsNotNull(str, "$this$toHttpUrlOrNull");
        try {
            m.checkParameterIsNotNull(str, "$this$toHttpUrl");
            w.a aVar2 = new w.a();
            aVar2.e(null, str);
            wVarB = aVar2.b();
        } catch (IllegalArgumentException unused) {
            wVarB = null;
        }
        w.a aVarF = wVarB.f();
        for (Map.Entry<String, String> entry : this.d.entrySet()) {
            aVarF.a(entry.getKey(), entry.getValue());
        }
        aVar.g(aVarF.b());
        for (Map.Entry<String, String> entry2 : this.e.entrySet()) {
            aVar.b(entry2.getKey(), entry2.getValue());
        }
        MultipartBody.a aVar3 = this.f;
        aVar.c(b.c.a.y.b.n(this.f1736b), aVar3 == null ? null : aVar3.b());
        Response responseExecute = ((e) a.b(aVar.a())).execute();
        ResponseBody responseBody = responseExecute.body;
        return new c(responseExecute.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String, responseBody != null ? responseBody.d() : null, responseExecute.headers);
    }

    public a b(String str, String str2) {
        if (this.f == null) {
            MultipartBody.a aVar = new MultipartBody.a();
            aVar.c(MultipartBody.f3809b);
            this.f = aVar;
        }
        MultipartBody.a aVar2 = this.f;
        Objects.requireNonNull(aVar2);
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkParameterIsNotNull(str2, "value");
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkParameterIsNotNull(str2, "value");
        aVar2.a(MultipartBody.Part.b(str, null, RequestBody.INSTANCE.a(str2, null)));
        this.f = aVar2;
        return this;
    }

    public a c(String str, String str2, String str3, File file) {
        MediaType.Companion aVar = MediaType.INSTANCE;
        RequestBody requestBodyCreate = RequestBody.create(MediaType.Companion.b(str3), file);
        if (this.f == null) {
            MultipartBody.a aVar2 = new MultipartBody.a();
            aVar2.c(MultipartBody.f3809b);
            this.f = aVar2;
        }
        MultipartBody.a aVar3 = this.f;
        Objects.requireNonNull(aVar3);
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkParameterIsNotNull(requestBodyCreate, "body");
        aVar3.a(MultipartBody.Part.b(str, str2, requestBodyCreate));
        this.f = aVar3;
        return this;
    }
}

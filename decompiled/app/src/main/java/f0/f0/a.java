package f0.f0;

import androidx.recyclerview.widget.RecyclerView;
import b.i.a.f.e.o.f;
import com.discord.analytics.utils.RegistrationSteps;
import d0.g0.t;
import d0.t.n0;
import d0.z.d.m;
import f0.e0.g.j;
import f0.e0.h.g;
import f0.k;
import g0.e;
import g0.l;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: HttpLoggingInterceptor.kt */
/* loaded from: classes3.dex */
public final class a implements Interceptor {

    /* renamed from: b, reason: collision with root package name */
    public volatile Set<String> f3669b;
    public volatile EnumC0611a c;
    public final b d;

    /* compiled from: HttpLoggingInterceptor.kt */
    /* renamed from: f0.f0.a$a, reason: collision with other inner class name */
    public enum EnumC0611a {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* compiled from: HttpLoggingInterceptor.kt */
    public interface b {
        void log(String str);
    }

    public a(b bVar) {
        m.checkParameterIsNotNull(bVar, "logger");
        this.d = bVar;
        this.f3669b = n0.emptySet();
        this.c = EnumC0611a.NONE;
    }

    public final boolean a(Headers headers) {
        String strC = headers.c("Content-Encoding");
        return (strC == null || t.equals(strC, RegistrationSteps.IDENTITY, true) || t.equals(strC, "gzip", true)) ? false : true;
    }

    public final void b(Headers headers, int i) {
        int i2 = i * 2;
        String str = this.f3669b.contains(headers.namesAndValues[i2]) ? "██" : headers.namesAndValues[i2 + 1];
        this.d.log(headers.namesAndValues[i2] + ": " + str);
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        String string;
        String str;
        String string2;
        Charset charsetA;
        Charset charsetA2;
        m.checkParameterIsNotNull(chain, "chain");
        EnumC0611a enumC0611a = this.c;
        g gVar = (g) chain;
        Request request = gVar.f;
        if (enumC0611a == EnumC0611a.NONE) {
            return gVar.a(request);
        }
        boolean z2 = enumC0611a == EnumC0611a.BODY;
        boolean z3 = z2 || enumC0611a == EnumC0611a.HEADERS;
        RequestBody requestBody = request.body;
        k kVarB = gVar.b();
        StringBuilder sbU = b.d.b.a.a.U("--> ");
        sbU.append(request.method);
        sbU.append(' ');
        sbU.append(request.url);
        if (kVarB != null) {
            StringBuilder sbU2 = b.d.b.a.a.U(" ");
            sbU2.append(((j) kVarB).m());
            string = sbU2.toString();
        } else {
            string = "";
        }
        sbU.append(string);
        String string3 = sbU.toString();
        if (!z3 && requestBody != null) {
            StringBuilder sbX = b.d.b.a.a.X(string3, " (");
            sbX.append(requestBody.contentLength());
            sbX.append("-byte body)");
            string3 = sbX.toString();
        }
        this.d.log(string3);
        if (z3) {
            Headers headers = request.headers;
            if (requestBody != null) {
                MediaType mediaTypeContentType = requestBody.contentType();
                if (mediaTypeContentType != null && headers.c("Content-Type") == null) {
                    this.d.log("Content-Type: " + mediaTypeContentType);
                }
                if (requestBody.contentLength() != -1 && headers.c("Content-Length") == null) {
                    b bVar = this.d;
                    StringBuilder sbU3 = b.d.b.a.a.U("Content-Length: ");
                    sbU3.append(requestBody.contentLength());
                    bVar.log(sbU3.toString());
                }
            }
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                b(headers, i);
            }
            if (!z2 || requestBody == null) {
                b bVar2 = this.d;
                StringBuilder sbU4 = b.d.b.a.a.U("--> END ");
                sbU4.append(request.method);
                bVar2.log(sbU4.toString());
            } else if (a(request.headers)) {
                b bVar3 = this.d;
                StringBuilder sbU5 = b.d.b.a.a.U("--> END ");
                sbU5.append(request.method);
                sbU5.append(" (encoded body omitted)");
                bVar3.log(sbU5.toString());
            } else if (requestBody.isDuplex()) {
                b bVar4 = this.d;
                StringBuilder sbU6 = b.d.b.a.a.U("--> END ");
                sbU6.append(request.method);
                sbU6.append(" (duplex request body omitted)");
                bVar4.log(sbU6.toString());
            } else if (requestBody.isOneShot()) {
                b bVar5 = this.d;
                StringBuilder sbU7 = b.d.b.a.a.U("--> END ");
                sbU7.append(request.method);
                sbU7.append(" (one-shot body omitted)");
                bVar5.log(sbU7.toString());
            } else {
                e eVar = new e();
                requestBody.writeTo(eVar);
                MediaType mediaTypeContentType2 = requestBody.contentType();
                if (mediaTypeContentType2 == null || (charsetA2 = mediaTypeContentType2.a(StandardCharsets.UTF_8)) == null) {
                    charsetA2 = StandardCharsets.UTF_8;
                    m.checkExpressionValueIsNotNull(charsetA2, "UTF_8");
                }
                this.d.log("");
                if (f.F0(eVar)) {
                    this.d.log(eVar.M(charsetA2));
                    b bVar6 = this.d;
                    StringBuilder sbU8 = b.d.b.a.a.U("--> END ");
                    sbU8.append(request.method);
                    sbU8.append(" (");
                    sbU8.append(requestBody.contentLength());
                    sbU8.append("-byte body)");
                    bVar6.log(sbU8.toString());
                } else {
                    b bVar7 = this.d;
                    StringBuilder sbU9 = b.d.b.a.a.U("--> END ");
                    sbU9.append(request.method);
                    sbU9.append(" (binary ");
                    sbU9.append(requestBody.contentLength());
                    sbU9.append("-byte body omitted)");
                    bVar7.log(sbU9.toString());
                }
            }
        }
        long jNanoTime = System.nanoTime();
        try {
            Response responseA = gVar.a(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            ResponseBody responseBody = responseA.body;
            if (responseBody == null) {
                m.throwNpe();
            }
            long jA = responseBody.a();
            String str2 = jA != -1 ? jA + "-byte" : "unknown-length";
            b bVar8 = this.d;
            StringBuilder sbU10 = b.d.b.a.a.U("<-- ");
            sbU10.append(responseA.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String);
            if (responseA.message.length() == 0) {
                str = "-byte body omitted)";
                string2 = "";
            } else {
                String str3 = responseA.message;
                StringBuilder sb = new StringBuilder();
                str = "-byte body omitted)";
                sb.append(String.valueOf(' '));
                sb.append(str3);
                string2 = sb.toString();
            }
            sbU10.append(string2);
            sbU10.append(' ');
            sbU10.append(responseA.request.url);
            sbU10.append(" (");
            sbU10.append(millis);
            sbU10.append("ms");
            sbU10.append(!z3 ? b.d.b.a.a.y(", ", str2, " body") : "");
            sbU10.append(')');
            bVar8.log(sbU10.toString());
            if (z3) {
                Headers headers2 = responseA.headers;
                int size2 = headers2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    b(headers2, i2);
                }
                if (!z2 || !f0.e0.h.e.a(responseA)) {
                    this.d.log("<-- END HTTP");
                } else if (a(responseA.headers)) {
                    this.d.log("<-- END HTTP (encoded body omitted)");
                } else {
                    g0.g gVarC = responseBody.c();
                    gVarC.j(RecyclerView.FOREVER_NS);
                    e eVarG = gVarC.g();
                    Long l = null;
                    if (t.equals("gzip", headers2.c("Content-Encoding"), true)) {
                        Long lValueOf = Long.valueOf(eVarG.k);
                        l lVar = new l(eVarG.b());
                        try {
                            eVarG = new e();
                            eVarG.P(lVar);
                            d0.y.b.closeFinally(lVar, null);
                            l = lValueOf;
                        } finally {
                        }
                    }
                    MediaType mediaTypeB = responseBody.b();
                    if (mediaTypeB == null || (charsetA = mediaTypeB.a(StandardCharsets.UTF_8)) == null) {
                        charsetA = StandardCharsets.UTF_8;
                        m.checkExpressionValueIsNotNull(charsetA, "UTF_8");
                    }
                    if (!f.F0(eVarG)) {
                        this.d.log("");
                        b bVar9 = this.d;
                        StringBuilder sbU11 = b.d.b.a.a.U("<-- END HTTP (binary ");
                        sbU11.append(eVarG.k);
                        sbU11.append(str);
                        bVar9.log(sbU11.toString());
                        return responseA;
                    }
                    if (jA != 0) {
                        this.d.log("");
                        this.d.log(eVarG.b().M(charsetA));
                    }
                    if (l != null) {
                        b bVar10 = this.d;
                        StringBuilder sbU12 = b.d.b.a.a.U("<-- END HTTP (");
                        sbU12.append(eVarG.k);
                        sbU12.append("-byte, ");
                        sbU12.append(l);
                        sbU12.append("-gzipped-byte body)");
                        bVar10.log(sbU12.toString());
                    } else {
                        b bVar11 = this.d;
                        StringBuilder sbU13 = b.d.b.a.a.U("<-- END HTTP (");
                        sbU13.append(eVarG.k);
                        sbU13.append("-byte body)");
                        bVar11.log(sbU13.toString());
                    }
                }
            }
            return responseA;
        } catch (Exception e) {
            this.d.log("<-- HTTP FAILED: " + e);
            throw e;
        }
    }
}

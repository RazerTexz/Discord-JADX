package okhttp3;

import androidx.browser.trusted.sharing.ShareTarget;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.g0.t;
import d0.t.h0;
import d0.t.n;
import d0.z.d.m;
import f0.d;
import f0.e0.c;
import f0.e0.h.f;
import f0.w;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import okhttp3.Headers;

/* compiled from: Request.kt */
/* loaded from: classes3.dex */
public final class Request {

    /* renamed from: a, reason: from kotlin metadata */
    public d lazyCacheControl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final w url;

    /* renamed from: c, reason: from kotlin metadata */
    public final String method;

    /* renamed from: d, reason: from kotlin metadata */
    public final Headers headers;

    /* renamed from: e, reason: from kotlin metadata */
    public final RequestBody body;

    /* renamed from: f, reason: from kotlin metadata */
    public final Map<Class<?>, Object> tags;

    public Request(w wVar, String str, Headers headers, RequestBody requestBody, Map<Class<?>, ? extends Object> map) {
        m.checkParameterIsNotNull(wVar, "url");
        m.checkParameterIsNotNull(str, "method");
        m.checkParameterIsNotNull(headers, "headers");
        m.checkParameterIsNotNull(map, ModelAuditLogEntry.CHANGE_KEY_TAGS);
        this.url = wVar;
        this.method = str;
        this.headers = headers;
        this.body = requestBody;
        this.tags = map;
    }

    public final d a() {
        d dVar = this.lazyCacheControl;
        if (dVar != null) {
            return dVar;
        }
        d dVarB = d.a.b(this.headers);
        this.lazyCacheControl = dVarB;
        return dVarB;
    }

    public final String b(String name) {
        m.checkParameterIsNotNull(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.headers.c(name);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Request{method=");
        sbU.append(this.method);
        sbU.append(", url=");
        sbU.append(this.url);
        if (this.headers.size() != 0) {
            sbU.append(", headers=[");
            int i = 0;
            for (Pair<? extends String, ? extends String> pair : this.headers) {
                int i2 = i + 1;
                if (i < 0) {
                    n.throwIndexOverflow();
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String strComponent1 = pair2.component1();
                String strComponent2 = pair2.component2();
                if (i > 0) {
                    sbU.append(", ");
                }
                sbU.append(strComponent1);
                sbU.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
                sbU.append(strComponent2);
                i = i2;
            }
            sbU.append(']');
        }
        if (!this.tags.isEmpty()) {
            sbU.append(", tags=");
            sbU.append(this.tags);
        }
        sbU.append('}');
        String string = sbU.toString();
        m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* compiled from: Request.kt */
    public static class a {
        public w a;

        /* renamed from: b, reason: collision with root package name */
        public String f3813b;
        public Headers.a c;
        public RequestBody d;
        public Map<Class<?>, Object> e;

        public a() {
            this.e = new LinkedHashMap();
            this.f3813b = ShareTarget.METHOD_GET;
            this.c = new Headers.a();
        }

        public Request a() {
            w wVar = this.a;
            if (wVar != null) {
                return new Request(wVar, this.f3813b, this.c.c(), this.d, c.A(this.e));
            }
            throw new IllegalStateException("url == null".toString());
        }

        public a b(String str, String str2) {
            m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            m.checkParameterIsNotNull(str2, "value");
            Headers.a aVar = this.c;
            Objects.requireNonNull(aVar);
            m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            m.checkParameterIsNotNull(str2, "value");
            Headers.Companion bVar = Headers.INSTANCE;
            bVar.a(str);
            bVar.b(str2, str);
            aVar.d(str);
            aVar.b(str, str2);
            return this;
        }

        public a c(String str, RequestBody requestBody) {
            m.checkParameterIsNotNull(str, "method");
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("method.isEmpty() == true".toString());
            }
            if (requestBody == null) {
                m.checkParameterIsNotNull(str, "method");
                if (!(!(m.areEqual(str, ShareTarget.METHOD_POST) || m.areEqual(str, "PUT") || m.areEqual(str, "PATCH") || m.areEqual(str, "PROPPATCH") || m.areEqual(str, "REPORT")))) {
                    throw new IllegalArgumentException(b.d.b.a.a.y("method ", str, " must have a request body.").toString());
                }
            } else if (!f.a(str)) {
                throw new IllegalArgumentException(b.d.b.a.a.y("method ", str, " must not have a request body.").toString());
            }
            this.f3813b = str;
            this.d = requestBody;
            return this;
        }

        public a d(String str) {
            m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.c.d(str);
            return this;
        }

        public <T> a e(Class<? super T> cls, T t) {
            m.checkParameterIsNotNull(cls, "type");
            if (t == null) {
                this.e.remove(cls);
            } else {
                if (this.e.isEmpty()) {
                    this.e = new LinkedHashMap();
                }
                Map<Class<?>, Object> map = this.e;
                T tCast = cls.cast(t);
                if (tCast == null) {
                    m.throwNpe();
                }
                map.put(cls, tCast);
            }
            return this;
        }

        public a f(String str) {
            m.checkParameterIsNotNull(str, "url");
            if (t.startsWith(str, "ws:", true)) {
                StringBuilder sbU = b.d.b.a.a.U("http:");
                String strSubstring = str.substring(3);
                m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
                sbU.append(strSubstring);
                str = sbU.toString();
            } else if (t.startsWith(str, "wss:", true)) {
                StringBuilder sbU2 = b.d.b.a.a.U("https:");
                String strSubstring2 = str.substring(4);
                m.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                sbU2.append(strSubstring2);
                str = sbU2.toString();
            }
            m.checkParameterIsNotNull(str, "$this$toHttpUrl");
            w.a aVar = new w.a();
            aVar.e(null, str);
            g(aVar.b());
            return this;
        }

        public a g(w wVar) {
            m.checkParameterIsNotNull(wVar, "url");
            this.a = wVar;
            return this;
        }

        public a(Request request) {
            Map<Class<?>, Object> mutableMap;
            m.checkParameterIsNotNull(request, "request");
            this.e = new LinkedHashMap();
            this.a = request.url;
            this.f3813b = request.method;
            this.d = request.body;
            if (request.tags.isEmpty()) {
                mutableMap = new LinkedHashMap<>();
            } else {
                mutableMap = h0.toMutableMap(request.tags);
            }
            this.e = mutableMap;
            this.c = request.headers.e();
        }
    }
}

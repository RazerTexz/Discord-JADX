package okhttp3;

import androidx.browser.trusted.sharing.ShareTarget;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Tuples2;
import okhttp3.Headers;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Collections2;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.CacheControl;
import p600f0.HttpUrl;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p606h.HttpMethod;

/* compiled from: Request.kt */
/* loaded from: classes3.dex */
public final class Request {

    /* renamed from: a, reason: from kotlin metadata */
    public CacheControl lazyCacheControl;

    /* renamed from: b, reason: from kotlin metadata */
    public final HttpUrl url;

    /* renamed from: c, reason: from kotlin metadata */
    public final String method;

    /* renamed from: d, reason: from kotlin metadata */
    public final Headers headers;

    /* renamed from: e, reason: from kotlin metadata */
    public final RequestBody body;

    /* renamed from: f, reason: from kotlin metadata */
    public final Map<Class<?>, Object> tags;

    public Request(HttpUrl httpUrl, String str, Headers headers, RequestBody requestBody, Map<Class<?>, ? extends Object> map) {
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        Intrinsics3.checkParameterIsNotNull(str, "method");
        Intrinsics3.checkParameterIsNotNull(headers, "headers");
        Intrinsics3.checkParameterIsNotNull(map, ModelAuditLogEntry.CHANGE_KEY_TAGS);
        this.url = httpUrl;
        this.method = str;
        this.headers = headers;
        this.body = requestBody;
        this.tags = map;
    }

    /* renamed from: a */
    public final CacheControl m10976a() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControlM10108b = CacheControl.f25373a.m10108b(this.headers);
        this.lazyCacheControl = cacheControlM10108b;
        return cacheControlM10108b;
    }

    /* renamed from: b */
    public final String m10977b(String name) {
        Intrinsics3.checkParameterIsNotNull(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.headers.m10954c(name);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Request{method=");
        sbM833U.append(this.method);
        sbM833U.append(", url=");
        sbM833U.append(this.url);
        if (this.headers.size() != 0) {
            sbM833U.append(", headers=[");
            int i = 0;
            for (Tuples2<? extends String, ? extends String> tuples2 : this.headers) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                Tuples2<? extends String, ? extends String> tuples22 = tuples2;
                String strComponent1 = tuples22.component1();
                String strComponent2 = tuples22.component2();
                if (i > 0) {
                    sbM833U.append(", ");
                }
                sbM833U.append(strComponent1);
                sbM833U.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
                sbM833U.append(strComponent2);
                i = i2;
            }
            sbM833U.append(']');
        }
        if (!this.tags.isEmpty()) {
            sbM833U.append(", tags=");
            sbM833U.append(this.tags);
        }
        sbM833U.append('}');
        String string = sbM833U.toString();
        Intrinsics3.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* compiled from: Request.kt */
    /* renamed from: okhttp3.Request$a */
    public static class C12935a {

        /* renamed from: a */
        public HttpUrl f27543a;

        /* renamed from: b */
        public String f27544b;

        /* renamed from: c */
        public Headers.C12930a f27545c;

        /* renamed from: d */
        public RequestBody f27546d;

        /* renamed from: e */
        public Map<Class<?>, Object> f27547e;

        public C12935a() {
            this.f27547e = new LinkedHashMap();
            this.f27544b = ShareTarget.METHOD_GET;
            this.f27545c = new Headers.C12930a();
        }

        /* renamed from: a */
        public Request m10978a() {
            HttpUrl httpUrl = this.f27543a;
            if (httpUrl != null) {
                return new Request(httpUrl, this.f27544b, this.f27545c.m10960c(), this.f27546d, Util7.m10116A(this.f27547e));
            }
            throw new IllegalStateException("url == null".toString());
        }

        /* renamed from: b */
        public C12935a m10979b(String str, String str2) {
            Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(str2, "value");
            Headers.C12930a c12930a = this.f27545c;
            Objects.requireNonNull(c12930a);
            Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(str2, "value");
            Headers.Companion c12931b = Headers.INSTANCE;
            c12931b.m10962a(str);
            c12931b.m10963b(str2, str);
            c12930a.m10961d(str);
            c12930a.m10959b(str, str2);
            return this;
        }

        /* renamed from: c */
        public C12935a m10980c(String str, RequestBody requestBody) {
            Intrinsics3.checkParameterIsNotNull(str, "method");
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("method.isEmpty() == true".toString());
            }
            if (requestBody == null) {
                Intrinsics3.checkParameterIsNotNull(str, "method");
                if (!(!(Intrinsics3.areEqual(str, ShareTarget.METHOD_POST) || Intrinsics3.areEqual(str, "PUT") || Intrinsics3.areEqual(str, "PATCH") || Intrinsics3.areEqual(str, "PROPPATCH") || Intrinsics3.areEqual(str, "REPORT")))) {
                    throw new IllegalArgumentException(outline.m886y("method ", str, " must have a request body.").toString());
                }
            } else if (!HttpMethod.m10226a(str)) {
                throw new IllegalArgumentException(outline.m886y("method ", str, " must not have a request body.").toString());
            }
            this.f27544b = str;
            this.f27546d = requestBody;
            return this;
        }

        /* renamed from: d */
        public C12935a m10981d(String str) {
            Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.f27545c.m10961d(str);
            return this;
        }

        /* renamed from: e */
        public <T> C12935a m10982e(Class<? super T> cls, T t) {
            Intrinsics3.checkParameterIsNotNull(cls, "type");
            if (t == null) {
                this.f27547e.remove(cls);
            } else {
                if (this.f27547e.isEmpty()) {
                    this.f27547e = new LinkedHashMap();
                }
                Map<Class<?>, Object> map = this.f27547e;
                T tCast = cls.cast(t);
                if (tCast == null) {
                    Intrinsics3.throwNpe();
                }
                map.put(cls, tCast);
            }
            return this;
        }

        /* renamed from: f */
        public C12935a m10983f(String str) {
            Intrinsics3.checkParameterIsNotNull(str, "url");
            if (StringsJVM.startsWith(str, "ws:", true)) {
                StringBuilder sbM833U = outline.m833U("http:");
                String strSubstring = str.substring(3);
                Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
                sbM833U.append(strSubstring);
                str = sbM833U.toString();
            } else if (StringsJVM.startsWith(str, "wss:", true)) {
                StringBuilder sbM833U2 = outline.m833U("https:");
                String strSubstring2 = str.substring(4);
                Intrinsics3.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                sbM833U2.append(strSubstring2);
                str = sbM833U2.toString();
            }
            Intrinsics3.checkParameterIsNotNull(str, "$this$toHttpUrl");
            HttpUrl.a aVar = new HttpUrl.a();
            aVar.m10412e(null, str);
            m10984g(aVar.m10409b());
            return this;
        }

        /* renamed from: g */
        public C12935a m10984g(HttpUrl httpUrl) {
            Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
            this.f27543a = httpUrl;
            return this;
        }

        public C12935a(Request request) {
            Map<Class<?>, Object> mutableMap;
            Intrinsics3.checkParameterIsNotNull(request, "request");
            this.f27547e = new LinkedHashMap();
            this.f27543a = request.url;
            this.f27544b = request.method;
            this.f27546d = request.body;
            if (request.tags.isEmpty()) {
                mutableMap = new LinkedHashMap<>();
            } else {
                mutableMap = Maps6.toMutableMap(request.tags);
            }
            this.f27547e = mutableMap;
            this.f27545c = request.headers.m10956e();
        }
    }
}

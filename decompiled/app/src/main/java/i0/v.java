package i0;

import com.discord.models.domain.ModelAuditLogEntry;
import f0.u;
import f0.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* compiled from: RequestBuilder.java */
/* loaded from: classes3.dex */
public final class v {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f3759b = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
    public final String c;
    public final f0.w d;
    public String e;
    public w.a f;
    public final Request.a g = new Request.a();
    public final Headers.a h;
    public MediaType i;
    public final boolean j;
    public MultipartBody.a k;
    public u.a l;
    public RequestBody m;

    /* compiled from: RequestBuilder.java */
    public static class a extends RequestBody {
        public final RequestBody a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaType f3760b;

        public a(RequestBody requestBody, MediaType mediaType) {
            this.a = requestBody;
            this.f3760b = mediaType;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.a.contentLength();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.f3760b;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            this.a.writeTo(bufferedSink);
        }
    }

    public v(String str, f0.w wVar, String str2, Headers headers, MediaType mediaType, boolean z2, boolean z3, boolean z4) {
        this.c = str;
        this.d = wVar;
        this.e = str2;
        this.i = mediaType;
        this.j = z2;
        if (headers != null) {
            this.h = headers.e();
        } else {
            this.h = new Headers.a();
        }
        if (z3) {
            this.l = new u.a();
        } else if (z4) {
            MultipartBody.a aVar = new MultipartBody.a();
            this.k = aVar;
            aVar.c(MultipartBody.f3809b);
        }
    }

    public void a(String str, String str2, boolean z2) {
        if (z2) {
            u.a aVar = this.l;
            Objects.requireNonNull(aVar);
            d0.z.d.m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            d0.z.d.m.checkParameterIsNotNull(str2, "value");
            List<String> list = aVar.a;
            w.b bVar = f0.w.f3681b;
            list.add(w.b.a(bVar, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, aVar.c, 83));
            aVar.f3679b.add(w.b.a(bVar, str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, aVar.c, 83));
            return;
        }
        u.a aVar2 = this.l;
        Objects.requireNonNull(aVar2);
        d0.z.d.m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkParameterIsNotNull(str2, "value");
        List<String> list2 = aVar2.a;
        w.b bVar2 = f0.w.f3681b;
        list2.add(w.b.a(bVar2, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, aVar2.c, 91));
        aVar2.f3679b.add(w.b.a(bVar2, str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, aVar2.c, 91));
    }

    public void b(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.h.a(str, str2);
            return;
        }
        try {
            MediaType.Companion companion = MediaType.INSTANCE;
            this.i = MediaType.Companion.a(str2);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(b.d.b.a.a.w("Malformed content type: ", str2), e);
        }
    }

    public void c(Headers headers, RequestBody requestBody) {
        MultipartBody.a aVar = this.k;
        Objects.requireNonNull(aVar);
        d0.z.d.m.checkParameterIsNotNull(requestBody, "body");
        d0.z.d.m.checkParameterIsNotNull(requestBody, "body");
        if (!((headers != null ? headers.c("Content-Type") : null) == null)) {
            throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
        }
        if (!((headers != null ? headers.c("Content-Length") : null) == null)) {
            throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
        }
        aVar.a(new MultipartBody.Part(headers, requestBody, null));
    }

    public void d(String str, String str2, boolean z2) {
        String str3 = this.e;
        if (str3 != null) {
            w.a aVarG = this.d.g(str3);
            this.f = aVarG;
            if (aVarG == null) {
                StringBuilder sbU = b.d.b.a.a.U("Malformed URL. Base: ");
                sbU.append(this.d);
                sbU.append(", Relative: ");
                sbU.append(this.e);
                throw new IllegalArgumentException(sbU.toString());
            }
            this.e = null;
        }
        if (z2) {
            this.f.a(str, str2);
            return;
        }
        w.a aVar = this.f;
        Objects.requireNonNull(aVar);
        d0.z.d.m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (aVar.h == null) {
            aVar.h = new ArrayList();
        }
        List<String> list = aVar.h;
        if (list == null) {
            d0.z.d.m.throwNpe();
        }
        w.b bVar = f0.w.f3681b;
        list.add(w.b.a(bVar, str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219));
        List<String> list2 = aVar.h;
        if (list2 == null) {
            d0.z.d.m.throwNpe();
        }
        list2.add(str2 != null ? w.b.a(bVar, str2, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219) : null);
    }
}

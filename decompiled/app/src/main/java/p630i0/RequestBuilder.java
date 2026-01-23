package p630i0;

import com.discord.models.domain.ModelAuditLogEntry;
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
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.FormBody;
import p600f0.HttpUrl;

/* JADX INFO: renamed from: i0.v, reason: use source file name */
/* JADX INFO: compiled from: RequestBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class RequestBuilder {

    /* JADX INFO: renamed from: a */
    public static final char[] f26618a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: b */
    public static final Pattern f26619b = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* JADX INFO: renamed from: c */
    public final String f26620c;

    /* JADX INFO: renamed from: d */
    public final HttpUrl f26621d;

    /* JADX INFO: renamed from: e */
    public String f26622e;

    /* JADX INFO: renamed from: f */
    public HttpUrl.a f26623f;

    /* JADX INFO: renamed from: g */
    public final Request.C12935a f26624g = new Request.C12935a();

    /* JADX INFO: renamed from: h */
    public final Headers.C12930a f26625h;

    /* JADX INFO: renamed from: i */
    public MediaType f26626i;

    /* JADX INFO: renamed from: j */
    public final boolean f26627j;

    /* JADX INFO: renamed from: k */
    public MultipartBody.C12933a f26628k;

    /* JADX INFO: renamed from: l */
    public FormBody.a f26629l;

    /* JADX INFO: renamed from: m */
    public RequestBody f26630m;

    /* JADX INFO: renamed from: i0.v$a */
    /* JADX INFO: compiled from: RequestBuilder.java */
    public static class a extends RequestBody {

        /* JADX INFO: renamed from: a */
        public final RequestBody f26631a;

        /* JADX INFO: renamed from: b */
        public final MediaType f26632b;

        public a(RequestBody requestBody, MediaType mediaType) {
            this.f26631a = requestBody;
            this.f26632b = mediaType;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.f26631a.contentLength();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.f26632b;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            this.f26631a.writeTo(bufferedSink);
        }
    }

    public RequestBuilder(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z2, boolean z3, boolean z4) {
        this.f26620c = str;
        this.f26621d = httpUrl;
        this.f26622e = str2;
        this.f26626i = mediaType;
        this.f26627j = z2;
        if (headers != null) {
            this.f26625h = headers.m10956e();
        } else {
            this.f26625h = new Headers.C12930a();
        }
        if (z3) {
            this.f26629l = new FormBody.a();
        } else if (z4) {
            MultipartBody.C12933a c12933a = new MultipartBody.C12933a();
            this.f26628k = c12933a;
            c12933a.m10974c(MultipartBody.f27522b);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10718a(String str, String str2, boolean z2) {
        if (z2) {
            FormBody.a aVar = this.f26629l;
            Objects.requireNonNull(aVar);
            Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(str2, "value");
            List<String> list = aVar.f25966a;
            HttpUrl.b bVar = HttpUrl.f25974b;
            list.add(HttpUrl.b.m10413a(bVar, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, aVar.f25968c, 83));
            aVar.f25967b.add(HttpUrl.b.m10413a(bVar, str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, aVar.f25968c, 83));
            return;
        }
        FormBody.a aVar2 = this.f26629l;
        Objects.requireNonNull(aVar2);
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull(str2, "value");
        List<String> list2 = aVar2.f25966a;
        HttpUrl.b bVar2 = HttpUrl.f25974b;
        list2.add(HttpUrl.b.m10413a(bVar2, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, aVar2.f25968c, 91));
        aVar2.f25967b.add(HttpUrl.b.m10413a(bVar2, str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, aVar2.f25968c, 91));
    }

    /* JADX INFO: renamed from: b */
    public void m10719b(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.f26625h.m10958a(str, str2);
            return;
        }
        try {
            MediaType.Companion companion = MediaType.INSTANCE;
            this.f26626i = MediaType.Companion.m10967a(str2);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(outline.m883w("Malformed content type: ", str2), e);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m10720c(Headers headers, RequestBody requestBody) {
        MultipartBody.C12933a c12933a = this.f26628k;
        Objects.requireNonNull(c12933a);
        Intrinsics3.checkParameterIsNotNull(requestBody, "body");
        Intrinsics3.checkParameterIsNotNull(requestBody, "body");
        if (!((headers != null ? headers.m10954c("Content-Type") : null) == null)) {
            throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
        }
        if (!((headers != null ? headers.m10954c("Content-Length") : null) == null)) {
            throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
        }
        c12933a.m10972a(new MultipartBody.Part(headers, requestBody, null));
    }

    /* JADX INFO: renamed from: d */
    public void m10721d(String str, String str2, boolean z2) {
        String str3 = this.f26622e;
        if (str3 != null) {
            HttpUrl.a aVarM10405g = this.f26621d.m10405g(str3);
            this.f26623f = aVarM10405g;
            if (aVarM10405g == null) {
                StringBuilder sbM833U = outline.m833U("Malformed URL. Base: ");
                sbM833U.append(this.f26621d);
                sbM833U.append(", Relative: ");
                sbM833U.append(this.f26622e);
                throw new IllegalArgumentException(sbM833U.toString());
            }
            this.f26622e = null;
        }
        if (z2) {
            this.f26623f.m10408a(str, str2);
            return;
        }
        HttpUrl.a aVar = this.f26623f;
        Objects.requireNonNull(aVar);
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (aVar.f25992h == null) {
            aVar.f25992h = new ArrayList();
        }
        List<String> list = aVar.f25992h;
        if (list == null) {
            Intrinsics3.throwNpe();
        }
        HttpUrl.b bVar = HttpUrl.f25974b;
        list.add(HttpUrl.b.m10413a(bVar, str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219));
        List<String> list2 = aVar.f25992h;
        if (list2 == null) {
            Intrinsics3.throwNpe();
        }
        list2.add(str2 != null ? HttpUrl.b.m10413a(bVar, str2, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219) : null);
    }
}

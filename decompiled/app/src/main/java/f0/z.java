package f0;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* compiled from: RequestBody.kt */
/* loaded from: classes3.dex */
public final class z extends RequestBody {
    public final /* synthetic */ File a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaType f3692b;

    public z(File file, MediaType mediaType) {
        this.a = file;
        this.f3692b = mediaType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.a.length();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.f3692b;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(bufferedSink, "sink");
        File file = this.a;
        d0.z.d.m.checkParameterIsNotNull(file, "$this$source");
        FileInputStream fileInputStream = new FileInputStream(file);
        d0.z.d.m.checkParameterIsNotNull(fileInputStream, "$this$source");
        g0.n nVar = new g0.n(fileInputStream, new g0.y());
        try {
            bufferedSink.P(nVar);
            d0.y.b.closeFinally(nVar, null);
        } finally {
        }
    }
}

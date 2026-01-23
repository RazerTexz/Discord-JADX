package p600f0;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import p507d0.p591y.Closeable;
import p507d0.p592z.p594d.Intrinsics3;
import p615g0.JvmOkio;
import p615g0.Timeout2;

/* JADX INFO: renamed from: f0.z, reason: use source file name */
/* JADX INFO: compiled from: RequestBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RequestBody3 extends RequestBody {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ File f26063a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ MediaType f26064b;

    public RequestBody3(File file, MediaType mediaType) {
        this.f26063a = file;
        this.f26064b = mediaType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.f26063a.length();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.f26064b;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Intrinsics3.checkParameterIsNotNull(bufferedSink, "sink");
        File file = this.f26063a;
        Intrinsics3.checkParameterIsNotNull(file, "$this$source");
        FileInputStream fileInputStream = new FileInputStream(file);
        Intrinsics3.checkParameterIsNotNull(fileInputStream, "$this$source");
        JvmOkio jvmOkio = new JvmOkio(fileInputStream, new Timeout2());
        try {
            bufferedSink.mo10440P(jvmOkio);
            Closeable.closeFinally(jvmOkio, null);
        } finally {
        }
    }
}

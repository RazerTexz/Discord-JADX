package p600f0;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.ByteString;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: RequestBody.kt */
/* renamed from: f0.a0, reason: use source file name */
/* loaded from: classes3.dex */
public final class RequestBody2 extends RequestBody {

    /* renamed from: a */
    public final /* synthetic */ ByteString f25364a;

    /* renamed from: b */
    public final /* synthetic */ MediaType f25365b;

    public RequestBody2(ByteString byteString, MediaType mediaType) {
        this.f25364a = byteString;
        this.f25365b = mediaType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.f25364a.mo10502j();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.f25365b;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Intrinsics3.checkParameterIsNotNull(bufferedSink, "sink");
        bufferedSink.mo10455e0(this.f25364a);
    }
}

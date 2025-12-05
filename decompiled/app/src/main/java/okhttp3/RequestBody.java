package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.MediaType;
import okio.BufferedSink;
import okio.ByteString;
import p507d0.p579g0.Charsets2;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.RequestBody2;
import p600f0.RequestBody3;
import p600f0.p601e0.Util7;

/* compiled from: RequestBody.kt */
/* loaded from: classes3.dex */
public abstract class RequestBody {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: RequestBody.kt */
    public static final class Companion {

        /* compiled from: RequestBody.kt */
        /* renamed from: okhttp3.RequestBody$Companion$a */
        public static final class C12936a extends RequestBody {

            /* renamed from: a */
            public final /* synthetic */ byte[] f27548a;

            /* renamed from: b */
            public final /* synthetic */ MediaType f27549b;

            /* renamed from: c */
            public final /* synthetic */ int f27550c;

            /* renamed from: d */
            public final /* synthetic */ int f27551d;

            public C12936a(byte[] bArr, MediaType mediaType, int i, int i2) {
                this.f27548a = bArr;
                this.f27549b = mediaType;
                this.f27550c = i;
                this.f27551d = i2;
            }

            @Override // okhttp3.RequestBody
            public long contentLength() {
                return this.f27550c;
            }

            @Override // okhttp3.RequestBody
            public MediaType contentType() {
                return this.f27549b;
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                Intrinsics3.checkParameterIsNotNull(bufferedSink, "sink");
                bufferedSink.write(this.f27548a, this.f27551d, this.f27550c);
            }
        }

        public Companion() {
        }

        /* renamed from: c */
        public static RequestBody m10985c(Companion companion, MediaType mediaType, byte[] bArr, int i, int i2, int i3) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = bArr.length;
            }
            Objects.requireNonNull(companion);
            Intrinsics3.checkParameterIsNotNull(bArr, "content");
            return companion.m10988b(bArr, mediaType, i, i2);
        }

        /* renamed from: d */
        public static /* synthetic */ RequestBody m10986d(Companion companion, byte[] bArr, MediaType mediaType, int i, int i2, int i3) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return companion.m10988b(bArr, mediaType, i, i2);
        }

        /* renamed from: a */
        public final RequestBody m10987a(String str, MediaType mediaType) {
            Intrinsics3.checkParameterIsNotNull(str, "$this$toRequestBody");
            Charset charset = Charsets2.f25136a;
            if (mediaType != null) {
                Pattern pattern = MediaType.f27514a;
                Charset charsetM10966a = mediaType.m10966a(null);
                if (charsetM10966a == null) {
                    MediaType.Companion c12932a = MediaType.INSTANCE;
                    mediaType = MediaType.Companion.m10968b(mediaType + "; charset=utf-8");
                } else {
                    charset = charsetM10966a;
                }
            }
            byte[] bytes = str.getBytes(charset);
            Intrinsics3.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            return m10988b(bytes, mediaType, 0, bytes.length);
        }

        /* renamed from: b */
        public final RequestBody m10988b(byte[] bArr, MediaType mediaType, int i, int i2) {
            Intrinsics3.checkParameterIsNotNull(bArr, "$this$toRequestBody");
            Util7.m10122c(bArr.length, i, i2);
            return new C12936a(bArr, mediaType, i2, i);
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public static final RequestBody create(File file, MediaType mediaType) {
        Objects.requireNonNull(INSTANCE);
        Intrinsics3.checkParameterIsNotNull(file, "$this$asRequestBody");
        return new RequestBody3(file, mediaType);
    }

    public static final RequestBody create(String str, MediaType mediaType) {
        return INSTANCE.m10987a(str, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr) {
        return Companion.m10985c(INSTANCE, mediaType, bArr, 0, 0, 12);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i) {
        return Companion.m10985c(INSTANCE, mediaType, bArr, i, 0, 8);
    }

    public static final RequestBody create(byte[] bArr) {
        return Companion.m10986d(INSTANCE, bArr, null, 0, 0, 7);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType) {
        return Companion.m10986d(INSTANCE, bArr, mediaType, 0, 0, 6);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i) {
        return Companion.m10986d(INSTANCE, bArr, mediaType, i, 0, 4);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i, int i2) {
        return INSTANCE.m10988b(bArr, mediaType, i, i2);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(BufferedSink sink) throws IOException;

    public static final RequestBody create(MediaType mediaType, File file) {
        Objects.requireNonNull(INSTANCE);
        Intrinsics3.checkParameterIsNotNull(file, "file");
        Intrinsics3.checkParameterIsNotNull(file, "$this$asRequestBody");
        return new RequestBody3(file, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, String str) {
        Companion companion = INSTANCE;
        Objects.requireNonNull(companion);
        Intrinsics3.checkParameterIsNotNull(str, "content");
        return companion.m10987a(str, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, ByteString byteString) {
        Objects.requireNonNull(INSTANCE);
        Intrinsics3.checkParameterIsNotNull(byteString, "content");
        Intrinsics3.checkParameterIsNotNull(byteString, "$this$toRequestBody");
        return new RequestBody2(byteString, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i, int i2) {
        Companion companion = INSTANCE;
        Objects.requireNonNull(companion);
        Intrinsics3.checkParameterIsNotNull(bArr, "content");
        return companion.m10988b(bArr, mediaType, i, i2);
    }

    public static final RequestBody create(ByteString byteString, MediaType mediaType) {
        Objects.requireNonNull(INSTANCE);
        Intrinsics3.checkParameterIsNotNull(byteString, "$this$toRequestBody");
        return new RequestBody2(byteString, mediaType);
    }
}

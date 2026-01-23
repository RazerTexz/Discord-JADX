package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import p507d0.p579g0.Charsets2;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.p601e0.Util7;
import p615g0.BufferedSource;

/* JADX INFO: compiled from: ResponseBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ResponseBody implements Closeable {

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public Reader reader;

    /* JADX INFO: renamed from: okhttp3.ResponseBody$a */
    /* JADX INFO: compiled from: ResponseBody.kt */
    public static final class C12938a extends Reader {

        /* JADX INFO: renamed from: j */
        public boolean f27580j;

        /* JADX INFO: renamed from: k */
        public Reader f27581k;

        /* JADX INFO: renamed from: l */
        public final BufferedSource f27582l;

        /* JADX INFO: renamed from: m */
        public final Charset f27583m;

        public C12938a(BufferedSource bufferedSource, Charset charset) {
            Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
            Intrinsics3.checkParameterIsNotNull(charset, "charset");
            this.f27582l = bufferedSource;
            this.f27583m = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f27580j = true;
            Reader reader = this.f27581k;
            if (reader != null) {
                reader.close();
            } else {
                this.f27582l.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            Intrinsics3.checkParameterIsNotNull(cArr, "cbuf");
            if (this.f27580j) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.f27581k;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.f27582l.mo10470u0(), Util7.m10138s(this.f27582l, this.f27583m));
                this.f27581k = inputStreamReader;
            }
            return inputStreamReader.read(cArr, i, i2);
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract long mo10103a();

    /* JADX INFO: renamed from: b */
    public abstract MediaType mo10104b();

    /* JADX INFO: renamed from: c */
    public abstract BufferedSource mo10105c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util7.m10123d(mo10105c());
    }

    /* JADX INFO: renamed from: d */
    public final String m10998d() throws IOException {
        Charset charsetM10966a;
        BufferedSource bufferedSourceMo10105c = mo10105c();
        try {
            MediaType mediaTypeMo10104b = mo10104b();
            if (mediaTypeMo10104b == null || (charsetM10966a = mediaTypeMo10104b.m10966a(Charsets2.f25136a)) == null) {
                charsetM10966a = Charsets2.f25136a;
            }
            String strMo10437M = bufferedSourceMo10105c.mo10437M(Util7.m10138s(bufferedSourceMo10105c, charsetM10966a));
            p507d0.p591y.Closeable.closeFinally(bufferedSourceMo10105c, null);
            return strMo10437M;
        } finally {
        }
    }
}

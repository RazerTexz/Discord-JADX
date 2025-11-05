package okhttp3;

import d0.y.b;
import d0.z.d.m;
import f0.e0.c;
import g0.g;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* compiled from: ResponseBody.kt */
/* loaded from: classes3.dex */
public abstract class ResponseBody implements Closeable {

    /* renamed from: k, reason: from kotlin metadata */
    public Reader reader;

    /* compiled from: ResponseBody.kt */
    public static final class a extends Reader {
        public boolean j;
        public Reader k;
        public final g l;
        public final Charset m;

        public a(g gVar, Charset charset) {
            m.checkParameterIsNotNull(gVar, "source");
            m.checkParameterIsNotNull(charset, "charset");
            this.l = gVar;
            this.m = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.j = true;
            Reader reader = this.k;
            if (reader != null) {
                reader.close();
            } else {
                this.l.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            m.checkParameterIsNotNull(cArr, "cbuf");
            if (this.j) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.k;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.l.u0(), c.s(this.l, this.m));
                this.k = inputStreamReader;
            }
            return inputStreamReader.read(cArr, i, i2);
        }
    }

    public abstract long a();

    public abstract MediaType b();

    public abstract g c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c.d(c());
    }

    public final String d() throws IOException {
        Charset charsetA;
        g gVarC = c();
        try {
            MediaType mediaTypeB = b();
            if (mediaTypeB == null || (charsetA = mediaTypeB.a(d0.g0.c.a)) == null) {
                charsetA = d0.g0.c.a;
            }
            String strM = gVarC.M(c.s(gVarC, charsetA));
            b.closeFinally(gVarC, null);
            return strM;
        } finally {
        }
    }
}

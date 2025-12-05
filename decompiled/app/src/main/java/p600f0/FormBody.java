package p600f0;

import androidx.browser.trusted.sharing.ShareTarget;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.p601e0.Util7;
import p615g0.Buffer3;

/* compiled from: FormBody.kt */
/* renamed from: f0.u, reason: use source file name */
/* loaded from: classes3.dex */
public final class FormBody extends RequestBody {

    /* renamed from: a */
    public static final MediaType f25963a;

    /* renamed from: b */
    public final List<String> f25964b;

    /* renamed from: c */
    public final List<String> f25965c;

    /* compiled from: FormBody.kt */
    /* renamed from: f0.u$a */
    public static final class a {

        /* renamed from: c */
        public final Charset f25968c = null;

        /* renamed from: a */
        public final List<String> f25966a = new ArrayList();

        /* renamed from: b */
        public final List<String> f25967b = new ArrayList();
    }

    static {
        MediaType.Companion companion = MediaType.INSTANCE;
        f25963a = MediaType.Companion.m10967a(ShareTarget.ENCODING_TYPE_URL_ENCODED);
    }

    public FormBody(List<String> list, List<String> list2) {
        Intrinsics3.checkParameterIsNotNull(list, "encodedNames");
        Intrinsics3.checkParameterIsNotNull(list2, "encodedValues");
        this.f25964b = Util7.m10145z(list);
        this.f25965c = Util7.m10145z(list2);
    }

    /* renamed from: a */
    public final long m10394a(BufferedSink bufferedSink, boolean z2) throws EOFException {
        Buffer3 buffer3Mo10457g;
        if (z2) {
            buffer3Mo10457g = new Buffer3();
        } else {
            if (bufferedSink == null) {
                Intrinsics3.throwNpe();
            }
            buffer3Mo10457g = bufferedSink.mo10457g();
        }
        int size = this.f25964b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer3Mo10457g.m10444T(38);
            }
            buffer3Mo10457g.m10452b0(this.f25964b.get(i));
            buffer3Mo10457g.m10444T(61);
            buffer3Mo10457g.m10452b0(this.f25965c.get(i));
        }
        if (!z2) {
            return 0L;
        }
        long j = buffer3Mo10457g.f26080k;
        buffer3Mo10457g.skip(j);
        return j;
    }

    @Override // okhttp3.RequestBody
    /* renamed from: contentLength */
    public long getSize() {
        return m10394a(null, true);
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return f25963a;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Intrinsics3.checkParameterIsNotNull(bufferedSink, "sink");
        m10394a(bufferedSink, false);
    }
}

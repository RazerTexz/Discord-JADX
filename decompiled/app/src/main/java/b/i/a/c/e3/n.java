package b.i.a.c.e3;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.browser.trusted.sharing.ShareTarget;
import b.i.a.c.i1;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DataSpec.java */
/* loaded from: classes3.dex */
public final class n {
    public final Uri a;

    /* renamed from: b, reason: collision with root package name */
    public final long f942b;
    public final int c;

    @Nullable
    public final byte[] d;
    public final Map<String, String> e;
    public final long f;
    public final long g;

    @Nullable
    public final String h;
    public final int i;

    @Nullable
    public final Object j;

    /* compiled from: DataSpec.java */
    public static final class b {

        @Nullable
        public Uri a;

        /* renamed from: b, reason: collision with root package name */
        public long f943b;
        public int c;

        @Nullable
        public byte[] d;
        public Map<String, String> e;
        public long f;
        public long g;

        @Nullable
        public String h;
        public int i;

        @Nullable
        public Object j;

        public b(n nVar, a aVar) {
            this.a = nVar.a;
            this.f943b = nVar.f942b;
            this.c = nVar.c;
            this.d = nVar.d;
            this.e = nVar.e;
            this.f = nVar.f;
            this.g = nVar.g;
            this.h = nVar.h;
            this.i = nVar.i;
            this.j = nVar.j;
        }

        public n a() {
            if (this.a != null) {
                return new n(this.a, this.f943b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
            }
            throw new IllegalStateException("The uri must be set.");
        }
    }

    static {
        i1.a("goog.exo.datasource");
    }

    public n(Uri uri, long j, int i, @Nullable byte[] bArr, Map<String, String> map, long j2, long j3, @Nullable String str, int i2, @Nullable Object obj) {
        byte[] bArr2 = bArr;
        boolean z2 = true;
        b.c.a.a0.d.j(j + j2 >= 0);
        b.c.a.a0.d.j(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z2 = false;
        }
        b.c.a.a0.d.j(z2);
        this.a = uri;
        this.f942b = j;
        this.c = i;
        this.d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.e = Collections.unmodifiableMap(new HashMap(map));
        this.f = j2;
        this.g = j3;
        this.h = str;
        this.i = i2;
        this.j = obj;
    }

    public static String b(int i) {
        if (i == 1) {
            return ShareTarget.METHOD_GET;
        }
        if (i == 2) {
            return ShareTarget.METHOD_POST;
        }
        if (i == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public b a() {
        return new b(this, null);
    }

    public boolean c(int i) {
        return (this.i & i) == i;
    }

    public String toString() {
        String strB = b(this.c);
        String strValueOf = String.valueOf(this.a);
        long j = this.f;
        long j2 = this.g;
        String str = this.h;
        int i = this.i;
        StringBuilder sbS = b.d.b.a.a.S(b.d.b.a.a.b(str, strValueOf.length() + strB.length() + 70), "DataSpec[", strB, " ", strValueOf);
        sbS.append(", ");
        sbS.append(j);
        sbS.append(", ");
        sbS.append(j2);
        sbS.append(", ");
        sbS.append(str);
        sbS.append(", ");
        sbS.append(i);
        sbS.append("]");
        return sbS.toString();
    }
}

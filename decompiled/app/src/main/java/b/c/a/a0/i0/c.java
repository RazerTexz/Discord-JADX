package b.c.a.a0.i0;

import g0.e;
import g0.o;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.ByteString;

/* compiled from: JsonReader.java */
/* loaded from: classes.dex */
public abstract class c implements Closeable {
    public static final String[] j = new String[128];
    public int k;
    public int[] l = new int[32];
    public String[] m = new String[32];
    public int[] n = new int[32];

    /* compiled from: JsonReader.java */
    public static final class a {
        public final String[] a;

        /* renamed from: b, reason: collision with root package name */
        public final o f333b;

        public a(String[] strArr, o oVar) {
            this.a = strArr;
            this.f333b = oVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x003a A[Catch: IOException -> 0x006b, TryCatch #0 {IOException -> 0x006b, blocks: (B:2:0x0000, B:3:0x000a, B:5:0x000d, B:7:0x001e, B:9:0x0026, B:21:0x0042, B:19:0x003a, B:20:0x003d, B:23:0x0047, B:24:0x004a, B:25:0x0059), top: B:30:0x0000 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static a a(String... strArr) {
            String str;
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                e eVar = new e();
                for (int i = 0; i < strArr.length; i++) {
                    String str2 = strArr[i];
                    String[] strArr2 = c.j;
                    eVar.T(34);
                    int length = str2.length();
                    int i2 = 0;
                    for (int i3 = 0; i3 < length; i3++) {
                        char cCharAt = str2.charAt(i3);
                        if (cCharAt < 128) {
                            str = strArr2[cCharAt];
                            if (str != null) {
                                if (i2 < i3) {
                                    eVar.c0(str2, i2, i3);
                                }
                                eVar.b0(str);
                                i2 = i3 + 1;
                            }
                        } else {
                            if (cCharAt == 8232) {
                                str = "\\u2028";
                            } else if (cCharAt == 8233) {
                                str = "\\u2029";
                            }
                            if (i2 < i3) {
                            }
                            eVar.b0(str);
                            i2 = i3 + 1;
                        }
                    }
                    if (i2 < length) {
                        eVar.c0(str2, i2, length);
                    }
                    eVar.T(34);
                    eVar.readByte();
                    byteStringArr[i] = eVar.x();
                }
                return new a((String[]) strArr.clone(), o.k.c(byteStringArr));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: JsonReader.java */
    public enum b {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i = 0; i <= 31; i++) {
            j[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = j;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public abstract void A() throws IOException;

    public abstract void C() throws IOException;

    public final b.c.a.a0.i0.b D(String str) throws b.c.a.a0.i0.b {
        StringBuilder sbX = b.d.b.a.a.X(str, " at path ");
        sbX.append(getPath());
        throw new b.c.a.a0.i0.b(sbX.toString());
    }

    public abstract void a() throws IOException;

    public abstract void b() throws IOException;

    public abstract void c() throws IOException;

    public abstract void d() throws IOException;

    public abstract boolean e() throws IOException;

    public abstract boolean f() throws IOException;

    public final String getPath() {
        int i = this.k;
        int[] iArr = this.l;
        String[] strArr = this.m;
        int[] iArr2 = this.n;
        StringBuilder sbQ = b.d.b.a.a.Q('$');
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 == 1 || i3 == 2) {
                sbQ.append('[');
                sbQ.append(iArr2[i2]);
                sbQ.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sbQ.append('.');
                if (strArr[i2] != null) {
                    sbQ.append(strArr[i2]);
                }
            }
        }
        return sbQ.toString();
    }

    public abstract double n() throws IOException;

    public abstract int q() throws IOException;

    public abstract String s() throws IOException;

    public abstract String t() throws IOException;

    public abstract b u() throws IOException;

    public final void x(int i) {
        int i2 = this.k;
        int[] iArr = this.l;
        if (i2 == iArr.length) {
            if (i2 == 256) {
                StringBuilder sbU = b.d.b.a.a.U("Nesting too deep at ");
                sbU.append(getPath());
                throw new b.c.a.a0.i0.a(sbU.toString());
            }
            this.l = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.m;
            this.m = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.n;
            this.n = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.l;
        int i3 = this.k;
        this.k = i3 + 1;
        iArr3[i3] = i;
    }

    public abstract int y(a aVar) throws IOException;
}

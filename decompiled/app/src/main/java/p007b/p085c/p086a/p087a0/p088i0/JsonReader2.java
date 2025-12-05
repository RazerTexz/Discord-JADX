package p007b.p085c.p086a.p087a0.p088i0;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.ByteString;
import p007b.p100d.p104b.p105a.outline;
import p615g0.Buffer3;
import p615g0.Options2;

/* compiled from: JsonReader.java */
/* renamed from: b.c.a.a0.i0.c, reason: use source file name */
/* loaded from: classes.dex */
public abstract class JsonReader2 implements Closeable {

    /* renamed from: j */
    public static final String[] f2236j = new String[128];

    /* renamed from: k */
    public int f2237k;

    /* renamed from: l */
    public int[] f2238l = new int[32];

    /* renamed from: m */
    public String[] f2239m = new String[32];

    /* renamed from: n */
    public int[] f2240n = new int[32];

    /* compiled from: JsonReader.java */
    /* renamed from: b.c.a.a0.i0.c$a */
    public static final class a {

        /* renamed from: a */
        public final String[] f2241a;

        /* renamed from: b */
        public final Options2 f2242b;

        public a(String[] strArr, Options2 options2) {
            this.f2241a = strArr;
            this.f2242b = options2;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x003a A[Catch: IOException -> 0x006b, TryCatch #0 {IOException -> 0x006b, blocks: (B:2:0x0000, B:3:0x000a, B:5:0x000d, B:7:0x001e, B:9:0x0026, B:21:0x0042, B:19:0x003a, B:20:0x003d, B:23:0x0047, B:24:0x004a, B:25:0x0059), top: B:30:0x0000 }] */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static a m616a(String... strArr) {
            String str;
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer3 buffer3 = new Buffer3();
                for (int i = 0; i < strArr.length; i++) {
                    String str2 = strArr[i];
                    String[] strArr2 = JsonReader2.f2236j;
                    buffer3.m10444T(34);
                    int length = str2.length();
                    int i2 = 0;
                    for (int i3 = 0; i3 < length; i3++) {
                        char cCharAt = str2.charAt(i3);
                        if (cCharAt < 128) {
                            str = strArr2[cCharAt];
                            if (str != null) {
                                if (i2 < i3) {
                                    buffer3.m10453c0(str2, i2, i3);
                                }
                                buffer3.m10452b0(str);
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
                            buffer3.m10452b0(str);
                            i2 = i3 + 1;
                        }
                    }
                    if (i2 < length) {
                        buffer3.m10453c0(str2, i2, length);
                    }
                    buffer3.m10444T(34);
                    buffer3.readByte();
                    byteStringArr[i] = buffer3.m10473x();
                }
                return new a((String[]) strArr.clone(), Options2.f26106k.m10491c(byteStringArr));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: JsonReader.java */
    /* renamed from: b.c.a.a0.i0.c$b */
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
            f2236j[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f2236j;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    /* renamed from: A */
    public abstract void mo600A() throws IOException;

    /* renamed from: C */
    public abstract void mo601C() throws IOException;

    /* renamed from: D */
    public final JsonEncodingException m602D(String str) throws JsonEncodingException {
        StringBuilder sbM836X = outline.m836X(str, " at path ");
        sbM836X.append(getPath());
        throw new JsonEncodingException(sbM836X.toString());
    }

    /* renamed from: a */
    public abstract void mo603a() throws IOException;

    /* renamed from: b */
    public abstract void mo604b() throws IOException;

    /* renamed from: c */
    public abstract void mo605c() throws IOException;

    /* renamed from: d */
    public abstract void mo606d() throws IOException;

    /* renamed from: e */
    public abstract boolean mo607e() throws IOException;

    /* renamed from: f */
    public abstract boolean mo608f() throws IOException;

    public final String getPath() {
        int i = this.f2237k;
        int[] iArr = this.f2238l;
        String[] strArr = this.f2239m;
        int[] iArr2 = this.f2240n;
        StringBuilder sbM829Q = outline.m829Q('$');
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 == 1 || i3 == 2) {
                sbM829Q.append('[');
                sbM829Q.append(iArr2[i2]);
                sbM829Q.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sbM829Q.append('.');
                if (strArr[i2] != null) {
                    sbM829Q.append(strArr[i2]);
                }
            }
        }
        return sbM829Q.toString();
    }

    /* renamed from: n */
    public abstract double mo609n() throws IOException;

    /* renamed from: q */
    public abstract int mo610q() throws IOException;

    /* renamed from: s */
    public abstract String mo611s() throws IOException;

    /* renamed from: t */
    public abstract String mo612t() throws IOException;

    /* renamed from: u */
    public abstract b mo613u() throws IOException;

    /* renamed from: x */
    public final void m614x(int i) {
        int i2 = this.f2237k;
        int[] iArr = this.f2238l;
        if (i2 == iArr.length) {
            if (i2 == 256) {
                StringBuilder sbM833U = outline.m833U("Nesting too deep at ");
                sbM833U.append(getPath());
                throw new JsonDataException(sbM833U.toString());
            }
            this.f2238l = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f2239m;
            this.f2239m = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f2240n;
            this.f2240n = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f2238l;
        int i3 = this.f2237k;
        this.f2237k = i3 + 1;
        iArr3[i3] = i;
    }

    /* renamed from: y */
    public abstract int mo615y(a aVar) throws IOException;
}

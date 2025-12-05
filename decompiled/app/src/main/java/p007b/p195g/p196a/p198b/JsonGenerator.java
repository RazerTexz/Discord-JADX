package p007b.p195g.p196a.p198b;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import p007b.p195g.p196a.p198b.p204t.JacksonFeatureSet;

/* compiled from: JsonGenerator.java */
/* renamed from: b.g.a.b.d, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class JsonGenerator implements Closeable, Flushable {

    /* renamed from: j */
    public static final JacksonFeatureSet<StreamWriteCapability> f4464j;

    /* renamed from: k */
    public static final JacksonFeatureSet<StreamWriteCapability> f4465k;

    /* renamed from: l */
    public PrettyPrinter2 f4466l;

    /* compiled from: JsonGenerator.java */
    /* renamed from: b.g.a.b.d$a */
    public enum a {
        AUTO_CLOSE_TARGET(true),
        AUTO_CLOSE_JSON_CONTENT(true),
        FLUSH_PASSED_TO_STREAM(true),
        QUOTE_FIELD_NAMES(true),
        QUOTE_NON_NUMERIC_NUMBERS(true),
        ESCAPE_NON_ASCII(false),
        WRITE_NUMBERS_AS_STRINGS(false),
        WRITE_BIGDECIMAL_AS_PLAIN(false),
        STRICT_DUPLICATE_DETECTION(false),
        IGNORE_UNKNOWN(false);

        private final boolean _defaultState;
        private final int _mask = 1 << ordinal();

        a(boolean z2) {
            this._defaultState = z2;
        }

        /* renamed from: f */
        public static int m1667f() {
            a[] aVarArrValues = values();
            int i = 0;
            for (int i2 = 0; i2 < 10; i2++) {
                a aVar = aVarArrValues[i2];
                if (aVar._defaultState) {
                    i |= aVar._mask;
                }
            }
            return i;
        }

        /* renamed from: g */
        public boolean m1668g(int i) {
            return (i & this._mask) != 0;
        }

        /* renamed from: h */
        public int m1669h() {
            return this._mask;
        }
    }

    static {
        JacksonFeatureSet<StreamWriteCapability> jacksonFeatureSetM1734a = JacksonFeatureSet.m1734a(StreamWriteCapability.values());
        f4464j = jacksonFeatureSetM1734a;
        f4465k = jacksonFeatureSetM1734a.m1735b(StreamWriteCapability.CAN_WRITE_FORMATTED_NUMBERS);
        jacksonFeatureSetM1734a.m1735b(StreamWriteCapability.CAN_WRITE_BINARY_NATIVELY);
    }

    /* renamed from: A */
    public abstract void mo1631A() throws IOException;

    /* renamed from: C */
    public abstract void mo1632C(double d) throws IOException;

    /* renamed from: D */
    public abstract void mo1633D(float f) throws IOException;

    /* renamed from: H */
    public abstract void mo1634H(int i) throws IOException;

    /* renamed from: I */
    public abstract void mo1635I(long j) throws IOException;

    /* renamed from: J */
    public abstract void mo1636J(String str) throws IOException;

    /* renamed from: L */
    public abstract void mo1637L(BigDecimal bigDecimal) throws IOException;

    /* renamed from: N */
    public abstract void mo1638N(BigInteger bigInteger) throws IOException;

    /* renamed from: O */
    public void mo1639O(short s2) throws IOException {
        mo1634H(s2);
    }

    /* renamed from: R */
    public abstract void mo1640R(char c) throws IOException;

    /* renamed from: S */
    public void mo1641S(SerializableString serializableString) throws IOException {
        mo1642T(serializableString.getValue());
    }

    /* renamed from: T */
    public abstract void mo1642T(String str) throws IOException;

    /* renamed from: U */
    public abstract void mo1643U(char[] cArr, int i, int i2) throws IOException;

    /* renamed from: V */
    public abstract void mo1644V(String str) throws IOException;

    /* renamed from: W */
    public abstract void mo1645W() throws IOException;

    /* renamed from: X */
    public void mo1646X(Object obj) throws IOException {
        mo1645W();
        mo1654e(obj);
    }

    /* renamed from: a */
    public final void m1647a(int i, int i2, int i3) {
        if (i2 < 0 || i2 + i3 > i) {
            throw new IllegalArgumentException(String.format("invalid argument(s) (offset=%d, length=%d) for input array of %d element", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i)));
        }
    }

    /* renamed from: b */
    public abstract JsonGenerator mo1648b(a aVar);

    /* renamed from: b0 */
    public void mo1649b0(Object obj, int i) throws IOException {
        mo1645W();
        mo1654e(obj);
    }

    /* renamed from: c */
    public abstract JsonStreamContext mo1650c();

    /* renamed from: c0 */
    public abstract void mo1651c0() throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close() throws IOException;

    /* renamed from: d */
    public abstract boolean mo1652d(a aVar);

    /* renamed from: d0 */
    public void mo1653d0(Object obj) throws IOException {
        mo1651c0();
        mo1654e(obj);
    }

    /* renamed from: e */
    public void mo1654e(Object obj) {
        JsonStreamContext jsonStreamContextMo1650c = mo1650c();
        if (jsonStreamContextMo1650c != null) {
            jsonStreamContextMo1650c.mo1676d(obj);
        }
    }

    /* renamed from: f */
    public abstract int mo1655f(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException;

    /* renamed from: f0 */
    public void mo1656f0(Object obj, int i) throws IOException {
        mo1651c0();
        mo1654e(obj);
    }

    /* renamed from: g0 */
    public abstract void mo1657g0(SerializableString serializableString) throws IOException;

    /* renamed from: j0 */
    public abstract void mo1658j0(String str) throws IOException;

    /* renamed from: m0 */
    public abstract void mo1659m0(char[] cArr, int i, int i2) throws IOException;

    /* renamed from: n */
    public abstract void mo1660n(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException;

    /* renamed from: q */
    public void m1661q(byte[] bArr) throws IOException {
        mo1660n(Base64Variants.f4452b, bArr, 0, bArr.length);
    }

    /* renamed from: s */
    public abstract void mo1662s(boolean z2) throws IOException;

    /* renamed from: t */
    public abstract void mo1663t() throws IOException;

    /* renamed from: u */
    public abstract void mo1664u() throws IOException;

    /* renamed from: x */
    public abstract void mo1665x(SerializableString serializableString) throws IOException;

    /* renamed from: y */
    public abstract void mo1666y(String str) throws IOException;
}

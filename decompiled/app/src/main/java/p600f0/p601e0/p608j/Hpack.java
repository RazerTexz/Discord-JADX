package p600f0.p601e0.p608j;

import androidx.browser.trusted.sharing.ShareTarget;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okio.ByteString;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t._ArraysJvm;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p608j.Huffman;
import p615g0.Buffer3;
import p615g0.BufferedSource;
import p615g0.RealBufferedSource;
import p615g0.Source2;

/* compiled from: Hpack.kt */
/* renamed from: f0.e0.j.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class Hpack {

    /* renamed from: a */
    public static final Header2[] f25589a;

    /* renamed from: b */
    public static final Map<ByteString, Integer> f25590b;

    /* renamed from: c */
    public static final Hpack f25591c = new Hpack();

    /* compiled from: Hpack.kt */
    /* renamed from: f0.e0.j.c$a */
    public static final class a {

        /* renamed from: a */
        public final List<Header2> f25592a;

        /* renamed from: b */
        public final BufferedSource f25593b;

        /* renamed from: c */
        public Header2[] f25594c;

        /* renamed from: d */
        public int f25595d;

        /* renamed from: e */
        public int f25596e;

        /* renamed from: f */
        public int f25597f;

        /* renamed from: g */
        public final int f25598g;

        /* renamed from: h */
        public int f25599h;

        public a(Source2 source2, int i, int i2, int i3) {
            i2 = (i3 & 4) != 0 ? i : i2;
            Intrinsics3.checkParameterIsNotNull(source2, "source");
            this.f25598g = i;
            this.f25599h = i2;
            this.f25592a = new ArrayList();
            Intrinsics3.checkParameterIsNotNull(source2, "$this$buffer");
            this.f25593b = new RealBufferedSource(source2);
            this.f25594c = new Header2[8];
            this.f25595d = 7;
        }

        /* renamed from: a */
        public final void m10243a() {
            _ArraysJvm.fill$default(this.f25594c, null, 0, 0, 6, null);
            this.f25595d = this.f25594c.length - 1;
            this.f25596e = 0;
            this.f25597f = 0;
        }

        /* renamed from: b */
        public final int m10244b(int i) {
            return this.f25595d + 1 + i;
        }

        /* renamed from: c */
        public final int m10245c(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f25594c.length;
                while (true) {
                    length--;
                    i2 = this.f25595d;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    Header2 header2 = this.f25594c[length];
                    if (header2 == null) {
                        Intrinsics3.throwNpe();
                    }
                    int i4 = header2.f25586g;
                    i -= i4;
                    this.f25597f -= i4;
                    this.f25596e--;
                    i3++;
                }
                Header2[] header2Arr = this.f25594c;
                System.arraycopy(header2Arr, i2 + 1, header2Arr, i2 + 1 + i3, this.f25596e);
                this.f25595d += i3;
            }
            return i3;
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x000d  */
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final ByteString m10246d(int i) throws IOException {
            boolean z2;
            if (i >= 0) {
                Hpack hpack = Hpack.f25591c;
                z2 = i <= Hpack.f25589a.length + (-1);
            }
            if (z2) {
                Hpack hpack2 = Hpack.f25591c;
                return Hpack.f25589a[i].f25587h;
            }
            Hpack hpack3 = Hpack.f25591c;
            int iM10244b = m10244b(i - Hpack.f25589a.length);
            if (iM10244b >= 0) {
                Header2[] header2Arr = this.f25594c;
                if (iM10244b < header2Arr.length) {
                    Header2 header2 = header2Arr[iM10244b];
                    if (header2 == null) {
                        Intrinsics3.throwNpe();
                    }
                    return header2.f25587h;
                }
            }
            StringBuilder sbM833U = outline.m833U("Header index too large ");
            sbM833U.append(i + 1);
            throw new IOException(sbM833U.toString());
        }

        /* renamed from: e */
        public final void m10247e(int i, Header2 header2) {
            this.f25592a.add(header2);
            int i2 = header2.f25586g;
            if (i != -1) {
                Header2 header22 = this.f25594c[this.f25595d + 1 + i];
                if (header22 == null) {
                    Intrinsics3.throwNpe();
                }
                i2 -= header22.f25586g;
            }
            int i3 = this.f25599h;
            if (i2 > i3) {
                m10243a();
                return;
            }
            int iM10245c = m10245c((this.f25597f + i2) - i3);
            if (i == -1) {
                int i4 = this.f25596e + 1;
                Header2[] header2Arr = this.f25594c;
                if (i4 > header2Arr.length) {
                    Header2[] header2Arr2 = new Header2[header2Arr.length * 2];
                    System.arraycopy(header2Arr, 0, header2Arr2, header2Arr.length, header2Arr.length);
                    this.f25595d = this.f25594c.length - 1;
                    this.f25594c = header2Arr2;
                }
                int i5 = this.f25595d;
                this.f25595d = i5 - 1;
                this.f25594c[i5] = header2;
                this.f25596e++;
            } else {
                this.f25594c[this.f25595d + 1 + i + iM10245c + i] = header2;
            }
            this.f25597f += i2;
        }

        /* renamed from: f */
        public final ByteString m10248f() throws IOException {
            byte b2 = this.f25593b.readByte();
            byte[] bArr = Util7.f25397a;
            int i = b2 & 255;
            int i2 = 0;
            boolean z2 = (i & 128) == 128;
            long jM10249g = m10249g(i, Opcodes.LAND);
            if (!z2) {
                return this.f25593b.mo10461o(jM10249g);
            }
            Buffer3 buffer3 = new Buffer3();
            Huffman huffman = Huffman.f25747d;
            BufferedSource bufferedSource = this.f25593b;
            Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
            Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
            Huffman.a aVar = Huffman.f25746c;
            int i3 = 0;
            for (long j = 0; j < jM10249g; j++) {
                byte b3 = bufferedSource.readByte();
                byte[] bArr2 = Util7.f25397a;
                i2 = (i2 << 8) | (b3 & 255);
                i3 += 8;
                while (i3 >= 8) {
                    int i4 = i3 - 8;
                    int i5 = (i2 >>> i4) & 255;
                    Huffman.a[] aVarArr = aVar.f25748a;
                    if (aVarArr == null) {
                        Intrinsics3.throwNpe();
                    }
                    aVar = aVarArr[i5];
                    if (aVar == null) {
                        Intrinsics3.throwNpe();
                    }
                    if (aVar.f25748a == null) {
                        buffer3.m10444T(aVar.f25749b);
                        i3 -= aVar.f25750c;
                        aVar = Huffman.f25746c;
                    } else {
                        i3 = i4;
                    }
                }
            }
            while (i3 > 0) {
                int i6 = (i2 << (8 - i3)) & 255;
                Huffman.a[] aVarArr2 = aVar.f25748a;
                if (aVarArr2 == null) {
                    Intrinsics3.throwNpe();
                }
                Huffman.a aVar2 = aVarArr2[i6];
                if (aVar2 == null) {
                    Intrinsics3.throwNpe();
                }
                if (aVar2.f25748a != null || aVar2.f25750c > i3) {
                    break;
                }
                buffer3.m10444T(aVar2.f25749b);
                i3 -= aVar2.f25750c;
                aVar = Huffman.f25746c;
            }
            return buffer3.m10473x();
        }

        /* renamed from: g */
        public final int m10249g(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                byte b2 = this.f25593b.readByte();
                byte[] bArr = Util7.f25397a;
                int i5 = b2 & 255;
                if ((i5 & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (i5 & Opcodes.LAND) << i4;
                i4 += 7;
            }
        }
    }

    /* compiled from: Hpack.kt */
    /* renamed from: f0.e0.j.c$b */
    public static final class b {

        /* renamed from: a */
        public int f25600a;

        /* renamed from: b */
        public boolean f25601b;

        /* renamed from: c */
        public int f25602c;

        /* renamed from: d */
        public Header2[] f25603d;

        /* renamed from: e */
        public int f25604e;

        /* renamed from: f */
        public int f25605f;

        /* renamed from: g */
        public int f25606g;

        /* renamed from: h */
        public int f25607h;

        /* renamed from: i */
        public final boolean f25608i;

        /* renamed from: j */
        public final Buffer3 f25609j;

        public b(int i, boolean z2, Buffer3 buffer3, int i2) {
            i = (i2 & 1) != 0 ? 4096 : i;
            z2 = (i2 & 2) != 0 ? true : z2;
            Intrinsics3.checkParameterIsNotNull(buffer3, "out");
            this.f25607h = i;
            this.f25608i = z2;
            this.f25609j = buffer3;
            this.f25600a = Integer.MAX_VALUE;
            this.f25602c = i;
            this.f25603d = new Header2[8];
            this.f25604e = 7;
        }

        /* renamed from: a */
        public final void m10250a() {
            _ArraysJvm.fill$default(this.f25603d, null, 0, 0, 6, null);
            this.f25604e = this.f25603d.length - 1;
            this.f25605f = 0;
            this.f25606g = 0;
        }

        /* renamed from: b */
        public final int m10251b(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f25603d.length;
                while (true) {
                    length--;
                    i2 = this.f25604e;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    Header2 header2 = this.f25603d[length];
                    if (header2 == null) {
                        Intrinsics3.throwNpe();
                    }
                    i -= header2.f25586g;
                    int i4 = this.f25606g;
                    Header2 header22 = this.f25603d[length];
                    if (header22 == null) {
                        Intrinsics3.throwNpe();
                    }
                    this.f25606g = i4 - header22.f25586g;
                    this.f25605f--;
                    i3++;
                }
                Header2[] header2Arr = this.f25603d;
                System.arraycopy(header2Arr, i2 + 1, header2Arr, i2 + 1 + i3, this.f25605f);
                Header2[] header2Arr2 = this.f25603d;
                int i5 = this.f25604e;
                Arrays.fill(header2Arr2, i5 + 1, i5 + 1 + i3, (Object) null);
                this.f25604e += i3;
            }
            return i3;
        }

        /* renamed from: c */
        public final void m10252c(Header2 header2) {
            int i = header2.f25586g;
            int i2 = this.f25602c;
            if (i > i2) {
                m10250a();
                return;
            }
            m10251b((this.f25606g + i) - i2);
            int i3 = this.f25605f + 1;
            Header2[] header2Arr = this.f25603d;
            if (i3 > header2Arr.length) {
                Header2[] header2Arr2 = new Header2[header2Arr.length * 2];
                System.arraycopy(header2Arr, 0, header2Arr2, header2Arr.length, header2Arr.length);
                this.f25604e = this.f25603d.length - 1;
                this.f25603d = header2Arr2;
            }
            int i4 = this.f25604e;
            this.f25604e = i4 - 1;
            this.f25603d[i4] = header2;
            this.f25605f++;
            this.f25606g += i;
        }

        /* renamed from: d */
        public final void m10253d(ByteString byteString) throws IOException {
            Intrinsics3.checkParameterIsNotNull(byteString, "data");
            if (this.f25608i) {
                Huffman huffman = Huffman.f25747d;
                Intrinsics3.checkParameterIsNotNull(byteString, "bytes");
                int iMo10502j = byteString.mo10502j();
                long j = 0;
                for (int i = 0; i < iMo10502j; i++) {
                    byte bMo10505m = byteString.mo10505m(i);
                    byte[] bArr = Util7.f25397a;
                    j += Huffman.f25745b[bMo10505m & 255];
                }
                if (((int) ((j + 7) >> 3)) < byteString.mo10502j()) {
                    Buffer3 buffer3 = new Buffer3();
                    Huffman huffman2 = Huffman.f25747d;
                    Intrinsics3.checkParameterIsNotNull(byteString, "source");
                    Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
                    int iMo10502j2 = byteString.mo10502j();
                    long j2 = 0;
                    int i2 = 0;
                    for (int i3 = 0; i3 < iMo10502j2; i3++) {
                        byte bMo10505m2 = byteString.mo10505m(i3);
                        byte[] bArr2 = Util7.f25397a;
                        int i4 = bMo10505m2 & 255;
                        int i5 = Huffman.f25744a[i4];
                        byte b2 = Huffman.f25745b[i4];
                        j2 = (j2 << b2) | i5;
                        i2 += b2;
                        while (i2 >= 8) {
                            i2 -= 8;
                            buffer3.writeByte((int) (j2 >> i2));
                        }
                    }
                    if (i2 > 0) {
                        buffer3.writeByte((int) ((255 >>> i2) | (j2 << (8 - i2))));
                    }
                    ByteString byteStringM10473x = buffer3.m10473x();
                    m10255f(byteStringM10473x.mo10502j(), Opcodes.LAND, 128);
                    this.f25609j.m10439O(byteStringM10473x);
                    return;
                }
            }
            m10255f(byteString.mo10502j(), Opcodes.LAND, 0);
            this.f25609j.m10439O(byteString);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
        /* renamed from: e */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void m10254e(List<Header2> list) throws IOException {
            int length;
            int length2;
            Intrinsics3.checkParameterIsNotNull(list, "headerBlock");
            if (this.f25601b) {
                int i = this.f25600a;
                if (i < this.f25602c) {
                    m10255f(i, 31, 32);
                }
                this.f25601b = false;
                this.f25600a = Integer.MAX_VALUE;
                m10255f(this.f25602c, 31, 32);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Header2 header2 = list.get(i2);
                ByteString byteStringMo10508p = header2.f25587h.mo10508p();
                ByteString byteString = header2.f25588i;
                Hpack hpack = Hpack.f25591c;
                Integer num = Hpack.f25590b.get(byteStringMo10508p);
                if (num != null) {
                    length = num.intValue() + 1;
                    if (2 <= length && 7 >= length) {
                        Header2[] header2Arr = Hpack.f25589a;
                        if (Intrinsics3.areEqual(header2Arr[length - 1].f25588i, byteString)) {
                            length2 = length;
                        } else if (Intrinsics3.areEqual(header2Arr[length].f25588i, byteString)) {
                            length2 = length;
                            length++;
                        } else {
                            length2 = length;
                            length = -1;
                        }
                    }
                } else {
                    length = -1;
                    length2 = -1;
                }
                if (length == -1) {
                    int i3 = this.f25604e + 1;
                    int length3 = this.f25603d.length;
                    while (true) {
                        if (i3 >= length3) {
                            break;
                        }
                        Header2 header22 = this.f25603d[i3];
                        if (header22 == null) {
                            Intrinsics3.throwNpe();
                        }
                        if (Intrinsics3.areEqual(header22.f25587h, byteStringMo10508p)) {
                            Header2 header23 = this.f25603d[i3];
                            if (header23 == null) {
                                Intrinsics3.throwNpe();
                            }
                            if (Intrinsics3.areEqual(header23.f25588i, byteString)) {
                                int i4 = i3 - this.f25604e;
                                Hpack hpack2 = Hpack.f25591c;
                                length = Hpack.f25589a.length + i4;
                                break;
                            } else if (length2 == -1) {
                                int i5 = i3 - this.f25604e;
                                Hpack hpack3 = Hpack.f25591c;
                                length2 = i5 + Hpack.f25589a.length;
                            }
                        }
                        i3++;
                    }
                }
                if (length != -1) {
                    m10255f(length, Opcodes.LAND, 128);
                } else if (length2 == -1) {
                    this.f25609j.m10444T(64);
                    m10253d(byteStringMo10508p);
                    m10253d(byteString);
                    m10252c(header2);
                } else {
                    ByteString byteString2 = Header2.f25580a;
                    Objects.requireNonNull(byteStringMo10508p);
                    Intrinsics3.checkParameterIsNotNull(byteString2, "prefix");
                    if (byteStringMo10508p.mo10506n(0, byteString2, 0, byteString2.mo10502j()) && (!Intrinsics3.areEqual(Header2.f25585f, byteStringMo10508p))) {
                        m10255f(length2, 15, 0);
                        m10253d(byteString);
                    } else {
                        m10255f(length2, 63, 64);
                        m10253d(byteString);
                        m10252c(header2);
                    }
                }
            }
        }

        /* renamed from: f */
        public final void m10255f(int i, int i2, int i3) {
            if (i < i2) {
                this.f25609j.m10444T(i | i3);
                return;
            }
            this.f25609j.m10444T(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f25609j.m10444T(128 | (i4 & Opcodes.LAND));
                i4 >>>= 7;
            }
            this.f25609j.m10444T(i4);
        }
    }

    static {
        Header2 header2 = new Header2(Header2.f25585f, "");
        ByteString byteString = Header2.f25582c;
        ByteString byteString2 = Header2.f25583d;
        ByteString byteString3 = Header2.f25584e;
        ByteString byteString4 = Header2.f25581b;
        Header2[] header2Arr = {header2, new Header2(byteString, ShareTarget.METHOD_GET), new Header2(byteString, ShareTarget.METHOD_POST), new Header2(byteString2, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN), new Header2(byteString2, "/index.html"), new Header2(byteString3, "http"), new Header2(byteString3, Constants.SCHEME), new Header2(byteString4, "200"), new Header2(byteString4, "204"), new Header2(byteString4, "206"), new Header2(byteString4, "304"), new Header2(byteString4, "400"), new Header2(byteString4, "404"), new Header2(byteString4, "500"), new Header2("accept-charset", ""), new Header2("accept-encoding", "gzip, deflate"), new Header2("accept-language", ""), new Header2("accept-ranges", ""), new Header2("accept", ""), new Header2("access-control-allow-origin", ""), new Header2("age", ""), new Header2(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED, ""), new Header2("authorization", ""), new Header2("cache-control", ""), new Header2("content-disposition", ""), new Header2("content-encoding", ""), new Header2("content-language", ""), new Header2("content-length", ""), new Header2("content-location", ""), new Header2("content-range", ""), new Header2("content-type", ""), new Header2("cookie", ""), new Header2("date", ""), new Header2("etag", ""), new Header2("expect", ""), new Header2("expires", ""), new Header2("from", ""), new Header2("host", ""), new Header2("if-match", ""), new Header2("if-modified-since", ""), new Header2("if-none-match", ""), new Header2("if-range", ""), new Header2("if-unmodified-since", ""), new Header2("last-modified", ""), new Header2("link", ""), new Header2(ModelAuditLogEntry.CHANGE_KEY_LOCATION, ""), new Header2("max-forwards", ""), new Header2("proxy-authenticate", ""), new Header2("proxy-authorization", ""), new Header2("range", ""), new Header2("referer", ""), new Header2("refresh", ""), new Header2("retry-after", ""), new Header2("server", ""), new Header2("set-cookie", ""), new Header2("strict-transport-security", ""), new Header2("transfer-encoding", ""), new Header2("user-agent", ""), new Header2("vary", ""), new Header2("via", ""), new Header2("www-authenticate", "")};
        f25589a = header2Arr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(header2Arr.length);
        int length = header2Arr.length;
        for (int i = 0; i < length; i++) {
            Header2[] header2Arr2 = f25589a;
            if (!linkedHashMap.containsKey(header2Arr2[i].f25587h)) {
                linkedHashMap.put(header2Arr2[i].f25587h, Integer.valueOf(i));
            }
        }
        Map<ByteString, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics3.checkExpressionValueIsNotNull(mapUnmodifiableMap, "Collections.unmodifiableMap(result)");
        f25590b = mapUnmodifiableMap;
    }

    /* renamed from: a */
    public final ByteString m10242a(ByteString byteString) throws IOException {
        Intrinsics3.checkParameterIsNotNull(byteString, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int iMo10502j = byteString.mo10502j();
        for (int i = 0; i < iMo10502j; i++) {
            byte b2 = (byte) 65;
            byte b3 = (byte) 90;
            byte bMo10505m = byteString.mo10505m(i);
            if (b2 <= bMo10505m && b3 >= bMo10505m) {
                StringBuilder sbM833U = outline.m833U("PROTOCOL_ERROR response malformed: mixed case name: ");
                sbM833U.append(byteString.m11008q());
                throw new IOException(sbM833U.toString());
            }
        }
        return byteString;
    }
}

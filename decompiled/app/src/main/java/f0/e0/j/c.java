package f0.e0.j;

import androidx.browser.trusted.sharing.ShareTarget;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import f0.e0.j.p;
import g0.x;
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

/* compiled from: Hpack.kt */
/* loaded from: classes3.dex */
public final class c {
    public static final f0.e0.j.b[] a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map<ByteString, Integer> f3634b;
    public static final c c = new c();

    /* compiled from: Hpack.kt */
    public static final class a {
        public final List<f0.e0.j.b> a;

        /* renamed from: b, reason: collision with root package name */
        public final g0.g f3635b;
        public f0.e0.j.b[] c;
        public int d;
        public int e;
        public int f;
        public final int g;
        public int h;

        public a(x xVar, int i, int i2, int i3) {
            i2 = (i3 & 4) != 0 ? i : i2;
            d0.z.d.m.checkParameterIsNotNull(xVar, "source");
            this.g = i;
            this.h = i2;
            this.a = new ArrayList();
            d0.z.d.m.checkParameterIsNotNull(xVar, "$this$buffer");
            this.f3635b = new g0.r(xVar);
            this.c = new f0.e0.j.b[8];
            this.d = 7;
        }

        public final void a() {
            d0.t.j.fill$default(this.c, null, 0, 0, 6, null);
            this.d = this.c.length - 1;
            this.e = 0;
            this.f = 0;
        }

        public final int b(int i) {
            return this.d + 1 + i;
        }

        public final int c(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.c.length;
                while (true) {
                    length--;
                    i2 = this.d;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    f0.e0.j.b bVar = this.c[length];
                    if (bVar == null) {
                        d0.z.d.m.throwNpe();
                    }
                    int i4 = bVar.g;
                    i -= i4;
                    this.f -= i4;
                    this.e--;
                    i3++;
                }
                f0.e0.j.b[] bVarArr = this.c;
                System.arraycopy(bVarArr, i2 + 1, bVarArr, i2 + 1 + i3, this.e);
                this.d += i3;
            }
            return i3;
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x000d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final ByteString d(int i) throws IOException {
            boolean z2;
            if (i >= 0) {
                c cVar = c.c;
                z2 = i <= c.a.length + (-1);
            }
            if (z2) {
                c cVar2 = c.c;
                return c.a[i].h;
            }
            c cVar3 = c.c;
            int iB = b(i - c.a.length);
            if (iB >= 0) {
                f0.e0.j.b[] bVarArr = this.c;
                if (iB < bVarArr.length) {
                    f0.e0.j.b bVar = bVarArr[iB];
                    if (bVar == null) {
                        d0.z.d.m.throwNpe();
                    }
                    return bVar.h;
                }
            }
            StringBuilder sbU = b.d.b.a.a.U("Header index too large ");
            sbU.append(i + 1);
            throw new IOException(sbU.toString());
        }

        public final void e(int i, f0.e0.j.b bVar) {
            this.a.add(bVar);
            int i2 = bVar.g;
            if (i != -1) {
                f0.e0.j.b bVar2 = this.c[this.d + 1 + i];
                if (bVar2 == null) {
                    d0.z.d.m.throwNpe();
                }
                i2 -= bVar2.g;
            }
            int i3 = this.h;
            if (i2 > i3) {
                a();
                return;
            }
            int iC = c((this.f + i2) - i3);
            if (i == -1) {
                int i4 = this.e + 1;
                f0.e0.j.b[] bVarArr = this.c;
                if (i4 > bVarArr.length) {
                    f0.e0.j.b[] bVarArr2 = new f0.e0.j.b[bVarArr.length * 2];
                    System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
                    this.d = this.c.length - 1;
                    this.c = bVarArr2;
                }
                int i5 = this.d;
                this.d = i5 - 1;
                this.c[i5] = bVar;
                this.e++;
            } else {
                this.c[this.d + 1 + i + iC + i] = bVar;
            }
            this.f += i2;
        }

        public final ByteString f() throws IOException {
            byte b2 = this.f3635b.readByte();
            byte[] bArr = f0.e0.c.a;
            int i = b2 & 255;
            int i2 = 0;
            boolean z2 = (i & 128) == 128;
            long jG = g(i, Opcodes.LAND);
            if (!z2) {
                return this.f3635b.o(jG);
            }
            g0.e eVar = new g0.e();
            p pVar = p.d;
            g0.g gVar = this.f3635b;
            d0.z.d.m.checkParameterIsNotNull(gVar, "source");
            d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
            p.a aVar = p.c;
            int i3 = 0;
            for (long j = 0; j < jG; j++) {
                byte b3 = gVar.readByte();
                byte[] bArr2 = f0.e0.c.a;
                i2 = (i2 << 8) | (b3 & 255);
                i3 += 8;
                while (i3 >= 8) {
                    int i4 = i3 - 8;
                    int i5 = (i2 >>> i4) & 255;
                    p.a[] aVarArr = aVar.a;
                    if (aVarArr == null) {
                        d0.z.d.m.throwNpe();
                    }
                    aVar = aVarArr[i5];
                    if (aVar == null) {
                        d0.z.d.m.throwNpe();
                    }
                    if (aVar.a == null) {
                        eVar.T(aVar.f3646b);
                        i3 -= aVar.c;
                        aVar = p.c;
                    } else {
                        i3 = i4;
                    }
                }
            }
            while (i3 > 0) {
                int i6 = (i2 << (8 - i3)) & 255;
                p.a[] aVarArr2 = aVar.a;
                if (aVarArr2 == null) {
                    d0.z.d.m.throwNpe();
                }
                p.a aVar2 = aVarArr2[i6];
                if (aVar2 == null) {
                    d0.z.d.m.throwNpe();
                }
                if (aVar2.a != null || aVar2.c > i3) {
                    break;
                }
                eVar.T(aVar2.f3646b);
                i3 -= aVar2.c;
                aVar = p.c;
            }
            return eVar.x();
        }

        public final int g(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                byte b2 = this.f3635b.readByte();
                byte[] bArr = f0.e0.c.a;
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
    public static final class b {
        public int a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f3636b;
        public int c;
        public f0.e0.j.b[] d;
        public int e;
        public int f;
        public int g;
        public int h;
        public final boolean i;
        public final g0.e j;

        public b(int i, boolean z2, g0.e eVar, int i2) {
            i = (i2 & 1) != 0 ? 4096 : i;
            z2 = (i2 & 2) != 0 ? true : z2;
            d0.z.d.m.checkParameterIsNotNull(eVar, "out");
            this.h = i;
            this.i = z2;
            this.j = eVar;
            this.a = Integer.MAX_VALUE;
            this.c = i;
            this.d = new f0.e0.j.b[8];
            this.e = 7;
        }

        public final void a() {
            d0.t.j.fill$default(this.d, null, 0, 0, 6, null);
            this.e = this.d.length - 1;
            this.f = 0;
            this.g = 0;
        }

        public final int b(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.d.length;
                while (true) {
                    length--;
                    i2 = this.e;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    f0.e0.j.b bVar = this.d[length];
                    if (bVar == null) {
                        d0.z.d.m.throwNpe();
                    }
                    i -= bVar.g;
                    int i4 = this.g;
                    f0.e0.j.b bVar2 = this.d[length];
                    if (bVar2 == null) {
                        d0.z.d.m.throwNpe();
                    }
                    this.g = i4 - bVar2.g;
                    this.f--;
                    i3++;
                }
                f0.e0.j.b[] bVarArr = this.d;
                System.arraycopy(bVarArr, i2 + 1, bVarArr, i2 + 1 + i3, this.f);
                f0.e0.j.b[] bVarArr2 = this.d;
                int i5 = this.e;
                Arrays.fill(bVarArr2, i5 + 1, i5 + 1 + i3, (Object) null);
                this.e += i3;
            }
            return i3;
        }

        public final void c(f0.e0.j.b bVar) {
            int i = bVar.g;
            int i2 = this.c;
            if (i > i2) {
                a();
                return;
            }
            b((this.g + i) - i2);
            int i3 = this.f + 1;
            f0.e0.j.b[] bVarArr = this.d;
            if (i3 > bVarArr.length) {
                f0.e0.j.b[] bVarArr2 = new f0.e0.j.b[bVarArr.length * 2];
                System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
                this.e = this.d.length - 1;
                this.d = bVarArr2;
            }
            int i4 = this.e;
            this.e = i4 - 1;
            this.d[i4] = bVar;
            this.f++;
            this.g += i;
        }

        public final void d(ByteString byteString) throws IOException {
            d0.z.d.m.checkParameterIsNotNull(byteString, "data");
            if (this.i) {
                p pVar = p.d;
                d0.z.d.m.checkParameterIsNotNull(byteString, "bytes");
                int iJ = byteString.j();
                long j = 0;
                for (int i = 0; i < iJ; i++) {
                    byte bM = byteString.m(i);
                    byte[] bArr = f0.e0.c.a;
                    j += p.f3645b[bM & 255];
                }
                if (((int) ((j + 7) >> 3)) < byteString.j()) {
                    g0.e eVar = new g0.e();
                    p pVar2 = p.d;
                    d0.z.d.m.checkParameterIsNotNull(byteString, "source");
                    d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
                    int iJ2 = byteString.j();
                    long j2 = 0;
                    int i2 = 0;
                    for (int i3 = 0; i3 < iJ2; i3++) {
                        byte bM2 = byteString.m(i3);
                        byte[] bArr2 = f0.e0.c.a;
                        int i4 = bM2 & 255;
                        int i5 = p.a[i4];
                        byte b2 = p.f3645b[i4];
                        j2 = (j2 << b2) | i5;
                        i2 += b2;
                        while (i2 >= 8) {
                            i2 -= 8;
                            eVar.writeByte((int) (j2 >> i2));
                        }
                    }
                    if (i2 > 0) {
                        eVar.writeByte((int) ((255 >>> i2) | (j2 << (8 - i2))));
                    }
                    ByteString byteStringX = eVar.x();
                    f(byteStringX.j(), Opcodes.LAND, 128);
                    this.j.O(byteStringX);
                    return;
                }
            }
            f(byteString.j(), Opcodes.LAND, 0);
            this.j.O(byteString);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void e(List<f0.e0.j.b> list) throws IOException {
            int length;
            int length2;
            d0.z.d.m.checkParameterIsNotNull(list, "headerBlock");
            if (this.f3636b) {
                int i = this.a;
                if (i < this.c) {
                    f(i, 31, 32);
                }
                this.f3636b = false;
                this.a = Integer.MAX_VALUE;
                f(this.c, 31, 32);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                f0.e0.j.b bVar = list.get(i2);
                ByteString byteStringP = bVar.h.p();
                ByteString byteString = bVar.i;
                c cVar = c.c;
                Integer num = c.f3634b.get(byteStringP);
                if (num != null) {
                    length = num.intValue() + 1;
                    if (2 <= length && 7 >= length) {
                        f0.e0.j.b[] bVarArr = c.a;
                        if (d0.z.d.m.areEqual(bVarArr[length - 1].i, byteString)) {
                            length2 = length;
                        } else if (d0.z.d.m.areEqual(bVarArr[length].i, byteString)) {
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
                    int i3 = this.e + 1;
                    int length3 = this.d.length;
                    while (true) {
                        if (i3 >= length3) {
                            break;
                        }
                        f0.e0.j.b bVar2 = this.d[i3];
                        if (bVar2 == null) {
                            d0.z.d.m.throwNpe();
                        }
                        if (d0.z.d.m.areEqual(bVar2.h, byteStringP)) {
                            f0.e0.j.b bVar3 = this.d[i3];
                            if (bVar3 == null) {
                                d0.z.d.m.throwNpe();
                            }
                            if (d0.z.d.m.areEqual(bVar3.i, byteString)) {
                                int i4 = i3 - this.e;
                                c cVar2 = c.c;
                                length = c.a.length + i4;
                                break;
                            } else if (length2 == -1) {
                                int i5 = i3 - this.e;
                                c cVar3 = c.c;
                                length2 = i5 + c.a.length;
                            }
                        }
                        i3++;
                    }
                }
                if (length != -1) {
                    f(length, Opcodes.LAND, 128);
                } else if (length2 == -1) {
                    this.j.T(64);
                    d(byteStringP);
                    d(byteString);
                    c(bVar);
                } else {
                    ByteString byteString2 = f0.e0.j.b.a;
                    Objects.requireNonNull(byteStringP);
                    d0.z.d.m.checkParameterIsNotNull(byteString2, "prefix");
                    if (byteStringP.n(0, byteString2, 0, byteString2.j()) && (!d0.z.d.m.areEqual(f0.e0.j.b.f, byteStringP))) {
                        f(length2, 15, 0);
                        d(byteString);
                    } else {
                        f(length2, 63, 64);
                        d(byteString);
                        c(bVar);
                    }
                }
            }
        }

        public final void f(int i, int i2, int i3) {
            if (i < i2) {
                this.j.T(i | i3);
                return;
            }
            this.j.T(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.j.T(128 | (i4 & Opcodes.LAND));
                i4 >>>= 7;
            }
            this.j.T(i4);
        }
    }

    static {
        f0.e0.j.b bVar = new f0.e0.j.b(f0.e0.j.b.f, "");
        ByteString byteString = f0.e0.j.b.c;
        ByteString byteString2 = f0.e0.j.b.d;
        ByteString byteString3 = f0.e0.j.b.e;
        ByteString byteString4 = f0.e0.j.b.f3633b;
        f0.e0.j.b[] bVarArr = {bVar, new f0.e0.j.b(byteString, ShareTarget.METHOD_GET), new f0.e0.j.b(byteString, ShareTarget.METHOD_POST), new f0.e0.j.b(byteString2, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN), new f0.e0.j.b(byteString2, "/index.html"), new f0.e0.j.b(byteString3, "http"), new f0.e0.j.b(byteString3, Constants.SCHEME), new f0.e0.j.b(byteString4, "200"), new f0.e0.j.b(byteString4, "204"), new f0.e0.j.b(byteString4, "206"), new f0.e0.j.b(byteString4, "304"), new f0.e0.j.b(byteString4, "400"), new f0.e0.j.b(byteString4, "404"), new f0.e0.j.b(byteString4, "500"), new f0.e0.j.b("accept-charset", ""), new f0.e0.j.b("accept-encoding", "gzip, deflate"), new f0.e0.j.b("accept-language", ""), new f0.e0.j.b("accept-ranges", ""), new f0.e0.j.b("accept", ""), new f0.e0.j.b("access-control-allow-origin", ""), new f0.e0.j.b("age", ""), new f0.e0.j.b(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED, ""), new f0.e0.j.b("authorization", ""), new f0.e0.j.b("cache-control", ""), new f0.e0.j.b("content-disposition", ""), new f0.e0.j.b("content-encoding", ""), new f0.e0.j.b("content-language", ""), new f0.e0.j.b("content-length", ""), new f0.e0.j.b("content-location", ""), new f0.e0.j.b("content-range", ""), new f0.e0.j.b("content-type", ""), new f0.e0.j.b("cookie", ""), new f0.e0.j.b("date", ""), new f0.e0.j.b("etag", ""), new f0.e0.j.b("expect", ""), new f0.e0.j.b("expires", ""), new f0.e0.j.b("from", ""), new f0.e0.j.b("host", ""), new f0.e0.j.b("if-match", ""), new f0.e0.j.b("if-modified-since", ""), new f0.e0.j.b("if-none-match", ""), new f0.e0.j.b("if-range", ""), new f0.e0.j.b("if-unmodified-since", ""), new f0.e0.j.b("last-modified", ""), new f0.e0.j.b("link", ""), new f0.e0.j.b(ModelAuditLogEntry.CHANGE_KEY_LOCATION, ""), new f0.e0.j.b("max-forwards", ""), new f0.e0.j.b("proxy-authenticate", ""), new f0.e0.j.b("proxy-authorization", ""), new f0.e0.j.b("range", ""), new f0.e0.j.b("referer", ""), new f0.e0.j.b("refresh", ""), new f0.e0.j.b("retry-after", ""), new f0.e0.j.b("server", ""), new f0.e0.j.b("set-cookie", ""), new f0.e0.j.b("strict-transport-security", ""), new f0.e0.j.b("transfer-encoding", ""), new f0.e0.j.b("user-agent", ""), new f0.e0.j.b("vary", ""), new f0.e0.j.b("via", ""), new f0.e0.j.b("www-authenticate", "")};
        a = bVarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(bVarArr.length);
        int length = bVarArr.length;
        for (int i = 0; i < length; i++) {
            f0.e0.j.b[] bVarArr2 = a;
            if (!linkedHashMap.containsKey(bVarArr2[i].h)) {
                linkedHashMap.put(bVarArr2[i].h, Integer.valueOf(i));
            }
        }
        Map<ByteString, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        d0.z.d.m.checkExpressionValueIsNotNull(mapUnmodifiableMap, "Collections.unmodifiableMap(result)");
        f3634b = mapUnmodifiableMap;
    }

    public final ByteString a(ByteString byteString) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(byteString, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int iJ = byteString.j();
        for (int i = 0; i < iJ; i++) {
            byte b2 = (byte) 65;
            byte b3 = (byte) 90;
            byte bM = byteString.m(i);
            if (b2 <= bM && b3 >= bM) {
                StringBuilder sbU = b.d.b.a.a.U("PROTOCOL_ERROR response malformed: mixed case name: ");
                sbU.append(byteString.q());
                throw new IOException(sbU.toString());
            }
        }
        return byteString;
    }
}

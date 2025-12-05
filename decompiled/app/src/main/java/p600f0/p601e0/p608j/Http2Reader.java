package p600f0.p601e0.p608j;

import com.discord.api.permission.Permission;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.ranges.Progressions2;
import okio.ByteString;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p512d0._Ranges;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p608j.Hpack;
import p615g0.Buffer3;
import p615g0.BufferedSource;
import p615g0.Source2;
import p615g0.Timeout2;

/* compiled from: Http2Reader.kt */
/* renamed from: f0.e0.j.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class Http2Reader implements Closeable {

    /* renamed from: j */
    public static final Logger f25700j;

    /* renamed from: k */
    public static final Http2Reader f25701k = null;

    /* renamed from: l */
    public final a f25702l;

    /* renamed from: m */
    public final Hpack.a f25703m;

    /* renamed from: n */
    public final BufferedSource f25704n;

    /* renamed from: o */
    public final boolean f25705o;

    /* compiled from: Http2Reader.kt */
    /* renamed from: f0.e0.j.m$a */
    public static final class a implements Source2 {

        /* renamed from: j */
        public int f25706j;

        /* renamed from: k */
        public int f25707k;

        /* renamed from: l */
        public int f25708l;

        /* renamed from: m */
        public int f25709m;

        /* renamed from: n */
        public int f25710n;

        /* renamed from: o */
        public final BufferedSource f25711o;

        public a(BufferedSource bufferedSource) {
            Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
            this.f25711o = bufferedSource;
        }

        @Override // p615g0.Source2, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // p615g0.Source2
        /* renamed from: i0 */
        public long mo10176i0(Buffer3 buffer3, long j) throws IOException {
            int i;
            int i2;
            Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
            do {
                int i3 = this.f25709m;
                if (i3 != 0) {
                    long jMo10176i0 = this.f25711o.mo10176i0(buffer3, Math.min(j, i3));
                    if (jMo10176i0 == -1) {
                        return -1L;
                    }
                    this.f25709m -= (int) jMo10176i0;
                    return jMo10176i0;
                }
                this.f25711o.skip(this.f25710n);
                this.f25710n = 0;
                if ((this.f25707k & 4) != 0) {
                    return -1L;
                }
                i = this.f25708l;
                int iM10139t = Util7.m10139t(this.f25711o);
                this.f25709m = iM10139t;
                this.f25706j = iM10139t;
                int i4 = this.f25711o.readByte() & 255;
                this.f25707k = this.f25711o.readByte() & 255;
                Http2Reader http2Reader = Http2Reader.f25701k;
                Logger logger = Http2Reader.f25700j;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Http2.f25614e.m10257b(true, this.f25708l, this.f25706j, i4, this.f25707k));
                }
                i2 = this.f25711o.readInt() & Integer.MAX_VALUE;
                this.f25708l = i2;
                if (i4 != 9) {
                    throw new IOException(i4 + " != TYPE_CONTINUATION");
                }
            } while (i2 == i);
            throw new IOException("TYPE_CONTINUATION streamId changed");
        }

        @Override // p615g0.Source2
        public Timeout2 timeout() {
            return this.f25711o.timeout();
        }
    }

    /* compiled from: Http2Reader.kt */
    /* renamed from: f0.e0.j.m$b */
    public interface b {
        /* renamed from: a */
        void mo10268a();

        /* renamed from: b */
        void mo10269b(boolean z2, Settings3 settings3);

        /* renamed from: c */
        void mo10270c(boolean z2, int i, int i2, List<Header2> list);

        /* renamed from: d */
        void mo10271d(int i, long j);

        /* renamed from: e */
        void mo10272e(boolean z2, int i, BufferedSource bufferedSource, int i2) throws IOException;

        /* renamed from: f */
        void mo10273f(boolean z2, int i, int i2);

        /* renamed from: g */
        void mo10274g(int i, int i2, int i3, boolean z2);

        /* renamed from: h */
        void mo10275h(int i, ErrorCode2 errorCode2);

        /* renamed from: i */
        void mo10276i(int i, int i2, List<Header2> list) throws IOException;

        /* renamed from: j */
        void mo10277j(int i, ErrorCode2 errorCode2, ByteString byteString);
    }

    static {
        Logger logger = Logger.getLogger(Http2.class.getName());
        Intrinsics3.checkExpressionValueIsNotNull(logger, "Logger.getLogger(Http2::class.java.name)");
        f25700j = logger;
    }

    public Http2Reader(BufferedSource bufferedSource, boolean z2) {
        Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
        this.f25704n = bufferedSource;
        this.f25705o = z2;
        a aVar = new a(bufferedSource);
        this.f25702l = aVar;
        this.f25703m = new Hpack.a(aVar, 4096, 0, 4);
    }

    /* renamed from: a */
    public final boolean m10278a(boolean z2, b bVar) throws IOException {
        ErrorCode2 errorCode2;
        int i;
        ErrorCode2 errorCode22;
        Intrinsics3.checkParameterIsNotNull(bVar, "handler");
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        try {
            this.f25704n.mo10463p0(9L);
            int iM10139t = Util7.m10139t(this.f25704n);
            if (iM10139t > 16384) {
                throw new IOException(outline.m871q("FRAME_SIZE_ERROR: ", iM10139t));
            }
            int i5 = this.f25704n.readByte() & 255;
            int i6 = this.f25704n.readByte() & 255;
            int i7 = this.f25704n.readInt() & Integer.MAX_VALUE;
            Logger logger = f25700j;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.f25614e.m10257b(true, i7, iM10139t, i5, i6));
            }
            if (z2 && i5 != 4) {
                StringBuilder sbM833U = outline.m833U("Expected a SETTINGS frame but was ");
                sbM833U.append(Http2.f25614e.m10256a(i5));
                throw new IOException(sbM833U.toString());
            }
            switch (i5) {
                case 0:
                    if (i7 == 0) {
                        throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
                    }
                    boolean z3 = (i6 & 1) != 0;
                    if ((i6 & 32) != 0) {
                        throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
                    }
                    int i8 = i6 & 8;
                    if (i8 != 0) {
                        byte b2 = this.f25704n.readByte();
                        byte[] bArr = Util7.f25397a;
                        i2 = b2 & 255;
                    }
                    if (i8 != 0) {
                        iM10139t--;
                    }
                    if (i2 > iM10139t) {
                        throw new IOException(outline.m875s("PROTOCOL_ERROR padding ", i2, " > remaining length ", iM10139t));
                    }
                    bVar.mo10272e(z3, i7, this.f25704n, iM10139t - i2);
                    this.f25704n.skip(i2);
                    return true;
                case 1:
                    if (i7 == 0) {
                        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
                    }
                    boolean z4 = (i6 & 1) != 0;
                    int i9 = i6 & 8;
                    if (i9 != 0) {
                        byte b3 = this.f25704n.readByte();
                        byte[] bArr2 = Util7.f25397a;
                        i4 = b3 & 255;
                    }
                    if ((i6 & 32) != 0) {
                        m10281d(bVar, i7);
                        iM10139t -= 5;
                    }
                    if (i9 != 0) {
                        iM10139t--;
                    }
                    if (i4 > iM10139t) {
                        throw new IOException(outline.m875s("PROTOCOL_ERROR padding ", i4, " > remaining length ", iM10139t));
                    }
                    bVar.mo10270c(z4, i7, -1, m10280c(iM10139t - i4, i4, i6, i7));
                    return true;
                case 2:
                    if (iM10139t != 5) {
                        throw new IOException(outline.m873r("TYPE_PRIORITY length: ", iM10139t, " != 5"));
                    }
                    if (i7 == 0) {
                        throw new IOException("TYPE_PRIORITY streamId == 0");
                    }
                    m10281d(bVar, i7);
                    return true;
                case 3:
                    if (iM10139t != 4) {
                        throw new IOException(outline.m873r("TYPE_RST_STREAM length: ", iM10139t, " != 4"));
                    }
                    if (i7 == 0) {
                        throw new IOException("TYPE_RST_STREAM streamId == 0");
                    }
                    int i10 = this.f25704n.readInt();
                    ErrorCode2[] errorCode2ArrValues = ErrorCode2.values();
                    int i11 = 0;
                    while (true) {
                        if (i11 < 14) {
                            errorCode2 = errorCode2ArrValues[i11];
                            if (!(errorCode2.m10241f() == i10)) {
                                i11++;
                            }
                        } else {
                            errorCode2 = null;
                        }
                    }
                    if (errorCode2 == null) {
                        throw new IOException(outline.m871q("TYPE_RST_STREAM unexpected error code: ", i10));
                    }
                    bVar.mo10275h(i7, errorCode2);
                    return true;
                case 4:
                    if (i7 != 0) {
                        throw new IOException("TYPE_SETTINGS streamId != 0");
                    }
                    if ((i6 & 1) != 0) {
                        if (iM10139t != 0) {
                            throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
                        }
                        bVar.mo10268a();
                    } else {
                        if (iM10139t % 6 != 0) {
                            throw new IOException(outline.m871q("TYPE_SETTINGS length % 6 != 0: ", iM10139t));
                        }
                        Settings3 settings3 = new Settings3();
                        Progressions2 progressions2Step = _Ranges.step(_Ranges.until(0, iM10139t), 6);
                        int first = progressions2Step.getFirst();
                        int last = progressions2Step.getLast();
                        int step = progressions2Step.getStep();
                        if (step < 0 ? first >= last : first <= last) {
                            while (true) {
                                short s2 = this.f25704n.readShort();
                                byte[] bArr3 = Util7.f25397a;
                                int i12 = s2 & 65535;
                                i = this.f25704n.readInt();
                                if (i12 != 2) {
                                    if (i12 == 3) {
                                        i12 = 4;
                                    } else if (i12 == 4) {
                                        i12 = 7;
                                        if (i < 0) {
                                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                        }
                                    } else if (i12 == 5 && (i < 16384 || i > 16777215)) {
                                    }
                                } else if (i != 0 && i != 1) {
                                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                                }
                                settings3.m10314c(i12, i);
                                if (first != last) {
                                    first += step;
                                }
                            }
                            throw new IOException(outline.m871q("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", i));
                        }
                        bVar.mo10269b(false, settings3);
                    }
                    return true;
                case 5:
                    if (i7 == 0) {
                        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
                    }
                    int i13 = i6 & 8;
                    if (i13 != 0) {
                        byte b4 = this.f25704n.readByte();
                        byte[] bArr4 = Util7.f25397a;
                        i3 = b4 & 255;
                    }
                    int i14 = this.f25704n.readInt() & Integer.MAX_VALUE;
                    int i15 = iM10139t - 4;
                    if (i13 != 0) {
                        i15--;
                    }
                    if (i3 > i15) {
                        throw new IOException(outline.m875s("PROTOCOL_ERROR padding ", i3, " > remaining length ", i15));
                    }
                    bVar.mo10276i(i7, i14, m10280c(i15 - i3, i3, i6, i7));
                    return true;
                case 6:
                    if (iM10139t != 8) {
                        throw new IOException(outline.m871q("TYPE_PING length != 8: ", iM10139t));
                    }
                    if (i7 != 0) {
                        throw new IOException("TYPE_PING streamId != 0");
                    }
                    bVar.mo10273f((i6 & 1) != 0, this.f25704n.readInt(), this.f25704n.readInt());
                    return true;
                case 7:
                    if (iM10139t < 8) {
                        throw new IOException(outline.m871q("TYPE_GOAWAY length < 8: ", iM10139t));
                    }
                    if (i7 != 0) {
                        throw new IOException("TYPE_GOAWAY streamId != 0");
                    }
                    int i16 = this.f25704n.readInt();
                    int i17 = this.f25704n.readInt();
                    int i18 = iM10139t - 8;
                    ErrorCode2[] errorCode2ArrValues2 = ErrorCode2.values();
                    int i19 = 0;
                    while (true) {
                        if (i19 < 14) {
                            errorCode22 = errorCode2ArrValues2[i19];
                            if (!(errorCode22.m10241f() == i17)) {
                                i19++;
                            }
                        } else {
                            errorCode22 = null;
                        }
                    }
                    if (errorCode22 == null) {
                        throw new IOException(outline.m871q("TYPE_GOAWAY unexpected error code: ", i17));
                    }
                    ByteString byteStringMo10461o = ByteString.f27592j;
                    if (i18 > 0) {
                        byteStringMo10461o = this.f25704n.mo10461o(i18);
                    }
                    bVar.mo10277j(i16, errorCode22, byteStringMo10461o);
                    return true;
                case 8:
                    if (iM10139t != 4) {
                        throw new IOException(outline.m871q("TYPE_WINDOW_UPDATE length !=4: ", iM10139t));
                    }
                    int i20 = this.f25704n.readInt();
                    byte[] bArr5 = Util7.f25397a;
                    long j = i20 & 2147483647L;
                    if (j == 0) {
                        throw new IOException("windowSizeIncrement was 0");
                    }
                    bVar.mo10271d(i7, j);
                    return true;
                default:
                    this.f25704n.skip(iM10139t);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    /* renamed from: b */
    public final void m10279b(b bVar) throws IOException {
        Intrinsics3.checkParameterIsNotNull(bVar, "handler");
        if (this.f25705o) {
            if (!m10278a(true, bVar)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        BufferedSource bufferedSource = this.f25704n;
        ByteString byteString = Http2.f25610a;
        ByteString byteStringMo10461o = bufferedSource.mo10461o(byteString.mo10502j());
        Logger logger = f25700j;
        if (logger.isLoggable(Level.FINE)) {
            StringBuilder sbM833U = outline.m833U("<< CONNECTION ");
            sbM833U.append(byteStringMo10461o.mo10503k());
            logger.fine(Util7.m10129j(sbM833U.toString(), new Object[0]));
        }
        if (!Intrinsics3.areEqual(byteString, byteStringMo10461o)) {
            StringBuilder sbM833U2 = outline.m833U("Expected a connection header but was ");
            sbM833U2.append(byteStringMo10461o.m11008q());
            throw new IOException(sbM833U2.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<Header2> m10280c(int i, int i2, int i3, int i4) throws IOException {
        a aVar = this.f25702l;
        aVar.f25709m = i;
        aVar.f25706j = i;
        aVar.f25710n = i2;
        aVar.f25707k = i3;
        aVar.f25708l = i4;
        Hpack.a aVar2 = this.f25703m;
        while (!aVar2.f25593b.mo10472w()) {
            byte b2 = aVar2.f25593b.readByte();
            byte[] bArr = Util7.f25397a;
            int i5 = b2 & 255;
            if (i5 == 128) {
                throw new IOException("index == 0");
            }
            if ((i5 & 128) == 128) {
                int iM10249g = aVar2.m10249g(i5, Opcodes.LAND) - 1;
                if (iM10249g >= 0) {
                    Hpack hpack = Hpack.f25591c;
                    boolean z2 = iM10249g <= Hpack.f25589a.length + (-1);
                    if (!z2) {
                        Hpack hpack2 = Hpack.f25591c;
                        int iM10244b = aVar2.m10244b(iM10249g - Hpack.f25589a.length);
                        if (iM10244b >= 0) {
                            Header2[] header2Arr = aVar2.f25594c;
                            if (iM10244b < header2Arr.length) {
                                List<Header2> list = aVar2.f25592a;
                                Header2 header2 = header2Arr[iM10244b];
                                if (header2 == null) {
                                    Intrinsics3.throwNpe();
                                }
                                list.add(header2);
                            }
                        }
                        StringBuilder sbM833U = outline.m833U("Header index too large ");
                        sbM833U.append(iM10249g + 1);
                        throw new IOException(sbM833U.toString());
                    }
                    Hpack hpack3 = Hpack.f25591c;
                    aVar2.f25592a.add(Hpack.f25589a[iM10249g]);
                }
            } else if (i5 == 64) {
                Hpack hpack4 = Hpack.f25591c;
                ByteString byteStringM10248f = aVar2.m10248f();
                hpack4.m10242a(byteStringM10248f);
                aVar2.m10247e(-1, new Header2(byteStringM10248f, aVar2.m10248f()));
            } else if ((i5 & 64) == 64) {
                aVar2.m10247e(-1, new Header2(aVar2.m10246d(aVar2.m10249g(i5, 63) - 1), aVar2.m10248f()));
            } else if ((i5 & 32) == 32) {
                int iM10249g2 = aVar2.m10249g(i5, 31);
                aVar2.f25599h = iM10249g2;
                if (iM10249g2 < 0 || iM10249g2 > aVar2.f25598g) {
                    StringBuilder sbM833U2 = outline.m833U("Invalid dynamic table size update ");
                    sbM833U2.append(aVar2.f25599h);
                    throw new IOException(sbM833U2.toString());
                }
                int i6 = aVar2.f25597f;
                if (iM10249g2 < i6) {
                    if (iM10249g2 == 0) {
                        aVar2.m10243a();
                    } else {
                        aVar2.m10245c(i6 - iM10249g2);
                    }
                }
            } else if (i5 == 16 || i5 == 0) {
                Hpack hpack5 = Hpack.f25591c;
                ByteString byteStringM10248f2 = aVar2.m10248f();
                hpack5.m10242a(byteStringM10248f2);
                aVar2.f25592a.add(new Header2(byteStringM10248f2, aVar2.m10248f()));
            } else {
                aVar2.f25592a.add(new Header2(aVar2.m10246d(aVar2.m10249g(i5, 15) - 1), aVar2.m10248f()));
            }
        }
        Hpack.a aVar3 = this.f25703m;
        List<Header2> list2 = _Collections.toList(aVar3.f25592a);
        aVar3.f25592a.clear();
        return list2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f25704n.close();
    }

    /* renamed from: d */
    public final void m10281d(b bVar, int i) throws IOException {
        int i2 = this.f25704n.readInt();
        boolean z2 = (i2 & ((int) Permission.USE_APPLICATION_COMMANDS)) != 0;
        byte b2 = this.f25704n.readByte();
        byte[] bArr = Util7.f25397a;
        bVar.mo10274g(i, i2 & Integer.MAX_VALUE, (b2 & 255) + 1, z2);
    }
}

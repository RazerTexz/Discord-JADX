package p600f0.p601e0.p608j;

import com.discord.api.permission.Permission;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.BufferedSink;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p608j.Hpack;
import p615g0.Buffer3;

/* compiled from: Http2Writer.kt */
/* renamed from: f0.e0.j.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class Http2Writer implements Closeable {

    /* renamed from: j */
    public static final Logger f25737j = Logger.getLogger(Http2.class.getName());

    /* renamed from: k */
    public final Buffer3 f25738k;

    /* renamed from: l */
    public int f25739l;

    /* renamed from: m */
    public boolean f25740m;

    /* renamed from: n */
    public final Hpack.b f25741n;

    /* renamed from: o */
    public final BufferedSink f25742o;

    /* renamed from: p */
    public final boolean f25743p;

    public Http2Writer(BufferedSink bufferedSink, boolean z2) {
        Intrinsics3.checkParameterIsNotNull(bufferedSink, "sink");
        this.f25742o = bufferedSink;
        this.f25743p = z2;
        Buffer3 buffer3 = new Buffer3();
        this.f25738k = buffer3;
        this.f25739l = 16384;
        this.f25741n = new Hpack.b(0, false, buffer3, 3);
    }

    /* renamed from: a */
    public final synchronized void m10298a(Settings3 settings3) throws IOException {
        Intrinsics3.checkParameterIsNotNull(settings3, "peerSettings");
        if (this.f25740m) {
            throw new IOException("closed");
        }
        int i = this.f25739l;
        int i2 = settings3.f25752a;
        if ((i2 & 32) != 0) {
            i = settings3.f25753b[5];
        }
        this.f25739l = i;
        int i3 = i2 & 2;
        if ((i3 != 0 ? settings3.f25753b[1] : -1) != -1) {
            Hpack.b bVar = this.f25741n;
            int i4 = i3 != 0 ? settings3.f25753b[1] : -1;
            bVar.f25607h = i4;
            int iMin = Math.min(i4, 16384);
            int i5 = bVar.f25602c;
            if (i5 != iMin) {
                if (iMin < i5) {
                    bVar.f25600a = Math.min(bVar.f25600a, iMin);
                }
                bVar.f25601b = true;
                bVar.f25602c = iMin;
                int i6 = bVar.f25606g;
                if (iMin < i6) {
                    if (iMin == 0) {
                        bVar.m10250a();
                    } else {
                        bVar.m10251b(i6 - iMin);
                    }
                }
            }
        }
        m10300c(0, 0, 4, 1);
        this.f25742o.flush();
    }

    /* renamed from: b */
    public final synchronized void m10299b(boolean z2, int i, Buffer3 buffer3, int i2) throws IOException {
        if (this.f25740m) {
            throw new IOException("closed");
        }
        m10300c(i, i2, 0, z2 ? 1 : 0);
        if (i2 > 0) {
            BufferedSink bufferedSink = this.f25742o;
            if (buffer3 == null) {
                Intrinsics3.throwNpe();
            }
            bufferedSink.write(buffer3, i2);
        }
    }

    /* renamed from: c */
    public final void m10300c(int i, int i2, int i3, int i4) throws IOException {
        Logger logger = f25737j;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.f25614e.m10257b(false, i, i2, i3, i4));
        }
        if (!(i2 <= this.f25739l)) {
            StringBuilder sbM833U = outline.m833U("FRAME_SIZE_ERROR length > ");
            sbM833U.append(this.f25739l);
            sbM833U.append(": ");
            sbM833U.append(i2);
            throw new IllegalArgumentException(sbM833U.toString().toString());
        }
        if (!((((int) Permission.USE_APPLICATION_COMMANDS) & i) == 0)) {
            throw new IllegalArgumentException(outline.m871q("reserved bit set: ", i).toString());
        }
        BufferedSink bufferedSink = this.f25742o;
        byte[] bArr = Util7.f25397a;
        Intrinsics3.checkParameterIsNotNull(bufferedSink, "$this$writeMedium");
        bufferedSink.writeByte((i2 >>> 16) & 255);
        bufferedSink.writeByte((i2 >>> 8) & 255);
        bufferedSink.writeByte(i2 & 255);
        this.f25742o.writeByte(i3 & 255);
        this.f25742o.writeByte(i4 & 255);
        this.f25742o.writeInt(i & Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f25740m = true;
        this.f25742o.close();
    }

    /* renamed from: d */
    public final synchronized void m10301d(int i, ErrorCode2 errorCode2, byte[] bArr) throws IOException {
        Intrinsics3.checkParameterIsNotNull(errorCode2, "errorCode");
        Intrinsics3.checkParameterIsNotNull(bArr, "debugData");
        if (this.f25740m) {
            throw new IOException("closed");
        }
        if (!(errorCode2.m10241f() != -1)) {
            throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
        }
        m10300c(0, bArr.length + 8, 7, 0);
        this.f25742o.writeInt(i);
        this.f25742o.writeInt(errorCode2.m10241f());
        if (!(bArr.length == 0)) {
            this.f25742o.write(bArr);
        }
        this.f25742o.flush();
    }

    /* renamed from: e */
    public final synchronized void m10302e(boolean z2, int i, List<Header2> list) throws IOException {
        Intrinsics3.checkParameterIsNotNull(list, "headerBlock");
        if (this.f25740m) {
            throw new IOException("closed");
        }
        this.f25741n.m10254e(list);
        long j = this.f25738k.f26080k;
        long jMin = Math.min(this.f25739l, j);
        int i2 = j == jMin ? 4 : 0;
        if (z2) {
            i2 |= 1;
        }
        m10300c(i, (int) jMin, 1, i2);
        this.f25742o.write(this.f25738k, jMin);
        if (j > jMin) {
            m10306s(i, j - jMin);
        }
    }

    /* renamed from: f */
    public final synchronized void m10303f(boolean z2, int i, int i2) throws IOException {
        if (this.f25740m) {
            throw new IOException("closed");
        }
        m10300c(0, 8, 6, z2 ? 1 : 0);
        this.f25742o.writeInt(i);
        this.f25742o.writeInt(i2);
        this.f25742o.flush();
    }

    public final synchronized void flush() throws IOException {
        if (this.f25740m) {
            throw new IOException("closed");
        }
        this.f25742o.flush();
    }

    /* renamed from: n */
    public final synchronized void m10304n(int i, ErrorCode2 errorCode2) throws IOException {
        Intrinsics3.checkParameterIsNotNull(errorCode2, "errorCode");
        if (this.f25740m) {
            throw new IOException("closed");
        }
        if (!(errorCode2.m10241f() != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        m10300c(i, 4, 3, 0);
        this.f25742o.writeInt(errorCode2.m10241f());
        this.f25742o.flush();
    }

    /* renamed from: q */
    public final synchronized void m10305q(int i, long j) throws IOException {
        if (this.f25740m) {
            throw new IOException("closed");
        }
        if (!(j != 0 && j <= 2147483647L)) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j).toString());
        }
        m10300c(i, 4, 8, 0);
        this.f25742o.writeInt((int) j);
        this.f25742o.flush();
    }

    /* renamed from: s */
    public final void m10306s(int i, long j) throws IOException {
        while (j > 0) {
            long jMin = Math.min(this.f25739l, j);
            j -= jMin;
            m10300c(i, (int) jMin, 9, j == 0 ? 4 : 0);
            this.f25742o.write(this.f25738k, jMin);
        }
    }
}

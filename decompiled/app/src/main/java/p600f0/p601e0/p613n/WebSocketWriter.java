package p600f0.p601e0.p613n;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import okio.BufferedSink;
import okio.ByteString;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p615g0.Buffer3;
import p615g0.Segment2;

/* JADX INFO: renamed from: f0.e0.n.i, reason: use source file name */
/* JADX INFO: compiled from: WebSocketWriter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class WebSocketWriter implements Closeable {

    /* JADX INFO: renamed from: j */
    public final Buffer3 f25883j;

    /* JADX INFO: renamed from: k */
    public final Buffer3 f25884k;

    /* JADX INFO: renamed from: l */
    public boolean f25885l;

    /* JADX INFO: renamed from: m */
    public MessageDeflater f25886m;

    /* JADX INFO: renamed from: n */
    public final byte[] f25887n;

    /* JADX INFO: renamed from: o */
    public final Buffer3.a f25888o;

    /* JADX INFO: renamed from: p */
    public final boolean f25889p;

    /* JADX INFO: renamed from: q */
    public final BufferedSink f25890q;

    /* JADX INFO: renamed from: r */
    public final Random f25891r;

    /* JADX INFO: renamed from: s */
    public final boolean f25892s;

    /* JADX INFO: renamed from: t */
    public final boolean f25893t;

    /* JADX INFO: renamed from: u */
    public final long f25894u;

    public WebSocketWriter(boolean z2, BufferedSink bufferedSink, Random random, boolean z3, boolean z4, long j) {
        Intrinsics3.checkParameterIsNotNull(bufferedSink, "sink");
        Intrinsics3.checkParameterIsNotNull(random, "random");
        this.f25889p = z2;
        this.f25890q = bufferedSink;
        this.f25891r = random;
        this.f25892s = z3;
        this.f25893t = z4;
        this.f25894u = j;
        this.f25883j = new Buffer3();
        this.f25884k = bufferedSink.mo10457g();
        this.f25887n = z2 ? new byte[4] : null;
        this.f25888o = z2 ? new Buffer3.a() : null;
    }

    /* JADX INFO: renamed from: a */
    public final void m10363a(int i, ByteString byteString) throws IOException {
        ByteString byteStringM10473x = ByteString.f27592j;
        if (i != 0 || byteString != null) {
            if (i != 0) {
                String strM871q = (i < 1000 || i >= 5000) ? outline.m871q("Code must be in range [1000,5000): ", i) : ((1004 > i || 1006 < i) && (1015 > i || 2999 < i)) ? null : outline.m873r("Code ", i, " is reserved and may not be used.");
                if (!(strM871q == null)) {
                    if (strM871q == null) {
                        Intrinsics3.throwNpe();
                    }
                    throw new IllegalArgumentException(strM871q.toString());
                }
            }
            Buffer3 buffer3 = new Buffer3();
            buffer3.m10448X(i);
            if (byteString != null) {
                buffer3.m10439O(byteString);
            }
            byteStringM10473x = buffer3.m10473x();
        }
        try {
            m10364b(8, byteStringM10473x);
        } finally {
            this.f25885l = true;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m10364b(int i, ByteString byteString) throws IOException {
        if (this.f25885l) {
            throw new IOException("closed");
        }
        int iMo10502j = byteString.mo10502j();
        if (!(((long) iMo10502j) <= 125)) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        this.f25884k.m10444T(i | 128);
        if (this.f25889p) {
            this.f25884k.m10444T(iMo10502j | 128);
            Random random = this.f25891r;
            byte[] bArr = this.f25887n;
            if (bArr == null) {
                Intrinsics3.throwNpe();
            }
            random.nextBytes(bArr);
            this.f25884k.m10442R(this.f25887n);
            if (iMo10502j > 0) {
                Buffer3 buffer3 = this.f25884k;
                long j = buffer3.f26080k;
                buffer3.m10439O(byteString);
                Buffer3 buffer32 = this.f25884k;
                Buffer3.a aVar = this.f25888o;
                if (aVar == null) {
                    Intrinsics3.throwNpe();
                }
                buffer32.m10469u(aVar);
                this.f25888o.m10476b(j);
                WebSocketProtocol.m10360a(this.f25888o, this.f25887n);
                this.f25888o.close();
            }
        } else {
            this.f25884k.m10444T(iMo10502j);
            this.f25884k.m10439O(byteString);
        }
        this.f25890q.flush();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00be  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m10365c(int i, ByteString byteString) throws IOException {
        Intrinsics3.checkParameterIsNotNull(byteString, "data");
        if (this.f25885l) {
            throw new IOException("closed");
        }
        this.f25883j.m10439O(byteString);
        int i2 = i | 128;
        if (this.f25892s && byteString.mo10502j() >= this.f25894u) {
            MessageDeflater messageDeflater = this.f25886m;
            if (messageDeflater == null) {
                messageDeflater = new MessageDeflater(this.f25893t);
                this.f25886m = messageDeflater;
            }
            Buffer3 buffer3 = this.f25883j;
            Intrinsics3.checkParameterIsNotNull(buffer3, "buffer");
            boolean z2 = true;
            if (!(messageDeflater.f25812j.f26080k == 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (messageDeflater.f25815m) {
                messageDeflater.f25813k.reset();
            }
            messageDeflater.f25814l.write(buffer3, buffer3.f26080k);
            messageDeflater.f25814l.flush();
            Buffer3 buffer32 = messageDeflater.f25812j;
            ByteString byteString2 = MessageDeflater2.f25816a;
            long jMo10502j = buffer32.f26080k - ((long) byteString2.mo10502j());
            Intrinsics3.checkParameterIsNotNull(byteString2, "bytes");
            int iMo10502j = byteString2.mo10502j();
            Intrinsics3.checkParameterIsNotNull(byteString2, "bytes");
            if (jMo10502j < 0 || iMo10502j < 0 || buffer32.f26080k - jMo10502j < iMo10502j || byteString2.mo10502j() - 0 < iMo10502j) {
                z2 = false;
                if (z2) {
                    messageDeflater.f25812j.m10444T(0);
                } else {
                    Buffer3 buffer33 = messageDeflater.f25812j;
                    long j = buffer33.f26080k - ((long) 4);
                    Buffer3.a aVar = new Buffer3.a();
                    buffer33.m10469u(aVar);
                    try {
                        aVar.m10475a(j);
                        p507d0.p591y.Closeable.closeFinally(aVar, null);
                    } finally {
                    }
                }
                Buffer3 buffer34 = messageDeflater.f25812j;
                buffer3.write(buffer34, buffer34.f26080k);
                i2 |= 64;
            } else {
                for (int i3 = 0; i3 < iMo10502j; i3++) {
                    if (buffer32.m10464q(((long) i3) + jMo10502j) != byteString2.mo10505m(0 + i3)) {
                        z2 = false;
                        break;
                    }
                }
                if (z2) {
                }
                Buffer3 buffer342 = messageDeflater.f25812j;
                buffer3.write(buffer342, buffer342.f26080k);
                i2 |= 64;
            }
        }
        long j2 = this.f25883j.f26080k;
        this.f25884k.m10444T(i2);
        int i4 = this.f25889p ? 128 : 0;
        if (j2 <= 125) {
            this.f25884k.m10444T(i4 | ((int) j2));
        } else if (j2 <= 65535) {
            this.f25884k.m10444T(i4 | 126);
            this.f25884k.m10448X((int) j2);
        } else {
            this.f25884k.m10444T(i4 | Opcodes.LAND);
            Buffer3 buffer35 = this.f25884k;
            Segment2 segment2M10438N = buffer35.m10438N(8);
            byte[] bArr = segment2M10438N.f26118a;
            int i5 = segment2M10438N.f26120c;
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((j2 >>> 56) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((j2 >>> 48) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((j2 >>> 40) & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) ((j2 >>> 32) & 255);
            int i10 = i9 + 1;
            bArr[i9] = (byte) ((j2 >>> 24) & 255);
            int i11 = i10 + 1;
            bArr[i10] = (byte) ((j2 >>> 16) & 255);
            int i12 = i11 + 1;
            bArr[i11] = (byte) ((j2 >>> 8) & 255);
            bArr[i12] = (byte) (j2 & 255);
            segment2M10438N.f26120c = i12 + 1;
            buffer35.f26080k += 8;
        }
        if (this.f25889p) {
            Random random = this.f25891r;
            byte[] bArr2 = this.f25887n;
            if (bArr2 == null) {
                Intrinsics3.throwNpe();
            }
            random.nextBytes(bArr2);
            this.f25884k.m10442R(this.f25887n);
            if (j2 > 0) {
                Buffer3 buffer36 = this.f25883j;
                Buffer3.a aVar2 = this.f25888o;
                if (aVar2 == null) {
                    Intrinsics3.throwNpe();
                }
                buffer36.m10469u(aVar2);
                this.f25888o.m10476b(0L);
                WebSocketProtocol.m10360a(this.f25888o, this.f25887n);
                this.f25888o.close();
            }
        }
        this.f25884k.write(this.f25883j, j2);
        this.f25890q.mo10462p();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageDeflater messageDeflater = this.f25886m;
        if (messageDeflater != null) {
            messageDeflater.f25814l.close();
        }
    }
}

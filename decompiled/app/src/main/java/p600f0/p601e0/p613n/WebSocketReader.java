package p600f0.p601e0.p613n;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.p601e0.Util7;
import p615g0.Buffer3;
import p615g0.BufferedSource;

/* compiled from: WebSocketReader.kt */
/* renamed from: f0.e0.n.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class WebSocketReader implements Closeable {

    /* renamed from: j */
    public boolean f25867j;

    /* renamed from: k */
    public int f25868k;

    /* renamed from: l */
    public long f25869l;

    /* renamed from: m */
    public boolean f25870m;

    /* renamed from: n */
    public boolean f25871n;

    /* renamed from: o */
    public boolean f25872o;

    /* renamed from: p */
    public final Buffer3 f25873p;

    /* renamed from: q */
    public final Buffer3 f25874q;

    /* renamed from: r */
    public MessageInflater f25875r;

    /* renamed from: s */
    public final byte[] f25876s;

    /* renamed from: t */
    public final Buffer3.a f25877t;

    /* renamed from: u */
    public final boolean f25878u;

    /* renamed from: v */
    public final BufferedSource f25879v;

    /* renamed from: w */
    public final a f25880w;

    /* renamed from: x */
    public final boolean f25881x;

    /* renamed from: y */
    public final boolean f25882y;

    /* compiled from: WebSocketReader.kt */
    /* renamed from: f0.e0.n.h$a */
    public interface a {
        /* renamed from: b */
        void mo10346b(ByteString byteString) throws IOException;

        /* renamed from: c */
        void mo10347c(String str) throws IOException;

        /* renamed from: d */
        void mo10348d(ByteString byteString);

        /* renamed from: f */
        void mo10350f(ByteString byteString);

        /* renamed from: g */
        void mo10351g(int i, String str);
    }

    public WebSocketReader(boolean z2, BufferedSource bufferedSource, a aVar, boolean z3, boolean z4) {
        Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
        Intrinsics3.checkParameterIsNotNull(aVar, "frameCallback");
        this.f25878u = z2;
        this.f25879v = bufferedSource;
        this.f25880w = aVar;
        this.f25881x = z3;
        this.f25882y = z4;
        this.f25873p = new Buffer3();
        this.f25874q = new Buffer3();
        this.f25876s = z2 ? null : new byte[4];
        this.f25877t = z2 ? null : new Buffer3.a();
    }

    /* renamed from: a */
    public final void m10361a() throws IOException {
        String strM10429D;
        long j = this.f25869l;
        if (j > 0) {
            this.f25879v.mo10428B(this.f25873p, j);
            if (!this.f25878u) {
                Buffer3 buffer3 = this.f25873p;
                Buffer3.a aVar = this.f25877t;
                if (aVar == null) {
                    Intrinsics3.throwNpe();
                }
                buffer3.m10469u(aVar);
                this.f25877t.m10476b(0L);
                Buffer3.a aVar2 = this.f25877t;
                byte[] bArr = this.f25876s;
                if (bArr == null) {
                    Intrinsics3.throwNpe();
                }
                WebSocketProtocol.m10360a(aVar2, bArr);
                this.f25877t.close();
            }
        }
        switch (this.f25868k) {
            case 8:
                short s2 = 1005;
                Buffer3 buffer32 = this.f25873p;
                long j2 = buffer32.f26080k;
                if (j2 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (j2 != 0) {
                    s2 = buffer32.readShort();
                    strM10429D = this.f25873p.m10429D();
                    String strM871q = (s2 < 1000 || s2 >= 5000) ? outline.m871q("Code must be in range [1000,5000): ", s2) : ((1004 > s2 || 1006 < s2) && (1015 > s2 || 2999 < s2)) ? null : outline.m873r("Code ", s2, " is reserved and may not be used.");
                    if (strM871q != null) {
                        throw new ProtocolException(strM871q);
                    }
                } else {
                    strM10429D = "";
                }
                this.f25880w.mo10351g(s2, strM10429D);
                this.f25867j = true;
                return;
            case 9:
                this.f25880w.mo10348d(this.f25873p.m10473x());
                return;
            case 10:
                this.f25880w.mo10350f(this.f25873p.m10473x());
                return;
            default:
                StringBuilder sbM833U = outline.m833U("Unknown control opcode: ");
                sbM833U.append(Util7.m10143x(this.f25868k));
                throw new ProtocolException(sbM833U.toString());
        }
    }

    /* JADX WARN: Finally extract failed */
    /* renamed from: b */
    public final void m10362b() throws IOException {
        if (this.f25867j) {
            throw new IOException("closed");
        }
        long jMo10485h = this.f25879v.timeout().mo10485h();
        this.f25879v.timeout().mo10479b();
        try {
            byte b2 = this.f25879v.readByte();
            byte[] bArr = Util7.f25397a;
            int i = b2 & 255;
            this.f25879v.timeout().mo10484g(jMo10485h, TimeUnit.NANOSECONDS);
            int i2 = i & 15;
            this.f25868k = i2;
            boolean z2 = (i & 128) != 0;
            this.f25870m = z2;
            boolean z3 = (i & 8) != 0;
            this.f25871n = z3;
            if (z3 && !z2) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z4 = (i & 64) != 0;
            if (i2 == 1 || i2 == 2) {
                if (!z4) {
                    this.f25872o = false;
                } else {
                    if (!this.f25881x) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    this.f25872o = true;
                }
            } else if (z4) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((i & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((i & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            int i3 = this.f25879v.readByte() & 255;
            boolean z5 = (i3 & 128) != 0;
            if (z5 == this.f25878u) {
                throw new ProtocolException(this.f25878u ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j = i3 & Opcodes.LAND;
            this.f25869l = j;
            if (j == 126) {
                this.f25869l = this.f25879v.readShort() & 65535;
            } else if (j == Opcodes.LAND) {
                long j2 = this.f25879v.readLong();
                this.f25869l = j2;
                if (j2 < 0) {
                    StringBuilder sbM833U = outline.m833U("Frame length 0x");
                    String hexString = Long.toHexString(this.f25869l);
                    Intrinsics3.checkExpressionValueIsNotNull(hexString, "java.lang.Long.toHexString(this)");
                    sbM833U.append(hexString);
                    sbM833U.append(" > 0x7FFFFFFFFFFFFFFF");
                    throw new ProtocolException(sbM833U.toString());
                }
            }
            if (this.f25871n && this.f25869l > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z5) {
                BufferedSource bufferedSource = this.f25879v;
                byte[] bArr2 = this.f25876s;
                if (bArr2 == null) {
                    Intrinsics3.throwNpe();
                }
                bufferedSource.readFully(bArr2);
            }
        } catch (Throwable th) {
            this.f25879v.timeout().mo10484g(jMo10485h, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        MessageInflater messageInflater = this.f25875r;
        if (messageInflater != null) {
            messageInflater.f25819l.close();
        }
    }
}

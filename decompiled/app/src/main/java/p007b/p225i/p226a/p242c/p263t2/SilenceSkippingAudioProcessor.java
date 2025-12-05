package p007b.p225i.p226a.p242c.p263t2;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: SilenceSkippingAudioProcessor.java */
/* renamed from: b.i.a.c.t2.c0, reason: use source file name */
/* loaded from: classes3.dex */
public final class SilenceSkippingAudioProcessor extends BaseAudioProcessor {

    /* renamed from: i */
    public final long f7688i;

    /* renamed from: j */
    public final long f7689j;

    /* renamed from: k */
    public final short f7690k;

    /* renamed from: l */
    public int f7691l;

    /* renamed from: m */
    public boolean f7692m;

    /* renamed from: n */
    public byte[] f7693n;

    /* renamed from: o */
    public byte[] f7694o;

    /* renamed from: p */
    public int f7695p;

    /* renamed from: q */
    public int f7696q;

    /* renamed from: r */
    public int f7697r;

    /* renamed from: s */
    public boolean f7698s;

    /* renamed from: t */
    public long f7699t;

    public SilenceSkippingAudioProcessor() {
        AnimatableValueParser.m531j(true);
        this.f7688i = 150000L;
        this.f7689j = 20000L;
        this.f7690k = (short) 1024;
        byte[] bArr = Util2.f6713f;
        this.f7693n = bArr;
        this.f7694o = bArr;
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.BaseAudioProcessor, com.google.android.exoplayer2.audio.AudioProcessor
    /* renamed from: a */
    public boolean mo3472a() {
        return this.f7692m;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /* renamed from: c */
    public void mo3470c(ByteBuffer byteBuffer) {
        int iPosition;
        while (byteBuffer.hasRemaining() && !this.f7842g.hasRemaining()) {
            int i = this.f7695p;
            if (i == 0) {
                int iLimit = byteBuffer.limit();
                byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.f7693n.length));
                int iLimit2 = byteBuffer.limit();
                while (true) {
                    iLimit2 -= 2;
                    if (iLimit2 < byteBuffer.position()) {
                        iPosition = byteBuffer.position();
                        break;
                    } else if (Math.abs((int) byteBuffer.getShort(iLimit2)) > this.f7690k) {
                        int i2 = this.f7691l;
                        iPosition = ((iLimit2 / i2) * i2) + i2;
                        break;
                    }
                }
                if (iPosition == byteBuffer.position()) {
                    this.f7695p = 1;
                } else {
                    byteBuffer.limit(iPosition);
                    int iRemaining = byteBuffer.remaining();
                    m3511j(iRemaining).put(byteBuffer).flip();
                    if (iRemaining > 0) {
                        this.f7698s = true;
                    }
                }
                byteBuffer.limit(iLimit);
            } else if (i == 1) {
                int iLimit3 = byteBuffer.limit();
                int iM3476k = m3476k(byteBuffer);
                int iPosition2 = iM3476k - byteBuffer.position();
                byte[] bArr = this.f7693n;
                int length = bArr.length;
                int i3 = this.f7696q;
                int i4 = length - i3;
                if (iM3476k >= iLimit3 || iPosition2 >= i4) {
                    int iMin = Math.min(iPosition2, i4);
                    byteBuffer.limit(byteBuffer.position() + iMin);
                    byteBuffer.get(this.f7693n, this.f7696q, iMin);
                    int i5 = this.f7696q + iMin;
                    this.f7696q = i5;
                    byte[] bArr2 = this.f7693n;
                    if (i5 == bArr2.length) {
                        if (this.f7698s) {
                            m3477l(bArr2, this.f7697r);
                            this.f7699t += (this.f7696q - (this.f7697r * 2)) / this.f7691l;
                        } else {
                            this.f7699t += (i5 - this.f7697r) / this.f7691l;
                        }
                        m3478m(byteBuffer, this.f7693n, this.f7696q);
                        this.f7696q = 0;
                        this.f7695p = 2;
                    }
                    byteBuffer.limit(iLimit3);
                } else {
                    m3477l(bArr, i3);
                    this.f7696q = 0;
                    this.f7695p = 0;
                }
            } else {
                if (i != 2) {
                    throw new IllegalStateException();
                }
                int iLimit4 = byteBuffer.limit();
                int iM3476k2 = m3476k(byteBuffer);
                byteBuffer.limit(iM3476k2);
                this.f7699t += byteBuffer.remaining() / this.f7691l;
                m3478m(byteBuffer, this.f7694o, this.f7697r);
                if (iM3476k2 < iLimit4) {
                    m3477l(this.f7694o, this.f7697r);
                    this.f7695p = 0;
                    byteBuffer.limit(iLimit4);
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.BaseAudioProcessor
    /* renamed from: f */
    public AudioProcessor.C10685a mo3471f(AudioProcessor.C10685a c10685a) throws AudioProcessor.UnhandledAudioFormatException {
        if (c10685a.f19698d == 2) {
            return this.f7692m ? c10685a : AudioProcessor.C10685a.f19695a;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(c10685a);
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.BaseAudioProcessor
    /* renamed from: g */
    public void mo3473g() {
        if (this.f7692m) {
            AudioProcessor.C10685a c10685a = this.f7837b;
            int i = c10685a.f19699e;
            this.f7691l = i;
            long j = this.f7688i;
            long j2 = c10685a.f19696b;
            int i2 = ((int) ((j * j2) / 1000000)) * i;
            if (this.f7693n.length != i2) {
                this.f7693n = new byte[i2];
            }
            int i3 = ((int) ((this.f7689j * j2) / 1000000)) * i;
            this.f7697r = i3;
            if (this.f7694o.length != i3) {
                this.f7694o = new byte[i3];
            }
        }
        this.f7695p = 0;
        this.f7699t = 0L;
        this.f7696q = 0;
        this.f7698s = false;
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.BaseAudioProcessor
    /* renamed from: h */
    public void mo3474h() {
        int i = this.f7696q;
        if (i > 0) {
            m3477l(this.f7693n, i);
        }
        if (this.f7698s) {
            return;
        }
        this.f7699t += this.f7697r / this.f7691l;
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.BaseAudioProcessor
    /* renamed from: i */
    public void mo3475i() {
        this.f7692m = false;
        this.f7697r = 0;
        byte[] bArr = Util2.f6713f;
        this.f7693n = bArr;
        this.f7694o = bArr;
    }

    /* renamed from: k */
    public final int m3476k(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position(); iPosition < byteBuffer.limit(); iPosition += 2) {
            if (Math.abs((int) byteBuffer.getShort(iPosition)) > this.f7690k) {
                int i = this.f7691l;
                return (iPosition / i) * i;
            }
        }
        return byteBuffer.limit();
    }

    /* renamed from: l */
    public final void m3477l(byte[] bArr, int i) {
        m3511j(i).put(bArr, 0, i).flip();
        if (i > 0) {
            this.f7698s = true;
        }
    }

    /* renamed from: m */
    public final void m3478m(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int iMin = Math.min(byteBuffer.remaining(), this.f7697r);
        int i2 = this.f7697r - iMin;
        System.arraycopy(bArr, i - i2, this.f7694o, 0, i2);
        byteBuffer.position(byteBuffer.limit() - iMin);
        byteBuffer.get(this.f7694o, i2, iMin);
    }
}

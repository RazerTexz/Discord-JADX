package p007b.p225i.p226a.p242c.p263t2;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: TrimmingAudioProcessor.java */
/* renamed from: b.i.a.c.t2.f0, reason: use source file name */
/* loaded from: classes3.dex */
public final class TrimmingAudioProcessor extends BaseAudioProcessor {

    /* renamed from: i */
    public int f7746i;

    /* renamed from: j */
    public int f7747j;

    /* renamed from: k */
    public boolean f7748k;

    /* renamed from: l */
    public int f7749l;

    /* renamed from: m */
    public byte[] f7750m = Util2.f6713f;

    /* renamed from: n */
    public int f7751n;

    /* renamed from: o */
    public long f7752o;

    @Override // p007b.p225i.p226a.p242c.p263t2.BaseAudioProcessor, com.google.android.exoplayer2.audio.AudioProcessor
    /* renamed from: b */
    public boolean mo3485b() {
        return super.mo3485b() && this.f7751n == 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /* renamed from: c */
    public void mo3470c(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        if (i == 0) {
            return;
        }
        int iMin = Math.min(i, this.f7749l);
        this.f7752o += iMin / this.f7837b.f19699e;
        this.f7749l -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.f7749l > 0) {
            return;
        }
        int i2 = i - iMin;
        int length = (this.f7751n + i2) - this.f7750m.length;
        ByteBuffer byteBufferM3511j = m3511j(length);
        int iM3000h = Util2.m3000h(length, 0, this.f7751n);
        byteBufferM3511j.put(this.f7750m, 0, iM3000h);
        int iM3000h2 = Util2.m3000h(length - iM3000h, 0, i2);
        byteBuffer.limit(byteBuffer.position() + iM3000h2);
        byteBufferM3511j.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i3 = i2 - iM3000h2;
        int i4 = this.f7751n - iM3000h;
        this.f7751n = i4;
        byte[] bArr = this.f7750m;
        System.arraycopy(bArr, iM3000h, bArr, 0, i4);
        byteBuffer.get(this.f7750m, this.f7751n, i3);
        this.f7751n += i3;
        byteBufferM3511j.flip();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.BaseAudioProcessor
    /* renamed from: f */
    public AudioProcessor.C10685a mo3471f(AudioProcessor.C10685a c10685a) throws AudioProcessor.UnhandledAudioFormatException {
        if (c10685a.f19698d != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(c10685a);
        }
        this.f7748k = true;
        return (this.f7746i == 0 && this.f7747j == 0) ? AudioProcessor.C10685a.f19695a : c10685a;
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.BaseAudioProcessor
    /* renamed from: g */
    public void mo3473g() {
        if (this.f7748k) {
            this.f7748k = false;
            int i = this.f7747j;
            int i2 = this.f7837b.f19699e;
            this.f7750m = new byte[i * i2];
            this.f7749l = this.f7746i * i2;
        }
        this.f7751n = 0;
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.BaseAudioProcessor, com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        int i;
        if (super.mo3485b() && (i = this.f7751n) > 0) {
            m3511j(i).put(this.f7750m, 0, this.f7751n).flip();
            this.f7751n = 0;
        }
        return super.getOutput();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.BaseAudioProcessor
    /* renamed from: h */
    public void mo3474h() {
        if (this.f7748k) {
            if (this.f7751n > 0) {
                this.f7752o += r0 / this.f7837b.f19699e;
            }
            this.f7751n = 0;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.BaseAudioProcessor
    /* renamed from: i */
    public void mo3475i() {
        this.f7750m = Util2.f6713f;
    }
}

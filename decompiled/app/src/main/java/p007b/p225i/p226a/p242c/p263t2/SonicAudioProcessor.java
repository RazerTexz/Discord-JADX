package p007b.p225i.p226a.p242c.p263t2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.t2.e0, reason: use source file name */
/* JADX INFO: compiled from: SonicAudioProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SonicAudioProcessor implements AudioProcessor {

    /* JADX INFO: renamed from: b */
    public int f7727b;

    /* JADX INFO: renamed from: c */
    public float f7728c = 1.0f;

    /* JADX INFO: renamed from: d */
    public float f7729d = 1.0f;

    /* JADX INFO: renamed from: e */
    public AudioProcessor.C10685a f7730e;

    /* JADX INFO: renamed from: f */
    public AudioProcessor.C10685a f7731f;

    /* JADX INFO: renamed from: g */
    public AudioProcessor.C10685a f7732g;

    /* JADX INFO: renamed from: h */
    public AudioProcessor.C10685a f7733h;

    /* JADX INFO: renamed from: i */
    public boolean f7734i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public Sonic f7735j;

    /* JADX INFO: renamed from: k */
    public ByteBuffer f7736k;

    /* JADX INFO: renamed from: l */
    public ShortBuffer f7737l;

    /* JADX INFO: renamed from: m */
    public ByteBuffer f7738m;

    /* JADX INFO: renamed from: n */
    public long f7739n;

    /* JADX INFO: renamed from: o */
    public long f7740o;

    /* JADX INFO: renamed from: p */
    public boolean f7741p;

    public SonicAudioProcessor() {
        AudioProcessor.C10685a c10685a = AudioProcessor.C10685a.f19695a;
        this.f7730e = c10685a;
        this.f7731f = c10685a;
        this.f7732g = c10685a;
        this.f7733h = c10685a;
        ByteBuffer byteBuffer = AudioProcessor.f19694a;
        this.f7736k = byteBuffer;
        this.f7737l = byteBuffer.asShortBuffer();
        this.f7738m = byteBuffer;
        this.f7727b = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /* JADX INFO: renamed from: a */
    public boolean mo3472a() {
        return this.f7731f.f19696b != -1 && (Math.abs(this.f7728c - 1.0f) >= 1.0E-4f || Math.abs(this.f7729d - 1.0f) >= 1.0E-4f || this.f7731f.f19696b != this.f7730e.f19696b);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /* JADX INFO: renamed from: b */
    public boolean mo3485b() {
        Sonic sonic;
        return this.f7741p && ((sonic = this.f7735j) == null || (sonic.f7714m * sonic.f7703b) * 2 == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /* JADX INFO: renamed from: c */
    public void mo3470c(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            Sonic sonic = this.f7735j;
            Objects.requireNonNull(sonic);
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.f7739n += (long) iRemaining;
            int iRemaining2 = shortBufferAsShortBuffer.remaining();
            int i = sonic.f7703b;
            int i2 = iRemaining2 / i;
            short[] sArrM3482c = sonic.m3482c(sonic.f7711j, sonic.f7712k, i2);
            sonic.f7711j = sArrM3482c;
            shortBufferAsShortBuffer.get(sArrM3482c, sonic.f7712k * sonic.f7703b, ((i * i2) * 2) / 2);
            sonic.f7712k += i2;
            sonic.m3484f();
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /* JADX INFO: renamed from: d */
    public AudioProcessor.C10685a mo3486d(AudioProcessor.C10685a c10685a) throws AudioProcessor.UnhandledAudioFormatException {
        if (c10685a.f19698d != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(c10685a);
        }
        int i = this.f7727b;
        if (i == -1) {
            i = c10685a.f19696b;
        }
        this.f7730e = c10685a;
        AudioProcessor.C10685a c10685a2 = new AudioProcessor.C10685a(i, c10685a.f19697c, 2);
        this.f7731f = c10685a2;
        this.f7734i = true;
        return c10685a2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /* JADX INFO: renamed from: e */
    public void mo3487e() {
        int i;
        Sonic sonic = this.f7735j;
        if (sonic != null) {
            int i2 = sonic.f7712k;
            float f = sonic.f7704c;
            float f2 = sonic.f7705d;
            int i3 = sonic.f7714m + ((int) ((((i2 / (f / f2)) + sonic.f7716o) / (sonic.f7706e * f2)) + 0.5f));
            sonic.f7711j = sonic.m3482c(sonic.f7711j, i2, (sonic.f7709h * 2) + i2);
            int i4 = 0;
            while (true) {
                i = sonic.f7709h * 2;
                int i5 = sonic.f7703b;
                if (i4 >= i * i5) {
                    break;
                }
                sonic.f7711j[(i5 * i2) + i4] = 0;
                i4++;
            }
            sonic.f7712k = i + sonic.f7712k;
            sonic.m3484f();
            if (sonic.f7714m > i3) {
                sonic.f7714m = i3;
            }
            sonic.f7712k = 0;
            sonic.f7719r = 0;
            sonic.f7716o = 0;
        }
        this.f7741p = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        if (mo3472a()) {
            AudioProcessor.C10685a c10685a = this.f7730e;
            this.f7732g = c10685a;
            AudioProcessor.C10685a c10685a2 = this.f7731f;
            this.f7733h = c10685a2;
            if (this.f7734i) {
                this.f7735j = new Sonic(c10685a.f19696b, c10685a.f19697c, this.f7728c, this.f7729d, c10685a2.f19696b);
            } else {
                Sonic sonic = this.f7735j;
                if (sonic != null) {
                    sonic.f7712k = 0;
                    sonic.f7714m = 0;
                    sonic.f7716o = 0;
                    sonic.f7717p = 0;
                    sonic.f7718q = 0;
                    sonic.f7719r = 0;
                    sonic.f7720s = 0;
                    sonic.f7721t = 0;
                    sonic.f7722u = 0;
                    sonic.f7723v = 0;
                }
            }
        }
        this.f7738m = AudioProcessor.f19694a;
        this.f7739n = 0L;
        this.f7740o = 0L;
        this.f7741p = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        int i;
        Sonic sonic = this.f7735j;
        if (sonic != null && (i = sonic.f7714m * sonic.f7703b * 2) > 0) {
            if (this.f7736k.capacity() < i) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
                this.f7736k = byteBufferOrder;
                this.f7737l = byteBufferOrder.asShortBuffer();
            } else {
                this.f7736k.clear();
                this.f7737l.clear();
            }
            ShortBuffer shortBuffer = this.f7737l;
            int iMin = Math.min(shortBuffer.remaining() / sonic.f7703b, sonic.f7714m);
            shortBuffer.put(sonic.f7713l, 0, sonic.f7703b * iMin);
            int i2 = sonic.f7714m - iMin;
            sonic.f7714m = i2;
            short[] sArr = sonic.f7713l;
            int i3 = sonic.f7703b;
            System.arraycopy(sArr, iMin * i3, sArr, 0, i2 * i3);
            this.f7740o += (long) i;
            this.f7736k.limit(i);
            this.f7738m = this.f7736k;
        }
        ByteBuffer byteBuffer = this.f7738m;
        this.f7738m = AudioProcessor.f19694a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.f7728c = 1.0f;
        this.f7729d = 1.0f;
        AudioProcessor.C10685a c10685a = AudioProcessor.C10685a.f19695a;
        this.f7730e = c10685a;
        this.f7731f = c10685a;
        this.f7732g = c10685a;
        this.f7733h = c10685a;
        ByteBuffer byteBuffer = AudioProcessor.f19694a;
        this.f7736k = byteBuffer;
        this.f7737l = byteBuffer.asShortBuffer();
        this.f7738m = byteBuffer;
        this.f7727b = -1;
        this.f7734i = false;
        this.f7735j = null;
        this.f7739n = 0L;
        this.f7740o = 0L;
        this.f7741p = false;
    }
}

package p007b.p225i.p226a.p242c.p263t2;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.FormatHolder;
import p007b.p225i.p226a.p242c.PlaybackParameters;
import p007b.p225i.p226a.p242c.Renderer2;
import p007b.p225i.p226a.p242c.RendererConfiguration;
import p007b.p225i.p226a.p242c.p259f3.Log2;
import p007b.p225i.p226a.p242c.p259f3.MediaClock;
import p007b.p225i.p226a.p242c.p259f3.MimeTypes;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2;
import p007b.p225i.p226a.p242c.p265v2.DecoderCounters;
import p007b.p225i.p226a.p242c.p265v2.DecoderReuseEvaluation;
import p007b.p225i.p226a.p242c.p278y2.C3135g;
import p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter;
import p007b.p225i.p226a.p242c.p278y2.MediaCodecInfo;
import p007b.p225i.p226a.p242c.p278y2.MediaCodecSelector;

/* compiled from: MediaCodecAudioRenderer.java */
/* renamed from: b.i.a.c.t2.z, reason: use source file name */
/* loaded from: classes3.dex */
public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {

    /* renamed from: N0 */
    public final Context f7850N0;

    /* renamed from: O0 */
    public final AudioRendererEventListener2.a f7851O0;

    /* renamed from: P0 */
    public final AudioSink f7852P0;

    /* renamed from: Q0 */
    public int f7853Q0;

    /* renamed from: R0 */
    public boolean f7854R0;

    /* renamed from: S0 */
    @Nullable
    public Format2 f7855S0;

    /* renamed from: T0 */
    public long f7856T0;

    /* renamed from: U0 */
    public boolean f7857U0;

    /* renamed from: V0 */
    public boolean f7858V0;

    /* renamed from: W0 */
    public boolean f7859W0;

    /* renamed from: X0 */
    @Nullable
    public Renderer2.a f7860X0;

    /* compiled from: MediaCodecAudioRenderer.java */
    /* renamed from: b.i.a.c.t2.z$b */
    public final class b implements AudioSink.InterfaceC10686a {
        public b(a aVar) {
        }

        /* renamed from: a */
        public void m3517a(Exception exc) {
            Log2.m3039b("MediaCodecAudioRenderer", "Audio sink error", exc);
            AudioRendererEventListener2.a aVar = MediaCodecAudioRenderer.this.f7851O0;
            Handler handler = aVar.f7790a;
            if (handler != null) {
                handler.post(new RunnableC2917d(aVar, exc));
            }
        }
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecAdapter.b bVar, MediaCodecSelector mediaCodecSelector, boolean z2, @Nullable Handler handler, @Nullable AudioRendererEventListener2 audioRendererEventListener2, AudioSink audioSink) {
        super(1, bVar, mediaCodecSelector, z2, 44100.0f);
        this.f7850N0 = context.getApplicationContext();
        this.f7852P0 = audioSink;
        this.f7851O0 = new AudioRendererEventListener2.a(handler, audioRendererEventListener2);
        audioSink.mo8773t(new b(null));
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, p007b.p225i.p226a.p242c.BaseRenderer
    /* renamed from: B */
    public void mo2621B() {
        this.f7859W0 = true;
        try {
            this.f7852P0.flush();
            try {
                super.mo2621B();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.mo2621B();
                throw th;
            } finally {
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.BaseRenderer
    /* renamed from: C */
    public void mo3137C(boolean z2, boolean z3) throws ExoPlaybackException {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.f19877J0 = decoderCounters;
        AudioRendererEventListener2.a aVar = this.f7851O0;
        Handler handler = aVar.f7790a;
        if (handler != null) {
            handler.post(new RunnableC2926j(aVar, decoderCounters));
        }
        RendererConfiguration rendererConfiguration = this.f7891l;
        Objects.requireNonNull(rendererConfiguration);
        if (rendererConfiguration.f7118b) {
            this.f7852P0.mo8771r();
        } else {
            this.f7852P0.mo8767n();
        }
    }

    /* renamed from: C0 */
    public final int m3513C0(MediaCodecInfo mediaCodecInfo, Format2 format2) {
        int i;
        if (!"OMX.google.raw.decoder".equals(mediaCodecInfo.f9112a) || (i = Util2.f6708a) >= 24 || (i == 23 && Util2.m2980A(this.f7850N0))) {
            return format2.f7156x;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, p007b.p225i.p226a.p242c.BaseRenderer
    /* renamed from: D */
    public void mo2622D(long j, boolean z2) throws ExoPlaybackException {
        super.mo2622D(j, z2);
        this.f7852P0.flush();
        this.f7856T0 = j;
        this.f7857U0 = true;
        this.f7858V0 = true;
    }

    /* renamed from: D0 */
    public final void m3514D0() {
        long jMo8766m = this.f7852P0.mo8766m(mo2631b());
        if (jMo8766m != Long.MIN_VALUE) {
            if (!this.f7858V0) {
                jMo8766m = Math.max(this.f7856T0, jMo8766m);
            }
            this.f7856T0 = jMo8766m;
            this.f7858V0 = false;
        }
    }

    @Override // p007b.p225i.p226a.p242c.BaseRenderer
    /* renamed from: E */
    public void mo3140E() {
        try {
            try {
                m8841M();
                m8855o0();
            } finally {
                m8859u0(null);
            }
        } finally {
            if (this.f7859W0) {
                this.f7859W0 = false;
                this.f7852P0.reset();
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.BaseRenderer
    /* renamed from: F */
    public void mo3141F() {
        this.f7852P0.mo8761e();
    }

    @Override // p007b.p225i.p226a.p242c.BaseRenderer
    /* renamed from: G */
    public void mo3142G() {
        m3514D0();
        this.f7852P0.mo8760d();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* renamed from: K */
    public DecoderReuseEvaluation mo3144K(MediaCodecInfo mediaCodecInfo, Format2 format2, Format2 format22) {
        DecoderReuseEvaluation decoderReuseEvaluationM3865c = mediaCodecInfo.m3865c(format2, format22);
        int i = decoderReuseEvaluationM3865c.f7930e;
        if (m3513C0(mediaCodecInfo, format22) > this.f7853Q0) {
            i |= 64;
        }
        int i2 = i;
        return new DecoderReuseEvaluation(mediaCodecInfo.f9112a, format2, format22, i2 != 0 ? 0 : decoderReuseEvaluationM3865c.f7929d, i2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* renamed from: V */
    public float mo3158V(float f, Format2 format2, Format2[] format2Arr) {
        int iMax = -1;
        for (Format2 format22 : format2Arr) {
            int i = format22.f7137K;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return f * iMax;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* renamed from: W */
    public List<MediaCodecInfo> mo3160W(MediaCodecSelector mediaCodecSelector, Format2 format2, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        MediaCodecInfo mediaCodecInfoM8865d;
        String str = format2.f7155w;
        if (str == null) {
            return Collections.emptyList();
        }
        if (this.f7852P0.mo8757a(format2) && (mediaCodecInfoM8865d = MediaCodecUtil.m8865d("audio/raw", false, false)) != null) {
            return Collections.singletonList(mediaCodecInfoM8865d);
        }
        List<MediaCodecInfo> listMo3831a = mediaCodecSelector.mo3831a(str, z2, false);
        Pattern pattern = MediaCodecUtil.f19928a;
        ArrayList arrayList = new ArrayList(listMo3831a);
        MediaCodecUtil.m8871j(arrayList, new C3135g(format2));
        if ("audio/eac3-joc".equals(str)) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            arrayList2.addAll(mediaCodecSelector.mo3831a("audio/eac3", z2, false));
            arrayList = arrayList2;
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* renamed from: Y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MediaCodecAdapter.a mo3161Y(MediaCodecInfo mediaCodecInfo, Format2 format2, @Nullable MediaCrypto mediaCrypto, float f) {
        boolean z2;
        Format2[] format2Arr = this.f7895p;
        Objects.requireNonNull(format2Arr);
        int iM3513C0 = m3513C0(mediaCodecInfo, format2);
        boolean z3 = false;
        if (format2Arr.length != 1) {
            for (Format2 format22 : format2Arr) {
                if (mediaCodecInfo.m3865c(format2, format22).f7929d != 0) {
                    iM3513C0 = Math.max(iM3513C0, m3513C0(mediaCodecInfo, format22));
                }
            }
        }
        this.f7853Q0 = iM3513C0;
        String str = mediaCodecInfo.f9112a;
        int i = Util2.f6708a;
        if (i < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(Util2.f6710c)) {
            String str2 = Util2.f6709b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                z2 = true;
            }
        } else {
            z2 = false;
        }
        this.f7854R0 = z2;
        String str3 = mediaCodecInfo.f9114c;
        int i2 = this.f7853Q0;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str3);
        mediaFormat.setInteger("channel-count", format2.f7136J);
        mediaFormat.setInteger("sample-rate", format2.f7137K);
        AnimatableValueParser.m491Y1(mediaFormat, format2.f7157y);
        AnimatableValueParser.m533j1(mediaFormat, "max-input-size", i2);
        if (i >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                if (i == 23) {
                    String str4 = Util2.f6711d;
                    boolean z4 = "ZTE B2017G".equals(str4) || "AXON 7 mini".equals(str4);
                    if (!z4) {
                        mediaFormat.setFloat("operating-rate", f);
                    }
                }
            }
        }
        if (i <= 28 && "audio/ac4".equals(format2.f7155w)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i >= 24) {
            AudioSink audioSink = this.f7852P0;
            int i3 = format2.f7136J;
            int i4 = format2.f7137K;
            Format2.b bVar = new Format2.b();
            bVar.f7173k = "audio/raw";
            bVar.f7186x = i3;
            bVar.f7187y = i4;
            bVar.f7188z = 4;
            if (audioSink.mo8774u(bVar.m3277a()) == 2) {
                mediaFormat.setInteger("pcm-encoding", 4);
            }
        }
        if ("audio/raw".equals(mediaCodecInfo.f9113b) && !"audio/raw".equals(format2.f7155w)) {
            z3 = true;
        }
        this.f7855S0 = z3 ? format2 : null;
        return new MediaCodecAdapter.a(mediaCodecInfo, mediaFormat, format2, null, mediaCrypto, 0, false);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: b */
    public boolean mo2631b() {
        return this.f19869F0 && this.f7852P0.mo8758b();
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.MediaClock
    /* renamed from: c */
    public PlaybackParameters mo2416c() {
        return this.f7852P0.mo8759c();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: d */
    public boolean mo2632d() {
        return this.f7852P0.mo8764k() || super.mo2632d();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* renamed from: d0 */
    public void mo3163d0(Exception exc) {
        Log2.m3039b("MediaCodecAudioRenderer", "Audio codec error", exc);
        AudioRendererEventListener2.a aVar = this.f7851O0;
        Handler handler = aVar.f7790a;
        if (handler != null) {
            handler.post(new RunnableC2915c(aVar, exc));
        }
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.MediaClock
    /* renamed from: e */
    public long mo2417e() {
        if (this.f7893n == 2) {
            m3514D0();
        }
        return this.f7856T0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* renamed from: e0 */
    public void mo3164e0(String str, long j, long j2) {
        AudioRendererEventListener2.a aVar = this.f7851O0;
        Handler handler = aVar.f7790a;
        if (handler != null) {
            handler.post(new RunnableC2921f(aVar, str, j, j2));
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* renamed from: f0 */
    public void mo3165f0(String str) {
        AudioRendererEventListener2.a aVar = this.f7851O0;
        Handler handler = aVar.f7790a;
        if (handler != null) {
            handler.post(new RunnableC2923g(aVar, str));
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    /* renamed from: g0 */
    public DecoderReuseEvaluation mo3166g0(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation decoderReuseEvaluationMo3166g0 = super.mo3166g0(formatHolder);
        AudioRendererEventListener2.a aVar = this.f7851O0;
        Format2 format2 = formatHolder.f7196b;
        Handler handler = aVar.f7790a;
        if (handler != null) {
            handler.post(new RunnableC2919e(aVar, format2, decoderReuseEvaluationMo3166g0));
        }
        return decoderReuseEvaluationMo3166g0;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2, p007b.p225i.p226a.p242c.RendererCapabilities
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* renamed from: h0 */
    public void mo3167h0(Format2 format2, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException {
        int i;
        Format2 format22 = this.f7855S0;
        int[] iArr = null;
        if (format22 != null) {
            format2 = format22;
        } else if (this.f19889S != null) {
            int iM3010r = "audio/raw".equals(format2.f7155w) ? format2.f7138L : (Util2.f6708a < 24 || !mediaFormat.containsKey("pcm-encoding")) ? mediaFormat.containsKey("v-bits-per-sample") ? Util2.m3010r(mediaFormat.getInteger("v-bits-per-sample")) : "audio/raw".equals(format2.f7155w) ? format2.f7138L : 2 : mediaFormat.getInteger("pcm-encoding");
            Format2.b bVar = new Format2.b();
            bVar.f7173k = "audio/raw";
            bVar.f7188z = iM3010r;
            bVar.f7159A = format2.f7139M;
            bVar.f7160B = format2.f7140N;
            bVar.f7186x = mediaFormat.getInteger("channel-count");
            bVar.f7187y = mediaFormat.getInteger("sample-rate");
            Format2 format2M3277a = bVar.m3277a();
            if (this.f7854R0 && format2M3277a.f7136J == 6 && (i = format2.f7136J) < 6) {
                iArr = new int[i];
                for (int i2 = 0; i2 < format2.f7136J; i2++) {
                    iArr[i2] = i2;
                }
            }
            format2 = format2M3277a;
        }
        try {
            this.f7852P0.mo8775v(format2, 0, iArr);
        } catch (AudioSink.ConfigurationException e) {
            throw m3550z(e, e.format, false, 5001);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.MediaClock
    /* renamed from: i */
    public void mo2418i(PlaybackParameters playbackParameters) {
        this.f7852P0.mo8762i(playbackParameters);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* renamed from: j0 */
    public void mo3169j0() {
        this.f7852P0.mo8769p();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* renamed from: k0 */
    public void mo3170k0(DecoderInputBuffer decoderInputBuffer) {
        if (!this.f7857U0 || decoderInputBuffer.m3554m()) {
            return;
        }
        if (Math.abs(decoderInputBuffer.f19780n - this.f7856T0) > 500000) {
            this.f7856T0 = decoderInputBuffer.f19780n;
        }
        this.f7857U0 = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* renamed from: m0 */
    public boolean mo3171m0(long j, long j2, @Nullable MediaCodecAdapter mediaCodecAdapter, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z2, boolean z3, Format2 format2) throws ExoPlaybackException {
        Objects.requireNonNull(byteBuffer);
        if (this.f7855S0 != null && (i2 & 2) != 0) {
            Objects.requireNonNull(mediaCodecAdapter);
            mediaCodecAdapter.releaseOutputBuffer(i, false);
            return true;
        }
        if (z2) {
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.releaseOutputBuffer(i, false);
            }
            this.f19877J0.f7919f += i3;
            this.f7852P0.mo8769p();
            return true;
        }
        try {
            if (!this.f7852P0.mo8772s(byteBuffer, j3, i3)) {
                return false;
            }
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.releaseOutputBuffer(i, false);
            }
            this.f19877J0.f7918e += i3;
            return true;
        } catch (AudioSink.InitializationException e) {
            throw m3550z(e, e.format, e.isRecoverable, 5001);
        } catch (AudioSink.WriteException e2) {
            throw m3550z(e2, format2, e2.isRecoverable, 5002);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* renamed from: p0 */
    public void mo3515p0() throws ExoPlaybackException {
        try {
            this.f7852P0.mo8763j();
        } catch (AudioSink.WriteException e) {
            throw m3550z(e, e.format, e.isRecoverable, 5002);
        }
    }

    @Override // p007b.p225i.p226a.p242c.BaseRenderer, p007b.p225i.p226a.p242c.PlayerMessage.b
    /* renamed from: r */
    public void mo2603r(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 2) {
            this.f7852P0.mo8770q(((Float) obj).floatValue());
        }
        if (i == 3) {
            this.f7852P0.mo8768o((AudioAttributes) obj);
            return;
        }
        if (i == 6) {
            this.f7852P0.mo8777x((AuxEffectInfo) obj);
            return;
        }
        switch (i) {
            case 9:
                this.f7852P0.mo8776w(((Boolean) obj).booleanValue());
                break;
            case 10:
                this.f7852P0.mo8765l(((Integer) obj).intValue());
                break;
            case 11:
                this.f7860X0 = (Renderer2.a) obj;
                break;
        }
    }

    @Override // p007b.p225i.p226a.p242c.BaseRenderer, p007b.p225i.p226a.p242c.Renderer2
    @Nullable
    /* renamed from: w */
    public MediaClock mo2945w() {
        return this;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* renamed from: x0 */
    public boolean mo3516x0(Format2 format2) {
        return this.f7852P0.mo8757a(format2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* renamed from: y0 */
    public int mo3174y0(MediaCodecSelector mediaCodecSelector, Format2 format2) throws MediaCodecUtil.DecoderQueryException {
        if (!MimeTypes.m3050h(format2.f7155w)) {
            return 0;
        }
        int i = Util2.f6708a >= 21 ? 32 : 0;
        int i2 = format2.f7142P;
        boolean z2 = i2 != 0;
        boolean z3 = i2 == 0 || i2 == 2;
        if (z3 && this.f7852P0.mo8757a(format2) && (!z2 || MediaCodecUtil.m8865d("audio/raw", false, false) != null)) {
            return i | 12;
        }
        if ("audio/raw".equals(format2.f7155w) && !this.f7852P0.mo8757a(format2)) {
            return 1;
        }
        AudioSink audioSink = this.f7852P0;
        int i3 = format2.f7136J;
        int i4 = format2.f7137K;
        Format2.b bVar = new Format2.b();
        bVar.f7173k = "audio/raw";
        bVar.f7186x = i3;
        bVar.f7187y = i4;
        bVar.f7188z = 2;
        if (!audioSink.mo8757a(bVar.m3277a())) {
            return 1;
        }
        List<MediaCodecInfo> listMo3160W = mo3160W(mediaCodecSelector, format2, false);
        if (listMo3160W.isEmpty()) {
            return 1;
        }
        if (!z3) {
            return 2;
        }
        MediaCodecInfo mediaCodecInfo = listMo3160W.get(0);
        boolean zM3867e = mediaCodecInfo.m3867e(format2);
        return ((zM3867e && mediaCodecInfo.m3868f(format2)) ? 16 : 8) | (zM3867e ? 4 : 3) | i;
    }
}

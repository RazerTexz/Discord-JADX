package p007b.p225i.p226a.p242c.p245b3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p242c.BaseRenderer;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.FormatHolder;
import p007b.p225i.p226a.p242c.p245b3.SubtitleDecoderFactory;
import p007b.p225i.p226a.p242c.p245b3.p246n.Cea608Decoder;
import p007b.p225i.p226a.p242c.p245b3.p246n.Cea708Decoder;
import p007b.p225i.p226a.p242c.p245b3.p247o.DvbDecoder;
import p007b.p225i.p226a.p242c.p245b3.p248p.PgsDecoder;
import p007b.p225i.p226a.p242c.p245b3.p250r.SsaDecoder;
import p007b.p225i.p226a.p242c.p245b3.p251s.SubripDecoder;
import p007b.p225i.p226a.p242c.p245b3.p252t.TtmlDecoder;
import p007b.p225i.p226a.p242c.p245b3.p253u.Tx3gDecoder;
import p007b.p225i.p226a.p242c.p245b3.p254v.Mp4WebvttDecoder;
import p007b.p225i.p226a.p242c.p245b3.p254v.WebvttDecoder;
import p007b.p225i.p226a.p242c.p259f3.Log2;
import p007b.p225i.p226a.p242c.p259f3.MimeTypes;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: TextRenderer.java */
/* renamed from: b.i.a.c.b3.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class TextRenderer extends BaseRenderer implements Handler.Callback {

    /* renamed from: A */
    public boolean f5803A;

    /* renamed from: B */
    public int f5804B;

    /* renamed from: C */
    @Nullable
    public Format2 f5805C;

    /* renamed from: D */
    @Nullable
    public SubtitleDecoder f5806D;

    /* renamed from: E */
    @Nullable
    public SubtitleInputBuffer f5807E;

    /* renamed from: F */
    @Nullable
    public SubtitleOutputBuffer f5808F;

    /* renamed from: G */
    @Nullable
    public SubtitleOutputBuffer f5809G;

    /* renamed from: H */
    public int f5810H;

    /* renamed from: I */
    public long f5811I;

    /* renamed from: u */
    @Nullable
    public final Handler f5812u;

    /* renamed from: v */
    public final TextOutput f5813v;

    /* renamed from: w */
    public final SubtitleDecoderFactory f5814w;

    /* renamed from: x */
    public final FormatHolder f5815x;

    /* renamed from: y */
    public boolean f5816y;

    /* renamed from: z */
    public boolean f5817z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextRenderer(TextOutput textOutput, @Nullable Looper looper) {
        Handler handler;
        super(3);
        SubtitleDecoderFactory subtitleDecoderFactory = SubtitleDecoderFactory.f5799a;
        Objects.requireNonNull(textOutput);
        this.f5813v = textOutput;
        if (looper == null) {
            handler = null;
        } else {
            int i = Util2.f6708a;
            handler = new Handler(looper, this);
        }
        this.f5812u = handler;
        this.f5814w = subtitleDecoderFactory;
        this.f5815x = new FormatHolder();
        this.f5811I = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.BaseRenderer
    /* renamed from: B */
    public void mo2621B() {
        this.f5805C = null;
        this.f5811I = -9223372036854775807L;
        m2624J();
        m2628N();
        SubtitleDecoder subtitleDecoder = this.f5806D;
        Objects.requireNonNull(subtitleDecoder);
        subtitleDecoder.release();
        this.f5806D = null;
        this.f5804B = 0;
    }

    @Override // p007b.p225i.p226a.p242c.BaseRenderer
    /* renamed from: D */
    public void mo2622D(long j, boolean z2) {
        m2624J();
        this.f5816y = false;
        this.f5817z = false;
        this.f5811I = -9223372036854775807L;
        if (this.f5804B != 0) {
            m2629O();
            return;
        }
        m2628N();
        SubtitleDecoder subtitleDecoder = this.f5806D;
        Objects.requireNonNull(subtitleDecoder);
        subtitleDecoder.flush();
    }

    @Override // p007b.p225i.p226a.p242c.BaseRenderer
    /* renamed from: H */
    public void mo2623H(Format2[] format2Arr, long j, long j2) {
        this.f5805C = format2Arr[0];
        if (this.f5806D != null) {
            this.f5804B = 1;
        } else {
            m2627M();
        }
    }

    /* renamed from: J */
    public final void m2624J() {
        List<Cue> listEmptyList = Collections.emptyList();
        Handler handler = this.f5812u;
        if (handler != null) {
            handler.obtainMessage(0, listEmptyList).sendToTarget();
        } else {
            this.f5813v.mo2620e(listEmptyList);
        }
    }

    /* renamed from: K */
    public final long m2625K() {
        if (this.f5810H == -1) {
            return RecyclerView.FOREVER_NS;
        }
        Objects.requireNonNull(this.f5808F);
        int i = this.f5810H;
        Subtitle subtitle = this.f5808F.f5801l;
        Objects.requireNonNull(subtitle);
        if (i >= subtitle.mo2615i()) {
            return RecyclerView.FOREVER_NS;
        }
        SubtitleOutputBuffer subtitleOutputBuffer = this.f5808F;
        int i2 = this.f5810H;
        Subtitle subtitle2 = subtitleOutputBuffer.f5801l;
        Objects.requireNonNull(subtitle2);
        return subtitle2.mo2613g(i2) + subtitleOutputBuffer.f5802m;
    }

    /* renamed from: L */
    public final void m2626L(SubtitleDecoderException subtitleDecoderException) {
        String strValueOf = String.valueOf(this.f5805C);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 39);
        sb.append("Subtitle decoding failed. streamFormat=");
        sb.append(strValueOf);
        Log2.m3039b("TextRenderer", sb.toString(), subtitleDecoderException);
        m2624J();
        m2629O();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001b  */
    /* renamed from: M */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2627M() {
        SubtitleDecoder dvbDecoder;
        char c = 1;
        this.f5803A = true;
        SubtitleDecoderFactory subtitleDecoderFactory = this.f5814w;
        Format2 format2 = this.f5805C;
        Objects.requireNonNull(format2);
        Objects.requireNonNull((SubtitleDecoderFactory.a) subtitleDecoderFactory);
        String str = format2.f7155w;
        if (str != null) {
            switch (str.hashCode()) {
                case -1351681404:
                    c = !str.equals("application/dvbsubs") ? (char) 65535 : (char) 0;
                    break;
                case -1248334819:
                    if (!str.equals("application/pgs")) {
                    }
                    break;
                case -1026075066:
                    if (str.equals("application/x-mp4-vtt")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1004728940:
                    if (str.equals("text/vtt")) {
                        c = 3;
                        break;
                    }
                    break;
                case 691401887:
                    if (str.equals("application/x-quicktime-tx3g")) {
                        c = 4;
                        break;
                    }
                    break;
                case 822864842:
                    if (str.equals("text/x-ssa")) {
                        c = 5;
                        break;
                    }
                    break;
                case 930165504:
                    if (str.equals("application/x-mp4-cea-608")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1201784583:
                    if (str.equals("text/x-exoplayer-cues")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1566015601:
                    if (str.equals("application/cea-608")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1566016562:
                    if (str.equals("application/cea-708")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1668750253:
                    if (str.equals("application/x-subrip")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 1693976202:
                    if (str.equals("application/ttml+xml")) {
                        c = 11;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    dvbDecoder = new DvbDecoder(format2.f7157y);
                    break;
                case 1:
                    dvbDecoder = new PgsDecoder();
                    break;
                case 2:
                    dvbDecoder = new Mp4WebvttDecoder();
                    break;
                case 3:
                    dvbDecoder = new WebvttDecoder();
                    break;
                case 4:
                    dvbDecoder = new Tx3gDecoder(format2.f7157y);
                    break;
                case 5:
                    dvbDecoder = new SsaDecoder(format2.f7157y);
                    break;
                case 6:
                case '\b':
                    dvbDecoder = new Cea608Decoder(str, format2.f7141O, 16000L);
                    break;
                case 7:
                    dvbDecoder = new ExoplayerCuesDecoder();
                    break;
                case '\t':
                    dvbDecoder = new Cea708Decoder(format2.f7141O, format2.f7157y);
                    break;
                case '\n':
                    dvbDecoder = new SubripDecoder();
                    break;
                case 11:
                    dvbDecoder = new TtmlDecoder();
                    break;
            }
            this.f5806D = dvbDecoder;
            return;
        }
        String strValueOf = String.valueOf(str);
        throw new IllegalArgumentException(strValueOf.length() != 0 ? "Attempted to create decoder for unsupported MIME type: ".concat(strValueOf) : new String("Attempted to create decoder for unsupported MIME type: "));
    }

    /* renamed from: N */
    public final void m2628N() {
        this.f5807E = null;
        this.f5810H = -1;
        SubtitleOutputBuffer subtitleOutputBuffer = this.f5808F;
        if (subtitleOutputBuffer != null) {
            subtitleOutputBuffer.mo2611p();
            this.f5808F = null;
        }
        SubtitleOutputBuffer subtitleOutputBuffer2 = this.f5809G;
        if (subtitleOutputBuffer2 != null) {
            subtitleOutputBuffer2.mo2611p();
            this.f5809G = null;
        }
    }

    /* renamed from: O */
    public final void m2629O() {
        m2628N();
        SubtitleDecoder subtitleDecoder = this.f5806D;
        Objects.requireNonNull(subtitleDecoder);
        subtitleDecoder.release();
        this.f5806D = null;
        this.f5804B = 0;
        m2627M();
    }

    @Override // p007b.p225i.p226a.p242c.RendererCapabilities
    /* renamed from: a */
    public int mo2630a(Format2 format2) {
        Objects.requireNonNull((SubtitleDecoderFactory.a) this.f5814w);
        String str = format2.f7155w;
        if ("text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str) || "text/x-exoplayer-cues".equals(str)) {
            return (format2.f7142P == 0 ? 4 : 2) | 0 | 0;
        }
        return MimeTypes.m3051i(format2.f7155w) ? 1 : 0;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: b */
    public boolean mo2631b() {
        return this.f5817z;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: d */
    public boolean mo2632d() {
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2, p007b.p225i.p226a.p242c.RendererCapabilities
    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        this.f5813v.mo2620e((List) message.obj);
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: q */
    public void mo2633q(long j, long j2) throws DecoderException {
        boolean z2;
        if (this.f7898s) {
            long j3 = this.f5811I;
            if (j3 != -9223372036854775807L && j >= j3) {
                m2628N();
                this.f5817z = true;
            }
        }
        if (this.f5817z) {
            return;
        }
        if (this.f5809G == null) {
            SubtitleDecoder subtitleDecoder = this.f5806D;
            Objects.requireNonNull(subtitleDecoder);
            subtitleDecoder.mo2607a(j);
            try {
                SubtitleDecoder subtitleDecoder2 = this.f5806D;
                Objects.requireNonNull(subtitleDecoder2);
                this.f5809G = subtitleDecoder2.mo2608b();
            } catch (SubtitleDecoderException e) {
                m2626L(e);
                return;
            }
        }
        if (this.f7893n != 2) {
            return;
        }
        if (this.f5808F != null) {
            long jM2625K = m2625K();
            z2 = false;
            while (jM2625K <= j) {
                this.f5810H++;
                jM2625K = m2625K();
                z2 = true;
            }
        } else {
            z2 = false;
        }
        SubtitleOutputBuffer subtitleOutputBuffer = this.f5809G;
        if (subtitleOutputBuffer != null) {
            if (subtitleOutputBuffer.m3555n()) {
                if (!z2 && m2625K() == RecyclerView.FOREVER_NS) {
                    if (this.f5804B == 2) {
                        m2629O();
                    } else {
                        m2628N();
                        this.f5817z = true;
                    }
                }
            } else if (subtitleOutputBuffer.f7925k <= j) {
                SubtitleOutputBuffer subtitleOutputBuffer2 = this.f5808F;
                if (subtitleOutputBuffer2 != null) {
                    subtitleOutputBuffer2.mo2611p();
                }
                Subtitle subtitle = subtitleOutputBuffer.f5801l;
                Objects.requireNonNull(subtitle);
                this.f5810H = subtitle.mo2612f(j - subtitleOutputBuffer.f5802m);
                this.f5808F = subtitleOutputBuffer;
                this.f5809G = null;
                z2 = true;
            }
        }
        if (z2) {
            Objects.requireNonNull(this.f5808F);
            SubtitleOutputBuffer subtitleOutputBuffer3 = this.f5808F;
            Subtitle subtitle2 = subtitleOutputBuffer3.f5801l;
            Objects.requireNonNull(subtitle2);
            List<Cue> listMo2614h = subtitle2.mo2614h(j - subtitleOutputBuffer3.f5802m);
            Handler handler = this.f5812u;
            if (handler != null) {
                handler.obtainMessage(0, listMo2614h).sendToTarget();
            } else {
                this.f5813v.mo2620e(listMo2614h);
            }
        }
        if (this.f5804B == 2) {
            return;
        }
        while (!this.f5816y) {
            try {
                SubtitleInputBuffer subtitleInputBufferMo2609c = this.f5807E;
                if (subtitleInputBufferMo2609c == null) {
                    SubtitleDecoder subtitleDecoder3 = this.f5806D;
                    Objects.requireNonNull(subtitleDecoder3);
                    subtitleInputBufferMo2609c = subtitleDecoder3.mo2609c();
                    if (subtitleInputBufferMo2609c == null) {
                        return;
                    } else {
                        this.f5807E = subtitleInputBufferMo2609c;
                    }
                }
                if (this.f5804B == 1) {
                    subtitleInputBufferMo2609c.f7901j = 4;
                    SubtitleDecoder subtitleDecoder4 = this.f5806D;
                    Objects.requireNonNull(subtitleDecoder4);
                    subtitleDecoder4.mo2610d(subtitleInputBufferMo2609c);
                    this.f5807E = null;
                    this.f5804B = 2;
                    return;
                }
                int iM3548I = m3548I(this.f5815x, subtitleInputBufferMo2609c, 0);
                if (iM3548I == -4) {
                    if (subtitleInputBufferMo2609c.m3555n()) {
                        this.f5816y = true;
                        this.f5803A = false;
                    } else {
                        Format2 format2 = this.f5815x.f7196b;
                        if (format2 == null) {
                            return;
                        }
                        subtitleInputBufferMo2609c.f5800r = format2.f7127A;
                        subtitleInputBufferMo2609c.m8813s();
                        this.f5803A &= !subtitleInputBufferMo2609c.m3556o();
                    }
                    if (!this.f5803A) {
                        SubtitleDecoder subtitleDecoder5 = this.f5806D;
                        Objects.requireNonNull(subtitleDecoder5);
                        subtitleDecoder5.mo2610d(subtitleInputBufferMo2609c);
                        this.f5807E = null;
                    }
                } else if (iM3548I == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e2) {
                m2626L(e2);
                return;
            }
        }
    }
}

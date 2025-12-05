package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.discord.api.permission.Permission;
import com.discord.restapi.RestAPIAbortCodes;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.PlaybackParameters;
import p007b.p225i.p226a.p242c.Renderer2;
import p007b.p225i.p226a.p242c.p259f3.Log2;
import p007b.p225i.p226a.p242c.p259f3.MimeTypes;
import p007b.p225i.p226a.p242c.p259f3.ParsableBitArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p263t2.Ac3Util;
import p007b.p225i.p226a.p242c.p263t2.Ac4Util;
import p007b.p225i.p226a.p242c.p263t2.AudioAttributes;
import p007b.p225i.p226a.p242c.p263t2.AudioCapabilities;
import p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2;
import p007b.p225i.p226a.p242c.p263t2.AudioTimestampPoller;
import p007b.p225i.p226a.p242c.p263t2.AudioTrackPositionTracker;
import p007b.p225i.p226a.p242c.p263t2.AuxEffectInfo;
import p007b.p225i.p226a.p242c.p263t2.ChannelMappingAudioProcessor;
import p007b.p225i.p226a.p242c.p263t2.ExecutorC2927k;
import p007b.p225i.p226a.p242c.p263t2.FloatResamplingAudioProcessor;
import p007b.p225i.p226a.p242c.p263t2.MediaCodecAudioRenderer;
import p007b.p225i.p226a.p242c.p263t2.MpegAudioUtil;
import p007b.p225i.p226a.p242c.p263t2.ResamplingAudioProcessor;
import p007b.p225i.p226a.p242c.p263t2.RunnableC2911a;
import p007b.p225i.p226a.p242c.p263t2.RunnableC2924h;
import p007b.p225i.p226a.p242c.p263t2.RunnableC2925i;
import p007b.p225i.p226a.p242c.p263t2.SilenceSkippingAudioProcessor;
import p007b.p225i.p226a.p242c.p263t2.SonicAudioProcessor;
import p007b.p225i.p226a.p242c.p263t2.TrimmingAudioProcessor;

/* loaded from: classes3.dex */
public final class DefaultAudioSink implements AudioSink {

    /* renamed from: A */
    public long f19700A;

    /* renamed from: B */
    public long f19701B;

    /* renamed from: C */
    public long f19702C;

    /* renamed from: D */
    public int f19703D;

    /* renamed from: E */
    public boolean f19704E;

    /* renamed from: F */
    public boolean f19705F;

    /* renamed from: G */
    public long f19706G;

    /* renamed from: H */
    public float f19707H;

    /* renamed from: I */
    public AudioProcessor[] f19708I;

    /* renamed from: J */
    public ByteBuffer[] f19709J;

    /* renamed from: K */
    @Nullable
    public ByteBuffer f19710K;

    /* renamed from: L */
    public int f19711L;

    /* renamed from: M */
    @Nullable
    public ByteBuffer f19712M;

    /* renamed from: N */
    public byte[] f19713N;

    /* renamed from: O */
    public int f19714O;

    /* renamed from: P */
    public int f19715P;

    /* renamed from: Q */
    public boolean f19716Q;

    /* renamed from: R */
    public boolean f19717R;

    /* renamed from: S */
    public boolean f19718S;

    /* renamed from: T */
    public boolean f19719T;

    /* renamed from: U */
    public int f19720U;

    /* renamed from: V */
    public AuxEffectInfo f19721V;

    /* renamed from: W */
    public boolean f19722W;

    /* renamed from: X */
    public long f19723X;

    /* renamed from: Y */
    public boolean f19724Y;

    /* renamed from: Z */
    public boolean f19725Z;

    /* renamed from: a */
    @Nullable
    public final AudioCapabilities f19726a;

    /* renamed from: b */
    public final InterfaceC10688b f19727b;

    /* renamed from: c */
    public final boolean f19728c;

    /* renamed from: d */
    public final ChannelMappingAudioProcessor f19729d;

    /* renamed from: e */
    public final TrimmingAudioProcessor f19730e;

    /* renamed from: f */
    public final AudioProcessor[] f19731f;

    /* renamed from: g */
    public final AudioProcessor[] f19732g;

    /* renamed from: h */
    public final ConditionVariable f19733h;

    /* renamed from: i */
    public final AudioTrackPositionTracker f19734i;

    /* renamed from: j */
    public final ArrayDeque<C10691e> f19735j;

    /* renamed from: k */
    public final boolean f19736k;

    /* renamed from: l */
    public final int f19737l;

    /* renamed from: m */
    public C10694h f19738m;

    /* renamed from: n */
    public final C10692f<AudioSink.InitializationException> f19739n;

    /* renamed from: o */
    public final C10692f<AudioSink.WriteException> f19740o;

    /* renamed from: p */
    @Nullable
    public AudioSink.InterfaceC10686a f19741p;

    /* renamed from: q */
    @Nullable
    public C10689c f19742q;

    /* renamed from: r */
    public C10689c f19743r;

    /* renamed from: s */
    @Nullable
    public AudioTrack f19744s;

    /* renamed from: t */
    public AudioAttributes f19745t;

    /* renamed from: u */
    @Nullable
    public C10691e f19746u;

    /* renamed from: v */
    public C10691e f19747v;

    /* renamed from: w */
    public PlaybackParameters f19748w;

    /* renamed from: x */
    @Nullable
    public ByteBuffer f19749x;

    /* renamed from: y */
    public int f19750y;

    /* renamed from: z */
    public long f19751z;

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
    }

    /* renamed from: com.google.android.exoplayer2.audio.DefaultAudioSink$a */
    public class C10687a extends Thread {

        /* renamed from: j */
        public final /* synthetic */ AudioTrack f19752j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10687a(String str, AudioTrack audioTrack) {
            super(str);
            this.f19752j = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.f19752j.flush();
                this.f19752j.release();
            } finally {
                DefaultAudioSink.this.f19733h.open();
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.audio.DefaultAudioSink$b */
    public interface InterfaceC10688b {
        /* renamed from: a */
        PlaybackParameters mo8800a(PlaybackParameters playbackParameters);

        /* renamed from: b */
        long mo8801b(long j);

        /* renamed from: c */
        long mo8802c();

        /* renamed from: d */
        boolean mo8803d(boolean z2);
    }

    /* renamed from: com.google.android.exoplayer2.audio.DefaultAudioSink$c */
    public static final class C10689c {

        /* renamed from: a */
        public final Format2 f19754a;

        /* renamed from: b */
        public final int f19755b;

        /* renamed from: c */
        public final int f19756c;

        /* renamed from: d */
        public final int f19757d;

        /* renamed from: e */
        public final int f19758e;

        /* renamed from: f */
        public final int f19759f;

        /* renamed from: g */
        public final int f19760g;

        /* renamed from: h */
        public final int f19761h;

        /* renamed from: i */
        public final AudioProcessor[] f19762i;

        public C10689c(Format2 format2, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z2, AudioProcessor[] audioProcessorArr) {
            int iRound;
            this.f19754a = format2;
            this.f19755b = i;
            this.f19756c = i2;
            this.f19757d = i3;
            this.f19758e = i4;
            this.f19759f = i5;
            this.f19760g = i6;
            this.f19762i = audioProcessorArr;
            if (i7 != 0) {
                iRound = i7;
            } else {
                if (i2 == 0) {
                    float f = z2 ? 8.0f : 1.0f;
                    int minBufferSize = AudioTrack.getMinBufferSize(i4, i5, i6);
                    AnimatableValueParser.m426D(minBufferSize != -2);
                    long j = i4;
                    int iM3000h = Util2.m3000h(minBufferSize * 4, ((int) ((250000 * j) / 1000000)) * i3, Math.max(minBufferSize, ((int) ((j * 750000) / 1000000)) * i3));
                    iRound = f != 1.0f ? Math.round(iM3000h * f) : iM3000h;
                } else if (i2 == 1) {
                    iRound = m8808e(50000000L);
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException();
                    }
                    iRound = m8808e(250000L);
                }
            }
            this.f19761h = iRound;
        }

        @RequiresApi(21)
        /* renamed from: d */
        public static android.media.AudioAttributes m8804d(AudioAttributes audioAttributes, boolean z2) {
            return z2 ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : audioAttributes.m3494a();
        }

        /* renamed from: a */
        public AudioTrack m8805a(boolean z2, p007b.p225i.p226a.p242c.p263t2.AudioAttributes audioAttributes, int i) throws AudioSink.InitializationException {
            try {
                AudioTrack audioTrackM8806b = m8806b(z2, audioAttributes, i);
                int state = audioTrackM8806b.getState();
                if (state == 1) {
                    return audioTrackM8806b;
                }
                try {
                    audioTrackM8806b.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.f19758e, this.f19759f, this.f19761h, this.f19754a, m8809f(), null);
            } catch (IllegalArgumentException | UnsupportedOperationException e) {
                throw new AudioSink.InitializationException(0, this.f19758e, this.f19759f, this.f19761h, this.f19754a, m8809f(), e);
            }
        }

        /* renamed from: b */
        public final AudioTrack m8806b(boolean z2, p007b.p225i.p226a.p242c.p263t2.AudioAttributes audioAttributes, int i) {
            int i2 = Util2.f6708a;
            if (i2 >= 29) {
                return new AudioTrack.Builder().setAudioAttributes(m8804d(audioAttributes, z2)).setAudioFormat(DefaultAudioSink.m8780y(this.f19758e, this.f19759f, this.f19760g)).setTransferMode(1).setBufferSizeInBytes(this.f19761h).setSessionId(i).setOffloadedPlayback(this.f19756c == 1).build();
            }
            if (i2 >= 21) {
                return new AudioTrack(m8804d(audioAttributes, z2), DefaultAudioSink.m8780y(this.f19758e, this.f19759f, this.f19760g), this.f19761h, 1, i);
            }
            int iM3012t = Util2.m3012t(audioAttributes.f7782m);
            return i == 0 ? new AudioTrack(iM3012t, this.f19758e, this.f19759f, this.f19760g, this.f19761h, 1) : new AudioTrack(iM3012t, this.f19758e, this.f19759f, this.f19760g, this.f19761h, 1, i);
        }

        /* renamed from: c */
        public long m8807c(long j) {
            return (j * 1000000) / this.f19758e;
        }

        /* renamed from: e */
        public final int m8808e(long j) {
            int i;
            int i2 = this.f19760g;
            switch (i2) {
                case 5:
                    i = RestAPIAbortCodes.RELATIONSHIP_INCOMING_DISABLED;
                    break;
                case 6:
                case 18:
                    i = 768000;
                    break;
                case 7:
                    i = 192000;
                    break;
                case 8:
                    i = 2250000;
                    break;
                case 9:
                    i = 40000;
                    break;
                case 10:
                    i = 100000;
                    break;
                case 11:
                    i = 16000;
                    break;
                case 12:
                    i = 7000;
                    break;
                case 13:
                default:
                    throw new IllegalArgumentException();
                case 14:
                    i = 3062500;
                    break;
                case 15:
                    i = 8000;
                    break;
                case 16:
                    i = 256000;
                    break;
                case 17:
                    i = 336000;
                    break;
            }
            if (i2 == 5) {
                i *= 2;
            }
            return (int) ((j * i) / 1000000);
        }

        /* renamed from: f */
        public boolean m8809f() {
            return this.f19756c == 1;
        }
    }

    /* renamed from: com.google.android.exoplayer2.audio.DefaultAudioSink$d */
    public static class C10690d implements InterfaceC10688b {

        /* renamed from: a */
        public final AudioProcessor[] f19763a;

        /* renamed from: b */
        public final SilenceSkippingAudioProcessor f19764b;

        /* renamed from: c */
        public final SonicAudioProcessor f19765c;

        public C10690d(AudioProcessor... audioProcessorArr) {
            SilenceSkippingAudioProcessor silenceSkippingAudioProcessor = new SilenceSkippingAudioProcessor();
            SonicAudioProcessor sonicAudioProcessor = new SonicAudioProcessor();
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 2];
            this.f19763a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.f19764b = silenceSkippingAudioProcessor;
            this.f19765c = sonicAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length] = silenceSkippingAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length + 1] = sonicAudioProcessor;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.InterfaceC10688b
        /* renamed from: a */
        public PlaybackParameters mo8800a(PlaybackParameters playbackParameters) {
            SonicAudioProcessor sonicAudioProcessor = this.f19765c;
            float f = playbackParameters.f8027k;
            if (sonicAudioProcessor.f7728c != f) {
                sonicAudioProcessor.f7728c = f;
                sonicAudioProcessor.f7734i = true;
            }
            float f2 = playbackParameters.f8028l;
            if (sonicAudioProcessor.f7729d != f2) {
                sonicAudioProcessor.f7729d = f2;
                sonicAudioProcessor.f7734i = true;
            }
            return playbackParameters;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.InterfaceC10688b
        /* renamed from: b */
        public long mo8801b(long j) {
            SonicAudioProcessor sonicAudioProcessor = this.f19765c;
            if (sonicAudioProcessor.f7740o < Permission.VIEW_CHANNEL) {
                return (long) (sonicAudioProcessor.f7728c * j);
            }
            long j2 = sonicAudioProcessor.f7739n;
            Objects.requireNonNull(sonicAudioProcessor.f7735j);
            long j3 = j2 - ((r4.f7712k * r4.f7703b) * 2);
            int i = sonicAudioProcessor.f7733h.f19696b;
            int i2 = sonicAudioProcessor.f7732g.f19696b;
            return i == i2 ? Util2.m2985F(j, j3, sonicAudioProcessor.f7740o) : Util2.m2985F(j, j3 * i, sonicAudioProcessor.f7740o * i2);
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.InterfaceC10688b
        /* renamed from: c */
        public long mo8802c() {
            return this.f19764b.f7699t;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.InterfaceC10688b
        /* renamed from: d */
        public boolean mo8803d(boolean z2) {
            this.f19764b.f7692m = z2;
            return z2;
        }
    }

    /* renamed from: com.google.android.exoplayer2.audio.DefaultAudioSink$e */
    public static final class C10691e {

        /* renamed from: a */
        public final PlaybackParameters f19766a;

        /* renamed from: b */
        public final boolean f19767b;

        /* renamed from: c */
        public final long f19768c;

        /* renamed from: d */
        public final long f19769d;

        public C10691e(PlaybackParameters playbackParameters, boolean z2, long j, long j2, C10687a c10687a) {
            this.f19766a = playbackParameters;
            this.f19767b = z2;
            this.f19768c = j;
            this.f19769d = j2;
        }
    }

    /* renamed from: com.google.android.exoplayer2.audio.DefaultAudioSink$f */
    public static final class C10692f<T extends Exception> {

        /* renamed from: a */
        @Nullable
        public T f19770a;

        /* renamed from: b */
        public long f19771b;

        public C10692f(long j) {
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: T extends java.lang.Exception */
        /* renamed from: a */
        public void m8810a(T t) throws Exception {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f19770a == null) {
                this.f19770a = t;
                this.f19771b = 100 + jElapsedRealtime;
            }
            if (jElapsedRealtime >= this.f19771b) {
                T t2 = this.f19770a;
                if (t2 != t) {
                    t2.addSuppressed(t);
                }
                T t3 = this.f19770a;
                this.f19770a = null;
                throw t3;
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.audio.DefaultAudioSink$g */
    public final class C10693g implements AudioTrackPositionTracker.a {
        public C10693g(C10687a c10687a) {
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.AudioTrackPositionTracker.a
        /* renamed from: a */
        public void mo3506a(long j) {
            AudioRendererEventListener2.a aVar;
            Handler handler;
            AudioSink.InterfaceC10686a interfaceC10686a = DefaultAudioSink.this.f19741p;
            if (interfaceC10686a == null || (handler = (aVar = MediaCodecAudioRenderer.this.f7851O0).f7790a) == null) {
                return;
            }
            handler.post(new RunnableC2924h(aVar, j));
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.AudioTrackPositionTracker.a
        /* renamed from: b */
        public void mo3507b(int i, long j) {
            if (DefaultAudioSink.this.f19741p != null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                DefaultAudioSink defaultAudioSink = DefaultAudioSink.this;
                long j2 = jElapsedRealtime - defaultAudioSink.f19723X;
                AudioRendererEventListener2.a aVar = MediaCodecAudioRenderer.this.f7851O0;
                Handler handler = aVar.f7790a;
                if (handler != null) {
                    handler.post(new RunnableC2925i(aVar, i, j, j2));
                }
            }
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.AudioTrackPositionTracker.a
        /* renamed from: c */
        public void mo3508c(long j) {
            StringBuilder sb = new StringBuilder(61);
            sb.append("Ignoring impossibly large audio latency: ");
            sb.append(j);
            Log.w("DefaultAudioSink", sb.toString());
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.AudioTrackPositionTracker.a
        /* renamed from: d */
        public void mo3509d(long j, long j2, long j3, long j4) {
            DefaultAudioSink defaultAudioSink = DefaultAudioSink.this;
            long j5 = defaultAudioSink.f19743r.f19756c == 0 ? defaultAudioSink.f19751z / r1.f19755b : defaultAudioSink.f19700A;
            long jM8784E = defaultAudioSink.m8784E();
            StringBuilder sbM830R = outline.m830R(Opcodes.INVOKEVIRTUAL, "Spurious audio timestamp (frame position mismatch): ", j, ", ");
            sbM830R.append(j2);
            sbM830R.append(", ");
            sbM830R.append(j3);
            sbM830R.append(", ");
            sbM830R.append(j4);
            sbM830R.append(", ");
            sbM830R.append(j5);
            sbM830R.append(", ");
            sbM830R.append(jM8784E);
            Log.w("DefaultAudioSink", sbM830R.toString());
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.AudioTrackPositionTracker.a
        /* renamed from: e */
        public void mo3510e(long j, long j2, long j3, long j4) {
            DefaultAudioSink defaultAudioSink = DefaultAudioSink.this;
            long j5 = defaultAudioSink.f19743r.f19756c == 0 ? defaultAudioSink.f19751z / r1.f19755b : defaultAudioSink.f19700A;
            long jM8784E = defaultAudioSink.m8784E();
            StringBuilder sbM830R = outline.m830R(180, "Spurious audio timestamp (system clock mismatch): ", j, ", ");
            sbM830R.append(j2);
            sbM830R.append(", ");
            sbM830R.append(j3);
            sbM830R.append(", ");
            sbM830R.append(j4);
            sbM830R.append(", ");
            sbM830R.append(j5);
            sbM830R.append(", ");
            sbM830R.append(jM8784E);
            Log.w("DefaultAudioSink", sbM830R.toString());
        }
    }

    @RequiresApi(29)
    /* renamed from: com.google.android.exoplayer2.audio.DefaultAudioSink$h */
    public final class C10694h {

        /* renamed from: a */
        public final Handler f19773a = new Handler();

        /* renamed from: b */
        public final AudioTrack.StreamEventCallback f19774b;

        /* renamed from: com.google.android.exoplayer2.audio.DefaultAudioSink$h$a */
        public class a extends AudioTrack.StreamEventCallback {
            public a(DefaultAudioSink defaultAudioSink) {
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onDataRequest(AudioTrack audioTrack, int i) {
                Renderer2.a aVar;
                AnimatableValueParser.m426D(audioTrack == DefaultAudioSink.this.f19744s);
                DefaultAudioSink defaultAudioSink = DefaultAudioSink.this;
                AudioSink.InterfaceC10686a interfaceC10686a = defaultAudioSink.f19741p;
                if (interfaceC10686a == null || !defaultAudioSink.f19718S || (aVar = MediaCodecAudioRenderer.this.f7860X0) == null) {
                    return;
                }
                aVar.mo2947a();
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onTearDown(AudioTrack audioTrack) {
                Renderer2.a aVar;
                AnimatableValueParser.m426D(audioTrack == DefaultAudioSink.this.f19744s);
                DefaultAudioSink defaultAudioSink = DefaultAudioSink.this;
                AudioSink.InterfaceC10686a interfaceC10686a = defaultAudioSink.f19741p;
                if (interfaceC10686a == null || !defaultAudioSink.f19718S || (aVar = MediaCodecAudioRenderer.this.f7860X0) == null) {
                    return;
                }
                aVar.mo2947a();
            }
        }

        public C10694h() {
            this.f19774b = new a(DefaultAudioSink.this);
        }
    }

    public DefaultAudioSink(@Nullable AudioCapabilities audioCapabilities, InterfaceC10688b interfaceC10688b, boolean z2, boolean z3, int i) {
        this.f19726a = audioCapabilities;
        this.f19727b = interfaceC10688b;
        int i2 = Util2.f6708a;
        this.f19728c = i2 >= 21 && z2;
        this.f19736k = i2 >= 23 && z3;
        this.f19737l = i2 < 29 ? 0 : i;
        this.f19733h = new ConditionVariable(true);
        this.f19734i = new AudioTrackPositionTracker(new C10693g(null));
        ChannelMappingAudioProcessor channelMappingAudioProcessor = new ChannelMappingAudioProcessor();
        this.f19729d = channelMappingAudioProcessor;
        TrimmingAudioProcessor trimmingAudioProcessor = new TrimmingAudioProcessor();
        this.f19730e = trimmingAudioProcessor;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new ResamplingAudioProcessor(), channelMappingAudioProcessor, trimmingAudioProcessor);
        Collections.addAll(arrayList, ((C10690d) interfaceC10688b).f19763a);
        this.f19731f = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[0]);
        this.f19732g = new AudioProcessor[]{new FloatResamplingAudioProcessor()};
        this.f19707H = 1.0f;
        this.f19745t = p007b.p225i.p226a.p242c.p263t2.AudioAttributes.f7779j;
        this.f19720U = 0;
        this.f19721V = new AuxEffectInfo(0, 0.0f);
        PlaybackParameters playbackParameters = PlaybackParameters.f8026j;
        this.f19747v = new C10691e(playbackParameters, false, 0L, 0L, null);
        this.f19748w = playbackParameters;
        this.f19715P = -1;
        this.f19708I = new AudioProcessor[0];
        this.f19709J = new ByteBuffer[0];
        this.f19735j = new ArrayDeque<>();
        this.f19739n = new C10692f<>(100L);
        this.f19740o = new C10692f<>(100L);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00b5  */
    @Nullable
    /* renamed from: A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Integer> m8778A(Format2 format2, @Nullable AudioCapabilities audioCapabilities) {
        if (audioCapabilities == null) {
            return null;
        }
        String str = format2.f7155w;
        Objects.requireNonNull(str);
        int iM3044b = MimeTypes.m3044b(str, format2.f7152t);
        int i = 0;
        int i2 = 6;
        if (!(iM3044b == 5 || iM3044b == 6 || iM3044b == 18 || iM3044b == 17 || iM3044b == 7 || iM3044b == 8 || iM3044b == 14)) {
            return null;
        }
        if (iM3044b == 18 && !audioCapabilities.m3495a(18)) {
            iM3044b = 6;
        } else if (iM3044b == 8 && !audioCapabilities.m3495a(8)) {
            iM3044b = 7;
        }
        if (!audioCapabilities.m3495a(iM3044b)) {
            return null;
        }
        if (iM3044b != 18) {
            i = format2.f7136J;
            if (i > audioCapabilities.f7789e) {
                return null;
            }
        } else if (Util2.f6708a >= 29) {
            int i3 = format2.f7137K;
            android.media.AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(1).setContentType(3).build();
            int i4 = 8;
            while (true) {
                if (i4 <= 0) {
                    break;
                }
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(18).setSampleRate(i3).setChannelMask(Util2.m3006n(i4)).build(), audioAttributesBuild)) {
                    i = i4;
                    break;
                }
                i4--;
            }
            if (i == 0) {
                Log.w("DefaultAudioSink", "E-AC3 JOC encoding supported but no channel count supported");
                return null;
            }
        } else {
            i = 6;
        }
        int i5 = Util2.f6708a;
        if (i5 > 28) {
            i2 = i;
        } else if (i == 7) {
            i2 = 8;
        } else if (i != 3 && i != 4 && i != 5) {
        }
        if (i5 <= 26 && "fugu".equals(Util2.f6709b) && i2 == 1) {
            i2 = 2;
        }
        int iM3006n = Util2.m3006n(i2);
        if (iM3006n == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(iM3044b), Integer.valueOf(iM3006n));
    }

    /* renamed from: H */
    public static boolean m8779H(AudioTrack audioTrack) {
        return Util2.f6708a >= 29 && audioTrack.isOffloadedPlayback();
    }

    @RequiresApi(21)
    /* renamed from: y */
    public static AudioFormat m8780y(int i, int i2, int i3) {
        return new AudioFormat.Builder().setSampleRate(i).setChannelMask(i2).setEncoding(i3).build();
    }

    /* renamed from: B */
    public final C10691e m8781B() {
        C10691e c10691e = this.f19746u;
        return c10691e != null ? c10691e : !this.f19735j.isEmpty() ? this.f19735j.getLast() : this.f19747v;
    }

    @RequiresApi(29)
    @SuppressLint({"WrongConstant"})
    /* renamed from: C */
    public final int m8782C(AudioFormat audioFormat, android.media.AudioAttributes audioAttributes) {
        int i = Util2.f6708a;
        if (i >= 31) {
            return AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        }
        if (AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return (i == 30 && Util2.f6711d.startsWith("Pixel")) ? 2 : 1;
        }
        return 0;
    }

    /* renamed from: D */
    public boolean m8783D() {
        return m8781B().f19767b;
    }

    /* renamed from: E */
    public final long m8784E() {
        return this.f19743r.f19756c == 0 ? this.f19701B / r0.f19757d : this.f19702C;
    }

    /* renamed from: F */
    public final void m8785F() throws AudioSink.InitializationException {
        this.f19733h.block();
        try {
            C10689c c10689c = this.f19743r;
            Objects.requireNonNull(c10689c);
            AudioTrack audioTrackM8805a = c10689c.m8805a(this.f19722W, this.f19745t, this.f19720U);
            this.f19744s = audioTrackM8805a;
            if (m8779H(audioTrackM8805a)) {
                AudioTrack audioTrack = this.f19744s;
                if (this.f19738m == null) {
                    this.f19738m = new C10694h();
                }
                C10694h c10694h = this.f19738m;
                Handler handler = c10694h.f19773a;
                Objects.requireNonNull(handler);
                audioTrack.registerStreamEventCallback(new ExecutorC2927k(handler), c10694h.f19774b);
                if (this.f19737l != 3) {
                    AudioTrack audioTrack2 = this.f19744s;
                    Format2 format2 = this.f19743r.f19754a;
                    audioTrack2.setOffloadDelayPadding(format2.f7139M, format2.f7140N);
                }
            }
            this.f19720U = this.f19744s.getAudioSessionId();
            AudioTrackPositionTracker audioTrackPositionTracker = this.f19734i;
            AudioTrack audioTrack3 = this.f19744s;
            C10689c c10689c2 = this.f19743r;
            audioTrackPositionTracker.m3505e(audioTrack3, c10689c2.f19756c == 2, c10689c2.f19760g, c10689c2.f19757d, c10689c2.f19761h);
            m8792N();
            int i = this.f19721V.f7835a;
            if (i != 0) {
                this.f19744s.attachAuxEffect(i);
                this.f19744s.setAuxEffectSendLevel(this.f19721V.f7836b);
            }
            this.f19705F = true;
        } catch (AudioSink.InitializationException e) {
            if (this.f19743r.m8809f()) {
                this.f19724Y = true;
            }
            AudioSink.InterfaceC10686a interfaceC10686a = this.f19741p;
            if (interfaceC10686a != null) {
                ((MediaCodecAudioRenderer.b) interfaceC10686a).m3517a(e);
            }
            throw e;
        }
    }

    /* renamed from: G */
    public final boolean m8786G() {
        return this.f19744s != null;
    }

    /* renamed from: I */
    public final void m8787I() throws IllegalStateException {
        if (this.f19717R) {
            return;
        }
        this.f19717R = true;
        AudioTrackPositionTracker audioTrackPositionTracker = this.f19734i;
        long jM8784E = m8784E();
        audioTrackPositionTracker.f7834z = audioTrackPositionTracker.m3502b();
        audioTrackPositionTracker.f7832x = SystemClock.elapsedRealtime() * 1000;
        audioTrackPositionTracker.f7803A = jM8784E;
        this.f19744s.stop();
        this.f19750y = 0;
    }

    /* renamed from: J */
    public final void m8788J(long j) throws Exception {
        ByteBuffer byteBuffer;
        int length = this.f19708I.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.f19709J[i - 1];
            } else {
                byteBuffer = this.f19710K;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.f19694a;
                }
            }
            if (i == length) {
                m8795Q(byteBuffer, j);
            } else {
                AudioProcessor audioProcessor = this.f19708I[i];
                if (i > this.f19715P) {
                    audioProcessor.mo3470c(byteBuffer);
                }
                ByteBuffer output = audioProcessor.getOutput();
                this.f19709J[i] = output;
                if (output.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    /* renamed from: K */
    public final void m8789K() {
        this.f19751z = 0L;
        this.f19700A = 0L;
        this.f19701B = 0L;
        this.f19702C = 0L;
        this.f19725Z = false;
        this.f19703D = 0;
        this.f19747v = new C10691e(m8799z(), m8783D(), 0L, 0L, null);
        this.f19706G = 0L;
        this.f19746u = null;
        this.f19735j.clear();
        this.f19710K = null;
        this.f19711L = 0;
        this.f19712M = null;
        this.f19717R = false;
        this.f19716Q = false;
        this.f19715P = -1;
        this.f19749x = null;
        this.f19750y = 0;
        this.f19730e.f7752o = 0L;
        m8798h();
    }

    /* renamed from: L */
    public final void m8790L(PlaybackParameters playbackParameters, boolean z2) {
        C10691e c10691eM8781B = m8781B();
        if (playbackParameters.equals(c10691eM8781B.f19766a) && z2 == c10691eM8781B.f19767b) {
            return;
        }
        C10691e c10691e = new C10691e(playbackParameters, z2, -9223372036854775807L, -9223372036854775807L, null);
        if (m8786G()) {
            this.f19746u = c10691e;
        } else {
            this.f19747v = c10691e;
        }
    }

    @RequiresApi(23)
    /* renamed from: M */
    public final void m8791M(PlaybackParameters playbackParameters) {
        if (m8786G()) {
            try {
                this.f19744s.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(playbackParameters.f8027k).setPitch(playbackParameters.f8028l).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e) {
                Log2.m3040c("DefaultAudioSink", "Failed to set playback params", e);
            }
            playbackParameters = new PlaybackParameters(this.f19744s.getPlaybackParams().getSpeed(), this.f19744s.getPlaybackParams().getPitch());
            AudioTrackPositionTracker audioTrackPositionTracker = this.f19734i;
            audioTrackPositionTracker.f7818j = playbackParameters.f8027k;
            AudioTimestampPoller audioTimestampPoller = audioTrackPositionTracker.f7814f;
            if (audioTimestampPoller != null) {
                audioTimestampPoller.m3499a();
            }
        }
        this.f19748w = playbackParameters;
    }

    /* renamed from: N */
    public final void m8792N() {
        if (m8786G()) {
            if (Util2.f6708a >= 21) {
                this.f19744s.setVolume(this.f19707H);
                return;
            }
            AudioTrack audioTrack = this.f19744s;
            float f = this.f19707H;
            audioTrack.setStereoVolume(f, f);
        }
    }

    /* renamed from: O */
    public final boolean m8793O() {
        if (this.f19722W || !"audio/raw".equals(this.f19743r.f19754a.f7155w)) {
            return false;
        }
        return !(this.f19728c && Util2.m3017y(this.f19743r.f19754a.f7138L));
    }

    /* renamed from: P */
    public final boolean m8794P(Format2 format2, p007b.p225i.p226a.p242c.p263t2.AudioAttributes audioAttributes) {
        int iM3006n;
        int iM8782C;
        if (Util2.f6708a < 29 || this.f19737l == 0) {
            return false;
        }
        String str = format2.f7155w;
        Objects.requireNonNull(str);
        int iM3044b = MimeTypes.m3044b(str, format2.f7152t);
        if (iM3044b == 0 || (iM3006n = Util2.m3006n(format2.f7136J)) == 0 || (iM8782C = m8782C(m8780y(format2.f7137K, iM3006n, iM3044b), audioAttributes.m3494a())) == 0) {
            return false;
        }
        if (iM8782C == 1) {
            return ((format2.f7139M != 0 || format2.f7140N != 0) && (this.f19737l == 1)) ? false : true;
        }
        if (iM8782C == 2) {
            return true;
        }
        throw new IllegalStateException();
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e6  */
    /* renamed from: Q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m8795Q(ByteBuffer byteBuffer, long j) throws Exception {
        int iWrite;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.f19712M;
            if (byteBuffer2 != null) {
                AnimatableValueParser.m531j(byteBuffer2 == byteBuffer);
            } else {
                this.f19712M = byteBuffer;
                if (Util2.f6708a < 21) {
                    int iRemaining = byteBuffer.remaining();
                    byte[] bArr = this.f19713N;
                    if (bArr == null || bArr.length < iRemaining) {
                        this.f19713N = new byte[iRemaining];
                    }
                    int iPosition = byteBuffer.position();
                    byteBuffer.get(this.f19713N, 0, iRemaining);
                    byteBuffer.position(iPosition);
                    this.f19714O = 0;
                }
            }
            int iRemaining2 = byteBuffer.remaining();
            int i = Util2.f6708a;
            if (i < 21) {
                AudioTrackPositionTracker audioTrackPositionTracker = this.f19734i;
                int iM3502b = audioTrackPositionTracker.f7813e - ((int) (this.f19701B - (audioTrackPositionTracker.m3502b() * audioTrackPositionTracker.f7812d)));
                if (iM3502b > 0) {
                    iWrite = this.f19744s.write(this.f19713N, this.f19714O, Math.min(iRemaining2, iM3502b));
                    if (iWrite > 0) {
                        this.f19714O += iWrite;
                        byteBuffer.position(byteBuffer.position() + iWrite);
                    }
                } else {
                    iWrite = 0;
                }
            } else if (this.f19722W) {
                AnimatableValueParser.m426D(j != -9223372036854775807L);
                AudioTrack audioTrack = this.f19744s;
                if (i >= 26) {
                    iWrite = audioTrack.write(byteBuffer, iRemaining2, 1, j * 1000);
                } else {
                    if (this.f19749x == null) {
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
                        this.f19749x = byteBufferAllocate;
                        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
                        this.f19749x.putInt(1431633921);
                    }
                    if (this.f19750y == 0) {
                        this.f19749x.putInt(4, iRemaining2);
                        this.f19749x.putLong(8, j * 1000);
                        this.f19749x.position(0);
                        this.f19750y = iRemaining2;
                    }
                    int iRemaining3 = this.f19749x.remaining();
                    if (iRemaining3 <= 0) {
                        iWrite = audioTrack.write(byteBuffer, iRemaining2, 1);
                        if (iWrite < 0) {
                            this.f19750y = 0;
                        } else {
                            this.f19750y -= iWrite;
                        }
                    } else {
                        int iWrite2 = audioTrack.write(this.f19749x, iRemaining3, 1);
                        if (iWrite2 < 0) {
                            this.f19750y = 0;
                            iWrite = iWrite2;
                        } else if (iWrite2 < iRemaining3) {
                        }
                    }
                }
            } else {
                iWrite = this.f19744s.write(byteBuffer, iRemaining2, 1);
            }
            this.f19723X = SystemClock.elapsedRealtime();
            if (iWrite < 0) {
                boolean z2 = (i >= 24 && iWrite == -6) || iWrite == -32;
                if (z2 && this.f19743r.m8809f()) {
                    this.f19724Y = true;
                }
                AudioSink.WriteException writeException = new AudioSink.WriteException(iWrite, this.f19743r.f19754a, z2);
                AudioSink.InterfaceC10686a interfaceC10686a = this.f19741p;
                if (interfaceC10686a != null) {
                    ((MediaCodecAudioRenderer.b) interfaceC10686a).m3517a(writeException);
                }
                if (writeException.isRecoverable) {
                    throw writeException;
                }
                this.f19740o.m8810a(writeException);
                return;
            }
            this.f19740o.f19770a = null;
            if (m8779H(this.f19744s)) {
                long j2 = this.f19702C;
                if (j2 > 0) {
                    this.f19725Z = false;
                }
                if (this.f19718S && this.f19741p != null && iWrite < iRemaining2 && !this.f19725Z) {
                    AudioTrackPositionTracker audioTrackPositionTracker2 = this.f19734i;
                    long jM2992M = Util2.m2992M(audioTrackPositionTracker2.m3501a(j2 - audioTrackPositionTracker2.m3502b()));
                    Renderer2.a aVar = MediaCodecAudioRenderer.this.f7860X0;
                    if (aVar != null) {
                        aVar.mo2948b(jM2992M);
                    }
                }
            }
            int i2 = this.f19743r.f19756c;
            if (i2 == 0) {
                this.f19701B += iWrite;
            }
            if (iWrite == iRemaining2) {
                if (i2 != 0) {
                    AnimatableValueParser.m426D(byteBuffer == this.f19710K);
                    this.f19702C += this.f19703D * this.f19711L;
                }
                this.f19712M = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: a */
    public boolean mo8757a(Format2 format2) {
        return mo8774u(format2) != 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: b */
    public boolean mo8758b() {
        return !m8786G() || (this.f19716Q && !mo8764k());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: c */
    public PlaybackParameters mo8759c() {
        return this.f19736k ? this.f19748w : m8799z();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: d */
    public void mo8760d() throws IllegalStateException {
        boolean z2 = false;
        this.f19718S = false;
        if (m8786G()) {
            AudioTrackPositionTracker audioTrackPositionTracker = this.f19734i;
            audioTrackPositionTracker.f7820l = 0L;
            audioTrackPositionTracker.f7831w = 0;
            audioTrackPositionTracker.f7830v = 0;
            audioTrackPositionTracker.f7821m = 0L;
            audioTrackPositionTracker.f7805C = 0L;
            audioTrackPositionTracker.f7808F = 0L;
            audioTrackPositionTracker.f7819k = false;
            if (audioTrackPositionTracker.f7832x == -9223372036854775807L) {
                AudioTimestampPoller audioTimestampPoller = audioTrackPositionTracker.f7814f;
                Objects.requireNonNull(audioTimestampPoller);
                audioTimestampPoller.m3499a();
                z2 = true;
            }
            if (z2) {
                this.f19744s.pause();
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: e */
    public void mo8761e() throws IllegalStateException {
        this.f19718S = true;
        if (m8786G()) {
            AudioTimestampPoller audioTimestampPoller = this.f19734i.f7814f;
            Objects.requireNonNull(audioTimestampPoller);
            audioTimestampPoller.m3499a();
            this.f19744s.play();
        }
    }

    /* renamed from: f */
    public final void m8796f(long j) {
        AudioRendererEventListener2.a aVar;
        Handler handler;
        PlaybackParameters playbackParametersMo8800a = m8793O() ? this.f19727b.mo8800a(m8799z()) : PlaybackParameters.f8026j;
        boolean zMo8803d = m8793O() ? this.f19727b.mo8803d(m8783D()) : false;
        this.f19735j.add(new C10691e(playbackParametersMo8800a, zMo8803d, Math.max(0L, j), this.f19743r.m8807c(m8784E()), null));
        AudioProcessor[] audioProcessorArr = this.f19743r.f19762i;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : audioProcessorArr) {
            if (audioProcessor.mo3472a()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.f19708I = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.f19709J = new ByteBuffer[size];
        m8798h();
        AudioSink.InterfaceC10686a interfaceC10686a = this.f19741p;
        if (interfaceC10686a == null || (handler = (aVar = MediaCodecAudioRenderer.this.f7851O0).f7790a) == null) {
            return;
        }
        handler.post(new RunnableC2911a(aVar, zMo8803d));
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void flush() throws IllegalStateException {
        if (m8786G()) {
            m8789K();
            AudioTrack audioTrack = this.f19734i.f7811c;
            Objects.requireNonNull(audioTrack);
            if (audioTrack.getPlayState() == 3) {
                this.f19744s.pause();
            }
            if (m8779H(this.f19744s)) {
                C10694h c10694h = this.f19738m;
                Objects.requireNonNull(c10694h);
                this.f19744s.unregisterStreamEventCallback(c10694h.f19774b);
                c10694h.f19773a.removeCallbacksAndMessages(null);
            }
            AudioTrack audioTrack2 = this.f19744s;
            this.f19744s = null;
            if (Util2.f6708a < 21 && !this.f19719T) {
                this.f19720U = 0;
            }
            C10689c c10689c = this.f19742q;
            if (c10689c != null) {
                this.f19743r = c10689c;
                this.f19742q = null;
            }
            this.f19734i.m3504d();
            this.f19733h.close();
            new C10687a("ExoPlayer:AudioTrackReleaseThread", audioTrack2).start();
        }
        this.f19740o.f19770a = null;
        this.f19739n.f19770a = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0029 -> B:5:0x0009). Please report as a decompilation issue!!! */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m8797g() throws Exception {
        boolean z2;
        int i;
        AudioProcessor[] audioProcessorArr;
        if (this.f19715P == -1) {
            this.f19715P = 0;
            z2 = true;
            i = this.f19715P;
            audioProcessorArr = this.f19708I;
            if (i < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i];
                if (z2) {
                    audioProcessor.mo3487e();
                }
                m8788J(-9223372036854775807L);
                if (!audioProcessor.mo3485b()) {
                    return false;
                }
                this.f19715P++;
                z2 = true;
                i = this.f19715P;
                audioProcessorArr = this.f19708I;
                if (i < audioProcessorArr.length) {
                    ByteBuffer byteBuffer = this.f19712M;
                    if (byteBuffer != null) {
                        m8795Q(byteBuffer, -9223372036854775807L);
                        if (this.f19712M != null) {
                            return false;
                        }
                    }
                    this.f19715P = -1;
                    return true;
                }
            }
        } else {
            z2 = false;
            i = this.f19715P;
            audioProcessorArr = this.f19708I;
            if (i < audioProcessorArr.length) {
            }
        }
    }

    /* renamed from: h */
    public final void m8798h() {
        int i = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.f19708I;
            if (i >= audioProcessorArr.length) {
                return;
            }
            AudioProcessor audioProcessor = audioProcessorArr[i];
            audioProcessor.flush();
            this.f19709J[i] = audioProcessor.getOutput();
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: i */
    public void mo8762i(PlaybackParameters playbackParameters) {
        PlaybackParameters playbackParameters2 = new PlaybackParameters(Util2.m2999g(playbackParameters.f8027k, 0.1f, 8.0f), Util2.m2999g(playbackParameters.f8028l, 0.1f, 8.0f));
        if (!this.f19736k || Util2.f6708a < 23) {
            m8790L(playbackParameters2, m8783D());
        } else {
            m8791M(playbackParameters2);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: j */
    public void mo8763j() throws IllegalStateException, AudioSink.WriteException {
        if (!this.f19716Q && m8786G() && m8797g()) {
            m8787I();
            this.f19716Q = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: k */
    public boolean mo8764k() {
        return m8786G() && this.f19734i.m3503c(m8784E());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: l */
    public void mo8765l(int i) throws IllegalStateException {
        if (this.f19720U != i) {
            this.f19720U = i;
            this.f19719T = i != 0;
            flush();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ab A[Catch: Exception -> 0x01b5, TRY_LEAVE, TryCatch #0 {Exception -> 0x01b5, blocks: (B:86:0x0181, B:88:0x01ab), top: B:144:0x0181 }] */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long mo8766m(boolean z2) {
        long jM3501a;
        long jM3009q;
        boolean timestamp;
        Method method;
        long jMax;
        if (!m8786G() || this.f19705F) {
            return Long.MIN_VALUE;
        }
        AudioTrackPositionTracker audioTrackPositionTracker = this.f19734i;
        AudioTrack audioTrack = audioTrackPositionTracker.f7811c;
        Objects.requireNonNull(audioTrack);
        if (audioTrack.getPlayState() == 3) {
            long jM3501a2 = audioTrackPositionTracker.m3501a(audioTrackPositionTracker.m3502b());
            if (jM3501a2 != 0) {
                long jNanoTime = System.nanoTime() / 1000;
                if (jNanoTime - audioTrackPositionTracker.f7821m >= 30000) {
                    long[] jArr = audioTrackPositionTracker.f7810b;
                    int i = audioTrackPositionTracker.f7830v;
                    jArr[i] = jM3501a2 - jNanoTime;
                    audioTrackPositionTracker.f7830v = (i + 1) % 10;
                    int i2 = audioTrackPositionTracker.f7831w;
                    if (i2 < 10) {
                        audioTrackPositionTracker.f7831w = i2 + 1;
                    }
                    audioTrackPositionTracker.f7821m = jNanoTime;
                    audioTrackPositionTracker.f7820l = 0L;
                    int i3 = 0;
                    while (true) {
                        int i4 = audioTrackPositionTracker.f7831w;
                        if (i3 >= i4) {
                            break;
                        }
                        audioTrackPositionTracker.f7820l = (audioTrackPositionTracker.f7810b[i3] / i4) + audioTrackPositionTracker.f7820l;
                        i3++;
                    }
                }
                if (!audioTrackPositionTracker.f7816h) {
                    AudioTimestampPoller audioTimestampPoller = audioTrackPositionTracker.f7814f;
                    Objects.requireNonNull(audioTimestampPoller);
                    AudioTimestampPoller.a aVar = audioTimestampPoller.f7792a;
                    if (aVar == null || jNanoTime - audioTimestampPoller.f7796e < audioTimestampPoller.f7795d) {
                        timestamp = false;
                        if (timestamp) {
                            AudioTimestampPoller.a aVar2 = audioTimestampPoller.f7792a;
                            long j = aVar2 != null ? aVar2.f7799b.nanoTime / 1000 : -9223372036854775807L;
                            long j2 = aVar2 != null ? aVar2.f7802e : -1L;
                            if (Math.abs(j - jNanoTime) > 5000000) {
                                audioTrackPositionTracker.f7809a.mo3510e(j2, j, jNanoTime, jM3501a2);
                                audioTimestampPoller.m3500b(4);
                            } else if (Math.abs(audioTrackPositionTracker.m3501a(j2) - jM3501a2) > 5000000) {
                                audioTrackPositionTracker.f7809a.mo3509d(j2, j, jNanoTime, jM3501a2);
                                audioTimestampPoller.m3500b(4);
                            } else if (audioTimestampPoller.f7793b == 4) {
                                audioTimestampPoller.m3499a();
                            }
                        }
                        if (audioTrackPositionTracker.f7825q && (method = audioTrackPositionTracker.f7822n) != null && jNanoTime - audioTrackPositionTracker.f7826r >= 500000) {
                            try {
                                AudioTrack audioTrack2 = audioTrackPositionTracker.f7811c;
                                Objects.requireNonNull(audioTrack2);
                                Integer num = (Integer) method.invoke(audioTrack2, new Object[0]);
                                int i5 = Util2.f6708a;
                                long jIntValue = (num.intValue() * 1000) - audioTrackPositionTracker.f7817i;
                                audioTrackPositionTracker.f7823o = jIntValue;
                                jMax = Math.max(jIntValue, 0L);
                                audioTrackPositionTracker.f7823o = jMax;
                                if (jMax > 5000000) {
                                    audioTrackPositionTracker.f7809a.mo3508c(jMax);
                                    audioTrackPositionTracker.f7823o = 0L;
                                }
                            } catch (Exception unused) {
                                audioTrackPositionTracker.f7822n = null;
                            }
                            audioTrackPositionTracker.f7826r = jNanoTime;
                        }
                    } else {
                        audioTimestampPoller.f7796e = jNanoTime;
                        timestamp = aVar.f7798a.getTimestamp(aVar.f7799b);
                        if (timestamp) {
                            long j3 = aVar.f7799b.framePosition;
                            if (aVar.f7801d > j3) {
                                aVar.f7800c++;
                            }
                            aVar.f7801d = j3;
                            aVar.f7802e = j3 + (aVar.f7800c << 32);
                        }
                        int i6 = audioTimestampPoller.f7793b;
                        if (i6 != 0) {
                            if (i6 != 1) {
                                if (i6 != 2) {
                                    if (i6 != 3) {
                                        if (i6 != 4) {
                                            throw new IllegalStateException();
                                        }
                                    } else if (timestamp) {
                                        audioTimestampPoller.m3499a();
                                    }
                                } else if (!timestamp) {
                                    audioTimestampPoller.m3499a();
                                }
                            } else if (!timestamp) {
                                audioTimestampPoller.m3499a();
                            } else if (audioTimestampPoller.f7792a.f7802e > audioTimestampPoller.f7797f) {
                                audioTimestampPoller.m3500b(2);
                            }
                        } else if (timestamp) {
                            AudioTimestampPoller.a aVar3 = audioTimestampPoller.f7792a;
                            if (aVar3.f7799b.nanoTime / 1000 >= audioTimestampPoller.f7794c) {
                                audioTimestampPoller.f7797f = aVar3.f7802e;
                                audioTimestampPoller.m3500b(1);
                            }
                        } else if (jNanoTime - audioTimestampPoller.f7794c > 500000) {
                            audioTimestampPoller.m3500b(3);
                        }
                        if (timestamp) {
                        }
                        if (audioTrackPositionTracker.f7825q) {
                            AudioTrack audioTrack22 = audioTrackPositionTracker.f7811c;
                            Objects.requireNonNull(audioTrack22);
                            Integer num2 = (Integer) method.invoke(audioTrack22, new Object[0]);
                            int i52 = Util2.f6708a;
                            long jIntValue2 = (num2.intValue() * 1000) - audioTrackPositionTracker.f7817i;
                            audioTrackPositionTracker.f7823o = jIntValue2;
                            jMax = Math.max(jIntValue2, 0L);
                            audioTrackPositionTracker.f7823o = jMax;
                            if (jMax > 5000000) {
                            }
                            audioTrackPositionTracker.f7826r = jNanoTime;
                        }
                    }
                }
            }
        }
        long jNanoTime2 = System.nanoTime() / 1000;
        AudioTimestampPoller audioTimestampPoller2 = audioTrackPositionTracker.f7814f;
        Objects.requireNonNull(audioTimestampPoller2);
        boolean z3 = audioTimestampPoller2.f7793b == 2;
        if (z3) {
            AudioTimestampPoller.a aVar4 = audioTimestampPoller2.f7792a;
            long jM3501a3 = audioTrackPositionTracker.m3501a(aVar4 != null ? aVar4.f7802e : -1L);
            AudioTimestampPoller.a aVar5 = audioTimestampPoller2.f7792a;
            jM3501a = Util2.m3009q(jNanoTime2 - (aVar5 != null ? aVar5.f7799b.nanoTime / 1000 : -9223372036854775807L), audioTrackPositionTracker.f7818j) + jM3501a3;
        } else {
            jM3501a = audioTrackPositionTracker.f7831w == 0 ? audioTrackPositionTracker.m3501a(audioTrackPositionTracker.m3502b()) : audioTrackPositionTracker.f7820l + jNanoTime2;
            if (!z2) {
                jM3501a = Math.max(0L, jM3501a - audioTrackPositionTracker.f7823o);
            }
        }
        if (audioTrackPositionTracker.f7806D != z3) {
            audioTrackPositionTracker.f7808F = audioTrackPositionTracker.f7805C;
            audioTrackPositionTracker.f7807E = audioTrackPositionTracker.f7804B;
        }
        long j4 = jNanoTime2 - audioTrackPositionTracker.f7808F;
        if (j4 < 1000000) {
            long jM3009q2 = Util2.m3009q(j4, audioTrackPositionTracker.f7818j) + audioTrackPositionTracker.f7807E;
            long j5 = (j4 * 1000) / 1000000;
            jM3501a = (((1000 - j5) * jM3009q2) + (jM3501a * j5)) / 1000;
        }
        if (!audioTrackPositionTracker.f7819k) {
            long j6 = audioTrackPositionTracker.f7804B;
            if (jM3501a > j6) {
                audioTrackPositionTracker.f7819k = true;
                long jM2992M = Util2.m2992M(jM3501a - j6);
                float f = audioTrackPositionTracker.f7818j;
                if (f != 1.0f) {
                    jM2992M = Math.round(jM2992M / f);
                }
                audioTrackPositionTracker.f7809a.mo3506a(System.currentTimeMillis() - Util2.m2992M(jM2992M));
            }
        }
        audioTrackPositionTracker.f7805C = jNanoTime2;
        audioTrackPositionTracker.f7804B = jM3501a;
        audioTrackPositionTracker.f7806D = z3;
        long jMin = Math.min(jM3501a, this.f19743r.m8807c(m8784E()));
        while (!this.f19735j.isEmpty() && jMin >= this.f19735j.getFirst().f19769d) {
            this.f19747v = this.f19735j.remove();
        }
        C10691e c10691e = this.f19747v;
        long j7 = jMin - c10691e.f19769d;
        if (c10691e.f19766a.equals(PlaybackParameters.f8026j)) {
            jM3009q = this.f19747v.f19768c + j7;
        } else if (this.f19735j.isEmpty()) {
            jM3009q = this.f19727b.mo8801b(j7) + this.f19747v.f19768c;
        } else {
            C10691e first = this.f19735j.getFirst();
            jM3009q = first.f19768c - Util2.m3009q(first.f19769d - jMin, this.f19747v.f19766a.f8027k);
        }
        return this.f19743r.m8807c(this.f19727b.mo8802c()) + jM3009q;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: n */
    public void mo8767n() throws IllegalStateException {
        if (this.f19722W) {
            this.f19722W = false;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: o */
    public void mo8768o(p007b.p225i.p226a.p242c.p263t2.AudioAttributes audioAttributes) throws IllegalStateException {
        if (this.f19745t.equals(audioAttributes)) {
            return;
        }
        this.f19745t = audioAttributes;
        if (this.f19722W) {
            return;
        }
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: p */
    public void mo8769p() {
        this.f19704E = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: q */
    public void mo8770q(float f) {
        if (this.f19707H != f) {
            this.f19707H = f;
            m8792N();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: r */
    public void mo8771r() throws IllegalStateException {
        AnimatableValueParser.m426D(Util2.f6708a >= 21);
        AnimatableValueParser.m426D(this.f19719T);
        if (this.f19722W) {
            return;
        }
        this.f19722W = true;
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() throws IllegalStateException {
        flush();
        for (AudioProcessor audioProcessor : this.f19731f) {
            audioProcessor.reset();
        }
        for (AudioProcessor audioProcessor2 : this.f19732g) {
            audioProcessor2.reset();
        }
        this.f19718S = false;
        this.f19724Y = false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0292 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ee  */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean mo8772s(ByteBuffer byteBuffer, long j, int i) throws Exception {
        boolean z2;
        int i2;
        int i3;
        byte b2;
        int i4;
        byte b3;
        int i5;
        ByteBuffer byteBuffer2 = this.f19710K;
        AnimatableValueParser.m531j(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.f19742q != null) {
            if (!m8797g()) {
                return false;
            }
            C10689c c10689c = this.f19742q;
            C10689c c10689c2 = this.f19743r;
            Objects.requireNonNull(c10689c);
            if (c10689c2.f19756c == c10689c.f19756c && c10689c2.f19760g == c10689c.f19760g && c10689c2.f19758e == c10689c.f19758e && c10689c2.f19759f == c10689c.f19759f && c10689c2.f19757d == c10689c.f19757d) {
                this.f19743r = this.f19742q;
                this.f19742q = null;
                if (m8779H(this.f19744s) && this.f19737l != 3) {
                    this.f19744s.setOffloadEndOfStream();
                    AudioTrack audioTrack = this.f19744s;
                    Format2 format2 = this.f19743r.f19754a;
                    audioTrack.setOffloadDelayPadding(format2.f7139M, format2.f7140N);
                    this.f19725Z = true;
                }
            } else {
                m8787I();
                if (mo8764k()) {
                    return false;
                }
                flush();
            }
            m8796f(j);
        }
        if (!m8786G()) {
            try {
                m8785F();
            } catch (AudioSink.InitializationException e) {
                if (e.isRecoverable) {
                    throw e;
                }
                this.f19739n.m8810a(e);
                return false;
            }
        }
        this.f19739n.f19770a = null;
        if (this.f19705F) {
            this.f19706G = Math.max(0L, j);
            this.f19704E = false;
            this.f19705F = false;
            if (this.f19736k && Util2.f6708a >= 23) {
                m8791M(this.f19748w);
            }
            m8796f(j);
            if (this.f19718S) {
                mo8761e();
            }
        }
        AudioTrackPositionTracker audioTrackPositionTracker = this.f19734i;
        long jM8784E = m8784E();
        AudioTrack audioTrack2 = audioTrackPositionTracker.f7811c;
        Objects.requireNonNull(audioTrack2);
        int playState = audioTrack2.getPlayState();
        if (audioTrackPositionTracker.f7816h) {
            if (playState == 2) {
                audioTrackPositionTracker.f7824p = false;
            } else if (playState != 1 || audioTrackPositionTracker.m3502b() != 0) {
            }
            z2 = false;
        } else {
            boolean z3 = audioTrackPositionTracker.f7824p;
            boolean zM3503c = audioTrackPositionTracker.m3503c(jM8784E);
            audioTrackPositionTracker.f7824p = zM3503c;
            if (z3 && !zM3503c && playState != 1) {
                audioTrackPositionTracker.f7809a.mo3507b(audioTrackPositionTracker.f7813e, Util2.m2992M(audioTrackPositionTracker.f7817i));
            }
            z2 = true;
        }
        if (!z2) {
            return false;
        }
        if (this.f19710K == null) {
            AnimatableValueParser.m531j(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            C10689c c10689c3 = this.f19743r;
            if (c10689c3.f19756c != 0 && this.f19703D == 0) {
                int i6 = c10689c3.f19760g;
                int iM3468d = 1024;
                switch (i6) {
                    case 5:
                    case 6:
                    case 18:
                        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
                            i2 = Ac3Util.f7769a[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
                            iM3468d = i2;
                            this.f19703D = iM3468d;
                            if (iM3468d == 0) {
                                return true;
                            }
                        } else {
                            iM3468d = 1536;
                            this.f19703D = iM3468d;
                            if (iM3468d == 0) {
                            }
                        }
                        break;
                    case 7:
                    case 8:
                        int iPosition = byteBuffer.position();
                        byte b4 = byteBuffer.get(iPosition);
                        if (b4 != -2) {
                            if (b4 == -1) {
                                i3 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                                b3 = byteBuffer.get(iPosition + 7);
                            } else if (b4 != 31) {
                                i3 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                                b2 = byteBuffer.get(iPosition + 5);
                            } else {
                                i3 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                                b3 = byteBuffer.get(iPosition + 6);
                            }
                            i4 = b3 & 60;
                            iM3468d = (((i4 >> 2) | i3) + 1) * 32;
                            this.f19703D = iM3468d;
                            if (iM3468d == 0) {
                            }
                        } else {
                            i3 = (byteBuffer.get(iPosition + 5) & 1) << 6;
                            b2 = byteBuffer.get(iPosition + 4);
                        }
                        i4 = b2 & 252;
                        iM3468d = (((i4 >> 2) | i3) + 1) * 32;
                        this.f19703D = iM3468d;
                        if (iM3468d == 0) {
                        }
                        break;
                    case 9:
                        int iPosition2 = byteBuffer.position();
                        int i7 = Util2.f6708a;
                        int iReverseBytes = byteBuffer.getInt(iPosition2);
                        if (byteBuffer.order() != ByteOrder.BIG_ENDIAN) {
                            iReverseBytes = Integer.reverseBytes(iReverseBytes);
                        }
                        iM3468d = MpegAudioUtil.m3468d(iReverseBytes);
                        if (iM3468d == -1) {
                            throw new IllegalArgumentException();
                        }
                        this.f19703D = iM3468d;
                        if (iM3468d == 0) {
                        }
                        break;
                    case 10:
                    case 16:
                        this.f19703D = iM3468d;
                        if (iM3468d == 0) {
                        }
                        break;
                    case 11:
                    case 12:
                        iM3468d = 2048;
                        this.f19703D = iM3468d;
                        if (iM3468d == 0) {
                        }
                        break;
                    case 13:
                    default:
                        throw new IllegalStateException(outline.m851g(38, "Unexpected audio encoding: ", i6));
                    case 14:
                        int iPosition3 = byteBuffer.position();
                        int iLimit = byteBuffer.limit() - 10;
                        int i8 = iPosition3;
                        while (true) {
                            if (i8 <= iLimit) {
                                int i9 = Util2.f6708a;
                                int iReverseBytes2 = byteBuffer.getInt(i8 + 4);
                                if (byteBuffer.order() != ByteOrder.BIG_ENDIAN) {
                                    iReverseBytes2 = Integer.reverseBytes(iReverseBytes2);
                                }
                                if ((iReverseBytes2 & (-2)) == -126718022) {
                                    i5 = i8 - iPosition3;
                                } else {
                                    i8++;
                                }
                            } else {
                                i5 = -1;
                            }
                        }
                        if (i5 == -1) {
                            iM3468d = 0;
                            this.f19703D = iM3468d;
                            if (iM3468d == 0) {
                            }
                        } else {
                            i2 = (40 << ((byteBuffer.get((byteBuffer.position() + i5) + ((byteBuffer.get((byteBuffer.position() + i5) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7)) * 16;
                            iM3468d = i2;
                            this.f19703D = iM3468d;
                            if (iM3468d == 0) {
                            }
                        }
                        break;
                    case 15:
                        iM3468d = 512;
                        this.f19703D = iM3468d;
                        if (iM3468d == 0) {
                        }
                        break;
                    case 17:
                        byte[] bArr = new byte[16];
                        int iPosition4 = byteBuffer.position();
                        byteBuffer.get(bArr);
                        byteBuffer.position(iPosition4);
                        iM3468d = Ac4Util.m3493b(new ParsableBitArray(bArr)).f7778c;
                        this.f19703D = iM3468d;
                        if (iM3468d == 0) {
                        }
                        break;
                }
            }
            if (this.f19746u != null) {
                if (!m8797g()) {
                    return false;
                }
                m8796f(j);
                this.f19746u = null;
            }
            long j2 = ((((this.f19743r.f19756c == 0 ? this.f19751z / r5.f19755b : this.f19700A) - this.f19730e.f7752o) * 1000000) / r5.f19754a.f7137K) + this.f19706G;
            if (!this.f19704E && Math.abs(j2 - j) > 200000) {
                ((MediaCodecAudioRenderer.b) this.f19741p).m3517a(new AudioSink.UnexpectedDiscontinuityException(j, j2));
                this.f19704E = true;
            }
            if (this.f19704E) {
                if (!m8797g()) {
                    return false;
                }
                long j3 = j - j2;
                this.f19706G += j3;
                this.f19704E = false;
                m8796f(j);
                AudioSink.InterfaceC10686a interfaceC10686a = this.f19741p;
                if (interfaceC10686a != null && j3 != 0) {
                    MediaCodecAudioRenderer.this.f7858V0 = true;
                }
            }
            if (this.f19743r.f19756c == 0) {
                this.f19751z += byteBuffer.remaining();
            } else {
                this.f19700A += this.f19703D * i;
            }
            this.f19710K = byteBuffer;
            this.f19711L = i;
        }
        m8788J(j);
        if (!this.f19710K.hasRemaining()) {
            this.f19710K = null;
            this.f19711L = 0;
            return true;
        }
        AudioTrackPositionTracker audioTrackPositionTracker2 = this.f19734i;
        if (!(audioTrackPositionTracker2.f7833y != -9223372036854775807L && m8784E() > 0 && SystemClock.elapsedRealtime() - audioTrackPositionTracker2.f7833y >= 200)) {
            return false;
        }
        Log.w("DefaultAudioSink", "Resetting stalled audio track");
        flush();
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: t */
    public void mo8773t(AudioSink.InterfaceC10686a interfaceC10686a) {
        this.f19741p = interfaceC10686a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: u */
    public int mo8774u(Format2 format2) {
        if (!"audio/raw".equals(format2.f7155w)) {
            if (this.f19724Y || !m8794P(format2, this.f19745t)) {
                return m8778A(format2, this.f19726a) != null ? 2 : 0;
            }
            return 2;
        }
        if (Util2.m3018z(format2.f7138L)) {
            int i = format2.f7138L;
            return (i == 2 || (this.f19728c && i == 4)) ? 2 : 1;
        }
        outline.m852g0(33, "Invalid PCM encoding: ", format2.f7138L, "DefaultAudioSink");
        return 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: v */
    public void mo8775v(Format2 format2, int i, @Nullable int[] iArr) throws AudioSink.ConfigurationException {
        int iIntValue;
        int iIntValue2;
        AudioProcessor[] audioProcessorArr;
        int i2;
        int iM3006n;
        int iM3011s;
        int iM3011s2;
        int i3;
        int i4;
        int[] iArr2;
        if ("audio/raw".equals(format2.f7155w)) {
            AnimatableValueParser.m531j(Util2.m3018z(format2.f7138L));
            iM3011s = Util2.m3011s(format2.f7138L, format2.f7136J);
            AudioProcessor[] audioProcessorArr2 = ((this.f19728c && Util2.m3017y(format2.f7138L)) ? 1 : 0) != 0 ? this.f19732g : this.f19731f;
            TrimmingAudioProcessor trimmingAudioProcessor = this.f19730e;
            int i5 = format2.f7139M;
            int i6 = format2.f7140N;
            trimmingAudioProcessor.f7746i = i5;
            trimmingAudioProcessor.f7747j = i6;
            if (Util2.f6708a < 21 && format2.f7136J == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i7 = 0; i7 < 6; i7++) {
                    iArr2[i7] = i7;
                }
            } else {
                iArr2 = iArr;
            }
            this.f19729d.f7844i = iArr2;
            AudioProcessor.C10685a c10685a = new AudioProcessor.C10685a(format2.f7137K, format2.f7136J, format2.f7138L);
            for (AudioProcessor audioProcessor : audioProcessorArr2) {
                try {
                    AudioProcessor.C10685a c10685aMo3486d = audioProcessor.mo3486d(c10685a);
                    if (audioProcessor.mo3472a()) {
                        c10685a = c10685aMo3486d;
                    }
                } catch (AudioProcessor.UnhandledAudioFormatException e) {
                    throw new AudioSink.ConfigurationException(e, format2);
                }
            }
            int i8 = c10685a.f19698d;
            i3 = c10685a.f19696b;
            iM3006n = Util2.m3006n(c10685a.f19697c);
            audioProcessorArr = audioProcessorArr2;
            i2 = i8;
            iM3011s2 = Util2.m3011s(i8, c10685a.f19697c);
            i4 = 0;
        } else {
            AudioProcessor[] audioProcessorArr3 = new AudioProcessor[0];
            int i9 = format2.f7137K;
            if (m8794P(format2, this.f19745t)) {
                String str = format2.f7155w;
                Objects.requireNonNull(str);
                iIntValue = MimeTypes.m3044b(str, format2.f7152t);
                iIntValue2 = Util2.m3006n(format2.f7136J);
            } else {
                Pair<Integer, Integer> pairM8778A = m8778A(format2, this.f19726a);
                if (pairM8778A == null) {
                    String strValueOf = String.valueOf(format2);
                    throw new AudioSink.ConfigurationException(outline.m857j(strValueOf.length() + 37, "Unable to configure passthrough for: ", strValueOf), format2);
                }
                iIntValue = ((Integer) pairM8778A.first).intValue();
                iIntValue2 = ((Integer) pairM8778A.second).intValue();
                i = 2;
            }
            audioProcessorArr = audioProcessorArr3;
            i2 = iIntValue;
            iM3006n = iIntValue2;
            iM3011s = -1;
            iM3011s2 = -1;
            i3 = i9;
            i4 = i;
        }
        if (i2 == 0) {
            String strValueOf2 = String.valueOf(format2);
            StringBuilder sb = new StringBuilder(strValueOf2.length() + 48);
            sb.append("Invalid output encoding (mode=");
            sb.append(i4);
            sb.append(") for: ");
            sb.append(strValueOf2);
            throw new AudioSink.ConfigurationException(sb.toString(), format2);
        }
        if (iM3006n != 0) {
            this.f19724Y = false;
            C10689c c10689c = new C10689c(format2, iM3011s, i4, iM3011s2, i3, iM3006n, i2, i, this.f19736k, audioProcessorArr);
            if (m8786G()) {
                this.f19742q = c10689c;
                return;
            } else {
                this.f19743r = c10689c;
                return;
            }
        }
        String strValueOf3 = String.valueOf(format2);
        StringBuilder sb2 = new StringBuilder(strValueOf3.length() + 54);
        sb2.append("Invalid output channel config (mode=");
        sb2.append(i4);
        sb2.append(") for: ");
        sb2.append(strValueOf3);
        throw new AudioSink.ConfigurationException(sb2.toString(), format2);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: w */
    public void mo8776w(boolean z2) {
        m8790L(m8799z(), z2);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    /* renamed from: x */
    public void mo8777x(AuxEffectInfo auxEffectInfo) {
        if (this.f19721V.equals(auxEffectInfo)) {
            return;
        }
        int i = auxEffectInfo.f7835a;
        float f = auxEffectInfo.f7836b;
        AudioTrack audioTrack = this.f19744s;
        if (audioTrack != null) {
            if (this.f19721V.f7835a != i) {
                audioTrack.attachAuxEffect(i);
            }
            if (i != 0) {
                this.f19744s.setAuxEffectSendLevel(f);
            }
        }
        this.f19721V = auxEffectInfo;
    }

    /* renamed from: z */
    public final PlaybackParameters m8799z() {
        return m8781B().f19766a;
    }
}

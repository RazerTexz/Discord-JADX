package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.PlaybackParameters;
import p007b.p225i.p226a.p242c.p263t2.AudioAttributes;
import p007b.p225i.p226a.p242c.p263t2.AuxEffectInfo;

/* loaded from: classes3.dex */
public interface AudioSink {

    public static final class InitializationException extends Exception {
        public final int audioTrackState;
        public final Format2 format;
        public final boolean isRecoverable;

        public InitializationException(int i, int i2, int i3, int i4, Format2 format2, boolean z2, @Nullable Exception exc) {
            String str = z2 ? " (recoverable)" : "";
            StringBuilder sb = new StringBuilder(str.length() + 80);
            sb.append("AudioTrack init failed ");
            sb.append(i);
            sb.append(" ");
            sb.append("Config(");
            sb.append(i2);
            sb.append(", ");
            sb.append(i3);
            sb.append(", ");
            sb.append(i4);
            sb.append(")");
            sb.append(str);
            super(sb.toString(), exc);
            this.audioTrackState = i;
            this.isRecoverable = z2;
            this.format = format2;
        }
    }

    public static final class UnexpectedDiscontinuityException extends Exception {
        public final long actualPresentationTimeUs;
        public final long expectedPresentationTimeUs;

        /* JADX WARN: Illegal instructions before constructor call */
        public UnexpectedDiscontinuityException(long j, long j2) {
            StringBuilder sbM830R = outline.m830R(103, "Unexpected audio track timestamp discontinuity: expected ", j2, ", got ");
            sbM830R.append(j);
            super(sbM830R.toString());
            this.actualPresentationTimeUs = j;
            this.expectedPresentationTimeUs = j2;
        }
    }

    public static final class WriteException extends Exception {
        public final int errorCode;
        public final Format2 format;
        public final boolean isRecoverable;

        public WriteException(int i, Format2 format2, boolean z2) {
            super(outline.m851g(36, "AudioTrack write failed: ", i));
            this.isRecoverable = z2;
            this.errorCode = i;
            this.format = format2;
        }
    }

    /* renamed from: com.google.android.exoplayer2.audio.AudioSink$a */
    public interface InterfaceC10686a {
    }

    /* renamed from: a */
    boolean mo8757a(Format2 format2);

    /* renamed from: b */
    boolean mo8758b();

    /* renamed from: c */
    PlaybackParameters mo8759c();

    /* renamed from: d */
    void mo8760d();

    /* renamed from: e */
    void mo8761e();

    void flush();

    /* renamed from: i */
    void mo8762i(PlaybackParameters playbackParameters);

    /* renamed from: j */
    void mo8763j() throws WriteException;

    /* renamed from: k */
    boolean mo8764k();

    /* renamed from: l */
    void mo8765l(int i);

    /* renamed from: m */
    long mo8766m(boolean z2);

    /* renamed from: n */
    void mo8767n();

    /* renamed from: o */
    void mo8768o(AudioAttributes audioAttributes);

    /* renamed from: p */
    void mo8769p();

    /* renamed from: q */
    void mo8770q(float f);

    /* renamed from: r */
    void mo8771r();

    void reset();

    /* renamed from: s */
    boolean mo8772s(ByteBuffer byteBuffer, long j, int i) throws WriteException, InitializationException;

    /* renamed from: t */
    void mo8773t(InterfaceC10686a interfaceC10686a);

    /* renamed from: u */
    int mo8774u(Format2 format2);

    /* renamed from: v */
    void mo8775v(Format2 format2, int i, @Nullable int[] iArr) throws ConfigurationException;

    /* renamed from: w */
    void mo8776w(boolean z2);

    /* renamed from: x */
    void mo8777x(AuxEffectInfo auxEffectInfo);

    public static final class ConfigurationException extends Exception {
        public final Format2 format;

        public ConfigurationException(Throwable th, Format2 format2) {
            super(th);
            this.format = format2;
        }

        public ConfigurationException(String str, Format2 format2) {
            super(str);
            this.format = format2;
        }
    }
}

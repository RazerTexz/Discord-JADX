package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* loaded from: classes3.dex */
public interface AudioProcessor {

    /* renamed from: a */
    public static final ByteBuffer f19694a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class UnhandledAudioFormatException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        public UnhandledAudioFormatException(C10685a c10685a) {
            String strValueOf = String.valueOf(c10685a);
            super(outline.m857j(strValueOf.length() + 18, "Unhandled format: ", strValueOf));
        }
    }

    /* renamed from: com.google.android.exoplayer2.audio.AudioProcessor$a */
    public static final class C10685a {

        /* renamed from: a */
        public static final C10685a f19695a = new C10685a(-1, -1, -1);

        /* renamed from: b */
        public final int f19696b;

        /* renamed from: c */
        public final int f19697c;

        /* renamed from: d */
        public final int f19698d;

        /* renamed from: e */
        public final int f19699e;

        public C10685a(int i, int i2, int i3) {
            this.f19696b = i;
            this.f19697c = i2;
            this.f19698d = i3;
            this.f19699e = Util2.m3018z(i3) ? Util2.m3011s(i3, i2) : -1;
        }

        public String toString() {
            int i = this.f19696b;
            int i2 = this.f19697c;
            int i3 = this.f19698d;
            StringBuilder sb = new StringBuilder(83);
            sb.append("AudioFormat[sampleRate=");
            sb.append(i);
            sb.append(", channelCount=");
            sb.append(i2);
            sb.append(", encoding=");
            sb.append(i3);
            sb.append(']');
            return sb.toString();
        }
    }

    /* renamed from: a */
    boolean mo3472a();

    /* renamed from: b */
    boolean mo3485b();

    /* renamed from: c */
    void mo3470c(ByteBuffer byteBuffer);

    /* renamed from: d */
    C10685a mo3486d(C10685a c10685a) throws UnhandledAudioFormatException;

    /* renamed from: e */
    void mo3487e();

    void flush();

    ByteBuffer getOutput();

    void reset();
}

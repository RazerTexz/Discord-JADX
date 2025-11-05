package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import b.i.a.c.j1;
import b.i.a.c.t2.o;
import b.i.a.c.t2.u;
import b.i.a.c.x1;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public interface AudioSink {

    public static final class InitializationException extends Exception {
        public final int audioTrackState;
        public final j1 format;
        public final boolean isRecoverable;

        public InitializationException(int i, int i2, int i3, int i4, j1 j1Var, boolean z2, @Nullable Exception exc) {
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
            this.format = j1Var;
        }
    }

    public static final class UnexpectedDiscontinuityException extends Exception {
        public final long actualPresentationTimeUs;
        public final long expectedPresentationTimeUs;

        /* JADX WARN: Illegal instructions before constructor call */
        public UnexpectedDiscontinuityException(long j, long j2) {
            StringBuilder sbR = b.d.b.a.a.R(103, "Unexpected audio track timestamp discontinuity: expected ", j2, ", got ");
            sbR.append(j);
            super(sbR.toString());
            this.actualPresentationTimeUs = j;
            this.expectedPresentationTimeUs = j2;
        }
    }

    public static final class WriteException extends Exception {
        public final int errorCode;
        public final j1 format;
        public final boolean isRecoverable;

        public WriteException(int i, j1 j1Var, boolean z2) {
            super(b.d.b.a.a.g(36, "AudioTrack write failed: ", i));
            this.isRecoverable = z2;
            this.errorCode = i;
            this.format = j1Var;
        }
    }

    public interface a {
    }

    boolean a(j1 j1Var);

    boolean b();

    x1 c();

    void d();

    void e();

    void flush();

    void i(x1 x1Var);

    void j() throws WriteException;

    boolean k();

    void l(int i);

    long m(boolean z2);

    void n();

    void o(o oVar);

    void p();

    void q(float f);

    void r();

    void reset();

    boolean s(ByteBuffer byteBuffer, long j, int i) throws WriteException, InitializationException;

    void t(a aVar);

    int u(j1 j1Var);

    void v(j1 j1Var, int i, @Nullable int[] iArr) throws ConfigurationException;

    void w(boolean z2);

    void x(u uVar);

    public static final class ConfigurationException extends Exception {
        public final j1 format;

        public ConfigurationException(Throwable th, j1 j1Var) {
            super(th);
            this.format = j1Var;
        }

        public ConfigurationException(String str, j1 j1Var) {
            super(str);
            this.format = j1Var;
        }
    }
}

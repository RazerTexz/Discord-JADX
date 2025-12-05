package com.google.android.exoplayer2;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p243a3.MediaPeriodId;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* loaded from: classes3.dex */
public final class ExoPlaybackException extends PlaybackException {
    public final boolean isRecoverable;

    @Nullable
    public final MediaPeriodId mediaPeriodId;

    @Nullable
    public final Format2 rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;

    @Nullable
    public final String rendererName;
    public final int type;

    public ExoPlaybackException(int i, Throwable th, int i2) {
        this(i, th, null, i2, null, -1, null, 4, false);
    }

    /* renamed from: b */
    public static ExoPlaybackException m8753b(RuntimeException runtimeException, int i) {
        return new ExoPlaybackException(2, runtimeException, i);
    }

    @CheckResult
    /* renamed from: a */
    public ExoPlaybackException m8754a(@Nullable MediaPeriodId mediaPeriodId) {
        String message = getMessage();
        int i = Util2.f6708a;
        return new ExoPlaybackException(message, getCause(), this.errorCode, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, mediaPeriodId, this.timestampMs, this.isRecoverable);
    }

    public ExoPlaybackException(String str, @Nullable Throwable th, int i, int i2, @Nullable String str2, int i3, @Nullable Format2 format2, int i4, @Nullable MediaPeriodId mediaPeriodId, long j, boolean z2) {
        super(str, th, i, j);
        AnimatableValueParser.m531j(!z2 || i2 == 1);
        AnimatableValueParser.m531j(th != null || i2 == 3);
        this.type = i2;
        this.rendererName = str2;
        this.rendererIndex = i3;
        this.rendererFormat = format2;
        this.rendererFormatSupport = i4;
        this.mediaPeriodId = mediaPeriodId;
        this.isRecoverable = z2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ExoPlaybackException(int i, @Nullable Throwable th, @Nullable String str, int i2, @Nullable String str2, int i3, @Nullable Format2 format2, int i4, boolean z2) {
        String strM859k;
        String str3;
        if (i == 0) {
            strM859k = "Source error";
        } else if (i != 1) {
            strM859k = i != 3 ? "Unexpected runtime error" : "Remote error";
        } else {
            String strValueOf = String.valueOf(format2);
            int i5 = Util2.f6708a;
            if (i4 == 0) {
                str3 = "NO";
            } else if (i4 == 1) {
                str3 = "NO_UNSUPPORTED_TYPE";
            } else if (i4 == 2) {
                str3 = "NO_UNSUPPORTED_DRM";
            } else if (i4 == 3) {
                str3 = "NO_EXCEEDS_CAPABILITIES";
            } else {
                if (i4 != 4) {
                    throw new IllegalStateException();
                }
                str3 = "YES";
            }
            StringBuilder sb = new StringBuilder(str3.length() + strValueOf.length() + outline.m841b(str2, 53));
            sb.append(str2);
            sb.append(" error, index=");
            sb.append(i3);
            sb.append(", format=");
            strM859k = outline.m823K(sb, strValueOf, ", format_supported=", str3);
        }
        if (!TextUtils.isEmpty(null)) {
            String strValueOf2 = String.valueOf(strM859k);
            strM859k = outline.m859k("null".length() + strValueOf2.length() + 2, strValueOf2, ": ", null);
        }
        this(strM859k, th, i2, i, str2, i3, format2, i4, null, SystemClock.elapsedRealtime(), z2);
    }
}

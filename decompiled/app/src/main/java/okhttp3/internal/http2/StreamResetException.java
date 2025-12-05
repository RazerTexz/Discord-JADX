package okhttp3.internal.http2;

import java.io.IOException;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.p601e0.p608j.ErrorCode2;

/* compiled from: StreamResetException.kt */
/* loaded from: classes3.dex */
public final class StreamResetException extends IOException {
    public final ErrorCode2 errorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamResetException(ErrorCode2 errorCode2) {
        super("stream was reset: " + errorCode2);
        Intrinsics3.checkParameterIsNotNull(errorCode2, "errorCode");
        this.errorCode = errorCode2;
    }
}

package okhttp3.internal.connection;

import java.io.IOException;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: RouteException.kt */
/* loaded from: classes3.dex */
public final class RouteException extends RuntimeException {
    private final IOException firstConnectException;
    private IOException lastConnectException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteException(IOException iOException) {
        super(iOException);
        Intrinsics3.checkParameterIsNotNull(iOException, "firstConnectException");
        this.firstConnectException = iOException;
        this.lastConnectException = iOException;
    }

    /* renamed from: a */
    public final void m10999a(IOException e) {
        Intrinsics3.checkParameterIsNotNull(e, "e");
        this.firstConnectException.addSuppressed(e);
        this.lastConnectException = e;
    }

    /* renamed from: b, reason: from getter */
    public final IOException getFirstConnectException() {
        return this.firstConnectException;
    }

    /* renamed from: c, reason: from getter */
    public final IOException getLastConnectException() {
        return this.lastConnectException;
    }
}

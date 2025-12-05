package p600f0.p601e0.p609k.p610i;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Protocol2;
import p600f0.p601e0.p609k.Platform2;

/* compiled from: Android10SocketAdapter.kt */
@SuppressLint({"NewApi"})
/* renamed from: f0.e0.k.i.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class Android10SocketAdapter implements SocketAdapter {
    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    /* renamed from: a */
    public boolean mo10334a(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sSLSocket);
    }

    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    /* renamed from: b */
    public boolean mo10335b() {
        return Platform2.f25785c.m10333c() && Build.VERSION.SDK_INT >= 29;
    }

    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    @SuppressLint({"NewApi"})
    /* renamed from: c */
    public String mo10336c(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || Intrinsics3.areEqual(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    @SuppressLint({"NewApi"})
    /* renamed from: d */
    public void mo10337d(SSLSocket sSLSocket, String str, List<? extends Protocol2> list) throws IOException {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            Intrinsics3.checkExpressionValueIsNotNull(sSLParameters, "sslParameters");
            Object[] array = Platform2.f25785c.m10331a(list).toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            sSLParameters.setApplicationProtocols((String[]) array);
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e) {
            throw new IOException("Android internal error", e);
        }
    }
}

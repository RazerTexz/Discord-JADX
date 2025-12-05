package p600f0.p601e0.p609k.p610i;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Protocol2;
import p600f0.p601e0.p609k.BouncyCastlePlatform;
import p600f0.p601e0.p609k.Platform2;
import p600f0.p601e0.p609k.p610i.DeferredSocketAdapter;

/* compiled from: BouncyCastleSocketAdapter.kt */
/* renamed from: f0.e0.k.i.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class BouncyCastleSocketAdapter implements SocketAdapter {

    /* renamed from: a */
    public static final DeferredSocketAdapter.a f25800a = new a();

    /* compiled from: BouncyCastleSocketAdapter.kt */
    /* renamed from: f0.e0.k.i.g$a */
    public static final class a implements DeferredSocketAdapter.a {
        @Override // p600f0.p601e0.p609k.p610i.DeferredSocketAdapter.a
        /* renamed from: a */
        public boolean mo10339a(SSLSocket sSLSocket) {
            Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
            BouncyCastlePlatform.a aVar = BouncyCastlePlatform.f25764e;
            return BouncyCastlePlatform.f25763d && (sSLSocket instanceof BCSSLSocket);
        }

        @Override // p600f0.p601e0.p609k.p610i.DeferredSocketAdapter.a
        /* renamed from: b */
        public SocketAdapter mo10340b(SSLSocket sSLSocket) {
            Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
            return new BouncyCastleSocketAdapter();
        }
    }

    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    /* renamed from: a */
    public boolean mo10334a(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return sSLSocket instanceof BCSSLSocket;
    }

    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    /* renamed from: b */
    public boolean mo10335b() {
        BouncyCastlePlatform.a aVar = BouncyCastlePlatform.f25764e;
        return BouncyCastlePlatform.f25763d;
    }

    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    /* renamed from: c */
    public String mo10336c(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null || Intrinsics3.areEqual(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    /* renamed from: d */
    public void mo10337d(SSLSocket sSLSocket, String str, List<? extends Protocol2> list) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        if (mo10334a(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            Intrinsics3.checkExpressionValueIsNotNull(parameters, "sslParameters");
            Object[] array = Platform2.f25785c.m10331a(list).toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            parameters.setApplicationProtocols((String[]) array);
            bCSSLSocket.setParameters(parameters);
        }
    }
}

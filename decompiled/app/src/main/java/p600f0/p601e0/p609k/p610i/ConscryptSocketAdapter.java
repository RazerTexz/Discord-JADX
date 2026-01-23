package p600f0.p601e0.p609k.p610i;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import org.conscrypt.Conscrypt;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Protocol2;
import p600f0.p601e0.p609k.ConscryptPlatform;
import p600f0.p601e0.p609k.Platform2;
import p600f0.p601e0.p609k.p610i.DeferredSocketAdapter;

/* JADX INFO: renamed from: f0.e0.k.i.i, reason: use source file name */
/* JADX INFO: compiled from: ConscryptSocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConscryptSocketAdapter implements SocketAdapter {

    /* JADX INFO: renamed from: a */
    public static final DeferredSocketAdapter.a f25804a = new a();

    /* JADX INFO: renamed from: f0.e0.k.i.i$a */
    /* JADX INFO: compiled from: ConscryptSocketAdapter.kt */
    public static final class a implements DeferredSocketAdapter.a {
        @Override // p600f0.p601e0.p609k.p610i.DeferredSocketAdapter.a
        /* JADX INFO: renamed from: a */
        public boolean mo10339a(SSLSocket sSLSocket) {
            Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
            ConscryptPlatform.a aVar = ConscryptPlatform.f25767e;
            return ConscryptPlatform.f25766d && Conscrypt.isConscrypt(sSLSocket);
        }

        @Override // p600f0.p601e0.p609k.p610i.DeferredSocketAdapter.a
        /* JADX INFO: renamed from: b */
        public SocketAdapter mo10340b(SSLSocket sSLSocket) {
            Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
            return new ConscryptSocketAdapter();
        }
    }

    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    /* JADX INFO: renamed from: a */
    public boolean mo10334a(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    /* JADX INFO: renamed from: b */
    public boolean mo10335b() {
        ConscryptPlatform.a aVar = ConscryptPlatform.f25767e;
        return ConscryptPlatform.f25766d;
    }

    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    /* JADX INFO: renamed from: c */
    public String mo10336c(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (mo10334a(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    /* JADX INFO: renamed from: d */
    public void mo10337d(SSLSocket sSLSocket, String str, List<? extends Protocol2> list) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        if (mo10334a(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Object[] array = Platform2.f25785c.m10331a(list).toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
        }
    }
}

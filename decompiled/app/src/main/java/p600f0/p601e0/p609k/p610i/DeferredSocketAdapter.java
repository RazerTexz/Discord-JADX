package p600f0.p601e0.p609k.p610i;

import java.util.List;
import javax.net.ssl.SSLSocket;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Protocol2;

/* compiled from: DeferredSocketAdapter.kt */
/* renamed from: f0.e0.k.i.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class DeferredSocketAdapter implements SocketAdapter {

    /* renamed from: a */
    public SocketAdapter f25805a;

    /* renamed from: b */
    public final a f25806b;

    /* compiled from: DeferredSocketAdapter.kt */
    /* renamed from: f0.e0.k.i.j$a */
    public interface a {
        /* renamed from: a */
        boolean mo10339a(SSLSocket sSLSocket);

        /* renamed from: b */
        SocketAdapter mo10340b(SSLSocket sSLSocket);
    }

    public DeferredSocketAdapter(a aVar) {
        Intrinsics3.checkParameterIsNotNull(aVar, "socketAdapterFactory");
        this.f25806b = aVar;
    }

    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    /* renamed from: a */
    public boolean mo10334a(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return this.f25806b.mo10339a(sSLSocket);
    }

    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    /* renamed from: b */
    public boolean mo10335b() {
        return true;
    }

    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    /* renamed from: c */
    public String mo10336c(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        SocketAdapter socketAdapterM10341e = m10341e(sSLSocket);
        if (socketAdapterM10341e != null) {
            return socketAdapterM10341e.mo10336c(sSLSocket);
        }
        return null;
    }

    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    /* renamed from: d */
    public void mo10337d(SSLSocket sSLSocket, String str, List<? extends Protocol2> list) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        SocketAdapter socketAdapterM10341e = m10341e(sSLSocket);
        if (socketAdapterM10341e != null) {
            socketAdapterM10341e.mo10337d(sSLSocket, str, list);
        }
    }

    /* renamed from: e */
    public final synchronized SocketAdapter m10341e(SSLSocket sSLSocket) {
        if (this.f25805a == null && this.f25806b.mo10339a(sSLSocket)) {
            this.f25805a = this.f25806b.mo10340b(sSLSocket);
        }
        return this.f25805a;
    }
}

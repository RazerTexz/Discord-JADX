package p600f0.p601e0.p609k.p610i;

import javax.net.ssl.SSLSocket;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.p601e0.p609k.p610i.AndroidSocketAdapter2;
import p600f0.p601e0.p609k.p610i.DeferredSocketAdapter;

/* compiled from: AndroidSocketAdapter.kt */
/* renamed from: f0.e0.k.i.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class AndroidSocketAdapter implements DeferredSocketAdapter.a {

    /* renamed from: a */
    public final /* synthetic */ String f25792a;

    public AndroidSocketAdapter(String str) {
        this.f25792a = str;
    }

    @Override // p600f0.p601e0.p609k.p610i.DeferredSocketAdapter.a
    /* renamed from: a */
    public boolean mo10339a(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        String name = sSLSocket.getClass().getName();
        Intrinsics3.checkExpressionValueIsNotNull(name, "sslSocket.javaClass.name");
        return StringsJVM.startsWith$default(name, outline.m820H(new StringBuilder(), this.f25792a, '.'), false, 2, null);
    }

    @Override // p600f0.p601e0.p609k.p610i.DeferredSocketAdapter.a
    /* renamed from: b */
    public SocketAdapter mo10340b(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        AndroidSocketAdapter2.a aVar = AndroidSocketAdapter2.f25794b;
        Class<?> cls = sSLSocket.getClass();
        Class<?> superclass = cls;
        while (superclass != null && (!Intrinsics3.areEqual(superclass.getSimpleName(), "OpenSSLSocketImpl"))) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
            }
        }
        if (superclass == null) {
            Intrinsics3.throwNpe();
        }
        return new AndroidSocketAdapter2(superclass);
    }
}

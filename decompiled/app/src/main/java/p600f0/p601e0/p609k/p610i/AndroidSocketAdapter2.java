package p600f0.p601e0.p609k.p610i;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Protocol2;
import p600f0.p601e0.p609k.AndroidPlatform;
import p600f0.p601e0.p609k.Platform2;
import p600f0.p601e0.p609k.p610i.DeferredSocketAdapter;

/* JADX INFO: renamed from: f0.e0.k.i.f, reason: use source file name */
/* JADX INFO: compiled from: AndroidSocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public class AndroidSocketAdapter2 implements SocketAdapter {

    /* JADX INFO: renamed from: a */
    public static final DeferredSocketAdapter.a f25793a;

    /* JADX INFO: renamed from: b */
    public static final a f25794b;

    /* JADX INFO: renamed from: c */
    public final Method f25795c;

    /* JADX INFO: renamed from: d */
    public final Method f25796d;

    /* JADX INFO: renamed from: e */
    public final Method f25797e;

    /* JADX INFO: renamed from: f */
    public final Method f25798f;

    /* JADX INFO: renamed from: g */
    public final Class<? super SSLSocket> f25799g;

    /* JADX INFO: renamed from: f0.e0.k.i.f$a */
    /* JADX INFO: compiled from: AndroidSocketAdapter.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        a aVar = new a(null);
        f25794b = aVar;
        Objects.requireNonNull(aVar);
        Intrinsics3.checkParameterIsNotNull("com.google.android.gms.org.conscrypt", "packageName");
        f25793a = new AndroidSocketAdapter("com.google.android.gms.org.conscrypt");
    }

    public AndroidSocketAdapter2(Class<? super SSLSocket> cls) throws NoSuchMethodException {
        Intrinsics3.checkParameterIsNotNull(cls, "sslSocketClass");
        this.f25799g = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        Intrinsics3.checkExpressionValueIsNotNull(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f25795c = declaredMethod;
        this.f25796d = cls.getMethod("setHostname", String.class);
        this.f25797e = cls.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.f25798f = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    /* JADX INFO: renamed from: a */
    public boolean mo10334a(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return this.f25799g.isInstance(sSLSocket);
    }

    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    /* JADX INFO: renamed from: b */
    public boolean mo10335b() {
        AndroidPlatform.a aVar = AndroidPlatform.f25758e;
        return AndroidPlatform.f25757d;
    }

    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    /* JADX INFO: renamed from: c */
    public String mo10336c(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (!mo10334a(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f25797e.invoke(sSLSocket, new Object[0]);
            if (bArr == null) {
                return null;
            }
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics3.checkExpressionValueIsNotNull(charset, "StandardCharsets.UTF_8");
            return new String(bArr, charset);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (NullPointerException e2) {
            if (Intrinsics3.areEqual(e2.getMessage(), "ssl == null")) {
                return null;
            }
            throw e2;
        } catch (InvocationTargetException e3) {
            throw new AssertionError(e3);
        }
    }

    @Override // p600f0.p601e0.p609k.p610i.SocketAdapter
    /* JADX INFO: renamed from: d */
    public void mo10337d(SSLSocket sSLSocket, String str, List<? extends Protocol2> list) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        if (mo10334a(sSLSocket)) {
            try {
                this.f25795c.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.f25796d.invoke(sSLSocket, str);
                }
                this.f25798f.invoke(sSLSocket, Platform2.f25785c.m10332b(list));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }
    }
}

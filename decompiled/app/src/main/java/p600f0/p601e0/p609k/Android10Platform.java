package p600f0.p601e0.p609k;

import android.annotation.SuppressLint;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Protocol2;
import p600f0.p601e0.p609k.p610i.Android10SocketAdapter;
import p600f0.p601e0.p609k.p610i.AndroidCertificateChainCleaner;
import p600f0.p601e0.p609k.p610i.AndroidSocketAdapter2;
import p600f0.p601e0.p609k.p610i.BouncyCastleSocketAdapter;
import p600f0.p601e0.p609k.p610i.ConscryptSocketAdapter;
import p600f0.p601e0.p609k.p610i.DeferredSocketAdapter;
import p600f0.p601e0.p609k.p610i.SocketAdapter;
import p600f0.p601e0.p612m.CertificateChainCleaner;

/* compiled from: Android10Platform.kt */
/* renamed from: f0.e0.k.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class Android10Platform extends Platform2 {

    /* renamed from: d */
    public static final boolean f25754d;

    /* renamed from: e */
    public static final Android10Platform f25755e = null;

    /* renamed from: f */
    public final List<SocketAdapter> f25756f;

    static {
        f25754d = Platform2.f25785c.m10333c() && Build.VERSION.SDK_INT >= 29;
    }

    public Android10Platform() {
        SocketAdapter[] socketAdapterArr = new SocketAdapter[4];
        socketAdapterArr[0] = Intrinsics3.areEqual("Dalvik", System.getProperty("java.vm.name")) && Build.VERSION.SDK_INT >= 29 ? new Android10SocketAdapter() : null;
        AndroidSocketAdapter2.a aVar = AndroidSocketAdapter2.f25794b;
        socketAdapterArr[1] = new DeferredSocketAdapter(AndroidSocketAdapter2.f25793a);
        socketAdapterArr[2] = new DeferredSocketAdapter(ConscryptSocketAdapter.f25804a);
        socketAdapterArr[3] = new DeferredSocketAdapter(BouncyCastleSocketAdapter.f25800a);
        List listListOfNotNull = Collections2.listOfNotNull((Object[]) socketAdapterArr);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOfNotNull) {
            if (((SocketAdapter) obj).mo10335b()) {
                arrayList.add(obj);
            }
        }
        this.f25756f = arrayList;
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* renamed from: b */
    public CertificateChainCleaner mo10315b(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        AndroidCertificateChainCleaner androidCertificateChainCleaner = x509TrustManagerExtensions != null ? new AndroidCertificateChainCleaner(x509TrustManager, x509TrustManagerExtensions) : null;
        return androidCertificateChainCleaner != null ? androidCertificateChainCleaner : super.mo10315b(x509TrustManager);
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* renamed from: d */
    public void mo10316d(SSLSocket sSLSocket, String str, List<? extends Protocol2> list) {
        Object next;
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        Iterator<T> it = this.f25756f.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((SocketAdapter) next).mo10334a(sSLSocket)) {
                    break;
                }
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) next;
        if (socketAdapter != null) {
            socketAdapter.mo10337d(sSLSocket, str, list);
        }
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* renamed from: f */
    public String mo10317f(SSLSocket sSLSocket) {
        Object next;
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Iterator<T> it = this.f25756f.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((SocketAdapter) next).mo10334a(sSLSocket)) {
                break;
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) next;
        if (socketAdapter != null) {
            return socketAdapter.mo10336c(sSLSocket);
        }
        return null;
    }

    @Override // p600f0.p601e0.p609k.Platform2
    @SuppressLint({"NewApi"})
    /* renamed from: h */
    public boolean mo10318h(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}

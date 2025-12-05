package p600f0.p601e0.p609k;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Protocol2;

/* compiled from: ConscryptPlatform.kt */
/* renamed from: f0.e0.k.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class ConscryptPlatform extends Platform2 {

    /* renamed from: d */
    public static final boolean f25766d;

    /* renamed from: e */
    public static final a f25767e;

    /* renamed from: f */
    public final Provider f25768f;

    /* compiled from: ConscryptPlatform.kt */
    /* renamed from: f0.e0.k.d$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public final boolean m10327a(int i, int i2, int i3) {
            Conscrypt.Version version = Conscrypt.version();
            return version.major() != i ? version.major() > i : version.minor() != i2 ? version.minor() > i2 : version.patch() >= i3;
        }
    }

    /* compiled from: ConscryptPlatform.kt */
    /* renamed from: f0.e0.k.d$b */
    public static final class b implements ConscryptHostnameVerifier {

        /* renamed from: a */
        public static final b f25769a = new b();
    }

    static {
        a aVar = new a(null);
        f25767e = aVar;
        boolean z2 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, aVar.getClass().getClassLoader());
            if (Conscrypt.isAvailable()) {
                if (aVar.m10327a(2, 1, 0)) {
                    z2 = true;
                }
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        f25766d = z2;
    }

    public ConscryptPlatform() {
        Provider providerBuild = Conscrypt.newProviderBuilder().provideTrustManager(true).build();
        Intrinsics3.checkExpressionValueIsNotNull(providerBuild, "Conscrypt.newProviderBui…rustManager(true).build()");
        this.f25768f = providerBuild;
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* renamed from: d */
    public void mo10316d(SSLSocket sSLSocket, String str, List<Protocol2> list) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
            Intrinsics3.checkParameterIsNotNull(list, "protocols");
            return;
        }
        Conscrypt.setUseSessionTickets(sSLSocket, true);
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Protocol2) next) != Protocol2.HTTP_1_0) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((Protocol2) it2.next()).toString());
        }
        Object[] array = arrayList2.toArray(new String[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* renamed from: f */
    public String mo10317f(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        super.mo10317f(sSLSocket);
        return null;
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* renamed from: l */
    public SSLContext mo10324l() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f25768f);
        Intrinsics3.checkExpressionValueIsNotNull(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* renamed from: m */
    public SSLSocketFactory mo10326m(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException {
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f25768f);
        Intrinsics3.checkExpressionValueIsNotNull(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        Conscrypt.setUseEngineSocket(socketFactory, true);
        Intrinsics3.checkExpressionValueIsNotNull(socketFactory, "newSSLContext().apply {\n…ineSocket(it, true)\n    }");
        return socketFactory;
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* renamed from: n */
    public X509TrustManager mo10325n() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        Intrinsics3.checkExpressionValueIsNotNull(trustManagerFactory, "TrustManagerFactory.getI…(null as KeyStore?)\n    }");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers == null) {
            Intrinsics3.throwNpe();
        }
        if (!(trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager))) {
            StringBuilder sbM833U = outline.m833U("Unexpected default trust managers: ");
            String string = Arrays.toString(trustManagers);
            Intrinsics3.checkExpressionValueIsNotNull(string, "java.util.Arrays.toString(this)");
            sbM833U.append(string);
            throw new IllegalStateException(sbM833U.toString().toString());
        }
        TrustManager trustManager = trustManagers[0];
        if (trustManager == null) {
            throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
        Conscrypt.setHostnameVerifier(x509TrustManager, b.f25769a);
        return x509TrustManager;
    }
}

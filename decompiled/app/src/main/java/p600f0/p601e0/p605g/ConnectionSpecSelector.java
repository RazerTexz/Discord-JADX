package p600f0.p601e0.p605g;

import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t._Arrays;
import p507d0.p582u.C12169a;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.CipherSuite;
import p600f0.ConnectionSpec;
import p600f0.p601e0.Util7;

/* JADX INFO: renamed from: f0.e0.g.b, reason: use source file name */
/* JADX INFO: compiled from: ConnectionSpecSelector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConnectionSpecSelector {

    /* JADX INFO: renamed from: a */
    public int f25433a;

    /* JADX INFO: renamed from: b */
    public boolean f25434b;

    /* JADX INFO: renamed from: c */
    public boolean f25435c;

    /* JADX INFO: renamed from: d */
    public final List<ConnectionSpec> f25436d;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        Intrinsics3.checkParameterIsNotNull(list, "connectionSpecs");
        this.f25436d = list;
    }

    /* JADX INFO: renamed from: a */
    public final ConnectionSpec m10166a(SSLSocket sSLSocket) throws IOException, CloneNotSupportedException {
        ConnectionSpec connectionSpec;
        boolean z2;
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        int i = this.f25433a;
        int size = this.f25436d.size();
        while (true) {
            if (i >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.f25436d.get(i);
            if (connectionSpec.m10376b(sSLSocket)) {
                this.f25433a = i + 1;
                break;
            }
            i++;
        }
        if (connectionSpec == null) {
            StringBuilder sbM833U = outline.m833U("Unable to find acceptable protocols. isFallback=");
            sbM833U.append(this.f25435c);
            sbM833U.append(',');
            sbM833U.append(" modes=");
            sbM833U.append(this.f25436d);
            sbM833U.append(',');
            sbM833U.append(" supported protocols=");
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            if (enabledProtocols2 == null) {
                Intrinsics3.throwNpe();
            }
            String string = Arrays.toString(enabledProtocols2);
            Intrinsics3.checkExpressionValueIsNotNull(string, "java.util.Arrays.toString(this)");
            sbM833U.append(string);
            throw new UnknownServiceException(sbM833U.toString());
        }
        int i2 = this.f25433a;
        int size2 = this.f25436d.size();
        while (true) {
            if (i2 >= size2) {
                z2 = false;
                break;
            }
            if (this.f25436d.get(i2).m10376b(sSLSocket)) {
                z2 = true;
                break;
            }
            i2++;
        }
        this.f25434b = z2;
        boolean z3 = this.f25435c;
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (connectionSpec.f25936g != null) {
            String[] enabledCipherSuites2 = sSLSocket.getEnabledCipherSuites();
            Intrinsics3.checkExpressionValueIsNotNull(enabledCipherSuites2, "sslSocket.enabledCipherSuites");
            String[] strArr = connectionSpec.f25936g;
            CipherSuite.b bVar = CipherSuite.f25927s;
            Comparator<String> comparator = CipherSuite.f25909a;
            enabledCipherSuites = Util7.m10136q(enabledCipherSuites2, strArr, CipherSuite.f25909a);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (connectionSpec.f25937h != null) {
            String[] enabledProtocols3 = sSLSocket.getEnabledProtocols();
            Intrinsics3.checkExpressionValueIsNotNull(enabledProtocols3, "sslSocket.enabledProtocols");
            enabledProtocols = Util7.m10136q(enabledProtocols3, connectionSpec.f25937h, C12169a.naturalOrder());
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        Intrinsics3.checkExpressionValueIsNotNull(supportedCipherSuites, "supportedCipherSuites");
        CipherSuite.b bVar2 = CipherSuite.f25927s;
        Comparator<String> comparator2 = CipherSuite.f25909a;
        Comparator<String> comparator3 = CipherSuite.f25909a;
        byte[] bArr = Util7.f25397a;
        Intrinsics3.checkParameterIsNotNull(supportedCipherSuites, "$this$indexOf");
        Intrinsics3.checkParameterIsNotNull("TLS_FALLBACK_SCSV", "value");
        Intrinsics3.checkParameterIsNotNull(comparator3, "comparator");
        int length = supportedCipherSuites.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            if (((CipherSuite.a) comparator3).compare(supportedCipherSuites[i3], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i3++;
        }
        if (z3 && i3 != -1) {
            Intrinsics3.checkExpressionValueIsNotNull(enabledCipherSuites, "cipherSuitesIntersection");
            String str = supportedCipherSuites[i3];
            Intrinsics3.checkExpressionValueIsNotNull(str, "supportedCipherSuites[indexOfFallbackScsv]");
            Intrinsics3.checkParameterIsNotNull(enabledCipherSuites, "$this$concat");
            Intrinsics3.checkParameterIsNotNull(str, "value");
            Object[] objArrCopyOf = Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length + 1);
            Intrinsics3.checkExpressionValueIsNotNull(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
            enabledCipherSuites = (String[]) objArrCopyOf;
            enabledCipherSuites[_Arrays.getLastIndex(enabledCipherSuites)] = str;
        }
        ConnectionSpec.a aVar = new ConnectionSpec.a(connectionSpec);
        Intrinsics3.checkExpressionValueIsNotNull(enabledCipherSuites, "cipherSuitesIntersection");
        aVar.m10379b((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        Intrinsics3.checkExpressionValueIsNotNull(enabledProtocols, "tlsVersionsIntersection");
        aVar.m10382e((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length));
        ConnectionSpec connectionSpecM10378a = aVar.m10378a();
        if (connectionSpecM10378a.m10377c() != null) {
            sSLSocket.setEnabledProtocols(connectionSpecM10378a.f25937h);
        }
        if (connectionSpecM10378a.m10375a() != null) {
            sSLSocket.setEnabledCipherSuites(connectionSpecM10378a.f25936g);
        }
        return connectionSpec;
    }
}

package p600f0.p601e0.p609k;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p579g0.StringNumberConversions;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Protocol2;

/* JADX INFO: renamed from: f0.e0.k.f, reason: use source file name */
/* JADX INFO: compiled from: Jdk9Platform.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Jdk9Platform extends Platform2 {

    /* JADX INFO: renamed from: d */
    public static final boolean f25778d;

    /* JADX INFO: renamed from: e */
    public static final a f25779e = new a(null);

    /* JADX INFO: renamed from: f0.e0.k.f$a */
    /* JADX INFO: compiled from: Jdk9Platform.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        String property = System.getProperty("java.specification.version");
        Integer intOrNull = property != null ? StringNumberConversions.toIntOrNull(property) : null;
        boolean z2 = true;
        if (intOrNull == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
            } catch (NoSuchMethodException unused) {
                z2 = false;
            }
        } else if (intOrNull.intValue() < 9) {
            z2 = false;
        }
        f25778d = z2;
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* JADX INFO: renamed from: d */
    public void mo10316d(SSLSocket sSLSocket, String str, List<Protocol2> list) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
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
        Intrinsics3.checkExpressionValueIsNotNull(sSLParameters, "sslParameters");
        Object[] array = arrayList2.toArray(new String[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        sSLParameters.setApplicationProtocols((String[]) array);
        sSLSocket.setSSLParameters(sSLParameters);
    }

    @Override // p600f0.p601e0.p609k.Platform2
    /* JADX INFO: renamed from: f */
    public String mo10317f(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        try {
            String applicationProtocol = sSLSocket.getApplicationProtocol();
            if (applicationProtocol != null) {
                if (!Intrinsics3.areEqual(applicationProtocol, "")) {
                    return applicationProtocol;
                }
            }
        } catch (UnsupportedOperationException unused) {
        }
        return null;
    }
}

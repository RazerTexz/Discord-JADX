package p600f0;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p600f0.p601e0.Util7;

/* compiled from: Handshake.kt */
/* renamed from: f0.v, reason: use source file name */
/* loaded from: classes3.dex */
public final class Handshake {

    /* renamed from: a */
    public final Lazy f25969a;

    /* renamed from: b */
    public final TlsVersion f25970b;

    /* renamed from: c */
    public final CipherSuite f25971c;

    /* renamed from: d */
    public final List<Certificate> f25972d;

    /* compiled from: Handshake.kt */
    /* renamed from: f0.v$a */
    public static final class a extends Lambda implements Function0<List<? extends Certificate>> {
        public final /* synthetic */ List $peerCertificatesCopy;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(List list) {
            super(0);
            this.$peerCertificatesCopy = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public List<? extends Certificate> invoke() {
            return this.$peerCertificatesCopy;
        }
    }

    /* compiled from: Handshake.kt */
    /* renamed from: f0.v$b */
    public static final class b extends Lambda implements Function0<List<? extends Certificate>> {
        public final /* synthetic */ Function0 $peerCertificatesFn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Function0 function0) {
            super(0);
            this.$peerCertificatesFn = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public List<? extends Certificate> invoke() {
            try {
                return (List) this.$peerCertificatesFn.invoke();
            } catch (SSLPeerUnverifiedException unused) {
                return Collections2.emptyList();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list, Function0<? extends List<? extends Certificate>> function0) {
        Intrinsics3.checkParameterIsNotNull(tlsVersion, "tlsVersion");
        Intrinsics3.checkParameterIsNotNull(cipherSuite, "cipherSuite");
        Intrinsics3.checkParameterIsNotNull(list, "localCertificates");
        Intrinsics3.checkParameterIsNotNull(function0, "peerCertificatesFn");
        this.f25970b = tlsVersion;
        this.f25971c = cipherSuite;
        this.f25972d = list;
        this.f25969a = LazyJVM.lazy(new b(function0));
    }

    /* renamed from: a */
    public static final Handshake m10395a(SSLSession sSLSession) throws IOException {
        List<Certificate> listEmptyList;
        Intrinsics3.checkParameterIsNotNull(sSLSession, "$this$handshake");
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null".toString());
        }
        int iHashCode = cipherSuite.hashCode();
        if (iHashCode == 1019404634 ? cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") : iHashCode == 1208658923 && cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
            throw new IOException(outline.m883w("cipherSuite == ", cipherSuite));
        }
        CipherSuite cipherSuiteM10373b = CipherSuite.f25927s.m10373b(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null".toString());
        }
        if (Intrinsics3.areEqual("NONE", protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        TlsVersion tlsVersionM10110a = TlsVersion.f25393p.m10110a(protocol);
        try {
            listEmptyList = m10396d(sSLSession.getPeerCertificates());
        } catch (SSLPeerUnverifiedException unused) {
            listEmptyList = Collections2.emptyList();
        }
        return new Handshake(tlsVersionM10110a, cipherSuiteM10373b, m10396d(sSLSession.getLocalCertificates()), new a(listEmptyList));
    }

    /* renamed from: d */
    public static final List<Certificate> m10396d(Certificate[] certificateArr) {
        return certificateArr != null ? Util7.m10132m((Certificate[]) Arrays.copyOf(certificateArr, certificateArr.length)) : Collections2.emptyList();
    }

    /* renamed from: b */
    public final String m10397b(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        Intrinsics3.checkExpressionValueIsNotNull(type, "type");
        return type;
    }

    /* renamed from: c */
    public final List<Certificate> m10398c() {
        return (List) this.f25969a.getValue();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            if (handshake.f25970b == this.f25970b && Intrinsics3.areEqual(handshake.f25971c, this.f25971c) && Intrinsics3.areEqual(handshake.m10398c(), m10398c()) && Intrinsics3.areEqual(handshake.f25972d, this.f25972d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f25972d.hashCode() + ((m10398c().hashCode() + ((this.f25971c.hashCode() + ((this.f25970b.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public String toString() {
        List<Certificate> listM10398c = m10398c();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listM10398c, 10));
        Iterator<T> it = listM10398c.iterator();
        while (it.hasNext()) {
            arrayList.add(m10397b((Certificate) it.next()));
        }
        String string = arrayList.toString();
        StringBuilder sbM836X = outline.m836X("Handshake{", "tlsVersion=");
        sbM836X.append(this.f25970b);
        sbM836X.append(' ');
        sbM836X.append("cipherSuite=");
        sbM836X.append(this.f25971c);
        sbM836X.append(' ');
        sbM836X.append("peerCertificates=");
        sbM836X.append(string);
        sbM836X.append(' ');
        sbM836X.append("localCertificates=");
        List<Certificate> list = this.f25972d;
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(m10397b((Certificate) it2.next()));
        }
        sbM836X.append(arrayList2);
        sbM836X.append('}');
        return sbM836X.toString();
    }
}

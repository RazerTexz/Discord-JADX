package p600f0;

import com.adjust.sdk.Constants;
import com.discord.widgets.chat.input.MentionUtils;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.HttpUrl;
import p600f0.p601e0.Util7;

/* JADX INFO: renamed from: f0.a, reason: use source file name */
/* JADX INFO: compiled from: Address.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Address {

    /* JADX INFO: renamed from: a */
    public final HttpUrl f25353a;

    /* JADX INFO: renamed from: b */
    public final List<Protocol2> f25354b;

    /* JADX INFO: renamed from: c */
    public final List<ConnectionSpec> f25355c;

    /* JADX INFO: renamed from: d */
    public final Dns2 f25356d;

    /* JADX INFO: renamed from: e */
    public final SocketFactory f25357e;

    /* JADX INFO: renamed from: f */
    public final SSLSocketFactory f25358f;

    /* JADX INFO: renamed from: g */
    public final HostnameVerifier f25359g;

    /* JADX INFO: renamed from: h */
    public final CertificatePinner f25360h;

    /* JADX INFO: renamed from: i */
    public final Authenticator2 f25361i;

    /* JADX INFO: renamed from: j */
    public final Proxy f25362j;

    /* JADX INFO: renamed from: k */
    public final ProxySelector f25363k;

    public Address(String str, int i, Dns2 dns2, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator2 authenticator2, Proxy proxy, List<? extends Protocol2> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        Intrinsics3.checkParameterIsNotNull(str, "uriHost");
        Intrinsics3.checkParameterIsNotNull(dns2, "dns");
        Intrinsics3.checkParameterIsNotNull(socketFactory, "socketFactory");
        Intrinsics3.checkParameterIsNotNull(authenticator2, "proxyAuthenticator");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        Intrinsics3.checkParameterIsNotNull(list2, "connectionSpecs");
        Intrinsics3.checkParameterIsNotNull(proxySelector, "proxySelector");
        this.f25356d = dns2;
        this.f25357e = socketFactory;
        this.f25358f = sSLSocketFactory;
        this.f25359g = hostnameVerifier;
        this.f25360h = certificatePinner;
        this.f25361i = authenticator2;
        this.f25362j = proxy;
        this.f25363k = proxySelector;
        HttpUrl.a aVar = new HttpUrl.a();
        String str2 = sSLSocketFactory != null ? Constants.SCHEME : "http";
        Intrinsics3.checkParameterIsNotNull(str2, "scheme");
        if (StringsJVM.equals(str2, "http", true)) {
            aVar.f25986b = "http";
        } else {
            if (!StringsJVM.equals(str2, Constants.SCHEME, true)) {
                throw new IllegalArgumentException(outline.m883w("unexpected scheme: ", str2));
            }
            aVar.f25986b = Constants.SCHEME;
        }
        Intrinsics3.checkParameterIsNotNull(str, "host");
        String strM4337r1 = C3404f.m4337r1(HttpUrl.b.m10414d(HttpUrl.f25974b, str, 0, 0, false, 7));
        if (strM4337r1 == null) {
            throw new IllegalArgumentException(outline.m883w("unexpected host: ", str));
        }
        aVar.f25989e = strM4337r1;
        if (!(1 <= i && 65535 >= i)) {
            throw new IllegalArgumentException(outline.m871q("unexpected port: ", i).toString());
        }
        aVar.f25990f = i;
        this.f25353a = aVar.m10409b();
        this.f25354b = Util7.m10145z(list);
        this.f25355c = Util7.m10145z(list2);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m10101a(Address address) {
        Intrinsics3.checkParameterIsNotNull(address, "that");
        return Intrinsics3.areEqual(this.f25356d, address.f25356d) && Intrinsics3.areEqual(this.f25361i, address.f25361i) && Intrinsics3.areEqual(this.f25354b, address.f25354b) && Intrinsics3.areEqual(this.f25355c, address.f25355c) && Intrinsics3.areEqual(this.f25363k, address.f25363k) && Intrinsics3.areEqual(this.f25362j, address.f25362j) && Intrinsics3.areEqual(this.f25358f, address.f25358f) && Intrinsics3.areEqual(this.f25359g, address.f25359g) && Intrinsics3.areEqual(this.f25360h, address.f25360h) && this.f25353a.f25980h == address.f25353a.f25980h;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (Intrinsics3.areEqual(this.f25353a, address.f25353a) && m10101a(address)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f25360h) + ((Objects.hashCode(this.f25359g) + ((Objects.hashCode(this.f25358f) + ((Objects.hashCode(this.f25362j) + ((this.f25363k.hashCode() + ((this.f25355c.hashCode() + ((this.f25354b.hashCode() + ((this.f25361i.hashCode() + ((this.f25356d.hashCode() + ((this.f25353a.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbM833U;
        Object obj;
        StringBuilder sbM833U2 = outline.m833U("Address{");
        sbM833U2.append(this.f25353a.f25979g);
        sbM833U2.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        sbM833U2.append(this.f25353a.f25980h);
        sbM833U2.append(", ");
        if (this.f25362j != null) {
            sbM833U = outline.m833U("proxy=");
            obj = this.f25362j;
        } else {
            sbM833U = outline.m833U("proxySelector=");
            obj = this.f25363k;
        }
        sbM833U.append(obj);
        sbM833U2.append(sbM833U.toString());
        sbM833U2.append("}");
        return sbM833U2.toString();
    }
}

package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;

/* JADX INFO: renamed from: b.g.a.c.g0.u.q, reason: use source file name */
/* JADX INFO: compiled from: InetSocketAddressSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class InetSocketAddressSerializer extends StdScalarSerializer<InetSocketAddress> {
    public InetSocketAddressSerializer() {
        super(InetSocketAddress.class);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public /* bridge */ /* synthetic */ void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        m2071p((InetSocketAddress) obj, jsonGenerator);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.StdScalarSerializer, p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
        WritableTypeId writableTypeIdM1958d = typeSerializer.m1958d(inetSocketAddress, JsonToken2.VALUE_STRING);
        writableTypeIdM1958d.f4585b = InetSocketAddress.class;
        WritableTypeId writableTypeIdMo1959e = typeSerializer.mo1959e(jsonGenerator, writableTypeIdM1958d);
        m2071p(inetSocketAddress, jsonGenerator);
        typeSerializer.mo1960f(jsonGenerator, writableTypeIdMo1959e);
    }

    /* JADX INFO: renamed from: p */
    public void m2071p(InetSocketAddress inetSocketAddress, JsonGenerator jsonGenerator) throws IOException {
        String strSubstring;
        InetAddress address = inetSocketAddress.getAddress();
        String hostName = address == null ? inetSocketAddress.getHostName() : address.toString().trim();
        int iIndexOf = hostName.indexOf(47);
        if (iIndexOf >= 0) {
            if (iIndexOf == 0) {
                if (address instanceof Inet6Address) {
                    StringBuilder sbM833U = outline.m833U("[");
                    sbM833U.append(hostName.substring(1));
                    sbM833U.append("]");
                    strSubstring = sbM833U.toString();
                } else {
                    strSubstring = hostName.substring(1);
                }
                hostName = strSubstring;
            } else {
                hostName = hostName.substring(0, iIndexOf);
            }
        }
        StringBuilder sbM836X = outline.m836X(hostName, ":");
        sbM836X.append(inetSocketAddress.getPort());
        jsonGenerator.mo1658j0(sbM836X.toString());
    }
}

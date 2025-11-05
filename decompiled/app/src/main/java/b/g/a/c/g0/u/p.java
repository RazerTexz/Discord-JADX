package b.g.a.c.g0.u;

import b.g.a.a.i;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.net.InetAddress;

/* compiled from: InetAddressSerializer.java */
/* loaded from: classes3.dex */
public class p extends p0<InetAddress> implements b.g.a.c.g0.i {
    public final boolean _asNumeric;

    public p() {
        super(InetAddress.class);
        this._asNumeric = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    @Override // b.g.a.c.g0.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        boolean z2;
        i.d dVarL = l(xVar, dVar, this._handledType);
        if (dVarL != null) {
            i.c cVarE = dVarL.e();
            z2 = cVarE.f() || cVarE == i.c.ARRAY;
        }
        return z2 != this._asNumeric ? new p(z2) : this;
    }

    @Override // b.g.a.c.n
    public /* bridge */ /* synthetic */ void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        p((InetAddress) obj, dVar);
    }

    @Override // b.g.a.c.g0.u.p0, b.g.a.c.n
    public void g(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        InetAddress inetAddress = (InetAddress) obj;
        b.g.a.b.s.b bVarD = gVar.d(inetAddress, b.g.a.b.h.VALUE_STRING);
        bVarD.f675b = InetAddress.class;
        b.g.a.b.s.b bVarE = gVar.e(dVar, bVarD);
        p(inetAddress, dVar);
        gVar.f(dVar, bVarE);
    }

    public void p(InetAddress inetAddress, b.g.a.b.d dVar) throws IOException {
        String strTrim;
        if (this._asNumeric) {
            strTrim = inetAddress.getHostAddress();
        } else {
            strTrim = inetAddress.toString().trim();
            int iIndexOf = strTrim.indexOf(47);
            if (iIndexOf >= 0) {
                strTrim = iIndexOf == 0 ? strTrim.substring(1) : strTrim.substring(0, iIndexOf);
            }
        }
        dVar.j0(strTrim);
    }

    public p(boolean z2) {
        super(InetAddress.class);
        this._asNumeric = z2;
    }
}

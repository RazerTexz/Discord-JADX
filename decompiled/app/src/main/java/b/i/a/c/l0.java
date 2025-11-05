package b.i.a.c;

import android.net.Uri;
import android.os.Bundle;
import b.i.a.c.p1;
import b.i.a.c.w0;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class l0 implements w0.a {
    public static final /* synthetic */ l0 a = new l0();

    @Override // b.i.a.c.w0.a
    public final w0 a(Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3;
        p1.b bVar = new p1.b();
        bVar.a = bundle.getCharSequence(p1.b(0));
        bVar.f1050b = bundle.getCharSequence(p1.b(1));
        bVar.c = bundle.getCharSequence(p1.b(2));
        bVar.d = bundle.getCharSequence(p1.b(3));
        bVar.e = bundle.getCharSequence(p1.b(4));
        bVar.f = bundle.getCharSequence(p1.b(5));
        bVar.g = bundle.getCharSequence(p1.b(6));
        bVar.h = (Uri) bundle.getParcelable(p1.b(7));
        byte[] byteArray = bundle.getByteArray(p1.b(10));
        Integer numValueOf = bundle.containsKey(p1.b(29)) ? Integer.valueOf(bundle.getInt(p1.b(29))) : null;
        bVar.k = byteArray != null ? (byte[]) byteArray.clone() : null;
        bVar.l = numValueOf;
        bVar.m = (Uri) bundle.getParcelable(p1.b(11));
        bVar.f1052x = bundle.getCharSequence(p1.b(22));
        bVar.f1053y = bundle.getCharSequence(p1.b(23));
        bVar.f1054z = bundle.getCharSequence(p1.b(24));
        bVar.C = bundle.getCharSequence(p1.b(27));
        bVar.D = bundle.getCharSequence(p1.b(28));
        bVar.E = bundle.getBundle(p1.b(1000));
        if (bundle.containsKey(p1.b(8)) && (bundle3 = bundle.getBundle(p1.b(8))) != null) {
            int i = d2.j;
            bVar.i = (d2) o0.a.a(bundle3);
        }
        if (bundle.containsKey(p1.b(9)) && (bundle2 = bundle.getBundle(p1.b(9))) != null) {
            int i2 = d2.j;
            bVar.j = (d2) o0.a.a(bundle2);
        }
        if (bundle.containsKey(p1.b(12))) {
            bVar.n = Integer.valueOf(bundle.getInt(p1.b(12)));
        }
        if (bundle.containsKey(p1.b(13))) {
            bVar.o = Integer.valueOf(bundle.getInt(p1.b(13)));
        }
        if (bundle.containsKey(p1.b(14))) {
            bVar.p = Integer.valueOf(bundle.getInt(p1.b(14)));
        }
        if (bundle.containsKey(p1.b(15))) {
            bVar.q = Boolean.valueOf(bundle.getBoolean(p1.b(15)));
        }
        if (bundle.containsKey(p1.b(16))) {
            bVar.r = Integer.valueOf(bundle.getInt(p1.b(16)));
        }
        if (bundle.containsKey(p1.b(17))) {
            bVar.f1051s = Integer.valueOf(bundle.getInt(p1.b(17)));
        }
        if (bundle.containsKey(p1.b(18))) {
            bVar.t = Integer.valueOf(bundle.getInt(p1.b(18)));
        }
        if (bundle.containsKey(p1.b(19))) {
            bVar.u = Integer.valueOf(bundle.getInt(p1.b(19)));
        }
        if (bundle.containsKey(p1.b(20))) {
            bVar.v = Integer.valueOf(bundle.getInt(p1.b(20)));
        }
        if (bundle.containsKey(p1.b(21))) {
            bVar.w = Integer.valueOf(bundle.getInt(p1.b(21)));
        }
        if (bundle.containsKey(p1.b(25))) {
            bVar.A = Integer.valueOf(bundle.getInt(p1.b(25)));
        }
        if (bundle.containsKey(p1.b(26))) {
            bVar.B = Integer.valueOf(bundle.getInt(p1.b(26)));
        }
        return bVar.a();
    }
}

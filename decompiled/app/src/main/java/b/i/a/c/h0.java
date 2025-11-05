package b.i.a.c;

import android.os.Bundle;
import b.i.a.c.j1;
import b.i.a.c.w0;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class h0 implements w0.a {
    public static final /* synthetic */ h0 a = new h0();

    @Override // b.i.a.c.w0.a
    public final w0 a(Bundle bundle) {
        j1 j1Var = j1.j;
        j1.b bVar = new j1.b();
        if (bundle != null) {
            ClassLoader classLoader = b.i.a.c.f3.f.class.getClassLoader();
            int i = b.i.a.c.f3.e0.a;
            bundle.setClassLoader(classLoader);
        }
        int i2 = 0;
        String string = bundle.getString(j1.d(0));
        j1 j1Var2 = j1.j;
        bVar.a = (String) j1.b(string, j1Var2.l);
        bVar.f1021b = (String) j1.b(bundle.getString(j1.d(1)), j1Var2.m);
        bVar.c = (String) j1.b(bundle.getString(j1.d(2)), j1Var2.n);
        bVar.d = bundle.getInt(j1.d(3), j1Var2.o);
        bVar.e = bundle.getInt(j1.d(4), j1Var2.p);
        bVar.f = bundle.getInt(j1.d(5), j1Var2.q);
        bVar.g = bundle.getInt(j1.d(6), j1Var2.r);
        bVar.h = (String) j1.b(bundle.getString(j1.d(7)), j1Var2.t);
        bVar.i = (Metadata) j1.b((Metadata) bundle.getParcelable(j1.d(8)), j1Var2.u);
        bVar.j = (String) j1.b(bundle.getString(j1.d(9)), j1Var2.v);
        bVar.k = (String) j1.b(bundle.getString(j1.d(10)), j1Var2.w);
        bVar.l = bundle.getInt(j1.d(11), j1Var2.f1018x);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strD = j1.d(12);
            String string2 = Integer.toString(i2, 36);
            StringBuilder sb = new StringBuilder(String.valueOf(string2).length() + String.valueOf(strD).length() + 1);
            sb.append(strD);
            sb.append("_");
            sb.append(string2);
            byte[] byteArray = bundle.getByteArray(sb.toString());
            if (byteArray == null) {
                bVar.m = arrayList;
                bVar.n = (DrmInitData) bundle.getParcelable(j1.d(13));
                String strD2 = j1.d(14);
                j1 j1Var3 = j1.j;
                bVar.o = bundle.getLong(strD2, j1Var3.A);
                bVar.p = bundle.getInt(j1.d(15), j1Var3.B);
                bVar.q = bundle.getInt(j1.d(16), j1Var3.C);
                bVar.r = bundle.getFloat(j1.d(17), j1Var3.D);
                bVar.f1022s = bundle.getInt(j1.d(18), j1Var3.E);
                bVar.t = bundle.getFloat(j1.d(19), j1Var3.F);
                bVar.u = bundle.getByteArray(j1.d(20));
                bVar.v = bundle.getInt(j1.d(21), j1Var3.H);
                int i3 = b.i.a.c.g3.n.j;
                bVar.w = (b.i.a.c.g3.n) b.i.a.c.f3.f.c(b.i.a.c.g3.a.a, bundle.getBundle(j1.d(22)));
                bVar.f1023x = bundle.getInt(j1.d(23), j1Var3.J);
                bVar.f1024y = bundle.getInt(j1.d(24), j1Var3.K);
                bVar.f1025z = bundle.getInt(j1.d(25), j1Var3.L);
                bVar.A = bundle.getInt(j1.d(26), j1Var3.M);
                bVar.B = bundle.getInt(j1.d(27), j1Var3.N);
                bVar.C = bundle.getInt(j1.d(28), j1Var3.O);
                bVar.D = bundle.getInt(j1.d(29), j1Var3.P);
                return bVar.a();
            }
            arrayList.add(byteArray);
            i2++;
        }
    }
}

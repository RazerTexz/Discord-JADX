package p007b.p225i.p226a.p242c;

import android.os.Bundle;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import p007b.p225i.p226a.p242c.Bundleable;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.BundleableUtil;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.C2764a;
import p007b.p225i.p226a.p242c.p260g3.ColorInfo;

/* JADX INFO: renamed from: b.i.a.c.h0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2802h0 implements Bundleable.a {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ C2802h0 f7051a = new C2802h0();

    @Override // p007b.p225i.p226a.p242c.Bundleable.a
    /* JADX INFO: renamed from: a */
    public final Bundleable mo2576a(Bundle bundle) {
        Format2 format2 = Format2.f7125j;
        Format2.b bVar = new Format2.b();
        if (bundle != null) {
            ClassLoader classLoader = BundleableUtil.class.getClassLoader();
            int i = Util2.f6708a;
            bundle.setClassLoader(classLoader);
        }
        int i2 = 0;
        String string = bundle.getString(Format2.m3274d(0));
        Format2 format22 = Format2.f7125j;
        bVar.f7163a = (String) Format2.m3273b(string, format22.f7144l);
        bVar.f7164b = (String) Format2.m3273b(bundle.getString(Format2.m3274d(1)), format22.f7145m);
        bVar.f7165c = (String) Format2.m3273b(bundle.getString(Format2.m3274d(2)), format22.f7146n);
        bVar.f7166d = bundle.getInt(Format2.m3274d(3), format22.f7147o);
        bVar.f7167e = bundle.getInt(Format2.m3274d(4), format22.f7148p);
        bVar.f7168f = bundle.getInt(Format2.m3274d(5), format22.f7149q);
        bVar.f7169g = bundle.getInt(Format2.m3274d(6), format22.f7150r);
        bVar.f7170h = (String) Format2.m3273b(bundle.getString(Format2.m3274d(7)), format22.f7152t);
        bVar.f7171i = (Metadata) Format2.m3273b((Metadata) bundle.getParcelable(Format2.m3274d(8)), format22.f7153u);
        bVar.f7172j = (String) Format2.m3273b(bundle.getString(Format2.m3274d(9)), format22.f7154v);
        bVar.f7173k = (String) Format2.m3273b(bundle.getString(Format2.m3274d(10)), format22.f7155w);
        bVar.f7174l = bundle.getInt(Format2.m3274d(11), format22.f7156x);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strM3274d = Format2.m3274d(12);
            String string2 = Integer.toString(i2, 36);
            StringBuilder sb = new StringBuilder(String.valueOf(string2).length() + String.valueOf(strM3274d).length() + 1);
            sb.append(strM3274d);
            sb.append("_");
            sb.append(string2);
            byte[] byteArray = bundle.getByteArray(sb.toString());
            if (byteArray == null) {
                bVar.f7175m = arrayList;
                bVar.f7176n = (DrmInitData) bundle.getParcelable(Format2.m3274d(13));
                String strM3274d2 = Format2.m3274d(14);
                Format2 format23 = Format2.f7125j;
                bVar.f7177o = bundle.getLong(strM3274d2, format23.f7127A);
                bVar.f7178p = bundle.getInt(Format2.m3274d(15), format23.f7128B);
                bVar.f7179q = bundle.getInt(Format2.m3274d(16), format23.f7129C);
                bVar.f7180r = bundle.getFloat(Format2.m3274d(17), format23.f7130D);
                bVar.f7181s = bundle.getInt(Format2.m3274d(18), format23.f7131E);
                bVar.f7182t = bundle.getFloat(Format2.m3274d(19), format23.f7132F);
                bVar.f7183u = bundle.getByteArray(Format2.m3274d(20));
                bVar.f7184v = bundle.getInt(Format2.m3274d(21), format23.f7134H);
                int i3 = ColorInfo.f6843j;
                bVar.f7185w = (ColorInfo) BundleableUtil.m3021c(C2764a.f6809a, bundle.getBundle(Format2.m3274d(22)));
                bVar.f7186x = bundle.getInt(Format2.m3274d(23), format23.f7136J);
                bVar.f7187y = bundle.getInt(Format2.m3274d(24), format23.f7137K);
                bVar.f7188z = bundle.getInt(Format2.m3274d(25), format23.f7138L);
                bVar.f7159A = bundle.getInt(Format2.m3274d(26), format23.f7139M);
                bVar.f7160B = bundle.getInt(Format2.m3274d(27), format23.f7140N);
                bVar.f7161C = bundle.getInt(Format2.m3274d(28), format23.f7141O);
                bVar.f7162D = bundle.getInt(Format2.m3274d(29), format23.f7142P);
                return bVar.m3277a();
            }
            arrayList.add(byteArray);
            i2++;
        }
    }
}

package d0.e0.p.d.m0.e.b;

import java.util.List;

/* compiled from: PackagePartProvider.kt */
/* loaded from: classes3.dex */
public interface v {

    /* compiled from: PackagePartProvider.kt */
    public static final class a implements v {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.e.b.v
        public List<String> findPackageParts(String str) {
            d0.z.d.m.checkNotNullParameter(str, "packageFqName");
            return d0.t.n.emptyList();
        }
    }

    List<String> findPackageParts(String str);
}

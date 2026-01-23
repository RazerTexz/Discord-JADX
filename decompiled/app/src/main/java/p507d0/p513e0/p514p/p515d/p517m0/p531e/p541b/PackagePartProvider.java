package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import java.util.List;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.v, reason: use source file name */
/* JADX INFO: compiled from: PackagePartProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface PackagePartProvider {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.v$a */
    /* JADX INFO: compiled from: PackagePartProvider.kt */
    public static final class a implements PackagePartProvider {

        /* JADX INFO: renamed from: a */
        public static final a f23635a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.PackagePartProvider
        public List<String> findPackageParts(String str) {
            Intrinsics3.checkNotNullParameter(str, "packageFqName");
            return Collections2.emptyList();
        }
    }

    List<String> findPackageParts(String str);
}

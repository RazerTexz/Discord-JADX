package p507d0;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e, reason: use source file name */
/* JADX INFO: compiled from: KotlinVersion.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinVersion implements Comparable<KotlinVersion> {

    /* JADX INFO: renamed from: j */
    public static final KotlinVersion f22290j;

    /* JADX INFO: renamed from: k */
    public final int f22291k;

    /* JADX INFO: renamed from: l */
    public final int f22292l;

    /* JADX INFO: renamed from: m */
    public final int f22293m;

    /* JADX INFO: renamed from: n */
    public final int f22294n;

    /* JADX INFO: renamed from: d0.e$a */
    /* JADX INFO: compiled from: KotlinVersion.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
        f22290j = KotlinVersion2.get();
    }

    public KotlinVersion(int i, int i2, int i3) {
        this.f22292l = i;
        this.f22293m = i2;
        this.f22294n = i3;
        if (i >= 0 && 255 >= i && i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3) {
            this.f22291k = (i << 16) + (i2 << 8) + i3;
            return;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + '.' + i2 + '.' + i3).toString());
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(KotlinVersion kotlinVersion) {
        return compareTo2(kotlinVersion);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KotlinVersion)) {
            obj = null;
        }
        KotlinVersion kotlinVersion = (KotlinVersion) obj;
        return kotlinVersion != null && this.f22291k == kotlinVersion.f22291k;
    }

    public int hashCode() {
        return this.f22291k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22292l);
        sb.append('.');
        sb.append(this.f22293m);
        sb.append('.');
        sb.append(this.f22294n);
        return sb.toString();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(KotlinVersion kotlinVersion) {
        Intrinsics3.checkNotNullParameter(kotlinVersion, "other");
        return this.f22291k - kotlinVersion.f22291k;
    }
}

package b.i.a.c.e3.b0;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.TreeSet;

/* compiled from: CachedContent.java */
/* loaded from: classes3.dex */
public final class i {
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public final String f930b;
    public final TreeSet<s> c = new TreeSet<>();
    public final ArrayList<a> d = new ArrayList<>();
    public n e;

    /* compiled from: CachedContent.java */
    public static final class a {
        public final long a;

        /* renamed from: b, reason: collision with root package name */
        public final long f931b;

        public a(long j, long j2) {
            this.a = j;
            this.f931b = j2;
        }
    }

    public i(int i, String str, n nVar) {
        this.a = i;
        this.f930b = str;
        this.e = nVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(long j, long j2) {
        boolean z2;
        for (int i = 0; i < this.d.size(); i++) {
            a aVar = this.d.get(i);
            long j3 = aVar.f931b;
            if (j3 == -1) {
                z2 = j >= aVar.a;
            } else if (j2 != -1) {
                long j4 = aVar.a;
                if (j4 > j || j + j2 > j4 + j3) {
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.a == iVar.a && this.f930b.equals(iVar.f930b) && this.c.equals(iVar.c) && this.e.equals(iVar.e);
    }

    public int hashCode() {
        return this.e.hashCode() + b.d.b.a.a.m(this.f930b, this.a * 31, 31);
    }
}

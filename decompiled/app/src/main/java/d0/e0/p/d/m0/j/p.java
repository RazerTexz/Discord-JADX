package d0.e0.p.d.m0.j;

import d0.g0.t;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DescriptorRenderer.kt */
/* loaded from: classes3.dex */
public abstract class p {
    public static final p j;
    public static final p k;
    public static final /* synthetic */ p[] l;

    /* compiled from: DescriptorRenderer.kt */
    public static final class a extends p {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // d0.e0.p.d.m0.j.p
        public String escape(String str) {
            d0.z.d.m.checkNotNullParameter(str, "string");
            return t.replace$default(t.replace$default(str, "<", "&lt;", false, 4, (Object) null), ">", "&gt;", false, 4, (Object) null);
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    public static final class b extends p {
        public b(String str, int i) {
            super(str, i, null);
        }

        @Override // d0.e0.p.d.m0.j.p
        public String escape(String str) {
            d0.z.d.m.checkNotNullParameter(str, "string");
            return str;
        }
    }

    static {
        b bVar = new b("PLAIN", 0);
        j = bVar;
        a aVar = new a("HTML", 1);
        k = aVar;
        l = new p[]{bVar, aVar};
    }

    public p(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static p valueOf(String str) {
        d0.z.d.m.checkNotNullParameter(str, "value");
        return (p) Enum.valueOf(p.class, str);
    }

    public static p[] values() {
        p[] pVarArr = l;
        p[] pVarArr2 = new p[pVarArr.length];
        System.arraycopy(pVarArr, 0, pVarArr2, 0, pVarArr.length);
        return pVarArr2;
    }

    public abstract String escape(String str);
}

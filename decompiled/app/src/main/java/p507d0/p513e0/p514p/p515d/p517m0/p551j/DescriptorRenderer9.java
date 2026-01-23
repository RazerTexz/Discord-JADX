package p507d0.p513e0.p514p.p515d.p517m0.p551j;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: d0.e0.p.d.m0.j.p, reason: use source file name */
/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DescriptorRenderer9 {

    /* JADX INFO: renamed from: j */
    public static final DescriptorRenderer9 f24329j;

    /* JADX INFO: renamed from: k */
    public static final DescriptorRenderer9 f24330k;

    /* JADX INFO: renamed from: l */
    public static final /* synthetic */ DescriptorRenderer9[] f24331l;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.p$a */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class a extends DescriptorRenderer9 {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer9
        public String escape(String str) {
            Intrinsics3.checkNotNullParameter(str, "string");
            return StringsJVM.replace$default(StringsJVM.replace$default(str, "<", "&lt;", false, 4, (Object) null), ">", "&gt;", false, 4, (Object) null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.p$b */
    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class b extends DescriptorRenderer9 {
        public b(String str, int i) {
            super(str, i, null);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.DescriptorRenderer9
        public String escape(String str) {
            Intrinsics3.checkNotNullParameter(str, "string");
            return str;
        }
    }

    static {
        b bVar = new b("PLAIN", 0);
        f24329j = bVar;
        a aVar = new a("HTML", 1);
        f24330k = aVar;
        f24331l = new DescriptorRenderer9[]{bVar, aVar};
    }

    public DescriptorRenderer9(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static DescriptorRenderer9 valueOf(String str) {
        Intrinsics3.checkNotNullParameter(str, "value");
        return (DescriptorRenderer9) Enum.valueOf(DescriptorRenderer9.class, str);
    }

    public static DescriptorRenderer9[] values() {
        DescriptorRenderer9[] descriptorRenderer9Arr = f24331l;
        DescriptorRenderer9[] descriptorRenderer9Arr2 = new DescriptorRenderer9[descriptorRenderer9Arr.length];
        System.arraycopy(descriptorRenderer9Arr, 0, descriptorRenderer9Arr2, 0, descriptorRenderer9Arr.length);
        return descriptorRenderer9Arr2;
    }

    public abstract String escape(String str);
}

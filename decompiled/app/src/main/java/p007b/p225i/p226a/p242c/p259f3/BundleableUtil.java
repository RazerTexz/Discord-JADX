package p007b.p225i.p226a.p242c.p259f3;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p242c.Bundleable;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.AbstractIndexedListIterator;
import p007b.p225i.p355b.p357b.ImmutableCollection;
import p007b.p225i.p355b.p357b.ImmutableList2;

/* compiled from: BundleableUtil.java */
/* renamed from: b.i.a.c.f3.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class BundleableUtil {
    /* renamed from: a */
    public static <T extends Bundleable> ImmutableList2<T> m3019a(Bundleable.a<T> aVar, List<Bundle> list) {
        AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
        C3404f.m4189A(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            Bundle bundle = list.get(i);
            Objects.requireNonNull(bundle);
            Bundleable bundleableMo2576a = aVar.mo2576a(bundle);
            Objects.requireNonNull(bundleableMo2576a);
            int i3 = i2 + 1;
            if (objArrCopyOf.length < i3) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, ImmutableCollection.b.m6260a(objArrCopyOf.length, i3));
            }
            objArrCopyOf[i2] = bundleableMo2576a;
            i++;
            i2 = i3;
        }
        return ImmutableList2.m6262l(objArrCopyOf, i2);
    }

    /* renamed from: b */
    public static <T extends Bundleable> List<T> m3020b(Bundleable.a<T> aVar, @Nullable List<Bundle> list, List<T> list2) {
        return list == null ? list2 : m3019a(aVar, list);
    }

    @Nullable
    /* renamed from: c */
    public static <T extends Bundleable> T m3021c(Bundleable.a<T> aVar, @Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return (T) aVar.mo2576a(bundle);
    }
}

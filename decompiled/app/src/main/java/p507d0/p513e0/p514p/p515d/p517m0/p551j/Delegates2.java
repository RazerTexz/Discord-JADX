package p507d0.p513e0.p514p.p515d.p517m0.p551j;

import kotlin.reflect.KProperty;
import p507d0.p509b0.ObservableProperty;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: d0.e0.p.d.m0.j.j, reason: use source file name */
/* JADX INFO: compiled from: Delegates.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Delegates2<T> extends ObservableProperty<T> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Object f24312a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DescriptorRendererOptionsImpl f24313b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Delegates2(Object obj, Object obj2, DescriptorRendererOptionsImpl descriptorRendererOptionsImpl) {
        super(obj2);
        this.f24312a = obj;
        this.f24313b = descriptorRendererOptionsImpl;
    }

    @Override // p507d0.p509b0.ObservableProperty
    public boolean beforeChange(KProperty<?> kProperty, T t, T t2) {
        Intrinsics3.checkNotNullParameter(kProperty, "property");
        if (this.f24313b.isLocked()) {
            throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
        }
        return true;
    }
}

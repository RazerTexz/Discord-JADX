package b.f.d.d;

import com.facebook.common.internal.Supplier;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Suppliers.java */
/* loaded from: classes.dex */
public final class k<T> implements Supplier<T> {
    public final /* synthetic */ Object a;

    public k(Object obj) {
        this.a = obj;
    }

    @Override // com.facebook.common.internal.Supplier
    public T get() {
        return (T) this.a;
    }
}

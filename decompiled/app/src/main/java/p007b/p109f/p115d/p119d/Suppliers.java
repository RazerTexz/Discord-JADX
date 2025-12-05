package p007b.p109f.p115d.p119d;

import com.facebook.common.internal.Supplier;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Suppliers.java */
/* renamed from: b.f.d.d.k, reason: use source file name */
/* loaded from: classes.dex */
public final class Suppliers<T> implements Supplier<T> {

    /* renamed from: a */
    public final /* synthetic */ Object f3100a;

    public Suppliers(Object obj) {
        this.f3100a = obj;
    }

    @Override // com.facebook.common.internal.Supplier
    public T get() {
        return (T) this.f3100a;
    }
}

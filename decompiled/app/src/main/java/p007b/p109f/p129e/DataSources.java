package p007b.p109f.p129e;

import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: DataSources.java */
/* renamed from: b.f.e.e, reason: use source file name */
/* loaded from: classes.dex */
public final class DataSources<T> implements Supplier<DataSource<T>> {

    /* renamed from: a */
    public final /* synthetic */ Throwable f3159a;

    public DataSources(Throwable th) {
        this.f3159a = th;
    }

    @Override // com.facebook.common.internal.Supplier
    public Object get() {
        return AnimatableValueParser.m457N0(this.f3159a);
    }
}

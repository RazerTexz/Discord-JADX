package p007b.p109f.p129e;

import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p117b.CallerThreadExecutor;
import p007b.p109f.p115d.p119d.Objects2;

/* compiled from: FirstAvailableDataSourceSupplier.java */
/* renamed from: b.f.e.g, reason: use source file name */
/* loaded from: classes.dex */
public class FirstAvailableDataSourceSupplier<T> implements Supplier<DataSource<T>> {

    /* renamed from: a */
    public final List<Supplier<DataSource<T>>> f3160a;

    /* compiled from: FirstAvailableDataSourceSupplier.java */
    /* renamed from: b.f.e.g$b */
    public class b extends AbstractDataSource3<T> {

        /* renamed from: h */
        public int f3161h = 0;

        /* renamed from: i */
        public DataSource<T> f3162i = null;

        /* renamed from: j */
        public DataSource<T> f3163j = null;

        /* compiled from: FirstAvailableDataSourceSupplier.java */
        /* renamed from: b.f.e.g$b$a */
        public class a implements DataSubscriber<T> {
            public a(a aVar) {
            }

            @Override // p007b.p109f.p129e.DataSubscriber
            public void onCancellation(DataSource<T> dataSource) {
            }

            @Override // p007b.p109f.p129e.DataSubscriber
            public void onFailure(DataSource<T> dataSource) {
                b.m1031o(b.this, dataSource);
            }

            @Override // p007b.p109f.p129e.DataSubscriber
            public void onNewResult(DataSource<T> dataSource) throws Throwable {
                DataSource<T> dataSource2;
                if (!dataSource.mo1018b()) {
                    if (((AbstractDataSource3) dataSource).mo1019c()) {
                        b.m1031o(b.this, dataSource);
                        return;
                    }
                    return;
                }
                b bVar = b.this;
                Objects.requireNonNull(bVar);
                AbstractDataSource3 abstractDataSource3 = (AbstractDataSource3) dataSource;
                boolean zMo1019c = abstractDataSource3.mo1019c();
                synchronized (bVar) {
                    if (dataSource == bVar.f3162i && dataSource != (dataSource2 = bVar.f3163j)) {
                        if (dataSource2 == null || zMo1019c) {
                            bVar.f3163j = dataSource;
                        } else {
                            dataSource2 = null;
                        }
                        if (dataSource2 != null) {
                            dataSource2.close();
                        }
                    }
                }
                if (dataSource == bVar.m1032p()) {
                    bVar.m1029m(null, abstractDataSource3.mo1019c(), abstractDataSource3.f3152a);
                }
            }

            @Override // p007b.p109f.p129e.DataSubscriber
            public void onProgressUpdate(DataSource<T> dataSource) {
                b.this.m1028l(Math.max(b.this.getProgress(), ((AbstractDataSource3) dataSource).getProgress()));
            }
        }

        public b() {
            if (m1033q()) {
                return;
            }
            m1027k(new RuntimeException("No data source supplier or supplier returned null."), null);
        }

        /* renamed from: o */
        public static void m1031o(b bVar, DataSource dataSource) {
            boolean z2;
            synchronized (bVar) {
                if (bVar.m1025i() || dataSource != bVar.f3162i) {
                    z2 = false;
                } else {
                    bVar.f3162i = null;
                    z2 = true;
                }
            }
            if (z2) {
                if (dataSource != bVar.m1032p() && dataSource != null) {
                    dataSource.close();
                }
                if (bVar.m1033q()) {
                    return;
                }
                bVar.m1027k(dataSource.mo1020d(), dataSource.mo1017a());
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x000f  */
        @Override // p007b.p109f.p129e.AbstractDataSource3, com.facebook.datasource.DataSource
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized boolean mo1018b() {
            boolean z2;
            DataSource<T> dataSourceM1032p = m1032p();
            if (dataSourceM1032p != null) {
                z2 = dataSourceM1032p.mo1018b();
            }
            return z2;
        }

        @Override // p007b.p109f.p129e.AbstractDataSource3, com.facebook.datasource.DataSource
        public boolean close() {
            synchronized (this) {
                if (!super.close()) {
                    return false;
                }
                DataSource<T> dataSource = this.f3162i;
                this.f3162i = null;
                DataSource<T> dataSource2 = this.f3163j;
                this.f3163j = null;
                if (dataSource2 != null) {
                    dataSource2.close();
                }
                if (dataSource == null) {
                    return true;
                }
                dataSource.close();
                return true;
            }
        }

        @Override // p007b.p109f.p129e.AbstractDataSource3, com.facebook.datasource.DataSource
        public synchronized T getResult() {
            DataSource<T> dataSourceM1032p;
            dataSourceM1032p = m1032p();
            return dataSourceM1032p != null ? dataSourceM1032p.getResult() : null;
        }

        /* renamed from: p */
        public final synchronized DataSource<T> m1032p() {
            return this.f3163j;
        }

        /* renamed from: q */
        public final boolean m1033q() {
            Supplier<DataSource<T>> supplier;
            boolean z2;
            synchronized (this) {
                if (m1025i() || this.f3161h >= FirstAvailableDataSourceSupplier.this.f3160a.size()) {
                    supplier = null;
                } else {
                    List<Supplier<DataSource<T>>> list = FirstAvailableDataSourceSupplier.this.f3160a;
                    int i = this.f3161h;
                    this.f3161h = i + 1;
                    supplier = list.get(i);
                }
            }
            DataSource<T> dataSource = supplier != null ? supplier.get() : null;
            synchronized (this) {
                if (m1025i()) {
                    z2 = false;
                } else {
                    this.f3162i = dataSource;
                    z2 = true;
                }
            }
            if (z2 && dataSource != null) {
                dataSource.mo1022f(new a(null), CallerThreadExecutor.f3078j);
                return true;
            }
            if (dataSource != null) {
                dataSource.close();
            }
            return false;
        }
    }

    public FirstAvailableDataSourceSupplier(List<Supplier<DataSource<T>>> list) {
        AnimatableValueParser.m535k(!list.isEmpty(), "List of suppliers is empty!");
        this.f3160a = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FirstAvailableDataSourceSupplier) {
            return AnimatableValueParser.m520g0(this.f3160a, ((FirstAvailableDataSourceSupplier) obj).f3160a);
        }
        return false;
    }

    @Override // com.facebook.common.internal.Supplier
    public Object get() {
        return new b();
    }

    public int hashCode() {
        return this.f3160a.hashCode();
    }

    public String toString() {
        Objects2 objects2M526h2 = AnimatableValueParser.m526h2(this);
        objects2M526h2.m971c("list", this.f3160a);
        return objects2M526h2.toString();
    }
}

package b.f.e;

import b.f.d.d.i;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import java.util.List;
import java.util.Objects;

/* compiled from: FirstAvailableDataSourceSupplier.java */
/* loaded from: classes.dex */
public class g<T> implements Supplier<DataSource<T>> {
    public final List<Supplier<DataSource<T>>> a;

    /* compiled from: FirstAvailableDataSourceSupplier.java */
    public class b extends c<T> {
        public int h = 0;
        public DataSource<T> i = null;
        public DataSource<T> j = null;

        /* compiled from: FirstAvailableDataSourceSupplier.java */
        public class a implements f<T> {
            public a(a aVar) {
            }

            @Override // b.f.e.f
            public void onCancellation(DataSource<T> dataSource) {
            }

            @Override // b.f.e.f
            public void onFailure(DataSource<T> dataSource) {
                b.o(b.this, dataSource);
            }

            @Override // b.f.e.f
            public void onNewResult(DataSource<T> dataSource) throws Throwable {
                DataSource<T> dataSource2;
                if (!dataSource.b()) {
                    if (((c) dataSource).c()) {
                        b.o(b.this, dataSource);
                        return;
                    }
                    return;
                }
                b bVar = b.this;
                Objects.requireNonNull(bVar);
                c cVar = (c) dataSource;
                boolean zC = cVar.c();
                synchronized (bVar) {
                    if (dataSource == bVar.i && dataSource != (dataSource2 = bVar.j)) {
                        if (dataSource2 == null || zC) {
                            bVar.j = dataSource;
                        } else {
                            dataSource2 = null;
                        }
                        if (dataSource2 != null) {
                            dataSource2.close();
                        }
                    }
                }
                if (dataSource == bVar.p()) {
                    bVar.m(null, cVar.c(), cVar.a);
                }
            }

            @Override // b.f.e.f
            public void onProgressUpdate(DataSource<T> dataSource) {
                b.this.l(Math.max(b.this.getProgress(), ((c) dataSource).getProgress()));
            }
        }

        public b() {
            if (q()) {
                return;
            }
            k(new RuntimeException("No data source supplier or supplier returned null."), null);
        }

        public static void o(b bVar, DataSource dataSource) {
            boolean z2;
            synchronized (bVar) {
                if (bVar.i() || dataSource != bVar.i) {
                    z2 = false;
                } else {
                    bVar.i = null;
                    z2 = true;
                }
            }
            if (z2) {
                if (dataSource != bVar.p() && dataSource != null) {
                    dataSource.close();
                }
                if (bVar.q()) {
                    return;
                }
                bVar.k(dataSource.d(), dataSource.a());
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x000f  */
        @Override // b.f.e.c, com.facebook.datasource.DataSource
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized boolean b() {
            boolean z2;
            DataSource<T> dataSourceP = p();
            if (dataSourceP != null) {
                z2 = dataSourceP.b();
            }
            return z2;
        }

        @Override // b.f.e.c, com.facebook.datasource.DataSource
        public boolean close() {
            synchronized (this) {
                if (!super.close()) {
                    return false;
                }
                DataSource<T> dataSource = this.i;
                this.i = null;
                DataSource<T> dataSource2 = this.j;
                this.j = null;
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

        @Override // b.f.e.c, com.facebook.datasource.DataSource
        public synchronized T getResult() {
            DataSource<T> dataSourceP;
            dataSourceP = p();
            return dataSourceP != null ? dataSourceP.getResult() : null;
        }

        public final synchronized DataSource<T> p() {
            return this.j;
        }

        public final boolean q() {
            Supplier<DataSource<T>> supplier;
            boolean z2;
            synchronized (this) {
                if (i() || this.h >= g.this.a.size()) {
                    supplier = null;
                } else {
                    List<Supplier<DataSource<T>>> list = g.this.a;
                    int i = this.h;
                    this.h = i + 1;
                    supplier = list.get(i);
                }
            }
            DataSource<T> dataSource = supplier != null ? supplier.get() : null;
            synchronized (this) {
                if (i()) {
                    z2 = false;
                } else {
                    this.i = dataSource;
                    z2 = true;
                }
            }
            if (z2 && dataSource != null) {
                dataSource.f(new a(null), b.f.d.b.a.j);
                return true;
            }
            if (dataSource != null) {
                dataSource.close();
            }
            return false;
        }
    }

    public g(List<Supplier<DataSource<T>>> list) {
        b.c.a.a0.d.k(!list.isEmpty(), "List of suppliers is empty!");
        this.a = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            return b.c.a.a0.d.g0(this.a, ((g) obj).a);
        }
        return false;
    }

    @Override // com.facebook.common.internal.Supplier
    public Object get() {
        return new b();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        i iVarH2 = b.c.a.a0.d.h2(this);
        iVarH2.c("list", this.a);
        return iVarH2.toString();
    }
}

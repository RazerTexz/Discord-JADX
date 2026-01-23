package p007b.p225i.p226a.p242c.p257e3;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.e3.g, reason: use source file name */
/* JADX INFO: compiled from: BaseDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDataSource implements DataSource3 {

    /* JADX INFO: renamed from: a */
    public final boolean f6528a;

    /* JADX INFO: renamed from: b */
    public final ArrayList<TransferListener> f6529b = new ArrayList<>(1);

    /* JADX INFO: renamed from: c */
    public int f6530c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public DataSpec f6531d;

    public BaseDataSource(boolean z2) {
        this.f6528a = z2;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    /* JADX INFO: renamed from: d */
    public final void mo2587d(TransferListener transferListener) {
        Objects.requireNonNull(transferListener);
        if (this.f6529b.contains(transferListener)) {
            return;
        }
        this.f6529b.add(transferListener);
        this.f6530c++;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.DataSource3
    /* JADX INFO: renamed from: j */
    public /* synthetic */ Map mo2588j() {
        return DataSource2.m2853a(this);
    }

    /* JADX INFO: renamed from: p */
    public final void m2848p(int i) {
        DataSpec dataSpec = this.f6531d;
        int i2 = Util2.f6708a;
        for (int i3 = 0; i3 < this.f6530c; i3++) {
            this.f6529b.get(i3).mo2775e(this, dataSpec, this.f6528a, i);
        }
    }

    /* JADX INFO: renamed from: q */
    public final void m2849q() {
        DataSpec dataSpec = this.f6531d;
        int i = Util2.f6708a;
        for (int i2 = 0; i2 < this.f6530c; i2++) {
            this.f6529b.get(i2).mo2773a(this, dataSpec, this.f6528a);
        }
        this.f6531d = null;
    }

    /* JADX INFO: renamed from: r */
    public final void m2850r(DataSpec dataSpec) {
        for (int i = 0; i < this.f6530c; i++) {
            this.f6529b.get(i).mo2776g(this, dataSpec, this.f6528a);
        }
    }

    /* JADX INFO: renamed from: s */
    public final void m2851s(DataSpec dataSpec) {
        this.f6531d = dataSpec;
        for (int i = 0; i < this.f6530c; i++) {
            this.f6529b.get(i).mo2774b(this, dataSpec, this.f6528a);
        }
    }
}

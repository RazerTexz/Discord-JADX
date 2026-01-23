package p007b.p225i.p226a.p242c.p257e3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: b.i.a.c.e3.l, reason: use source file name */
/* JADX INFO: compiled from: DataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public interface DataSource3 extends DataReader {

    /* JADX INFO: renamed from: b.i.a.c.e3.l$a */
    /* JADX INFO: compiled from: DataSource.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        DataSource3 mo234a();
    }

    /* JADX INFO: renamed from: a */
    long mo2586a(DataSpec dataSpec) throws IOException;

    void close() throws IOException;

    /* JADX INFO: renamed from: d */
    void mo2587d(TransferListener transferListener);

    /* JADX INFO: renamed from: j */
    Map<String, List<String>> mo2588j();

    @Nullable
    /* JADX INFO: renamed from: n */
    Uri mo2589n();
}

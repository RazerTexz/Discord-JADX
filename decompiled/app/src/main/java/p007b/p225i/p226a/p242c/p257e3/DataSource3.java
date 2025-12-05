package p007b.p225i.p226a.p242c.p257e3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: DataSource.java */
/* renamed from: b.i.a.c.e3.l, reason: use source file name */
/* loaded from: classes3.dex */
public interface DataSource3 extends DataReader {

    /* compiled from: DataSource.java */
    /* renamed from: b.i.a.c.e3.l$a */
    public interface a {
        /* renamed from: a */
        DataSource3 mo234a();
    }

    /* renamed from: a */
    long mo2586a(DataSpec dataSpec) throws IOException;

    void close() throws IOException;

    /* renamed from: d */
    void mo2587d(TransferListener transferListener);

    /* renamed from: j */
    Map<String, List<String>> mo2588j();

    @Nullable
    /* renamed from: n */
    Uri mo2589n();
}

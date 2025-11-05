package b.i.a.c.e3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: DataSource.java */
/* loaded from: classes3.dex */
public interface l extends h {

    /* compiled from: DataSource.java */
    public interface a {
        l a();
    }

    long a(n nVar) throws IOException;

    void close() throws IOException;

    void d(a0 a0Var);

    Map<String, List<String>> j();

    @Nullable
    Uri n();
}

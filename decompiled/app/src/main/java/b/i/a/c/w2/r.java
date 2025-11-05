package b.i.a.c.w2;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;
import b.i.a.c.e3.r;
import b.i.a.c.o1;
import b.i.a.c.x0;
import b.i.b.b.s0;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* compiled from: DefaultDrmSessionManagerProvider.java */
/* loaded from: classes3.dex */
public final class r {
    public final Object a = new Object();

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("lock")
    public o1.f f1155b;

    @GuardedBy("lock")
    public u c;

    @RequiresApi(18)
    public final u a(o1.f fVar) {
        r.b bVar = new r.b();
        bVar.f951b = null;
        Uri uri = fVar.f1036b;
        d0 d0Var = new d0(uri == null ? null : uri.toString(), fVar.f, bVar);
        s0<Map.Entry<String, String>> s0VarJ = fVar.c.e().j();
        while (s0VarJ.hasNext()) {
            Map.Entry<String, String> next = s0VarJ.next();
            String key = next.getKey();
            String value = next.getValue();
            Objects.requireNonNull(key);
            Objects.requireNonNull(value);
            synchronized (d0Var.d) {
                d0Var.d.put(key, value);
            }
        }
        HashMap map = new HashMap();
        UUID uuid = x0.d;
        int i = c0.a;
        b.i.a.c.e3.s sVar = new b.i.a.c.e3.s();
        UUID uuid2 = fVar.a;
        n nVar = n.a;
        Objects.requireNonNull(uuid2);
        boolean z2 = fVar.d;
        boolean z3 = fVar.e;
        int[] iArrQ1 = b.i.a.f.e.o.f.q1(fVar.g);
        for (int i2 : iArrQ1) {
            boolean z4 = true;
            if (i2 != 2 && i2 != 1) {
                z4 = false;
            }
            b.c.a.a0.d.j(z4);
        }
        DefaultDrmSessionManager defaultDrmSessionManager = new DefaultDrmSessionManager(uuid2, nVar, d0Var, map, z2, (int[]) iArrQ1.clone(), z3, sVar, 300000L, null);
        byte[] bArr = fVar.h;
        byte[] bArrCopyOf = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        b.c.a.a0.d.D(defaultDrmSessionManager.m.isEmpty());
        defaultDrmSessionManager.v = 0;
        defaultDrmSessionManager.w = bArrCopyOf;
        return defaultDrmSessionManager;
    }
}

package b.i.c.r;

import android.content.Context;
import androidx.annotation.NonNull;
import b.i.c.l.r;
import b.i.c.r.d;

/* compiled from: DefaultHeartBeatInfo.java */
/* loaded from: classes3.dex */
public class c implements d {
    public b.i.c.t.a<e> a;

    public c(Context context) {
        this.a = new r(new a(context));
    }

    @Override // b.i.c.r.d
    @NonNull
    public d.a a(@NonNull String str) {
        boolean zA;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zA2 = this.a.get().a(str, jCurrentTimeMillis);
        e eVar = this.a.get();
        synchronized (eVar) {
            zA = eVar.a("fire-global", jCurrentTimeMillis);
        }
        return (zA2 && zA) ? d.a.COMBINED : zA ? d.a.GLOBAL : zA2 ? d.a.SDK : d.a.NONE;
    }
}

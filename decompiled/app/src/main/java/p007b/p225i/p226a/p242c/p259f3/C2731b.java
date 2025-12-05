package p007b.p225i.p226a.p242c.p259f3;

import android.os.Handler;
import android.os.Message;
import java.util.Iterator;
import p007b.p225i.p226a.p242c.p259f3.FlagSet;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;

/* compiled from: lambda */
/* renamed from: b.i.a.c.f3.b */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2731b implements Handler.Callback {

    /* renamed from: j */
    public final /* synthetic */ ListenerSet f6689j;

    public /* synthetic */ C2731b(ListenerSet listenerSet) {
        this.f6689j = listenerSet;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        ListenerSet listenerSet = this.f6689j;
        Iterator it = listenerSet.f6739d.iterator();
        while (it.hasNext()) {
            ListenerSet.c cVar = (ListenerSet.c) it.next();
            ListenerSet.b<T> bVar = listenerSet.f6738c;
            if (!cVar.f6746d && cVar.f6745c) {
                FlagSet flagSetM3033b = cVar.f6744b.m3033b();
                cVar.f6744b = new FlagSet.b();
                cVar.f6745c = false;
                bVar.mo3037a(cVar.f6743a, flagSetM3033b);
            }
            if (listenerSet.f6737b.mo2958e(0)) {
                return true;
            }
        }
        return true;
    }
}

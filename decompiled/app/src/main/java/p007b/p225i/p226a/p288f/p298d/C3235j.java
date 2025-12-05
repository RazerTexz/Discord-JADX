package p007b.p225i.p226a.p288f.p298d;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.cloudmessaging.zzp;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* renamed from: b.i.a.f.d.j */
/* loaded from: classes3.dex */
public final /* synthetic */ class C3235j implements Handler.Callback {

    /* renamed from: j */
    public final ServiceConnectionC3232g f9270j;

    public C3235j(ServiceConnectionC3232g serviceConnectionC3232g) {
        this.f9270j = serviceConnectionC3232g;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        ServiceConnectionC3232g serviceConnectionC3232g = this.f9270j;
        Objects.requireNonNull(serviceConnectionC3232g);
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Received response to request: ");
            sb.append(i);
            Log.d("MessengerIpcClient", sb.toString());
        }
        synchronized (serviceConnectionC3232g) {
            AbstractC3242q<?> abstractC3242q = serviceConnectionC3232g.f9267n.get(i);
            if (abstractC3242q == null) {
                StringBuilder sb2 = new StringBuilder(50);
                sb2.append("Received response for unknown request: ");
                sb2.append(i);
                Log.w("MessengerIpcClient", sb2.toString());
                return true;
            }
            serviceConnectionC3232g.f9267n.remove(i);
            serviceConnectionC3232g.m4005c();
            Bundle data = message.getData();
            if (data.getBoolean("unsupported", false)) {
                abstractC3242q.m4008b(new zzp(4, "Not supported by GmsCore"));
                return true;
            }
            abstractC3242q.mo4006a(data);
            return true;
        }
    }
}

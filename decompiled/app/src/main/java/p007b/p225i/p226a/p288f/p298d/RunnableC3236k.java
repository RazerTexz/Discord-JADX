package p007b.p225i.p226a.p288f.p298d;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.cloudmessaging.zza;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: b.i.a.f.d.k */
/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC3236k implements Runnable {

    /* JADX INFO: renamed from: j */
    public final ServiceConnectionC3232g f9271j;

    public RunnableC3236k(ServiceConnectionC3232g serviceConnectionC3232g) {
        this.f9271j = serviceConnectionC3232g;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ServiceConnectionC3232g serviceConnectionC3232g = this.f9271j;
        while (true) {
            synchronized (serviceConnectionC3232g) {
                if (serviceConnectionC3232g.f9263j != 2) {
                    return;
                }
                if (serviceConnectionC3232g.f9266m.isEmpty()) {
                    serviceConnectionC3232g.m4005c();
                    return;
                }
                AbstractC3242q<?> abstractC3242qPoll = serviceConnectionC3232g.f9266m.poll();
                serviceConnectionC3232g.f9267n.put(abstractC3242qPoll.f9279a, abstractC3242qPoll);
                serviceConnectionC3232g.f9268o.f9260c.schedule(new RunnableC3238m(serviceConnectionC3232g, abstractC3242qPoll), 30L, TimeUnit.SECONDS);
                if (Log.isLoggable("MessengerIpcClient", 3)) {
                    String strValueOf = String.valueOf(abstractC3242qPoll);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 8);
                    sb.append("Sending ");
                    sb.append(strValueOf);
                    Log.d("MessengerIpcClient", sb.toString());
                }
                Context context = serviceConnectionC3232g.f9268o.f9259b;
                Messenger messenger = serviceConnectionC3232g.f9264k;
                Message messageObtain = Message.obtain();
                messageObtain.what = abstractC3242qPoll.f9281c;
                messageObtain.arg1 = abstractC3242qPoll.f9279a;
                messageObtain.replyTo = messenger;
                Bundle bundle = new Bundle();
                bundle.putBoolean("oneWay", abstractC3242qPoll.mo4007d());
                bundle.putString("pkg", context.getPackageName());
                bundle.putBundle("data", abstractC3242qPoll.f9282d);
                messageObtain.setData(bundle);
                try {
                    C3241p c3241p = serviceConnectionC3232g.f9265l;
                    Messenger messenger2 = c3241p.f9277a;
                    if (messenger2 != null) {
                        messenger2.send(messageObtain);
                    } else {
                        zza zzaVar = c3241p.f9278b;
                        if (zzaVar == null) {
                            throw new IllegalStateException("Both messengers are null");
                        }
                        Messenger messenger3 = zzaVar.f20471j;
                        Objects.requireNonNull(messenger3);
                        messenger3.send(messageObtain);
                    }
                } catch (RemoteException e) {
                    serviceConnectionC3232g.m4003a(2, e.getMessage());
                }
            }
        }
    }
}

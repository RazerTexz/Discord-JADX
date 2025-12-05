package p007b.p225i.p226a.p288f.p298d;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.google.android.gms.cloudmessaging.zzp;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p299e.p307n.C3398a;
import p007b.p225i.p226a.p288f.p313h.p319f.HandlerC3480a;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* renamed from: b.i.a.f.d.g */
/* loaded from: classes3.dex */
public final class ServiceConnectionC3232g implements ServiceConnection {

    /* renamed from: l */
    public C3241p f9265l;

    /* renamed from: o */
    public final /* synthetic */ C3231f f9268o;

    /* renamed from: j */
    public int f9263j = 0;

    /* renamed from: k */
    public final Messenger f9264k = new Messenger(new HandlerC3480a(Looper.getMainLooper(), new C3235j(this)));

    /* renamed from: m */
    public final Queue<AbstractC3242q<?>> f9266m = new ArrayDeque();

    /* renamed from: n */
    public final SparseArray<AbstractC3242q<?>> f9267n = new SparseArray<>();

    public ServiceConnectionC3232g(C3231f c3231f, C3233h c3233h) {
        this.f9268o = c3231f;
    }

    /* renamed from: a */
    public final synchronized void m4003a(int i, @Nullable String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", strValueOf.length() != 0 ? "Disconnected: ".concat(strValueOf) : new String("Disconnected: "));
        }
        int i2 = this.f9263j;
        if (i2 == 0) {
            throw new IllegalStateException();
        }
        if (i2 != 1 && i2 != 2) {
            if (i2 == 3) {
                this.f9263j = 4;
                return;
            } else {
                if (i2 == 4) {
                    return;
                }
                int i3 = this.f9263j;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
            }
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Unbinding service");
        }
        this.f9263j = 4;
        C3398a.m4181b().m4183c(this.f9268o.f9259b, this);
        zzp zzpVar = new zzp(i, str);
        Iterator<AbstractC3242q<?>> it = this.f9266m.iterator();
        while (it.hasNext()) {
            it.next().m4008b(zzpVar);
        }
        this.f9266m.clear();
        for (int i4 = 0; i4 < this.f9267n.size(); i4++) {
            this.f9267n.valueAt(i4).m4008b(zzpVar);
        }
        this.f9267n.clear();
    }

    /* renamed from: b */
    public final synchronized boolean m4004b(AbstractC3242q<?> abstractC3242q) {
        int i = this.f9263j;
        if (i == 0) {
            this.f9266m.add(abstractC3242q);
            AnimatableValueParser.m432F(this.f9263j == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.f9263j = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            if (C3398a.m4181b().m4182a(this.f9268o.f9259b, intent, this, 1)) {
                this.f9268o.f9260c.schedule(new RunnableC3234i(this), 30L, TimeUnit.SECONDS);
            } else {
                m4003a(0, "Unable to bind to service");
            }
            return true;
        }
        if (i == 1) {
            this.f9266m.add(abstractC3242q);
            return true;
        }
        if (i == 2) {
            this.f9266m.add(abstractC3242q);
            this.f9268o.f9260c.execute(new RunnableC3236k(this));
            return true;
        }
        if (i != 3 && i != 4) {
            int i2 = this.f9263j;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Unknown state: ");
            sb.append(i2);
            throw new IllegalStateException(sb.toString());
        }
        return false;
    }

    /* renamed from: c */
    public final synchronized void m4005c() {
        if (this.f9263j == 2 && this.f9266m.isEmpty() && this.f9267n.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.f9263j = 3;
            C3398a.m4181b().m4183c(this.f9268o.f9259b, this);
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.f9268o.f9260c.execute(new RunnableC3237l(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.f9268o.f9260c.execute(new RunnableC3239n(this));
    }
}

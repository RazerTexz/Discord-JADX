package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.C3267b;
import p007b.p225i.p226a.p288f.p299e.p300h.RunnableC3333k;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3282c0;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3285d0;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3293g;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3301k;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3308n0;
import p007b.p225i.p226a.p288f.p299e.p304k.C3347c;
import p007b.p225i.p226a.p288f.p333j.p334b.C4264a;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.i */
/* JADX INFO: loaded from: classes3.dex */
public final class C4286i extends MessagesClient {

    /* JADX INFO: renamed from: j */
    public static final C3266a.g<C4280f> f11413j;

    /* JADX INFO: renamed from: k */
    public static final C3266a.a<C4280f, C4264a> f11414k;

    /* JADX INFO: renamed from: l */
    public static final C3266a<C4264a> f11415l;

    /* JADX INFO: renamed from: m */
    public final int f11416m;

    static {
        C3266a.g<C4280f> gVar = new C3266a.g<>();
        f11413j = gVar;
        C4302q c4302q = new C4302q();
        f11414k = c4302q;
        f11415l = new C3266a<>("Nearby.MESSAGES_API", c4302q, gVar);
    }

    public C4286i(Activity activity, @Nullable C4264a c4264a) {
        super(activity, f11415l, c4264a, C3267b.a.f9335a);
        this.f11416m = 1;
        activity.getApplication().registerActivityLifecycleCallbacks(new C4320z(activity, this, null));
    }

    /* JADX INFO: renamed from: j */
    public static C3301k m5983j(C4286i c4286i, TaskCompletionSource taskCompletionSource) {
        Objects.requireNonNull(c4286i);
        C4308t c4308t = new C4308t(taskCompletionSource);
        String name = Status.class.getName();
        Looper looper = c4286i.f9330e;
        AnimatableValueParser.m595z(c4308t, "Listener must not be null");
        AnimatableValueParser.m595z(looper, "Looper must not be null");
        AnimatableValueParser.m595z(name, "Listener type must not be null");
        return new C3301k(looper, c4308t, name);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.C3267b
    /* JADX INFO: renamed from: a */
    public final C3347c.a mo4044a() {
        return super.mo4044a();
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    /* JADX INFO: renamed from: f */
    public final Task<Void> mo5984f(Message message, PublishOptions publishOptions) {
        C3301k c3301kM5990m = m5990m(message);
        return m5988k(c3301kM5990m, new C4288j(this, message, new BinderC4304r(this, m5990m(publishOptions.f20726b), c3301kM5990m), publishOptions), new C4290k(message));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    /* JADX INFO: renamed from: g */
    public final Task<Void> mo5985g(MessageListener messageListener, SubscribeOptions subscribeOptions) {
        AnimatableValueParser.m551o(subscribeOptions.f20737a.f20736s == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        C3301k c3301kM5990m = m5990m(messageListener);
        return m5988k(c3301kM5990m, new C4292l(this, c3301kM5990m, new BinderC4306s(this, m5990m(subscribeOptions.f20739c), c3301kM5990m), subscribeOptions), new C4294m(c3301kM5990m));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    /* JADX INFO: renamed from: h */
    public final Task<Void> mo5986h(Message message) {
        return m5989l(message);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    /* JADX INFO: renamed from: i */
    public final Task<Void> mo5987i(MessageListener messageListener) {
        return m5989l(messageListener);
    }

    /* JADX INFO: renamed from: k */
    public final <T> Task<Void> m5988k(C3301k<T> c3301k, InterfaceC4269a0 interfaceC4269a0, InterfaceC4269a0 interfaceC4269a02) {
        C4312v c4312v = new C4312v(this, c3301k, interfaceC4269a0);
        C3301k.a<T> aVar = c3301k.f9430c;
        C4316x c4316x = new C4316x(this, aVar, interfaceC4269a02);
        AnimatableValueParser.m595z(c3301k.f9430c, "Listener has already been released.");
        AnimatableValueParser.m595z(aVar, "Listener has already been released.");
        AnimatableValueParser.m551o(AnimatableValueParser.m524h0(c3301k.f9430c, aVar), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        C3293g c3293g = this.f9334i;
        Runnable runnable = RunnableC3333k.f9473j;
        Objects.requireNonNull(c3293g);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        C3308n0 c3308n0 = new C3308n0(new C3285d0(c4312v, c4316x, runnable), taskCompletionSource);
        Handler handler = c3293g.f9390x;
        handler.sendMessage(handler.obtainMessage(8, new C3282c0(c3308n0, c3293g.f9385s.get(), this)));
        return taskCompletionSource.f20845a;
    }

    /* JADX INFO: renamed from: l */
    public final <T> Task<Void> m5989l(T t) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        String name = t.getClass().getName();
        AnimatableValueParser.m595z(t, "Listener must not be null");
        AnimatableValueParser.m595z(name, "Listener type must not be null");
        AnimatableValueParser.m579v(name, "Listener type must not be empty");
        m4045b(new C3301k.a<>(t, name)).mo6007b(new C4310u(taskCompletionSource));
        return taskCompletionSource.f20845a;
    }

    /* JADX INFO: renamed from: m */
    public final <T> C3301k<T> m5990m(T t) {
        if (t == null) {
            return null;
        }
        String name = t.getClass().getName();
        Looper looper = this.f9330e;
        AnimatableValueParser.m595z(t, "Listener must not be null");
        AnimatableValueParser.m595z(looper, "Looper must not be null");
        AnimatableValueParser.m595z(name, "Listener type must not be null");
        return new C3301k<>(looper, t, name);
    }
}

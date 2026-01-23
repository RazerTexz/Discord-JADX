package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.C3260e;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.C3267b;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3301k;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b;
import p007b.p225i.p226a.p288f.p299e.p304k.C3347c;
import p007b.p225i.p226a.p288f.p299e.p304k.C3361j;
import p007b.p225i.p226a.p288f.p299e.p304k.C3377r;
import p007b.p225i.p226a.p288f.p299e.p304k.C3391y;
import p007b.p225i.p226a.p288f.p299e.p304k.InterfaceC3355g;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p313h.p318e.HandlerC3479c;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4280f;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4286i;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4312v;
import p007b.p225i.p226a.p288f.p337l.C4335a;
import p007b.p225i.p226a.p288f.p337l.InterfaceC4349f;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.g */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3293g implements Handler.Callback {

    /* JADX INFO: renamed from: j */
    public static final Status f9376j = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* JADX INFO: renamed from: k */
    public static final Status f9377k = new Status(4, "The user must be signed in to make this API call.");

    /* JADX INFO: renamed from: l */
    public static final Object f9378l = new Object();

    /* JADX INFO: renamed from: m */
    @Nullable
    public static C3293g f9379m;

    /* JADX INFO: renamed from: o */
    public final Context f9381o;

    /* JADX INFO: renamed from: p */
    public final GoogleApiAvailability f9382p;

    /* JADX INFO: renamed from: q */
    public final C3377r f9383q;

    /* JADX INFO: renamed from: x */
    @NotOnlyInitialized
    public final Handler f9390x;

    /* JADX INFO: renamed from: y */
    public volatile boolean f9391y;

    /* JADX INFO: renamed from: n */
    public long f9380n = 10000;

    /* JADX INFO: renamed from: r */
    public final AtomicInteger f9384r = new AtomicInteger(1);

    /* JADX INFO: renamed from: s */
    public final AtomicInteger f9385s = new AtomicInteger(0);

    /* JADX INFO: renamed from: t */
    public final Map<C3278b<?>, a<?>> f9386t = new ConcurrentHashMap(5, 0.75f, 1);

    /* JADX INFO: renamed from: u */
    @Nullable
    public C3277a1 f9387u = null;

    /* JADX INFO: renamed from: v */
    public final Set<C3278b<?>> f9388v = new ArraySet();

    /* JADX INFO: renamed from: w */
    public final Set<C3278b<?>> f9389w = new ArraySet();

    /* JADX INFO: renamed from: b.i.a.f.e.h.j.g$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public class a<O extends C3266a.d> implements AbstractC3268c.a, AbstractC3268c.b {

        /* JADX INFO: renamed from: b */
        @NotOnlyInitialized
        public final C3266a.f f9393b;

        /* JADX INFO: renamed from: c */
        public final C3266a.b f9394c;

        /* JADX INFO: renamed from: d */
        public final C3278b<O> f9395d;

        /* JADX INFO: renamed from: e */
        public final C3328x0 f9396e;

        /* JADX INFO: renamed from: h */
        public final int f9399h;

        /* JADX INFO: renamed from: i */
        @Nullable
        public final BinderC3294g0 f9400i;

        /* JADX INFO: renamed from: j */
        public boolean f9401j;

        /* JADX INFO: renamed from: a */
        public final Queue<AbstractC3317s> f9392a = new LinkedList();

        /* JADX INFO: renamed from: f */
        public final Set<C3316r0> f9397f = new HashSet();

        /* JADX INFO: renamed from: g */
        public final Map<C3301k.a<?>, C3285d0> f9398g = new HashMap();

        /* JADX INFO: renamed from: k */
        public final List<c> f9402k = new ArrayList();

        /* JADX INFO: renamed from: l */
        @Nullable
        public ConnectionResult f9403l = null;

        @WorkerThread
        public a(C3267b<O> c3267b) {
            Looper looper = C3293g.this.f9390x.getLooper();
            C3347c c3347cM4148a = c3267b.mo4044a().m4148a();
            C3266a<O> c3266a = c3267b.f9327b;
            AnimatableValueParser.m435G(c3266a.f9323a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
            C3266a.a<?, O> aVar = c3266a.f9323a;
            Objects.requireNonNull(aVar, "null reference");
            C3266a.f fVarMo3996a = aVar.mo3996a(c3267b.f9326a, looper, c3347cM4148a, c3267b.f9328c, this, this);
            this.f9393b = fVarMo3996a;
            if (fVarMo3996a instanceof C3391y) {
                throw new NoSuchMethodError();
            }
            this.f9394c = fVarMo3996a;
            this.f9395d = c3267b.f9329d;
            this.f9396e = new C3328x0();
            this.f9399h = c3267b.f9331f;
            if (fVarMo3996a.mo4042o()) {
                this.f9400i = new BinderC3294g0(C3293g.this.f9381o, C3293g.this.f9390x, c3267b.mo4044a().m4148a());
            } else {
                this.f9400i = null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        @WorkerThread
        /* JADX INFO: renamed from: a */
        public final Feature m4082a(@Nullable Feature[] featureArr) {
            if (featureArr != null && featureArr.length != 0) {
                Feature[] featureArrM4040m = this.f9393b.m4040m();
                if (featureArrM4040m == null) {
                    featureArrM4040m = new Feature[0];
                }
                ArrayMap arrayMap = new ArrayMap(featureArrM4040m.length);
                for (Feature feature : featureArrM4040m) {
                    arrayMap.put(feature.f20477j, Long.valueOf(feature.m9021w0()));
                }
                for (Feature feature2 : featureArr) {
                    Long l = (Long) arrayMap.get(feature2.f20477j);
                    if (l == null || l.longValue() < feature2.m9021w0()) {
                        return feature2;
                    }
                }
            }
            return null;
        }

        @WorkerThread
        /* JADX INFO: renamed from: b */
        public final void m4083b() throws PackageManager.NameNotFoundException {
            AnimatableValueParser.m567s(C3293g.this.f9390x);
            Status status = C3293g.f9376j;
            m4086f(status);
            C3328x0 c3328x0 = this.f9396e;
            Objects.requireNonNull(c3328x0);
            c3328x0.m4120a(false, status);
            for (C3301k.a aVar : (C3301k.a[]) this.f9398g.keySet().toArray(new C3301k.a[0])) {
                m4089j(new C3312p0(aVar, new TaskCompletionSource()));
            }
            m4093n(new ConnectionResult(4));
            if (this.f9393b.m4038j()) {
                this.f9393b.m4037i(new C3327x(this));
            }
        }

        @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3290f
        /* JADX INFO: renamed from: c */
        public final void mo4076c(int i) {
            if (Looper.myLooper() == C3293g.this.f9390x.getLooper()) {
                m4084d(i);
            } else {
                C3293g.this.f9390x.post(new RunnableC3323v(this, i));
            }
        }

        @WorkerThread
        /* JADX INFO: renamed from: d */
        public final void m4084d(int i) {
            m4096q();
            this.f9401j = true;
            C3328x0 c3328x0 = this.f9396e;
            String strM4041n = this.f9393b.m4041n();
            Objects.requireNonNull(c3328x0);
            StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
            if (i == 1) {
                sb.append(" due to service disconnection.");
            } else if (i == 3) {
                sb.append(" due to dead object exception.");
            }
            if (strM4041n != null) {
                sb.append(" Last reason for disconnect: ");
                sb.append(strM4041n);
            }
            c3328x0.m4120a(true, new Status(20, sb.toString()));
            Handler handler = C3293g.this.f9390x;
            Message messageObtain = Message.obtain(handler, 9, this.f9395d);
            Objects.requireNonNull(C3293g.this);
            handler.sendMessageDelayed(messageObtain, 5000L);
            Handler handler2 = C3293g.this.f9390x;
            Message messageObtain2 = Message.obtain(handler2, 11, this.f9395d);
            Objects.requireNonNull(C3293g.this);
            handler2.sendMessageDelayed(messageObtain2, 120000L);
            C3293g.this.f9383q.f9551a.clear();
            Iterator<C3285d0> it = this.f9398g.values().iterator();
            while (it.hasNext()) {
                it.next().f9362c.run();
            }
        }

        @WorkerThread
        /* JADX INFO: renamed from: e */
        public final void m4085e(@NonNull ConnectionResult connectionResult, @Nullable Exception exc) {
            InterfaceC4349f interfaceC4349f;
            AnimatableValueParser.m567s(C3293g.this.f9390x);
            BinderC3294g0 binderC3294g0 = this.f9400i;
            if (binderC3294g0 != null && (interfaceC4349f = binderC3294g0.f9419g) != null) {
                interfaceC4349f.mo4036h();
            }
            m4096q();
            C3293g.this.f9383q.f9551a.clear();
            m4093n(connectionResult);
            if (connectionResult.f20474l == 4) {
                m4086f(C3293g.f9377k);
                return;
            }
            if (this.f9392a.isEmpty()) {
                this.f9403l = connectionResult;
                return;
            }
            if (exc != null) {
                AnimatableValueParser.m567s(C3293g.this.f9390x);
                m4088h(null, exc, false);
                return;
            }
            if (!C3293g.this.f9391y) {
                Status statusM4095p = m4095p(connectionResult);
                AnimatableValueParser.m567s(C3293g.this.f9390x);
                m4088h(statusM4095p, null, false);
                return;
            }
            m4088h(m4095p(connectionResult), null, true);
            if (this.f9392a.isEmpty() || m4091l(connectionResult) || C3293g.this.m4080c(connectionResult, this.f9399h)) {
                return;
            }
            if (connectionResult.f20474l == 18) {
                this.f9401j = true;
            }
            if (!this.f9401j) {
                Status statusM4095p2 = m4095p(connectionResult);
                AnimatableValueParser.m567s(C3293g.this.f9390x);
                m4088h(statusM4095p2, null, false);
            } else {
                Handler handler = C3293g.this.f9390x;
                Message messageObtain = Message.obtain(handler, 9, this.f9395d);
                Objects.requireNonNull(C3293g.this);
                handler.sendMessageDelayed(messageObtain, 5000L);
            }
        }

        @WorkerThread
        /* JADX INFO: renamed from: f */
        public final void m4086f(Status status) {
            AnimatableValueParser.m567s(C3293g.this.f9390x);
            m4088h(status, null, false);
        }

        @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3303l
        @WorkerThread
        /* JADX INFO: renamed from: g */
        public final void mo4087g(@NonNull ConnectionResult connectionResult) {
            m4085e(connectionResult, null);
        }

        @WorkerThread
        /* JADX INFO: renamed from: h */
        public final void m4088h(@Nullable Status status, @Nullable Exception exc, boolean z2) {
            AnimatableValueParser.m567s(C3293g.this.f9390x);
            if ((status == null) == (exc == null)) {
                throw new IllegalArgumentException("Status XOR exception should be null");
            }
            Iterator<AbstractC3317s> it = this.f9392a.iterator();
            while (it.hasNext()) {
                AbstractC3317s next = it.next();
                if (!z2 || next.f9447a == 2) {
                    if (status != null) {
                        next.mo4072b(status);
                    } else {
                        next.mo4074e(exc);
                    }
                    it.remove();
                }
            }
        }

        @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3290f
        /* JADX INFO: renamed from: i */
        public final void mo4077i(@Nullable Bundle bundle) {
            if (Looper.myLooper() == C3293g.this.f9390x.getLooper()) {
                m4099t();
            } else {
                C3293g.this.f9390x.post(new RunnableC3321u(this));
            }
        }

        @WorkerThread
        /* JADX INFO: renamed from: j */
        public final void m4089j(AbstractC3317s abstractC3317s) throws PackageManager.NameNotFoundException {
            AnimatableValueParser.m567s(C3293g.this.f9390x);
            if (this.f9393b.m4038j()) {
                if (m4092m(abstractC3317s)) {
                    m4102w();
                    return;
                } else {
                    this.f9392a.add(abstractC3317s);
                    return;
                }
            }
            this.f9392a.add(abstractC3317s);
            ConnectionResult connectionResult = this.f9403l;
            if (connectionResult == null || !connectionResult.m9019w0()) {
                m4097r();
            } else {
                m4085e(this.f9403l, null);
            }
        }

        @WorkerThread
        /* JADX INFO: renamed from: k */
        public final boolean m4090k(boolean z2) {
            AnimatableValueParser.m567s(C3293g.this.f9390x);
            if (!this.f9393b.m4038j() || this.f9398g.size() != 0) {
                return false;
            }
            C3328x0 c3328x0 = this.f9396e;
            if (!((c3328x0.f9464a.isEmpty() && c3328x0.f9465b.isEmpty()) ? false : true)) {
                this.f9393b.m4032c("Timing out service connection.");
                return true;
            }
            if (z2) {
                m4102w();
            }
            return false;
        }

        @WorkerThread
        /* JADX INFO: renamed from: l */
        public final boolean m4091l(@NonNull ConnectionResult connectionResult) {
            synchronized (C3293g.f9378l) {
                C3293g c3293g = C3293g.this;
                if (c3293g.f9387u == null || !c3293g.f9388v.contains(this.f9395d)) {
                    return false;
                }
                C3293g.this.f9387u.m4119n(connectionResult, this.f9399h);
                return true;
            }
        }

        @WorkerThread
        /* JADX INFO: renamed from: m */
        public final boolean m4092m(AbstractC3317s abstractC3317s) {
            if (!(abstractC3317s instanceof AbstractC3306m0)) {
                m4094o(abstractC3317s);
                return true;
            }
            AbstractC3306m0 abstractC3306m0 = (AbstractC3306m0) abstractC3317s;
            Feature featureM4082a = m4082a(abstractC3306m0.mo4111f(this));
            if (featureM4082a == null) {
                m4094o(abstractC3317s);
                return true;
            }
            String name = this.f9394c.getClass().getName();
            String str = featureM4082a.f20477j;
            long jM9021w0 = featureM4082a.m9021w0();
            StringBuilder sbM831S = outline.m831S(outline.m841b(str, name.length() + 77), name, " could not execute call because it requires feature (", str, ", ");
            sbM831S.append(jM9021w0);
            sbM831S.append(").");
            Log.w("GoogleApiManager", sbM831S.toString());
            if (!C3293g.this.f9391y || !abstractC3306m0.mo4112g(this)) {
                abstractC3306m0.mo4074e(new UnsupportedApiCallException(featureM4082a));
                return true;
            }
            c cVar = new c(this.f9395d, featureM4082a, null);
            int iIndexOf = this.f9402k.indexOf(cVar);
            if (iIndexOf >= 0) {
                c cVar2 = this.f9402k.get(iIndexOf);
                C3293g.this.f9390x.removeMessages(15, cVar2);
                Handler handler = C3293g.this.f9390x;
                Message messageObtain = Message.obtain(handler, 15, cVar2);
                Objects.requireNonNull(C3293g.this);
                handler.sendMessageDelayed(messageObtain, 5000L);
                return false;
            }
            this.f9402k.add(cVar);
            Handler handler2 = C3293g.this.f9390x;
            Message messageObtain2 = Message.obtain(handler2, 15, cVar);
            Objects.requireNonNull(C3293g.this);
            handler2.sendMessageDelayed(messageObtain2, 5000L);
            Handler handler3 = C3293g.this.f9390x;
            Message messageObtain3 = Message.obtain(handler3, 16, cVar);
            Objects.requireNonNull(C3293g.this);
            handler3.sendMessageDelayed(messageObtain3, 120000L);
            ConnectionResult connectionResult = new ConnectionResult(2, null);
            if (m4091l(connectionResult)) {
                return false;
            }
            C3293g.this.m4080c(connectionResult, this.f9399h);
            return false;
        }

        @WorkerThread
        /* JADX INFO: renamed from: n */
        public final void m4093n(ConnectionResult connectionResult) {
            Iterator<C3316r0> it = this.f9397f.iterator();
            if (!it.hasNext()) {
                this.f9397f.clear();
                return;
            }
            C3316r0 next = it.next();
            if (AnimatableValueParser.m524h0(connectionResult, ConnectionResult.f20472j)) {
                this.f9393b.m4034f();
            }
            Objects.requireNonNull(next);
            throw null;
        }

        @WorkerThread
        /* JADX INFO: renamed from: o */
        public final void m4094o(AbstractC3317s abstractC3317s) {
            abstractC3317s.mo4113d(this.f9396e, m4098s());
            try {
                abstractC3317s.mo4073c(this);
            } catch (DeadObjectException unused) {
                mo4076c(1);
                this.f9393b.m4032c("DeadObjectException thrown while running ApiCallRunner.");
            } catch (Throwable th) {
                throw new IllegalStateException(String.format("Error in GoogleApi implementation for client %s.", this.f9394c.getClass().getName()), th);
            }
        }

        /* JADX INFO: renamed from: p */
        public final Status m4095p(ConnectionResult connectionResult) {
            String str = this.f9395d.f9346b.f9325c;
            String strValueOf = String.valueOf(connectionResult);
            return new Status(17, outline.m861l(strValueOf.length() + outline.m841b(str, 63), "API: ", str, " is not available on this device. Connection failed with: ", strValueOf));
        }

        @WorkerThread
        /* JADX INFO: renamed from: q */
        public final void m4096q() {
            AnimatableValueParser.m567s(C3293g.this.f9390x);
            this.f9403l = null;
        }

        @WorkerThread
        /* JADX INFO: renamed from: r */
        public final void m4097r() throws PackageManager.NameNotFoundException {
            AnimatableValueParser.m567s(C3293g.this.f9390x);
            if (this.f9393b.m4038j() || this.f9393b.m4033e()) {
                return;
            }
            try {
                C3293g c3293g = C3293g.this;
                int iM4175a = c3293g.f9383q.m4175a(c3293g.f9381o, this.f9393b);
                if (iM4175a != 0) {
                    ConnectionResult connectionResult = new ConnectionResult(iM4175a, null);
                    String name = this.f9394c.getClass().getName();
                    String strValueOf = String.valueOf(connectionResult);
                    StringBuilder sb = new StringBuilder(name.length() + 35 + strValueOf.length());
                    sb.append("The service for ");
                    sb.append(name);
                    sb.append(" is not available: ");
                    sb.append(strValueOf);
                    Log.w("GoogleApiManager", sb.toString());
                    m4085e(connectionResult, null);
                    return;
                }
                C3293g c3293g2 = C3293g.this;
                C3266a.f fVar = this.f9393b;
                b bVar = c3293g2.new b(fVar, this.f9395d);
                if (fVar.mo4042o()) {
                    BinderC3294g0 binderC3294g0 = this.f9400i;
                    Objects.requireNonNull(binderC3294g0, "null reference");
                    InterfaceC4349f interfaceC4349f = binderC3294g0.f9419g;
                    if (interfaceC4349f != null) {
                        interfaceC4349f.mo4036h();
                    }
                    binderC3294g0.f9418f.f9508h = Integer.valueOf(System.identityHashCode(binderC3294g0));
                    C3266a.a<? extends InterfaceC4349f, C4335a> aVar = binderC3294g0.f9416d;
                    Context context = binderC3294g0.f9414b;
                    Looper looper = binderC3294g0.f9415c.getLooper();
                    C3347c c3347c = binderC3294g0.f9418f;
                    binderC3294g0.f9419g = (InterfaceC4349f) aVar.mo3996a(context, looper, c3347c, c3347c.f9507g, binderC3294g0, binderC3294g0);
                    binderC3294g0.f9420h = bVar;
                    Set<Scope> set = binderC3294g0.f9417e;
                    if (set == null || set.isEmpty()) {
                        binderC3294g0.f9415c.post(new RunnableC3291f0(binderC3294g0));
                    } else {
                        binderC3294g0.f9419g.mo5999p();
                    }
                }
                try {
                    this.f9393b.m4035g(bVar);
                } catch (SecurityException e) {
                    m4085e(new ConnectionResult(10), e);
                }
            } catch (IllegalStateException e2) {
                m4085e(new ConnectionResult(10), e2);
            }
        }

        /* JADX INFO: renamed from: s */
        public final boolean m4098s() {
            return this.f9393b.mo4042o();
        }

        @WorkerThread
        /* JADX INFO: renamed from: t */
        public final void m4099t() {
            m4096q();
            m4093n(ConnectionResult.f20472j);
            m4101v();
            Iterator<C3285d0> it = this.f9398g.values().iterator();
            while (it.hasNext()) {
                C3285d0 next = it.next();
                Objects.requireNonNull(next.f9360a);
                if (m4082a(null) != null) {
                    it.remove();
                } else {
                    try {
                        AbstractC3305m<C3266a.b, ?> abstractC3305m = next.f9360a;
                        C3266a.b bVar = this.f9394c;
                        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                        C4312v c4312v = (C4312v) abstractC3305m;
                        Objects.requireNonNull(c4312v);
                        c4312v.f11435b.mo5981a((C4280f) bVar, C4286i.m5983j(c4312v.f11436c, taskCompletionSource));
                    } catch (DeadObjectException unused) {
                        mo4076c(3);
                        this.f9393b.m4032c("DeadObjectException thrown while calling register listener method.");
                    } catch (RemoteException unused2) {
                        it.remove();
                    }
                }
            }
            m4100u();
            m4102w();
        }

        @WorkerThread
        /* JADX INFO: renamed from: u */
        public final void m4100u() {
            ArrayList arrayList = new ArrayList(this.f9392a);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                AbstractC3317s abstractC3317s = (AbstractC3317s) obj;
                if (!this.f9393b.m4038j()) {
                    return;
                }
                if (m4092m(abstractC3317s)) {
                    this.f9392a.remove(abstractC3317s);
                }
            }
        }

        @WorkerThread
        /* JADX INFO: renamed from: v */
        public final void m4101v() {
            if (this.f9401j) {
                C3293g.this.f9390x.removeMessages(11, this.f9395d);
                C3293g.this.f9390x.removeMessages(9, this.f9395d);
                this.f9401j = false;
            }
        }

        /* JADX INFO: renamed from: w */
        public final void m4102w() {
            C3293g.this.f9390x.removeMessages(12, this.f9395d);
            Handler handler = C3293g.this.f9390x;
            handler.sendMessageDelayed(handler.obtainMessage(12, this.f9395d), C3293g.this.f9380n);
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.e.h.j.g$b */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public class b implements InterfaceC3296h0, AbstractC3345b.c {

        /* JADX INFO: renamed from: a */
        public final C3266a.f f9405a;

        /* JADX INFO: renamed from: b */
        public final C3278b<?> f9406b;

        /* JADX INFO: renamed from: c */
        @Nullable
        public InterfaceC3355g f9407c = null;

        /* JADX INFO: renamed from: d */
        @Nullable
        public Set<Scope> f9408d = null;

        /* JADX INFO: renamed from: e */
        public boolean f9409e = false;

        public b(C3266a.f fVar, C3278b<?> c3278b) {
            this.f9405a = fVar;
            this.f9406b = c3278b;
        }

        @Override // p007b.p225i.p226a.p288f.p299e.p304k.AbstractC3345b.c
        /* JADX INFO: renamed from: a */
        public final void mo4103a(@NonNull ConnectionResult connectionResult) {
            C3293g.this.f9390x.post(new RunnableC3331z(this, connectionResult));
        }

        @WorkerThread
        /* JADX INFO: renamed from: b */
        public final void m4104b(ConnectionResult connectionResult) {
            a<?> aVar = C3293g.this.f9386t.get(this.f9406b);
            if (aVar != null) {
                AnimatableValueParser.m567s(C3293g.this.f9390x);
                C3266a.f fVar = aVar.f9393b;
                String name = aVar.f9394c.getClass().getName();
                String strValueOf = String.valueOf(connectionResult);
                fVar.m4032c(outline.m861l(strValueOf.length() + name.length() + 25, "onSignInFailed for ", name, " with ", strValueOf));
                aVar.m4085e(connectionResult, null);
            }
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.e.h.j.g$c */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static class c {

        /* JADX INFO: renamed from: a */
        public final C3278b<?> f9411a;

        /* JADX INFO: renamed from: b */
        public final Feature f9412b;

        public c(C3278b c3278b, Feature feature, C3319t c3319t) {
            this.f9411a = c3278b;
            this.f9412b = feature;
        }

        public final boolean equals(@Nullable Object obj) {
            if (obj != null && (obj instanceof c)) {
                c cVar = (c) obj;
                if (AnimatableValueParser.m524h0(this.f9411a, cVar.f9411a) && AnimatableValueParser.m524h0(this.f9412b, cVar.f9412b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.f9411a, this.f9412b});
        }

        public final String toString() {
            C3361j c3361j = new C3361j(this);
            c3361j.m4162a("key", this.f9411a);
            c3361j.m4162a("feature", this.f9412b);
            return c3361j.toString();
        }
    }

    public C3293g(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.f9391y = true;
        this.f9381o = context;
        HandlerC3479c handlerC3479c = new HandlerC3479c(looper, this);
        this.f9390x = handlerC3479c;
        this.f9382p = googleApiAvailability;
        this.f9383q = new C3377r(googleApiAvailability);
        PackageManager packageManager = context.getPackageManager();
        if (AnimatableValueParser.f2221f == null) {
            AnimatableValueParser.f2221f = Boolean.valueOf(C3404f.m4190A0() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (AnimatableValueParser.f2221f.booleanValue()) {
            this.f9391y = false;
        }
        handlerC3479c.sendMessage(handlerC3479c.obtainMessage(6));
    }

    /* JADX INFO: renamed from: a */
    public static C3293g m4078a(Context context) {
        C3293g c3293g;
        synchronized (f9378l) {
            if (f9379m == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                Looper looper = handlerThread.getLooper();
                Context applicationContext = context.getApplicationContext();
                Object obj = GoogleApiAvailability.f20480c;
                f9379m = new C3293g(applicationContext, looper, GoogleApiAvailability.f20481d);
            }
            c3293g = f9379m;
        }
        return c3293g;
    }

    /* JADX INFO: renamed from: b */
    public final void m4079b(@NonNull C3277a1 c3277a1) {
        synchronized (f9378l) {
            if (this.f9387u != c3277a1) {
                this.f9387u = c3277a1;
                this.f9388v.clear();
            }
            this.f9388v.addAll(c3277a1.f9343o);
        }
    }

    /* JADX INFO: renamed from: c */
    public final boolean m4080c(ConnectionResult connectionResult, int i) {
        PendingIntent activity;
        GoogleApiAvailability googleApiAvailability = this.f9382p;
        Context context = this.f9381o;
        Objects.requireNonNull(googleApiAvailability);
        if (connectionResult.m9019w0()) {
            activity = connectionResult.f20475m;
        } else {
            Intent intentMo4017a = googleApiAvailability.mo4017a(context, connectionResult.f20474l, null);
            activity = intentMo4017a == null ? null : PendingIntent.getActivity(context, 0, intentMo4017a, 134217728);
        }
        if (activity == null) {
            return false;
        }
        int i2 = connectionResult.f20474l;
        int i3 = GoogleApiActivity.f20485j;
        Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
        intent.putExtra("pending_intent", activity);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", true);
        googleApiAvailability.m9028i(context, i2, PendingIntent.getActivity(context, 0, intent, 134217728));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @WorkerThread
    /* JADX INFO: renamed from: d */
    public final a<?> m4081d(C3267b<?> c3267b) throws PackageManager.NameNotFoundException {
        Object obj = c3267b.f9329d;
        a<?> aVar = this.f9386t.get(obj);
        if (aVar == null) {
            aVar = new a<>(c3267b);
            this.f9386t.put(obj, aVar);
        }
        if (aVar.m4098s()) {
            this.f9389w.add(obj);
        }
        aVar.m4097r();
        return aVar;
    }

    @Override // android.os.Handler.Callback
    @WorkerThread
    public boolean handleMessage(Message message) throws PackageManager.NameNotFoundException {
        a<?> next;
        Feature[] featureArrMo4111f;
        boolean z2;
        int i = message.what;
        int i2 = 0;
        switch (i) {
            case 1:
                this.f9380n = ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.f9390x.removeMessages(12);
                for (C3278b<?> c3278b : this.f9386t.keySet()) {
                    Handler handler = this.f9390x;
                    handler.sendMessageDelayed(handler.obtainMessage(12, c3278b), this.f9380n);
                }
                return true;
            case 2:
                Objects.requireNonNull((C3316r0) message.obj);
                throw null;
            case 3:
                for (a<?> aVar : this.f9386t.values()) {
                    aVar.m4096q();
                    aVar.m4097r();
                }
                return true;
            case 4:
            case 8:
            case 13:
                C3282c0 c3282c0 = (C3282c0) message.obj;
                a<?> aVarM4081d = this.f9386t.get(c3282c0.f9356c.f9329d);
                if (aVarM4081d == null) {
                    aVarM4081d = m4081d(c3282c0.f9356c);
                }
                if (!aVarM4081d.m4098s() || this.f9385s.get() == c3282c0.f9355b) {
                    aVarM4081d.m4089j(c3282c0.f9354a);
                } else {
                    c3282c0.f9354a.mo4072b(f9376j);
                    aVarM4081d.m4083b();
                }
                return true;
            case 5:
                int i3 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<a<?>> it = this.f9386t.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        if (next.f9399h == i3) {
                        }
                    } else {
                        next = null;
                    }
                }
                if (next != null) {
                    GoogleApiAvailability googleApiAvailability = this.f9382p;
                    int i4 = connectionResult.f20474l;
                    Objects.requireNonNull(googleApiAvailability);
                    AtomicBoolean atomicBoolean = C3260e.f9309a;
                    String strM9018y0 = ConnectionResult.m9018y0(i4);
                    String str = connectionResult.f20476n;
                    Status status = new Status(17, outline.m861l(outline.m841b(str, outline.m841b(strM9018y0, 69)), "Error resolution was canceled by the user, original error message: ", strM9018y0, ": ", str));
                    AnimatableValueParser.m567s(C3293g.this.f9390x);
                    next.m4088h(status, null, false);
                } else {
                    StringBuilder sb = new StringBuilder(76);
                    sb.append("Could not find API instance ");
                    sb.append(i3);
                    sb.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb.toString(), new Exception());
                }
                return true;
            case 6:
                if (this.f9381o.getApplicationContext() instanceof Application) {
                    ComponentCallbacks2C3281c.m4064a((Application) this.f9381o.getApplicationContext());
                    ComponentCallbacks2C3281c componentCallbacks2C3281c = ComponentCallbacks2C3281c.f9349j;
                    C3319t c3319t = new C3319t(this);
                    Objects.requireNonNull(componentCallbacks2C3281c);
                    synchronized (componentCallbacks2C3281c) {
                        componentCallbacks2C3281c.f9352m.add(c3319t);
                        break;
                    }
                    if (!componentCallbacks2C3281c.f9351l.get()) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                        if (!componentCallbacks2C3281c.f9351l.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                            componentCallbacks2C3281c.f9350k.set(true);
                        }
                    }
                    if (!componentCallbacks2C3281c.f9350k.get()) {
                        this.f9380n = 300000L;
                    }
                }
                return true;
            case 7:
                m4081d((C3267b) message.obj);
                return true;
            case 9:
                if (this.f9386t.containsKey(message.obj)) {
                    a<?> aVar2 = this.f9386t.get(message.obj);
                    AnimatableValueParser.m567s(C3293g.this.f9390x);
                    if (aVar2.f9401j) {
                        aVar2.m4097r();
                    }
                }
                return true;
            case 10:
                Iterator<C3278b<?>> it2 = this.f9389w.iterator();
                while (it2.hasNext()) {
                    a<?> aVarRemove = this.f9386t.remove(it2.next());
                    if (aVarRemove != null) {
                        aVarRemove.m4083b();
                    }
                }
                this.f9389w.clear();
                return true;
            case 11:
                if (this.f9386t.containsKey(message.obj)) {
                    a<?> aVar3 = this.f9386t.get(message.obj);
                    AnimatableValueParser.m567s(C3293g.this.f9390x);
                    if (aVar3.f9401j) {
                        aVar3.m4101v();
                        C3293g c3293g = C3293g.this;
                        Status status2 = c3293g.f9382p.m9024c(c3293g.f9381o) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error.");
                        AnimatableValueParser.m567s(C3293g.this.f9390x);
                        aVar3.m4088h(status2, null, false);
                        aVar3.f9393b.m4032c("Timing out connection while resuming.");
                    }
                }
                return true;
            case 12:
                if (this.f9386t.containsKey(message.obj)) {
                    this.f9386t.get(message.obj).m4090k(true);
                }
                return true;
            case 14:
                Objects.requireNonNull((C3280b1) message.obj);
                if (!this.f9386t.containsKey(null)) {
                    throw null;
                }
                this.f9386t.get(null).m4090k(false);
                throw null;
            case 15:
                c cVar = (c) message.obj;
                if (this.f9386t.containsKey(cVar.f9411a)) {
                    a<?> aVar4 = this.f9386t.get(cVar.f9411a);
                    if (aVar4.f9402k.contains(cVar) && !aVar4.f9401j) {
                        if (aVar4.f9393b.m4038j()) {
                            aVar4.m4100u();
                        } else {
                            aVar4.m4097r();
                        }
                    }
                }
                return true;
            case 16:
                c cVar2 = (c) message.obj;
                if (this.f9386t.containsKey(cVar2.f9411a)) {
                    a<?> aVar5 = this.f9386t.get(cVar2.f9411a);
                    if (aVar5.f9402k.remove(cVar2)) {
                        C3293g.this.f9390x.removeMessages(15, cVar2);
                        C3293g.this.f9390x.removeMessages(16, cVar2);
                        Feature feature = cVar2.f9412b;
                        ArrayList arrayList = new ArrayList(aVar5.f9392a.size());
                        for (AbstractC3317s abstractC3317s : aVar5.f9392a) {
                            if ((abstractC3317s instanceof AbstractC3306m0) && (featureArrMo4111f = ((AbstractC3306m0) abstractC3317s).mo4111f(aVar5)) != null) {
                                int length = featureArrMo4111f.length;
                                int i5 = 0;
                                while (true) {
                                    if (i5 < length) {
                                        if (AnimatableValueParser.m524h0(featureArrMo4111f[i5], feature)) {
                                            z2 = i5 >= 0;
                                        } else {
                                            i5++;
                                        }
                                    }
                                }
                                if (z2) {
                                    arrayList.add(abstractC3317s);
                                }
                            }
                        }
                        int size = arrayList.size();
                        while (i2 < size) {
                            Object obj = arrayList.get(i2);
                            i2++;
                            AbstractC3317s abstractC3317s2 = (AbstractC3317s) obj;
                            aVar5.f9392a.remove(abstractC3317s2);
                            abstractC3317s2.mo4074e(new UnsupportedApiCallException(feature));
                        }
                    }
                }
                return true;
            default:
                outline.m852g0(31, "Unknown message id: ", i, "GoogleApiManager");
                return false;
        }
    }
}

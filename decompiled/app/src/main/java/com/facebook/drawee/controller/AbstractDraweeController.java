package com.facebook.drawee.controller;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.ImmutableMap;
import p007b.p109f.p115d.p119d.Objects2;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p129e.AbstractDataSource3;
import p007b.p109f.p129e.BaseDataSubscriber;
import p007b.p109f.p132g.p138b.DeferredReleaser;
import p007b.p109f.p132g.p138b.DeferredReleaserConcurrentImpl;
import p007b.p109f.p132g.p138b.DraweeEventTracker;
import p007b.p109f.p132g.p138b.RetryManager;
import p007b.p109f.p132g.p139c.BaseControllerListener;
import p007b.p109f.p132g.p139c.ForwardingControllerListener;
import p007b.p109f.p132g.p142e.ScaleTypeDrawable;
import p007b.p109f.p132g.p144g.GestureDetector;
import p007b.p109f.p132g.p145h.SettableDraweeHierarchy;
import p007b.p109f.p148h.p158b.p159a.ControllerListener2;
import p007b.p109f.p148h.p158b.p159a.ForwardingControllerListener2;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* loaded from: classes.dex */
public abstract class AbstractDraweeController<T, INFO> implements DraweeController, DeferredReleaser.a, GestureDetector.a {

    /* renamed from: a */
    public static final Map<String, Object> f19451a = ImmutableMap.m967of("component_tag", "drawee");

    /* renamed from: b */
    public static final Map<String, Object> f19452b = ImmutableMap.m968of("origin", "memory_bitmap", "origin_sub", "shortcut");

    /* renamed from: c */
    public static final Class<?> f19453c = AbstractDraweeController.class;

    /* renamed from: d */
    public final DraweeEventTracker f19454d;

    /* renamed from: e */
    public final DeferredReleaser f19455e;

    /* renamed from: f */
    public final Executor f19456f;

    /* renamed from: g */
    public RetryManager f19457g;

    /* renamed from: h */
    public GestureDetector f19458h;

    /* renamed from: i */
    public ControllerListener<INFO> f19459i;

    /* renamed from: j */
    public ForwardingControllerListener2<INFO> f19460j;

    /* renamed from: k */
    public SettableDraweeHierarchy f19461k;

    /* renamed from: l */
    public Drawable f19462l;

    /* renamed from: m */
    public String f19463m;

    /* renamed from: n */
    public Object f19464n;

    /* renamed from: o */
    public boolean f19465o;

    /* renamed from: p */
    public boolean f19466p;

    /* renamed from: q */
    public boolean f19467q;

    /* renamed from: r */
    public boolean f19468r;

    /* renamed from: s */
    public String f19469s;

    /* renamed from: t */
    public DataSource<T> f19470t;

    /* renamed from: u */
    public T f19471u;

    /* renamed from: v */
    public boolean f19472v;

    /* renamed from: w */
    public Drawable f19473w;

    /* renamed from: com.facebook.drawee.controller.AbstractDraweeController$a */
    public class C10640a extends BaseDataSubscriber<T> {

        /* renamed from: a */
        public final /* synthetic */ String f19474a;

        /* renamed from: b */
        public final /* synthetic */ boolean f19475b;

        public C10640a(String str, boolean z2) {
            this.f19474a = str;
            this.f19475b = z2;
        }

        @Override // p007b.p109f.p129e.BaseDataSubscriber
        public void onFailureImpl(DataSource<T> dataSource) {
            AbstractDraweeController abstractDraweeController = AbstractDraweeController.this;
            String str = this.f19474a;
            Throwable thMo1020d = dataSource.mo1020d();
            Map<String, Object> map = AbstractDraweeController.f19451a;
            abstractDraweeController.m8664u(str, dataSource, thMo1020d, true);
        }

        @Override // p007b.p109f.p129e.BaseDataSubscriber
        public void onNewResultImpl(DataSource<T> dataSource) {
            boolean zMo1019c = dataSource.mo1019c();
            boolean zMo1021e = dataSource.mo1021e();
            float progress = dataSource.getProgress();
            T result = dataSource.getResult();
            if (result != null) {
                AbstractDraweeController abstractDraweeController = AbstractDraweeController.this;
                String str = this.f19474a;
                boolean z2 = this.f19475b;
                Map<String, Object> map = AbstractDraweeController.f19451a;
                abstractDraweeController.m8665w(str, dataSource, result, progress, zMo1019c, z2, zMo1021e);
                return;
            }
            if (zMo1019c) {
                AbstractDraweeController abstractDraweeController2 = AbstractDraweeController.this;
                String str2 = this.f19474a;
                NullPointerException nullPointerException = new NullPointerException();
                Map<String, Object> map2 = AbstractDraweeController.f19451a;
                abstractDraweeController2.m8664u(str2, dataSource, nullPointerException, true);
            }
        }

        @Override // p007b.p109f.p129e.BaseDataSubscriber, p007b.p109f.p129e.DataSubscriber
        public void onProgressUpdate(DataSource<T> dataSource) {
            AbstractDataSource3 abstractDataSource3 = (AbstractDataSource3) dataSource;
            boolean zMo1019c = abstractDataSource3.mo1019c();
            float progress = abstractDataSource3.getProgress();
            AbstractDraweeController abstractDraweeController = AbstractDraweeController.this;
            String str = this.f19474a;
            Map<String, Object> map = AbstractDraweeController.f19451a;
            if (!abstractDraweeController.m8659o(str, abstractDataSource3)) {
                abstractDraweeController.m8660p("ignore_old_datasource @ onProgress", null);
                abstractDataSource3.close();
            } else {
                if (zMo1019c) {
                    return;
                }
                abstractDraweeController.f19461k.mo1134d(progress, false);
            }
        }
    }

    /* renamed from: com.facebook.drawee.controller.AbstractDraweeController$b */
    public static class C10641b<INFO> extends ForwardingControllerListener<INFO> {
    }

    public AbstractDraweeController(DeferredReleaser deferredReleaser, Executor executor, String str, Object obj) {
        this.f19454d = DraweeEventTracker.f3261b ? new DraweeEventTracker() : DraweeEventTracker.f3260a;
        this.f19460j = new ForwardingControllerListener2<>();
        this.f19472v = true;
        this.f19455e = deferredReleaser;
        this.f19456f = executor;
        m8658n(null, null);
    }

    /* renamed from: A */
    public void m8647A(ControllerListener<? super INFO> controllerListener) {
        Objects.requireNonNull(controllerListener);
        ControllerListener<INFO> controllerListener2 = this.f19459i;
        if (!(controllerListener2 instanceof C10641b)) {
            if (controllerListener2 == controllerListener) {
                this.f19459i = null;
            }
        } else {
            C10641b c10641b = (C10641b) controllerListener2;
            synchronized (c10641b) {
                int iIndexOf = c10641b.f3298a.indexOf(controllerListener);
                if (iIndexOf != -1) {
                    c10641b.f3298a.set(iIndexOf, null);
                }
            }
        }
    }

    /* renamed from: B */
    public void m8648B(DataSource<T> dataSource, INFO info) {
        m8657i().onSubmit(this.f19463m, this.f19464n);
        this.f19460j.mo1071a(this.f19463m, this.f19464n, m8662r(dataSource, info, mo1051m()));
    }

    /* renamed from: C */
    public final void m8649C(String str, T t, DataSource<T> dataSource) {
        INFO infoMo1050l = mo1050l(t);
        m8657i().onFinalImageSet(str, infoMo1050l, mo8654c());
        this.f19460j.mo1074d(str, infoMo1050l, m8662r(dataSource, infoMo1050l, null));
    }

    /* renamed from: D */
    public final boolean m8650D() {
        RetryManager retryManager;
        if (this.f19467q && (retryManager = this.f19457g) != null) {
            if (retryManager.f3288a && retryManager.f3290c < retryManager.f3289b) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: E */
    public void m8651E() {
        FrescoSystrace.m1527b();
        T tMo1047h = mo1047h();
        if (tMo1047h != null) {
            FrescoSystrace.m1527b();
            this.f19470t = null;
            this.f19466p = true;
            this.f19467q = false;
            this.f19454d.m1084a(DraweeEventTracker.a.ON_SUBMIT_CACHE_HIT);
            m8648B(this.f19470t, mo1050l(tMo1047h));
            mo1053v(this.f19463m, tMo1047h);
            m8665w(this.f19463m, this.f19470t, tMo1047h, 1.0f, true, true, true);
            FrescoSystrace.m1527b();
            FrescoSystrace.m1527b();
            return;
        }
        this.f19454d.m1084a(DraweeEventTracker.a.ON_DATASOURCE_SUBMIT);
        this.f19461k.mo1134d(0.0f, true);
        this.f19466p = true;
        this.f19467q = false;
        DataSource<T> dataSourceMo1048j = mo1048j();
        this.f19470t = dataSourceMo1048j;
        m8648B(dataSourceMo1048j, null);
        if (FLog.m980h(2)) {
            FLog.m982j(f19453c, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.f19463m, Integer.valueOf(System.identityHashCode(this.f19470t)));
        }
        this.f19470t.mo1022f(new C10640a(this.f19463m, this.f19470t.mo1018b()), this.f19456f);
        FrescoSystrace.m1527b();
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    /* renamed from: a */
    public void mo8652a() {
        FrescoSystrace.m1527b();
        if (FLog.m980h(2)) {
            System.identityHashCode(this);
        }
        this.f19454d.m1084a(DraweeEventTracker.a.ON_DETACH_CONTROLLER);
        this.f19465o = false;
        DeferredReleaserConcurrentImpl deferredReleaserConcurrentImpl = (DeferredReleaserConcurrentImpl) this.f19455e;
        Objects.requireNonNull(deferredReleaserConcurrentImpl);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            synchronized (deferredReleaserConcurrentImpl.f3254b) {
                if (!deferredReleaserConcurrentImpl.f3256d.contains(this)) {
                    deferredReleaserConcurrentImpl.f3256d.add(this);
                    boolean z2 = deferredReleaserConcurrentImpl.f3256d.size() == 1;
                    if (z2) {
                        deferredReleaserConcurrentImpl.f3255c.post(deferredReleaserConcurrentImpl.f3258f);
                    }
                }
            }
        } else {
            release();
        }
        FrescoSystrace.m1527b();
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    /* renamed from: b */
    public DraweeHierarchy mo8653b() {
        return this.f19461k;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    /* renamed from: c */
    public Animatable mo8654c() {
        Object obj = this.f19473w;
        if (obj instanceof Animatable) {
            return (Animatable) obj;
        }
        return null;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    /* renamed from: d */
    public void mo8655d() {
        FrescoSystrace.m1527b();
        if (FLog.m980h(2)) {
            FLog.m982j(f19453c, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.f19463m, this.f19466p ? "request already submitted" : "request needs submit");
        }
        this.f19454d.m1084a(DraweeEventTracker.a.ON_ATTACH_CONTROLLER);
        Objects.requireNonNull(this.f19461k);
        this.f19455e.mo1083a(this);
        this.f19465o = true;
        if (!this.f19466p) {
            m8651E();
        }
        FrescoSystrace.m1527b();
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    /* renamed from: e */
    public void mo1045e(DraweeHierarchy draweeHierarchy) {
        if (FLog.m980h(2)) {
            FLog.m982j(f19453c, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.f19463m, draweeHierarchy);
        }
        this.f19454d.m1084a(draweeHierarchy != null ? DraweeEventTracker.a.ON_SET_HIERARCHY : DraweeEventTracker.a.ON_CLEAR_HIERARCHY);
        if (this.f19466p) {
            this.f19455e.mo1083a(this);
            release();
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.f19461k;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.mo1131a(null);
            this.f19461k = null;
        }
        if (draweeHierarchy != null) {
            AnimatableValueParser.m527i(Boolean.valueOf(draweeHierarchy instanceof SettableDraweeHierarchy));
            SettableDraweeHierarchy settableDraweeHierarchy2 = (SettableDraweeHierarchy) draweeHierarchy;
            this.f19461k = settableDraweeHierarchy2;
            settableDraweeHierarchy2.mo1131a(this.f19462l);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f */
    public void m8656f(ControllerListener<? super INFO> controllerListener) {
        Objects.requireNonNull(controllerListener);
        ControllerListener<INFO> controllerListener2 = this.f19459i;
        if (controllerListener2 instanceof C10641b) {
            ((C10641b) controllerListener2).m1085a(controllerListener);
            return;
        }
        if (controllerListener2 == null) {
            this.f19459i = controllerListener;
            return;
        }
        FrescoSystrace.m1527b();
        C10641b c10641b = new C10641b();
        c10641b.m1085a(controllerListener2);
        c10641b.m1085a(controllerListener);
        FrescoSystrace.m1527b();
        this.f19459i = c10641b;
    }

    /* renamed from: g */
    public abstract Drawable mo1046g(T t);

    /* renamed from: h */
    public T mo1047h() {
        return null;
    }

    /* renamed from: i */
    public ControllerListener<INFO> m8657i() {
        ControllerListener<INFO> controllerListener = this.f19459i;
        return controllerListener == null ? BaseControllerListener.getNoOpListener() : controllerListener;
    }

    /* renamed from: j */
    public abstract DataSource<T> mo1048j();

    /* renamed from: k */
    public int mo1049k(T t) {
        return System.identityHashCode(t);
    }

    /* renamed from: l */
    public abstract INFO mo1050l(T t);

    /* renamed from: m */
    public Uri mo1051m() {
        return null;
    }

    /* renamed from: n */
    public final synchronized void m8658n(String str, Object obj) {
        DeferredReleaser deferredReleaser;
        FrescoSystrace.m1527b();
        this.f19454d.m1084a(DraweeEventTracker.a.ON_INIT_CONTROLLER);
        if (!this.f19472v && (deferredReleaser = this.f19455e) != null) {
            deferredReleaser.mo1083a(this);
        }
        this.f19465o = false;
        m8666y();
        this.f19468r = false;
        RetryManager retryManager = this.f19457g;
        if (retryManager != null) {
            retryManager.f3288a = false;
            retryManager.f3289b = 4;
            retryManager.f3290c = 0;
        }
        GestureDetector gestureDetector = this.f19458h;
        if (gestureDetector != null) {
            gestureDetector.f3480a = null;
            gestureDetector.f3482c = false;
            gestureDetector.f3483d = false;
            gestureDetector.f3480a = this;
        }
        ControllerListener<INFO> controllerListener = this.f19459i;
        if (controllerListener instanceof C10641b) {
            C10641b c10641b = (C10641b) controllerListener;
            synchronized (c10641b) {
                c10641b.f3298a.clear();
            }
        } else {
            this.f19459i = null;
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.f19461k;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.reset();
            this.f19461k.mo1131a(null);
            this.f19461k = null;
        }
        this.f19462l = null;
        if (FLog.m980h(2)) {
            FLog.m982j(f19453c, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.f19463m, str);
        }
        this.f19463m = str;
        this.f19464n = obj;
        FrescoSystrace.m1527b();
    }

    /* renamed from: o */
    public final boolean m8659o(String str, DataSource<T> dataSource) {
        if (dataSource == null && this.f19470t == null) {
            return true;
        }
        return str.equals(this.f19463m) && dataSource == this.f19470t && this.f19466p;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector.a aVar;
        boolean zM980h = FLog.m980h(2);
        if (zM980h) {
            FLog.m982j(f19453c, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.f19463m, motionEvent);
        }
        GestureDetector gestureDetector = this.f19458h;
        if (gestureDetector == null) {
            return false;
        }
        if (!gestureDetector.f3482c && !m8650D()) {
            return false;
        }
        GestureDetector gestureDetector2 = this.f19458h;
        Objects.requireNonNull(gestureDetector2);
        int action = motionEvent.getAction();
        if (action == 0) {
            gestureDetector2.f3482c = true;
            gestureDetector2.f3483d = true;
            gestureDetector2.f3484e = motionEvent.getEventTime();
            gestureDetector2.f3485f = motionEvent.getX();
            gestureDetector2.f3486g = motionEvent.getY();
        } else if (action == 1) {
            gestureDetector2.f3482c = false;
            if (Math.abs(motionEvent.getX() - gestureDetector2.f3485f) > gestureDetector2.f3481b || Math.abs(motionEvent.getY() - gestureDetector2.f3486g) > gestureDetector2.f3481b) {
                gestureDetector2.f3483d = false;
            }
            if (gestureDetector2.f3483d && motionEvent.getEventTime() - gestureDetector2.f3484e <= ViewConfiguration.getLongPressTimeout() && (aVar = gestureDetector2.f3480a) != null) {
                AbstractDraweeController abstractDraweeController = (AbstractDraweeController) aVar;
                if (zM980h) {
                    System.identityHashCode(abstractDraweeController);
                }
                if (abstractDraweeController.m8650D()) {
                    abstractDraweeController.f19457g.f3290c++;
                    abstractDraweeController.f19461k.reset();
                    abstractDraweeController.m8651E();
                }
            }
            gestureDetector2.f3483d = false;
        } else if (action != 2) {
            if (action == 3) {
                gestureDetector2.f3482c = false;
                gestureDetector2.f3483d = false;
            }
        } else if (Math.abs(motionEvent.getX() - gestureDetector2.f3485f) > gestureDetector2.f3481b || Math.abs(motionEvent.getY() - gestureDetector2.f3486g) > gestureDetector2.f3481b) {
            gestureDetector2.f3483d = false;
        }
        return true;
    }

    /* renamed from: p */
    public final void m8660p(String str, Throwable th) {
        if (FLog.m980h(2)) {
            System.identityHashCode(this);
        }
    }

    /* renamed from: q */
    public final void m8661q(String str, T t) {
        if (FLog.m980h(2)) {
            System.identityHashCode(this);
            if (t != null) {
                t.getClass().getSimpleName();
            }
            mo1049k(t);
        }
    }

    /* renamed from: r */
    public final ControllerListener2.a m8662r(DataSource<T> dataSource, INFO info, Uri uri) {
        return m8663s(dataSource == null ? null : dataSource.mo1017a(), mo1052t(info), uri);
    }

    @Override // p007b.p109f.p132g.p138b.DeferredReleaser.a
    public void release() {
        this.f19454d.m1084a(DraweeEventTracker.a.ON_RELEASE_CONTROLLER);
        RetryManager retryManager = this.f19457g;
        if (retryManager != null) {
            retryManager.f3290c = 0;
        }
        GestureDetector gestureDetector = this.f19458h;
        if (gestureDetector != null) {
            gestureDetector.f3482c = false;
            gestureDetector.f3483d = false;
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.f19461k;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.reset();
        }
        m8666y();
    }

    /* renamed from: s */
    public final ControllerListener2.a m8663s(Map<String, Object> map, Map<String, Object> map2, Uri uri) {
        SettableDraweeHierarchy settableDraweeHierarchy = this.f19461k;
        if (settableDraweeHierarchy instanceof GenericDraweeHierarchy) {
            GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) settableDraweeHierarchy;
            String.valueOf(!(genericDraweeHierarchy.m8675k(2) instanceof ScaleTypeDrawable) ? null : genericDraweeHierarchy.m8676l(2).f3435n);
            if (genericDraweeHierarchy.m8675k(2) instanceof ScaleTypeDrawable) {
                PointF pointF = genericDraweeHierarchy.m8676l(2).f3437p;
            }
        }
        Map<String, Object> map3 = f19451a;
        Map<String, Object> map4 = f19452b;
        SettableDraweeHierarchy settableDraweeHierarchy2 = this.f19461k;
        Rect bounds = settableDraweeHierarchy2 != null ? settableDraweeHierarchy2.getBounds() : null;
        Object obj = this.f19464n;
        ControllerListener2.a aVar = new ControllerListener2.a();
        if (bounds != null) {
            bounds.width();
            bounds.height();
        }
        aVar.f3567e = obj;
        aVar.f3565c = map;
        aVar.f3566d = map2;
        aVar.f3564b = map4;
        aVar.f3563a = map3;
        return aVar;
    }

    /* renamed from: t */
    public abstract Map<String, Object> mo1052t(INFO info);

    public String toString() {
        Objects2 objects2M526h2 = AnimatableValueParser.m526h2(this);
        objects2M526h2.m970b("isAttached", this.f19465o);
        objects2M526h2.m970b("isRequestSubmitted", this.f19466p);
        objects2M526h2.m970b("hasFetchFailed", this.f19467q);
        objects2M526h2.m969a("fetchedImage", mo1049k(this.f19471u));
        objects2M526h2.m971c("events", this.f19454d.toString());
        return objects2M526h2.toString();
    }

    /* renamed from: u */
    public final void m8664u(String str, DataSource<T> dataSource, Throwable th, boolean z2) {
        Drawable drawable;
        FrescoSystrace.m1527b();
        if (!m8659o(str, dataSource)) {
            m8660p("ignore_old_datasource @ onFailure", th);
            dataSource.close();
            FrescoSystrace.m1527b();
            return;
        }
        this.f19454d.m1084a(z2 ? DraweeEventTracker.a.ON_DATASOURCE_FAILURE : DraweeEventTracker.a.ON_DATASOURCE_FAILURE_INT);
        if (z2) {
            m8660p("final_failed @ onFailure", th);
            this.f19470t = null;
            this.f19467q = true;
            SettableDraweeHierarchy settableDraweeHierarchy = this.f19461k;
            if (settableDraweeHierarchy != null) {
                if (this.f19468r && (drawable = this.f19473w) != null) {
                    settableDraweeHierarchy.mo1135f(drawable, 1.0f, true);
                } else if (m8650D()) {
                    settableDraweeHierarchy.mo1132b(th);
                } else {
                    settableDraweeHierarchy.mo1133c(th);
                }
            }
            ControllerListener2.a aVarM8662r = m8662r(dataSource, null, null);
            m8657i().onFailure(this.f19463m, th);
            this.f19460j.mo1072b(this.f19463m, th, aVarM8662r);
        } else {
            m8660p("intermediate_failed @ onFailure", th);
            m8657i().onIntermediateImageFailed(this.f19463m, th);
            Objects.requireNonNull(this.f19460j);
        }
        FrescoSystrace.m1527b();
    }

    /* renamed from: v */
    public void mo1053v(String str, T t) {
    }

    /* renamed from: w */
    public final void m8665w(String str, DataSource<T> dataSource, T t, float f, boolean z2, boolean z3, boolean z4) {
        try {
            FrescoSystrace.m1527b();
            if (!m8659o(str, dataSource)) {
                m8661q("ignore_old_datasource @ onNewResult", t);
                mo1055z(t);
                dataSource.close();
                FrescoSystrace.m1527b();
                return;
            }
            this.f19454d.m1084a(z2 ? DraweeEventTracker.a.ON_DATASOURCE_RESULT : DraweeEventTracker.a.ON_DATASOURCE_RESULT_INT);
            try {
                Drawable drawableMo1046g = mo1046g(t);
                T t2 = this.f19471u;
                Drawable drawable = this.f19473w;
                this.f19471u = t;
                this.f19473w = drawableMo1046g;
                try {
                    if (z2) {
                        m8661q("set_final_result @ onNewResult", t);
                        this.f19470t = null;
                        this.f19461k.mo1135f(drawableMo1046g, 1.0f, z3);
                        m8649C(str, t, dataSource);
                    } else if (z4) {
                        m8661q("set_temporary_result @ onNewResult", t);
                        this.f19461k.mo1135f(drawableMo1046g, 1.0f, z3);
                        m8649C(str, t, dataSource);
                    } else {
                        m8661q("set_intermediate_result @ onNewResult", t);
                        this.f19461k.mo1135f(drawableMo1046g, f, z3);
                        m8657i().onIntermediateImageSet(str, mo1050l(t));
                        Objects.requireNonNull(this.f19460j);
                    }
                    if (drawable != null && drawable != drawableMo1046g) {
                        mo1054x(drawable);
                    }
                    if (t2 != null && t2 != t) {
                        m8661q("release_previous_result @ onNewResult", t2);
                        mo1055z(t2);
                    }
                    FrescoSystrace.m1527b();
                } catch (Throwable th) {
                    if (drawable != null && drawable != drawableMo1046g) {
                        mo1054x(drawable);
                    }
                    if (t2 != null && t2 != t) {
                        m8661q("release_previous_result @ onNewResult", t2);
                        mo1055z(t2);
                    }
                    throw th;
                }
            } catch (Exception e) {
                m8661q("drawable_failed @ onNewResult", t);
                mo1055z(t);
                m8664u(str, dataSource, e, z2);
                FrescoSystrace.m1527b();
            }
        } catch (Throwable th2) {
            FrescoSystrace.m1527b();
            throw th2;
        }
    }

    /* renamed from: x */
    public abstract void mo1054x(Drawable drawable);

    /* renamed from: y */
    public final void m8666y() {
        Map<String, Object> mapMo1017a;
        Map<String, Object> mapMo1052t;
        boolean z2 = this.f19466p;
        this.f19466p = false;
        this.f19467q = false;
        DataSource<T> dataSource = this.f19470t;
        if (dataSource != null) {
            mapMo1017a = dataSource.mo1017a();
            this.f19470t.close();
            this.f19470t = null;
        } else {
            mapMo1017a = null;
        }
        Drawable drawable = this.f19473w;
        if (drawable != null) {
            mo1054x(drawable);
        }
        if (this.f19469s != null) {
            this.f19469s = null;
        }
        this.f19473w = null;
        T t = this.f19471u;
        if (t != null) {
            mapMo1052t = mo1052t(mo1050l(t));
            m8661q("release", this.f19471u);
            mo1055z(this.f19471u);
            this.f19471u = null;
        } else {
            mapMo1052t = null;
        }
        if (z2) {
            m8657i().onRelease(this.f19463m);
            this.f19460j.mo1073c(this.f19463m, m8663s(mapMo1017a, mapMo1052t, null));
        }
    }

    /* renamed from: z */
    public abstract void mo1055z(T t);
}

package com.discord.utilities.press;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.analytics.Traits;
import d0.z.d.m;
import j0.k.b;
import j0.p.a;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;

/* compiled from: RepeatingOnTouchListener.kt */
/* loaded from: classes2.dex */
public final class RepeatingOnTouchListener implements View.OnTouchListener {
    private final Action0 action;
    private final Action0 initialAction;
    private final long initialDelay;
    private final long repeatRate;
    private Subscription subscription;
    private final TimeUnit timeUnit;

    /* compiled from: RepeatingOnTouchListener.kt */
    /* renamed from: com.discord.utilities.press.RepeatingOnTouchListener$subscribe$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Long, Observable<? extends Long>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends Long> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Long> call2(Long l) {
            long repeatRate = RepeatingOnTouchListener.this.getRepeatRate();
            return Observable.F(repeatRate, repeatRate, RepeatingOnTouchListener.this.getTimeUnit(), a.a());
        }
    }

    /* compiled from: RepeatingOnTouchListener.kt */
    /* renamed from: com.discord.utilities.press.RepeatingOnTouchListener$subscribe$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Long> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Long l) {
            call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Long l) {
            RepeatingOnTouchListener.this.getAction().call();
        }
    }

    /* compiled from: RepeatingOnTouchListener.kt */
    /* renamed from: com.discord.utilities.press.RepeatingOnTouchListener$subscribe$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Throwable> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
        }
    }

    public RepeatingOnTouchListener(long j, long j2, TimeUnit timeUnit, Action0 action0) {
        this(j, j2, timeUnit, action0, null, 16, null);
    }

    public RepeatingOnTouchListener(long j, long j2, TimeUnit timeUnit, Action0 action0, Action0 action02) {
        m.checkNotNullParameter(timeUnit, "timeUnit");
        m.checkNotNullParameter(action0, "action");
        m.checkNotNullParameter(action02, "initialAction");
        this.initialDelay = j;
        this.repeatRate = j2;
        this.timeUnit = timeUnit;
        this.action = action0;
        this.initialAction = action02;
    }

    private final void subscribe() {
        this.subscription = Observable.d0(this.initialDelay, this.timeUnit).A(new AnonymousClass1()).J(j0.j.b.a.a()).W(new AnonymousClass2(), AnonymousClass3.INSTANCE);
    }

    public final Action0 getAction() {
        return this.action;
    }

    public final Action0 getInitialAction() {
        return this.initialAction;
    }

    public final long getInitialDelay() {
        return this.initialDelay;
    }

    public final long getRepeatRate() {
        return this.repeatRate;
    }

    public final TimeUnit getTimeUnit() {
        return this.timeUnit;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        Integer numValueOf = event != null ? Integer.valueOf(event.getAction()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            this.initialAction.call();
            subscribe();
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == 2) {
            return true;
        }
        Subscription subscription = this.subscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.subscription = null;
        return true;
    }

    public /* synthetic */ RepeatingOnTouchListener(long j, long j2, TimeUnit timeUnit, Action0 action0, Action0 action02, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, timeUnit, action0, (i & 16) != 0 ? action0 : action02);
    }
}

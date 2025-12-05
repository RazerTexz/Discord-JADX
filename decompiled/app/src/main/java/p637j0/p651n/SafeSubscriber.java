package p637j0.p651n;

import java.util.Arrays;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p652o.C12774l;
import p637j0.p652o.RxJavaPlugins;
import p658rx.Subscriber;
import p658rx.exceptions.CompositeException;
import p658rx.exceptions.OnCompletedFailedException;
import p658rx.exceptions.OnErrorFailedException;
import p658rx.exceptions.OnErrorNotImplementedException;
import p658rx.exceptions.UnsubscribeFailedException;

/* compiled from: SafeSubscriber.java */
/* renamed from: j0.n.b, reason: use source file name */
/* loaded from: classes3.dex */
public class SafeSubscriber<T> extends Subscriber<T> {

    /* renamed from: j */
    public final Subscriber<? super T> f27364j;

    /* renamed from: k */
    public boolean f27365k;

    public SafeSubscriber(Subscriber<? super T> subscriber) {
        super(subscriber);
        this.f27364j = subscriber;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        UnsubscribeFailedException unsubscribeFailedException;
        if (this.f27365k) {
            return;
        }
        this.f27365k = true;
        try {
            this.f27364j.onCompleted();
            try {
                unsubscribe();
            } finally {
            }
        } catch (Throwable th) {
            try {
                C3404f.m4325o1(th);
                C12774l.m10863b(th);
                throw new OnCompletedFailedException(th.getMessage(), th);
            } catch (Throwable th2) {
                try {
                    unsubscribe();
                    throw th2;
                } finally {
                }
            }
        }
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        C3404f.m4325o1(th);
        if (this.f27365k) {
            return;
        }
        this.f27365k = true;
        Objects.requireNonNull(RxJavaPlugins.f27384a.m10869b());
        try {
            this.f27364j.onError(th);
            try {
                unsubscribe();
            } catch (Throwable th2) {
                C12774l.m10863b(th2);
                throw new OnErrorFailedException(th2);
            }
        } catch (OnErrorNotImplementedException e) {
            try {
                unsubscribe();
                throw e;
            } catch (Throwable th3) {
                C12774l.m10863b(th3);
                throw new OnErrorNotImplementedException("Observer.onError not implemented and error while unsubscribing.", new CompositeException(Arrays.asList(th, th3)));
            }
        } catch (Throwable th4) {
            C12774l.m10863b(th4);
            try {
                unsubscribe();
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError", new CompositeException(Arrays.asList(th, th4)));
            } catch (Throwable th5) {
                C12774l.m10863b(th5);
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new CompositeException(Arrays.asList(th, th4, th5)));
            }
        }
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        try {
            if (this.f27365k) {
                return;
            }
            this.f27364j.onNext(t);
        } catch (Throwable th) {
            C3404f.m4325o1(th);
            onError(th);
        }
    }
}

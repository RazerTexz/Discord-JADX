package p630i0.p631d0.p632a;

import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p652o.RxJavaPlugins;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.exceptions.CompositeException;
import p658rx.exceptions.OnCompletedFailedException;
import p658rx.exceptions.OnErrorFailedException;
import p658rx.exceptions.OnErrorNotImplementedException;
import retrofit2.Response;

/* compiled from: ResultOnSubscribe.java */
/* renamed from: i0.d0.a.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class ResultOnSubscribe<T> implements Observable.InterfaceC13005a<Result4<T>> {

    /* renamed from: j */
    public final Observable.InterfaceC13005a<Response<T>> f26503j;

    /* compiled from: ResultOnSubscribe.java */
    /* renamed from: i0.d0.a.e$a */
    public static class a<R> extends Subscriber<Response<R>> {

        /* renamed from: j */
        public final Subscriber<? super Result4<R>> f26504j;

        public a(Subscriber<? super Result4<R>> subscriber) {
            super(subscriber);
            this.f26504j = subscriber;
        }

        @Override // p637j0.Observer2
        public void onCompleted() {
            this.f26504j.onCompleted();
        }

        @Override // p637j0.Observer2
        public void onError(Throwable th) {
            try {
                Subscriber<? super Result4<R>> subscriber = this.f26504j;
                Objects.requireNonNull(th, "error == null");
                subscriber.onNext(new Result4(null, th));
                this.f26504j.onCompleted();
            } catch (Throwable th2) {
                try {
                    this.f26504j.onError(th2);
                } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException unused) {
                    Objects.requireNonNull(RxJavaPlugins.f27384a.m10869b());
                } catch (Throwable th3) {
                    C3404f.m4325o1(th3);
                    new CompositeException(th2, th3);
                    Objects.requireNonNull(RxJavaPlugins.f27384a.m10869b());
                }
            }
        }

        @Override // p637j0.Observer2
        public void onNext(Object obj) {
            Response response = (Response) obj;
            Subscriber<? super Result4<R>> subscriber = this.f26504j;
            Objects.requireNonNull(response, "response == null");
            subscriber.onNext(new Result4(response, null));
        }
    }

    public ResultOnSubscribe(Observable.InterfaceC13005a<Response<T>> interfaceC13005a) {
        this.f26503j = interfaceC13005a;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        this.f26503j.call(new a((Subscriber) obj));
    }
}

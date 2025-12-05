package p637j0.p642l.p643a;

import android.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicLong;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;

/* compiled from: OnSubscribeFromArray.java */
/* renamed from: j0.l.a.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class OnSubscribeFromArray<T> implements Observable.InterfaceC13005a<T> {

    /* renamed from: j */
    public final T[] f26955j;

    /* compiled from: OnSubscribeFromArray.java */
    /* renamed from: j0.l.a.o$a */
    public static final class a<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = 3534218984725836979L;
        public final T[] array;
        public final Subscriber<? super T> child;
        public int index;

        public a(Subscriber<? super T> subscriber, T[] tArr) {
            this.child = subscriber;
            this.array = tArr;
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0079, code lost:
        
            r10.index = r5;
            r11 = addAndGet(r6);
         */
        @Override // p658rx.Producer
        /* renamed from: j */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void mo10704j(long j) {
            if (j < 0) {
                throw new IllegalArgumentException(outline.m877t("n >= 0 required but it was ", j));
            }
            if (j == RecyclerView.FOREVER_NS) {
                if (C3404f.m4276c0(this, j) == 0) {
                    Subscriber<? super T> subscriber = this.child;
                    for (R.anim animVar : this.array) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        subscriber.onNext(animVar);
                    }
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    subscriber.onCompleted();
                    return;
                }
                return;
            }
            if (j == 0 || C3404f.m4276c0(this, j) != 0) {
                return;
            }
            Subscriber<? super T> subscriber2 = this.child;
            T[] tArr = this.array;
            int length = tArr.length;
            int i = this.index;
            do {
                long j2 = 0;
                while (true) {
                    if (j == 0 || i == length) {
                        j = get() + j2;
                        if (j == 0) {
                            break;
                        }
                    } else {
                        if (subscriber2.isUnsubscribed()) {
                            return;
                        }
                        subscriber2.onNext(tArr[i]);
                        i++;
                        if (i == length) {
                            if (subscriber2.isUnsubscribed()) {
                                return;
                            }
                            subscriber2.onCompleted();
                            return;
                        }
                        j--;
                        j2--;
                    }
                }
            } while (j != 0);
        }
    }

    public OnSubscribeFromArray(T[] tArr) {
        this.f26955j = tArr;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        subscriber.setProducer(new a(subscriber, this.f26955j));
    }
}

package p007b.p008a.p020e;

import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.Subject;

/* compiled from: Backgrounded.kt */
/* renamed from: b.a.e.d, reason: use source file name */
/* loaded from: classes.dex */
public final class Backgrounded4 {

    /* renamed from: a */
    public static boolean f597a = true;

    /* renamed from: b */
    public static final Subject<Boolean, Boolean> f598b;

    /* renamed from: c */
    public static Subscription f599c;

    /* renamed from: d */
    public static final Backgrounded4 f600d = new Backgrounded4();

    static {
        BehaviorSubject behaviorSubjectM11130l0 = BehaviorSubject.m11130l0(true);
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(isBackgrounded)");
        f598b = behaviorSubjectM11130l0;
    }

    /* renamed from: a */
    public final Observable<Boolean> m185a() {
        Observable<Boolean> observableM11112r = f598b.m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "emitter.distinctUntilChanged()");
        return observableM11112r;
    }
}

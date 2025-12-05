package p007b.p008a.p018d;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* compiled from: AppTransformers.kt */
/* renamed from: b.a.d.b0 */
/* loaded from: classes.dex */
public final class C0855b0<R, T> extends Lambda implements Function1<T, Observable<R>> {
    public final /* synthetic */ Object $switchedValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0855b0(Object obj) {
        super(1);
        this.$switchedValue = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(this.$switchedValue);
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(switchedValue)");
        return scalarSynchronousObservable;
    }
}

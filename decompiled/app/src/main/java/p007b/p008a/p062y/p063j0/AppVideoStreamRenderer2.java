package p007b.p008a.p062y.p063j0;

import android.graphics.Point;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* compiled from: AppVideoStreamRenderer.kt */
/* renamed from: b.a.y.j0.a, reason: use source file name */
/* loaded from: classes2.dex */
public final class AppVideoStreamRenderer2<T, R> implements Func1<Unit, Observable<? extends Point>> {

    /* renamed from: j */
    public final /* synthetic */ RxRendererEvents f2028j;

    public AppVideoStreamRenderer2(RxRendererEvents rxRendererEvents) {
        this.f2028j = rxRendererEvents;
    }

    @Override // p637j0.p641k.Func1
    public Observable<? extends Point> call(Unit unit) {
        Observable<R> observableM11086L = this.f2028j.f2030j.m11090P(50L, TimeUnit.MILLISECONDS).m11083G(RxRendererEvents2.f2034j).m11086L();
        Intrinsics3.checkNotNullExpressionValue(observableM11086L, "frameResolutionSubject\n …  .onBackpressureLatest()");
        return observableM11086L;
    }
}

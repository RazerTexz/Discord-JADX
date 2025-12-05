package p007b.p008a.p073z.p074a.p075a;

import java.util.List;
import java.util.Map;
import p637j0.p641k.Func1;
import p637j0.p642l.p643a.OnSubscribeFlattenIterable2;
import p637j0.p642l.p643a.OnSubscribeLift;
import p637j0.p642l.p643a.OperatorToObservableSortedList;
import p637j0.p642l.p647e.RxRingBuffer;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p637j0.p642l.p647e.UtilityFunctions;
import p658rx.Observable;

/* compiled from: lambda */
/* renamed from: b.a.z.a.a.h */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1398h implements Func1 {

    /* renamed from: j */
    public final /* synthetic */ List f2094j;

    /* renamed from: k */
    public final /* synthetic */ Map f2095k;

    /* renamed from: l */
    public final /* synthetic */ String f2096l;

    public /* synthetic */ C1398h(List list, Map map, String str) {
        this.f2094j = list;
        this.f2095k = map;
        this.f2096l = str;
    }

    @Override // p637j0.p641k.Func1
    public final Object call(Object obj) {
        List list = this.f2094j;
        Map map = this.f2095k;
        Observable observableM11074h0 = Observable.m11074h0(new OnSubscribeLift(Observable.m11058B(((Map) obj).values()).m11118y(new C1402l(list)).m11118y(new C1403m(map)).m11118y(new C1401k(this.f2096l)).f27640j, new OperatorToObservableSortedList(new C1396f(map), 10)));
        UtilityFunctions.a aVar = UtilityFunctions.a.INSTANCE;
        return (observableM11074h0 instanceof ScalarSynchronousObservable ? Observable.m11074h0(new OnSubscribeFlattenIterable2.b(((ScalarSynchronousObservable) observableM11074h0).f27288l, aVar)) : Observable.m11074h0(new OnSubscribeFlattenIterable2(observableM11074h0, aVar, RxRingBuffer.f27283j))).m11083G(new C1394d(map)).m11105f0();
    }
}

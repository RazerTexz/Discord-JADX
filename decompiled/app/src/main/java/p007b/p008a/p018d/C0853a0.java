package p007b.p008a.p018d;

import kotlin.jvm.functions.Function1;
import p658rx.Observable;

/* compiled from: AppTransformers.kt */
/* renamed from: b.a.d.a0 */
/* loaded from: classes.dex */
public final class C0853a0<T, R> implements Observable.InterfaceC13007c<T, R> {

    /* renamed from: j */
    public final /* synthetic */ Function1 f499j;

    /* renamed from: k */
    public final /* synthetic */ Function1 f500k;

    /* renamed from: l */
    public final /* synthetic */ Function1 f501l;

    public C0853a0(Function1 function1, Function1 function12, Function1 function13) {
        this.f499j = function1;
        this.f500k = function12;
        this.f501l = function13;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        return ((Observable) obj).m11099Y(new C0890z(this));
    }
}

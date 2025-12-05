package p007b.p008a.p018d;

import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action3;

/* compiled from: App.kt */
/* renamed from: b.a.d.a, reason: use source file name */
/* loaded from: classes.dex */
public final class App2 implements Action3 {

    /* renamed from: j */
    public final /* synthetic */ Function3 f498j;

    public App2(Function3 function3) {
        this.f498j = function3;
    }

    @Override // p658rx.functions.Action3
    public final /* synthetic */ void call(Object obj, Object obj2, Object obj3) {
        Intrinsics3.checkNotNullExpressionValue(this.f498j.invoke(obj, obj2, obj3), "invoke(...)");
    }
}

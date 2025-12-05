package p007b.p008a.p020e;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action1;

/* compiled from: Backgrounded.kt */
/* renamed from: b.a.e.c, reason: use source file name */
/* loaded from: classes.dex */
public final class Backgrounded3 implements Action1 {

    /* renamed from: j */
    public final /* synthetic */ Function1 f596j;

    public Backgrounded3(Function1 function1) {
        this.f596j = function1;
    }

    @Override // p658rx.functions.Action1
    public final /* synthetic */ void call(Object obj) {
        Intrinsics3.checkNotNullExpressionValue(this.f596j.invoke(obj), "invoke(...)");
    }
}

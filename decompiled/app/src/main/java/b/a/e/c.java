package b.a.e;

import d0.z.d.m;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;

/* compiled from: Backgrounded.kt */
/* loaded from: classes.dex */
public final class c implements Action1 {
    public final /* synthetic */ Function1 j;

    public c(Function1 function1) {
        this.j = function1;
    }

    @Override // rx.functions.Action1
    public final /* synthetic */ void call(Object obj) {
        m.checkNotNullExpressionValue(this.j.invoke(obj), "invoke(...)");
    }
}

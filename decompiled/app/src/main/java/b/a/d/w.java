package b.a.d;

import android.content.Context;
import com.discord.utilities.rx.ObservableExtensionsKt;
import kotlin.jvm.functions.Function0;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: AppTransformers.kt */
/* loaded from: classes.dex */
public final class w<T, R> implements Observable.c<T, T> {
    public final /* synthetic */ Context j;
    public final /* synthetic */ Class k;
    public final /* synthetic */ Action1 l;
    public final /* synthetic */ Action1 m;
    public final /* synthetic */ Action1 n;

    public w(Context context, Class cls, Action1 action1, Action1 action12, Action1 action13) {
        this.j = context;
        this.k = cls;
        this.l = action1;
        this.m = action12;
        this.n = action13;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Observable observable = (Observable) obj;
        d0.z.d.m.checkNotNullExpressionValue(observable, "observable");
        Context context = this.j;
        String simpleName = this.k.getSimpleName();
        d0.z.d.m.checkNotNullExpressionValue(simpleName, "errorClass.simpleName");
        Action1 action1 = this.l;
        c0 c0Var = action1 != null ? new c0(action1) : null;
        u uVar = new u(this.m);
        Action1 action12 = this.n;
        ObservableExtensionsKt.appSubscribe$default(observable, context, simpleName, c0Var, uVar, action12 != null ? new c0(action12) : null, v.j, (Function0) null, 64, (Object) null);
        return null;
    }
}

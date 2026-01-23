package p007b.p008a.p018d;

import android.content.Context;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.d.w */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0887w<T, R> implements Observable.InterfaceC13007c<T, T> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Context f582j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Class f583k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Action1 f584l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ Action1 f585m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ Action1 f586n;

    public C0887w(Context context, Class cls, Action1 action1, Action1 action12, Action1 action13) {
        this.f582j = context;
        this.f583k = cls;
        this.f584l = action1;
        this.f585m = action12;
        this.f586n = action13;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Observable observable = (Observable) obj;
        Intrinsics3.checkNotNullExpressionValue(observable, "observable");
        Context context = this.f582j;
        String simpleName = this.f583k.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "errorClass.simpleName");
        Action1 action1 = this.f584l;
        C0857c0 c0857c0 = action1 != null ? new C0857c0(action1) : null;
        C0885u c0885u = new C0885u(this.f585m);
        Action1 action12 = this.f586n;
        ObservableExtensionsKt.appSubscribe$default(observable, context, simpleName, c0857c0, c0885u, action12 != null ? new C0857c0(action12) : null, C0886v.f581j, (Function0) null, 64, (Object) null);
        return null;
    }
}

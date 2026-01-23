package p007b.p008a.p018d;

import android.content.Context;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;

/* JADX INFO: renamed from: b.a.d.y */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0889y<T, R> implements Observable.InterfaceC13007c<T, T> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Context f588j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f589k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Function1 f590l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ Function1 f591m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ Function1 f592n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ Function0 f593o;

    public C0889y(Context context, String str, Function1 function1, Function1 function12, Function1 function13, Function0 function0) {
        this.f588j = context;
        this.f589k = str;
        this.f590l = function1;
        this.f591m = function12;
        this.f592n = function13;
        this.f593o = function0;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Observable observable = (Observable) obj;
        Intrinsics3.checkNotNullExpressionValue(observable, "observable");
        Context context = this.f588j;
        String str = this.f589k;
        Function1 function1 = this.f590l;
        Function1 function12 = this.f591m;
        Function1 function13 = this.f592n;
        Function0 function0 = this.f593o;
        if (function0 == null) {
            function0 = C0888x.f587j;
        }
        ObservableExtensionsKt.appSubscribe$default(observable, context, str, function1, function12, function13, function0, (Function0) null, 64, (Object) null);
        return null;
    }
}

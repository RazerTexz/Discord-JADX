package androidx.core.view;

import android.view.View;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewKt$doOnLayout$$inlined$doOnNextLayout$1 implements View.OnLayoutChangeListener {
    public final /* synthetic */ Function1 $action$inlined;

    public ViewKt$doOnLayout$$inlined$doOnNextLayout$1(Function1 function1) {
        this.$action$inlined = function1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        Intrinsics3.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        this.$action$inlined.invoke(view);
    }
}

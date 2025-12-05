package androidx.fragment.app;

import android.view.View;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: View.kt */
/* loaded from: classes.dex */
public final class ViewKt {
    public static final <F extends Fragment> F findFragment(View view) {
        Intrinsics3.checkNotNullParameter(view, "$this$findFragment");
        F f = (F) FragmentManager.findFragment(view);
        Intrinsics3.checkNotNullExpressionValue(f, "FragmentManager.findFragment(this)");
        return f;
    }
}

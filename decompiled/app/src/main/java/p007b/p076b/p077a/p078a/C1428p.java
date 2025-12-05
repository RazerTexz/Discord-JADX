package p007b.p076b.p077a.p078a;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import kotlin.reflect.KProperty;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: FlexInputFragment.kt */
/* renamed from: b.b.a.a.p */
/* loaded from: classes3.dex */
public final class C1428p implements OnApplyWindowInsetsListener {

    /* renamed from: a */
    public final /* synthetic */ FlexInputFragment f2140a;

    public C1428p(FlexInputFragment flexInputFragment) {
        this.f2140a = flexInputFragment;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
        FlexInputFragment flexInputFragment = this.f2140a;
        KProperty[] kPropertyArr = FlexInputFragment.f22054j;
        ViewCompat.dispatchApplyWindowInsets(flexInputFragment.m9291j().f2178g, windowInsetsCompat);
        ViewCompat.dispatchApplyWindowInsets(this.f2140a.m9291j().f2182k, windowInsetsCompat);
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}

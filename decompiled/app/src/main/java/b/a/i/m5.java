package b.a.i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: WidgetHomePanelLoadingBinding.java */
/* loaded from: classes.dex */
public final class m5 implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f162b;

    public m5(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView) {
        this.a = frameLayout;
        this.f162b = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}

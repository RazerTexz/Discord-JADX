package p007b.p008a.p025i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: WidgetHomePanelLoadingBinding.java */
/* renamed from: b.a.i.m5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetHomePanelLoadingBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final FrameLayout f1063a;

    /* renamed from: b */
    @NonNull
    public final ImageView f1064b;

    public WidgetHomePanelLoadingBinding(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView) {
        this.f1063a = frameLayout;
        this.f1064b = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1063a;
    }
}

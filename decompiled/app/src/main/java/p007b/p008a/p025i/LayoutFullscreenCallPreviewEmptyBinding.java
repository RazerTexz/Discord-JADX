package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* compiled from: LayoutFullscreenCallPreviewEmptyBinding.java */
/* renamed from: b.a.i.q0, reason: use source file name */
/* loaded from: classes.dex */
public final class LayoutFullscreenCallPreviewEmptyBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f1142a;

    /* renamed from: b */
    @NonNull
    public final ConstraintLayout f1143b;

    public LayoutFullscreenCallPreviewEmptyBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f1142a = constraintLayout;
        this.f1143b = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1142a;
    }
}

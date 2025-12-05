package p007b.p008a.p036n.p037g;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: TrashWrapBinding.java */
/* renamed from: b.a.n.g.a, reason: use source file name */
/* loaded from: classes.dex */
public final class TrashWrapBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f1557a;

    /* renamed from: b */
    @NonNull
    public final ImageView f1558b;

    /* renamed from: c */
    @NonNull
    public final FrameLayout f1559c;

    /* renamed from: d */
    @NonNull
    public final FrameLayout f1560d;

    public TrashWrapBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2) {
        this.f1557a = view;
        this.f1558b = imageView;
        this.f1559c = frameLayout;
        this.f1560d = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1557a;
    }
}

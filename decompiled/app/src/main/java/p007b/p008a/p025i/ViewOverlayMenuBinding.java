package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: ViewOverlayMenuBinding.java */
/* renamed from: b.a.i.s2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewOverlayMenuBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f1206a;

    /* renamed from: b */
    @NonNull
    public final ViewOverlayMenuContentBinding f1207b;

    /* renamed from: c */
    @NonNull
    public final ImageView f1208c;

    /* renamed from: d */
    @NonNull
    public final ImageView f1209d;

    /* renamed from: e */
    @NonNull
    public final ImageView f1210e;

    public ViewOverlayMenuBinding(@NonNull View view, @NonNull ViewOverlayMenuContentBinding viewOverlayMenuContentBinding, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3) {
        this.f1206a = view;
        this.f1207b = viewOverlayMenuContentBinding;
        this.f1208c = imageView;
        this.f1209d = imageView2;
        this.f1210e = imageView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1206a;
    }
}

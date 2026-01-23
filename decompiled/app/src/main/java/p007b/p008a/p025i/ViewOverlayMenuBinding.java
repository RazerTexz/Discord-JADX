package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.s2, reason: use source file name */
/* JADX INFO: compiled from: ViewOverlayMenuBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOverlayMenuBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f1206a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ViewOverlayMenuContentBinding f1207b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f1208c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f1209d;

    /* JADX INFO: renamed from: e */
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

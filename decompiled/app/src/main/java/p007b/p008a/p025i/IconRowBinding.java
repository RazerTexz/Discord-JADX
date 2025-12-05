package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: IconRowBinding.java */
/* renamed from: b.a.i.a0, reason: use source file name */
/* loaded from: classes.dex */
public final class IconRowBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f658a;

    /* renamed from: b */
    @NonNull
    public final ImageView f659b;

    /* renamed from: c */
    @NonNull
    public final TextView f660c;

    public IconRowBinding(@NonNull View view, @NonNull View view2, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f658a = view;
        this.f659b = imageView;
        this.f660c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f658a;
    }
}

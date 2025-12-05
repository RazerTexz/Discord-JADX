package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: ShinyButtonBinding.java */
/* renamed from: b.a.i.n1, reason: use source file name */
/* loaded from: classes.dex */
public final class ShinyButtonBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f1070a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f1071b;

    /* renamed from: c */
    @NonNull
    public final ImageView f1072c;

    /* renamed from: d */
    @NonNull
    public final TextView f1073d;

    public ShinyButtonBinding(@NonNull View view, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f1070a = view;
        this.f1071b = linearLayout;
        this.f1072c = imageView;
        this.f1073d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1070a;
    }
}

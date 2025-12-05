package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: ViewStreamPreviewBinding.java */
/* renamed from: b.a.i.z3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewStreamPreviewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f1440a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f1441b;

    /* renamed from: c */
    @NonNull
    public final TextView f1442c;

    /* renamed from: d */
    @NonNull
    public final TextView f1443d;

    public ViewStreamPreviewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f1440a = constraintLayout;
        this.f1441b = simpleDraweeView;
        this.f1442c = textView;
        this.f1443d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1440a;
    }
}

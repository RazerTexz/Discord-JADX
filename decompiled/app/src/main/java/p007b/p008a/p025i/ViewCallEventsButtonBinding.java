package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* compiled from: ViewCallEventsButtonBinding.java */
/* renamed from: b.a.i.a2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewCallEventsButtonBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f663a;

    /* renamed from: b */
    @NonNull
    public final ImageView f664b;

    /* renamed from: c */
    @NonNull
    public final TextView f665c;

    public ViewCallEventsButtonBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f663a = constraintLayout;
        this.f664b = imageView;
        this.f665c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f663a;
    }
}

package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textview.MaterialTextView;

/* compiled from: BottomSheetSimpleSelectorItemBinding.java */
/* renamed from: b.a.i.d, reason: use source file name */
/* loaded from: classes.dex */
public final class BottomSheetSimpleSelectorItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f761a;

    /* renamed from: b */
    @NonNull
    public final MaterialTextView f762b;

    /* renamed from: c */
    @NonNull
    public final SimpleDraweeView f763c;

    /* renamed from: d */
    @NonNull
    public final MaterialTextView f764d;

    public BottomSheetSimpleSelectorItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialTextView materialTextView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialTextView materialTextView2) {
        this.f761a = constraintLayout;
        this.f762b = materialTextView;
        this.f763c = simpleDraweeView;
        this.f764d = materialTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f761a;
    }
}

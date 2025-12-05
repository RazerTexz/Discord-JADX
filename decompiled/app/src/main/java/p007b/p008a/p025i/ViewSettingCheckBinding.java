package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.checkbox.MaterialCheckBox;

/* compiled from: ViewSettingCheckBinding.java */
/* renamed from: b.a.i.p3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewSettingCheckBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f1134a;

    /* renamed from: b */
    @NonNull
    public final MaterialCheckBox f1135b;

    /* renamed from: c */
    @NonNull
    public final ConstraintLayout f1136c;

    public ViewSettingCheckBinding(@NonNull View view, @NonNull MaterialCheckBox materialCheckBox, @NonNull ConstraintLayout constraintLayout) {
        this.f1134a = view;
        this.f1135b = materialCheckBox;
        this.f1136c = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1134a;
    }
}

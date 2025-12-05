package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.radiobutton.MaterialRadioButton;

/* compiled from: ViewSettingRadioBinding.java */
/* renamed from: b.a.i.q3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewSettingRadioBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f1148a;

    /* renamed from: b */
    @NonNull
    public final MaterialRadioButton f1149b;

    /* renamed from: c */
    @NonNull
    public final ConstraintLayout f1150c;

    public ViewSettingRadioBinding(@NonNull View view, @NonNull MaterialRadioButton materialRadioButton, @NonNull ConstraintLayout constraintLayout) {
        this.f1148a = view;
        this.f1149b = materialRadioButton;
        this.f1150c = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1148a;
    }
}

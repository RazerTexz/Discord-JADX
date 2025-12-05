package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* compiled from: ViewSettingSwitchBinding.java */
/* renamed from: b.a.i.s3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewSettingSwitchBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f1211a;

    /* renamed from: b */
    @NonNull
    public final SwitchMaterial f1212b;

    /* renamed from: c */
    @NonNull
    public final ConstraintLayout f1213c;

    public ViewSettingSwitchBinding(@NonNull View view, @NonNull SwitchMaterial switchMaterial, @NonNull ConstraintLayout constraintLayout) {
        this.f1211a = view;
        this.f1212b = switchMaterial;
        this.f1213c = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1211a;
    }
}

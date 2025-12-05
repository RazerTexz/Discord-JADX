package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* compiled from: WidgetRemoteAuthPendingLoginBinding.java */
/* renamed from: b.a.i.w5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetRemoteAuthPendingLoginBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1358a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f1359b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f1360c;

    /* renamed from: d */
    @NonNull
    public final SwitchMaterial f1361d;

    public WidgetRemoteAuthPendingLoginBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull SwitchMaterial switchMaterial) {
        this.f1358a = linearLayout;
        this.f1359b = materialButton;
        this.f1360c = materialButton2;
        this.f1361d = switchMaterial;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1358a;
    }
}

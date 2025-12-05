package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: ViewPremiumSettingsTier2Binding.java */
/* renamed from: b.a.i.b3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewPremiumSettingsTier2Binding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f705a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f706b;

    public ViewPremiumSettingsTier2Binding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull MaterialButton materialButton) {
        this.f705a = linearLayout;
        this.f706b = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f705a;
    }
}

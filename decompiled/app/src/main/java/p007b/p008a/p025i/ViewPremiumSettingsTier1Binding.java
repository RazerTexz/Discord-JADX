package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: ViewPremiumSettingsTier1Binding.java */
/* renamed from: b.a.i.a3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewPremiumSettingsTier1Binding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f666a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f667b;

    /* renamed from: c */
    @NonNull
    public final TextView f668c;

    /* renamed from: d */
    @NonNull
    public final TextView f669d;

    public ViewPremiumSettingsTier1Binding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f666a = linearLayout;
        this.f667b = materialButton;
        this.f668c = textView;
        this.f669d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f666a;
    }
}

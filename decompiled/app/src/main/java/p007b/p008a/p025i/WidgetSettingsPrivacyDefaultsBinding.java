package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: WidgetSettingsPrivacyDefaultsBinding.java */
/* renamed from: b.a.i.b6, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetSettingsPrivacyDefaultsBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f719a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f720b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f721c;

    public WidgetSettingsPrivacyDefaultsBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2) {
        this.f719a = linearLayout;
        this.f720b = materialButton;
        this.f721c = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f719a;
    }
}

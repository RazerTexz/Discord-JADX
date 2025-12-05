package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: WidgetServerSettingsConfirmDisableIntegrationBinding.java */
/* renamed from: b.a.i.y5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetServerSettingsConfirmDisableIntegrationBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1427a;

    /* renamed from: b */
    @NonNull
    public final TextView f1428b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f1429c;

    /* renamed from: d */
    @NonNull
    public final MaterialButton f1430d;

    public WidgetServerSettingsConfirmDisableIntegrationBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView2) {
        this.f1427a = linearLayout;
        this.f1428b = textView;
        this.f1429c = materialButton;
        this.f1430d = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1427a;
    }
}

package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: AllowAccessibilityDetectionDialogBinding.java */
/* renamed from: b.a.i.a, reason: use source file name */
/* loaded from: classes.dex */
public final class AllowAccessibilityDetectionDialogBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f654a;

    /* renamed from: b */
    @NonNull
    public final TextView f655b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f656c;

    /* renamed from: d */
    @NonNull
    public final MaterialButton f657d;

    public AllowAccessibilityDetectionDialogBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView2) {
        this.f654a = linearLayout;
        this.f655b = textView;
        this.f656c = materialButton;
        this.f657d = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f654a;
    }
}

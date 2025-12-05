package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.premium.ShinyButton;
import com.google.android.material.button.MaterialButton;

/* compiled from: SingleValuePropPremiumUpsellDialogBinding.java */
/* renamed from: b.a.i.p1, reason: use source file name */
/* loaded from: classes.dex */
public final class SingleValuePropPremiumUpsellDialogBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1124a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f1125b;

    /* renamed from: c */
    @NonNull
    public final ShinyButton f1126c;

    /* renamed from: d */
    @NonNull
    public final TextView f1127d;

    /* renamed from: e */
    @NonNull
    public final TextView f1128e;

    /* renamed from: f */
    @NonNull
    public final ImageView f1129f;

    public SingleValuePropPremiumUpsellDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull MaterialButton materialButton, @NonNull View view, @NonNull ShinyButton shinyButton, @NonNull View view2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.f1124a = linearLayout;
        this.f1125b = materialButton;
        this.f1126c = shinyButton;
        this.f1127d = textView;
        this.f1128e = textView2;
        this.f1129f = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1124a;
    }
}

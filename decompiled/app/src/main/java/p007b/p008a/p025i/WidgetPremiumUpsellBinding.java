package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: WidgetPremiumUpsellBinding.java */
/* renamed from: b.a.i.u5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetPremiumUpsellBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1296a;

    /* renamed from: b */
    @NonNull
    public final TextView f1297b;

    /* renamed from: c */
    @NonNull
    public final TextView f1298c;

    /* renamed from: d */
    @NonNull
    public final ImageView f1299d;

    public WidgetPremiumUpsellBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.f1296a = linearLayout;
        this.f1297b = textView;
        this.f1298c = textView2;
        this.f1299d = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1296a;
    }
}

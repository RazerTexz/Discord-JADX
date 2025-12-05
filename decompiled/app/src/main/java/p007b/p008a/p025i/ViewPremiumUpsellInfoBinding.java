package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: ViewPremiumUpsellInfoBinding.java */
/* renamed from: b.a.i.c3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewPremiumUpsellInfoBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f742a;

    /* renamed from: b */
    @NonNull
    public final TextView f743b;

    /* renamed from: c */
    @NonNull
    public final TextView f744c;

    /* renamed from: d */
    @NonNull
    public final TextView f745d;

    public ViewPremiumUpsellInfoBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f742a = linearLayout;
        this.f743b = textView;
        this.f744c = textView2;
        this.f745d = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f742a;
    }
}

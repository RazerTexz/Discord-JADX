package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;

/* compiled from: GiftPurchasedDialogBinding.java */
/* renamed from: b.a.i.r, reason: use source file name */
/* loaded from: classes.dex */
public final class GiftPurchasedDialogBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f1165a;

    /* renamed from: b */
    @NonNull
    public final TextView f1166b;

    /* renamed from: c */
    @NonNull
    public final RelativeLayout f1167c;

    /* renamed from: d */
    @NonNull
    public final MaterialButton f1168d;

    /* renamed from: e */
    @NonNull
    public final LinkifiedTextView f1169e;

    /* renamed from: f */
    @NonNull
    public final MaterialButton f1170f;

    /* renamed from: g */
    @NonNull
    public final TextView f1171g;

    /* renamed from: h */
    @NonNull
    public final ImageView f1172h;

    public GiftPurchasedDialogBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout, @NonNull MaterialButton materialButton, @NonNull LinkifiedTextView linkifiedTextView, @NonNull MaterialButton materialButton2, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.f1165a = linearLayout;
        this.f1166b = textView;
        this.f1167c = relativeLayout;
        this.f1168d = materialButton;
        this.f1169e = linkifiedTextView;
        this.f1170f = materialButton2;
        this.f1171g = textView2;
        this.f1172h = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1165a;
    }
}

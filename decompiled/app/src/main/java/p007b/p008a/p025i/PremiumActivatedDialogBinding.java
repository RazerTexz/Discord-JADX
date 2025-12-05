package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: PremiumActivatedDialogBinding.java */
/* renamed from: b.a.i.d1, reason: use source file name */
/* loaded from: classes.dex */
public final class PremiumActivatedDialogBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f771a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f772b;

    /* renamed from: c */
    @NonNull
    public final TextView f773c;

    /* renamed from: d */
    @NonNull
    public final ImageView f774d;

    /* renamed from: e */
    @NonNull
    public final ImageView f775e;

    /* renamed from: f */
    @NonNull
    public final ImageView f776f;

    /* renamed from: g */
    @NonNull
    public final ImageView f777g;

    public PremiumActivatedDialogBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4) {
        this.f771a = linearLayout;
        this.f772b = materialButton;
        this.f773c = textView;
        this.f774d = imageView;
        this.f775e = imageView2;
        this.f776f = imageView3;
        this.f777g = imageView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f771a;
    }
}

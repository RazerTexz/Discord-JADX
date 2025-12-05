package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: WidgetChatInputMemberVerificationGuardBinding.java */
/* renamed from: b.a.i.v4, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetChatInputMemberVerificationGuardBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f1320a;

    /* renamed from: b */
    @NonNull
    public final CardView f1321b;

    /* renamed from: c */
    @NonNull
    public final ImageView f1322c;

    /* renamed from: d */
    @NonNull
    public final MaterialButton f1323d;

    /* renamed from: e */
    @NonNull
    public final ImageView f1324e;

    /* renamed from: f */
    @NonNull
    public final TextView f1325f;

    public WidgetChatInputMemberVerificationGuardBinding(@NonNull RelativeLayout relativeLayout, @NonNull CardView cardView, @NonNull ImageView imageView, @NonNull MaterialButton materialButton, @NonNull ImageView imageView2, @NonNull TextView textView) {
        this.f1320a = relativeLayout;
        this.f1321b = cardView;
        this.f1322c = imageView;
        this.f1323d = materialButton;
        this.f1324e = imageView2;
        this.f1325f = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1320a;
    }
}

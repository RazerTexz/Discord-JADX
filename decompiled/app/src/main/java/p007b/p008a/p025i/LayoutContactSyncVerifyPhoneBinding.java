package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CodeVerificationView;

/* compiled from: LayoutContactSyncVerifyPhoneBinding.java */
/* renamed from: b.a.i.p0, reason: use source file name */
/* loaded from: classes.dex */
public final class LayoutContactSyncVerifyPhoneBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f1122a;

    /* renamed from: b */
    @NonNull
    public final CodeVerificationView f1123b;

    public LayoutContactSyncVerifyPhoneBinding(@NonNull ConstraintLayout constraintLayout, @NonNull CodeVerificationView codeVerificationView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f1122a = constraintLayout;
        this.f1123b = codeVerificationView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1122a;
    }
}

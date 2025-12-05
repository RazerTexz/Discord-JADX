package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.google.android.material.button.MaterialButton;

/* compiled from: LayoutContactSyncAddPhoneBinding.java */
/* renamed from: b.a.i.j0, reason: use source file name */
/* loaded from: classes.dex */
public final class LayoutContactSyncAddPhoneBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f966a;

    /* renamed from: b */
    @NonNull
    public final PhoneOrEmailInputView f967b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f968c;

    public LayoutContactSyncAddPhoneBinding(@NonNull ConstraintLayout constraintLayout, @NonNull PhoneOrEmailInputView phoneOrEmailInputView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f966a = constraintLayout;
        this.f967b = phoneOrEmailInputView;
        this.f968c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f966a;
    }
}

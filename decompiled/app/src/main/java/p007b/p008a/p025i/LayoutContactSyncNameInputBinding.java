package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: LayoutContactSyncNameInputBinding.java */
/* renamed from: b.a.i.l0, reason: use source file name */
/* loaded from: classes.dex */
public final class LayoutContactSyncNameInputBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f1012a;

    /* renamed from: b */
    @NonNull
    public final TextInputEditText f1013b;

    /* renamed from: c */
    @NonNull
    public final TextInputLayout f1014c;

    /* renamed from: d */
    @NonNull
    public final LoadingButton f1015d;

    /* renamed from: e */
    @NonNull
    public final TextView f1016e;

    public LayoutContactSyncNameInputBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout, @NonNull LoadingButton loadingButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f1012a = constraintLayout;
        this.f1013b = textInputEditText;
        this.f1014c = textInputLayout;
        this.f1015d = loadingButton;
        this.f1016e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1012a;
    }
}

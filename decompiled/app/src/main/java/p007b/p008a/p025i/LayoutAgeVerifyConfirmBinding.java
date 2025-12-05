package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;

/* compiled from: LayoutAgeVerifyConfirmBinding.java */
/* renamed from: b.a.i.h0, reason: use source file name */
/* loaded from: classes.dex */
public final class LayoutAgeVerifyConfirmBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f895a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f896b;

    /* renamed from: c */
    @NonNull
    public final LoadingButton f897c;

    /* renamed from: d */
    @NonNull
    public final LinkifiedTextView f898d;

    /* renamed from: e */
    @NonNull
    public final TextView f899e;

    public LayoutAgeVerifyConfirmBinding(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull LoadingButton loadingButton, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView) {
        this.f895a = constraintLayout;
        this.f896b = materialButton;
        this.f897c = loadingButton;
        this.f898d = linkifiedTextView;
        this.f899e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f895a;
    }
}

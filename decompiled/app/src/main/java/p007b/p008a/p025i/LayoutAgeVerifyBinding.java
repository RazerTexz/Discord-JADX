package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: b.a.i.g0, reason: use source file name */
/* JADX INFO: compiled from: LayoutAgeVerifyBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutAgeVerifyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f857a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinkifiedTextView f858b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputLayout f859c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LoadingButton f860d;

    public LayoutAgeVerifyBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextInputLayout textInputLayout, @NonNull LoadingButton loadingButton, @NonNull TextView textView) {
        this.f857a = constraintLayout;
        this.f858b = linkifiedTextView;
        this.f859c = textInputLayout;
        this.f860d = loadingButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f857a;
    }
}

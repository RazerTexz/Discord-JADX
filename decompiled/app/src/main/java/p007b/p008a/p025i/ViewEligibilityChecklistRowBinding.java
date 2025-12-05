package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;

/* compiled from: ViewEligibilityChecklistRowBinding.java */
/* renamed from: b.a.i.h2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewEligibilityChecklistRowBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f901a;

    /* renamed from: b */
    @NonNull
    public final LinkifiedTextView f902b;

    /* renamed from: c */
    @NonNull
    public final ImageView f903c;

    /* renamed from: d */
    @NonNull
    public final TextView f904d;

    public ViewEligibilityChecklistRowBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinkifiedTextView linkifiedTextView, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f901a = constraintLayout;
        this.f902b = linkifiedTextView;
        this.f903c = imageView;
        this.f904d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f901a;
    }
}

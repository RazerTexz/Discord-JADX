package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* compiled from: ForumBrowserEmptyBinding.java */
/* renamed from: b.a.i.o, reason: use source file name */
/* loaded from: classes.dex */
public final class ForumBrowserEmptyBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f1092a;

    /* renamed from: b */
    @NonNull
    public final TextView f1093b;

    public ForumBrowserEmptyBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2) {
        this.f1092a = constraintLayout;
        this.f1093b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1092a;
    }
}

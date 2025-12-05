package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* compiled from: ViewVoiceCallActiveEventBinding.java */
/* renamed from: b.a.i.i4, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewVoiceCallActiveEventBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f957a;

    /* renamed from: b */
    @NonNull
    public final TextView f958b;

    /* renamed from: c */
    @NonNull
    public final TextView f959c;

    public ViewVoiceCallActiveEventBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2) {
        this.f957a = constraintLayout;
        this.f958b = textView;
        this.f959c = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f957a;
    }
}

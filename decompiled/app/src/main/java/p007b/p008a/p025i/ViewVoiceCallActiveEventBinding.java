package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.i4, reason: use source file name */
/* JADX INFO: compiled from: ViewVoiceCallActiveEventBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewVoiceCallActiveEventBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f957a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f958b;

    /* JADX INFO: renamed from: c */
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

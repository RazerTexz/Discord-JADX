package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;

/* compiled from: LayoutContactSyncLandingBinding.java */
/* renamed from: b.a.i.k0, reason: use source file name */
/* loaded from: classes.dex */
public final class LayoutContactSyncLandingBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f991a;

    /* renamed from: b */
    @NonNull
    public final TextView f992b;

    /* renamed from: c */
    @NonNull
    public final LoadingButton f993c;

    /* renamed from: d */
    @NonNull
    public final View f994d;

    /* renamed from: e */
    @NonNull
    public final LayoutContactSyncToggleInfoBinding f995e;

    public LayoutContactSyncLandingBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LoadingButton loadingButton, @NonNull View view, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LayoutContactSyncToggleInfoBinding layoutContactSyncToggleInfoBinding) {
        this.f991a = constraintLayout;
        this.f992b = textView;
        this.f993c = loadingButton;
        this.f994d = view;
        this.f995e = layoutContactSyncToggleInfoBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f991a;
    }
}

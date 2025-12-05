package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: PrivateChannelSideBarActionsViewBinding.java */
/* renamed from: b.a.i.g1, reason: use source file name */
/* loaded from: classes.dex */
public final class PrivateChannelSideBarActionsViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f861a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f862b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f863c;

    /* renamed from: d */
    @NonNull
    public final MaterialButton f864d;

    /* renamed from: e */
    @NonNull
    public final MaterialButton f865e;

    public PrivateChannelSideBarActionsViewBinding(@NonNull View view, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull MaterialButton materialButton3, @NonNull MaterialButton materialButton4) {
        this.f861a = view;
        this.f862b = materialButton;
        this.f863c = materialButton2;
        this.f864d = materialButton3;
        this.f865e = materialButton4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f861a;
    }
}

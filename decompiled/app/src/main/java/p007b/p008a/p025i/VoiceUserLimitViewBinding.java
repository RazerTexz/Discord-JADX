package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: VoiceUserLimitViewBinding.java */
/* renamed from: b.a.i.k4, reason: use source file name */
/* loaded from: classes.dex */
public final class VoiceUserLimitViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f1004a;

    /* renamed from: b */
    @NonNull
    public final TextView f1005b;

    /* renamed from: c */
    @NonNull
    public final TextView f1006c;

    public VoiceUserLimitViewBinding(@NonNull View view, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f1004a = view;
        this.f1005b = textView;
        this.f1006c = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1004a;
    }
}

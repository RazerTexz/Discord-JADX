package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: ConnectedAccountActionsDialogBinding.java */
/* renamed from: b.a.i.h, reason: use source file name */
/* loaded from: classes.dex */
public final class ConnectedAccountActionsDialogBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f891a;

    /* renamed from: b */
    @NonNull
    public final TextView f892b;

    /* renamed from: c */
    @NonNull
    public final TextView f893c;

    /* renamed from: d */
    @NonNull
    public final TextView f894d;

    public ConnectedAccountActionsDialogBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f891a = linearLayout;
        this.f892b = textView;
        this.f893c = textView2;
        this.f894d = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f891a;
    }
}

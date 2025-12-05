package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: CardSegmentViewBinding.java */
/* renamed from: b.a.i.f, reason: use source file name */
/* loaded from: classes.dex */
public final class CardSegmentViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f827a;

    /* renamed from: b */
    @NonNull
    public final TextView f828b;

    /* renamed from: c */
    @NonNull
    public final TextView f829c;

    public CardSegmentViewBinding(@NonNull View view, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f827a = view;
        this.f828b = textView;
        this.f829c = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f827a;
    }
}

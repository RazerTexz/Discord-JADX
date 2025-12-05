package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.chip.Chip;

/* compiled from: ViewGuildBoostConfirmationBinding.java */
/* renamed from: b.a.i.l2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewGuildBoostConfirmationBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f1019a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f1020b;

    /* renamed from: c */
    @NonNull
    public final TextView f1021c;

    /* renamed from: d */
    @NonNull
    public final Chip f1022d;

    /* renamed from: e */
    @NonNull
    public final Chip f1023e;

    /* renamed from: f */
    @NonNull
    public final ImageView f1024f;

    public ViewGuildBoostConfirmationBinding(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull Chip chip, @NonNull Chip chip2, @NonNull ImageView imageView) {
        this.f1019a = view;
        this.f1020b = simpleDraweeView;
        this.f1021c = textView;
        this.f1022d = chip;
        this.f1023e = chip2;
        this.f1024f = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1019a;
    }
}

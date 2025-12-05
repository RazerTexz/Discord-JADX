package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CutoutView;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: ViewPileItemBinding.java */
/* renamed from: b.a.i.v2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewPileItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CutoutView f1314a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f1315b;

    /* renamed from: c */
    @NonNull
    public final SimpleDraweeView f1316c;

    /* renamed from: d */
    @NonNull
    public final TextView f1317d;

    public ViewPileItemBinding(@NonNull CutoutView cutoutView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView) {
        this.f1314a = cutoutView;
        this.f1315b = simpleDraweeView;
        this.f1316c = simpleDraweeView2;
        this.f1317d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1314a;
    }
}

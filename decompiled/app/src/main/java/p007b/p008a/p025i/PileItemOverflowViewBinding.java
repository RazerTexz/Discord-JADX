package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CutoutView;

/* compiled from: PileItemOverflowViewBinding.java */
/* renamed from: b.a.i.c1, reason: use source file name */
/* loaded from: classes.dex */
public final class PileItemOverflowViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CutoutView f736a;

    /* renamed from: b */
    @NonNull
    public final TextView f737b;

    public PileItemOverflowViewBinding(@NonNull CutoutView cutoutView, @NonNull TextView textView) {
        this.f736a = cutoutView;
        this.f737b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f736a;
    }
}

package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CutoutView;

/* compiled from: PileItemOverflowViewBinding.java */
/* loaded from: classes.dex */
public final class c1 implements ViewBinding {

    @NonNull
    public final CutoutView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f90b;

    public c1(@NonNull CutoutView cutoutView, @NonNull TextView textView) {
        this.a = cutoutView;
        this.f90b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}

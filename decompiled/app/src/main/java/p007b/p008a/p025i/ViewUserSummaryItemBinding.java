package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.discord.views.CutoutView;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: ViewUserSummaryItemBinding.java */
/* renamed from: b.a.i.f4, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewUserSummaryItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CutoutView f845a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f846b;

    public ViewUserSummaryItemBinding(@NonNull CutoutView cutoutView, @NonNull SimpleDraweeView simpleDraweeView) {
        this.f845a = cutoutView;
        this.f846b = simpleDraweeView;
    }

    @NonNull
    /* renamed from: a */
    public static ViewUserSummaryItemBinding m199a(@NonNull View view) {
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.avatar);
        if (simpleDraweeView != null) {
            return new ViewUserSummaryItemBinding((CutoutView) view, simpleDraweeView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.avatar)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f845a;
    }
}

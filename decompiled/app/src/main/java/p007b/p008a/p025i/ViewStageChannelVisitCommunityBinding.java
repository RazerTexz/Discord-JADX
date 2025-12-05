package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: ViewStageChannelVisitCommunityBinding.java */
/* renamed from: b.a.i.x3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewStageChannelVisitCommunityBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f1377a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f1378b;

    /* renamed from: c */
    @NonNull
    public final TextView f1379c;

    public ViewStageChannelVisitCommunityBinding(@NonNull ConstraintLayout constraintLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f1377a = constraintLayout;
        this.f1378b = simpleDraweeView;
        this.f1379c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1377a;
    }
}

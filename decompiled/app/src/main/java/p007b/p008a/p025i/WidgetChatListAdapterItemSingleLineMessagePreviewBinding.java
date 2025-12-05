package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: WidgetChatListAdapterItemSingleLineMessagePreviewBinding.java */
/* renamed from: b.a.i.z4, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetChatListAdapterItemSingleLineMessagePreviewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f1444a;

    /* renamed from: b */
    @NonNull
    public final ImageView f1445b;

    /* renamed from: c */
    @NonNull
    public final LinkifiedTextView f1446c;

    /* renamed from: d */
    @NonNull
    public final SimpleDraweeView f1447d;

    /* renamed from: e */
    @NonNull
    public final TextView f1448e;

    public WidgetChatListAdapterItemSingleLineMessagePreviewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull Guideline guideline, @NonNull Guideline guideline2, @NonNull Guideline guideline3) {
        this.f1444a = constraintLayout;
        this.f1445b = imageView;
        this.f1446c = linkifiedTextView;
        this.f1447d = simpleDraweeView;
        this.f1448e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1444a;
    }
}

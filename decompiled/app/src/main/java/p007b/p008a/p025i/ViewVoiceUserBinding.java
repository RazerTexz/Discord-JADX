package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: ViewVoiceUserBinding.java */
/* renamed from: b.a.i.j4, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewVoiceUserBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f979a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f980b;

    /* renamed from: c */
    @NonNull
    public final TextView f981c;

    public ViewVoiceUserBinding(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView) {
        this.f979a = view;
        this.f980b = simpleDraweeView;
        this.f981c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f979a;
    }
}

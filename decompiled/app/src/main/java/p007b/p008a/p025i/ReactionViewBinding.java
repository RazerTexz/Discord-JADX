package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;

/* compiled from: ReactionViewBinding.java */
/* renamed from: b.a.i.i1, reason: use source file name */
/* loaded from: classes.dex */
public final class ReactionViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f941a;

    /* renamed from: b */
    @NonNull
    public final TextView f942b;

    /* renamed from: c */
    @NonNull
    public final TextView f943c;

    /* renamed from: d */
    @NonNull
    public final TextSwitcher f944d;

    /* renamed from: e */
    @NonNull
    public final SimpleDraweeSpanTextView f945e;

    public ReactionViewBinding(@NonNull View view, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextSwitcher textSwitcher, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView) {
        this.f941a = view;
        this.f942b = textView;
        this.f943c = textView2;
        this.f944d = textSwitcher;
        this.f945e = simpleDraweeSpanTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f941a;
    }
}

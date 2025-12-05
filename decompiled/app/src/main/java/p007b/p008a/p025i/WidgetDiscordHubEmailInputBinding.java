package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: WidgetDiscordHubEmailInputBinding.java */
/* renamed from: b.a.i.e5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetDiscordHubEmailInputBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final NestedScrollView f817a;

    /* renamed from: b */
    @NonNull
    public final LinkifiedTextView f818b;

    /* renamed from: c */
    @NonNull
    public final TextInputEditText f819c;

    /* renamed from: d */
    @NonNull
    public final TextInputLayout f820d;

    /* renamed from: e */
    @NonNull
    public final TextView f821e;

    /* renamed from: f */
    @NonNull
    public final TextView f822f;

    public WidgetDiscordHubEmailInputBinding(@NonNull NestedScrollView nestedScrollView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f817a = nestedScrollView;
        this.f818b = linkifiedTextView;
        this.f819c = textInputEditText;
        this.f820d = textInputLayout;
        this.f821e = textView;
        this.f822f = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f817a;
    }
}

package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;

/* compiled from: ViewSettingSharedBinding.java */
/* renamed from: b.a.i.r3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewSettingSharedBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f1181a;

    /* renamed from: b */
    @NonNull
    public final ImageView f1182b;

    /* renamed from: c */
    @NonNull
    public final TextView f1183c;

    /* renamed from: d */
    @NonNull
    public final LinkifiedTextView f1184d;

    /* renamed from: e */
    @NonNull
    public final TextView f1185e;

    public ViewSettingSharedBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView2) {
        this.f1181a = view;
        this.f1182b = imageView;
        this.f1183c = textView;
        this.f1184d = linkifiedTextView;
        this.f1185e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1181a;
    }
}

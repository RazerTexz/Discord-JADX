package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.google.android.material.button.MaterialButton;

/* compiled from: ThreadBrowserEmptyBinding.java */
/* renamed from: b.a.i.s1, reason: use source file name */
/* loaded from: classes.dex */
public final class ThreadBrowserEmptyBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f1202a;

    /* renamed from: b */
    @NonNull
    public final ConstraintLayout f1203b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f1204c;

    /* renamed from: d */
    @NonNull
    public final TextView f1205d;

    public ThreadBrowserEmptyBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.f1202a = constraintLayout;
        this.f1203b = constraintLayout2;
        this.f1204c = materialButton;
        this.f1205d = textView;
    }

    @NonNull
    /* renamed from: a */
    public static ThreadBrowserEmptyBinding m205a(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = C5419R.id.thread_browser_empty_create_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.thread_browser_empty_create_button);
        if (materialButton != null) {
            i = C5419R.id.thread_browser_empty_heading;
            TextView textView = (TextView) view.findViewById(C5419R.id.thread_browser_empty_heading);
            if (textView != null) {
                i = C5419R.id.thread_browser_empty_subheading;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.thread_browser_empty_subheading);
                if (textView2 != null) {
                    i = C5419R.id.thread_icon;
                    ImageView imageView = (ImageView) view.findViewById(C5419R.id.thread_icon);
                    if (imageView != null) {
                        return new ThreadBrowserEmptyBinding(constraintLayout, constraintLayout, materialButton, textView, textView2, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1202a;
    }
}

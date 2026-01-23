package com.discord.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import p007b.p008a.p025i.ViewUploadProgressBinding;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: UploadProgressView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UploadProgressView extends ConstraintLayout {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f19167j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final ViewUploadProgressBinding binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final Drawable drawableComplete;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Drawable drawableInProgress;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.view_upload_progress, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.progress_bar;
        ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(C5419R.id.progress_bar);
        if (progressBar != null) {
            i = C5419R.id.progress_file_image;
            ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.progress_file_image);
            if (imageView != null) {
                i = C5419R.id.progress_subtext;
                TextView textView = (TextView) viewInflate.findViewById(C5419R.id.progress_subtext);
                if (textView != null) {
                    i = C5419R.id.progress_text;
                    TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.progress_text);
                    if (textView2 != null) {
                        ViewUploadProgressBinding viewUploadProgressBinding = new ViewUploadProgressBinding((ConstraintLayout) viewInflate, progressBar, imageView, textView, textView2);
                        Intrinsics3.checkNotNullExpressionValue(viewUploadProgressBinding, "ViewUploadProgressBindin…rom(context), this, true)");
                        this.binding = viewUploadProgressBinding;
                        this.drawableComplete = ContextCompat.getDrawable(getContext(), C5419R.drawable.drawable_progress_green);
                        this.drawableInProgress = ContextCompat.getDrawable(getContext(), DrawableCompat.getThemedDrawableRes$default(this, C5419R.attr.progress_gradient, 0, 2, (Object) null));
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    /* JADX INFO: renamed from: a */
    public final void m8565a(CharSequence title, int progress, String subtitle) {
        Intrinsics3.checkNotNullParameter(title, "title");
        ViewUploadProgressBinding viewUploadProgressBinding = this.binding;
        TextView textView = viewUploadProgressBinding.f750e;
        Intrinsics3.checkNotNullExpressionValue(textView, "progressText");
        textView.setText(title);
        if (progress >= 0) {
            ProgressBar progressBar = viewUploadProgressBinding.f747b;
            Intrinsics3.checkNotNullExpressionValue(progressBar, "progressBar");
            progressBar.setIndeterminate(false);
            if (Build.VERSION.SDK_INT >= 24) {
                ProgressBar progressBar2 = viewUploadProgressBinding.f747b;
                Intrinsics3.checkNotNullExpressionValue(progressBar2, "progressBar");
                viewUploadProgressBinding.f747b.setProgress(progress, progress >= progressBar2.getProgress());
            } else {
                ProgressBar progressBar3 = viewUploadProgressBinding.f747b;
                Intrinsics3.checkNotNullExpressionValue(progressBar3, "progressBar");
                progressBar3.setProgress(progress);
            }
            ProgressBar progressBar4 = viewUploadProgressBinding.f747b;
            Intrinsics3.checkNotNullExpressionValue(progressBar4, "progressBar");
            progressBar4.setProgressDrawable(progress == 100 ? this.drawableComplete : this.drawableInProgress);
            ProgressBar progressBar5 = viewUploadProgressBinding.f747b;
            Intrinsics3.checkNotNullExpressionValue(progressBar5, "progressBar");
            progressBar5.setVisibility(0);
        } else if (progress == -1) {
            ProgressBar progressBar6 = viewUploadProgressBinding.f747b;
            Intrinsics3.checkNotNullExpressionValue(progressBar6, "progressBar");
            progressBar6.setVisibility(0);
            ProgressBar progressBar7 = viewUploadProgressBinding.f747b;
            Intrinsics3.checkNotNullExpressionValue(progressBar7, "progressBar");
            progressBar7.setIndeterminate(true);
        } else {
            if (progress != -2) {
                throw new IllegalArgumentException(outline.m871q("invalid argument supplied to progress: ", progress));
            }
            ProgressBar progressBar8 = viewUploadProgressBinding.f747b;
            Intrinsics3.checkNotNullExpressionValue(progressBar8, "progressBar");
            progressBar8.setVisibility(4);
        }
        TextView textView2 = viewUploadProgressBinding.f749d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "progressSubtext");
        ViewExtensions.setTextAndVisibilityBy(textView2, subtitle);
    }

    public final void setIcon(@DrawableRes int drawableResId) {
        this.binding.f748c.setImageResource(drawableResId);
    }
}

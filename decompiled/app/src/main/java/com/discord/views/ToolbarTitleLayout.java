package com.discord.views;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.extensions.ViewExtensions;
import p007b.p008a.p025i.ViewToolbarTitleBinding;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ToolbarTitleLayout.kt */
/* loaded from: classes2.dex */
public final class ToolbarTitleLayout extends ConstraintLayout {

    /* renamed from: j */
    public static final /* synthetic */ int f19165j = 0;

    /* renamed from: k, reason: from kotlin metadata */
    public final ViewToolbarTitleBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolbarTitleLayout(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(C5419R.layout.view_toolbar_title, this);
        int i = C5419R.id.toolbar_icon;
        ImageView imageView = (ImageView) findViewById(C5419R.id.toolbar_icon);
        if (imageView != null) {
            i = C5419R.id.toolbar_presence;
            StatusView statusView = (StatusView) findViewById(C5419R.id.toolbar_presence);
            if (statusView != null) {
                i = C5419R.id.toolbar_title;
                TextView textView = (TextView) findViewById(C5419R.id.toolbar_title);
                if (textView != null) {
                    i = C5419R.id.toolbar_title_subtext;
                    TextView textView2 = (TextView) findViewById(C5419R.id.toolbar_title_subtext);
                    if (textView2 != null) {
                        i = C5419R.id.toolbar_title_trailing_icon;
                        ImageView imageView2 = (ImageView) findViewById(C5419R.id.toolbar_title_trailing_icon);
                        if (imageView2 != null) {
                            ViewToolbarTitleBinding viewToolbarTitleBinding = new ViewToolbarTitleBinding(this, imageView, statusView, textView, textView2, imageView2);
                            Intrinsics3.checkNotNullExpressionValue(viewToolbarTitleBinding, "ViewToolbarTitleBinding.…ater.from(context), this)");
                            this.binding = viewToolbarTitleBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    /* renamed from: a */
    public final void m8564a(CharSequence title, @DrawableRes Integer leftDrawableRes, @DrawableRes Integer trailingDrawableRes) {
        TextView textView = this.binding.f710d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.toolbarTitle");
        textView.setText(title);
        if (leftDrawableRes != null) {
            ImageView imageView = this.binding.f708b;
            Resources resources = getResources();
            int iIntValue = leftDrawableRes.intValue();
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, iIntValue, context.getTheme()));
            ImageView imageView2 = this.binding.f708b;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.toolbarIcon");
            imageView2.setVisibility(0);
        } else {
            ImageView imageView3 = this.binding.f708b;
            Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.toolbarIcon");
            imageView3.setVisibility(8);
        }
        if (trailingDrawableRes == null) {
            ImageView imageView4 = this.binding.f712f;
            Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.toolbarTitleTrailingIcon");
            imageView4.setVisibility(8);
            return;
        }
        ImageView imageView5 = this.binding.f712f;
        Resources resources2 = getResources();
        int iIntValue2 = trailingDrawableRes.intValue();
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        imageView5.setImageDrawable(ResourcesCompat.getDrawable(resources2, iIntValue2, context2.getTheme()));
        ImageView imageView6 = this.binding.f712f;
        Intrinsics3.checkNotNullExpressionValue(imageView6, "binding.toolbarTitleTrailingIcon");
        imageView6.setVisibility(0);
    }

    public final TextView getTitle() {
        TextView textView = this.binding.f710d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.toolbarTitle");
        return textView;
    }

    public final void setSubtitle(CharSequence subtitle) {
        TextView textView = this.binding.f711e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.toolbarTitleSubtext");
        ViewExtensions.setTextAndVisibilityBy(textView, subtitle);
    }

    public final void setTitleColor(@ColorInt int color) {
        this.binding.f710d.setTextColor(color);
    }
}

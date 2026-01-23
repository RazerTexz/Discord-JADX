package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.utilities.view.extensions.ViewExtensions;
import p007b.p008a.p025i.ViewScreenTitleBinding;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ScreenTitleView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ScreenTitleView extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final ViewScreenTitleBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.view_screen_title, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.screen_title_subtitle;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.screen_title_subtitle);
        if (textView != null) {
            i = C5419R.id.screen_title_title;
            TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.screen_title_title);
            if (textView2 != null) {
                ViewScreenTitleBinding viewScreenTitleBinding = new ViewScreenTitleBinding((LinearLayout) viewInflate, textView, textView2);
                Intrinsics3.checkNotNullExpressionValue(viewScreenTitleBinding, "ViewScreenTitleBinding.i…rom(context), this, true)");
                this.binding = viewScreenTitleBinding;
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C5419R.a.ScreenTitleView, 0, 0);
                    Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.ScreenTitleView, 0, 0)");
                    CharSequence text = typedArrayObtainStyledAttributes.getText(1);
                    CharSequence text2 = typedArrayObtainStyledAttributes.getText(0);
                    typedArrayObtainStyledAttributes.recycle();
                    if (text != null) {
                        setTitle(text);
                    }
                    setSubtitle(text2);
                    return;
                }
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void setSubtitle(CharSequence subtitle) {
        TextView textView = this.binding.f811b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.screenTitleSubtitle");
        ViewExtensions.setTextAndVisibilityBy(textView, subtitle);
    }

    public final void setTitle(CharSequence title) {
        Intrinsics3.checkNotNullParameter(title, "title");
        TextView textView = this.binding.f812c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.screenTitleTitle");
        textView.setText(title);
    }
}

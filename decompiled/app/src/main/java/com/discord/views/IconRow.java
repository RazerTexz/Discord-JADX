package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import b.a.i.a0;
import b.a.k.b;
import com.discord.R;
import d0.z.d.m;

/* compiled from: IconRow.kt */
/* loaded from: classes2.dex */
public final class IconRow extends ConstraintLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final a0 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IconRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.icon_row, this);
        int i = R.id.divider;
        View viewFindViewById = findViewById(R.id.divider);
        if (viewFindViewById != null) {
            i = R.id.image;
            ImageView imageView = (ImageView) findViewById(R.id.image);
            if (imageView != null) {
                i = R.id.text;
                TextView textView = (TextView) findViewById(R.id.text);
                if (textView != null) {
                    a0 a0Var = new a0(this, viewFindViewById, imageView, textView);
                    m.checkNotNullExpressionValue(a0Var, "IconRowBinding.inflate(L…ater.from(context), this)");
                    this.binding = a0Var;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void setImageRes(@DrawableRes Integer imageRes) {
        if (imageRes != null) {
            this.binding.f73b.setImageResource(imageRes.intValue());
        }
        ImageView imageView = this.binding.f73b;
        m.checkNotNullExpressionValue(imageView, "binding.image");
        imageView.setVisibility(imageRes == null || imageRes.intValue() != 0 ? 0 : 8);
    }

    public final void setText(String text) {
        m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.text");
        b.a(textView, text);
    }
}

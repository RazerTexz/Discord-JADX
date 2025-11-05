package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import b.a.i.v0;
import com.discord.R;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* compiled from: MemberVerificationAvatarView.kt */
/* loaded from: classes2.dex */
public final class MemberVerificationAvatarView extends FrameLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final v0 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.member_verification_avatar_view, this);
        int i = R.id.member_verification_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.member_verification_avatar);
        if (simpleDraweeView != null) {
            i = R.id.member_verification_text;
            TextView textView = (TextView) findViewById(R.id.member_verification_text);
            if (textView != null) {
                v0 v0Var = new v0(this, simpleDraweeView, textView);
                m.checkNotNullExpressionValue(v0Var, "MemberVerificationAvatar…ater.from(context), this)");
                this.binding = v0Var;
                setClipToOutline(true);
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }
}

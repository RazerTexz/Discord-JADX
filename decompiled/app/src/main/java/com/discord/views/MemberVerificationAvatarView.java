package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.facebook.drawee.view.SimpleDraweeView;
import p007b.p008a.p025i.MemberVerificationAvatarViewBinding;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: MemberVerificationAvatarView.kt */
/* loaded from: classes2.dex */
public final class MemberVerificationAvatarView extends FrameLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final MemberVerificationAvatarViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.member_verification_avatar_view, this);
        int i = C5419R.id.member_verification_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(C5419R.id.member_verification_avatar);
        if (simpleDraweeView != null) {
            i = C5419R.id.member_verification_text;
            TextView textView = (TextView) findViewById(C5419R.id.member_verification_text);
            if (textView != null) {
                MemberVerificationAvatarViewBinding memberVerificationAvatarViewBinding = new MemberVerificationAvatarViewBinding(this, simpleDraweeView, textView);
                Intrinsics3.checkNotNullExpressionValue(memberVerificationAvatarViewBinding, "MemberVerificationAvatar…ater.from(context), this)");
                this.binding = memberVerificationAvatarViewBinding;
                setClipToOutline(true);
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }
}

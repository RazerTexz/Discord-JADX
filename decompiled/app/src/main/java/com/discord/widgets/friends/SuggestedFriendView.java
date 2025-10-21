package com.discord.widgets.friends;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.SuggestedFriendViewBinding;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SuggestedFriendView.kt */
/* loaded from: classes2.dex */
public final class SuggestedFriendView extends ConstraintLayout {
    private final SuggestedFriendViewBinding binding;

    /* compiled from: SuggestedFriendView.kt */
    /* renamed from: com.discord.widgets.friends.SuggestedFriendView$setOnDeclineClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onDeclineClicked;

        public AnonymousClass1(Function0 function0) {
            this.$onDeclineClicked = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onDeclineClicked.invoke();
        }
    }

    /* compiled from: SuggestedFriendView.kt */
    /* renamed from: com.discord.widgets.friends.SuggestedFriendView$setOnSendClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onSendClicked;

        public AnonymousClass1(Function0 function0) {
            this.$onSendClicked = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onSendClicked.invoke();
        }
    }

    public SuggestedFriendView(Context context) {
        this(context, null, 0, 6, null);
    }

    public SuggestedFriendView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ SuggestedFriendView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setAvatarUrl(long userId, Integer discriminator, String avatarUrl) {
        Long lValueOf = Long.valueOf(userId);
        SimpleDraweeView simpleDraweeView = this.binding.f2156b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.suggestedFriendAvatar");
        String forUser = IconUtils.getForUser(lValueOf, avatarUrl, discriminator, false, Integer.valueOf(simpleDraweeView.getHeight()));
        SimpleDraweeView simpleDraweeView2 = this.binding.f2156b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.suggestedFriendAvatar");
        IconUtils.setIcon$default(simpleDraweeView2, forUser, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
    }

    public final void setOnDeclineClicked(Function0<Unit> onDeclineClicked) {
        Intrinsics3.checkNotNullParameter(onDeclineClicked, "onDeclineClicked");
        this.binding.c.setOnClickListener(new AnonymousClass1(onDeclineClicked));
    }

    public final void setOnSendClicked(Function0<Unit> onSendClicked) {
        Intrinsics3.checkNotNullParameter(onSendClicked, "onSendClicked");
        this.binding.e.setOnClickListener(new AnonymousClass1(onSendClicked));
    }

    public final void setPublicName(String publicName) {
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.suggestedFriendPublicName");
        textView.setText(publicName);
    }

    public final void setUsername(String username) {
        Intrinsics3.checkNotNullParameter(username, "username");
        TextView textView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.suggestedFriendUsername");
        textView.setText(username);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuggestedFriendView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.suggested_friend_view, this);
        int i2 = R.id.suggested_friend_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.suggested_friend_avatar);
        if (simpleDraweeView != null) {
            i2 = R.id.suggested_friend_decline;
            AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById(R.id.suggested_friend_decline);
            if (appCompatImageView != null) {
                i2 = R.id.suggested_friend_public_name;
                TextView textView = (TextView) findViewById(R.id.suggested_friend_public_name);
                if (textView != null) {
                    i2 = R.id.suggested_friend_send_request;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) findViewById(R.id.suggested_friend_send_request);
                    if (appCompatImageView2 != null) {
                        i2 = R.id.suggested_friend_username;
                        TextView textView2 = (TextView) findViewById(R.id.suggested_friend_username);
                        if (textView2 != null) {
                            SuggestedFriendViewBinding suggestedFriendViewBinding = new SuggestedFriendViewBinding(this, simpleDraweeView, appCompatImageView, textView, appCompatImageView2, textView2);
                            Intrinsics3.checkNotNullExpressionValue(suggestedFriendViewBinding, "SuggestedFriendViewBindi…ater.from(context), this)");
                            this.binding = suggestedFriendViewBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}

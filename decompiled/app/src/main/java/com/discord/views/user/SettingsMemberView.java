package com.discord.views.user;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.views.UsernameView;
import com.discord.widgets.user.profile.DraweeSpanStringBuilderExtensions;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;
import com.facebook.drawee.view.SimpleDraweeView;
import p007b.p008a.p025i.SettingsMemberViewBinding;
import p007b.p109f.p132g.p143f.RoundingParams;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: SettingsMemberView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsMemberView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final SettingsMemberViewBinding binding;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public int avatarBackgroundColor;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public User user;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public GuildMember guildMember;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsMemberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.settings_member_view, this);
        int i = C5419R.id.large_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(C5419R.id.large_avatar);
        if (simpleDraweeView != null) {
            i = C5419R.id.member_subtitle;
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) findViewById(C5419R.id.member_subtitle);
            if (simpleDraweeSpanTextView != null) {
                i = C5419R.id.member_title;
                UsernameView usernameView = (UsernameView) findViewById(C5419R.id.member_title);
                if (usernameView != null) {
                    SettingsMemberViewBinding settingsMemberViewBinding = new SettingsMemberViewBinding(this, simpleDraweeView, simpleDraweeSpanTextView, usernameView);
                    Intrinsics3.checkNotNullExpressionValue(settingsMemberViewBinding, "SettingsMemberViewBindin…ater.from(context), this)");
                    this.binding = settingsMemberViewBinding;
                    this.avatarBackgroundColor = ColorCompat.getThemedColor(this, C5419R.attr.colorBackgroundPrimary);
                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C5419R.a.SettingsMemberView);
                    Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…eable.SettingsMemberView)");
                    this.avatarBackgroundColor = typedArrayObtainStyledAttributes.getColor(0, ColorCompat.getThemedColor(this, C5419R.attr.colorBackgroundPrimary));
                    typedArrayObtainStyledAttributes.recycle();
                    setAvatarBackgroundColor(this.avatarBackgroundColor);
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    /* JADX INFO: renamed from: a */
    public final void m8621a(User user, GuildMember guildMember) {
        Intrinsics3.checkNotNullParameter(user, "user");
        this.user = user;
        this.guildMember = guildMember;
        String nick = guildMember != null ? guildMember.getNick() : null;
        boolean z2 = true;
        boolean z3 = !(nick == null || StringsJVM.isBlank(nick));
        SimpleDraweeView simpleDraweeView = this.binding.f1044b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.largeAvatar");
        IconUtils.setIcon$default(simpleDraweeView, user, C5419R.dimen.avatar_size_large, null, null, guildMember, 24, null);
        UsernameView usernameView = this.binding.f1046d;
        if (nick == null) {
            nick = user.getUsername();
        }
        UsernameView.m8566c(usernameView, nick, null, false, null, null, 30);
        UsernameView usernameView2 = this.binding.f1046d;
        boolean isBot = user.getIsBot();
        int i = user.getIsSystemUser() ? C5419R.string.system_dm_tag_system : C5419R.string.bot_tag;
        UserUtils userUtils = UserUtils.INSTANCE;
        usernameView2.m8567a(isBot, i, userUtils.isVerifiedBot(user));
        boolean z4 = guildMember != null && guildMember.hasAvatar();
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        if (z4) {
            int dimension = (int) getResources().getDimension(C5419R.dimen.avatar_size_profile_small);
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            DraweeSpanStringBuilderExtensions.setAvatar$default(draweeSpanStringBuilder, context, IconUtils.getForUser$default(user, false, Integer.valueOf(dimension), 2, null), false, Integer.valueOf(dimension), Integer.valueOf(this.avatarBackgroundColor), (char) 8194, 4, null);
        }
        draweeSpanStringBuilder.append(UserUtils.getUserNameWithDiscriminator$default(userUtils, user, null, null, 3, null));
        this.binding.f1045c.setDraweeSpanStringBuilder(draweeSpanStringBuilder);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f1045c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.memberSubtitle");
        if (!z4 && !z3) {
            z2 = false;
        }
        simpleDraweeSpanTextView.setVisibility(z2 ? 0 : 8);
    }

    public final void setAvatarBackgroundColor(@ColorInt int backgroundColor) {
        GuildMember guildMember;
        this.avatarBackgroundColor = backgroundColor;
        Intrinsics3.checkNotNullExpressionValue(this.binding.f1044b, "binding.largeAvatar");
        RoundingParams roundingParamsM1124a = RoundingParams.m1124a(r0.getWidth() / 2);
        Intrinsics3.checkNotNullExpressionValue(roundingParamsM1124a, "roundingParams");
        roundingParamsM1124a.f3472b = true;
        roundingParamsM1124a.f3474d = backgroundColor;
        roundingParamsM1124a.f3471a = 1;
        SimpleDraweeView simpleDraweeView = this.binding.f1044b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.largeAvatar");
        GenericDraweeHierarchy hierarchy = simpleDraweeView.getHierarchy();
        Intrinsics3.checkNotNullExpressionValue(hierarchy, "binding.largeAvatar.hierarchy");
        hierarchy.m8683s(roundingParamsM1124a);
        User user = this.user;
        if (user == null || (guildMember = this.guildMember) == null) {
            return;
        }
        m8621a(user, guildMember);
    }
}

package com.discord.views.guilds;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.utilities.resources.StringResourceUtils;
import p007b.p008a.p025i.ViewServerMemberCountBinding;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ServerMemberCount.kt */
/* loaded from: classes2.dex */
public final class ServerMemberCount extends FrameLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewServerMemberCountBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerMemberCount(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.view_server_member_count, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.item_invite_online_dot;
        ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.item_invite_online_dot);
        if (imageView != null) {
            i = C5419R.id.item_invite_online_text;
            TextView textView = (TextView) viewInflate.findViewById(C5419R.id.item_invite_online_text);
            if (textView != null) {
                i = C5419R.id.item_invite_total_member_dot;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(C5419R.id.item_invite_total_member_dot);
                if (imageView2 != null) {
                    i = C5419R.id.item_invite_total_member_text;
                    TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.item_invite_total_member_text);
                    if (textView2 != null) {
                        ViewServerMemberCountBinding viewServerMemberCountBinding = new ViewServerMemberCountBinding((LinearLayout) viewInflate, imageView, textView, imageView2, textView2);
                        Intrinsics3.checkNotNullExpressionValue(viewServerMemberCountBinding, "ViewServerMemberCountBin…rom(context), this, true)");
                        this.binding = viewServerMemberCountBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void setInvalidText(CharSequence charSequence) {
        ImageView imageView = this.binding.f953b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.itemInviteOnlineDot");
        imageView.setVisibility(8);
        ImageView imageView2 = this.binding.f955d;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.itemInviteTotalMemberDot");
        imageView2.setVisibility(8);
        TextView textView = this.binding.f954c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemInviteOnlineText");
        FormatUtils.m209a(textView, charSequence);
        TextView textView2 = this.binding.f956e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemInviteTotalMemberText");
        FormatUtils.m209a(textView2, null);
    }

    public final void setMembers(Integer members) {
        CharSequence i18nPluralString;
        ImageView imageView = this.binding.f955d;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.itemInviteTotalMemberDot");
        imageView.setVisibility(members != null ? 0 : 8);
        TextView textView = this.binding.f956e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemInviteTotalMemberText");
        if (members != null) {
            members.intValue();
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            i18nPluralString = StringResourceUtils.getI18nPluralString(context, C5419R.plurals.members_header_members, members.intValue(), members);
        } else {
            i18nPluralString = null;
        }
        FormatUtils.m209a(textView, i18nPluralString);
    }

    public final void setOnline(Integer active) {
        ImageView imageView = this.binding.f953b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.itemInviteOnlineDot");
        imageView.setVisibility(active != null ? 0 : 8);
        TextView textView = this.binding.f954c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemInviteOnlineText");
        CharSequence charSequenceM218j = null;
        if (active != null) {
            active.intValue();
            charSequenceM218j = FormatUtils.m218j(this, C5419R.string.instant_invite_guild_members_online, new Object[]{active}, null, 4);
        }
        FormatUtils.m209a(textView, charSequenceM218j);
    }
}

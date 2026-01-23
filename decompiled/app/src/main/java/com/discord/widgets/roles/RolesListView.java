package com.discord.widgets.roles;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.discord.C5419R;
import com.discord.api.role.GuildRole;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.guilds.RoleUtils;
import com.google.android.material.chip.ChipGroup;
import java.util.List;
import p007b.p008a.p025i.GuildRoleChipBinding;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: RolesListView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RolesListView extends ChipGroup {
    private List<GuildRole> roles;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RolesListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        this.roles = Collections2.emptyList();
        int iDpToPixels = DimenUtils.dpToPixels(4);
        setChipSpacingVertical(iDpToPixels);
        setChipSpacingHorizontal(iDpToPixels);
    }

    public final List<GuildRole> getRoles() {
        return this.roles;
    }

    public final void setRoles(List<GuildRole> list) {
        Intrinsics3.checkNotNullParameter(list, "<set-?>");
        this.roles = list;
    }

    public final void updateView(List<GuildRole> roles, int roleDefaultColor, long guildId) {
        Intrinsics3.checkNotNullParameter(roles, "roles");
        if (Intrinsics3.areEqual(roles, this.roles)) {
            return;
        }
        boolean isDeveloperMode = StoreStream.INSTANCE.getUserSettings().getIsDeveloperMode();
        this.roles = roles;
        removeAllViews();
        for (GuildRole guildRole : roles) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.guild_role_chip, (ViewGroup) null, false);
            int i = C5419R.id.role_chip_dot;
            ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.role_chip_dot);
            if (imageView != null) {
                i = C5419R.id.role_chip_icon;
                RoleIconView roleIconView = (RoleIconView) viewInflate.findViewById(C5419R.id.role_chip_icon);
                if (roleIconView != null) {
                    i = C5419R.id.role_chip_text;
                    TextView textView = (TextView) viewInflate.findViewById(C5419R.id.role_chip_text);
                    if (textView != null) {
                        CardView cardView = (CardView) viewInflate;
                        Intrinsics3.checkNotNullExpressionValue(new GuildRoleChipBinding(cardView, imageView, roleIconView, textView), "GuildRoleChipBinding.inf…om(context), null, false)");
                        Intrinsics3.checkNotNullExpressionValue(textView, "binding.roleChipText");
                        textView.setText(guildRole.getName());
                        int opaqueColor = RoleUtils.isDefaultColor(guildRole) ? roleDefaultColor : RoleUtils.getOpaqueColor(guildRole);
                        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.roleChipDot");
                        ColorCompat2.tintWithColor(imageView, opaqueColor);
                        roleIconView.setRole(guildRole, Long.valueOf(guildId));
                        if (isDeveloperMode) {
                            cardView.setOnClickListener(new RolesListView2(guildRole, this, roleDefaultColor, guildId, isDeveloperMode));
                        }
                        addView(cardView);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
    }
}

package com.discord.widgets.guild_role_subscriptions.tier.create;

import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;

/* compiled from: GuildRoleSubscriptionTierViewModel.kt */
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionTierViewModel extends d0<ViewState> {

    /* compiled from: GuildRoleSubscriptionTierViewModel.kt */
    public static final /* data */ class ViewState {
        private final GuildRoleSubscriptionTier guildRoleSubscriptionTier;
        private final Boolean isFullServerGating;

        public ViewState() {
            this(null, null, 3, null);
        }

        public ViewState(GuildRoleSubscriptionTier guildRoleSubscriptionTier, Boolean bool) {
            m.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
            this.guildRoleSubscriptionTier = guildRoleSubscriptionTier;
            this.isFullServerGating = bool;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, GuildRoleSubscriptionTier guildRoleSubscriptionTier, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRoleSubscriptionTier = viewState.guildRoleSubscriptionTier;
            }
            if ((i & 2) != 0) {
                bool = viewState.isFullServerGating;
            }
            return viewState.copy(guildRoleSubscriptionTier, bool);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
            return this.guildRoleSubscriptionTier;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getIsFullServerGating() {
            return this.isFullServerGating;
        }

        public final ViewState copy(GuildRoleSubscriptionTier guildRoleSubscriptionTier, Boolean isFullServerGating) {
            m.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
            return new ViewState(guildRoleSubscriptionTier, isFullServerGating);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return m.areEqual(this.guildRoleSubscriptionTier, viewState.guildRoleSubscriptionTier) && m.areEqual(this.isFullServerGating, viewState.isFullServerGating);
        }

        public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
            return this.guildRoleSubscriptionTier;
        }

        public int hashCode() {
            GuildRoleSubscriptionTier guildRoleSubscriptionTier = this.guildRoleSubscriptionTier;
            int iHashCode = (guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.hashCode() : 0) * 31;
            Boolean bool = this.isFullServerGating;
            return iHashCode + (bool != null ? bool.hashCode() : 0);
        }

        public final Boolean isFullServerGating() {
            return this.isFullServerGating;
        }

        public String toString() {
            StringBuilder sbU = a.U("ViewState(guildRoleSubscriptionTier=");
            sbU.append(this.guildRoleSubscriptionTier);
            sbU.append(", isFullServerGating=");
            return a.D(sbU, this.isFullServerGating, ")");
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
            	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
            	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
            	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
            */
        public /* synthetic */ ViewState(com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier r20, java.lang.Boolean r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
            /*
                r19 = this;
                r0 = r22 & 1
                if (r0 == 0) goto L1f
                com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier r0 = new com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier
                r1 = r0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 32767(0x7fff, float:4.5916E-41)
                r18 = 0
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
                goto L21
            L1f:
                r0 = r20
            L21:
                r1 = r22 & 2
                if (r1 == 0) goto L29
                r1 = 0
                r2 = r19
                goto L2d
            L29:
                r2 = r19
                r1 = r21
            L2d:
                r2.<init>(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel.ViewState.<init>(com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    public GuildRoleSubscriptionTierViewModel() {
        super(new ViewState(null, null, 3, null));
    }

    private final void addChannelBenefit(Benefit.ChannelBenefit channelBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, null, u.plus((Collection<? extends Benefit.ChannelBenefit>) guildRoleSubscriptionTier.getChannelBenefits(), channelBenefit), null, null, null, 30719, null), null, 2, null));
    }

    private final void addIntangibleBenefit(Benefit.IntangibleBenefit intangibleBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, null, null, u.plus((Collection<? extends Benefit.IntangibleBenefit>) guildRoleSubscriptionTier.getIntangibleBenefits(), intangibleBenefit), null, null, 28671, null), null, 2, null));
    }

    private final void removeChannelBenefit(Benefit.ChannelBenefit channelBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, null, u.minus(guildRoleSubscriptionTier.getChannelBenefits(), channelBenefit), null, null, null, 30719, null), null, 2, null));
    }

    private final void removeIntangibleBenefit(Benefit.IntangibleBenefit intangibleBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, null, null, u.minus(guildRoleSubscriptionTier.getIntangibleBenefits(), intangibleBenefit), null, null, 28671, null), null, 2, null));
    }

    private final void replaceChannelBenefit(Benefit.ChannelBenefit existingChannelBenefit, Benefit.ChannelBenefit newChannelBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        List mutableList = u.toMutableList((Collection) guildRoleSubscriptionTier.getChannelBenefits());
        int iIndexOf = mutableList.indexOf(existingChannelBenefit);
        if (iIndexOf != -1) {
            mutableList.set(iIndexOf, newChannelBenefit);
            updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, null, mutableList, null, null, null, 30719, null), null, 2, null));
        }
    }

    private final void replaceIntangibleBenefit(Benefit.IntangibleBenefit existingIntangibleBenefit, Benefit.IntangibleBenefit newIntangibleBenefit) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        List mutableList = u.toMutableList((Collection) guildRoleSubscriptionTier.getIntangibleBenefits());
        int iIndexOf = mutableList.indexOf(existingIntangibleBenefit);
        if (iIndexOf != -1) {
            mutableList.set(iIndexOf, newIntangibleBenefit);
            updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, null, null, mutableList, null, null, 28671, null), null, 2, null));
        }
    }

    public static /* synthetic */ void updateFreeTrialInterval$default(GuildRoleSubscriptionTierViewModel guildRoleSubscriptionTierViewModel, SubscriptionTrialInterval subscriptionTrialInterval, int i, Object obj) {
        if ((i & 1) != 0) {
            subscriptionTrialInterval = null;
        }
        guildRoleSubscriptionTierViewModel.updateFreeTrialInterval(subscriptionTrialInterval);
    }

    public static /* synthetic */ void updateFreeTrialLimit$default(GuildRoleSubscriptionTierViewModel guildRoleSubscriptionTierViewModel, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        guildRoleSubscriptionTierViewModel.updateFreeTrialLimit(num);
    }

    public static /* synthetic */ void updateImage$default(GuildRoleSubscriptionTierViewModel guildRoleSubscriptionTierViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        guildRoleSubscriptionTierViewModel.updateImage(str);
    }

    public static /* synthetic */ void updateMemberIcon$default(GuildRoleSubscriptionTierViewModel guildRoleSubscriptionTierViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        guildRoleSubscriptionTierViewModel.updateMemberIcon(str);
    }

    public final void setCanAccessAllChannels(boolean canAccessAllChannels) {
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, null, null, null, null, null, null, null, null, Boolean.valueOf(canAccessAllChannels), null, null, null, null, 31743, null), null, 2, null));
    }

    public final void setDefaultMemberColor(int defaultMemberColor) {
        if (requireViewState().getGuildRoleSubscriptionTier().getMemberColor() == null) {
            updateMemberColor(Integer.valueOf(defaultMemberColor));
        }
    }

    public final void setFullServerGating(boolean isFullServerGating) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        updateViewState(requireViewState().copy(GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, null, null, null, null, Boolean.valueOf(guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(Boolean.valueOf(isFullServerGating))), null, null, null, null, 31743, null), Boolean.valueOf(isFullServerGating)));
    }

    public final void setTier(GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
        m.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        updateViewState(ViewState.copy$default(requireViewState(), guildRoleSubscriptionTier, null, 2, null));
    }

    public final void updateBenefit(Benefit existingBenefit, Benefit newBenefit) {
        boolean z2 = existingBenefit instanceof Benefit.ChannelBenefit;
        if (z2 || (newBenefit instanceof Benefit.ChannelBenefit)) {
            if (!z2) {
                existingBenefit = null;
            }
            Benefit.ChannelBenefit channelBenefit = (Benefit.ChannelBenefit) existingBenefit;
            if (!(newBenefit instanceof Benefit.ChannelBenefit)) {
                newBenefit = null;
            }
            updateChannelBenefit(channelBenefit, (Benefit.ChannelBenefit) newBenefit);
            return;
        }
        if (!(existingBenefit instanceof Benefit.IntangibleBenefit)) {
            existingBenefit = null;
        }
        Benefit.IntangibleBenefit intangibleBenefit = (Benefit.IntangibleBenefit) existingBenefit;
        if (!(newBenefit instanceof Benefit.IntangibleBenefit)) {
            newBenefit = null;
        }
        updateIntangibleBenefit(intangibleBenefit, (Benefit.IntangibleBenefit) newBenefit);
    }

    public final void updateChannelBenefit(Benefit.ChannelBenefit existingChannelBenefit, Benefit.ChannelBenefit newChannelBenefit) {
        if (existingChannelBenefit == null && newChannelBenefit != null) {
            addChannelBenefit(newChannelBenefit);
            return;
        }
        if (existingChannelBenefit != null && newChannelBenefit == null) {
            removeChannelBenefit(existingChannelBenefit);
        } else {
            if (existingChannelBenefit == null || newChannelBenefit == null) {
                return;
            }
            replaceChannelBenefit(existingChannelBenefit, newChannelBenefit);
        }
    }

    public final void updateDescription(String description) {
        m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, null, null, null, null, null, null, description, null, null, null, null, null, null, 32511, null), null, 2, null));
    }

    public final void updateFreeTrialInterval(SubscriptionTrialInterval trialInterval) {
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, null, null, null, null, null, null, null, null, null, null, null, trialInterval, null, 24575, null), null, 2, null));
    }

    public final void updateFreeTrialLimit(Integer limit) {
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, limit, 16383, null), null, 2, null));
    }

    public final void updateImage(String image) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        requireViewState();
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(guildRoleSubscriptionTier, null, null, null, null, null, null, image, null, null, null, null, null, null, null, null, 32703, null), null, 2, null));
    }

    public final void updateIntangibleBenefit(Benefit.IntangibleBenefit existingIntangibleBenefit, Benefit.IntangibleBenefit newIntangibleBenefit) {
        if (existingIntangibleBenefit == null && newIntangibleBenefit != null) {
            addIntangibleBenefit(newIntangibleBenefit);
            return;
        }
        if (existingIntangibleBenefit != null && newIntangibleBenefit == null) {
            removeIntangibleBenefit(existingIntangibleBenefit);
        } else {
            if (existingIntangibleBenefit == null || newIntangibleBenefit == null) {
                return;
            }
            replaceIntangibleBenefit(existingIntangibleBenefit, newIntangibleBenefit);
        }
    }

    public final void updateMemberColor(Integer memberColor) {
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, null, memberColor, null, null, null, null, null, null, null, null, null, null, null, 32759, null), null, 2, null));
    }

    public final void updateMemberIcon(String memberIcon) {
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, null, null, memberIcon, null, null, null, null, null, null, null, null, null, null, 32751, null), null, 2, null));
    }

    public final void updatePriceTier(int priceTier) {
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), null, null, Integer.valueOf(priceTier), null, null, null, null, null, null, null, null, null, null, null, null, 32763, null), null, 2, null));
    }

    public final void updateTierName(String tierName) {
        m.checkNotNullParameter(tierName, "tierName");
        updateViewState(ViewState.copy$default(requireViewState(), GuildRoleSubscriptionTier.copy$default(requireViewState().getGuildRoleSubscriptionTier(), tierName, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null), null, 2, null));
    }
}

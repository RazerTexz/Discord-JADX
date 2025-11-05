package com.discord.widgets.stage.usersheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.databinding.UserProfileStageActionsViewBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.widgets.stage.StageRoles;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UserProfileStageActionsView.kt */
/* loaded from: classes2.dex */
public final class UserProfileStageActionsView extends LinearLayout {
    private final UserProfileStageActionsViewBinding binding;

    /* compiled from: UserProfileStageActionsView.kt */
    public static final /* data */ class ViewState {
        private final boolean canMuteMembers;
        private final Channel channel;
        private final boolean isInvitingToSpeak;
        private final boolean isMe;
        private final boolean isUpdatingSuppressed;
        private final boolean userInSameVoiceChannel;
        private final StageRequestToSpeakState userRequestToSpeakState;
        private final StageRoles userStageRole;

        private ViewState(boolean z2, Channel channel, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, boolean z3, boolean z4, boolean z5, boolean z6) {
            this.isMe = z2;
            this.channel = channel;
            this.userStageRole = stageRoles;
            this.userRequestToSpeakState = stageRequestToSpeakState;
            this.userInSameVoiceChannel = z3;
            this.canMuteMembers = z4;
            this.isUpdatingSuppressed = z5;
            this.isInvitingToSpeak = z6;
        }

        /* renamed from: copy-am1GJgw$default, reason: not valid java name */
        public static /* synthetic */ ViewState m51copyam1GJgw$default(ViewState viewState, boolean z2, Channel channel, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, boolean z3, boolean z4, boolean z5, boolean z6, int i, Object obj) {
            return viewState.m53copyam1GJgw((i & 1) != 0 ? viewState.isMe : z2, (i & 2) != 0 ? viewState.channel : channel, (i & 4) != 0 ? viewState.userStageRole : stageRoles, (i & 8) != 0 ? viewState.userRequestToSpeakState : stageRequestToSpeakState, (i & 16) != 0 ? viewState.userInSameVoiceChannel : z3, (i & 32) != 0 ? viewState.canMuteMembers : z4, (i & 64) != 0 ? viewState.isUpdatingSuppressed : z5, (i & 128) != 0 ? viewState.isInvitingToSpeak : z6);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsMe() {
            return this.isMe;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component3-twRsX-0, reason: not valid java name and from getter */
        public final StageRoles getUserStageRole() {
            return this.userStageRole;
        }

        /* renamed from: component4, reason: from getter */
        public final StageRequestToSpeakState getUserRequestToSpeakState() {
            return this.userRequestToSpeakState;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getUserInSameVoiceChannel() {
            return this.userInSameVoiceChannel;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getCanMuteMembers() {
            return this.canMuteMembers;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsUpdatingSuppressed() {
            return this.isUpdatingSuppressed;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getIsInvitingToSpeak() {
            return this.isInvitingToSpeak;
        }

        /* renamed from: copy-am1GJgw, reason: not valid java name */
        public final ViewState m53copyam1GJgw(boolean isMe, Channel channel, StageRoles userStageRole, StageRequestToSpeakState userRequestToSpeakState, boolean userInSameVoiceChannel, boolean canMuteMembers, boolean isUpdatingSuppressed, boolean isInvitingToSpeak) {
            m.checkNotNullParameter(userRequestToSpeakState, "userRequestToSpeakState");
            return new ViewState(isMe, channel, userStageRole, userRequestToSpeakState, userInSameVoiceChannel, canMuteMembers, isUpdatingSuppressed, isInvitingToSpeak);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isMe == viewState.isMe && m.areEqual(this.channel, viewState.channel) && m.areEqual(this.userStageRole, viewState.userStageRole) && m.areEqual(this.userRequestToSpeakState, viewState.userRequestToSpeakState) && this.userInSameVoiceChannel == viewState.userInSameVoiceChannel && this.canMuteMembers == viewState.canMuteMembers && this.isUpdatingSuppressed == viewState.isUpdatingSuppressed && this.isInvitingToSpeak == viewState.isInvitingToSpeak;
        }

        public final boolean getCanMuteMembers() {
            return this.canMuteMembers;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final boolean getUserInSameVoiceChannel() {
            return this.userInSameVoiceChannel;
        }

        public final StageRequestToSpeakState getUserRequestToSpeakState() {
            return this.userRequestToSpeakState;
        }

        /* renamed from: getUserStageRole-twRsX-0, reason: not valid java name */
        public final StageRoles m54getUserStageRoletwRsX0() {
            return this.userStageRole;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r2v11, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v7, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v9, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.isMe;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            Channel channel = this.channel;
            int iHashCode = (i + (channel != null ? channel.hashCode() : 0)) * 31;
            StageRoles stageRoles = this.userStageRole;
            int iHashCode2 = (iHashCode + (stageRoles != null ? stageRoles.hashCode() : 0)) * 31;
            StageRequestToSpeakState stageRequestToSpeakState = this.userRequestToSpeakState;
            int iHashCode3 = (iHashCode2 + (stageRequestToSpeakState != null ? stageRequestToSpeakState.hashCode() : 0)) * 31;
            ?? r2 = this.userInSameVoiceChannel;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (iHashCode3 + i2) * 31;
            ?? r22 = this.canMuteMembers;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            ?? r23 = this.isUpdatingSuppressed;
            int i6 = r23;
            if (r23 != 0) {
                i6 = 1;
            }
            int i7 = (i5 + i6) * 31;
            boolean z3 = this.isInvitingToSpeak;
            return i7 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isInvitingToSpeak() {
            return this.isInvitingToSpeak;
        }

        public final boolean isMe() {
            return this.isMe;
        }

        public final boolean isUpdatingSuppressed() {
            return this.isUpdatingSuppressed;
        }

        public String toString() {
            StringBuilder sbU = a.U("ViewState(isMe=");
            sbU.append(this.isMe);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", userStageRole=");
            sbU.append(this.userStageRole);
            sbU.append(", userRequestToSpeakState=");
            sbU.append(this.userRequestToSpeakState);
            sbU.append(", userInSameVoiceChannel=");
            sbU.append(this.userInSameVoiceChannel);
            sbU.append(", canMuteMembers=");
            sbU.append(this.canMuteMembers);
            sbU.append(", isUpdatingSuppressed=");
            sbU.append(this.isUpdatingSuppressed);
            sbU.append(", isInvitingToSpeak=");
            return a.O(sbU, this.isInvitingToSpeak, ")");
        }

        public /* synthetic */ ViewState(boolean z2, Channel channel, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, boolean z3, boolean z4, boolean z5, boolean z6, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, channel, stageRoles, stageRequestToSpeakState, z3, z4, z5, z6);
        }

        public /* synthetic */ ViewState(boolean z2, Channel channel, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, boolean z3, boolean z4, boolean z5, boolean z6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, channel, stageRoles, stageRequestToSpeakState, z3, z4, (i & 64) != 0 ? false : z5, (i & 128) != 0 ? false : z6);
        }
    }

    /* compiled from: UserProfileStageActionsView.kt */
    /* renamed from: com.discord.widgets.stage.usersheet.UserProfileStageActionsView$setOnInviteToSpeak$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onInviteToSpeak;

        public AnonymousClass1(Function0 function0) {
            this.$onInviteToSpeak = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onInviteToSpeak.invoke();
        }
    }

    /* compiled from: UserProfileStageActionsView.kt */
    /* renamed from: com.discord.widgets.stage.usersheet.UserProfileStageActionsView$setOnMoveToAudience$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onMoveToAudience;

        public AnonymousClass1(Function0 function0) {
            this.$onMoveToAudience = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onMoveToAudience.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileStageActionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.user_profile_stage_actions_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.user_profile_stage_invite_to_speak;
        TextView textView = (TextView) viewInflate.findViewById(R.id.user_profile_stage_invite_to_speak);
        if (textView != null) {
            i = R.id.user_profile_stage_move_to_audience;
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.user_profile_stage_move_to_audience);
            if (textView2 != null) {
                UserProfileStageActionsViewBinding userProfileStageActionsViewBinding = new UserProfileStageActionsViewBinding((LinearLayout) viewInflate, textView, textView2);
                m.checkNotNullExpressionValue(userProfileStageActionsViewBinding, "UserProfileStageActionsV…rom(context), this, true)");
                this.binding = userProfileStageActionsViewBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void setOnInviteToSpeak(Function0<Unit> onInviteToSpeak) {
        m.checkNotNullParameter(onInviteToSpeak, "onInviteToSpeak");
        this.binding.f2167b.setOnClickListener(new AnonymousClass1(onInviteToSpeak));
    }

    public final void setOnMoveToAudience(Function0<Unit> onMoveToAudience) {
        m.checkNotNullParameter(onMoveToAudience, "onMoveToAudience");
        this.binding.c.setOnClickListener(new AnonymousClass1(onMoveToAudience));
    }

    public final void updateView(ViewState viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        if (!viewState.getUserInSameVoiceChannel() || !viewState.getCanMuteMembers()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        TextView textView = this.binding.f2167b;
        textView.setVisibility(viewState.getUserRequestToSpeakState().getCanBeInvitedToSpeak() ? 0 : 8);
        textView.setEnabled(!viewState.isInvitingToSpeak());
        textView.setText(viewState.isMe() ? R.string.moderator_raise_own_hand : R.string.stage_channel_user_invite_to_speak);
        DrawableCompat.setCompoundDrawablesCompat$default(textView, viewState.isMe() ? R.drawable.ic_stage_move_to_speaker : R.drawable.ic_stage_invite_speak, 0, 0, 0, 14, (Object) null);
        TextView textView2 = this.binding.c;
        StageRoles stageRolesM54getUserStageRoletwRsX0 = viewState.m54getUserStageRoletwRsX0();
        textView2.setVisibility(stageRolesM54getUserStageRoletwRsX0 != null && StageRoles.m33isSpeakerimpl(stageRolesM54getUserStageRoletwRsX0.m35unboximpl()) ? 0 : 8);
        textView2.setEnabled(!viewState.isUpdatingSuppressed());
    }
}

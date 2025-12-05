package com.discord.widgets.user.profile;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import com.discord.databinding.UserProfileAdminViewBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: UserProfileAdminView.kt */
/* loaded from: classes.dex */
public final class UserProfileAdminView extends LinearLayout {
    private final UserProfileAdminViewBinding binding;

    /* compiled from: UserProfileAdminView.kt */
    public static final /* data */ class ViewState {
        private final boolean isAdminSectionEnabled;
        private final boolean isCommunicationDisabled;
        private final boolean isMe;
        private final boolean isMultiUserDM;
        private final boolean isServerDeafened;
        private final boolean isServerMuted;
        private final boolean showBanButton;
        private final boolean showDisableCommunicationButton;
        private final boolean showEditMemberButton;
        private final boolean showKickButton;
        private final boolean showServerDeafenButton;
        private final boolean showServerMoveAndDisconnectButtons;
        private final boolean showServerMuteButton;

        public ViewState(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
            this.showEditMemberButton = z2;
            this.showKickButton = z3;
            this.showDisableCommunicationButton = z4;
            this.isMultiUserDM = z5;
            this.showBanButton = z6;
            this.showServerMuteButton = z7;
            this.isServerMuted = z8;
            this.showServerDeafenButton = z9;
            this.isServerDeafened = z10;
            this.showServerMoveAndDisconnectButtons = z11;
            this.isAdminSectionEnabled = z12;
            this.isMe = z13;
            this.isCommunicationDisabled = z14;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i, Object obj) {
            return viewState.copy((i & 1) != 0 ? viewState.showEditMemberButton : z2, (i & 2) != 0 ? viewState.showKickButton : z3, (i & 4) != 0 ? viewState.showDisableCommunicationButton : z4, (i & 8) != 0 ? viewState.isMultiUserDM : z5, (i & 16) != 0 ? viewState.showBanButton : z6, (i & 32) != 0 ? viewState.showServerMuteButton : z7, (i & 64) != 0 ? viewState.isServerMuted : z8, (i & 128) != 0 ? viewState.showServerDeafenButton : z9, (i & 256) != 0 ? viewState.isServerDeafened : z10, (i & 512) != 0 ? viewState.showServerMoveAndDisconnectButtons : z11, (i & 1024) != 0 ? viewState.isAdminSectionEnabled : z12, (i & 2048) != 0 ? viewState.isMe : z13, (i & 4096) != 0 ? viewState.isCommunicationDisabled : z14);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getShowEditMemberButton() {
            return this.showEditMemberButton;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getShowServerMoveAndDisconnectButtons() {
            return this.showServerMoveAndDisconnectButtons;
        }

        /* renamed from: component11, reason: from getter */
        public final boolean getIsAdminSectionEnabled() {
            return this.isAdminSectionEnabled;
        }

        /* renamed from: component12, reason: from getter */
        public final boolean getIsMe() {
            return this.isMe;
        }

        /* renamed from: component13, reason: from getter */
        public final boolean getIsCommunicationDisabled() {
            return this.isCommunicationDisabled;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getShowKickButton() {
            return this.showKickButton;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getShowDisableCommunicationButton() {
            return this.showDisableCommunicationButton;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsMultiUserDM() {
            return this.isMultiUserDM;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getShowBanButton() {
            return this.showBanButton;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getShowServerMuteButton() {
            return this.showServerMuteButton;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsServerMuted() {
            return this.isServerMuted;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getShowServerDeafenButton() {
            return this.showServerDeafenButton;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getIsServerDeafened() {
            return this.isServerDeafened;
        }

        public final ViewState copy(boolean showEditMemberButton, boolean showKickButton, boolean showDisableCommunicationButton, boolean isMultiUserDM, boolean showBanButton, boolean showServerMuteButton, boolean isServerMuted, boolean showServerDeafenButton, boolean isServerDeafened, boolean showServerMoveAndDisconnectButtons, boolean isAdminSectionEnabled, boolean isMe, boolean isCommunicationDisabled) {
            return new ViewState(showEditMemberButton, showKickButton, showDisableCommunicationButton, isMultiUserDM, showBanButton, showServerMuteButton, isServerMuted, showServerDeafenButton, isServerDeafened, showServerMoveAndDisconnectButtons, isAdminSectionEnabled, isMe, isCommunicationDisabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.showEditMemberButton == viewState.showEditMemberButton && this.showKickButton == viewState.showKickButton && this.showDisableCommunicationButton == viewState.showDisableCommunicationButton && this.isMultiUserDM == viewState.isMultiUserDM && this.showBanButton == viewState.showBanButton && this.showServerMuteButton == viewState.showServerMuteButton && this.isServerMuted == viewState.isServerMuted && this.showServerDeafenButton == viewState.showServerDeafenButton && this.isServerDeafened == viewState.isServerDeafened && this.showServerMoveAndDisconnectButtons == viewState.showServerMoveAndDisconnectButtons && this.isAdminSectionEnabled == viewState.isAdminSectionEnabled && this.isMe == viewState.isMe && this.isCommunicationDisabled == viewState.isCommunicationDisabled;
        }

        public final boolean getShowBanButton() {
            return this.showBanButton;
        }

        public final boolean getShowDisableCommunicationButton() {
            return this.showDisableCommunicationButton;
        }

        public final boolean getShowEditMemberButton() {
            return this.showEditMemberButton;
        }

        public final boolean getShowKickButton() {
            return this.showKickButton;
        }

        public final boolean getShowServerDeafenButton() {
            return this.showServerDeafenButton;
        }

        public final boolean getShowServerMoveAndDisconnectButtons() {
            return this.showServerMoveAndDisconnectButtons;
        }

        public final boolean getShowServerMuteButton() {
            return this.showServerMuteButton;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v26 */
        /* JADX WARN: Type inference failed for: r0v27 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v14, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v16, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v18, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v20, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.showEditMemberButton;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.showKickButton;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            ?? r22 = this.showDisableCommunicationButton;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            ?? r23 = this.isMultiUserDM;
            int i6 = r23;
            if (r23 != 0) {
                i6 = 1;
            }
            int i7 = (i5 + i6) * 31;
            ?? r24 = this.showBanButton;
            int i8 = r24;
            if (r24 != 0) {
                i8 = 1;
            }
            int i9 = (i7 + i8) * 31;
            ?? r25 = this.showServerMuteButton;
            int i10 = r25;
            if (r25 != 0) {
                i10 = 1;
            }
            int i11 = (i9 + i10) * 31;
            ?? r26 = this.isServerMuted;
            int i12 = r26;
            if (r26 != 0) {
                i12 = 1;
            }
            int i13 = (i11 + i12) * 31;
            ?? r27 = this.showServerDeafenButton;
            int i14 = r27;
            if (r27 != 0) {
                i14 = 1;
            }
            int i15 = (i13 + i14) * 31;
            ?? r28 = this.isServerDeafened;
            int i16 = r28;
            if (r28 != 0) {
                i16 = 1;
            }
            int i17 = (i15 + i16) * 31;
            ?? r29 = this.showServerMoveAndDisconnectButtons;
            int i18 = r29;
            if (r29 != 0) {
                i18 = 1;
            }
            int i19 = (i17 + i18) * 31;
            ?? r210 = this.isAdminSectionEnabled;
            int i20 = r210;
            if (r210 != 0) {
                i20 = 1;
            }
            int i21 = (i19 + i20) * 31;
            ?? r211 = this.isMe;
            int i22 = r211;
            if (r211 != 0) {
                i22 = 1;
            }
            int i23 = (i21 + i22) * 31;
            boolean z3 = this.isCommunicationDisabled;
            return i23 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isAdminSectionEnabled() {
            return this.isAdminSectionEnabled;
        }

        public final boolean isCommunicationDisabled() {
            return this.isCommunicationDisabled;
        }

        public final boolean isMe() {
            return this.isMe;
        }

        public final boolean isMultiUserDM() {
            return this.isMultiUserDM;
        }

        public final boolean isServerDeafened() {
            return this.isServerDeafened;
        }

        public final boolean isServerMuted() {
            return this.isServerMuted;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("ViewState(showEditMemberButton=");
            sbM833U.append(this.showEditMemberButton);
            sbM833U.append(", showKickButton=");
            sbM833U.append(this.showKickButton);
            sbM833U.append(", showDisableCommunicationButton=");
            sbM833U.append(this.showDisableCommunicationButton);
            sbM833U.append(", isMultiUserDM=");
            sbM833U.append(this.isMultiUserDM);
            sbM833U.append(", showBanButton=");
            sbM833U.append(this.showBanButton);
            sbM833U.append(", showServerMuteButton=");
            sbM833U.append(this.showServerMuteButton);
            sbM833U.append(", isServerMuted=");
            sbM833U.append(this.isServerMuted);
            sbM833U.append(", showServerDeafenButton=");
            sbM833U.append(this.showServerDeafenButton);
            sbM833U.append(", isServerDeafened=");
            sbM833U.append(this.isServerDeafened);
            sbM833U.append(", showServerMoveAndDisconnectButtons=");
            sbM833U.append(this.showServerMoveAndDisconnectButtons);
            sbM833U.append(", isAdminSectionEnabled=");
            sbM833U.append(this.isAdminSectionEnabled);
            sbM833U.append(", isMe=");
            sbM833U.append(this.isMe);
            sbM833U.append(", isCommunicationDisabled=");
            return outline.m827O(sbM833U, this.isCommunicationDisabled, ")");
        }
    }

    /* compiled from: UserProfileAdminView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileAdminView$setOnBan$1 */
    public static final class ViewOnClickListenerC102841 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onBan;

        public ViewOnClickListenerC102841(Function0 function0) {
            this.$onBan = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onBan.invoke();
        }
    }

    /* compiled from: UserProfileAdminView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileAdminView$setOnDisableCommunication$1 */
    public static final class ViewOnClickListenerC102851 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onDisableCommunication;

        public ViewOnClickListenerC102851(Function0 function0) {
            this.$onDisableCommunication = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onDisableCommunication.invoke();
        }
    }

    /* compiled from: UserProfileAdminView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileAdminView$setOnDisconnect$1 */
    public static final class ViewOnClickListenerC102861 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onDisconnect;

        public ViewOnClickListenerC102861(Function0 function0) {
            this.$onDisconnect = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onDisconnect.invoke();
        }
    }

    /* compiled from: UserProfileAdminView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileAdminView$setOnEditMember$1 */
    public static final class ViewOnClickListenerC102871 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onEditMember;

        public ViewOnClickListenerC102871(Function0 function0) {
            this.$onEditMember = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onEditMember.invoke();
        }
    }

    /* compiled from: UserProfileAdminView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileAdminView$setOnKick$1 */
    public static final class ViewOnClickListenerC102881 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onKick;

        public ViewOnClickListenerC102881(Function0 function0) {
            this.$onKick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onKick.invoke();
        }
    }

    /* compiled from: UserProfileAdminView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileAdminView$setOnServerDeafen$1 */
    public static final class ViewOnClickListenerC102891 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onServerDeafen;

        public ViewOnClickListenerC102891(Function0 function0) {
            this.$onServerDeafen = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onServerDeafen.invoke();
        }
    }

    /* compiled from: UserProfileAdminView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileAdminView$setOnServerMove$1 */
    public static final class ViewOnClickListenerC102901 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onServerMove;

        public ViewOnClickListenerC102901(Function0 function0) {
            this.$onServerMove = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onServerMove.invoke();
        }
    }

    /* compiled from: UserProfileAdminView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileAdminView$setOnServerMute$1 */
    public static final class ViewOnClickListenerC102911 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onServerMute;

        public ViewOnClickListenerC102911(Function0 function0) {
            this.$onServerMute = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onServerMute.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileAdminView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.user_profile_admin_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.user_profile_admin_ban;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.user_profile_admin_ban);
        if (textView != null) {
            i = C5419R.id.user_profile_admin_disable_communication;
            TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.user_profile_admin_disable_communication);
            if (textView2 != null) {
                i = C5419R.id.user_profile_admin_edit_member;
                TextView textView3 = (TextView) viewInflate.findViewById(C5419R.id.user_profile_admin_edit_member);
                if (textView3 != null) {
                    i = C5419R.id.user_profile_admin_kick;
                    TextView textView4 = (TextView) viewInflate.findViewById(C5419R.id.user_profile_admin_kick);
                    if (textView4 != null) {
                        i = C5419R.id.user_profile_admin_server_deafen;
                        TextView textView5 = (TextView) viewInflate.findViewById(C5419R.id.user_profile_admin_server_deafen);
                        if (textView5 != null) {
                            i = C5419R.id.user_profile_admin_server_disconnect;
                            TextView textView6 = (TextView) viewInflate.findViewById(C5419R.id.user_profile_admin_server_disconnect);
                            if (textView6 != null) {
                                i = C5419R.id.user_profile_admin_server_move;
                                TextView textView7 = (TextView) viewInflate.findViewById(C5419R.id.user_profile_admin_server_move);
                                if (textView7 != null) {
                                    i = C5419R.id.user_profile_admin_server_mute;
                                    TextView textView8 = (TextView) viewInflate.findViewById(C5419R.id.user_profile_admin_server_mute);
                                    if (textView8 != null) {
                                        UserProfileAdminViewBinding userProfileAdminViewBinding = new UserProfileAdminViewBinding((LinearLayout) viewInflate, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
                                        Intrinsics3.checkNotNullExpressionValue(userProfileAdminViewBinding, "UserProfileAdminViewBind…rom(context), this, true)");
                                        this.binding = userProfileAdminViewBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void setOnBan(Function0<Unit> onBan) {
        Intrinsics3.checkNotNullParameter(onBan, "onBan");
        this.binding.f15327b.setOnClickListener(new ViewOnClickListenerC102841(onBan));
    }

    public final void setOnDisableCommunication(Function0<Unit> onDisableCommunication) {
        Intrinsics3.checkNotNullParameter(onDisableCommunication, "onDisableCommunication");
        this.binding.f15328c.setOnClickListener(new ViewOnClickListenerC102851(onDisableCommunication));
    }

    public final void setOnDisconnect(Function0<Unit> onDisconnect) {
        Intrinsics3.checkNotNullParameter(onDisconnect, "onDisconnect");
        this.binding.f15332g.setOnClickListener(new ViewOnClickListenerC102861(onDisconnect));
    }

    public final void setOnEditMember(Function0<Unit> onEditMember) {
        Intrinsics3.checkNotNullParameter(onEditMember, "onEditMember");
        this.binding.f15329d.setOnClickListener(new ViewOnClickListenerC102871(onEditMember));
    }

    public final void setOnKick(Function0<Unit> onKick) {
        Intrinsics3.checkNotNullParameter(onKick, "onKick");
        this.binding.f15330e.setOnClickListener(new ViewOnClickListenerC102881(onKick));
    }

    public final void setOnServerDeafen(Function0<Unit> onServerDeafen) {
        Intrinsics3.checkNotNullParameter(onServerDeafen, "onServerDeafen");
        this.binding.f15331f.setOnClickListener(new ViewOnClickListenerC102891(onServerDeafen));
    }

    public final void setOnServerMove(Function0<Unit> onServerMove) {
        Intrinsics3.checkNotNullParameter(onServerMove, "onServerMove");
        this.binding.f15333h.setOnClickListener(new ViewOnClickListenerC102901(onServerMove));
    }

    public final void setOnServerMute(Function0<Unit> onServerMute) {
        Intrinsics3.checkNotNullParameter(onServerMute, "onServerMute");
        this.binding.f15334i.setOnClickListener(new ViewOnClickListenerC102911(onServerMute));
    }

    public final void updateView(ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        TextView textView = this.binding.f15329d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.userProfileAdminEditMember");
        textView.setVisibility(viewState.getShowEditMemberButton() ? 0 : 8);
        TextView textView2 = this.binding.f15330e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.userProfileAdminKick");
        textView2.setVisibility(viewState.getShowKickButton() ? 0 : 8);
        TextView textView3 = this.binding.f15328c;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.userProfileAdminDisableCommunication");
        textView3.setVisibility(viewState.getShowDisableCommunicationButton() ? 0 : 8);
        this.binding.f15330e.setText(viewState.isMultiUserDM() ? C5419R.string.remove_from_group : C5419R.string.kick);
        TextView textView4 = this.binding.f15327b;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.userProfileAdminBan");
        textView4.setVisibility(viewState.getShowBanButton() ? 0 : 8);
        boolean zIsCommunicationDisabled = viewState.isCommunicationDisabled();
        int i = zIsCommunicationDisabled ? C5419R.string.remove_time_out : C5419R.string.time_out;
        Drawable drawable = zIsCommunicationDisabled ? ContextCompat.getDrawable(getContext(), C5419R.drawable.ic_enable_guild_communication_24dp) : ContextCompat.getDrawable(getContext(), C5419R.drawable.ic_disable_guild_communication_red_24dp);
        this.binding.f15328c.setText(i);
        TextView textView5 = this.binding.f15328c;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.userProfileAdminDisableCommunication");
        DrawableCompat.setCompoundDrawablesCompat$default(textView5, drawable, (Drawable) null, (Drawable) null, (Drawable) null, 14, (Object) null);
        TextView textView6 = this.binding.f15334i;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.userProfileAdminServerMute");
        textView6.setVisibility(viewState.getShowServerMuteButton() ? 0 : 8);
        boolean zIsServerMuted = viewState.isServerMuted();
        boolean zIsMe = viewState.isMe();
        int themedDrawableRes$default = zIsServerMuted ? DrawableCompat.getThemedDrawableRes$default(this, C5419R.attr.ic_mic_muted_grey, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(this, C5419R.attr.ic_mic_grey, 0, 2, (Object) null);
        int i2 = zIsServerMuted ? C5419R.string.server_unmute : C5419R.string.server_mute;
        TextView textView7 = this.binding.f15334i;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.userProfileAdminServerMute");
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView7, themedDrawableRes$default, 0, 0, 0, 14, null);
        this.binding.f15334i.setText(i2);
        TextView textView8 = this.binding.f15331f;
        Intrinsics3.checkNotNullExpressionValue(textView8, "binding.userProfileAdminServerDeafen");
        textView8.setVisibility(viewState.getShowServerDeafenButton() ? 0 : 8);
        boolean zIsServerDeafened = viewState.isServerDeafened();
        int themedDrawableRes$default2 = zIsServerDeafened ? DrawableCompat.getThemedDrawableRes$default(this, C5419R.attr.ic_headset_deafened_grey, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(this, C5419R.attr.ic_headset_deafened_grey, 0, 2, (Object) null);
        int i3 = zIsServerDeafened ? C5419R.string.server_undeafen : C5419R.string.server_deafen;
        int i4 = zIsMe ? C5419R.string.disconnect_self : C5419R.string.disconnect_other;
        TextView textView9 = this.binding.f15331f;
        Intrinsics3.checkNotNullExpressionValue(textView9, "binding.userProfileAdminServerDeafen");
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView9, themedDrawableRes$default2, 0, 0, 0, 14, null);
        this.binding.f15331f.setText(i3);
        TextView textView10 = this.binding.f15333h;
        Intrinsics3.checkNotNullExpressionValue(textView10, "binding.userProfileAdminServerMove");
        textView10.setVisibility(viewState.getShowServerMoveAndDisconnectButtons() ? 0 : 8);
        this.binding.f15332g.setText(i4);
        TextView textView11 = this.binding.f15332g;
        Intrinsics3.checkNotNullExpressionValue(textView11, "binding.userProfileAdminServerDisconnect");
        textView11.setVisibility(viewState.getShowServerMoveAndDisconnectButtons() ? 0 : 8);
    }
}

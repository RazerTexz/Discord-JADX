package com.discord.widgets.user.presence;

import android.view.View;
import android.widget.Button;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.utilities.presence.ActivityUtils2;
import com.discord.utilities.views.ViewCoroutineScope;
import com.discord.widgets.stage.StageChannelJoinHelper;

/* compiled from: ViewHolderStageChannelRichPresence.kt */
/* renamed from: com.discord.widgets.user.presence.ViewHolderStageChannelRichPresence$configureButtonUi$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewHolderStageChannelRichPresence2 implements View.OnClickListener {
    public final /* synthetic */ FragmentManager $fragmentManager$inlined;
    public final /* synthetic */ boolean $isMe$inlined;
    public final /* synthetic */ ActivityUtils2 $partyDerivedData$inlined;
    public final /* synthetic */ Button $this_apply;
    public final /* synthetic */ boolean $userInSameVoiceChannel$inlined;

    public ViewHolderStageChannelRichPresence2(Button button, boolean z2, boolean z3, FragmentManager fragmentManager, ActivityUtils2 activityUtils2) {
        this.$this_apply = button;
        this.$isMe$inlined = z2;
        this.$userInSameVoiceChannel$inlined = z3;
        this.$fragmentManager$inlined = fragmentManager;
        this.$partyDerivedData$inlined = activityUtils2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StageChannelJoinHelper.lurkAndJoinStage$default(StageChannelJoinHelper.INSTANCE, outline.x(view, "it", "it.context"), this.$fragmentManager$inlined, ViewCoroutineScope.getCoroutineScope(this.$this_apply), this.$partyDerivedData$inlined.getGuildId(), this.$partyDerivedData$inlined.getChannelId(), true, null, null, null, 448, null);
    }
}

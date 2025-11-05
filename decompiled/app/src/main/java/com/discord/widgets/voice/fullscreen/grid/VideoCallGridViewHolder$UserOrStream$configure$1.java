package com.discord.widgets.voice.fullscreen.grid;

import android.view.View;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import kotlin.jvm.functions.Function1;

/* compiled from: VideoCallGridViewHolder.kt */
/* loaded from: classes.dex */
public final class VideoCallGridViewHolder$UserOrStream$configure$1 implements View.OnClickListener {
    public final /* synthetic */ CallParticipant.UserOrStreamParticipant $callParticipant;
    public final /* synthetic */ Function1 $onTapped;

    public VideoCallGridViewHolder$UserOrStream$configure$1(Function1 function1, CallParticipant.UserOrStreamParticipant userOrStreamParticipant) {
        this.$onTapped = function1;
        this.$callParticipant = userOrStreamParticipant;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$onTapped.invoke(this.$callParticipant);
    }
}

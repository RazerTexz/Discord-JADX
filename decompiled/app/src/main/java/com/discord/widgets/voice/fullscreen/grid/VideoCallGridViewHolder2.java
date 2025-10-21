package com.discord.widgets.voice.fullscreen.grid;

import android.view.View;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import kotlin.jvm.functions.Function1;

/* compiled from: VideoCallGridViewHolder.kt */
/* renamed from: com.discord.widgets.voice.fullscreen.grid.VideoCallGridViewHolder$EmbeddedActivity$configure$1, reason: use source file name */
/* loaded from: classes.dex */
public final class VideoCallGridViewHolder2 implements View.OnClickListener {
    public final /* synthetic */ CallParticipant.EmbeddedActivityParticipant $callParticipant;
    public final /* synthetic */ Function1 $onTapped;

    public VideoCallGridViewHolder2(Function1 function1, CallParticipant.EmbeddedActivityParticipant embeddedActivityParticipant) {
        this.$onTapped = function1;
        this.$callParticipant = embeddedActivityParticipant;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$onTapped.invoke(this.$callParticipant);
    }
}

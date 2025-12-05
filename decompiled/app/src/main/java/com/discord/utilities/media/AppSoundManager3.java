package com.discord.utilities.media;

import android.content.Context;
import android.media.MediaPlayer;
import com.discord.utilities.media.AppSoundManager;
import kotlin.jvm.functions.Function0;

/* compiled from: AppSoundManager.kt */
/* renamed from: com.discord.utilities.media.AppSoundManager$SoundPlayer$$special$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class AppSoundManager3 implements MediaPlayer.OnCompletionListener {
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ Function0 $onCompletion$inlined;
    public final /* synthetic */ AppSound $sound$inlined;
    public final /* synthetic */ AppSoundManager.SoundPlayer this$0;

    public AppSoundManager3(AppSoundManager.SoundPlayer soundPlayer, AppSound appSound, Context context, Function0 function0) {
        this.this$0 = soundPlayer;
        this.$sound$inlined = appSound;
        this.$context$inlined = context;
        this.$onCompletion$inlined = function0;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        this.$onCompletion$inlined.invoke();
    }
}

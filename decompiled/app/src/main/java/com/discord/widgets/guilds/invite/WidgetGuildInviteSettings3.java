package com.discord.widgets.guilds.invite;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import java.io.Serializable;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetGuildInviteSettings.kt */
/* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$Companion$registerForResult$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildInviteSettings3<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Function1 $callback;

    public WidgetGuildInviteSettings3(Function1 function1) {
        this.$callback = function1;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            Serializable serializableExtra = data != null ? data.getSerializableExtra("EXTRA_CREATED_INVITE") : null;
            GuildInvite guildInvite = (GuildInvite) (serializableExtra instanceof GuildInvite ? serializableExtra : null);
            if (guildInvite != null) {
                this.$callback.invoke(guildInvite);
            }
        }
    }
}

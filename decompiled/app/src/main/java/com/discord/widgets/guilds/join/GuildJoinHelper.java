package com.discord.widgets.guilds.join;

import android.content.Context;
import com.discord.api.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.GuildCaptchaUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* compiled from: GuildJoinHelper.kt */
/* renamed from: com.discord.widgets.guilds.join.GuildJoinHelperKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildJoinHelper {

    /* compiled from: GuildJoinHelper.kt */
    /* renamed from: com.discord.widgets.guilds.join.GuildJoinHelperKt$joinGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ Long $directoryChannelId;
        public final /* synthetic */ Class $errorClass;
        public final /* synthetic */ Function1 $errorHandler;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ boolean $isLurker;
        public final /* synthetic */ Function1 $onNext;
        public final /* synthetic */ String $sessionId;
        public final /* synthetic */ Function1 $subscriptionHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, long j, boolean z2, String str, Long l, Class cls, Function1 function1, Function1 function12, Function1 function13) {
            super(1);
            this.$context = context;
            this.$guildId = j;
            this.$isLurker = z2;
            this.$sessionId = str;
            this.$directoryChannelId = l;
            this.$errorClass = cls;
            this.$subscriptionHandler = function1;
            this.$errorHandler = function12;
            this.$onNext = function13;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            GuildCaptchaUtils.handleHttpException(error, this.$context, new JoinArgs(this.$guildId, this.$isLurker, this.$sessionId, this.$directoryChannelId, this.$errorClass, this.$subscriptionHandler, this.$errorHandler, this.$onNext));
        }
    }

    public static final void joinGuild(Context context, long j, boolean z2, String str, Long l, String str2, Class<?> cls, Function1<? super Subscription, Unit> function1, Function1<? super Error, Unit> function12, CaptchaHelper.CaptchaPayload captchaPayload, Function1<? super Guild, Unit> function13) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(cls, "errorClass");
        Intrinsics3.checkNotNullParameter(function13, "onNext");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().joinGuild(j, z2, str, l, new RestAPIParams.InviteCode(captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null), str2), false, 1, null)), cls, (Context) null, function1, new AnonymousClass1(context, j, z2, str, l, cls, function1, function12, function13), (Function0) null, (Function0) null, function13, 50, (Object) null);
    }

    public static /* synthetic */ void joinGuild$default(Context context, long j, boolean z2, String str, Long l, String str2, Class cls, Function1 function1, Function1 function12, CaptchaHelper.CaptchaPayload captchaPayload, Function1 function13, int i, Object obj) {
        joinGuild(context, j, z2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : str2, cls, (i & 128) != 0 ? null : function1, (i & 256) != 0 ? null : function12, (i & 512) != 0 ? null : captchaPayload, function13);
    }
}

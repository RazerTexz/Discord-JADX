package com.discord.utilities.guilds;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.a.d.AppToast;
import com.discord.app.AppFragment;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.widgets.guilds.invite.InviteJoinHelper;
import com.discord.widgets.guilds.join.GuildJoinHelper;
import com.discord.widgets.guilds.join.InviteArgs;
import com.discord.widgets.guilds.join.JoinArgs;
import com.discord.widgets.guilds.join.WidgetGuildJoinCaptchaBottomSheet;
import d0.g0.Strings4;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import retrofit2.HttpException;

/* compiled from: GuildCaptchaUtils.kt */
/* renamed from: com.discord.utilities.guilds.GuildCaptchaUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildCaptchaUtils {
    private static final String REQUEST_KEY_GUILD_CAPTCHA = "REQUEST_KEY_GUILD_CAPTCHA";

    /* compiled from: GuildCaptchaUtils.kt */
    /* renamed from: com.discord.utilities.guilds.GuildCaptchaUtilsKt$handleHttpException$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<AppFragment, CaptchaHelper.CaptchaPayload, Unit> {
        public final /* synthetic */ InviteArgs $args;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InviteArgs inviteArgs) {
            super(2);
            this.$args = inviteArgs;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            invoke2(appFragment, captchaPayload);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            Intrinsics3.checkNotNullParameter(appFragment, "newFragment");
            Intrinsics3.checkNotNullParameter(captchaPayload, "captchaPayload");
            InviteJoinHelper.INSTANCE.joinViaInvite(this.$args.getInvite(), this.$args.getJavaClass(), appFragment, this.$args.getLocation(), this.$args.getOnInvitePostError(), this.$args.getOnInvitePostSuccess(), this.$args.getOnInviteFlowFinished(), captchaPayload);
        }
    }

    /* compiled from: GuildCaptchaUtils.kt */
    /* renamed from: com.discord.utilities.guilds.GuildCaptchaUtilsKt$handleHttpException$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function2<AppFragment, CaptchaHelper.CaptchaPayload, Unit> {
        public final /* synthetic */ JoinArgs $args;
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, JoinArgs joinArgs) {
            super(2);
            this.$context = context;
            this.$args = joinArgs;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            invoke2(appFragment, captchaPayload);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            Intrinsics3.checkNotNullParameter(appFragment, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(captchaPayload, "captchaPayload");
            GuildJoinHelper.joinGuild$default(this.$context, this.$args.getGuildId(), this.$args.isLurker(), this.$args.getSessionId(), this.$args.getDirectoryChannelId(), null, this.$args.getErrorClass(), this.$args.getSubscriptionHandler(), this.$args.getErrorHandler(), captchaPayload, this.$args.getOnNext(), 32, null);
        }
    }

    public static final void handleHttpException(Error error, Fragment fragment, InviteArgs inviteArgs) {
        Intrinsics3.checkNotNullParameter(error, "error");
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(inviteArgs, "args");
        if (error.getThrowable() instanceof HttpException) {
            String bodyText = error.getBodyText();
            if (Intrinsics3.areEqual(bodyText != null ? Boolean.valueOf(Strings4.contains$default((CharSequence) bodyText, (CharSequence) CaptchaHelper.CAPTCHA_KEY, false, 2, (Object) null)) : null, Boolean.TRUE)) {
                WidgetGuildJoinCaptchaBottomSheet.INSTANCE.enqueue(REQUEST_KEY_GUILD_CAPTCHA, new AnonymousClass1(inviteArgs), CaptchaErrorBody.INSTANCE.createFromError(error));
                return;
            }
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            List list = (List) _Collections.firstOrNull(response.getMessages().values());
            String str = list != null ? (String) _Collections.firstOrNull(list) : null;
            if (str != null) {
                AppToast.j(fragment, str, 0, 4);
            }
        }
    }

    public static final void handleHttpException(Error error, Context context, JoinArgs joinArgs) {
        String str;
        Intrinsics3.checkNotNullParameter(error, "error");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(joinArgs, "args");
        if (error.getThrowable() instanceof HttpException) {
            String bodyText = error.getBodyText();
            if (Intrinsics3.areEqual(bodyText != null ? Boolean.valueOf(Strings4.contains$default((CharSequence) bodyText, (CharSequence) CaptchaHelper.CAPTCHA_KEY, false, 2, (Object) null)) : null, Boolean.TRUE)) {
                WidgetGuildJoinCaptchaBottomSheet.INSTANCE.enqueue(REQUEST_KEY_GUILD_CAPTCHA, new AnonymousClass2(context, joinArgs), CaptchaErrorBody.INSTANCE.createFromError(error));
                return;
            }
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            List list = (List) _Collections.firstOrNull(response.getMessages().values());
            if (list == null || (str = (String) _Collections.firstOrNull(list)) == null) {
                return;
            }
            AppToast.h(context, str, 0, null, 12);
        }
    }
}

package com.discord.utilities.guilds;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.discord.app.AppFragment;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.widgets.guilds.invite.InviteJoinHelper;
import com.discord.widgets.guilds.join.GuildJoinHelperKt;
import com.discord.widgets.guilds.join.InviteArgs;
import com.discord.widgets.guilds.join.JoinArgs;
import com.discord.widgets.guilds.join.WidgetGuildJoinCaptchaBottomSheet;
import d0.g0.w;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import retrofit2.HttpException;

/* compiled from: GuildCaptchaUtils.kt */
/* loaded from: classes2.dex */
public final class GuildCaptchaUtilsKt {
    private static final String REQUEST_KEY_GUILD_CAPTCHA = "REQUEST_KEY_GUILD_CAPTCHA";

    /* compiled from: GuildCaptchaUtils.kt */
    /* renamed from: com.discord.utilities.guilds.GuildCaptchaUtilsKt$handleHttpException$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function2<AppFragment, CaptchaHelper.CaptchaPayload, Unit> {
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
            m.checkNotNullParameter(appFragment, "newFragment");
            m.checkNotNullParameter(captchaPayload, "captchaPayload");
            InviteJoinHelper.INSTANCE.joinViaInvite(this.$args.getInvite(), this.$args.getJavaClass(), appFragment, this.$args.getLocation(), this.$args.getOnInvitePostError(), this.$args.getOnInvitePostSuccess(), this.$args.getOnInviteFlowFinished(), captchaPayload);
        }
    }

    /* compiled from: GuildCaptchaUtils.kt */
    /* renamed from: com.discord.utilities.guilds.GuildCaptchaUtilsKt$handleHttpException$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function2<AppFragment, CaptchaHelper.CaptchaPayload, Unit> {
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
            m.checkNotNullParameter(appFragment, "<anonymous parameter 0>");
            m.checkNotNullParameter(captchaPayload, "captchaPayload");
            GuildJoinHelperKt.joinGuild$default(this.$context, this.$args.getGuildId(), this.$args.isLurker(), this.$args.getSessionId(), this.$args.getDirectoryChannelId(), null, this.$args.getErrorClass(), this.$args.getSubscriptionHandler(), this.$args.getErrorHandler(), captchaPayload, this.$args.getOnNext(), 32, null);
        }
    }

    public static final void handleHttpException(Error error, Fragment fragment, InviteArgs inviteArgs) {
        m.checkNotNullParameter(error, "error");
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(inviteArgs, "args");
        if (error.getThrowable() instanceof HttpException) {
            String bodyText = error.getBodyText();
            if (m.areEqual(bodyText != null ? Boolean.valueOf(w.contains$default((CharSequence) bodyText, (CharSequence) CaptchaHelper.CAPTCHA_KEY, false, 2, (Object) null)) : null, Boolean.TRUE)) {
                WidgetGuildJoinCaptchaBottomSheet.INSTANCE.enqueue(REQUEST_KEY_GUILD_CAPTCHA, new AnonymousClass1(inviteArgs), CaptchaErrorBody.INSTANCE.createFromError(error));
                return;
            }
            Error.Response response = error.getResponse();
            m.checkNotNullExpressionValue(response, "error.response");
            List list = (List) u.firstOrNull(response.getMessages().values());
            String str = list != null ? (String) u.firstOrNull(list) : null;
            if (str != null) {
                b.a.d.m.j(fragment, str, 0, 4);
            }
        }
    }

    public static final void handleHttpException(Error error, Context context, JoinArgs joinArgs) {
        String str;
        m.checkNotNullParameter(error, "error");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(joinArgs, "args");
        if (error.getThrowable() instanceof HttpException) {
            String bodyText = error.getBodyText();
            if (m.areEqual(bodyText != null ? Boolean.valueOf(w.contains$default((CharSequence) bodyText, (CharSequence) CaptchaHelper.CAPTCHA_KEY, false, 2, (Object) null)) : null, Boolean.TRUE)) {
                WidgetGuildJoinCaptchaBottomSheet.INSTANCE.enqueue(REQUEST_KEY_GUILD_CAPTCHA, new AnonymousClass2(context, joinArgs), CaptchaErrorBody.INSTANCE.createFromError(error));
                return;
            }
            Error.Response response = error.getResponse();
            m.checkNotNullExpressionValue(response, "error.response");
            List list = (List) u.firstOrNull(response.getMessages().values());
            if (list == null || (str = (String) u.firstOrNull(list)) == null) {
                return;
            }
            b.a.d.m.h(context, str, 0, null, 12);
        }
    }
}

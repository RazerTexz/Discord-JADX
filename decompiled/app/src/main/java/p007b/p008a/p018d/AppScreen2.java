package p007b.p008a.p018d;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.discord.app.AppActivity;
import com.discord.app.AppComponent;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.widgets.auth.WidgetAgeVerify;
import com.discord.widgets.auth.WidgetAuthAgeGated;
import com.discord.widgets.auth.WidgetAuthBirthday;
import com.discord.widgets.auth.WidgetAuthCaptcha;
import com.discord.widgets.auth.WidgetAuthLanding;
import com.discord.widgets.auth.WidgetAuthLogin;
import com.discord.widgets.auth.WidgetAuthMfa;
import com.discord.widgets.auth.WidgetAuthPhoneVerify;
import com.discord.widgets.auth.WidgetAuthRegisterAccountInformation;
import com.discord.widgets.auth.WidgetAuthRegisterIdentity;
import com.discord.widgets.auth.WidgetAuthResetPassword;
import com.discord.widgets.auth.WidgetAuthUndeleteAccount;
import com.discord.widgets.auth.WidgetOauth2Authorize;
import com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings;
import com.discord.widgets.nux.WidgetNuxChannelPrompt;
import com.discord.widgets.servers.WidgetServerNotifications;
import com.discord.widgets.servers.WidgetServerSettingsBans;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import com.discord.widgets.servers.WidgetServerSettingsEditMember;
import com.discord.widgets.servers.WidgetServerSettingsEditRole;
import com.discord.widgets.servers.WidgetServerSettingsEmojis;
import com.discord.widgets.servers.WidgetServerSettingsEmojisEdit;
import com.discord.widgets.servers.WidgetServerSettingsIntegrations;
import com.discord.widgets.servers.WidgetServerSettingsModeration;
import com.discord.widgets.servers.WidgetServerSettingsOverview;
import com.discord.widgets.servers.WidgetServerSettingsRoles;
import com.discord.widgets.servers.WidgetServerSettingsSecurity;
import com.discord.widgets.servers.WidgetServerSettingsVanityUrl;
import com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps;
import com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites;
import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers;
import com.discord.widgets.settings.WidgetSettingsAppearance;
import com.discord.widgets.settings.WidgetSettingsAuthorizedApps;
import com.discord.widgets.settings.WidgetSettingsBehavior;
import com.discord.widgets.settings.WidgetSettingsLanguage;
import com.discord.widgets.settings.WidgetSettingsMedia;
import com.discord.widgets.settings.WidgetSettingsNotifications;
import com.discord.widgets.settings.WidgetSettingsPrivacy;
import com.discord.widgets.settings.WidgetSettingsVoice;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.discord.widgets.settings.account.WidgetSettingsAccountEmailEdit;
import com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm;
import com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit;
import com.discord.widgets.settings.account.WidgetSettingsBlockedUsers;
import com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnections;
import com.discord.widgets.settings.developer.WidgetSettingsDeveloper;
import com.discord.widgets.settings.premium.WidgetChoosePlan;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.discord.widgets.user.account.WidgetUserAccountVerify;
import com.discord.widgets.user.email.WidgetUserEmailUpdate;
import com.discord.widgets.user.email.WidgetUserEmailVerify;
import com.discord.widgets.user.phone.WidgetUserPhoneManage;
import com.discord.widgets.user.phone.WidgetUserPhoneVerify;
import java.util.List;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p507d0.p513e0.KClass;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: b.a.d.j, reason: use source file name */
/* JADX INFO: compiled from: AppScreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppScreen2 {

    /* JADX INFO: renamed from: g */
    public static final AppScreen2 f524g = new AppScreen2();

    /* JADX INFO: renamed from: a */
    public static final List<KClass<? extends AppFragment>> f518a = Collections2.listOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(WidgetAuthLanding.class), Reflection2.getOrCreateKotlinClass(WidgetAuthLogin.class), Reflection2.getOrCreateKotlinClass(WidgetAuthRegisterIdentity.class), Reflection2.getOrCreateKotlinClass(WidgetAuthRegisterAccountInformation.class), Reflection2.getOrCreateKotlinClass(WidgetAuthUndeleteAccount.class), Reflection2.getOrCreateKotlinClass(WidgetAuthCaptcha.class), Reflection2.getOrCreateKotlinClass(WidgetAuthMfa.class), Reflection2.getOrCreateKotlinClass(WidgetAuthBirthday.class), Reflection2.getOrCreateKotlinClass(WidgetAuthAgeGated.class), Reflection2.getOrCreateKotlinClass(WidgetAuthPhoneVerify.class), Reflection2.getOrCreateKotlinClass(WidgetAuthResetPassword.class)});

    /* JADX INFO: renamed from: b */
    public static final List<KClass<WidgetAgeVerify>> f519b = CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetAgeVerify.class));

    /* JADX INFO: renamed from: c */
    public static final List<KClass<? extends WidgetOauth2Authorize>> f520c = Collections2.listOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(WidgetOauth2Authorize.class), Reflection2.getOrCreateKotlinClass(WidgetOauth2AuthorizeSamsung.class)});

    /* JADX INFO: renamed from: d */
    public static final List<KClass<? extends AppFragment>> f521d = Collections2.listOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(WidgetSettingsAccount.class), Reflection2.getOrCreateKotlinClass(WidgetSettingsAccountBackupCodes.class), Reflection2.getOrCreateKotlinClass(WidgetSettingsAccountChangePassword.class), Reflection2.getOrCreateKotlinClass(WidgetSettingsAccountUsernameEdit.class), Reflection2.getOrCreateKotlinClass(WidgetSettingsAccountEmailEdit.class), Reflection2.getOrCreateKotlinClass(WidgetSettingsAccountEmailEditConfirm.class), Reflection2.getOrCreateKotlinClass(WidgetUserPasswordVerify.class), Reflection2.getOrCreateKotlinClass(WidgetEnableMFASteps.class), Reflection2.getOrCreateKotlinClass(WidgetSettingsAppearance.class), Reflection2.getOrCreateKotlinClass(WidgetSettingsBehavior.class), Reflection2.getOrCreateKotlinClass(WidgetSettingsLanguage.class), Reflection2.getOrCreateKotlinClass(WidgetSettingsMedia.class), Reflection2.getOrCreateKotlinClass(WidgetSettingsPremium.class), Reflection2.getOrCreateKotlinClass(WidgetSettingsNotifications.class), Reflection2.getOrCreateKotlinClass(WidgetSettingsUserConnections.class), Reflection2.getOrCreateKotlinClass(WidgetSettingsVoice.class), Reflection2.getOrCreateKotlinClass(WidgetSettingsPrivacy.class), Reflection2.getOrCreateKotlinClass(WidgetSettingsAuthorizedApps.class), Reflection2.getOrCreateKotlinClass(WidgetServerNotifications.class), Reflection2.getOrCreateKotlinClass(WidgetServerSettingsOverview.class), Reflection2.getOrCreateKotlinClass(WidgetServerSettingsChannels.class), Reflection2.getOrCreateKotlinClass(WidgetServerSettingsEditMember.class), Reflection2.getOrCreateKotlinClass(WidgetServerSettingsEditRole.class), Reflection2.getOrCreateKotlinClass(WidgetServerSettingsIntegrations.class), Reflection2.getOrCreateKotlinClass(WidgetServerSettingsModeration.class), Reflection2.getOrCreateKotlinClass(WidgetServerSettingsVanityUrl.class), Reflection2.getOrCreateKotlinClass(WidgetServerSettingsSecurity.class), Reflection2.getOrCreateKotlinClass(WidgetServerSettingsMembers.class), Reflection2.getOrCreateKotlinClass(WidgetServerSettingsEmojis.class), Reflection2.getOrCreateKotlinClass(WidgetServerSettingsEmojisEdit.class), Reflection2.getOrCreateKotlinClass(WidgetServerSettingsRoles.class), Reflection2.getOrCreateKotlinClass(WidgetServerSettingsInstantInvites.class), Reflection2.getOrCreateKotlinClass(WidgetServerSettingsBans.class), Reflection2.getOrCreateKotlinClass(WidgetChannelSettingsEditPermissions.class), Reflection2.getOrCreateKotlinClass(WidgetChannelSettingsPermissionsOverview.class), Reflection2.getOrCreateKotlinClass(WidgetAuthRegisterIdentity.class), Reflection2.getOrCreateKotlinClass(WidgetAuthRegisterAccountInformation.class), Reflection2.getOrCreateKotlinClass(WidgetAuthBirthday.class), Reflection2.getOrCreateKotlinClass(WidgetAuthAgeGated.class), Reflection2.getOrCreateKotlinClass(WidgetAuthLogin.class), Reflection2.getOrCreateKotlinClass(WidgetAuthPhoneVerify.class), Reflection2.getOrCreateKotlinClass(WidgetAuthResetPassword.class), Reflection2.getOrCreateKotlinClass(WidgetSettingsDeveloper.class), Reflection2.getOrCreateKotlinClass(WidgetSettingsBlockedUsers.class), Reflection2.getOrCreateKotlinClass(WidgetNuxChannelPrompt.class), Reflection2.getOrCreateKotlinClass(WidgetChoosePlan.class), Reflection2.getOrCreateKotlinClass(WidgetServerSettingsCommunityOverview.class), Reflection2.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunitySteps.class), Reflection2.getOrCreateKotlinClass(WidgetGuildScheduledEventSettings.class)});

    /* JADX INFO: renamed from: e */
    public static final List<KClass<? extends AppFragment>> f522e = Collections2.listOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(WidgetCaptcha.class), Reflection2.getOrCreateKotlinClass(WidgetUserAccountVerify.class), Reflection2.getOrCreateKotlinClass(WidgetUserEmailVerify.class), Reflection2.getOrCreateKotlinClass(WidgetUserEmailUpdate.class), Reflection2.getOrCreateKotlinClass(WidgetUserPhoneManage.class), Reflection2.getOrCreateKotlinClass(WidgetUserPhoneVerify.class), Reflection2.getOrCreateKotlinClass(WidgetUserPasswordVerify.class)});

    /* JADX INFO: renamed from: f */
    public static final List<KClass<WidgetTabsHost>> f523f = CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetTabsHost.class));

    /* JADX INFO: renamed from: b */
    public static final void m154b(Context context, boolean z2, Intent intent) {
        Class cls;
        Intrinsics3.checkNotNullParameter(context, "context");
        if (z2) {
            StoreTabsNavigation.selectHomeTab$default(StoreStream.INSTANCE.getTabsNavigation(), intent != null ? intent.getBooleanExtra("com.discord.intent.extra.EXTRA_OPEN_PANEL", false) : false ? StoreNavigation.PanelAction.OPEN : StoreNavigation.PanelAction.CLOSE, false, 2, null);
            cls = WidgetTabsHost.class;
        } else {
            cls = WidgetAuthLanding.class;
        }
        m156d(context, cls, intent);
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ void m155c(Context context, boolean z2, Intent intent, int i) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            intent = null;
        }
        m154b(context, z2, intent);
    }

    /* JADX INFO: renamed from: d */
    public static final void m156d(Context context, Class<? extends AppComponent> cls, Parcelable parcelable) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(cls, "screen");
        Intent intentM522g2 = null;
        Intent intent = (Intent) (!(parcelable instanceof Intent) ? null : parcelable);
        if (intent != null) {
            intentM522g2 = intent;
        } else if (parcelable != null) {
            intentM522g2 = AnimatableValueParser.m522g2(parcelable);
        }
        AppLog appLog = AppLog.f14950g;
        String simpleName = context.getClass().getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        String simpleName2 = cls.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName2, "screen.simpleName");
        appLog.m8365f(simpleName, simpleName2);
        Intent intentPutExtra = (intentM522g2 != null ? new Intent(intentM522g2) : new Intent()).setClass(context, AppActivity.class).putExtra("com.discord.intent.extra.EXTRA_SCREEN", cls);
        Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "if (extras != null) {\n  …nts.EXTRA_SCREEN, screen)");
        context.startActivity(intentPutExtra);
    }

    /* JADX INFO: renamed from: e */
    public static /* synthetic */ void m157e(Context context, Class cls, Parcelable parcelable, int i) {
        int i2 = i & 4;
        m156d(context, cls, null);
    }

    /* JADX INFO: renamed from: g */
    public static void m158g(AppScreen2 appScreen2, FragmentManager fragmentManager, Context context, Class cls, int i, boolean z2, String str, Parcelable parcelable, int i2) {
        if ((i2 & 8) != 0) {
            i = R.id.content;
        }
        if ((i2 & 16) != 0) {
            z2 = false;
        }
        int i3 = i2 & 32;
        if ((i2 & 64) != 0) {
            parcelable = null;
        }
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(cls, "screen");
        if (fragmentManager == null) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        Intrinsics3.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fragmentManager.beginTransaction()");
        Fragment fragmentInstantiate = Fragment.instantiate(context, cls.getName());
        if (parcelable != null) {
            Intrinsics3.checkNotNullExpressionValue(fragmentInstantiate, "fragment");
            Bundle bundleM514e2 = (Bundle) (!(parcelable instanceof Bundle) ? null : parcelable);
            if (bundleM514e2 == null) {
                bundleM514e2 = AnimatableValueParser.m514e2(parcelable);
            }
            fragmentInstantiate.setArguments(bundleM514e2);
        }
        Intrinsics3.checkNotNullExpressionValue(fragmentInstantiate, "Fragment.instantiate(con….toBundle()\n      }\n    }");
        fragmentTransactionBeginTransaction.replace(i, fragmentInstantiate, cls.getName());
        if (z2) {
            fragmentTransactionBeginTransaction.addToBackStack(null);
        }
        fragmentTransactionBeginTransaction.commit();
    }

    /* JADX INFO: renamed from: a */
    public final Intent m159a(Context context, Class<? extends AppComponent> cls, Intent intent) {
        AppLog appLog = AppLog.f14950g;
        String simpleName = context.getClass().getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        String simpleName2 = cls.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName2, "screen.simpleName");
        appLog.m8365f(simpleName, simpleName2);
        Intent intentPutExtra = (intent != null ? new Intent(intent) : new Intent()).setClass(context, AppActivity.class).putExtra("com.discord.intent.extra.EXTRA_SCREEN", cls);
        Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "if (extras != null) {\n  …nts.EXTRA_SCREEN, screen)");
        return intentPutExtra;
    }

    /* JADX INFO: renamed from: f */
    public final void m160f(Context context, ActivityResultLauncher<Intent> activityResultLauncher, Class<? extends AppComponent> cls, Parcelable parcelable) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(activityResultLauncher, "launcher");
        Intrinsics3.checkNotNullParameter(cls, "screen");
        Intent intentM522g2 = null;
        Intent intent = (Intent) (!(parcelable instanceof Intent) ? null : parcelable);
        if (intent != null) {
            intentM522g2 = intent;
        } else if (parcelable != null) {
            intentM522g2 = AnimatableValueParser.m522g2(parcelable);
        }
        activityResultLauncher.launch(m159a(context, cls, intentM522g2));
    }
}

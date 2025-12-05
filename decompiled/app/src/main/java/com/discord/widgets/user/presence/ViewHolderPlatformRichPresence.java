package com.discord.widgets.user.presence;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewKt;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.api.application.Application;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.presence.ActivityUtils;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.playstation.PlaystationExperimentUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ViewHolderPlatformRichPresence.kt */
/* loaded from: classes.dex */
public final class ViewHolderPlatformRichPresence extends ViewHolderUserRichPresence {

    /* compiled from: ViewHolderPlatformRichPresence.kt */
    /* renamed from: com.discord.widgets.user.presence.ViewHolderPlatformRichPresence$configureUi$1 */
    public static final class ViewOnClickListenerC102781 implements View.OnClickListener {
        public final /* synthetic */ Platform $platform;
        public final /* synthetic */ StoreUserConnections $userConnectionStore;

        public ViewOnClickListenerC102781(StoreUserConnections storeUserConnections, Platform platform) {
            this.$userConnectionStore = storeUserConnections;
            this.$platform = platform;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreUserConnections storeUserConnections = this.$userConnectionStore;
            String platformId = this.$platform.getPlatformId();
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            storeUserConnections.authorizeConnection(platformId, context, Traits.Location.Obj.ACTIVITY_ACTION);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolderPlatformRichPresence(View view, SimpleDraweeView simpleDraweeView, SimpleDraweeView simpleDraweeView2, TextView textView, TextView textView2, TextView textView3, View view2, Button button) {
        super(view, simpleDraweeView, simpleDraweeView2, textView, textView2, null, textView3, null, view2, button, null, 3);
        Intrinsics3.checkNotNullParameter(view, "root");
        Intrinsics3.checkNotNullParameter(simpleDraweeView, "richPresenceImageLarge");
        Intrinsics3.checkNotNullParameter(simpleDraweeView2, "richPresenceImageSmall");
        Intrinsics3.checkNotNullParameter(textView, "richPresenceHeader");
        Intrinsics3.checkNotNullParameter(textView2, "richPresenceTitle");
        Intrinsics3.checkNotNullParameter(textView3, "richPresenceTime");
        Intrinsics3.checkNotNullParameter(view2, "richPresenceTextContainer");
        Intrinsics3.checkNotNullParameter(button, "richPresencePrimaryButton");
    }

    private final void configureImages(Platform platform, ModelRichPresence richPresence) {
        Application primaryApplication;
        String applicationIcon$default = null;
        super.configureAssetUi(richPresence != null ? richPresence.getPrimaryActivity() : null, null);
        if (platform == Platform.PLAYSTATION) {
            return;
        }
        if (platform == Platform.XBOX && platform.getThemedPlatformImage() != null) {
            MGImages.setImage$default(MGImages.INSTANCE, getRichPresenceImageLarge(), DrawableCompat.getThemedDrawableRes$default(getRichPresenceImageLarge(), platform.getThemedPlatformImage().intValue(), 0, 2, (Object) null), (MGImages.ChangeDetector) null, 4, (Object) null);
            getRichPresenceImageLarge().setVisibility(0);
            return;
        }
        Integer whitePlatformImage = platform.getWhitePlatformImage();
        SimpleDraweeView richPresenceImageSmall = getRichPresenceImageSmall();
        if (richPresenceImageSmall != null) {
            ViewKt.setVisible(richPresenceImageSmall, (whitePlatformImage == null || platform == Platform.NONE) ? false : true);
        }
        if (platform != Platform.NONE) {
            SimpleDraweeView richPresenceImageSmall2 = getRichPresenceImageSmall();
            Resources resources = richPresenceImageSmall2 != null ? richPresenceImageSmall2.getResources() : null;
            Drawable drawable = (whitePlatformImage == null || resources == null) ? null : ResourcesCompat.getDrawable(resources, whitePlatformImage.intValue(), null);
            SimpleDraweeView richPresenceImageSmall3 = getRichPresenceImageSmall();
            if (richPresenceImageSmall3 != null) {
                richPresenceImageSmall3.setImageDrawable(drawable);
            }
        }
        if (getRichPresenceImageLarge().getVisibility() != 0) {
            if (richPresence != null && (primaryApplication = richPresence.getPrimaryApplication()) != null) {
                long id2 = primaryApplication.getId();
                String icon = primaryApplication.getIcon();
                if (icon == null) {
                    icon = "";
                }
                applicationIcon$default = IconUtils.getApplicationIcon$default(id2, icon, 0, 4, (Object) null);
            }
            getRichPresenceImageLarge().setVisibility(0);
            MGImages.setImage$default(getRichPresenceImageLarge(), applicationIcon$default, 0, 0, false, null, null, 124, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0110  */
    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void configureUi(FragmentManager fragmentManager, StreamContext streamContext, boolean isMe, User user, Context applicationContext, ModelRichPresence richPresence, boolean userInSameVoiceChannel) {
        boolean z2;
        Button richPresencePrimaryButton;
        Button richPresencePrimaryButton2;
        Button richPresencePrimaryButton3;
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(applicationContext, "applicationContext");
        disposeSubscriptions();
        Activity primaryActivity = richPresence != null ? richPresence.getPrimaryActivity() : null;
        if (primaryActivity == null || !ActivityUtils.isGamePlatform(primaryActivity)) {
            getRoot().setVisibility(8);
            return;
        }
        getRoot().setVisibility(0);
        Platform platformFrom = ActivityUtils.isXboxActivity(primaryActivity) ? Platform.XBOX : Platform.INSTANCE.from(primaryActivity.getPlatform());
        TextView richPresenceHeader = getRichPresenceHeader();
        Context context = getRichPresenceHeader().getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "richPresenceHeader.context");
        richPresenceHeader.setText(PresenceUtils.getActivityHeader(context, primaryActivity));
        getRichPresenceTitle().setText(primaryActivity.getName());
        TextView richPresenceTime = getRichPresenceTime();
        ActivityTimestamps timestamps = primaryActivity.getTimestamps();
        ViewExtensions.setTextAndVisibilityBy(richPresenceTime, timestamps != null ? friendlyTime(timestamps) : null);
        getRichPresenceTextContainer().setSelected(true);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        boolean zCanSeePlaystationAccountIntegration = PlaystationExperimentUtils.canSeePlaystationAccountIntegration(companion.getExperiments());
        if (!platformFrom.getEnabled() || (platformFrom == Platform.PLAYSTATION && !zCanSeePlaystationAccountIntegration)) {
            Button richPresencePrimaryButton4 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton4 != null) {
                ViewKt.setVisible(richPresencePrimaryButton4, false);
            }
            Button richPresencePrimaryButton5 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton5 != null) {
                richPresencePrimaryButton5.setOnClickListener(null);
            }
        } else {
            StoreUserConnections userConnections = companion.getUserConnections();
            StoreUserConnections.State stateSnapshot = userConnections.getStateSnapshot();
            if ((stateSnapshot instanceof Collection) && stateSnapshot.isEmpty()) {
                z2 = false;
                richPresencePrimaryButton = getRichPresencePrimaryButton();
                if (richPresencePrimaryButton != null) {
                }
                richPresencePrimaryButton2 = getRichPresencePrimaryButton();
                if (richPresencePrimaryButton2 != null) {
                }
                richPresencePrimaryButton3 = getRichPresencePrimaryButton();
                if (richPresencePrimaryButton3 != null) {
                }
            } else {
                Iterator<ConnectedAccount> it = stateSnapshot.iterator();
                while (it.hasNext()) {
                    String type = it.next().getType();
                    String strName = platformFrom.name();
                    Locale locale = Locale.ENGLISH;
                    Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
                    Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
                    String lowerCase = strName.toLowerCase(locale);
                    Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    if (Intrinsics3.areEqual(type, lowerCase)) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
                richPresencePrimaryButton = getRichPresencePrimaryButton();
                if (richPresencePrimaryButton != null) {
                    ViewKt.setVisible(richPresencePrimaryButton, !z2);
                }
                richPresencePrimaryButton2 = getRichPresencePrimaryButton();
                if (richPresencePrimaryButton2 != null) {
                    Context context2 = getRoot().getContext();
                    Intrinsics3.checkNotNullExpressionValue(context2, "root.context");
                    richPresencePrimaryButton2.setText(FormatUtils.m216h(context2, C5419R.string.user_activity_connect_platform, new Object[]{platformFrom.getProperName()}, null, 4));
                }
                richPresencePrimaryButton3 = getRichPresencePrimaryButton();
                if (richPresencePrimaryButton3 != null) {
                    richPresencePrimaryButton3.setOnClickListener(new ViewOnClickListenerC102781(userConnections, platformFrom));
                }
            }
        }
        configureImages(platformFrom, richPresence);
    }
}

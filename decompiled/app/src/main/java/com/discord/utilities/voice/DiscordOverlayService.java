package com.discord.utilities.voice;

import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import com.discord.C5419R;
import com.discord.app.AppLog;
import com.discord.overlay.OverlayManager;
import com.discord.overlay.OverlayService;
import com.discord.overlay.views.OverlayBubbleWrap;
import com.discord.overlay.views.OverlayDialog;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.device.DeviceUtils;
import com.discord.utilities.extensions.PendingIntentExtensions;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.views.OverlayMenuBubbleDialog;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p036n.OverlayManager4;
import p007b.p008a.p036n.OverlayManager5;
import p007b.p008a.p062y.OverlayVoiceBubble2;
import p007b.p008a.p062y.OverlayVoiceSelectorBubbleDialog3;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* compiled from: DiscordOverlayService.kt */
/* loaded from: classes2.dex */
public final class DiscordOverlayService extends OverlayService {
    private static final String ACTION_CLOSE = "com.discord.actions.OVERLAY_CLOSE";
    private static final String ACTION_OPEN = "com.discord.actions.OVERLAY_OPEN";
    private static final String ACTION_SELECTOR = "com.discord.actions.OVERLAY_SELECTOR";
    private static final String ACTION_VOICE = "com.discord.actions.OVERLAY_VOICE";
    private static final int CLOSE_INTENT_REQ_CODE = 1010;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LOG_TAG = "OverlayService";

    /* compiled from: DiscordOverlayService.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Intent access$createOverlayIntent(Companion companion, Context context, String str) {
            return companion.createOverlayIntent(context, str);
        }

        private final Intent createOverlayIntent(Context context, String action) {
            return new Intent(action, null, context, DiscordOverlayService.class);
        }

        private final void tryStartOverlayService(Context context, String action, boolean checkEnabled) {
            if (StoreStream.INSTANCE.getUserSettings().getIsMobileOverlayEnabled() || !checkEnabled) {
                try {
                    context.startService(createOverlayIntent(context, action));
                } catch (Exception e) {
                    AppLog.f14950g.m8517v(DiscordOverlayService.LOG_TAG, "Overlay request failed.", e);
                }
            }
        }

        public static /* synthetic */ void tryStartOverlayService$default(Companion companion, Context context, String str, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = true;
            }
            companion.tryStartOverlayService(context, str, z2);
        }

        public final void launchForClose(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            tryStartOverlayService(context, DiscordOverlayService.ACTION_CLOSE, false);
        }

        public final void launchForConnect(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.Companion companion = StoreStream.INSTANCE;
            if (!companion.getUserSettings().getIsMobileOverlayEnabled()) {
                AppToast.m169g(context, C5419R.string.overlay_mobile_required, 1, null, 8);
                return;
            }
            WeakReference weakReference = new WeakReference(context);
            Observable observableM11083G = ObservableExtensionsKt.takeSingleUntilTimeout$default(companion.getRtcConnection().getConnectionState(), 1000L, false, 2, null).m11083G(DiscordOverlayService2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11083G, "StoreStream\n            …          }\n            }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(observableM11083G), DiscordOverlayService.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new DiscordOverlayService3(weakReference), 60, (Object) null);
        }

        public final void launchForVoice(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            tryStartOverlayService$default(this, context, DiscordOverlayService.ACTION_VOICE, false, 4, null);
        }

        public final void launchForVoiceChannelSelect(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            tryStartOverlayService$default(this, context, DiscordOverlayService.ACTION_SELECTOR, false, 4, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: DiscordOverlayService.kt */
    /* renamed from: com.discord.utilities.voice.DiscordOverlayService$createMenu$1 */
    public static final class C70311 extends Lambda implements Function1<OverlayDialog, Unit> {
        public C70311() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(OverlayDialog overlayDialog) {
            invoke2(overlayDialog);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(OverlayDialog overlayDialog) {
            Intrinsics3.checkNotNullParameter(overlayDialog, "it");
            DiscordOverlayService.access$getOverlayManager$p(DiscordOverlayService.this).m8433d(overlayDialog);
        }
    }

    /* compiled from: DiscordOverlayService.kt */
    /* renamed from: com.discord.utilities.voice.DiscordOverlayService$createVoiceBubble$1 */
    public static final class C70321 extends Lambda implements Function1<OverlayBubbleWrap, OverlayBubbleWrap> {
        public final /* synthetic */ String $anchorTag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C70321(String str) {
            super(1);
            this.$anchorTag = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ OverlayBubbleWrap invoke(OverlayBubbleWrap overlayBubbleWrap) {
            return invoke2(overlayBubbleWrap);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final OverlayBubbleWrap invoke2(OverlayBubbleWrap overlayBubbleWrap) {
            Rect rect;
            SimpleDraweeView imageView$app_productionGoogleRelease;
            Intrinsics3.checkNotNullParameter(overlayBubbleWrap, "srcBubble");
            OverlayMenuBubbleDialog overlayMenuBubbleDialogAccess$createMenu = DiscordOverlayService.access$createMenu(DiscordOverlayService.this);
            OverlayVoiceBubble2 overlayVoiceBubble2 = (OverlayVoiceBubble2) (!(overlayBubbleWrap instanceof OverlayVoiceBubble2) ? null : overlayBubbleWrap);
            if (overlayVoiceBubble2 == null || (imageView$app_productionGoogleRelease = overlayVoiceBubble2.getImageView$app_productionGoogleRelease()) == null) {
                rect = new Rect();
            } else {
                ViewGroup.LayoutParams layoutParams = imageView$app_productionGoogleRelease.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                int i = marginLayoutParams == null ? 0 : marginLayoutParams.leftMargin;
                ViewGroup.LayoutParams layoutParams2 = imageView$app_productionGoogleRelease.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
                int i2 = marginLayoutParams2 == null ? 0 : marginLayoutParams2.topMargin;
                ViewGroup.LayoutParams layoutParams3 = imageView$app_productionGoogleRelease.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
                int i3 = marginLayoutParams3 == null ? 0 : marginLayoutParams3.rightMargin;
                ViewGroup.LayoutParams layoutParams4 = imageView$app_productionGoogleRelease.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams4 = layoutParams4 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams4 : null;
                rect = new Rect(i, i2, i3, marginLayoutParams4 != null ? marginLayoutParams4.bottomMargin : 0);
            }
            ViewGroup.LayoutParams layoutParams5 = overlayMenuBubbleDialogAccess$createMenu.getLinkedAnchorView().getLayoutParams();
            layoutParams5.width = (overlayBubbleWrap.getWidth() - rect.left) - rect.right;
            layoutParams5.height = overlayBubbleWrap.getHeight();
            overlayMenuBubbleDialogAccess$createMenu.getLinkedAnchorView().requestLayout();
            overlayMenuBubbleDialogAccess$createMenu.getLinkedAnchorView().setTag(this.$anchorTag);
            return overlayMenuBubbleDialogAccess$createMenu;
        }
    }

    /* compiled from: DiscordOverlayService.kt */
    /* renamed from: com.discord.utilities.voice.DiscordOverlayService$createVoiceSelector$1 */
    public static final class C70331 extends Lambda implements Function1<OverlayDialog, Unit> {
        public C70331() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(OverlayDialog overlayDialog) {
            invoke2(overlayDialog);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(OverlayDialog overlayDialog) {
            Intrinsics3.checkNotNullParameter(overlayDialog, "it");
            DiscordOverlayService.access$getOverlayManager$p(DiscordOverlayService.this).m8433d(overlayDialog);
        }
    }

    /* compiled from: DiscordOverlayService.kt */
    /* renamed from: com.discord.utilities.voice.DiscordOverlayService$onCreate$1 */
    public static final class C70341 extends Lambda implements Function1<View, Unit> {
        public static final C70341 INSTANCE = new C70341();

        public C70341() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            if (view instanceof OverlayVoiceBubble2) {
                StoreStream.INSTANCE.getAnalytics().onOverlayVoiceEvent(true);
            }
        }
    }

    /* compiled from: DiscordOverlayService.kt */
    /* renamed from: com.discord.utilities.voice.DiscordOverlayService$onCreate$2 */
    public static final class C70352 extends Lambda implements Function1<View, Unit> {
        public C70352() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            Logger.v$default(AppLog.f14950g, DiscordOverlayService.LOG_TAG, "removeView: " + view, null, 4, null);
            if (view instanceof OverlayVoiceBubble2) {
                StoreStream.INSTANCE.getAnalytics().onOverlayVoiceEvent(false);
            }
            if (DiscordOverlayService.access$getOverlayManager$p(DiscordOverlayService.this).activeBubbles.isEmpty()) {
                Companion.tryStartOverlayService$default(DiscordOverlayService.INSTANCE, DiscordOverlayService.this, DiscordOverlayService.ACTION_CLOSE, false, 4, null);
            }
        }
    }

    /* compiled from: DiscordOverlayService.kt */
    /* renamed from: com.discord.utilities.voice.DiscordOverlayService$onStartCommand$1 */
    public static final class C70361<T, R> implements Func1<Boolean, Boolean> {
        public static final C70361 INSTANCE = new C70361();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Boolean bool) {
            return call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Boolean bool) {
            return Boolean.valueOf(Intrinsics3.areEqual(bool, Boolean.TRUE));
        }
    }

    /* compiled from: DiscordOverlayService.kt */
    /* renamed from: com.discord.utilities.voice.DiscordOverlayService$onStartCommand$2 */
    public static final class C70372 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ Intent $intent;
        public final /* synthetic */ int $startId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C70372(int i, Intent intent) {
            super(1);
            this.$startId = i;
            this.$intent = intent;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            if (!StoreStream.INSTANCE.getUserSettings().getIsMobileOverlayEnabled()) {
                DiscordOverlayService.this.stopForeground(true);
                DiscordOverlayService.this.stopSelf(this.$startId);
                return;
            }
            try {
                DiscordOverlayService.access$handleStart$s1927314545(DiscordOverlayService.this, this.$intent);
            } catch (Exception e) {
                Logger.e$default(AppLog.f14950g, DiscordOverlayService.LOG_TAG, "Overlay failed to handle a request.", e, null, 8, null);
                Companion.tryStartOverlayService$default(DiscordOverlayService.INSTANCE, DiscordOverlayService.this, DiscordOverlayService.ACTION_CLOSE, false, 4, null);
            }
        }
    }

    public static final /* synthetic */ OverlayMenuBubbleDialog access$createMenu(DiscordOverlayService discordOverlayService) {
        return discordOverlayService.createMenu();
    }

    public static final /* synthetic */ OverlayManager access$getOverlayManager$p(DiscordOverlayService discordOverlayService) {
        return discordOverlayService.getOverlayManager();
    }

    public static final /* synthetic */ void access$handleStart$s1927314545(DiscordOverlayService discordOverlayService, Intent intent) {
        super.handleStart(intent);
    }

    public static final /* synthetic */ void access$setOverlayManager$p(DiscordOverlayService discordOverlayService, OverlayManager overlayManager) {
        discordOverlayService.setOverlayManager(overlayManager);
    }

    private final OverlayMenuBubbleDialog createMenu() {
        Context applicationContext = getApplicationContext();
        Intrinsics3.checkNotNullExpressionValue(applicationContext, "applicationContext");
        OverlayMenuBubbleDialog overlayMenuBubbleDialog = new OverlayMenuBubbleDialog(applicationContext);
        overlayMenuBubbleDialog.getInsetMargins().top = overlayMenuBubbleDialog.getResources().getDimensionPixelOffset(C5419R.dimen.vertical_safe_margin);
        overlayMenuBubbleDialog.setOnDialogClosed(new C70311());
        return overlayMenuBubbleDialog;
    }

    private final OverlayBubbleWrap createVoiceBubble() throws Resources.NotFoundException {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(C5419R.dimen.overlay_safe_margin);
        Context applicationContext = getApplicationContext();
        Intrinsics3.checkNotNullExpressionValue(applicationContext, "applicationContext");
        OverlayVoiceBubble2 overlayVoiceBubble2 = new OverlayVoiceBubble2(applicationContext);
        int i = -dimensionPixelOffset;
        overlayVoiceBubble2.getInsetMargins().set(i, dimensionPixelOffset, i, dimensionPixelOffset);
        OverlayManager overlayManager = getOverlayManager();
        C70321 c70321 = new C70321("Active Voice Bubble");
        Objects.requireNonNull(overlayManager);
        Intrinsics3.checkNotNullParameter(overlayVoiceBubble2, "srcBubble");
        Intrinsics3.checkNotNullParameter("Active Voice Bubble", "anchorViewTag");
        Intrinsics3.checkNotNullParameter(c70321, "menuBubbleProvider");
        overlayVoiceBubble2.setOnClickListener(new OverlayManager5(overlayManager, c70321, overlayVoiceBubble2, "Active Voice Bubble"));
        OverlayManager overlayManager2 = getOverlayManager();
        Objects.requireNonNull(overlayManager2);
        Intrinsics3.checkNotNullParameter(overlayVoiceBubble2, "bubble");
        overlayVoiceBubble2.setOnTouchListener(overlayManager2.bubbleOnTouchListener);
        overlayVoiceBubble2.setOnMovingStateChanged(new OverlayManager4(overlayManager2, overlayVoiceBubble2));
        return overlayVoiceBubble2;
    }

    private final OverlayBubbleWrap createVoiceSelector() {
        Context applicationContext = getApplicationContext();
        Intrinsics3.checkNotNullExpressionValue(applicationContext, "applicationContext");
        OverlayVoiceSelectorBubbleDialog3 overlayVoiceSelectorBubbleDialog3 = new OverlayVoiceSelectorBubbleDialog3(applicationContext);
        overlayVoiceSelectorBubbleDialog3.setOnDialogClosed(new C70331());
        return overlayVoiceSelectorBubbleDialog3;
    }

    @Override // com.discord.overlay.OverlayService
    public Notification createNotification(Intent intent) {
        PendingIntent service = PendingIntent.getService(this, 1010, Companion.access$createOverlayIntent(INSTANCE, this, ACTION_CLOSE), PendingIntentExtensions.immutablePendingIntentFlag(134217728));
        Notification notificationBuild = new NotificationCompat.Builder(this, NotificationClient.NOTIF_CHANNEL_MEDIA_CONNECTIONS).setCategory(NotificationCompat.CATEGORY_SERVICE).setPriority(-2).setOnlyAlertOnce(true).setLocalOnly(true).setSmallIcon(C5419R.drawable.ic_notification_24dp).setColor(ColorCompat.getColor(this, C5419R.color.status_green_600)).setContentTitle(getString(C5419R.string.overlay)).setContentText(getString(C5419R.string.overlay_mobile_toggle_desc)).setOngoing(true).addAction(C5419R.drawable.ic_close_grey_24dp, getString(C5419R.string.close), service).addAction(C5419R.drawable.ic_settings_grey_a60_24dp, getString(C5419R.string.settings), PendingIntent.getActivity(this, 1010, new Intent("android.intent.action.VIEW", IntentUtils.RouteBuilders.Uris.INSTANCE.getSelectSettingsVoice()).setPackage(getPackageName()), PendingIntentExtensions.immutablePendingIntentFlag(134217728))).build();
        Intrinsics3.checkNotNullExpressionValue(notificationBuild, "NotificationCompat.Build…       )\n        .build()");
        return notificationBuild;
    }

    @Override // com.discord.overlay.OverlayService
    public OverlayBubbleWrap createOverlayBubble(Intent intent) {
        Object next;
        Object next2;
        Intrinsics3.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action == null) {
            return null;
        }
        int iHashCode = action.hashCode();
        if (iHashCode == -753952221) {
            if (!action.equals(ACTION_VOICE)) {
                return null;
            }
            Iterator<T> it = getOverlayManager().activeBubbles.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((OverlayBubbleWrap) next) instanceof OverlayVoiceBubble2) {
                    break;
                }
            }
            if (((OverlayBubbleWrap) next) != null) {
                return null;
            }
            return createVoiceBubble();
        }
        if (iHashCode != -440170727) {
            if (iHashCode == 557534510 && action.equals(ACTION_SELECTOR)) {
                return createVoiceSelector();
            }
            return null;
        }
        if (!action.equals(ACTION_OPEN)) {
            return null;
        }
        Iterator<T> it2 = getOverlayManager().activeBubbles.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
            if (((OverlayBubbleWrap) next2) instanceof OverlayVoiceBubble2) {
                break;
            }
        }
        OverlayBubbleWrap overlayBubbleWrap = (OverlayBubbleWrap) next2;
        if (overlayBubbleWrap == null) {
            return createVoiceBubble();
        }
        overlayBubbleWrap.performClick();
        return null;
    }

    @Override // com.discord.overlay.OverlayService, android.app.Service
    public void onCreate() {
        super.onCreate();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Application application = getApplication();
        Intrinsics3.checkNotNullExpressionValue(application, "application");
        companion.initialize(application);
        OverlayManager overlayManager = getOverlayManager();
        C70341 c70341 = C70341.INSTANCE;
        Objects.requireNonNull(overlayManager);
        Intrinsics3.checkNotNullParameter(c70341, "<set-?>");
        overlayManager.onOverlayBubbleAdded = c70341;
        OverlayManager overlayManager2 = getOverlayManager();
        C70352 c70352 = new C70352();
        Objects.requireNonNull(overlayManager2);
        Intrinsics3.checkNotNullParameter(c70352, "<set-?>");
        overlayManager2.onOverlayBubbleRemoved = c70352;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        AppLog appLog = AppLog.f14950g;
        StringBuilder sbM833U = outline.m833U("onStartCommand: ");
        sbM833U.append(intent != null ? intent.getAction() : null);
        Logger.v$default(appLog, LOG_TAG, sbM833U.toString(), null, 4, null);
        if (Intrinsics3.areEqual(intent != null ? intent.getAction() : null, ACTION_CLOSE) || !DeviceUtils.INSTANCE.canDrawOverlays(this)) {
            stopForeground(true);
            stopSelf(startId);
            return 2;
        }
        Observable<Boolean> observableM11100Z = StoreStream.INSTANCE.isInitializedObservable().m11118y(C70361.INSTANCE).m11100Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableM11100Z, "StoreStream.isInitialize….takeFirst { it == true }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(observableM11100Z), DiscordOverlayService.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C70372(startId, intent), 62, (Object) null);
        return 3;
    }
}
